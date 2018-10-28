package com.sky.shopping.model.promotion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sky.shopping.model.ObjectMetier;
import com.sky.shopping.model.ObjectMetierVisitor;


/**
 * 
 * @author miladi
 *
 * The number formula Bean. To describe formula like "3 for the price of 2"
 * 
 */
@Entity
@Table(name = "NUMBER_FORMULA")
public class NumberFormula extends Formula implements ObjectMetier{
 
	private static final long serialVersionUID = 492577324559618093L;

	@Column(name="TOTAL_ITEM", length=8, nullable=false)
	private Integer totalItem ;
	
	@Column(name="BASE_ITEM", length=8, nullable=false)
	private Integer baseItem ;

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public Integer getBaseItem() {
		return baseItem;
	}

	public void setBaseItem(Integer baseItem) {
		this.baseItem = baseItem;
	}
	
	@Override
	public void accept(ObjectMetierVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseItem == null) ? 0 : baseItem.hashCode());
		result = prime * result + ((totalItem == null) ? 0 : totalItem.hashCode());
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
		NumberFormula other = (NumberFormula) obj;
		if (baseItem == null) {
			if (other.baseItem != null)
				return false;
		} else if (!baseItem.equals(other.baseItem))
			return false;
		if (totalItem == null) {
			if (other.totalItem != null)
				return false;
		} else if (!totalItem.equals(other.totalItem))
			return false;
		return true;
	}
	
	
	
	
	
	

}
