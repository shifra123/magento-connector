
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CatalogProductAttributeMediaCreateEntityExpressionHolder;
import com.magento.api.holders.CatalogProductImageFileEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateProductAttributeMediaMessageProcessor;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-23T03:07:34-05:00", comments = "Build master.1920.518defc")
public class UpdateProductAttributeMediaDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateProductAttributeMediaDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateProductAttributeMediaMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-product-attribute-media] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-product-attribute-media] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateProductAttributeMedia");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "productId", "productId");
        parseProperty(builder, element, "productSku", "productSku");
        parseProperty(builder, element, "productIdOrSku", "productIdOrSku");
        parseProperty(builder, element, "fileName", "fileName");
        if (!parseObjectRefWithDefault(element, builder, "catalog-product-attribute-media-entity", "catalogProductAttributeMediaEntity", "#[payload]")) {
            BeanDefinitionBuilder catalogProductAttributeMediaEntityBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductAttributeMediaCreateEntityExpressionHolder.class.getName());
            Element catalogProductAttributeMediaEntityChildElement = DomUtils.getChildElementByTagName(element, "catalog-product-attribute-media-entity");
            if (catalogProductAttributeMediaEntityChildElement!= null) {
                if (!parseObjectRef(catalogProductAttributeMediaEntityChildElement, catalogProductAttributeMediaEntityBuilder, "file", "file")) {
                    BeanDefinitionBuilder _fileBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogProductImageFileEntityExpressionHolder.class.getName());
                    Element _fileChildElement = DomUtils.getChildElementByTagName(catalogProductAttributeMediaEntityChildElement, "file");
                    if (_fileChildElement!= null) {
                        parseProperty(_fileBuilder, _fileChildElement, "content", "content");
                        parseProperty(_fileBuilder, _fileChildElement, "mime", "mime");
                        parseProperty(_fileBuilder, _fileChildElement, "name", "name");
                        catalogProductAttributeMediaEntityBuilder.addPropertyValue("file", _fileBuilder.getBeanDefinition());
                    }
                }
                parseProperty(catalogProductAttributeMediaEntityBuilder, catalogProductAttributeMediaEntityChildElement, "label", "label");
                parseProperty(catalogProductAttributeMediaEntityBuilder, catalogProductAttributeMediaEntityChildElement, "position", "position");
                if (hasAttribute(catalogProductAttributeMediaEntityChildElement, "types-ref")) {
                    if (catalogProductAttributeMediaEntityChildElement.getAttribute("types-ref").startsWith("#")) {
                        catalogProductAttributeMediaEntityBuilder.addPropertyValue("types", catalogProductAttributeMediaEntityChildElement.getAttribute("types-ref"));
                    } else {
                        catalogProductAttributeMediaEntityBuilder.addPropertyValue("types", (("#[registry:"+ catalogProductAttributeMediaEntityChildElement.getAttribute("types-ref"))+"]"));
                    }
                }
                parseProperty(catalogProductAttributeMediaEntityBuilder, catalogProductAttributeMediaEntityChildElement, "exclude", "exclude");
                parseProperty(catalogProductAttributeMediaEntityBuilder, catalogProductAttributeMediaEntityChildElement, "remove", "remove");
                builder.addPropertyValue("catalogProductAttributeMediaEntity", catalogProductAttributeMediaEntityBuilder.getBeanDefinition());
            }
        }
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
