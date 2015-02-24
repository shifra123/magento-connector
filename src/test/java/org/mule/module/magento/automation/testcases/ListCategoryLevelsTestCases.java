/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogCategoryEntityCreate;
import com.magento.api.CatalogCategoryEntityNoChildren;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Ignore
public class ListCategoryLevelsTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listCategoryLevels");
        int parentCategoryId = getTestRunMessageValue("parentCategoryId");
        List<Integer> categoryIds = new ArrayList<Integer>();
        List<CatalogCategoryEntityCreate> categories = getTestRunMessageValue("categories");
        for (CatalogCategoryEntityCreate category : categories) {
            int categoryId = createCategory(parentCategoryId, category);
            categoryIds.add(categoryId);
        }
        initializeTestRunMessage("listCategoryLevels");
        upsertOnTestRunMessage("categoryIds", categoryIds);

    }

    @Category({RegressionTests.class})
    @Test
    public void testListCategoryLevels_WithParentCategory() {
        try {
            List<Integer> categoryIds = getTestRunMessageValue("categoryIds");
            List<CatalogCategoryEntityNoChildren> categories =
                    runFlowAndGetPayload("list-category-levels-with-parent-category");
            assertEquals(categoryIds.size() + 1, categories.size());
            for (CatalogCategoryEntityNoChildren category : categories) {
                categoryIds.contains(category.getCategory_id());
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({RegressionTests.class})
    @Test
    @Ignore
    public void testListCategoryLevels() {
        try {
            List<CatalogCategoryEntityNoChildren> categories = runFlowAndGetPayload("list-category-levels");
            assertTrue(categories.size() == 1); // Only the default category should be there

            CatalogCategoryEntityNoChildren category = categories.get(0);
            assertTrue(category.getCategory_id() == DEFAULT_CATEGORY_ID); // The default category
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        List<Integer> categoryIds = getTestRunMessageValue("categoryIds");
        for (int categoryId : categoryIds) {
            deleteCategory(categoryId);
        }
    }
}
