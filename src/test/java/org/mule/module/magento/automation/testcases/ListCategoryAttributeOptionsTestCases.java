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

public class ListCategoryAttributeOptionsTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = new HashMap<String, Object>();
			
			MessageProcessor flow = lookupFlowConstruct("list-category-attributes");
			MuleEvent response = flow.process(getTestEvent(null));
			
			List<CatalogAttributeEntity> attributes = (List<CatalogAttributeEntity>) response.getMessage().getPayload();
			testObjects.put("attributes", attributes);			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Category({RegressionTests.class})
	@Test
	public void testListCategoryAttributeOptions() {
		try {
			List<CatalogAttributeEntity> attributes = (List<CatalogAttributeEntity>) testObjects.get("attributes");
			
			for (CatalogAttributeEntity attribute : attributes) {				
				if (attribute.getAttribute_id() != null) {				
					testObjects.put("attributeId", attribute.getAttribute_id());
					MessageProcessor flow = lookupFlowConstruct("list-category-attribute-options");
					MuleEvent response = flow.process(getTestEvent(testObjects));
					
					List<CatalogAttributeOptionEntity> attributeOptions = (List<CatalogAttributeOptionEntity>) response.getMessage().getPayload();
					assertNotNull(attributeOptions);
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
		
}
