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

import static org.junit.Assert.*;

public class ListOrdersTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listOrders");
        List<Integer> productIds = new ArrayList<Integer>();
        List<String> orderIds = new ArrayList<String>();

        String storeId = getTestRunMessageValue("storeId");
        List<HashMap<String, Object>> orderBeans = getTestRunMessageValue("orderBeans");

        for (HashMap<String, Object> orderBean : orderBeans) {

            List<ShoppingCartProductEntity> cartProducts = new ArrayList<ShoppingCartProductEntity>();

            ShoppingCartCustomerEntity customer = (ShoppingCartCustomerEntity) orderBean.get("customer");
            List<ShoppingCartCustomerAddressEntity> addresses = (List<ShoppingCartCustomerAddressEntity>) orderBean.get("customerAddresses");
            String shippingMethod = orderBean.get("shippingMethod").toString();
            ShoppingCartPaymentMethodEntity paymentMethod = (ShoppingCartPaymentMethodEntity) orderBean.get("paymentMethod");

            List<HashMap<String, Object>> products = (List<HashMap<String, Object>>) orderBean.get("products");
            for (HashMap<String, Object> product : products) {
                // Get the product data
                String productType = (String) product.get("type");
                int productSet = (Integer) product.get("set");
                String productSKU = (String) product.get("sku");
                CatalogProductCreateEntity attributes = (CatalogProductCreateEntity) product.get("attributesRef");

                // Create the product and get the product ID
                int productId = createProduct(productType, productSet, productSKU, attributes);
                productIds.add(productId);

                double qtyToPurchase = (Double) product.get("qtyToPurchase");

                ShoppingCartProductEntity cartProduct = new ShoppingCartProductEntity();
                cartProduct.setProduct_id(productId + "");
                cartProduct.setQty(qtyToPurchase);

                cartProducts.add(cartProduct);
            }
            int quoteId = createShoppingCart(storeId);
            String orderId = createShoppingCartOrder(quoteId, customer, addresses, paymentMethod, shippingMethod, cartProducts);
            orderIds.add(orderId);
        }
        initializeTestRunMessage("listOrders");
        upsertOnTestRunMessage("orderIds", orderIds);
        upsertOnTestRunMessage("productIds", productIds);
    }

    @Category({RegressionTests.class})
    @Test
    public void testListOrders_NoFilter() {
        try {
            List<String> orderIds = getTestRunMessageValue("orderIds");

            List<SalesOrderListEntity> orders = runFlowAndGetPayload("list-orders-unfiltered");
            assertEquals(orders.size(), orderIds.size());
            for (SalesOrderListEntity order : orders) {
                assertTrue(orderIds.contains(order.getIncrement_id()));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({RegressionTests.class})
    @Test
    public void testListOrders_Pending() {
        try {
            List<String> orderIds = getTestRunMessageValue("orderIds");

            String filter = getTestRunMessageValue("pendingOrdersFilter");
            upsertOnTestRunMessage("filter", filter);

            List<SalesOrderListEntity> orders = runFlowAndGetPayload("list-orders");
            assertEquals(orders.size(), orderIds.size());
            for (SalesOrderListEntity order : orders) {
                assertTrue(orderIds.contains(order.getIncrement_id()));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({RegressionTests.class})
    @Test
    public void testListOrders_Cancelled() {
        try {
            String filter = getTestRunMessageValue("cancelledOrdersFilter");
            upsertOnTestRunMessage("filter", filter);

            List<SalesOrderListEntity> orders = runFlowAndGetPayload("list-orders");
            assertTrue(orders.isEmpty());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({RegressionTests.class})
    @Test
    public void testListOrders_Completed() {
        try {
            String filter = getTestRunMessageValue("completedOrdersFilter");
            upsertOnTestRunMessage("filter", filter);

            List<SalesOrderListEntity> orders = runFlowAndGetPayload("list-orders");
            assertTrue(orders.isEmpty());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        List<Integer> productIds = (List<Integer>) getTestRunMessageValue("productIds");
        for (int productId : productIds) {
            deleteProductById(productId);
        }
    }

}
