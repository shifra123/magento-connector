/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogAttributeEntity;
import com.magento.api.CatalogAttributeOptionEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ListProductAttributeOptionsTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listProductAttributeOptions");
        List<CatalogAttributeEntity> catalogAttributeEntities = runFlowAndGetPayload("list-product-attributes");
        upsertOnTestRunMessage("attributeId", catalogAttributeEntities.get(0).getAttribute_id());
    }

    @Category({RegressionTests.class})
    @Test
    public void testListProductAttributes() {
        try {
            List<CatalogAttributeOptionEntity> catalogAttributeOptionEntities = runFlowAndGetPayload("list-product-attribute-options");
            assertNotNull(catalogAttributeOptionEntities);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}
