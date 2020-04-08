package direction.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="PersonCascade")
public class Person{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="personId")
	int id;
	String name;
	int age;
	String gender;
	
	@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
	Passport passport;
	
	public Person(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}