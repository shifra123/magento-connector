/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SetShoppingCartCustomerTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("setShoppingCartCustomer");
        String storeId = getTestRunMessageValue("storeId");
        int quoteId = createShoppingCart(storeId);
        initializeTestRunMessage("setShoppingCartCustomer");
        upsertOnTestRunMessage("quoteId", quoteId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testSetShoppingCartCustomerTestCases() {
        try {
            boolean result = runFlowAndGetPayload("set-shopping-cart-customer");
            assertTrue(result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
