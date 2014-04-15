
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.CatalogProductTierPriceEntity;
import com.magento.api.holders.CatalogProductTierPriceEntityExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-15T03:23:30-05:00", comments = "Build master.1915.dd1962d")
public class CatalogProductTierPriceEntityExpressionHolderTransformer
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
        return (aClass == CatalogProductTierPriceEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CatalogProductTierPriceEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CatalogProductTierPriceEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CatalogProductTierPriceEntityExpressionHolder.class)});
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
        return CatalogProductTierPriceEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CatalogProductTierPriceEntity.class);
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
        CatalogProductTierPriceEntityExpressionHolder holder = ((CatalogProductTierPriceEntityExpressionHolder) src);
        CatalogProductTierPriceEntity result = new CatalogProductTierPriceEntity();
        try {
            final String _transformedCustomer_group_id = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductTierPriceEntityExpressionHolder.class.getDeclaredField("_customer_group_idType").getGenericType(), null, holder.getCustomer_group_id()));
            result.setCustomer_group_id(_transformedCustomer_group_id);
            final String _transformedWebsite = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductTierPriceEntityExpressionHolder.class.getDeclaredField("_websiteType").getGenericType(), null, holder.getWebsite()));
            result.setWebsite(_transformedWebsite);
            final Integer _transformedQty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogProductTierPriceEntityExpressionHolder.class.getDeclaredField("_qtyType").getGenericType(), null, holder.getQty()));
            result.setQty(_transformedQty);
            final Double _transformedPrice = ((Double) evaluateAndTransform(this.muleContext, event, CatalogProductTierPriceEntityExpressionHolder.class.getDeclaredField("_priceType").getGenericType(), null, holder.getPrice()));
            result.setPrice(_transformedPrice);
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
