package direction.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	int age;
	String gender;
	
	@OneToOne
	@JoinColumn(name = "fk_passportid")
	Passport passport;
	
	public Person(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}