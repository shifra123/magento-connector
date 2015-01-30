/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.DirectoryRegionEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ListDirectoryRegionsTestCases extends MagentoTestParent {

    @Before
    public void setUp() {
        initializeTestRunMessage("listDirectoryRegions");
    }

    @Category({RegressionTests.class})
    @Test
    public void testListDirectoryRegions() {
        try {
            List<DirectoryRegionEntity> regions = runFlowAndGetPayload("list-directory-regions");
            assertNotNull(regions);
            for (DirectoryRegionEntity region : regions) {
                assertNotNull(region);
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
