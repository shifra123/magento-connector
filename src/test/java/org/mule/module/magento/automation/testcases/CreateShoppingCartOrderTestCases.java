/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CreateShoppingCartOrderTestCases extends MagentoTestParent {

    List<Integer> productIds;

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("createShoppingCartOrder");
        List<HashMap<String, Object>> products = getTestRunMessageValue("products");

        String storeId = getTestRunMessageValue("storeId");

        // Create the shopping cart
        int quoteId = createShoppingCart(storeId);


        // Create the products and add to shopping cart

        List<ShoppingCartProductEntity> shoppingCartProducts = new ArrayList<ShoppingCartProductEntity>();
        productIds = new ArrayList<Integer>();

        for (HashMap<String, Object> product : products) {
            // Get the product data
            String productType = (String) product.get("type");
            int productSet = (Integer) product.get("set");
            String productSKU = (String) product.get("sku");
            CatalogProductCreateEntity attributes = (CatalogProductCreateEntity) product.get("attributesRef");

            // Create the product and get the product ID
            int productId = createProduct(productType, productSet, productSKU, attributes);

            // Get the quantity to place in the shopping cart
            double qtyToPurchase = (Double) product.get("qtyToPurchase");

            // Create the shopping cart product entity
            ShoppingCartProductEntity shoppingCartProduct = new ShoppingCartProductEntity();
            shoppingCartProduct.setProduct_id(productId + "");
            shoppingCartProduct.setQty(qtyToPurchase);

            shoppingCartProducts.add(shoppingCartProduct);
            productIds.add(productId);
        }

        // Add the products to the shopping cart
        addProductsToShoppingCart(quoteId, shoppingCartProducts);


        // Create the shopping cart customer
        ShoppingCartCustomerEntity customer = getTestRunMessageValue("customer");
        setShoppingCartCustomer(quoteId, customer);

        // Set the customer addresses to the shopping cart
        List<ShoppingCartCustomerAddressEntity> customerAddresses = getTestRunMessageValue("customerAddresses");
        setCustomerAddressesToShoppingCart(quoteId, customerAddresses);

        // Set the shipping method
        String shippingMethod = getTestRunMessageValue("shippingMethod");
        setShoppingCartShippingMethod(quoteId, shippingMethod);

        // Set the payment method
        ShoppingCartPaymentMethodEntity paymentMethod = getTestRunMessageValue("paymentMethod");
        setShoppingCartPaymentMethod(quoteId, paymentMethod);

        initializeTestRunMessage("createShoppingCartOrder");
        upsertOnTestRunMessage("quoteId", quoteId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateShoppingCartOrder() {
        try {
            // Create the order
            String orderId = runFlowAndGetPayload("create-shopping-cart-order");
            assertNotNull(orderId);

            // Try parsing the order number as an integer
            // If no exception was thrown, then the result is correct
            Integer.parseInt(orderId);

            upsertOnTestRunMessage("orderId", orderId);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        for (Integer productId : productIds) {
            deleteProductById(productId);
        }

        clearSalesTables();
    }

}
