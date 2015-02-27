/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogAttributeEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ListCategoryAttributesTestCases extends MagentoTestParent {

    @Before
    public void setUp() {
        initializeTestRunMessage("listCategoryAttributes");
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testListCategoryAttributes() {
        try {
            List<String> definedAttributes = getTestRunMessageValue("attributes");
            List<CatalogAttributeEntity> attributes = runFlowAndGetPayload("list-category-attributes");
            assertTrue(attributes.size() == definedAttributes.size());
            for (CatalogAttributeEntity attribute : attributes) {
                assertTrue(definedAttributes.contains(attribute.getCode()));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
