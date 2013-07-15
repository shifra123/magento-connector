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

public class AddCategoryProductTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context
					.getBean("addCategoryProduct");

			MessageProcessor createCategoryFlow = lookupFlowConstruct("create-category");
			MuleEvent res = createCategoryFlow
					.process(getTestEvent(testObjects));
			Integer categoryId = (Integer) res.getMessage().getPayload();
			testObjects.put("categoryId", categoryId);

			MessageProcessor createProductFlow = lookupFlowConstruct("create-product");
			MuleEvent res2 = createProductFlow
					.process(getTestEvent(testObjects));
			Integer productId = (Integer) res2.getMessage().getPayload();
			testObjects.put("productId", productId);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@SuppressWarnings("unchecked")
	@Category({ SmokeTests.class, RegressionTests.class })
	@Test
	public void testDeleteCategoryProduct() {
		try {
			MessageProcessor listFlow = lookupFlowConstruct("list-category-products");
			MuleEvent listResponse = listFlow
					.process(getTestEvent(testObjects));
			assertEquals(
					"There should be 0 products in category before adding the product in the category",
					0, ((List<CatalogProductEntity>) listResponse.getMessage()
							.getPayload()).size());

			MessageProcessor flow = lookupFlowConstruct("add-category-product");
			flow.process(getTestEvent(testObjects));

			listResponse = listFlow.process(getTestEvent(testObjects));
			assertEquals(
					"There should be 1 product in category after adding the product in the category",
					1, ((List<CatalogProductEntity>) listResponse.getMessage()
							.getPayload()).size());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@After
	public void tearDown() {
		try {
			int productId = (Integer) testObjects.get("productId");
			int categoryId = (Integer) testObjects.get("categoryId");
			deleteProductById(productId);
			deleteCategory(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
