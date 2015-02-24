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

public class AddProductLinkTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("addProductLink");

        Integer productId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("productId", productId);

        // change the sku for the second product
        upsertOnTestRunMessage("sku", getTestRunMessageValue("sku") + "abc");
        Integer linkedProductId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("linkedProductIdOrSku", linkedProductId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    // This test fails because according to http://www.magentocommerce.com/api/soap/catalog/catalogProductLink/catalog_product_link.assign.html
    // I'm expecting a boolean result but I get a HashMap
    public void testAddProductLink() {
        try {
            String linkType = "related";
            upsertOnTestRunMessage("type", linkType);
            Boolean addProductLinkFlow = runFlowAndGetPayload("add-product-link");

            assertTrue("Assert that the return type of the operation should be boolean (true)", addProductLinkFlow);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() {
        try {
            int productId = getTestRunMessageValue("productId");
            int linkedProductId = getTestRunMessageValue("linkedProductIdOrSku");
            deleteProductById(productId);
            deleteProductById(linkedProductId);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
