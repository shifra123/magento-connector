
package org.mule.module.magento.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/magento</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-15T03:23:30-05:00", comments = "Build master.1915.dd1962d")
public class MagentoNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(MagentoNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [magento] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [magento] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new MagentoCloudConnectorConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-order-shipment-comment", new AddOrderShipmentCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-order-shipment-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-order-shipment-track", new AddOrderShipmentTrackDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-order-shipment-track", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("cancel-order", new CancelOrderDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("cancel-order", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-order-shipment", new CreateOrderShipmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-order-shipment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-order", new GetOrderDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-order", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-order-invoice", new GetOrderInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-order-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-order-shipment-carriers", new GetOrderShipmentCarriersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-order-shipment-carriers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-order-shipment", new GetOrderShipmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-order-shipment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("hold-order", new HoldOrderDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("hold-order", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-orders", new ListOrdersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-orders", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-orders-invoices", new ListOrdersInvoicesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-orders-invoices", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-orders-shipments", new ListOrdersShipmentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-orders-shipments", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-order-shipment-track", new DeleteOrderShipmentTrackDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-order-shipment-track", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-order-comment", new AddOrderCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-order-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("unhold-order", new UnholdOrderDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("unhold-order", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-order-invoice", new CreateOrderInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-order-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-order-invoice-comment", new AddOrderInvoiceCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-order-invoice-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("capture-order-invoice", new CaptureOrderInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("capture-order-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("void-order-invoice", new VoidOrderInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("void-order-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("cancel-order-invoice", new CancelOrderInvoiceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("cancel-order-invoice", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-customer-address", new CreateCustomerAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-customer-address", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-customer", new CreateCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-customer", new DeleteCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-customer-address", new DeleteCustomerAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-customer-address", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-customer", new GetCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-customer-address", new GetCustomerAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-customer-address", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-customer-addresses", new ListCustomerAddressesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-customer-addresses", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-customer-groups", new ListCustomerGroupsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-customer-groups", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-customers", new ListCustomersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-customers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-customer", new UpdateCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-customer-address", new UpdateCustomerAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-customer-address", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-stock-items", new ListStockItemsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-stock-items", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-stock-item", new UpdateStockItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-stock-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-directory-countries", new ListDirectoryCountriesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-directory-countries", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-directory-regions", new ListDirectoryRegionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-directory-regions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-product-link", new AddProductLinkDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-product-link", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-product-attribute-media", new CreateProductAttributeMediaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-product-attribute-media", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-product-attribute-media", new DeleteProductAttributeMediaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-product-attribute-media", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-product-link", new DeleteProductLinkDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-product-link", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-product-attribute-media", new GetProductAttributeMediaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-product-attribute-media", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-catalog-current-store-view", new GetCatalogCurrentStoreViewDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-catalog-current-store-view", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-category-attribute-store-view", new UpdateCategoryAttributeStoreViewDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-category-attribute-store-view", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-category-attributes", new ListCategoryAttributesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-category-attributes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-category-attribute-options", new ListCategoryAttributeOptionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-category-attribute-options", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-attribute-media", new ListProductAttributeMediaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-attribute-media", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-attribute-media-types", new ListProductAttributeMediaTypesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-attribute-media-types", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-attribute-options", new ListProductAttributeOptionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-attribute-options", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-attributes", new ListProductAttributesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-attributes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-attribute-sets", new ListProductAttributeSetsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-attribute-sets", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-attribute-tier-prices", new ListProductAttributeTierPricesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-attribute-tier-prices", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-link", new ListProductLinkDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-link", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-link-attributes", new ListProductLinkAttributesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-link-attributes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-link-types", new ListProductLinkTypesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-link-types", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-product-types", new ListProductTypesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-product-types", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-product-attribute-media", new UpdateProductAttributeMediaDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-product-attribute-media", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-product-attribute-tier-price", new UpdateProductAttributeTierPriceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-product-attribute-tier-price", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-product-link", new UpdateProductLinkDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-product-link", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-category-products", new ListCategoryProductsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-category-products", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-category-product", new AddCategoryProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-category-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-category", new CreateCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-category", new DeleteCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-category", new GetCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-category-levels", new ListCategoryLevelsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-category-levels", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("move-category", new MoveCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("move-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-category-product", new DeleteCategoryProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-category-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-category-tree", new GetCategoryTreeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-category-tree", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-category", new UpdateCategoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-category", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-category-product", new UpdateCategoryProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-category-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-inventory-stock-items", new ListInventoryStockItemsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-inventory-stock-items", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-inventory-stock-item", new UpdateInventoryStockItemDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-inventory-stock-item", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-product", new CreateProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-product", new DeleteProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-product-special-price", new GetProductSpecialPriceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-product-special-price", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-product", new GetProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-products", new ListProductsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-products", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-product-special-price", new UpdateProductSpecialPriceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-product-special-price", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-product", new UpdateProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-shopping-cart", new CreateShoppingCartDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-shopping-cart", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-info-shopping-cart", new GetInfoShoppingCartDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-info-shopping-cart", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-shopping-cart-totals", new ListShoppingCartTotalsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-shopping-cart-totals", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-shopping-cart-order", new CreateShoppingCartOrderDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-shopping-cart-order", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-shopping-cart-licenses", new ListShoppingCartLicensesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-shopping-cart-licenses", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-shopping-cart-product", new AddShoppingCartProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-shopping-cart-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-shopping-cart-product", new UpdateShoppingCartProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-shopping-cart-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-shopping-cart-product", new RemoveShoppingCartProductDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-shopping-cart-product", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-shopping-cart-products", new ListShoppingCartProductsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-shopping-cart-products", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("move-shopping-cart-product-to-customer-quote", new MoveShoppingCartProductToCustomerQuoteDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("move-shopping-cart-product-to-customer-quote", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-shopping-cart-customer", new SetShoppingCartCustomerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-shopping-cart-customer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-shopping-cart-customer-addresses", new SetShoppingCartCustomerAddressesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-shopping-cart-customer-addresses", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-shopping-cart-shipping-method", new SetShoppingCartShippingMethodDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-shopping-cart-shipping-method", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-shopping-cart-shipping-methods", new ListShoppingCartShippingMethodsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-shopping-cart-shipping-methods", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-shopping-cart-payment-method", new SetShoppingCartPaymentMethodDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-shopping-cart-payment-method", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("list-shopping-cart-payment-methods", new ListShoppingCartPaymentMethodsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("list-shopping-cart-payment-methods", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-shopping-cart-coupon", new AddShoppingCartCouponDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-shopping-cart-coupon", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-shopping-cart-coupon", new RemoveShoppingCartCouponDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-shopping-cart-coupon", "@Processor", ex);
        }
    }

}
