package direction.dto;

import java.util.List;


import javax.persistence.ElementCollection;
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
public class Passport{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int passportId;
	String countryOfOrigin;
	
	@ElementCollection
	List<String> visas;
	
	@OneToOne
	@JoinColumn(name="personId")
	Person person;
	
	public Passport(String countryOfOrigin, List<String> visas, Person person) {
		this.countryOfOrigin = countryOfOrigin;
		this.visas = visas;
		this.person = person;
	}
}