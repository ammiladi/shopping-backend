package com.sky.shopping.promotion;
 
import org.mockito.InjectMocks;
import com.sky.shopping.model.order.Order;
import com.sky.shopping.model.order.OrderItem;
import com.sky.shopping.model.product.Product;
import com.sky.shopping.model.product.ProductTypeEnum;
import com.sky.shopping.model.promotion.Condition;
import com.sky.shopping.model.promotion.NumberFormula;
import com.sky.shopping.model.promotion.PourcentFormula;
import com.sky.shopping.model.promotion.Promotion;
import com.sky.shopping.services.OrderServicesImpl;

 
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author miladi
 *
 *  OrdersServicesImpl Tests suites
 *  
 */
public class OrdersServicesImplTests {
	
	@InjectMocks
	private OrderServicesImpl ordersService;

	@Before
	public void setup() {
		initMocks(this);
		
		
	}

	@Test
	public void applyPromotionTest() {
		
		/**
		 * Given
		 */
		Product product1 = new Product();
		product1.setName("HeadPhones");
		product1.setType(ProductTypeEnum.AUDIO);
		product1.setPrice(new BigDecimal("150"));
		Product product2 = new Product();
		product2.setName("Speakers");
		product2.setType(ProductTypeEnum.AUDIO);
		product2.setPrice(new BigDecimal("85"));
		Product product3 = new Product();
		product3.setName("AAA Batteries");
		product3.setType(ProductTypeEnum.POWER);
		product3.setPrice(new BigDecimal("0.85"));
		Product product4 = new Product();
		product4.setName("Proteins Bars");
		product4.setType(ProductTypeEnum.FOOD);
		product4.setPrice(new BigDecimal("25"));	
		//
		Order order = new Order();	
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setProduct(product2);
		orderItem1.setQuantity(1);
		order.getListOfOrderItems().add(orderItem1);
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProduct(product3);
		orderItem2.setQuantity(5);
		order.getListOfOrderItems().add(orderItem2);
		OrderItem orderItem3 = new OrderItem();
		orderItem3.setProduct(product4);
		orderItem3.setQuantity(2);
		order.getListOfOrderItems().add(orderItem3);
		//
		Condition condition1  = new Condition();
		condition1.setField("type");
		condition1.setValue(ProductTypeEnum.AUDIO.name());
		Condition condition2  = new Condition();
		condition2.setField("name");
		condition2.setValue("AAA Batteries");
		PourcentFormula formula1 = new PourcentFormula();
		formula1.setPourcent(new BigDecimal("30"));
		NumberFormula formula2 = new NumberFormula();
		formula2.setBaseItem(2);
		formula2.setTotalItem(3);
		
		Promotion promotion1 = new Promotion();
		promotion1.setCondition(condition1);
		promotion1.setFormula(formula1);
		promotion1.setStartDate(new Date());
		promotion1.setEndDate(null);
		Promotion promotion2 = new Promotion();
		promotion2.setCondition(condition2);
		promotion2.setFormula(formula2);
		promotion2.setStartDate(new Date());
		promotion2.setEndDate(null);
		List<Promotion> listOfPromotions = new ArrayList<>();
		listOfPromotions.add(promotion1);
		listOfPromotions.add(promotion2);
		
		/**
		 * When
		 */
		order = ordersService.applyPromotions(order, listOfPromotions);
		 
		/**
		 * Then
		 */
		OrderItem expectedOrderItem1 = new OrderItem();
		expectedOrderItem1.setProduct(product2);
		expectedOrderItem1.setQuantity(1);
		expectedOrderItem1.setPrice(new BigDecimal("85")); 
		expectedOrderItem1.setPriceAfterPromotion(new BigDecimal("59.5"));
		OrderItem expectedOrderItem2 = new OrderItem();
		expectedOrderItem2.setProduct(product3);
		expectedOrderItem2.setQuantity(5);
		expectedOrderItem2.setPriceAfterPromotion(new BigDecimal("3.40"));
		expectedOrderItem2.setPrice(new BigDecimal("4.25"));
		OrderItem expectedOrderItem3 = new OrderItem();
		expectedOrderItem3.setProduct(product4);
		expectedOrderItem3.setQuantity(2);
		expectedOrderItem3.setPriceAfterPromotion(new BigDecimal("50"));
		expectedOrderItem3.setPrice(new BigDecimal("50"));
		assertThat(order.getListOfOrderItems(), hasItems(
				  expectedOrderItem1,
				  expectedOrderItem2,
				  expectedOrderItem3
	        ));
		
		System.out.println(order.toString());
		
	}

}
