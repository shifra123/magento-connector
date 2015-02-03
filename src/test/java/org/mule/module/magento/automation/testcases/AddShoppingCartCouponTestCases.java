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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AddShoppingCartCouponTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("addShoppingCartCoupon");
        String storeId = getTestRunMessageValue("storeId");
        int quoteId = createShoppingCart(storeId);
        initializeTestRunMessage("addShoppingCartCoupon");
        upsertOnTestRunMessage("quoteId", quoteId);

        ShoppingCartCustomerEntity customer = getTestRunMessageValue("customer");
        List<ShoppingCartCustomerAddressEntity> addresses = getTestRunMessageValue("customerAddresses");
        String shippingMethod = getTestRunMessageValue("shippingMethod");
        ShoppingCartPaymentMethodEntity paymentMethod = getTestRunMessageValue("paymentMethod");

        List<HashMap<String, Object>> products = getTestRunMessageValue("products");
        List<ShoppingCartProductEntity> shoppingCartProducts = new ArrayList<ShoppingCartProductEntity>();
        List<Integer> productIds = new ArrayList<Integer>();

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

        setShoppingCartCustomer(quoteId, customer);
        addProductsToShoppingCart(quoteId, shoppingCartProducts);
        setCustomerAddressesToShoppingCart(quoteId, addresses);
        setShoppingCartPaymentMethod(quoteId, paymentMethod);
        setShoppingCartShippingMethod(quoteId, shippingMethod);

        initializeTestRunMessage("addShoppingCartCoupon");
        upsertOnTestRunMessage("productIds", productIds);
        upsertOnTestRunMessage("quoteId",quoteId);

    }

    /**
     * A pre-requisite for this test is the availability of coupon code CODE12345678
     * in the Magento installation.
     *
     */

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testAddShoppingCartCoupon() {
        try {
            Boolean result = runFlowAndGetPayload("add-shopping-cart-coupon");
            assertTrue(result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() {
        try {
            List<Integer> productIds = getTestRunMessageValue("productIds");
            for (Integer productId : productIds) {
                deleteProductById(productId);
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
