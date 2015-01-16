/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.automation.testcases;

import com.magento.api.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.mule.modules.tests.ConnectorTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class MagentoTestParent extends ConnectorTestCase {

    // Set global timeout of tests to 10minutes
    @Rule
    public Timeout globalTimeout = new Timeout(600000);

//    protected static final String[] SPRING_CONFIG_FILES = new String[]{"AutomationSpringBeans.xml", "AttributesSpringBeans.xml"};
    protected static ApplicationContext context;
    protected Map<String, Object> testObjects;

    public static final String DEFAULT_STORE_ID = "1";

    public static final int ROOT_CATEGORY_ID = 1;
    public static final int DEFAULT_CATEGORY_ID = 2;

    public static final int DEFAULT_PRODUCT_SET = 4;

//    @Override
//    protected String getConfigResources() {
//        return "automation-test-flows.xml";
//    }

    //,automation-helper-flows.xml

//	protected MessageProcessor lookupFlowConstruct(String name) {
//		return (MessageProcessor) muleContext.getRegistry().lookupFlowConstruct(name);
//	}

//    @BeforeClass
//    public static void beforeClass() {
//        context = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILES);
//    }

	/*
     * Helper methods below
	 */

    public int createCustomer(CustomerCustomerEntityToCreate customer) throws Exception {
        initializeTestRunMessage("customerRef", customer);
        return runFlowAndGetPayload("create-customer");
    }

    public boolean deleteCustomer(int customerId) throws Exception {
        initializeTestRunMessage("customerId", customerId);
        return runFlowAndGetPayload("delete-customer");
    }

    public int createCustomerAddress(int customerId, CustomerAddressEntityCreate address) throws Exception {
        initializeTestRunMessage("customerId", customerId);
        upsertOnTestRunMessage("customerAddressRef", address);
        return runFlowAndGetPayload("create-customer-address");
    }

    public boolean deleteCustomerAddress(int customerAddressId) throws Exception {
        initializeTestRunMessage("addressId", customerAddressId);
        return runFlowAndGetPayload("delete-customer-address");
    }

    public int createCategory(int parentId, CatalogCategoryEntityCreate category) throws Exception {
        initializeTestRunMessage("parentId", parentId);
        upsertOnTestRunMessage("catalogCategoryEntityRef", category);
        return runFlowAndGetPayload("create-category");
    }

    public boolean deleteCategory(int categoryId) throws Exception {
        initializeTestRunMessage("categoryId", categoryId);
        return runFlowAndGetPayload("delete-category");
    }

    public int createProduct(String type, int set, String sku, CatalogProductCreateEntity productAttributes) throws Exception {
        initializeTestRunMessage("type", type);
        upsertOnTestRunMessage("set", set);
        upsertOnTestRunMessage("sku", sku);
        upsertOnTestRunMessage("attributesRef", productAttributes);

        return runFlowAndGetPayload("create-product");
    }

    public int deleteProductById(int productId) throws Exception {
        initializeTestRunMessage("productId", productId);
        return runFlowAndGetPayload("delete-product-by-product-id");
    }

    public int deleteProductBySku(String productSku) throws Exception {
        initializeTestRunMessage("productSku", productSku);
        return runFlowAndGetPayload("delete-product-by-product-sku");
    }

    @SuppressWarnings("unchecked")
    public CatalogCategoryInfo getCategory(int categoryId) throws Exception {
        List<String> categoryAttributeNames = (List<String>) context.getBean("categoryAttributeNames");
        initializeTestRunMessage("categoryId", categoryId);
        upsertOnTestRunMessage("attributeNames", categoryAttributeNames);
        return runFlowAndGetPayload("get-category");
    }

    public int createShoppingCart() throws Exception {
        return runFlowAndGetPayload("create-shopping-cart");
    }

    public int createShoppingCart(String storeId) throws Exception {
        initializeTestRunMessage("storeId", storeId);

        return runFlowAndGetPayload("create-shopping-cart-with-store-id");
    }

    public boolean addProductsToShoppingCart(int quoteId, List<ShoppingCartProductEntity> products) throws Exception {
        initializeTestRunMessage("quoteId", quoteId);
        upsertOnTestRunMessage("productsRef", products);

        // Add the shopping cart products
        return runFlowAndGetPayload("add-shopping-cart-product");
    }

    public boolean setShoppingCartCustomer(int quoteId, ShoppingCartCustomerEntity customer) throws Exception {
        initializeTestRunMessage("quoteId", quoteId);
        upsertOnTestRunMessage("customerRef", customer);

        // Add the shopping cart customer
        return runFlowAndGetPayload("set-shopping-cart-customer");
    }

    public boolean setCustomerAddressesToShoppingCart(int quoteId, List<ShoppingCartCustomerAddressEntity> addresses) throws Exception {
        initializeTestRunMessage("quoteId", quoteId);
        upsertOnTestRunMessage("shoppingCartCustomerAddressesRef", addresses);

        // Add the customer addresses
        return runFlowAndGetPayload("set-shopping-cart-customer-addresses");
    }

    public boolean setShoppingCartShippingMethod(int quoteId, String shippingMethod) throws Exception {
        initializeTestRunMessage("quoteId", quoteId);
        upsertOnTestRunMessage("method", shippingMethod);

        // Set the shopping cart shipping method
        return runFlowAndGetPayload("set-shopping-cart-shipping-method");
    }

    public boolean setShoppingCartPaymentMethod(int quoteId, ShoppingCartPaymentMethodEntity paymentMethod) throws Exception {
        initializeTestRunMessage("quoteId", quoteId);
        upsertOnTestRunMessage("shoppingCartPaymentMethodRef", paymentMethod);

        // Set the shopping cart payment method
        return runFlowAndGetPayload("set-shopping-cart-payment-method");
    }

    public String createShoppingCartOrder(int quoteId, ShoppingCartCustomerEntity customer,
                                          List<ShoppingCartCustomerAddressEntity> addresses,
                                          ShoppingCartPaymentMethodEntity paymentMethod,
                                          String shippingMethod,
                                          List<ShoppingCartProductEntity> products) throws Exception {

        initializeTestRunMessage("quoteId", quoteId);
        addProductsToShoppingCart(quoteId, products);

        setShoppingCartCustomer(quoteId, customer);
        setCustomerAddressesToShoppingCart(quoteId, addresses);
        setShoppingCartPaymentMethod(quoteId, paymentMethod);
        setShoppingCartShippingMethod(quoteId, shippingMethod);

        return runFlowAndGetPayload("create-shopping-cart-order");
    }

    public String createShoppingCartOrder(int quoteId, ShoppingCartCustomerEntity customer,
                                          List<ShoppingCartCustomerAddressEntity> addresses,
                                          ShoppingCartPaymentMethodEntity paymentMethod,
                                          String shippingMethod,
                                          List<ShoppingCartProductEntity> products,
                                          List<String> licenses) throws Exception {

        initializeTestRunMessage("quoteId", quoteId);

        setShoppingCartCustomer(quoteId, customer);
        setCustomerAddressesToShoppingCart(quoteId, addresses);
        setShoppingCartPaymentMethod(quoteId, paymentMethod);
        setShoppingCartShippingMethod(quoteId, shippingMethod);
        addProductsToShoppingCart(quoteId, products);

        upsertOnTestRunMessage("licensesRef", licenses);

        return runFlowAndGetPayload("create-shopping-cart-order-with-licenses");
    }

    // unused
    public Boolean cancelOrder(String orderId) throws Exception {
        initializeTestRunMessage("orderId", orderId);

        // Cancel the order
        return runFlowAndGetPayload("cancel-order");
    }

    public boolean holdOrder(String orderId) throws Exception {
        initializeTestRunMessage("orderId", orderId);

        return runFlowAndGetPayload("hold-order");
    }

    // unused
    public Integer unholdOrder(String orderId) throws Exception {
        initializeTestRunMessage("orderId", orderId);

        return runFlowAndGetPayload("unhold-order");
    }

    public boolean addShoppingCartCoupon(int quoteId, String couponCode) throws Exception {
        initializeTestRunMessage("quoteId", quoteId);
        upsertOnTestRunMessage("couponCode", couponCode);

        return runFlowAndGetPayload("add-shopping-cart-coupon");
    }

    // unused
    public Integer captureOrderInvoice(String invoiceId) throws Exception {
        initializeTestRunMessage("invoiceId", invoiceId);

        return runFlowAndGetPayload("capture-order-invoice");
    }

    public String createOrderInvoice(String orderId, List<OrderItemIdQty> quantities) throws Exception {
        initializeTestRunMessage("orderId", orderId);
        upsertOnTestRunMessage("itemsQuantitiesRef", quantities);

        return runFlowAndGetPayload("create-order-invoice");
    }

    public String createOrderInvoice(String orderId, String comment, List<OrderItemIdQty> quantities) throws Exception {
        initializeTestRunMessage("orderId", orderId);
        upsertOnTestRunMessage("comment", comment);
        upsertOnTestRunMessage("itemsQuantitiesRef", quantities);

        return runFlowAndGetPayload("create-order-invoice-with-comment");
    }

    // unused
    public boolean cancelOrderInvoice(String invoiceId) throws Exception {
        initializeTestRunMessage("invoiceId", invoiceId);

        return runFlowAndGetPayload("cancel-order-invoice");
    }

    public String createOrderShipment(String orderId, List<OrderItemIdQty> quantities) throws Exception {
        initializeTestRunMessage("orderId", orderId);

        // A workaround for Magento's internal bug
        // To remove this if statement once the bug is fixed
        if (quantities.size() > 0) {
            quantities.clear();
        }

        upsertOnTestRunMessage("itemsQuantitiesRef", quantities);

        return runFlowAndGetPayload("create-order-shipment");
    }

    public int addOrderShipmentTrack(String shipmentIncrementId, String carrierCode, String title, String trackId) throws Exception {
        initializeTestRunMessage("shipmentId", shipmentIncrementId);
        upsertOnTestRunMessage("carrierCode", carrierCode);
        upsertOnTestRunMessage("title", title);
        upsertOnTestRunMessage("trackId", trackId);

        return runFlowAndGetPayload("add-order-shipment-track");
    }

    public void clearSalesTables() throws Exception {
//		 runFlowAndGetPayload("truncate-sales");
    }

    public void clearCatalogProductsTables() throws Exception {
        runFlowAndGetPayload("truncate-catalog-products");
    }
}
