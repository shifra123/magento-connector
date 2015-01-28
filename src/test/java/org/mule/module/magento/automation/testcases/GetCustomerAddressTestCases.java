/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CustomerAddressEntityCreate;
import com.magento.api.CustomerAddressEntityItem;
import com.magento.api.CustomerCustomerEntityToCreate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.*;

public class GetCustomerAddressTestCases extends MagentoTestParent {

    Integer addressId;
    Integer customerId;

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getCustomerAddress");

        CustomerCustomerEntityToCreate customer = getTestRunMessageValue("customerRef");
        customerId = createCustomer(customer);

        upsertOnTestRunMessage("customerId", customerId);

        CustomerAddressEntityCreate address = getTestRunMessageValue("customerAddressRef");
        addressId = createCustomerAddress(customerId, address);

        upsertOnTestRunMessage("addressId", addressId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testGetCustomerAddress() {
        try {
            CustomerAddressEntityItem address = runFlowAndGetPayload("get-customer-address");
            assertNotNull(address);
            assertTrue(addressId == address.getCustomer_address_id());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        deleteCustomerAddress(addressId);
        deleteCustomer(customerId);
    }
}