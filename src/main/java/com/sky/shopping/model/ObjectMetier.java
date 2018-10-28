package com.sky.shopping.model;

import java.io.Serializable;
/**
 * 
 * @author miladi
 * 
 * ObjectMetier interface
 *
 */
public interface ObjectMetier  extends Serializable{
	
	public Long getId();
	
	public Long getVersion();
	
	public void accept(ObjectMetierVisitor visitor);

}
