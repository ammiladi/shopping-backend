package com.sky.shopping.model.promotion;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * TODO: add composite condition.
 * Exemple condition = condition and condition,  
 * condition = condition  or condition
 */

@Entity
@Table(name = "CONDITION")
public class Condition  implements ObjectMetier{
	
	 
	private static final long serialVersionUID = -1635037015010743470L;

	@Id
	@Column(name="ID", length=8, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Version
	@Column(name="VERSION", length=8, nullable=false)
	private Long version;
	
	@Column(name="FIELD", length=8, nullable=false)
	private String field;
	
	@Column(name="VALUE", length=8, nullable=false)
	private String value;

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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void accept(ObjectMetierVisitor visitor) {
		visitor.visit(this);
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Condition other = (Condition) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	

}
