/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogCategoryEntityCreate;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DeleteCategoryTestCases extends MagentoTestParent {


    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("deleteCategory");

        int parentId = getTestRunMessageValue("parentId");
        CatalogCategoryEntityCreate category = getTestRunMessageValue("catalogCategoryEntityRef");
        Integer categoryId = createCategory(parentId, category);
        upsertOnTestRunMessage("categoryId", categoryId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testDeleteCategory() {
        try {
            Boolean response = runFlowAndGetPayload("delete-category");
            assertTrue(response);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
