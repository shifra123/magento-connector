/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogInventoryStockItemEntity;
import com.magento.api.CatalogProductCreateEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ListInventoryStockItemsTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listInventoryStockItems");

        List<HashMap<String, Object>> products = getTestRunMessageValue("products");
        List<Integer> productIds = new ArrayList<Integer>();

        // Iterate over all the defined products and insert them into Magento
        // Record the returned product IDs.
        for (HashMap<String, Object> product : products) {
            String productType = (String) product.get("type");
            int productSet = (Integer) product.get("set");
            String productSKU = (String) product.get("sku");
            CatalogProductCreateEntity attributes = (CatalogProductCreateEntity) product.get("attributesRef");
            int productId = createProduct(productType, productSet, productSKU, attributes);
            productIds.add(productId);
        }
        initializeTestRunMessage("listInventoryStockItems");
        upsertOnTestRunMessage("productIds", productIds);
    }

    @Category({RegressionTests.class})
    @Test
    public void testListInventoryStockItems() {
        try {
            List<Integer> productIds = getTestRunMessageValue("productIds");
            // Connector expects a list of Strings instead of list of integers, so reformat
            List<String> productIdsFormatted = MagentoTestHelper.getStringList(productIds);

            upsertOnTestRunMessage("productIdOrSkusRef", productIdsFormatted);

            // Get the inventory
            List<CatalogInventoryStockItemEntity> stockItems = runFlowAndGetPayload("list-inventory-stock-items");
            assertNotNull(stockItems);
            assertTrue(productIds.size() == stockItems.size());

            for (CatalogInventoryStockItemEntity stockItem : stockItems) {
                assertTrue(productIdsFormatted.contains(stockItem.getProduct_id()));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        // Delete the products
        List<Integer> productIds = getTestRunMessageValue("productIds");
        for (Integer productId : productIds) {
            deleteProductById(productId);
        }
    }

}
