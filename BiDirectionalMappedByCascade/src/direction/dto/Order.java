package direction.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="OrderCascade")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	int itemCount;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	List<OrderItem> itemList;
	
	public Order(int itemCount) {
		this.itemCount = itemCount;
	}
	
}
