package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CatalogProductAttributeSetEntity;

public class ListProductAttributeSetsTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Category({RegressionTests.class })
	@Test
	public void testListProductAttributeSets() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-product-attribute-sets");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<CatalogProductAttributeSetEntity> catalogProductAttributeSetEntities = (List<CatalogProductAttributeSetEntity>) response
					.getMessage().getPayload();
			assertNotNull(catalogProductAttributeSetEntities);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
