package com.sky.shopping.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sky.shopping.model.ObjectMetierVisitor;
import com.sky.shopping.model.ObjectMetierVisitorImpl;
import com.sky.shopping.model.order.Order;
import com.sky.shopping.model.order.OrderItem;
import com.sky.shopping.model.product.ProductTypeEnum;
import com.sky.shopping.model.promotion.Condition;
import com.sky.shopping.model.promotion.NumberFormula;
import com.sky.shopping.model.promotion.PourcentFormula;
import com.sky.shopping.model.promotion.Promotion;

public class OrderServicesImpl implements OrdersService{

	@Override
	public Order applyPromotions(Order anOrder, List<Promotion> aListOfPromotion) {	
		for(OrderItem orderItem : anOrder.getListOfOrderItems()){
			//Compute price before promotion and init e the price after promotion
			orderItem.setPrice(new BigDecimal(orderItem.getQuantity()).multiply(orderItem.getProduct().getPrice()));
			orderItem.setPriceAfterPromotion(orderItem.getPrice());
			//Apply promotion on each item
			for(Promotion promotion : aListOfPromotion){
				applyPromotion(promotion, orderItem );
			}
		}
		return anOrder;
	}

	/**
	 * Apply promotion on an arder item
	 * @param promotion
	 * @param orderItem
	 */
	private void applyPromotion(Promotion promotion, OrderItem orderItem) {
		
		boolean isValidePromotion = false;
		Condition condition = promotion.getCondition();
		
		if("name".equals(condition.getField()) && //
				condition.getValue().equals(orderItem.getProduct().getName()))
				isValidePromotion = true;
		if("type".equals(condition.getField()) && //
				(ProductTypeEnum.valueOf(condition.getValue())).equals(orderItem.getProduct().getType())) isValidePromotion = true;
		
		// control start and the end dates of the promotion
		isValidePromotion = isValidePromotion &&//
				promotion.getStartDate().compareTo(new Date())<=0 &&//
				(promotion.getEndDate()==null || promotion.getEndDate().compareTo(new Date()) >=0);
		
		ObjectMetierVisitor visitor = new ObjectMetierVisitorImpl() {
			
			@Override
			public void visit(PourcentFormula formula) {
				BigDecimal coef = new BigDecimal("100").subtract(formula.getPourcent()).divide(new BigDecimal(100));
				orderItem.setPriceAfterPromotion(orderItem.getPrice().multiply(coef));
			}
			
			@Override
			public void visit(NumberFormula formula) {
				Integer mod = orderItem.getQuantity() % formula.getTotalItem();
				Integer div = (orderItem.getQuantity() - mod)/formula.getTotalItem();
				Integer effectiveQuantity = div*formula.getBaseItem()+mod;
				BigDecimal price = orderItem.getProduct().getPrice().multiply(new BigDecimal(effectiveQuantity));
				orderItem.setPriceAfterPromotion(price);
			}
			
	
		};
		
		if(isValidePromotion) promotion.getFormula().accept(visitor);
		
	}
	

}
