package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

public class SetShoppingCartCustomerTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("setShoppingCartCustomer");
		
			String storeId = testObjects.get("storeId").toString();
			int quoteId = createShoppingCart(storeId);
			testObjects.put("quoteId", quoteId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testSetShoppingCartCustomerTestCases() {
		try {
			MessageProcessor flow = lookupFlowConstruct("set-shopping-cart-customer");
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
