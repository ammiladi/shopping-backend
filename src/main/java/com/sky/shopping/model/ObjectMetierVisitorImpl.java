package com.sky.shopping.model;

import com.sky.shopping.model.order.Order;
import com.sky.shopping.model.order.OrderItem;
import com.sky.shopping.model.product.Product;
import com.sky.shopping.model.promotion.Condition;
import com.sky.shopping.model.promotion.NumberFormula;
import com.sky.shopping.model.promotion.PourcentFormula;
import com.sky.shopping.model.promotion.Promotion;
/**
 * 
 * @author miladi
 * 
 * Default implementation of the ObjectMetierVisitor
 *
 */
public class ObjectMetierVisitorImpl implements ObjectMetierVisitor{

	@Override
	public void visit(Order order) {
		
		
	}

	@Override
	public void visit(OrderItem orderItem) {
		
	}

	@Override
	public void visit(Product product) {
	
	}

	@Override
	public void visit(Condition condition) {
	
	}

	@Override
	public void visit(PourcentFormula formula) {
	
	}

	@Override
	public void visit(NumberFormula formula) {
		
	}

	@Override
	public void visit(Promotion promotion) {
		
	}

}
