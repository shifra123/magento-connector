/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GetCategoryTestCases extends MagentoTestCase {

    @Before
	public void setUp() {
		
		try {
	
			Map<String,Object> category = (HashMap<String,Object>) context.getBean("categoryForGetCategoryOperations");
			
			flow = lookupMessageProcessor("create-category-attributes-from-message");
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
	
	@After
	public void tearDown() {
		
    	try {
    		
    		String categoryId = (String) testObjects.get("createdCategoryId");
    		
        	flow = lookupMessageProcessor("delete-category");
        	response = flow.process(getTestEvent(categoryId));
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
   	
    }
	
    @Category({SanityTests.class})
	@Test
	public void testGetCategoryDefaultValues() {
    	
    	Map<String,Object> createdCategory = (HashMap<String,Object>) context.getBean("categoryForGetCategoryOperations");
    	String categoryId = (String) testObjects.get("createdCategoryId");
    	
    	createdCategory.put("categoryId", categoryId);

		try {
			
			flow = lookupMessageProcessor("get-category-default-values");
			response = flow.process(getTestEvent(createdCategory));
			
			Map<String, Object> returnedCategory = (Map<String, Object>) response.getMessage().getPayload();
			
			assertNotNull(returnedCategory);
   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
        
	} 
	
    @Category({SanityTests.class})
	@Test
	public void testGetCategoryAttributesToRetrieveFromMessage() {
    	
    	Map<String,Object> createdCategory = (HashMap<String,Object>) context.getBean("categoryForGetCategoryOperations");
    	String categoryId = (String) testObjects.get("createdCategoryId");
    	
    	createdCategory.put("categoryId", categoryId);

		try {
			
			flow = lookupMessageProcessor("get-category-attributes-from-message");
			response = flow.process(getTestEvent(createdCategory));
			
			Map<String, Object> returnedCategory = (Map<String, Object>) response.getMessage().getPayload();
			
			assertNotNull(returnedCategory);
   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

    }	
        
	@Category({SanityTests.class})
	@Test
	public void testGetCategoryAttributesToRetrieveAsList() {
    	
    	Map<String,Object> createdCategory = (HashMap<String,Object>) context.getBean("categoryForGetCategoryOperations");
    	String categoryId = (String) testObjects.get("createdCategoryId");
    	
    	createdCategory.put("categoryId", categoryId);

		try {
			
			flow = lookupMessageProcessor("get-category-attributes-as-list");
			response = flow.process(getTestEvent(createdCategory));
			
			Map<String, Object> returnedCategory = (Map<String, Object>) response.getMessage().getPayload();
			
			assertNotNull(returnedCategory);
   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
    }

}
