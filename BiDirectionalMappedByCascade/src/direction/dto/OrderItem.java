package direction.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int itemId;
	String itemName;
	float price;
	
	@ManyToOne
	@JoinColumn(name="item_orderID")
	Order order;
	
	public OrderItem(String itemName, float price) {
		this.itemName = itemName;
		this.price = price;
	}
}
