package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

public class DeleteProductTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("deleteProduct");
			MessageProcessor createProductFlow = lookupFlowConstruct("create-product");
			MuleEvent response = createProductFlow.process(getTestEvent(testObjects));
			response.getMessage().getPayload();
			testObjects.put("productId", response.getMessage().getPayload());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testDeleteProductByProductId() {
		try {
			MessageProcessor flow = lookupFlowConstruct("delete-product-by-product-id");
			
			MuleEvent response = flow.process(getTestEvent(testObjects));
			Integer deleteResult = (Integer) response.getMessage().getPayload();
			assertNotNull(deleteResult);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testDeleteProductByProductSku() {
		try {
			MessageProcessor flow = lookupFlowConstruct("delete-product-by-product-sku");
			
			MuleEvent response = flow.process(getTestEvent(testObjects));
			Integer deleteResult = (Integer) response.getMessage().getPayload();
			assertNotNull(deleteResult);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
