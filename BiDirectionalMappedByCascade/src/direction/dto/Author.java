package direction.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  
  
@Entity  
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author{
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private long authorId;
	@Column(name="author_name")
	private String authorName;
	
	@ManyToMany(mappedBy="authors")
	List<Book> books = new ArrayList<>();
}  