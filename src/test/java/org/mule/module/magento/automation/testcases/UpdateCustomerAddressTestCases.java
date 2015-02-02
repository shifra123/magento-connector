/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CustomerAddressEntityCreate;
import com.magento.api.CustomerCustomerEntityToCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UpdateCustomerAddressTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateCustomerAddress");

        CustomerCustomerEntityToCreate customer = getTestRunMessageValue("customerRef");
        int customerId = createCustomer(customer);

        CustomerAddressEntityCreate address = getTestRunMessageValue("customerAddressBefore");
        int addressId = createCustomerAddress(customerId, address);

        initializeTestRunMessage("updateCustomerAddress");
        upsertOnTestRunMessage("customerId", customerId);
        upsertOnTestRunMessage("addressId", addressId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateCustomerAddress() {
        try {
            CustomerAddressEntityCreate addressAfter = getTestRunMessageValue("customerAddressAfter");
            upsertOnTestRunMessage("customerAddressRef", addressAfter);

            Boolean result = runFlowAndGetPayload("update-customer-address");
            assertTrue(result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int addressId = getTestRunMessageValue("addressId");
        deleteCustomerAddress(addressId);

        int customerId = getTestRunMessageValue("customerId");
        deleteCustomer(customerId);
    }

}
