
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.AssociativeEntityExpressionHolder;
import com.magento.api.holders.CatalogInventoryStockItemUpdateEntityExpressionHolder;
import com.magento.api.holders.CatalogProductAdditionalAttributesEntityExpressionHolder;
import com.magento.api.holders.CatalogProductCreateEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateProductMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.0-RC1", date = "2014-05-06T10:53:30-05:00", comments = "Build master.1926.b0106b2")
public class UpdateProductDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateProductDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateProductMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-product] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-product] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateProduct");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "productId", "productId");
        parseProperty(builder, element, "productSku", "productSku");
        parseProperty(builder, element, "productIdOrSku", "productIdOrSku");
        if (!parseObjectRefWithDefault(element, builder, "catalog-product-entity", "catalogProductEntity", "#[payload]")) {
            BeanDefinitionBuilder catalogProductEntityBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductCreateEntityExpressionHolder.class.getName());
            Element catalogProductEntityChildElement = DomUtils.getChildElementByTagName(element, "catalog-product-entity");
            if (catalogProductEntityChildElement!= null) {
                if (hasAttribute(catalogProductEntityChildElement, "categories-ref")) {
                    if (catalogProductEntityChildElement.getAttribute("categories-ref").startsWith("#")) {
                        catalogProductEntityBuilder.addPropertyValue("categories", catalogProductEntityChildElement.getAttribute("categories-ref"));
                    } else {
                        catalogProductEntityBuilder.addPropertyValue("categories", (("#[registry:"+ catalogProductEntityChildElement.getAttribute("categories-ref"))+"]"));
                    }
                }
                if (hasAttribute(catalogProductEntityChildElement, "websites-ref")) {
                    if (catalogProductEntityChildElement.getAttribute("websites-ref").startsWith("#")) {
                        catalogProductEntityBuilder.addPropertyValue("websites", catalogProductEntityChildElement.getAttribute("websites-ref"));
                    } else {
                        catalogProductEntityBuilder.addPropertyValue("websites", (("#[registry:"+ catalogProductEntityChildElement.getAttribute("websites-ref"))+"]"));
                    }
                }
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "name", "name");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "description", "description");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "short_description", "short_description");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "weight", "weight");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "status", "status");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "url_key", "url_key");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "url_path", "url_path");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "visibility", "visibility");
                if (hasAttribute(catalogProductEntityChildElement, "category_ids-ref")) {
                    if (catalogProductEntityChildElement.getAttribute("category_ids-ref").startsWith("#")) {
                        catalogProductEntityBuilder.addPropertyValue("category_ids", catalogProductEntityChildElement.getAttribute("category_ids-ref"));
                    } else {
                        catalogProductEntityBuilder.addPropertyValue("category_ids", (("#[registry:"+ catalogProductEntityChildElement.getAttribute("category_ids-ref"))+"]"));
                    }
                }
                if (hasAttribute(catalogProductEntityChildElement, "website_ids-ref")) {
                    if (catalogProductEntityChildElement.getAttribute("website_ids-ref").startsWith("#")) {
                        catalogProductEntityBuilder.addPropertyValue("website_ids", catalogProductEntityChildElement.getAttribute("website_ids-ref"));
                    } else {
                        catalogProductEntityBuilder.addPropertyValue("website_ids", (("#[registry:"+ catalogProductEntityChildElement.getAttribute("website_ids-ref"))+"]"));
                    }
                }
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "has_options", "has_options");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "gift_message_available", "gift_message_available");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "price", "price");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "special_price", "special_price");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "special_from_date", "special_from_date");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "special_to_date", "special_to_date");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "tax_class_id", "tax_class_id");
                if (hasAttribute(catalogProductEntityChildElement, "tier_price-ref")) {
                    if (catalogProductEntityChildElement.getAttribute("tier_price-ref").startsWith("#")) {
                        catalogProductEntityBuilder.addPropertyValue("tier_price", catalogProductEntityChildElement.getAttribute("tier_price-ref"));
                    } else {
                        catalogProductEntityBuilder.addPropertyValue("tier_price", (("#[registry:"+ catalogProductEntityChildElement.getAttribute("tier_price-ref"))+"]"));
                    }
                }
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "meta_title", "meta_title");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "meta_keyword", "meta_keyword");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "meta_description", "meta_description");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "custom_design", "custom_design");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "custom_layout_update", "custom_layout_update");
                parseProperty(catalogProductEntityBuilder, catalogProductEntityChildElement, "options_container", "options_container");
                if (!parseObjectRef(catalogProductEntityChildElement, catalogProductEntityBuilder, "additional_attributes", "additional_attributes")) {
                    BeanDefinitionBuilder _additional_attributesBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductAdditionalAttributesEntityExpressionHolder.class.getName());
                    Element _additional_attributesChildElement = DomUtils.getChildElementByTagName(catalogProductEntityChildElement, "additional_attributes");
                    if (_additional_attributesChildElement!= null) {
                        if (hasAttribute(_additional_attributesChildElement, "multi_data-ref")) {
                            if (_additional_attributesChildElement.getAttribute("multi_data-ref").startsWith("#")) {
                                _additional_attributesBuilder.addPropertyValue("multi_data", _additional_attributesChildElement.getAttribute("multi_data-ref"));
                            } else {
                                _additional_attributesBuilder.addPropertyValue("multi_data", (("#[registry:"+ _additional_attributesChildElement.getAttribute("multi_data-ref"))+"]"));
                            }
                        }
                        if (hasAttribute(_additional_attributesChildElement, "single_data-ref")) {
                            if (_additional_attributesChildElement.getAttribute("single_data-ref").startsWith("#")) {
                                _additional_attributesBuilder.addPropertyValue("single_data", _additional_attributesChildElement.getAttribute("single_data-ref"));
                            } else {
                                _additional_attributesBuilder.addPropertyValue("single_data", (("#[registry:"+ _additional_attributesChildElement.getAttribute("single_data-ref"))+"]"));
                            }
                        }
                        catalogProductEntityBuilder.addPropertyValue("additional_attributes", _additional_attributesBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(catalogProductEntityChildElement, catalogProductEntityBuilder, "stock_data", "stock_data")) {
                    BeanDefinitionBuilder _stock_dataBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getName());
                    Element _stock_dataChildElement = DomUtils.getChildElementByTagName(catalogProductEntityChildElement, "stock_data");
                    if (_stock_dataChildElement!= null) {
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "qty", "qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "is_in_stock", "is_in_stock");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "manage_stock", "manage_stock");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "use_config_manage_stock", "use_config_manage_stock");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "min_qty", "min_qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "use_config_min_qty", "use_config_min_qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "min_sale_qty", "min_sale_qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "use_config_min_sale_qty", "use_config_min_sale_qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "max_sale_qty", "max_sale_qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "use_config_max_sale_qty", "use_config_max_sale_qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "is_qty_decimal", "is_qty_decimal");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "backorders", "backorders");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "use_config_backorders", "use_config_backorders");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "notify_stock_qty", "notify_stock_qty");
                        parseProperty(_stock_dataBuilder, _stock_dataChildElement, "use_config_notify_stock_qty", "use_config_notify_stock_qty");
                        catalogProductEntityBuilder.addPropertyValue("stock_data", _stock_dataBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("catalogProductEntity", catalogProductEntityBuilder.getBeanDefinition());
            }
        }
        parseListAndSetProperty(element, builder, "additionalAttributes", "additional-attributes", "additional-attribute", new ParseDelegate<BeanDefinition>() {


            public BeanDefinition parse(Element element) {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AssociativeEntityExpressionHolder.class);
                parseProperty(builder, element, "key", "key");
                parseProperty(builder, element, "value", "value");
                return builder.getBeanDefinition();
            }

        }
        );
        parseProperty(builder, element, "storeViewIdOrCode", "storeViewIdOrCode");
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "password", "password");
        parseProperty(builder, element, "address", "address");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
