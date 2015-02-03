/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogProductImageEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class GetProductAttributeMediaTestCases extends MagentoTestParent {

    Integer productId;

    @Before
    // This test depends on there being an img.gif file in the classpath
    // (when writing this test there was such a file in src/test/resources).
    public void setUp() throws Exception {
        initializeTestRunMessage("getProductAttributeMedia");
        productId = runFlowAndGetPayload("create-product");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("img.gif");
        upsertPayloadContentOnTestRunMessage(is);
        upsertOnTestRunMessage("productId", productId);
        String newImageFilename = runFlowAndGetPayload("create-product-attribute-media");
        upsertOnTestRunMessage("fileName", newImageFilename);
    }

    @Category({RegressionTests.class})
    @Test
    public void testGetProductAttributeMedia() {
        try {
            CatalogProductImageEntity result = runFlowAndGetPayload("get-product-attribute-media");
            assertNotNull(result);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        deleteProductById(productId);
    }

}
