package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CatalogCategoryEntityCreate;
import com.magento.api.CatalogCategoryInfo;

public class MoveCategoryTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("moveCategory");
			
			int beforeParentId = (Integer) testObjects.get("beforeParentId");
			
			CatalogCategoryEntityCreate category = (CatalogCategoryEntityCreate) testObjects.get("category");
			int categoryId = createCategory(beforeParentId, category);
			
			testObjects.put("categoryId", categoryId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testMoveCategory() {
		try {
			int categoryId = (Integer) testObjects.get("categoryId");
			int afterParentId = (Integer) testObjects.get("afterParentId");
			
			testObjects.put("parentId", afterParentId);
			
			MessageProcessor flow = lookupFlowConstruct("move-category");
			MuleEvent response = flow.process(getTestEvent(testObjects));

			CatalogCategoryInfo movedCategory = getCategory(categoryId);
			assertTrue(movedCategory.getCategory_id().equals(Integer.toString(categoryId)));
			assertTrue(movedCategory.getParent_id().equals(Integer.toString(afterParentId)));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@After
	public void tearDown() {
		try {
			int categoryId = (Integer) testObjects.get("categoryId");
			deleteCategory(categoryId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
