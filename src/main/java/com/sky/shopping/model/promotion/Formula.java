package com.sky.shopping.model.promotion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import com.sky.shopping.model.ObjectMetier;
import com.sky.shopping.model.ObjectMetierVisitor;

@Entity
@Table(name = "FORMULA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Formula implements ObjectMetier {
	
	 
	private static final long serialVersionUID = 222618766295478759L;

	@Id
	@Column(name="ID", length=8, nullable=false)
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	@Version
	@Column(name="VERSION", length=8, nullable=false)
	private Long version;

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

	 
	
	


}
