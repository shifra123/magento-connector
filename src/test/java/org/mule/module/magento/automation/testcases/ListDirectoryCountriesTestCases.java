/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.DirectoryCountryEntity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ListDirectoryCountriesTestCases extends MagentoTestParent {

    @Category({RegressionTests.class})
    @Test
    public void testListDirectoryCountries() {
        try {
            List<DirectoryCountryEntity> countries = runFlowAndGetPayload("list-directory-countries");
            assertNotNull(countries);
            for (DirectoryCountryEntity country : countries) {
                assertNotNull(country);
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

}
