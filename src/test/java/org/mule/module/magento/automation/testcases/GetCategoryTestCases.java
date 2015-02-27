/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogCategoryEntityCreate;
import com.magento.api.CatalogCategoryInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetCategoryTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getCategory");
        int parentId = getTestRunMessageValue("parentId");
        CatalogCategoryEntityCreate category = getTestRunMessageValue("catalogCategoryEntityRef");
        int categoryId = createCategory(parentId, category);

        initializeTestRunMessage("getCategory");
        upsertOnTestRunMessage("categoryId", categoryId);
    }


    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testGetCategory() {
        try {

            int categoryId = getTestRunMessageValue("categoryId");
            int parentId = getTestRunMessageValue("parentId");
            CatalogCategoryInfo category = runFlowAndGetPayload("get-category");
            assertTrue(category.getParent_id().equals(Integer.toString(parentId)));
            assertTrue(category.getCategory_id().equals(Integer.toString(categoryId)));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int categoryId = getTestRunMessageValue("categoryId");
        deleteCategory(categoryId);
    }
}
