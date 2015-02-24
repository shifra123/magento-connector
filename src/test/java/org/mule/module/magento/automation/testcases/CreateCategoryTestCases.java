/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CreateCategoryTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("createCategory");
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateCategory() {
        try {
            Integer categoryId = runFlowAndGetPayload("create-category");
            assertTrue(categoryId != null);

            upsertOnTestRunMessage("categoryId", categoryId);
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
