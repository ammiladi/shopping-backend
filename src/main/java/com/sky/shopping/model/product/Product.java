package com.sky.shopping.model.product;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.sky.shopping.model.ObjectMetier;
import com.sky.shopping.model.ObjectMetierVisitor;


/**
 * 
 * @author miladi
 * 
 * The product description ...
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements ObjectMetier{
	
 
	private static final long serialVersionUID = -2249439320802390637L;

	@Id
	@Column(name="ID", length=8, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Version
	@Column(name="VERSION", length=8, nullable=false)
	private Long version;
	
	@Column(name="NZME", length=20, nullable=false)
	private String name;
	
	@Column(name="TYPE", length=8, nullable=false)
	@Enumerated
	private ProductTypeEnum type;
	
	@Column(name="PRICE", length=20, nullable=false)
	private BigDecimal price;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductTypeEnum getType() {
		return type;
	}

	public void setType(ProductTypeEnum type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public void accept(ObjectMetierVisitor visitor) {
		visitor.visit(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
	
	

}
