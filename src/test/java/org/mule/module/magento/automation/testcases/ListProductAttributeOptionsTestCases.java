package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CatalogAttributeEntity;
import com.magento.api.CatalogAttributeOptionEntity;

public class ListProductAttributeOptionsTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context
					.getBean("listProductAttributeOptions");
			MessageProcessor listProductAttributesFlow = lookupFlowConstruct("list-product-attributes");
			MuleEvent event = listProductAttributesFlow.process(getTestEvent(testObjects));
			List<CatalogAttributeEntity> catalogAttributeEntities = (List<CatalogAttributeEntity>) event.getMessage().getPayload();
			testObjects.put("attributeId", catalogAttributeEntities.get(0).getAttribute_id());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@SuppressWarnings("unchecked")
	@Category({RegressionTests.class })
	@Test
	public void testListProductAttributes() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-product-attribute-options");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<CatalogAttributeOptionEntity> catalogAttributeOptionEntities = (List<CatalogAttributeOptionEntity>) response
					.getMessage().getPayload();
			assertNotNull(catalogAttributeOptionEntities);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
