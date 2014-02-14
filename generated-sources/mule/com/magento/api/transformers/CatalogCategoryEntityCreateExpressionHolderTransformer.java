
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.CatalogCategoryEntityCreate;
import com.magento.api.holders.CatalogCategoryEntityCreateExpressionHolder;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-02-14T12:22:33-06:00", comments = "Build UNKNOWN_BUILDNUMBER")
public class CatalogCategoryEntityCreateExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == CatalogCategoryEntityCreateExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CatalogCategoryEntityCreateExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CatalogCategoryEntityCreateExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CatalogCategoryEntityCreateExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return CatalogCategoryEntityCreate.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CatalogCategoryEntityCreate.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        CatalogCategoryEntityCreateExpressionHolder holder = ((CatalogCategoryEntityCreateExpressionHolder) src);
        CatalogCategoryEntityCreate result = new CatalogCategoryEntityCreate();
        try {
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final Integer _transformedIs_active = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_is_activeType").getGenericType(), null, holder.getIs_active()));
            result.setIs_active(_transformedIs_active);
            final Integer _transformedPosition = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_positionType").getGenericType(), null, holder.getPosition()));
            result.setPosition(_transformedPosition);
            final String[] _transformedAvailable_sort_by = ((String[]) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_available_sort_byType").getGenericType(), null, holder.getAvailable_sort_by()));
            result.setAvailable_sort_by(_transformedAvailable_sort_by);
            final String _transformedCustom_design = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_custom_designType").getGenericType(), null, holder.getCustom_design()));
            result.setCustom_design(_transformedCustom_design);
            final Integer _transformedCustom_design_apply = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_custom_design_applyType").getGenericType(), null, holder.getCustom_design_apply()));
            result.setCustom_design_apply(_transformedCustom_design_apply);
            final String _transformedCustom_design_from = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_custom_design_fromType").getGenericType(), null, holder.getCustom_design_from()));
            result.setCustom_design_from(_transformedCustom_design_from);
            final String _transformedCustom_design_to = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_custom_design_toType").getGenericType(), null, holder.getCustom_design_to()));
            result.setCustom_design_to(_transformedCustom_design_to);
            final String _transformedCustom_layout_update = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_custom_layout_updateType").getGenericType(), null, holder.getCustom_layout_update()));
            result.setCustom_layout_update(_transformedCustom_layout_update);
            final String _transformedDefault_sort_by = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_default_sort_byType").getGenericType(), null, holder.getDefault_sort_by()));
            result.setDefault_sort_by(_transformedDefault_sort_by);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedDisplay_mode = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_display_modeType").getGenericType(), null, holder.getDisplay_mode()));
            result.setDisplay_mode(_transformedDisplay_mode);
            final Integer _transformedIs_anchor = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_is_anchorType").getGenericType(), null, holder.getIs_anchor()));
            result.setIs_anchor(_transformedIs_anchor);
            final Integer _transformedLanding_page = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_landing_pageType").getGenericType(), null, holder.getLanding_page()));
            result.setLanding_page(_transformedLanding_page);
            final String _transformedMeta_description = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_meta_descriptionType").getGenericType(), null, holder.getMeta_description()));
            result.setMeta_description(_transformedMeta_description);
            final String _transformedMeta_keywords = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_meta_keywordsType").getGenericType(), null, holder.getMeta_keywords()));
            result.setMeta_keywords(_transformedMeta_keywords);
            final String _transformedMeta_title = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_meta_titleType").getGenericType(), null, holder.getMeta_title()));
            result.setMeta_title(_transformedMeta_title);
            final String _transformedPage_layout = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_page_layoutType").getGenericType(), null, holder.getPage_layout()));
            result.setPage_layout(_transformedPage_layout);
            final String _transformedUrl_key = ((String) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_url_keyType").getGenericType(), null, holder.getUrl_key()));
            result.setUrl_key(_transformedUrl_key);
            final Integer _transformedInclude_in_menu = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogCategoryEntityCreateExpressionHolder.class.getDeclaredField("_include_in_menuType").getGenericType(), null, holder.getInclude_in_menu()));
            result.setInclude_in_menu(_transformedInclude_in_menu);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
