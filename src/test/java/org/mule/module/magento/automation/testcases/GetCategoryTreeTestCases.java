/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GetCategoryTreeTestCases extends MagentoTestCase {


    @Category({SanityTests.class})
	@Test
	public void testGetCategoryTreeRootCatalog() {

		try {
			
			flow = lookupMessageProcessorConstruct("get-category-tree");
			response = flow.process(getTestEvent("1"));
			
			Map<String, Object> categoryTree = (Map<String, Object>) response.getMessage().getPayload();
			
			assertEquals("Root Catalog", categoryTree.get("name").toString());
   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
        
	} 

}
