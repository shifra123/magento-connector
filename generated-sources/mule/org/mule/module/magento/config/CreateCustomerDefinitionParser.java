
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CustomerCustomerEntityToCreateExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.CreateCustomerMessageProcessor;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-23T03:47:06-05:00", comments = "Build master.1920.518defc")
public class CreateCustomerDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateCustomerDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateCustomerMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-customer] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-customer] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createCustomer");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        if (!parseObjectRef(element, builder, "customer", "customer")) {
            BeanDefinitionBuilder customerBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomerCustomerEntityToCreateExpressionHolder.class.getName());
            Element customerChildElement = DomUtils.getChildElementByTagName(element, "customer");
            if (customerChildElement!= null) {
                parseProperty(customerBuilder, customerChildElement, "customer_id", "customer_id");
                parseProperty(customerBuilder, customerChildElement, "email", "email");
                parseProperty(customerBuilder, customerChildElement, "firstname", "firstname");
                parseProperty(customerBuilder, customerChildElement, "lastname", "lastname");
                parseProperty(customerBuilder, customerChildElement, "password", "password");
                parseProperty(customerBuilder, customerChildElement, "website_id", "website_id");
                parseProperty(customerBuilder, customerChildElement, "store_id", "store_id");
                parseProperty(customerBuilder, customerChildElement, "group_id", "group_id");
                builder.addPropertyValue("customer", customerBuilder.getBeanDefinition());
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
