
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.ShoppingCartProductEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateShoppingCartProductMessageProcessor;
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
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-23T03:47:06-05:00", comments = "Build master.1920.518defc")
public class UpdateShoppingCartProductDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateShoppingCartProductDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateShoppingCartProductMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-shopping-cart-product] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-shopping-cart-product] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateShoppingCartProduct");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "quoteId", "quoteId");
        parseListWithDefaultAndSetProperty(element, builder, "products", "products", "product", "#[payload]", new ParseDelegate<BeanDefinition>() {


            public BeanDefinition parse(Element element) {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ShoppingCartProductEntityExpressionHolder.class);
                parseProperty(builder, element, "product_id", "product_id");
                parseProperty(builder, element, "sku", "sku");
                parseProperty(builder, element, "qty", "qty");
                if (hasAttribute(element, "options-ref")) {
                    if (element.getAttribute("options-ref").startsWith("#")) {
                        builder.addPropertyValue("options", element.getAttribute("options-ref"));
                    } else {
                        builder.addPropertyValue("options", (("#[registry:"+ element.getAttribute("options-ref"))+"]"));
                    }
                }
                if (hasAttribute(element, "bundle_option-ref")) {
                    if (element.getAttribute("bundle_option-ref").startsWith("#")) {
                        builder.addPropertyValue("bundle_option", element.getAttribute("bundle_option-ref"));
                    } else {
                        builder.addPropertyValue("bundle_option", (("#[registry:"+ element.getAttribute("bundle_option-ref"))+"]"));
                    }
                }
                if (hasAttribute(element, "bundle_option_qty-ref")) {
                    if (element.getAttribute("bundle_option_qty-ref").startsWith("#")) {
                        builder.addPropertyValue("bundle_option_qty", element.getAttribute("bundle_option_qty-ref"));
                    } else {
                        builder.addPropertyValue("bundle_option_qty", (("#[registry:"+ element.getAttribute("bundle_option_qty-ref"))+"]"));
                    }
                }
                if (hasAttribute(element, "links-ref")) {
                    if (element.getAttribute("links-ref").startsWith("#")) {
                        builder.addPropertyValue("links", element.getAttribute("links-ref"));
                    } else {
                        builder.addPropertyValue("links", (("#[registry:"+ element.getAttribute("links-ref"))+"]"));
                    }
                }
                return builder.getBeanDefinition();
            }

        }
        );
        parseProperty(builder, element, "storeId", "storeId");
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "password", "password");
        parseProperty(builder, element, "address", "address");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
