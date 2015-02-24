/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ListProductLinkTypesTestCases extends MagentoTestParent {

    @Category({RegressionTests.class})
    @Test
    public void testListProductLinkTypes() {
        try {
            List<String> productLinkTypes = runFlowAndGetPayload("list-product-link-types");

            assertNotNull(productLinkTypes);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}
