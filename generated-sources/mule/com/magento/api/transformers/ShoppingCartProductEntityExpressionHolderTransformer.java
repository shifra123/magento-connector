
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.AssociativeEntity;
import com.magento.api.ShoppingCartProductEntity;
import com.magento.api.holders.ShoppingCartProductEntityExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.5.0-RC1", date = "2014-05-05T03:23:13-05:00", comments = "Build master.1926.b0106b2")
public class ShoppingCartProductEntityExpressionHolderTransformer
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
        return (aClass == ShoppingCartProductEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ShoppingCartProductEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ShoppingCartProductEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ShoppingCartProductEntityExpressionHolder.class)});
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
        return ShoppingCartProductEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(ShoppingCartProductEntity.class);
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
        ShoppingCartProductEntityExpressionHolder holder = ((ShoppingCartProductEntityExpressionHolder) src);
        ShoppingCartProductEntity result = new ShoppingCartProductEntity();
        try {
            final String _transformedProduct_id = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartProductEntityExpressionHolder.class.getDeclaredField("_product_idType").getGenericType(), null, holder.getProduct_id()));
            result.setProduct_id(_transformedProduct_id);
            final String _transformedSku = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartProductEntityExpressionHolder.class.getDeclaredField("_skuType").getGenericType(), null, holder.getSku()));
            result.setSku(_transformedSku);
            final Double _transformedQty = ((Double) evaluateAndTransform(this.muleContext, event, ShoppingCartProductEntityExpressionHolder.class.getDeclaredField("_qtyType").getGenericType(), null, holder.getQty()));
            result.setQty(_transformedQty);
            final AssociativeEntity[] _transformedOptions = ((AssociativeEntity[]) evaluateAndTransform(this.muleContext, event, ShoppingCartProductEntityExpressionHolder.class.getDeclaredField("_optionsType").getGenericType(), null, holder.getOptions()));
            result.setOptions(_transformedOptions);
            final AssociativeEntity[] _transformedBundle_option = ((AssociativeEntity[]) evaluateAndTransform(this.muleContext, event, ShoppingCartProductEntityExpressionHolder.class.getDeclaredField("_bundle_optionType").getGenericType(), null, holder.getBundle_option()));
            result.setBundle_option(_transformedBundle_option);
            final AssociativeEntity[] _transformedBundle_option_qty = ((AssociativeEntity[]) evaluateAndTransform(this.muleContext, event, ShoppingCartProductEntityExpressionHolder.class.getDeclaredField("_bundle_option_qtyType").getGenericType(), null, holder.getBundle_option_qty()));
            result.setBundle_option_qty(_transformedBundle_option_qty);
            final String[] _transformedLinks = ((String[]) evaluateAndTransform(this.muleContext, event, ShoppingCartProductEntityExpressionHolder.class.getDeclaredField("_linksType").getGenericType(), null, holder.getLinks()));
            result.setLinks(_transformedLinks);
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
