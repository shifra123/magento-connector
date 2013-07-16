package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.ShoppingCartCustomerAddressEntity;
import com.magento.api.ShoppingCartShippingMethodEntity;

public class ListShoppingCartShippingMethodsTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (Map<String, Object>) context.getBean("listShoppingCartShippingMethods");

			int quoteId = createShoppingCart();
			testObjects.put("quoteId", quoteId); 
			
			List<ShoppingCartCustomerAddressEntity> customerAddresses = (List<ShoppingCartCustomerAddressEntity>) testObjects.get("customerAddresses");
			setCustomerAddressesToShoppingCart(quoteId, customerAddresses);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListShoppingCartShippingMethods() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-shopping-cart-shipping-methods");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<ShoppingCartShippingMethodEntity> shippingMethods = (List<ShoppingCartShippingMethodEntity>) response.getMessage().getPayload();
			assertNotNull(shippingMethods);
			for (ShoppingCartShippingMethodEntity method : shippingMethods) {
				System.out.println(method.getMethod());
				System.out.println(method.getMethod_title());
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
