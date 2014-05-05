
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.ShoppingCartCustomerEntity;
import com.magento.api.holders.ShoppingCartCustomerEntityExpressionHolder;
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
public class ShoppingCartCustomerEntityExpressionHolderTransformer
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
        return (aClass == ShoppingCartCustomerEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ShoppingCartCustomerEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ShoppingCartCustomerEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ShoppingCartCustomerEntityExpressionHolder.class)});
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
        return ShoppingCartCustomerEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(ShoppingCartCustomerEntity.class);
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
        ShoppingCartCustomerEntityExpressionHolder holder = ((ShoppingCartCustomerEntityExpressionHolder) src);
        ShoppingCartCustomerEntity result = new ShoppingCartCustomerEntity();
        try {
            final String _transformedMode = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_modeType").getGenericType(), null, holder.getMode()));
            result.setMode(_transformedMode);
            final Integer _transformedCustomer_id = ((Integer) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_customer_idType").getGenericType(), null, holder.getCustomer_id()));
            result.setCustomer_id(_transformedCustomer_id);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final String _transformedFirstname = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_firstnameType").getGenericType(), null, holder.getFirstname()));
            result.setFirstname(_transformedFirstname);
            final String _transformedLastname = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_lastnameType").getGenericType(), null, holder.getLastname()));
            result.setLastname(_transformedLastname);
            final String _transformedPassword = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_passwordType").getGenericType(), null, holder.getPassword()));
            result.setPassword(_transformedPassword);
            final String _transformedConfirmation = ((String) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_confirmationType").getGenericType(), null, holder.getConfirmation()));
            result.setConfirmation(_transformedConfirmation);
            final Integer _transformedWebsite_id = ((Integer) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_website_idType").getGenericType(), null, holder.getWebsite_id()));
            result.setWebsite_id(_transformedWebsite_id);
            final Integer _transformedStore_id = ((Integer) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_store_idType").getGenericType(), null, holder.getStore_id()));
            result.setStore_id(_transformedStore_id);
            final Integer _transformedGroup_id = ((Integer) evaluateAndTransform(this.muleContext, event, ShoppingCartCustomerEntityExpressionHolder.class.getDeclaredField("_group_idType").getGenericType(), null, holder.getGroup_id()));
            result.setGroup_id(_transformedGroup_id);
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
