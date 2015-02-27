/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogProductLinkAttributeEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.*;

public class ListProductLinkAttributesTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("listProductLinkAttributes");
        Integer productId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("productId", productId);
        String sku = getTestRunMessageValue("sku");
        // change the sku for the second product
        upsertOnTestRunMessage("sku", sku + "abc");
        Integer linkedProductId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("linkedProductIdOrSku", linkedProductId);

        String linkType = "related";
        upsertOnTestRunMessage("type", linkType);
        runFlowAndGetPayload("add-product-link");
    }

    @Category({RegressionTests.class})
    @Test
    public void testListProductLinkAttributes() {
        try {
            List<CatalogProductLinkAttributeEntity> catalogProductLinkAttributeEntities =
                    runFlowAndGetPayload("list-product-link-attributes");

            assertNotNull(catalogProductLinkAttributeEntities);
            assertEquals(1, catalogProductLinkAttributeEntities.size());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int productId = getTestRunMessageValue("productId");
        int linkedProductId = getTestRunMessageValue("linkedProductIdOrSku");
        deleteProductById(productId);
        deleteProductById(linkedProductId);
    }

}
