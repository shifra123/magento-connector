
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.CatalogInventoryStockItemUpdateEntity;
import com.magento.api.CatalogProductAdditionalAttributesEntity;
import com.magento.api.CatalogProductCreateEntity;
import com.magento.api.CatalogProductTierPriceEntity;
import com.magento.api.holders.CatalogProductCreateEntityExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-23T03:47:06-05:00", comments = "Build master.1920.518defc")
public class CatalogProductCreateEntityExpressionHolderTransformer
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
        return (aClass == CatalogProductCreateEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CatalogProductCreateEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CatalogProductCreateEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CatalogProductCreateEntityExpressionHolder.class)});
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
        return CatalogProductCreateEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CatalogProductCreateEntity.class);
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
        CatalogProductCreateEntityExpressionHolder holder = ((CatalogProductCreateEntityExpressionHolder) src);
        CatalogProductCreateEntity result = new CatalogProductCreateEntity();
        try {
            final String[] _transformedCategories = ((String[]) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_categoriesType").getGenericType(), null, holder.getCategories()));
            result.setCategories(_transformedCategories);
            final String[] _transformedWebsites = ((String[]) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_websitesType").getGenericType(), null, holder.getWebsites()));
            result.setWebsites(_transformedWebsites);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedShort_description = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_short_descriptionType").getGenericType(), null, holder.getShort_description()));
            result.setShort_description(_transformedShort_description);
            final String _transformedWeight = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_weightType").getGenericType(), null, holder.getWeight()));
            result.setWeight(_transformedWeight);
            final String _transformedStatus = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
            final String _transformedUrl_key = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_url_keyType").getGenericType(), null, holder.getUrl_key()));
            result.setUrl_key(_transformedUrl_key);
            final String _transformedUrl_path = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_url_pathType").getGenericType(), null, holder.getUrl_path()));
            result.setUrl_path(_transformedUrl_path);
            final String _transformedVisibility = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_visibilityType").getGenericType(), null, holder.getVisibility()));
            result.setVisibility(_transformedVisibility);
            final String[] _transformedCategory_ids = ((String[]) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_category_idsType").getGenericType(), null, holder.getCategory_ids()));
            result.setCategory_ids(_transformedCategory_ids);
            final String[] _transformedWebsite_ids = ((String[]) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_website_idsType").getGenericType(), null, holder.getWebsite_ids()));
            result.setWebsite_ids(_transformedWebsite_ids);
            final String _transformedHas_options = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_has_optionsType").getGenericType(), null, holder.getHas_options()));
            result.setHas_options(_transformedHas_options);
            final String _transformedGift_message_available = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_gift_message_availableType").getGenericType(), null, holder.getGift_message_available()));
            result.setGift_message_available(_transformedGift_message_available);
            final String _transformedPrice = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_priceType").getGenericType(), null, holder.getPrice()));
            result.setPrice(_transformedPrice);
            final String _transformedSpecial_price = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_special_priceType").getGenericType(), null, holder.getSpecial_price()));
            result.setSpecial_price(_transformedSpecial_price);
            final String _transformedSpecial_from_date = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_special_from_dateType").getGenericType(), null, holder.getSpecial_from_date()));
            result.setSpecial_from_date(_transformedSpecial_from_date);
            final String _transformedSpecial_to_date = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_special_to_dateType").getGenericType(), null, holder.getSpecial_to_date()));
            result.setSpecial_to_date(_transformedSpecial_to_date);
            final String _transformedTax_class_id = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_tax_class_idType").getGenericType(), null, holder.getTax_class_id()));
            result.setTax_class_id(_transformedTax_class_id);
            final CatalogProductTierPriceEntity[] _transformedTier_price = ((CatalogProductTierPriceEntity[]) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_tier_priceType").getGenericType(), null, holder.getTier_price()));
            result.setTier_price(_transformedTier_price);
            final String _transformedMeta_title = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_meta_titleType").getGenericType(), null, holder.getMeta_title()));
            result.setMeta_title(_transformedMeta_title);
            final String _transformedMeta_keyword = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_meta_keywordType").getGenericType(), null, holder.getMeta_keyword()));
            result.setMeta_keyword(_transformedMeta_keyword);
            final String _transformedMeta_description = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_meta_descriptionType").getGenericType(), null, holder.getMeta_description()));
            result.setMeta_description(_transformedMeta_description);
            final String _transformedCustom_design = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_custom_designType").getGenericType(), null, holder.getCustom_design()));
            result.setCustom_design(_transformedCustom_design);
            final String _transformedCustom_layout_update = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_custom_layout_updateType").getGenericType(), null, holder.getCustom_layout_update()));
            result.setCustom_layout_update(_transformedCustom_layout_update);
            final String _transformedOptions_container = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_options_containerType").getGenericType(), null, holder.getOptions_container()));
            result.setOptions_container(_transformedOptions_container);
            final CatalogProductAdditionalAttributesEntity _transformedAdditional_attributes = ((CatalogProductAdditionalAttributesEntity) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_additional_attributesType").getGenericType(), null, holder.getAdditional_attributes()));
            result.setAdditional_attributes(_transformedAdditional_attributes);
            final CatalogInventoryStockItemUpdateEntity _transformedStock_data = ((CatalogInventoryStockItemUpdateEntity) evaluateAndTransform(this.muleContext, event, CatalogProductCreateEntityExpressionHolder.class.getDeclaredField("_stock_dataType").getGenericType(), null, holder.getStock_data()));
            result.setStock_data(_transformedStock_data);
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
