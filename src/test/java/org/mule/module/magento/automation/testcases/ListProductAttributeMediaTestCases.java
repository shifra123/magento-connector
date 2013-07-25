package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CatalogProductImageEntity;

public class ListProductAttributeMediaTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("listProductAttributeMedia");

			MessageProcessor createProductFlow = lookupFlowConstruct("create-product");
			MuleEvent res = createProductFlow.process(getTestEvent(testObjects));
			Integer productId = (Integer) res.getMessage().getPayload();
			testObjects.put("productId", productId);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@SuppressWarnings("unchecked")
	@Category({RegressionTests.class })
	@Test
	public void testListProductAttributeMedia() {
		try {
			MessageProcessor listProductLinkFlow = lookupFlowConstruct("list-product-attribute-media");
			MuleEvent res = listProductLinkFlow.process(getTestEvent(testObjects));
			List<CatalogProductImageEntity> catalogProductImageEntities = (List<CatalogProductImageEntity>) res.getMessage().getPayload();
			
			assertNotNull(catalogProductImageEntities);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@After
	public void tearDown() {
		try {
			int productId = (Integer) testObjects.get("productId");
			deleteProductById(productId);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
