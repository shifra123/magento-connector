/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogProductCreateEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UpdateStockItemTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateStockItem");

        String type = getTestRunMessageValue("type");
        String sku = getTestRunMessageValue("sku");
        int set = Integer.parseInt(getTestRunMessageValue("set").toString());

        CatalogProductCreateEntity productAttributes = getTestRunMessageValue("attributesRef");
        int productId = createProduct(type, set, sku, productAttributes);

        initializeTestRunMessage("updateStockItem");
        upsertOnTestRunMessage("productId", productId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateStockItem() {
        try {
            int productId = getTestRunMessageValue("productId");
            upsertOnTestRunMessage("productIdOrSku", productId);

            Integer result = runFlowAndGetPayload("update-stock-item");
            assertTrue(result == 1);
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
