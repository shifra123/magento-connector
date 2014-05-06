
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.ShoppingCartCustomerAddressEntityExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.SetShoppingCartCustomerAddressesMessageProcessor;
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

@Generated(value = "Mule DevKit Version 3.5.0-RC1", date = "2014-05-06T10:53:30-05:00", comments = "Build master.1926.b0106b2")
public class SetShoppingCartCustomerAddressesDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(SetShoppingCartCustomerAddressesDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(SetShoppingCartCustomerAddressesMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [set-shopping-cart-customer-addresses] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [set-shopping-cart-customer-addresses] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("setShoppingCartCustomerAddresses");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "quoteId", "quoteId");
        parseListWithDefaultAndSetProperty(element, builder, "shoppingCartCustomerAddresses", "shopping-cart-customer-addresses", "shopping-cart-customer-address", "#[payload]", new ParseDelegate<BeanDefinition>() {


            public BeanDefinition parse(Element element) {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ShoppingCartCustomerAddressEntityExpressionHolder.class);
                parseProperty(builder, element, "mode", "mode");
                parseProperty(builder, element, "address_id", "address_id");
                parseProperty(builder, element, "firstname", "firstname");
                parseProperty(builder, element, "lastname", "lastname");
                parseProperty(builder, element, "company", "company");
                parseProperty(builder, element, "street", "street");
                parseProperty(builder, element, "city", "city");
                parseProperty(builder, element, "region", "region");
                parseProperty(builder, element, "region_id", "region_id");
                parseProperty(builder, element, "postcode", "postcode");
                parseProperty(builder, element, "country_id", "country_id");
                parseProperty(builder, element, "telephone", "telephone");
                parseProperty(builder, element, "fax", "fax");
                parseProperty(builder, element, "is_default_billing", "is_default_billing");
                parseProperty(builder, element, "is_default_shipping", "is_default_shipping");
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
