package com.sky.shopping.model.product;

/**
 * 
 * @author miladi
 *
 * Product type Enumuration
 */
public enum ProductTypeEnum {
	
	
	
	AUDIO("AUDIO"),//
	POWER("POWER"),//
	FOOD("FOOD")//
	//ADD OTHER type
	;
	
	private String code;

	
	private ProductTypeEnum(String code) {
		this.code = code;
	}


	public String getCode() {
		return code;
	}

	
	
	

}
