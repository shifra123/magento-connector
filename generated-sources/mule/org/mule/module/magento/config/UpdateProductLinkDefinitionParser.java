
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CatalogProductLinkEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateProductLinkMessageProcessor;
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
public class UpdateProductLinkDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateProductLinkDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateProductLinkMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-product-link] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-product-link] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateProductLink");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "type", "type");
        parseProperty(builder, element, "productId", "productId");
        parseProperty(builder, element, "productSku", "productSku");
        parseProperty(builder, element, "productIdOrSku", "productIdOrSku");
        parseProperty(builder, element, "linkedProductIdOrSku", "linkedProductIdOrSku");
        if (!parseObjectRefWithDefault(element, builder, "catalog-product-link-entity", "catalogProductLinkEntity", "#[payload]")) {
            BeanDefinitionBuilder catalogProductLinkEntityBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductLinkEntityExpressionHolder.class.getName());
            Element catalogProductLinkEntityChildElement = DomUtils.getChildElementByTagName(element, "catalog-product-link-entity");
            if (catalogProductLinkEntityChildElement!= null) {
                parseProperty(catalogProductLinkEntityBuilder, catalogProductLinkEntityChildElement, "product_id", "product_id");
                parseProperty(catalogProductLinkEntityBuilder, catalogProductLinkEntityChildElement, "type", "type");
                parseProperty(catalogProductLinkEntityBuilder, catalogProductLinkEntityChildElement, "set", "set");
                parseProperty(catalogProductLinkEntityBuilder, catalogProductLinkEntityChildElement, "sku", "sku");
                parseProperty(catalogProductLinkEntityBuilder, catalogProductLinkEntityChildElement, "position", "position");
                parseProperty(catalogProductLinkEntityBuilder, catalogProductLinkEntityChildElement, "qty", "qty");
                builder.addPropertyValue("catalogProductLinkEntity", catalogProductLinkEntityBuilder.getBeanDefinition());
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
