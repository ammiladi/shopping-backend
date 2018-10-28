package com.sky.shopping.model;

import com.sky.shopping.model.order.Order;
import com.sky.shopping.model.order.OrderItem;
import com.sky.shopping.model.product.Product;
import com.sky.shopping.model.promotion.Condition;
import com.sky.shopping.model.promotion.Formula;
import com.sky.shopping.model.promotion.NumberFormula;
import com.sky.shopping.model.promotion.PourcentFormula;
import com.sky.shopping.model.promotion.Promotion;

/**
 * 
 * @author miladi
 * 
 * ObjectMetierVisitor interface
 *
 */
public interface ObjectMetierVisitor {

	void visit(Order order);
	void visit(OrderItem orderItem);
	void visit(Product product);
	void visit(Condition condition);
	void visit(PourcentFormula formula);
	void visit(NumberFormula formula);
	void visit(Promotion promotion);
	
	
	

}
