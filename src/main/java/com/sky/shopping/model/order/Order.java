package com.sky.shopping.model.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.sky.shopping.model.ObjectMetier;
import com.sky.shopping.model.ObjectMetierVisitor;
 
/**
 * 
 * @author miladi
 *
 *
 *Descripte the content of the order. One order content many order items
 *
 *
 */
@Entity
@Table(name = "ORDER_DETAIL")
public class Order implements ObjectMetier{
	
	
	 
	private static final long serialVersionUID = 8267575648080318150L;

	@Id
	@Column(name="ID", length=8, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Version
	@Column(name="VERSION", length=8, nullable=false)
	private Long version;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private List<OrderItem> listOfOrderItems = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public List<OrderItem> getListOfOrderItems() {
		return listOfOrderItems;
	}

	public void setListOfOrderItems(List<OrderItem> listOfOrderItems) {
		this.listOfOrderItems = listOfOrderItems;
	}

	@Override
	public void accept(ObjectMetierVisitor visitor) {	
		visitor.visit(this);
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listOfOrderItems == null) ? 0 : listOfOrderItems.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (listOfOrderItems == null) {
			if (other.listOfOrderItems != null)
				return false;
		} else if (!listOfOrderItems.equals(other.listOfOrderItems))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String toString = "Order [ Name - Quantity - Price - Price after promotion \n";
		for(OrderItem orderItem : this.getListOfOrderItems()){
			toString= toString+ orderItem.getProduct().getName()+" - "+ orderItem.getQuantity() + " - " + orderItem.getPrice()+ " - " + orderItem.getPriceAfterPromotion()+ "\n";
		}
		toString = toString + "]";
		return toString;
	}

	
	
	
	
	
	
		

}
