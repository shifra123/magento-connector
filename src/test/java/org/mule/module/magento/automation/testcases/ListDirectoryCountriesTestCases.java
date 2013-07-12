package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.DirectoryCountryEntity;

public class ListDirectoryCountriesTestCases extends MagentoTestParent {

	@Category({RegressionTests.class})
	@Test
	public void testListDirectoryCountries() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-directory-countries");
			MuleEvent response = flow.process(getTestEvent(null));
			
			List<DirectoryCountryEntity> countries = (List<DirectoryCountryEntity>) response.getMessage().getPayload();
			assertNotNull(countries);
			for (DirectoryCountryEntity country : countries) {
				assertNotNull(country);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
