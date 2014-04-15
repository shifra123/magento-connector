
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.ShoppingCartPaymentMethodEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.SetShoppingCartPaymentMethodMessageProcessor;
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
public class SetShoppingCartPaymentMethodDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(SetShoppingCartPaymentMethodDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(SetShoppingCartPaymentMethodMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [set-shopping-cart-payment-method] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [set-shopping-cart-payment-method] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("setShoppingCartPaymentMethod");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "quoteId", "quoteId");
        if (!parseObjectRefWithDefault(element, builder, "shopping-cart-payment-method", "shoppingCartPaymentMethod", "#[payload]")) {
            BeanDefinitionBuilder shoppingCartPaymentMethodBuilder = BeanDefinitionBuilder.rootBeanDefinition(ShoppingCartPaymentMethodEntityExpressionHolder.class.getName());
            Element shoppingCartPaymentMethodChildElement = DomUtils.getChildElementByTagName(element, "shopping-cart-payment-method");
            if (shoppingCartPaymentMethodChildElement!= null) {
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "po_number", "po_number");
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "method", "method");
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "cc_cid", "cc_cid");
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "cc_owner", "cc_owner");
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "cc_number", "cc_number");
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "cc_type", "cc_type");
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "cc_exp_year", "cc_exp_year");
                parseProperty(shoppingCartPaymentMethodBuilder, shoppingCartPaymentMethodChildElement, "cc_exp_month", "cc_exp_month");
                builder.addPropertyValue("shoppingCartPaymentMethod", shoppingCartPaymentMethodBuilder.getBeanDefinition());
            }
        }
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
