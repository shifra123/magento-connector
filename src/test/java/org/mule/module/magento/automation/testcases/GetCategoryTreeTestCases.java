/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogCategoryEntity;
import com.magento.api.CatalogCategoryEntityCreate;
import com.magento.api.CatalogCategoryTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetCategoryTreeTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getCategoryTree");

        CatalogCategoryEntityCreate parentCategory = getTestRunMessageValue("parentCategory");
        CatalogCategoryEntityCreate childCategory = getTestRunMessageValue("childCategory");

        int parentId = getTestRunMessageValue("parentId");
        int parentCategoryId = createCategory(parentId, parentCategory);
        int childCategoryId = createCategory(parentCategoryId, childCategory);

        upsertOnTestRunMessage("parentCategoryId", parentCategoryId);
        upsertOnTestRunMessage("childCategoryId", childCategoryId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testGetCategoryTree() {
        try {
            int parentCategoryId = getTestRunMessageValue("parentCategoryId");
            int childCategoryId = getTestRunMessageValue("childCategoryId");

            CatalogCategoryTree tree = runFlowAndGetPayload("get-category-tree");
            assertTrue(tree.getCategory_id() == parentCategoryId);

            CatalogCategoryEntity[] children = tree.getChildren();
            CatalogCategoryEntity child = children[0]; // We only created 1 child.

            assertTrue(child.getCategory_id() == childCategoryId);
            assertTrue(child.getParent_id() == parentCategoryId);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        // Deleting the parent also deletes the child
        int parentCategoryId = getTestRunMessageValue("parentCategoryId");
        deleteCategory(parentCategoryId);
    }
}
