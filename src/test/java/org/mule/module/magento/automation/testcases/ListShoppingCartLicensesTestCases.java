/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.ShoppingCartLicenseEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ListShoppingCartLicensesTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listShoppingCartLicenses");
        String storeId = getTestRunMessageValue("storeId");
        int quoteId = createShoppingCart(storeId);
        upsertOnTestRunMessage("quoteId", quoteId);
    }


    @Category({RegressionTests.class})
    @Test
    public void testListShoppingCartLicenses() {
        try {
            List<String> licenses = getTestRunMessageValue("licenses");

            List<ShoppingCartLicenseEntity> definedLicenses = runFlowAndGetPayload("list-shopping-cart-licenses");
            for (ShoppingCartLicenseEntity license : definedLicenses) {
                assertTrue(licenses.contains(license.getContent()));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}
