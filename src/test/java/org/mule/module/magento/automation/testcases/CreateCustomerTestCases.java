/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CreateCustomerTestCases extends MagentoTestParent {

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("createCustomer");
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateCustomer() {
        try {
            // Create the customer
            Integer customerId = runFlowAndGetPayload("create-customer");
            assertNotNull(customerId);

            // Put the customerId in testObjects so that we can use it to delete
            upsertOnTestRunMessage("customerId", customerId);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        // Delete the customer
        runFlowAndGetPayload("delete-customer");
    }

}
