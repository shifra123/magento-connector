
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.CatalogProductImageFileEntity;
import com.magento.api.holders.CatalogProductImageFileEntityExpressionHolder;
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
public class CatalogProductImageFileEntityExpressionHolderTransformer
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
        return (aClass == CatalogProductImageFileEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CatalogProductImageFileEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CatalogProductImageFileEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CatalogProductImageFileEntityExpressionHolder.class)});
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
        return CatalogProductImageFileEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CatalogProductImageFileEntity.class);
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
        CatalogProductImageFileEntityExpressionHolder holder = ((CatalogProductImageFileEntityExpressionHolder) src);
        CatalogProductImageFileEntity result = new CatalogProductImageFileEntity();
        try {
            final String _transformedContent = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductImageFileEntityExpressionHolder.class.getDeclaredField("_contentType").getGenericType(), null, holder.getContent()));
            result.setContent(_transformedContent);
            final String _transformedMime = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductImageFileEntityExpressionHolder.class.getDeclaredField("_mimeType").getGenericType(), null, holder.getMime()));
            result.setMime(_transformedMime);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductImageFileEntityExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
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
