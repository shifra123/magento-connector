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

import com.magento.api.CatalogProductAttributeMediaTypeEntity;

public class ListProductAttributeMediaTypesTestCases extends MagentoTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("listProductAttributeMediaTypes");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@SuppressWarnings("unchecked")
	@Category({ SmokeTests.class, RegressionTests.class })
	@Test
	public void testListProductAttributeMediaTypes() {
		try {
			MessageProcessor listProductLinkFlow = lookupFlowConstruct("list-product-attribute-media-types");
			MuleEvent res = listProductLinkFlow.process(getTestEvent(testObjects));
			List<CatalogProductAttributeMediaTypeEntity> catalogProductAttributeMediaTypes = (List<CatalogProductAttributeMediaTypeEntity>) res.getMessage().getPayload();
			
			assertNotNull(catalogProductAttributeMediaTypes);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
