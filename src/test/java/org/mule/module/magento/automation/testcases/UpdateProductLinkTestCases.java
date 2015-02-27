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

public class UpdateProductLinkTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("deleteProductLink");

        Integer productId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("productId", productId);

        // change the sku for the second product
        upsertOnTestRunMessage("sku", ((String) getTestRunMessageValue("sku")) + "abc");
        Integer linkedProductId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("linkedProductIdOrSku", linkedProductId);

        String linkType = "related";
        upsertOnTestRunMessage("type", linkType);
        runFlowAndGetPayload("add-product-link");
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateProductLink() {
        try {
            upsertOnTestRunMessage("qty", 5);
            Boolean response = runFlowAndGetPayload("update-product-link");
            assertTrue(response);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int productId = getTestRunMessageValue("productId");
        int linkedProductId = getTestRunMessageValue("linkedProductIdOrSku");
        deleteProductById(productId);
        deleteProductById(linkedProductId);
    }

}
