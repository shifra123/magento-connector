package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.ShoppingCartCustomerAddressEntity;

public class SetShoppingCartShippingMethodTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (Map<String, Object>) context.getBean("setShoppingCartShippingMethod"); 

			String storeId = testObjects.get("storeId").toString();
			int quoteId = createShoppingCart(storeId);
			testObjects.put("quoteId", quoteId);
			
			List<ShoppingCartCustomerAddressEntity> addresses = (List<ShoppingCartCustomerAddressEntity>) testObjects.get("customerAddresses");
			setCustomerAddressesToShoppingCart(quoteId, addresses);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testSetShoppingCartShippingMethodTestCases() {
		try {
			MessageProcessor flow = lookupFlowConstruct("set-shopping-cart-shipping-method");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			Boolean result = (Boolean) response.getMessage().getPayload();
			assertTrue(result);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
