
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.ShoppingCartPaymentMethodEntity;
import com.magento.api.holders.ShoppingCartPaymentMethodEntityExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-24T12:56:20-05:00", comments = "Build master.1920.518defc")
public class ShoppingCartPaymentMethodEntityExpressionHolderTransformer
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
        return (aClass == ShoppingCartPaymentMethodEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ShoppingCartPaymentMethodEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ShoppingCartPaymentMethodEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ShoppingCartPaymentMethodEntityExpressionHolder.class)});
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
        return ShoppingCartPaymentMethodEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(ShoppingCartPaymentMethodEntity.class);
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
        ShoppingCartPaymentMethodEntityExpressionHolder holder = ((ShoppingCartPaymentMethodEntityExpressionHolder) src);
        ShoppingCartPaymentMethodEntity result = new ShoppingCartPaymentMethodEntity();
        try {
            final String _transformedPo_number = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_po_numberType").getGenericType(), null, holder.getPo_number()));
            result.setPo_number(_transformedPo_number);
            final String _transformedMethod = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_methodType").getGenericType(), null, holder.getMethod()));
            result.setMethod(_transformedMethod);
            final String _transformedCc_cid = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_cc_cidType").getGenericType(), null, holder.getCc_cid()));
            result.setCc_cid(_transformedCc_cid);
            final String _transformedCc_owner = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_cc_ownerType").getGenericType(), null, holder.getCc_owner()));
            result.setCc_owner(_transformedCc_owner);
            final String _transformedCc_number = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_cc_numberType").getGenericType(), null, holder.getCc_number()));
            result.setCc_number(_transformedCc_number);
            final String _transformedCc_type = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_cc_typeType").getGenericType(), null, holder.getCc_type()));
            result.setCc_type(_transformedCc_type);
            final String _transformedCc_exp_year = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_cc_exp_yearType").getGenericType(), null, holder.getCc_exp_year()));
            result.setCc_exp_year(_transformedCc_exp_year);
            final String _transformedCc_exp_month = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartPaymentMethodEntityExpressionHolder.class.getDeclaredField("_cc_exp_monthType").getGenericType(), null, holder.getCc_exp_month()));
            result.setCc_exp_month(_transformedCc_exp_month);
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
