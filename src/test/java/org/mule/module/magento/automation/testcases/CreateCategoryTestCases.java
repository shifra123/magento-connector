/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreateCategoryTestCases extends MagentoTestCase {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		
	}
	
    @After
    public void tearDown() {
    	
    	try {
    		
    		String createdCategoryId = (String) testObjects.get("createdCategoryId");
    		
        	flow = lookupMessageProcessorConstruct("delete-category");
        	flow.process(getTestEvent(createdCategoryId));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
   	
    }
	
    @Category({SanityTests.class, SmokeTests.class})
	@Test
	public void testCreateCategoryAttributesFromMessage() {

		try {
			
			Map<String,Object> category = (HashMap<String,Object>) context.getBean("createCategoryAttributesFromMessage");

			flow = lookupMessageProcessorConstruct("create-category-attributes-from-message");
			response = flow.process(getTestEvent(category));
			
			String categoryId = response.getMessage().getPayload().toString();
			
			assertNotNull(categoryId);
			
			testObjects.put("createdCategoryId", categoryId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
        
	} 
	
    @Category({SanityTests.class})
	@Test
	public void testCreateCategoryAttributesAsList() {
		
		try {
			
			Map<String,Object> category = (HashMap<String,Object>) context.getBean("createCategoryAttributesAsList");
			
			flow = lookupMessageProcessorConstruct("create-category-attributes-as-list");
			response = flow.process(getTestEvent(category));
			
			String categoryId = response.getMessage().getPayload().toString();
			
			assertNotNull(categoryId);
			
			testObjects.put("createdCategoryId", categoryId);
     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
        
	} 
	
}
