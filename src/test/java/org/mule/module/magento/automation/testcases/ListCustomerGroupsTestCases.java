/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CustomerGroupEntity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ListCustomerGroupsTestCases extends MagentoTestParent {

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testListCustomerGroups() {
        try {
            List<CustomerGroupEntity> customerGroups = runFlowAndGetPayload("list-customer-groups");
            assertNotNull(customerGroups);
            for (CustomerGroupEntity group : customerGroups) {
                // This is the only assertion we can perform since there is currently no way
                // to add a customer group using Soap V2
                assertNotNull(group);
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
