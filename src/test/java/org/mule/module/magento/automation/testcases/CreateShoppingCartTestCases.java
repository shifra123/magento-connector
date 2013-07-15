package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

public class CreateShoppingCartTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = new HashMap<String, Object>(); 
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testCreateShoppingCart() {
		try {
			MessageProcessor flow = lookupFlowConstruct("create-shopping-cart");
			MuleEvent response = flow.process(getTestEvent(testObjects));
		
			Integer shoppingCartId = (Integer) response.getMessage().getPayload();
			assertNotNull(shoppingCartId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
		
	
}
