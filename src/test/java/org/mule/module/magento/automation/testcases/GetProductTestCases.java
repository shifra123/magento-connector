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
import com.magento.api.ShoppingCartProductEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetProductTestCases extends MagentoTestParent {

    int productId;

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getProduct");
        HashMap<String, Object> product = getTestRunMessageValue("products");

        // Get the product data
        String productType = (String) product.get("type");
        int productSet = (Integer) product.get("set");
        String productSKU = (String) product.get("sku");
        CatalogProductCreateEntity attributes = (CatalogProductCreateEntity) product.get("attributesRef");

        // Create the product and get the product ID
        productId = createProduct(productType, productSet, productSKU, attributes);

        // Get the quantity to place in the shopping cart
        double qtyToPurchase = (Double) product.get("qtyToPurchase");

        // Create the shopping cart product entity
        ShoppingCartProductEntity shoppingCartProduct = new ShoppingCartProductEntity();
        shoppingCartProduct.setProduct_id(productId + "");
        shoppingCartProduct.setQty(qtyToPurchase);

        initializeTestRunMessage("getProduct");
        upsertOnTestRunMessage("productSku", productSKU);
        upsertOnTestRunMessage("productId", productId);
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testGetProduct() {
        try {
            CatalogProductReturnEntity catalogProductReturnEntity = runFlowAndGetPayload("get-product");
            assertEquals("The sku of the retrieved object should be " + getTestRunMessageValue("sku"),
                    getTestRunMessageValue("sku"), catalogProductReturnEntity.getSku());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        deleteProductById(productId);
    }
}
