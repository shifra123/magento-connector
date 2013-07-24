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

import com.magento.api.ShoppingCartLicenseEntity;

public class ListShoppingCartLicensesTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("listShoppingCartLicenses");
			
			String storeId = testObjects.get("storeId").toString();
			int quoteId = createShoppingCart(storeId);
			testObjects.put("quoteId", quoteId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListShoppingCartLicenses() {
		try {
			List<String> licenses = (List<String>) testObjects.get("licenses");
			
			MessageProcessor flow = lookupFlowConstruct("list-shopping-cart-licenses");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<ShoppingCartLicenseEntity> definedLicenses = (List<ShoppingCartLicenseEntity>) response.getMessage().getPayload();
			for (ShoppingCartLicenseEntity license : definedLicenses) {
				assertTrue(licenses.contains(license.getContent()));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		} 
	}
	
}
