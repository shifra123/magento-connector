
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CustomerAddressEntityCreateExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.CreateCustomerAddressMessageProcessor;
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
public class CreateCustomerAddressDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateCustomerAddressDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateCustomerAddressMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-customer-address] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-customer-address] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createCustomerAddress");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "customerId", "customerId");
        if (!parseObjectRefWithDefault(element, builder, "customer-address", "customerAddress", "#[payload]")) {
            BeanDefinitionBuilder customerAddressBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomerAddressEntityCreateExpressionHolder.class.getName());
            Element customerAddressChildElement = DomUtils.getChildElementByTagName(element, "customer-address");
            if (customerAddressChildElement!= null) {
                parseProperty(customerAddressBuilder, customerAddressChildElement, "city", "city");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "company", "company");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "country_id", "country_id");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "fax", "fax");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "firstname", "firstname");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "lastname", "lastname");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "middlename", "middlename");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "postcode", "postcode");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "prefix", "prefix");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "region_id", "region_id");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "region", "region");
                if (hasAttribute(customerAddressChildElement, "street-ref")) {
                    if (customerAddressChildElement.getAttribute("street-ref").startsWith("#")) {
                        customerAddressBuilder.addPropertyValue("street", customerAddressChildElement.getAttribute("street-ref"));
                    } else {
                        customerAddressBuilder.addPropertyValue("street", (("#[registry:"+ customerAddressChildElement.getAttribute("street-ref"))+"]"));
                    }
                }
                parseProperty(customerAddressBuilder, customerAddressChildElement, "suffix", "suffix");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "telephone", "telephone");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "is_default_billing", "is_default_billing");
                parseProperty(customerAddressBuilder, customerAddressChildElement, "is_default_shipping", "is_default_shipping");
                builder.addPropertyValue("customerAddress", customerAddressBuilder.getBeanDefinition());
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
