
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.CustomerAddressEntityCreate;
import com.magento.api.holders.CustomerAddressEntityCreateExpressionHolder;
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
public class CustomerAddressEntityCreateExpressionHolderTransformer
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
        return (aClass == CustomerAddressEntityCreateExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CustomerAddressEntityCreateExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CustomerAddressEntityCreateExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CustomerAddressEntityCreateExpressionHolder.class)});
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
        return CustomerAddressEntityCreate.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CustomerAddressEntityCreate.class);
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
        CustomerAddressEntityCreateExpressionHolder holder = ((CustomerAddressEntityCreateExpressionHolder) src);
        CustomerAddressEntityCreate result = new CustomerAddressEntityCreate();
        try {
            final String _transformedCity = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_cityType").getGenericType(), null, holder.getCity()));
            result.setCity(_transformedCity);
            final String _transformedCompany = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_companyType").getGenericType(), null, holder.getCompany()));
            result.setCompany(_transformedCompany);
            final String _transformedCountry_id = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_country_idType").getGenericType(), null, holder.getCountry_id()));
            result.setCountry_id(_transformedCountry_id);
            final String _transformedFax = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_faxType").getGenericType(), null, holder.getFax()));
            result.setFax(_transformedFax);
            final String _transformedFirstname = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_firstnameType").getGenericType(), null, holder.getFirstname()));
            result.setFirstname(_transformedFirstname);
            final String _transformedLastname = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_lastnameType").getGenericType(), null, holder.getLastname()));
            result.setLastname(_transformedLastname);
            final String _transformedMiddlename = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_middlenameType").getGenericType(), null, holder.getMiddlename()));
            result.setMiddlename(_transformedMiddlename);
            final String _transformedPostcode = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_postcodeType").getGenericType(), null, holder.getPostcode()));
            result.setPostcode(_transformedPostcode);
            final String _transformedPrefix = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_prefixType").getGenericType(), null, holder.getPrefix()));
            result.setPrefix(_transformedPrefix);
            final Integer _transformedRegion_id = ((Integer) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_region_idType").getGenericType(), null, holder.getRegion_id()));
            result.setRegion_id(_transformedRegion_id);
            final String _transformedRegion = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_regionType").getGenericType(), null, holder.getRegion()));
            result.setRegion(_transformedRegion);
            final String[] _transformedStreet = ((String[]) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_streetType").getGenericType(), null, holder.getStreet()));
            result.setStreet(_transformedStreet);
            final String _transformedSuffix = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_suffixType").getGenericType(), null, holder.getSuffix()));
            result.setSuffix(_transformedSuffix);
            final String _transformedTelephone = ((String) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_telephoneType").getGenericType(), null, holder.getTelephone()));
            result.setTelephone(_transformedTelephone);
            final Boolean _transformedIs_default_billing = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_is_default_billingType").getGenericType(), null, holder.getIs_default_billing()));
            result.setIs_default_billing(_transformedIs_default_billing);
            final Boolean _transformedIs_default_shipping = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomerAddressEntityCreateExpressionHolder.class.getDeclaredField("_is_default_shippingType").getGenericType(), null, holder.getIs_default_shipping()));
            result.setIs_default_shipping(_transformedIs_default_shipping);
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
