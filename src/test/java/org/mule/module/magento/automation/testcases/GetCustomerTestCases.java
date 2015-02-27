/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CustomerCustomerEntity;
import com.magento.api.CustomerCustomerEntityToCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetCustomerTestCases extends MagentoTestParent {

    Integer customerId;

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getCustomer");
        customerId = runFlowAndGetPayload("create-customer");
        upsertOnTestRunMessage("customerId", customerId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testGetCustomer() {
        try {

            int customerId = getTestRunMessageValue("customerId");
            CustomerCustomerEntityToCreate customer = getTestRunMessageValue("customerRef");

            CustomerCustomerEntity createdCustomer = runFlowAndGetPayload("get-customer");

            assertTrue(createdCustomer.getCustomer_id() == customerId);
            assertTrue(createdCustomer.getEmail().equals(customer.getEmail()));
            assertTrue(createdCustomer.getFirstname().equals(customer.getFirstname()));
            assertTrue(createdCustomer.getLastname().equals(customer.getLastname()));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        runFlowAndGetPayload("delete-customer");
    }

}
