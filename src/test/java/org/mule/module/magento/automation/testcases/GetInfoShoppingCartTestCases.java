package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.ShoppingCartCustomerEntity;
import com.magento.api.ShoppingCartInfoEntity;

public class GetInfoShoppingCartTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (Map<String, Object>) context.getBean("getInfoShoppingCart");
			
			String storeId = testObjects.get("storeId").toString();
			
			int quoteId = createShoppingCart(storeId);
			testObjects.put("quoteId", quoteId);
			
			ShoppingCartCustomerEntity customer = (ShoppingCartCustomerEntity) testObjects.get("customer");
			setShoppingCartCustomer(quoteId, customer);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testGetInfoShoppingCart() {
		try {
			int quoteId = (Integer) testObjects.get("quoteId");
			
			MessageProcessor flow = lookupFlowConstruct("get-info-shopping-cart");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			ShoppingCartInfoEntity result = (ShoppingCartInfoEntity) response.getMessage().getPayload();
			assertNotNull(result);
			assertTrue(quoteId == result.getQuote_id());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
		
}
