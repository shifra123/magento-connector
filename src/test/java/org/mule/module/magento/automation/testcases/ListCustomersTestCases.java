package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CustomerCustomerEntity;
import com.magento.api.CustomerCustomerEntityToCreate;

public class ListCustomersTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("listCustomers");
			
			List<Integer> customerIds = new ArrayList<Integer>();
			
			List<CustomerCustomerEntityToCreate> customers = (List<CustomerCustomerEntityToCreate>) testObjects.get("customers");
			
			for (CustomerCustomerEntityToCreate customer : customers) {
				
				testObjects.put("email", customer.getEmail());
				testObjects.put("password", customer.getPassword());
				testObjects.put("firstname", customer.getFirstname());
				testObjects.put("lastname", customer.getLastname());
				
				MessageProcessor flow = lookupFlowConstruct("create-customer");
				MuleEvent response = flow.process(getTestEvent(testObjects));
				
				Integer customerId = (Integer) response.getMessage().getPayload();
				customerIds.add(customerId);
			}

			testObjects.put("customerIds", customerIds);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListCustomers_WithoutFilter() {
		try {
			List<Integer> customerIds = (List<Integer>) testObjects.get("customerIds");
			
			MessageProcessor flow = lookupFlowConstruct("list-customers-without-filter");
			MuleEvent event = flow.process(getTestEvent(testObjects));
			
			List<CustomerCustomerEntity> customers = (List<CustomerCustomerEntity>) event.getMessage().getPayload();
			for (CustomerCustomerEntity customer : customers) {
				Integer temp = customer.getCustomer_id();
				assertTrue(customerIds.contains(temp));
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListCustomers_WithFilter() {
		try {
			
			String emailFilter = testObjects.get("emailFilter").toString();
			List<Integer> customerIds = (List<Integer>) testObjects.get("customerIds");
			
			MessageProcessor flow = lookupFlowConstruct("list-customers-with-filter");
			MuleEvent event = flow.process(getTestEvent(testObjects));
			
			List<CustomerCustomerEntity> retrievedCustomers = (List<CustomerCustomerEntity>) event.getMessage().getPayload();
			assertTrue(retrievedCustomers.size() == 1);
			
			CustomerCustomerEntity customer = retrievedCustomers.get(0);
			assertTrue(customerIds.contains(customer.getCustomer_id()));
			assertTrue(customer.getEmail().equals(emailFilter));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@After
	public void tearDown() {
		try {
			List<Integer> customerIds = (List<Integer>) testObjects.get("customerIds");

			for (Integer customerId : customerIds) {
				testObjects.put("customerId", customerId);
				MessageProcessor flow = lookupFlowConstruct("delete-customer");
				MuleEvent event = flow.process(getTestEvent(testObjects));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
