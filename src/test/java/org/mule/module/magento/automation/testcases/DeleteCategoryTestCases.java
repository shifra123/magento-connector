/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DeleteCategoryTestCases extends MagentoTestCase {

    @Before
	public void setUp() {
		
		try {
	
			Map<String,Object> category = (HashMap<String,Object>) context.getBean("getCategoryAttributesFromMessage");
			
			flow = lookupMessageProcessorConstruct("create-category-attributes-from-message");
			response = flow.process(getTestEvent(category));
			
			String categoryId = response.getMessage().getPayload().toString();

			testObjects = new HashMap<String,Object>();
			testObjects.put("createdCategoryId", categoryId);
     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
        
	} 
	
	@Test
	public void testDeleteCategory() {
		
    	try {
    		
    		String categoryId = (String) testObjects.get("createdCategoryId");
    		
        	flow = lookupMessageProcessorConstruct("delete-category");
        	response = flow.process(getTestEvent(categoryId));
        	
        	assertTrue((Boolean) response.getMessage().getPayload());
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
   	
    }

}
