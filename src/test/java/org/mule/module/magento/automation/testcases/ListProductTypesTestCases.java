package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CatalogProductTypeEntity;

public class ListProductTypesTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Category({RegressionTests.class })
	@Test
	public void testListProductTypes() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-product-types");

			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<CatalogProductTypeEntity> catalogProductTypeEntities = (List<CatalogProductTypeEntity>) response.getMessage().getPayload();
			assertNotNull(catalogProductTypeEntities);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
