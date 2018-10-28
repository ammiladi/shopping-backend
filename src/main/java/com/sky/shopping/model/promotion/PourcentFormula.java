package com.sky.shopping.model.promotion;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sky.shopping.model.ObjectMetier;
import com.sky.shopping.model.ObjectMetierVisitor;


/**
 * 
 * @author miladi
 *
 * The pourcentage formula Bean. To describe formula like "30% discount of the price"
 * 
 */
@Entity
@Table(name = "POURCENTAGE_FORMULA")
public class PourcentFormula extends Formula implements ObjectMetier{
	
	
	 
	private static final long serialVersionUID = -7593357769051059571L;
	
	@Column(name="PERCENT", length=8, nullable=false)
	private BigDecimal pourcent ;

	public BigDecimal getPourcent() {
		return pourcent;
	}

	public void setPourcent(BigDecimal pourcent) {
		this.pourcent = pourcent;
	}

	@Override
	public void accept(ObjectMetierVisitor visitor) {
		visitor.visit(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pourcent == null) ? 0 : pourcent.hashCode());
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
		PourcentFormula other = (PourcentFormula) obj;
		if (pourcent == null) {
			if (other.pourcent != null)
				return false;
		} else if (!pourcent.equals(other.pourcent))
			return false;
		return true;
	}
	
	

}
