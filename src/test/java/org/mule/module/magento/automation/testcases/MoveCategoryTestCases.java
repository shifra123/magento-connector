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

public class MoveCategoryTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("moveCategory");

        int beforeParentId = getTestRunMessageValue("beforeParentId");

        CatalogCategoryEntityCreate category = getTestRunMessageValue("category");
        int categoryId = createCategory(beforeParentId, category);

        initializeTestRunMessage("moveCategory");
        upsertOnTestRunMessage("categoryId", categoryId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testMoveCategory() {
        try {
            int categoryId = getTestRunMessageValue("categoryId");
            int afterParentId = getTestRunMessageValue("afterParentId");

            upsertOnTestRunMessage("parentId", afterParentId);

            CatalogCategoryInfo movedCategory = runFlowAndGetPayload("move-category");
            assertTrue(movedCategory.getCategory_id().equals(Integer.toString(categoryId)));
            assertTrue(movedCategory.getParent_id().equals(Integer.toString(afterParentId)));
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
