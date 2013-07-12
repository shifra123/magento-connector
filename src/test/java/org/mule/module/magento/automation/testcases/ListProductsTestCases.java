package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CatalogProductEntity;

public class ListProductsTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("listProducts");
			MessageProcessor flow = lookupFlowConstruct("create-product");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			testObjects.put("productId", response.getMessage().getPayload());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testListProducts() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-products");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<CatalogProductEntity> products = (List<CatalogProductEntity>) response.getMessage().getPayload();
			assertEquals("There should be 1 product", 1, products.size());
			
			CatalogProductEntity product = products.get(0);
			assertEquals("Product sku should be " + testObjects.get("sku"), testObjects.get("sku"), product.getSku());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@After
	public void tearDown() {
		try {
			int productId = (Integer) testObjects.get("productId");
			deleteProductById(productId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
