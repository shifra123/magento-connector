package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

public class GetCatalogCurrentStoreViewTestCases extends MagentoTestParent {

	@Category({RegressionTests.class})
	@Test
	public void testGetCatalogCurrentStoreView() {
		try {
			MessageProcessor flow = lookupFlowConstruct("get-catalog-current-store-view");
			MuleEvent response = flow.process(getTestEvent(null));
			
			Integer defaultStoreId = (Integer) response.getMessage().getPayload();
			assertNotNull(defaultStoreId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
