
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CatalogProductTierPriceEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateProductAttributeTierPriceMessageProcessor;
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

@Generated(value = "Mule DevKit Version 3.5.0-RC1", date = "2014-05-06T10:53:30-05:00", comments = "Build master.1926.b0106b2")
public class UpdateProductAttributeTierPriceDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateProductAttributeTierPriceDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateProductAttributeTierPriceMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-product-attribute-tier-price] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-product-attribute-tier-price] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateProductAttributeTierPrice");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "productId", "productId");
        parseProperty(builder, element, "productSku", "productSku");
        parseProperty(builder, element, "productIdOrSku", "productIdOrSku");
        if (!parseObjectRefWithDefault(element, builder, "catalog-product-tier-price-entity", "catalogProductTierPriceEntity", "#[payload]")) {
            BeanDefinitionBuilder catalogProductTierPriceEntityBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductTierPriceEntityExpressionHolder.class.getName());
            Element catalogProductTierPriceEntityChildElement = DomUtils.getChildElementByTagName(element, "catalog-product-tier-price-entity");
            if (catalogProductTierPriceEntityChildElement!= null) {
                parseProperty(catalogProductTierPriceEntityBuilder, catalogProductTierPriceEntityChildElement, "customer_group_id", "customer_group_id");
                parseProperty(catalogProductTierPriceEntityBuilder, catalogProductTierPriceEntityChildElement, "website", "website");
                parseProperty(catalogProductTierPriceEntityBuilder, catalogProductTierPriceEntityChildElement, "qty", "qty");
                parseProperty(catalogProductTierPriceEntityBuilder, catalogProductTierPriceEntityChildElement, "price", "price");
                builder.addPropertyValue("catalogProductTierPriceEntity", catalogProductTierPriceEntityBuilder.getBeanDefinition());
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
