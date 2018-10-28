package com.sky.shopping.services;

import java.util.List;

import com.sky.shopping.model.order.Order;
import com.sky.shopping.model.promotion.Promotion;

/**
 * 
 * @author miladi
 *
 * OrdersServices interface
 */
public interface OrdersService {
	
	/**
	 * Apply a list of promotion on an order
	 * @param anOrder
	 * @return
	 */
	public Order applyPromotions(Order anOrder, List<Promotion> aListOfPromotion) ;

}
