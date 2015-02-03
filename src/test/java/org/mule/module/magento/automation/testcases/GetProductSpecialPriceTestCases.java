/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogProductCreateEntity;
import com.magento.api.CatalogProductReturnEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetProductSpecialPriceTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getProductSpecialPrice");

        String type = getTestRunMessageValue("type");
        String sku = getTestRunMessageValue("sku");
        int set = getTestRunMessageValue("set");
        CatalogProductCreateEntity productAttributes = getTestRunMessageValue("attributesRef");
        int productId = createProduct(type, set, sku, productAttributes);
        initializeTestRunMessage("getProductSpecialPrice");
        upsertOnTestRunMessage("attributes", productAttributes);
        upsertOnTestRunMessage("specialPrice", productAttributes.getSpecial_price());
        upsertOnTestRunMessage("productId", productId);
    }

    @Category({RegressionTests.class})
    @Test
    @Ignore
    public void testGetProductSpecialPrice() {
        try {
            String specialPrice = getTestRunMessageValue("specialPrice");
            Integer productId = getTestRunMessageValue("productId");
            CatalogProductReturnEntity specialPriceResult = runFlowAndGetPayload("get-product-special-price");
            assertEquals(productId, Integer.valueOf(specialPriceResult.getProduct_id()));
            assertEquals(specialPrice, specialPriceResult.getSpecial_price());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int productId = getTestRunMessageValue("productId");
        deleteProductById(productId);
    }

}
