/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CustomerCustomerEntityToCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CreateCustomerAddressTestCases extends MagentoTestParent {

    int customerId;

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("createCustomerAddress");

        CustomerCustomerEntityToCreate customer = getTestRunMessageValue("customerRef");
        customerId = createCustomer(customer);

        initializeTestRunMessage("createCustomerAddress");
        upsertOnTestRunMessage("customerId", customerId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateCustomerAddress() {
        try {
            Integer customerAddressId = runFlowAndGetPayload("create-customer-address");
            assertNotNull(customerAddressId);
            upsertOnTestRunMessage("customerAddressId", customerAddressId);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int customerAddressId = getTestRunMessageValue("customerAddressId");
        deleteCustomerAddress(customerAddressId);

        deleteCustomer(customerId);
    }

}
