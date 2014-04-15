
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CatalogInventoryStockItemUpdateEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateInventoryStockItemMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-15T03:23:30-05:00", comments = "Build master.1915.dd1962d")
public class UpdateInventoryStockItemDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateInventoryStockItemDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateInventoryStockItemMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-inventory-stock-item] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-inventory-stock-item] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateInventoryStockItem");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "productId", "productId");
        parseProperty(builder, element, "productSku", "productSku");
        parseProperty(builder, element, "productIdOrSku", "productIdOrSku");
        if (!parseObjectRefWithDefault(element, builder, "catalog-inventory-stock-item", "catalogInventoryStockItem", "#[payload]")) {
            BeanDefinitionBuilder catalogInventoryStockItemBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getName());
            Element catalogInventoryStockItemChildElement = DomUtils.getChildElementByTagName(element, "catalog-inventory-stock-item");
            if (catalogInventoryStockItemChildElement!= null) {
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "qty", "qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "is_in_stock", "is_in_stock");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "manage_stock", "manage_stock");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "use_config_manage_stock", "use_config_manage_stock");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "min_qty", "min_qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "use_config_min_qty", "use_config_min_qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "min_sale_qty", "min_sale_qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "use_config_min_sale_qty", "use_config_min_sale_qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "max_sale_qty", "max_sale_qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "use_config_max_sale_qty", "use_config_max_sale_qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "is_qty_decimal", "is_qty_decimal");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "backorders", "backorders");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "use_config_backorders", "use_config_backorders");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "notify_stock_qty", "notify_stock_qty");
                parseProperty(catalogInventoryStockItemBuilder, catalogInventoryStockItemChildElement, "use_config_notify_stock_qty", "use_config_notify_stock_qty");
                builder.addPropertyValue("catalogInventoryStockItem", catalogInventoryStockItemBuilder.getBeanDefinition());
            }
        }
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "password", "password");
        parseProperty(builder, element, "address", "address");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
