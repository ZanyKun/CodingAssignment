package direction.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "fk_passportid")
	int passportId;
	String countryOfOrigin;
	
	@ElementCollection
	List<String> visas;
	
	@OneToOne
	Person person;
	
	public Passport(String countryOfOrigin, List<String> visas) {
		this.countryOfOrigin = countryOfOrigin;
		this.visas = visas;
	}
}