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

import static org.junit.Assert.*;

public class UpdateCategoryAttributeStoreViewTestCases extends MagentoTestParent {

    @Before
    public void setUp() {
        initializeTestRunMessage("updateCategoryAttributeStoreView");
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateCategoryAttributeStoreViewTestCases() {
        try {
            Integer result = runFlowAndGetPayload("update-category-attribute-store-view");
            assertNotNull(result);
            assertEquals("Assert that the integer returned is the store view id which was set",
                    getTestRunMessageValue("storeViewIdOrCode"), result + "");
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
