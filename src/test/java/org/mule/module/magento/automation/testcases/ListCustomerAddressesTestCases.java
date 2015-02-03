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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListCustomerAddressesTestCases extends MagentoTestParent {

    int customerId;

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listCustomerAddresses");
        CustomerCustomerEntityToCreate customer = getTestRunMessageValue("customerRef");
        customerId = createCustomer(customer);

        initializeTestRunMessage("listCustomerAddresses");
        upsertOnTestRunMessage("customerId", customerId);
        List<Integer> addressIds = new ArrayList<Integer>();
        List<CustomerAddressEntityCreate> addresses = getTestRunMessageValue("customerAddresses");
        for (CustomerAddressEntityCreate address : addresses) {
            int addressId = createCustomerAddress(customerId, address);
            addressIds.add(addressId);
        }

        initializeTestRunMessage("listCustomerAddresses");
        upsertOnTestRunMessage("addressIds", addressIds);
        upsertOnTestRunMessage("customerId", customerId);
    }

    @Category({RegressionTests.class})
    @Test
    public void testListCustomerAddresses() {
        try {
            List<Integer> addressIds = getTestRunMessageValue("addressIds");
            List<CustomerAddressEntityItem> customerAddresses = runFlowAndGetPayload("list-customer-addresses");
            assertEquals(addressIds.size(), customerAddresses.size());
            for (CustomerAddressEntityItem address : customerAddresses) {
                assertTrue(addressIds.contains(address.getCustomer_address_id()));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        List<Integer> addressIds = getTestRunMessageValue("addressIds");
        for (int addressId : addressIds) {
            deleteCustomerAddress(addressId);
        }
        deleteCustomer(customerId);
    }
}
