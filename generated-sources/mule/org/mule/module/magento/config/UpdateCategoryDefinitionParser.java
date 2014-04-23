
package org.mule.module.magento.config;

import javax.annotation.Generated;
import com.magento.api.holders.CatalogCategoryEntityCreateExpressionHolder;
import org.mule.config.MuleManifest;
import org.mule.module.magento.processors.UpdateCategoryMessageProcessor;
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
public class UpdateCategoryDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateCategoryDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateCategoryMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-category] within the connector [magento] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-category] within the connector [magento] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateCategory");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "categoryId", "categoryId");
        if (!parseObjectRefWithDefault(element, builder, "catalog-category-entity", "catalogCategoryEntity", "#[payload]")) {
            BeanDefinitionBuilder catalogCategoryEntityBuilder = BeanDefinitionBuilder.rootBeanDefinition(CatalogCategoryEntityCreateExpressionHolder.class.getName());
            Element catalogCategoryEntityChildElement = DomUtils.getChildElementByTagName(element, "catalog-category-entity");
            if (catalogCategoryEntityChildElement!= null) {
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "name", "name");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "is_active", "is_active");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "position", "position");
                if (hasAttribute(catalogCategoryEntityChildElement, "available_sort_by-ref")) {
                    if (catalogCategoryEntityChildElement.getAttribute("available_sort_by-ref").startsWith("#")) {
                        catalogCategoryEntityBuilder.addPropertyValue("available_sort_by", catalogCategoryEntityChildElement.getAttribute("available_sort_by-ref"));
                    } else {
                        catalogCategoryEntityBuilder.addPropertyValue("available_sort_by", (("#[registry:"+ catalogCategoryEntityChildElement.getAttribute("available_sort_by-ref"))+"]"));
                    }
                }
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "custom_design", "custom_design");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "custom_design_apply", "custom_design_apply");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "custom_design_from", "custom_design_from");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "custom_design_to", "custom_design_to");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "custom_layout_update", "custom_layout_update");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "default_sort_by", "default_sort_by");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "description", "description");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "display_mode", "display_mode");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "is_anchor", "is_anchor");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "landing_page", "landing_page");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "meta_description", "meta_description");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "meta_keywords", "meta_keywords");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "meta_title", "meta_title");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "page_layout", "page_layout");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "url_key", "url_key");
                parseProperty(catalogCategoryEntityBuilder, catalogCategoryEntityChildElement, "include_in_menu", "include_in_menu");
                builder.addPropertyValue("catalogCategoryEntity", catalogCategoryEntityBuilder.getBeanDefinition());
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
