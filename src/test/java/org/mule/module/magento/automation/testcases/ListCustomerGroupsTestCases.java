package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CustomerGroupEntity;

public class ListCustomerGroupsTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = new HashMap<String, Object>();
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListCustomerGroups() {
		try {
			MessageProcessor flow = lookupFlowConstruct("list-customer-groups");
			MuleEvent response = flow.process(getTestEvent(testObjects));

			List<CustomerGroupEntity> customerGroups = (List<CustomerGroupEntity>) response.getMessage().getPayload();
			assertNotNull(customerGroups);
			for (CustomerGroupEntity group : customerGroups) {
				// This is the only assertion we can perform since there is currently no way
				// to add a customer group using Soap V2
				assertNotNull(group);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
