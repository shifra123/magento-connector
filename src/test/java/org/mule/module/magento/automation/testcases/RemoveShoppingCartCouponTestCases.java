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

public class RemoveShoppingCartCouponTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("removeShoppingCartCoupon");

        String storeId = getTestRunMessageValue("storeId");
        int quoteId = createShoppingCart(storeId);
        upsertOnTestRunMessage("quoteId", quoteId);

        ShoppingCartCustomerEntity customer = (ShoppingCartCustomerEntity) getTestRunMessageValue("customer");
        List<ShoppingCartCustomerAddressEntity> addresses = (List<ShoppingCartCustomerAddressEntity>) getTestRunMessageValue("customerAddresses");
        String shippingMethod = getTestRunMessageValue("shippingMethod").toString();
        ShoppingCartPaymentMethodEntity paymentMethod = (ShoppingCartPaymentMethodEntity) getTestRunMessageValue("paymentMethod");

        List<HashMap<String, Object>> products = (List<HashMap<String, Object>>) getTestRunMessageValue("products");
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

        upsertOnTestRunMessage("productIds", productIds);

        String couponCode = getTestRunMessageValue("couponCode");

        setShoppingCartCustomer(quoteId, customer);
        addProductsToShoppingCart(quoteId, shoppingCartProducts);
        setCustomerAddressesToShoppingCart(quoteId, addresses);
        setShoppingCartPaymentMethod(quoteId, paymentMethod);
        setShoppingCartShippingMethod(quoteId, shippingMethod);
        addShoppingCartCoupon(quoteId, couponCode);
    }

    @Category({RegressionTests.class})
    @Test
    public void testRemoveShoppingCartCoupon() {
        try {
            Boolean result = runFlowAndGetPayload("remove-shopping-cart-coupon");
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
