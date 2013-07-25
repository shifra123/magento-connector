package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

public class UpdateProductLinkTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("deleteProductLink");

			MessageProcessor createProductFlow = lookupFlowConstruct("create-product");
			MuleEvent res = createProductFlow.process(getTestEvent(testObjects));
			Integer productId = (Integer) res.getMessage().getPayload();
			testObjects.put("productId", productId);
			
			// change the sku for the second product
			testObjects.put("sku", ((String) testObjects.get("sku")) + "abc");
			res = createProductFlow.process(getTestEvent(testObjects));
			Integer linkedProductId = (Integer) res.getMessage().getPayload();
			testObjects.put("linkedProductIdOrSku", linkedProductId);
			
			String linkType = "related";
			testObjects.put("type", linkType);
			MessageProcessor addProductLinkFlow = lookupFlowConstruct("add-product-link");
			addProductLinkFlow.process(getTestEvent(testObjects));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Category({RegressionTests.class })
	@Test
	public void testUpdateProductLink() {
		try {
			testObjects.put("qty", 5);
			MessageProcessor updateProductLinkFlow = lookupFlowConstruct("update-product-link");
			MuleEvent res = updateProductLinkFlow.process(getTestEvent(testObjects));
			
			assertTrue((Boolean) res.getMessage().getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@After
	public void tearDown() {
		try {
			int productId = (Integer) testObjects.get("productId");
			int linkedProductId = (Integer) testObjects.get("linkedProductIdOrSku");
			deleteProductById(productId);
			deleteProductById(linkedProductId);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
