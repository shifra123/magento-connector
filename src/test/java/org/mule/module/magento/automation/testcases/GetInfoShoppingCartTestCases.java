/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.ShoppingCartCustomerEntity;
import com.magento.api.ShoppingCartInfoEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.*;

public class GetInfoShoppingCartTestCases extends MagentoTestParent {

    Integer quoteId;

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getInfoShoppingCart");
        String storeId = getTestRunMessageValue("storeId");
        ShoppingCartCustomerEntity customer = getTestRunMessageValue("customer");
        quoteId = createShoppingCart(storeId);
        setShoppingCartCustomer(quoteId, customer);
        upsertOnTestRunMessage("quoteId", quoteId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testGetInfoShoppingCart() {
        try {
            ShoppingCartInfoEntity result = runFlowAndGetPayload("get-info-shopping-cart");
            assertNotNull(result);
            assertEquals(quoteId, result.getQuote_id());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
