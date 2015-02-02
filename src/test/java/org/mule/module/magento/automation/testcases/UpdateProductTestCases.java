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

public class UpdateProductTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateProduct");
        Integer productId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("productId", productId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateProduct() {
        try {
            Boolean result = runFlowAndGetPayload("update-product");
            assertTrue("Assert that the update was successful", result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int productId = getTestRunMessageValue("productId");
        deleteProductById(productId);
    }

}
