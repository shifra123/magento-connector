
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CatalogInventoryStockItemUpdateEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateStockItemMessageProcessor;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-28T03:10:18-05:00", comments = "Build master.1926.b0106b2")
public class UpdateStockItemDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateStockItemDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateStockItemMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-stock-item] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-stock-item] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateStockItem");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "productIdOrSku", "productIdOrSku");
        if (!parseObjectRefWithDefault(element, builder, "stock-item", "stockItem", "#[payload]")) {
            BeanDefinitionBuilder stockItemBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getName());
            Element stockItemChildElement = DomUtils.getChildElementByTagName(element, "stock-item");
            if (stockItemChildElement!= null) {
                parseProperty(stockItemBuilder, stockItemChildElement, "qty", "qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "is_in_stock", "is_in_stock");
                parseProperty(stockItemBuilder, stockItemChildElement, "manage_stock", "manage_stock");
                parseProperty(stockItemBuilder, stockItemChildElement, "use_config_manage_stock", "use_config_manage_stock");
                parseProperty(stockItemBuilder, stockItemChildElement, "min_qty", "min_qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "use_config_min_qty", "use_config_min_qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "min_sale_qty", "min_sale_qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "use_config_min_sale_qty", "use_config_min_sale_qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "max_sale_qty", "max_sale_qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "use_config_max_sale_qty", "use_config_max_sale_qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "is_qty_decimal", "is_qty_decimal");
                parseProperty(stockItemBuilder, stockItemChildElement, "backorders", "backorders");
                parseProperty(stockItemBuilder, stockItemChildElement, "use_config_backorders", "use_config_backorders");
                parseProperty(stockItemBuilder, stockItemChildElement, "notify_stock_qty", "notify_stock_qty");
                parseProperty(stockItemBuilder, stockItemChildElement, "use_config_notify_stock_qty", "use_config_notify_stock_qty");
                builder.addPropertyValue("stockItem", stockItemBuilder.getBeanDefinition());
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
