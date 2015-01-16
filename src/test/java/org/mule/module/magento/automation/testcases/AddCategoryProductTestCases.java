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

public class AddCategoryProductTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("addCategoryProduct");

        Integer categoryId = runFlowAndGetPayload("create-category");
        upsertOnTestRunMessage("categoryId", categoryId);

        Integer productId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("productId", productId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testAddCategoryProduct() {
        try {
            Boolean result = runFlowAndGetPayload("add-category-product");
            assertTrue(result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testAddCategoryProduct_without_position() {
        try {
            Boolean result = runFlowAndGetPayload("add-category-product-without-position");
            assertTrue(result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() {
        try {
            int productId = getTestRunMessageValue("productId");
            int categoryId = getTestRunMessageValue("categoryId");
            deleteProductById(productId);
            deleteCategory(categoryId);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
