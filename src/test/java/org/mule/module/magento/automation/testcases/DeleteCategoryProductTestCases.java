/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.CatalogProductCreateEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DeleteCategoryProductTestCases extends MagentoTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("deleteCategoryProduct");

        Integer categoryId = runFlowAndGetPayload("create-category");
        upsertOnTestRunMessage("categoryId", categoryId);

        CatalogProductCreateEntity catalogProductCreateEntity = getTestRunMessageValue("attributesRef");
        catalogProductCreateEntity.setCategory_ids(new String[]{String.valueOf(categoryId)});
        Integer productId = runFlowAndGetPayload("create-product");
        upsertOnTestRunMessage("productId", productId);

    }

    @Category({RegressionTests.class})
    @Test
    public void testDeleteCategoryProduct() {
        try {
            Boolean response = runFlowAndGetPayload("delete-category-product");
            assertTrue(response);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        int productId = getTestRunMessageValue("productId");
        int categoryId = getTestRunMessageValue("categoryId");
        deleteProductById(productId);
        deleteCategory(categoryId);
    }

}
