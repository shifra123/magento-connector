package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.AssociativeEntity;
import com.magento.api.ShoppingCartPaymentMethodResponseEntityArray;

public class ListShoppingCartPaymentMethodsTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = new HashMap<String, Object>(); 

			int quoteId = createShoppingCart();
			testObjects.put("quoteId", quoteId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListShoppingCartPaymentMethodsTestCases() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-shopping-cart-payment-methods");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			ShoppingCartPaymentMethodResponseEntityArray cartPayments = (ShoppingCartPaymentMethodResponseEntityArray) response.getMessage().getPayload();
			assertNotNull(cartPayments);
			System.out.println(cartPayments.getCode());
			System.out.println(cartPayments.getTitle());
			for (AssociativeEntity entity : cartPayments.getCc_types()) {
				System.out.println(entity.getKey() + " : " + entity.getValue());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@After
	public void tearDown() {
		try {
			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
