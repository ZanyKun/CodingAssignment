package direction.uni;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import direction.dao.DbUtil;
import direction.dto.Author;
import direction.dto.Book;
import direction.dto.Order;
import direction.dto.OrderItem;
import direction.dto.Passport;
import direction.dto.Person;


public class DirectionalMappings {
	static Logger logger = Logger.getLogger(DirectionalMappings.class);
	public static void main(String... args) {
		
		//Bidirectional OneToOne Mapping
			Session s = DbUtil.openSession();
			s.beginTransaction();
			Person p1 = new Person("kevin", 24, "M");
			Person p2 = new Person("lananh", 24, "F");
			
			s.save(p1);
			s.save(p2);
			
			Passport v1 = new Passport("Honduras", Arrays.asList("Japan", "United States"), p1);
			Passport v2 = new Passport("Vietnam", Arrays.asList("United States"), p1);
			
			s.save(v1);
			s.save(v2);
			
			p1.setPassport(v1);
			p2.setPassport(v2);
			
			s.getTransaction().commit();
			
			s.close();
		
		//Bidirectional ManyToOne Mapping
			Session s1 = DbUtil.openSession();
			s1.beginTransaction();
			
			Order o1 = new Order(2);
			Order o2 = new Order(3);
			
			s1.save(o1);
			s1.save(o2);
			
			OrderItem i1 = new OrderItem("Clorox", 10.00f);
			OrderItem i2 = new OrderItem("Kleenex", 5.00f);
			OrderItem i3 = new OrderItem("Chocolate", 1.50f);
			OrderItem i4 = new OrderItem("iPhone", 1000.00f);
			OrderItem i5 = new OrderItem("Water Bottle", 12.00f);

			i1.setOrder(o1);
			i2.setOrder(o1);
			i3.setOrder(o2);
			i4.setOrder(o2);
			i5.setOrder(o2);
			
			List<OrderItem> list1 = Arrays.asList(i1, i2);
			List<OrderItem> list2 = Arrays.asList(i3, i4, i5);
			o1.setItemList(list1);
			o2.setItemList(list2);
			
			s1.save(i1);
			s1.save(i2);
			s1.save(i3);
			s1.save(i4);
			s1.save(i5);
			
			s1.getTransaction().commit();
			s1.close();
			
		//Bidirectional ManyToMany Mapping
			Session s2 = DbUtil.openSession();
			s2.beginTransaction();
			
			Set<Author> howToProgramWithJavaAuthor = new HashSet<Author>();  
	        Set<Author> howToProgramWithJava2ndAuthors = new HashSet<Author>();  
	        Set<Author> howToPlayGuitarAuthor = new HashSet<Author>();  
	          
	        Author author = new Author();  
	        author.setAuthorName("Trevor Page");  
	        howToProgramWithJavaAuthor.add(author);  
	          
	        Author author2 = new Author();  
	        author2.setAuthorName("John Doe");  
	          
	        howToProgramWithJava2ndAuthors.add(author);  
	        howToProgramWithJava2ndAuthors.add(author2);  
	        howToPlayGuitarAuthor.add(author2);  
	          
	        Book book = new Book();  
	        book.setBookName("How to Program with Java");  
	          
	        Book book2 = new Book();  
	        book2.setBookName("How to Program with Java 2nd Edition");  
	          
	        Book book3 = new Book();  
	        book3.setBookName("How to Play Guitar");  
	          
	        book.setAuthors(howToProgramWithJavaAuthor);  
	        book2.setAuthors(howToProgramWithJava2ndAuthors);  
	        book3.setAuthors(howToPlayGuitarAuthor);
	        
	        List<Book> books1 = Arrays.asList(book);
	        List<Book> books2 = Arrays.asList(book2, book3);
	        
	        author.setBooks(books1);
	        author2.setBooks(books2);
	        
	        s2.save(author);
	        s2.save(author2);
	        
	        s2.save(book);  
	        s2.save(book2);  
	        s2.save(book3);  
			
			s2.getTransaction().commit();
			
			
	}
}