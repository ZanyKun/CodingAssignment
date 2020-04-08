package direction.dao;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Oracle8iDialect;

import direction.dto.Author;
import direction.dto.Book;
import direction.dto.Order;
import direction.dto.OrderItem;
import direction.dto.Passport;
import direction.dto.Person;



public class DbUtil {
	static SessionFactory sf= null;
	static {
        Configuration cfg = new Configuration();
        Properties p= new Properties();
        try {
			p.load(DbUtil.class.getResourceAsStream("/database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        cfg.addPackage("com.java.dto");
        cfg.setProperty("hibernate.connection.url", p.getProperty("url"));
        cfg.setProperty("hibernate.connection.driver_class", p.getProperty("driver"));
        cfg.setProperty("hibernate.connection.username", p.getProperty("user"));
        cfg.setProperty("hibernate.connection.password", p.getProperty("pwd"));
        cfg.setProperty(Environment.SHOW_SQL,"true");
        cfg.setProperty(Environment.HBM2DDL_AUTO, p.getProperty("hbm2ddl"));
        cfg.setProperty(Environment.GENERATE_STATISTICS, "true");
        cfg.addAnnotatedClass(Person.class);
        cfg.addAnnotatedClass(Passport.class);
        cfg.addAnnotatedClass(OrderItem.class);
        cfg.addAnnotatedClass(Order.class);
        cfg.addAnnotatedClass(Author.class);
        cfg.addAnnotatedClass(Book.class);
        cfg.setProperty(Environment.DIALECT, Oracle8iDialect.class.getName());
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        
        sf= cfg.buildSessionFactory(builder.build());
    }
	public static Session openSession() {
		return sf.openSession();
	}
}
