package direction.dto;

import java.util.Set;  

import javax.persistence.CascadeType;  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.JoinColumn;  
import javax.persistence.JoinTable;  
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  
  
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book  {
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private long bookId;  
	@Column(name="book_name") 
	private String bookName;
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="author_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="author_id")) 
	private Set<Author> authors;   
}  