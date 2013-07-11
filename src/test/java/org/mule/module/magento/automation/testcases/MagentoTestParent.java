package org.mule.module.magento.automation.testcases;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;
import org.mule.tck.junit4.FunctionalTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.magento.api.CustomerAddressEntityCreate;
import com.magento.api.CustomerCustomerEntityToCreate;

public class MagentoTestParent extends FunctionalTestCase {

	// Set global timeout of tests to 10minutes
    @Rule
    public Timeout globalTimeout = new Timeout(600000);

	protected static final String[] SPRING_CONFIG_FILES = new String[] { "AutomationSpringBeans.xml" };
	protected static ApplicationContext context;
	protected Map<String, Object> testObjects;
	
	@Override
	protected String getConfigResources() {
		return "automation-test-flows.xml";
	}

	protected MessageProcessor lookupFlowConstruct(String name) {
		return (MessageProcessor) muleContext.getRegistry().lookupFlowConstruct(name);
	}
	
	@BeforeClass
	public static void beforeClass() {
		context = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILES);
	}
	
	/*
	 * Helper methods below
	 */
	
	public int createCustomer(CustomerCustomerEntityToCreate customer) throws Exception {
		testObjects.put("customerRef", customer);
		MessageProcessor flow = lookupFlowConstruct("create-customer");
		MuleEvent response = flow.process(getTestEvent(testObjects));
		return (Integer) response.getMessage().getPayload();
	}
	
	public boolean deleteCustomer(int customerId) throws Exception {
		testObjects.put("customerId", customerId);
		MessageProcessor flow = lookupFlowConstruct("delete-customer");
		MuleEvent response = flow.process(getTestEvent(testObjects));
		return (Boolean) response.getMessage().getPayload();
	}

	public int createCustomerAddress(int customerId, CustomerAddressEntityCreate address) throws Exception {
		testObjects.put("customerId", customerId);
		testObjects.put("customerAddressRef", address);
		MessageProcessor flow = lookupFlowConstruct("create-customer-address");
		MuleEvent response = flow.process(getTestEvent(testObjects));
		return (Integer) response.getMessage().getPayload();
	}
	
	public boolean deleteCustomerAddress(int customerAddressId) throws Exception {
		testObjects.put("addressId", customerAddressId);
		MessageProcessor flow = lookupFlowConstruct("delete-customer-address");
		MuleEvent response = flow.process(getTestEvent(testObjects));
		return (Boolean) response.getMessage().getPayload();
	}
	
}
