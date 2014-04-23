
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.AssociativeEntityExpressionHolder;
import com.magento.api.holders.CatalogInventoryStockItemUpdateEntityExpressionHolder;
import com.magento.api.holders.CatalogProductAdditionalAttributesEntityExpressionHolder;
import com.magento.api.holders.CatalogProductCreateEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.CreateProductMessageProcessor;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-23T03:47:06-05:00", comments = "Build master.1920.518defc")
public class CreateProductDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateProductDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateProductMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-product] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-product] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createProduct");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "type", "type");
        parseProperty(builder, element, "set", "set");
        parseProperty(builder, element, "sku", "sku");
        if (!parseObjectRefWithDefault(element, builder, "attributes", "attributes", "#[payload]")) {
            BeanDefinitionBuilder attributesBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductCreateEntityExpressionHolder.class.getName());
            Element attributesChildElement = DomUtils.getChildElementByTagName(element, "attributes");
            if (attributesChildElement!= null) {
                if (hasAttribute(attributesChildElement, "categories-ref")) {
                    if (attributesChildElement.getAttribute("categories-ref").startsWith("#")) {
                        attributesBuilder.addPropertyValue("categories", attributesChildElement.getAttribute("categories-ref"));
                    } else {
                        attributesBuilder.addPropertyValue("categories", (("#[registry:"+ attributesChildElement.getAttribute("categories-ref"))+"]"));
                    }
                }
                if (hasAttribute(attributesChildElement, "websites-ref")) {
                    if (attributesChildElement.getAttribute("websites-ref").startsWith("#")) {
                        attributesBuilder.addPropertyValue("websites", attributesChildElement.getAttribute("websites-ref"));
                    } else {
                        attributesBuilder.addPropertyValue("websites", (("#[registry:"+ attributesChildElement.getAttribute("websites-ref"))+"]"));
                    }
                }
                parseProperty(attributesBuilder, attributesChildElement, "name", "name");
                parseProperty(attributesBuilder, attributesChildElement, "description", "description");
                parseProperty(attributesBuilder, attributesChildElement, "short_description", "short_description");
                parseProperty(attributesBuilder, attributesChildElement, "weight", "weight");
                parseProperty(attributesBuilder, attributesChildElement, "status", "status");
                parseProperty(attributesBuilder, attributesChildElement, "url_key", "url_key");
                parseProperty(attributesBuilder, attributesChildElement, "url_path", "url_path");
                parseProperty(attributesBuilder, attributesChildElement, "visibility", "visibility");
                if (hasAttribute(attributesChildElement, "category_ids-ref")) {
                    if (attributesChildElement.getAttribute("category_ids-ref").startsWith("#")) {
                        attributesBuilder.addPropertyValue("category_ids", attributesChildElement.getAttribute("category_ids-ref"));
                    } else {
                        attributesBuilder.addPropertyValue("category_ids", (("#[registry:"+ attributesChildElement.getAttribute("category_ids-ref"))+"]"));
                    }
                }
                if (hasAttribute(attributesChildElement, "website_ids-ref")) {
                    if (attributesChildElement.getAttribute("website_ids-ref").startsWith("#")) {
                        attributesBuilder.addPropertyValue("website_ids", attributesChildElement.getAttribute("website_ids-ref"));
                    } else {
                        attributesBuilder.addPropertyValue("website_ids", (("#[registry:"+ attributesChildElement.getAttribute("website_ids-ref"))+"]"));
                    }
                }
                parseProperty(attributesBuilder, attributesChildElement, "has_options", "has_options");
                parseProperty(attributesBuilder, attributesChildElement, "gift_message_available", "gift_message_available");
                parseProperty(attributesBuilder, attributesChildElement, "price", "price");
                parseProperty(attributesBuilder, attributesChildElement, "special_price", "special_price");
                parseProperty(attributesBuilder, attributesChildElement, "special_from_date", "special_from_date");
                parseProperty(attributesBuilder, attributesChildElement, "special_to_date", "special_to_date");
                parseProperty(attributesBuilder, attributesChildElement, "tax_class_id", "tax_class_id");
                if (hasAttribute(attributesChildElement, "tier_price-ref")) {
                    if (attributesChildElement.getAttribute("tier_price-ref").startsWith("#")) {
                        attributesBuilder.addPropertyValue("tier_price", attributesChildElement.getAttribute("tier_price-ref"));
                    } else {
                        attributesBuilder.addPropertyValue("tier_price", (("#[registry:"+ attributesChildElement.getAttribute("tier_price-ref"))+"]"));
                    }
                }
                parseProperty(attributesBuilder, attributesChildElement, "meta_title", "meta_title");
                parseProperty(attributesBuilder, attributesChildElement, "meta_keyword", "meta_keyword");
                parseProperty(attributesBuilder, attributesChildElement, "meta_description", "meta_description");
                parseProperty(attributesBuilder, attributesChildElement, "custom_design", "custom_design");
                parseProperty(attributesBuilder, attributesChildElement, "custom_layout_update", "custom_layout_update");
                parseProperty(attributesBuilder, attributesChildElement, "options_container", "options_container");
                if (!parseObjectRef(attributesChildElement, attributesBuilder, "additional_attributes", "additional_attributes")) {
                    BeanDefinitionBuilder _additional_attributesBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductAdditionalAttributesEntityExpressionHolder.class.getName());
                    Element _additional_attributesChildElement = DomUtils.getChildElementByTagName(attributesChildElement, "additional_attributes");
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
                        attributesBuilder.addPropertyValue("additional_attributes", _additional_attributesBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(attributesChildElement, attributesBuilder, "stock_data", "stock_data")) {
                    BeanDefinitionBuilder _stock_dataBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getName());
                    Element _stock_dataChildElement = DomUtils.getChildElementByTagName(attributesChildElement, "stock_data");
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
                        attributesBuilder.addPropertyValue("stock_data", _stock_dataBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("attributes", attributesBuilder.getBeanDefinition());
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
