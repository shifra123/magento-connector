package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.ShoppingCartCustomerAddressEntity;

public class SetShoppingCartCustomerAddressesTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("setShoppingCartCustomerAddresses");

			int quoteId = createShoppingCart();
			testObjects.put("quoteId", quoteId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testSetShoppingCartCustomerAddresses() {
		try {
			MessageProcessor flow = lookupFlowConstruct("set-shopping-cart-customer-addresses");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			boolean result = (Boolean) response.getMessage().getPayload();			
			assertTrue(result);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
		
}
