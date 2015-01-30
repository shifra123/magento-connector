/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.ShoppingCartCustomerAddressEntity;
import com.magento.api.ShoppingCartShippingMethodEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ListShoppingCartShippingMethodsTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listShoppingCartShippingMethods");

        String storeId = getTestRunMessageValue("storeId");

        int quoteId = createShoppingCart(storeId);
        initializeTestRunMessage("listShoppingCartShippingMethods");
        upsertOnTestRunMessage("quoteId", quoteId);

        List<ShoppingCartCustomerAddressEntity> customerAddresses = getTestRunMessageValue("customerAddresses");
        setCustomerAddressesToShoppingCart(quoteId, customerAddresses);
        initializeTestRunMessage("listShoppingCartShippingMethods");
    }

    @SuppressWarnings("unchecked")
    @Category({RegressionTests.class})
    @Test
    public void testListShoppingCartShippingMethods() {
        try {
            List<ShoppingCartShippingMethodEntity> shippingMethods = runFlowAndGetPayload("list-shopping-cart-shipping-methods");
            assertNotNull(shippingMethods);
            for (ShoppingCartShippingMethodEntity method : shippingMethods) {
                assertNotNull(method);
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
