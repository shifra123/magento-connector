/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogProductCreateEntity;
import com.magento.api.ShoppingCartProductEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UpdateShoppingCartProductTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateShoppingCartProduct");
        List<HashMap<String, Object>> products = getTestRunMessageValue("products");
        String storeId = getTestRunMessageValue("storeId");
        int quoteId = createShoppingCart(storeId);


        List<Integer> productIds = new ArrayList<Integer>();
        List<ShoppingCartProductEntity> shoppingCartProductsBefore = new ArrayList<ShoppingCartProductEntity>();
        List<ShoppingCartProductEntity> shoppingCartProductsAfter = new ArrayList<ShoppingCartProductEntity>();

        for (HashMap<String, Object> product : products) {

            // Get the product data
            String productType = (String) product.get("type");
            int productSet = (Integer) product.get("set");
            String productSKU = (String) product.get("sku");
            CatalogProductCreateEntity attributes = (CatalogProductCreateEntity) product.get("attributesRef");

            // Create the product and get the product ID
            int productId = createProduct(productType, productSet, productSKU, attributes);

            // Get the quantity to place in the shopping cart (before)
            double qtyToPurchaseBefore = (Double) product.get("qtyToPurchaseBefore");
            // Get the quantity to place in the shopping cart (after)
            double qtyToPurchaseAfter = (Double) product.get("qtyToPurchaseAfter");

            // Create the shopping cart product entity (before)
            ShoppingCartProductEntity shoppingCartProductBefore = new ShoppingCartProductEntity();
            shoppingCartProductBefore.setProduct_id(productId + "");
            shoppingCartProductBefore.setQty(qtyToPurchaseBefore);
            shoppingCartProductsBefore.add(shoppingCartProductBefore);

            // Create the shopping cart product entity (after)
            ShoppingCartProductEntity shoppingCartProductAfter = new ShoppingCartProductEntity();
            shoppingCartProductAfter.setProduct_id(productId + "");
            shoppingCartProductAfter.setQty(qtyToPurchaseAfter);
            shoppingCartProductsAfter.add(shoppingCartProductAfter);

            productIds.add(productId);
        }

        addProductsToShoppingCart(quoteId, shoppingCartProductsBefore);

        initializeTestRunMessage("updateShoppingCartProduct");
        upsertOnTestRunMessage("quoteId", quoteId);
        upsertOnTestRunMessage("productIds", productIds);
        upsertOnTestRunMessage("shoppingCartProductsBefore", shoppingCartProductsBefore);
        upsertOnTestRunMessage("shoppingCartProductsAfter", shoppingCartProductsAfter);
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateShoppingCartProduct() {
        try {
            List<ShoppingCartProductEntity> shoppingCartProductsAfter = getTestRunMessageValue("shoppingCartProductsAfter");
            upsertOnTestRunMessage("productsRef", shoppingCartProductsAfter);

            Boolean result = runFlowAndGetPayload("update-shopping-cart-product");
            assertTrue(result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        List<Integer> productIds = getTestRunMessageValue("productIds");
        for (Integer productId : productIds) {
            deleteProductById(productId);
        }
    }
}
