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

import com.magento.api.DirectoryRegionEntity;

public class ListDirectoryRegionsTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("listDirectoryRegions");
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListDirectoryRegions() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-directory-regions");
			MuleEvent response = flow.process(getTestEvent(testObjects));
		
			List<DirectoryRegionEntity> regions = (List<DirectoryRegionEntity>) response.getMessage().getPayload();
			assertNotNull(regions);
			for (DirectoryRegionEntity region : regions) {
				assertNotNull(region);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
		
}
