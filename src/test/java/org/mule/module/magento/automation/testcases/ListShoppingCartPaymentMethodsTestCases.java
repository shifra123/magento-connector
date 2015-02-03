/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.ShoppingCartCustomerAddressEntity;
import com.magento.api.ShoppingCartPaymentMethodEntity;
import com.magento.api.ShoppingCartPaymentMethodResponseEntityArray;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ListShoppingCartPaymentMethodsTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listShoppingCartPaymentMethods");
        String storeId = getTestRunMessageValue("storeId");
        ShoppingCartPaymentMethodEntity paymentMethod = getTestRunMessageValue("paymentMethod");
        List<ShoppingCartCustomerAddressEntity> customerAddresses = getTestRunMessageValue("customerAddresses");
        int quoteId = createShoppingCart(storeId);
        setCustomerAddressesToShoppingCart(quoteId, customerAddresses);
        setShoppingCartPaymentMethod(quoteId, paymentMethod);
        initializeTestRunMessage("listShoppingCartPaymentMethods");
        upsertOnTestRunMessage("quoteId", quoteId);
    }

    @Category({RegressionTests.class})
    @Test
    @Ignore
    public void testListShoppingCartPaymentMethodsTestCases() {
        try {
            ShoppingCartPaymentMethodResponseEntityArray cartPayments = runFlowAndGetPayload("list-shopping-cart-payment-methods");
            assertNotNull(cartPayments);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}
