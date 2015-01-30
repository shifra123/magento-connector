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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ListCustomersTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listCustomers");
        List<Integer> customerIds = new ArrayList<Integer>();
        List<CustomerCustomerEntityToCreate> customers = getTestRunMessageValue("customers");

        // Create the customers
        for (CustomerCustomerEntityToCreate customer : customers) {
            Integer customerId = createCustomer(customer);
            customerIds.add(customerId);
        }
        upsertOnTestRunMessage("customerIds", customerIds);
    }

    @Category({RegressionTests.class})
    @Test
    public void testListCustomers_WithoutFilter() {
        try {
            List<Integer> customerIds = getTestRunMessageValue("customerIds");

            List<CustomerCustomerEntity> customers = runFlowAndGetPayload("list-customers-without-filter");
            for (CustomerCustomerEntity customer : customers) {
                Integer temp = customer.getCustomer_id();
                assertTrue(customerIds.contains(temp));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({RegressionTests.class})
    @Test
    public void testListCustomers_WithFilter() {
        try {

            String emailFilter = getTestRunMessageValue("emailFilter");
            List<Integer> customerIds = getTestRunMessageValue("customerIds");

            List<CustomerCustomerEntity> retrievedCustomers = runFlowAndGetPayload("list-customers-with-filter");
            assertTrue(retrievedCustomers.size() == 1);

            CustomerCustomerEntity customer = retrievedCustomers.get(0);
            assertTrue(customerIds.contains(customer.getCustomer_id()));
            assertTrue(customer.getEmail().equals(emailFilter));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        List<Integer> customerIds = getTestRunMessageValue("customerIds");

        // Delete the customers
        for (Integer customerId : customerIds) {
            deleteCustomer(customerId);
        }
    }
}
