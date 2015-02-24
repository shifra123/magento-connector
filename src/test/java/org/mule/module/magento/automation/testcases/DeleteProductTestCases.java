/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class DeleteProductTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("deleteProduct");
        Integer productId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("productId", productId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testDeleteProductByProductId() {
        try {
            Integer deleteResult = runFlowAndGetPayload("delete-product-by-product-id");
            assertNotNull(deleteResult);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testDeleteProductByProductSku() {
        try {
            Integer deleteResult = runFlowAndGetPayload("delete-product-by-product-sku");
            assertNotNull(deleteResult);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}
