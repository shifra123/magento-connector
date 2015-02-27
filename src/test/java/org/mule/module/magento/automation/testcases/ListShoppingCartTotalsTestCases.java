/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogProductCreateEntity;
import com.magento.api.ShoppingCartCustomerAddressEntity;
import com.magento.api.ShoppingCartProductEntity;
import com.magento.api.ShoppingCartTotalsEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ListShoppingCartTotalsTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listShoppingCartTotals");

        List<HashMap<String, Object>> productDefinitions = getTestRunMessageValue("products");
        List<ShoppingCartCustomerAddressEntity> addresses = getTestRunMessageValue("addresses");
        String storeId = getTestRunMessageValue("storeId");

        double totalProductPrice = 0;
        HashMap<Integer, Double> productPrices = new HashMap<Integer, Double>();
        List<ShoppingCartProductEntity> shoppingCartEntities = new ArrayList<ShoppingCartProductEntity>();

        // Iterate over each product definition and insert
        for (HashMap<String, Object> productDefinition : productDefinitions) {
            String productType = (String) productDefinition.get("type");
            int productSet = (Integer) productDefinition.get("set");
            String productSKU = (String) productDefinition.get("sku");
            CatalogProductCreateEntity attributes = (CatalogProductCreateEntity) productDefinition.get("attributesRef");

            double price = Double.parseDouble(attributes.getPrice());

            // Get the product ID and the number of items we want to place in the shopping cart
            int productId = createProduct(productType, productSet, productSKU, attributes);
            double qtyToPurchase = (Double) productDefinition.get("qtyToPurchase");

            ShoppingCartProductEntity shoppingCartEntity = new ShoppingCartProductEntity();
            shoppingCartEntity.setProduct_id(productId + "");
            shoppingCartEntity.setQty(qtyToPurchase);

            shoppingCartEntities.add(shoppingCartEntity);

            double totalPrice = price * qtyToPurchase;
            totalProductPrice += totalPrice;
            productPrices.put(productId, totalPrice);
        }

        // Create the shopping cart
        int shoppingCartId = createShoppingCart(storeId);


        // Add the products to the shopping cart
        addProductsToShoppingCart(shoppingCartId, shoppingCartEntities);

        // Add the customer addresses

        setCustomerAddressesToShoppingCart(shoppingCartId, addresses);

        initializeTestRunMessage("listShoppingCartTotals");
        upsertOnTestRunMessage("productPrices", productPrices);
        upsertOnTestRunMessage("shoppingCartEntities", shoppingCartEntities);
        upsertOnTestRunMessage("totalPrice", totalProductPrice);
        upsertOnTestRunMessage("quoteId", shoppingCartId);
    }


    @Category({RegressionTests.class})
    @Test
    public void testListShoppingCartTotals() {
        try {
            double totalPrice = getTestRunMessageValue("totalPrice");

            List<ShoppingCartTotalsEntity> totals = runFlowAndGetPayload("list-shopping-cart-totals");
            for (ShoppingCartTotalsEntity total : totals) {
                if (total.getTitle().equals("Subtotal")) {
                    assertTrue(total.getAmount().doubleValue() == totalPrice);
                } else if (total.getTitle().equals("Grant Total")) {
                    assertTrue(total.getAmount().doubleValue() == totalPrice);
                }
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        HashMap<Integer, Double> productPrices = getTestRunMessageValue("productPrices");
        for (Map.Entry<Integer, Double> product : productPrices.entrySet()) {
            Integer productId = product.getKey();
            deleteProductById(productId);
        }
    }


}
