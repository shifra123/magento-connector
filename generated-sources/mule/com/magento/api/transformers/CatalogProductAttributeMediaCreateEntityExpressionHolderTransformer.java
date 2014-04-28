
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.CatalogProductAttributeMediaCreateEntity;
import com.magento.api.CatalogProductImageFileEntity;
import com.magento.api.holders.CatalogProductAttributeMediaCreateEntityExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-28T03:10:18-05:00", comments = "Build master.1926.b0106b2")
public class CatalogProductAttributeMediaCreateEntityExpressionHolderTransformer
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
        return (aClass == CatalogProductAttributeMediaCreateEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CatalogProductAttributeMediaCreateEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CatalogProductAttributeMediaCreateEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CatalogProductAttributeMediaCreateEntityExpressionHolder.class)});
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
        return CatalogProductAttributeMediaCreateEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CatalogProductAttributeMediaCreateEntity.class);
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
        CatalogProductAttributeMediaCreateEntityExpressionHolder holder = ((CatalogProductAttributeMediaCreateEntityExpressionHolder) src);
        CatalogProductAttributeMediaCreateEntity result = new CatalogProductAttributeMediaCreateEntity();
        try {
            final CatalogProductImageFileEntity _transformedFile = ((CatalogProductImageFileEntity) evaluateAndTransform(this.muleContext, event, CatalogProductAttributeMediaCreateEntityExpressionHolder.class.getDeclaredField("_fileType").getGenericType(), null, holder.getFile()));
            result.setFile(_transformedFile);
            final String _transformedLabel = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductAttributeMediaCreateEntityExpressionHolder.class.getDeclaredField("_labelType").getGenericType(), null, holder.getLabel()));
            result.setLabel(_transformedLabel);
            final String _transformedPosition = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductAttributeMediaCreateEntityExpressionHolder.class.getDeclaredField("_positionType").getGenericType(), null, holder.getPosition()));
            result.setPosition(_transformedPosition);
            final String[] _transformedTypes = ((String[]) evaluateAndTransform(this.muleContext, event, CatalogProductAttributeMediaCreateEntityExpressionHolder.class.getDeclaredField("_typesType").getGenericType(), null, holder.getTypes()));
            result.setTypes(_transformedTypes);
            final String _transformedExclude = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductAttributeMediaCreateEntityExpressionHolder.class.getDeclaredField("_excludeType").getGenericType(), null, holder.getExclude()));
            result.setExclude(_transformedExclude);
            final String _transformedRemove = ((String) evaluateAndTransform(this.muleContext, event, CatalogProductAttributeMediaCreateEntityExpressionHolder.class.getDeclaredField("_removeType").getGenericType(), null, holder.getRemove()));
            result.setRemove(_transformedRemove);
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
