package com.sky.shopping.model.order;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.sky.shopping.model.ObjectMetier;
import com.sky.shopping.model.ObjectMetierVisitor;
import com.sky.shopping.model.product.Product;


/**
 * 
 * @author miladi
 * 
 * Descripte details of the order by product item
 *
 */
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements ObjectMetier {
	
	 
	private static final long serialVersionUID = 3281424687874145778L;

	@Id
	@Column(name="ID", length=8, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Version
	@Column(name="VERSION", length=8, nullable=false)
	private Long version;
	
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name="ID_ORDER", nullable=false)
	private Order order;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;
	
	@Column(name="QUANTITY", length=20, nullable=false)
	private Integer quantity;
	
	@Column(name="PRICE", length=20, nullable=false)
	private BigDecimal price;
	
	@Column(name="PRICE_AFTER_PROMITION", length=20, nullable=false)
	private BigDecimal priceAfterPromotion;

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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceAfterPromotion() {
		return priceAfterPromotion;
	}

	public void setPriceAfterPromotion(BigDecimal priceAfterPromotion) {
		this.priceAfterPromotion = priceAfterPromotion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((priceAfterPromotion == null) ? 0 : priceAfterPromotion.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceAfterPromotion == null) {
			if (other.priceAfterPromotion != null)
				return false;
		} else if (!priceAfterPromotion.equals(other.priceAfterPromotion))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public void accept(ObjectMetierVisitor visitor) {
		visitor.visit(this);
	}
	
	
	
	
	
	
	
	
		

}
