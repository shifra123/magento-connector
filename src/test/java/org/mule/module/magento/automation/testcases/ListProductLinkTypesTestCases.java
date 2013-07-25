package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

public class ListProductLinkTypesTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Category({RegressionTests.class })
	@Test
	public void testListProductLinkTypes() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-product-link-types");

			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<String> productLinkTypes = (List<String>) response.getMessage().getPayload();
			assertNotNull(productLinkTypes);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
