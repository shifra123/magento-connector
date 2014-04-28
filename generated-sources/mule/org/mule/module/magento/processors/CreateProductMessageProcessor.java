
package org.mule.module.magento.processors;

import java.util.List;
import javax.annotation.Generated;
import com.magento.api.AssociativeEntity;
import com.magento.api.CatalogProductCreateEntity;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.module.magento.MagentoCloudConnector;
import org.mule.module.magento.connectivity.MagentoCloudConnectorConnectionManager;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * CreateProductMessageProcessor invokes the {@link org.mule.module.magento.MagentoCloudConnector#createProduct(java.lang.String, int, java.lang.String, com.magento.api.CatalogProductCreateEntity, java.util.List, java.lang.String)} method in {@link MagentoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-28T03:10:18-05:00", comments = "Build master.1926.b0106b2")
public class CreateProductMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object type;
    protected String _typeType;
    protected Object set;
    protected int _setType;
    protected Object sku;
    protected String _skuType;
    protected Object attributes;
    protected CatalogProductCreateEntity _attributesType;
    protected Object additionalAttributes;
    protected List<AssociativeEntity> _additionalAttributesType;
    protected Object storeViewIdOrCode;
    protected String _storeViewIdOrCodeType;

    public CreateProductMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets additionalAttributes
     * 
     * @param value Value to set
     */
    public void setAdditionalAttributes(Object value) {
        this.additionalAttributes = value;
    }

    /**
     * Sets set
     * 
     * @param value Value to set
     */
    public void setSet(Object value) {
        this.set = value;
    }

    /**
     * Sets storeViewIdOrCode
     * 
     * @param value Value to set
     */
    public void setStoreViewIdOrCode(Object value) {
        this.storeViewIdOrCode = value;
    }

    /**
     * Sets attributes
     * 
     * @param value Value to set
     */
    public void setAttributes(Object value) {
        this.attributes = value;
    }

    /**
     * Sets sku
     * 
     * @param value Value to set
     */
    public void setSku(Object value) {
        this.sku = value;
    }

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(MagentoCloudConnectorConnectionManager.class, true, event);
            final String _transformedType = ((String) evaluateAndTransform(getMuleContext(), event, CreateProductMessageProcessor.class.getDeclaredField("_typeType").getGenericType(), null, type));
            final Integer _transformedSet = ((Integer) evaluateAndTransform(getMuleContext(), event, CreateProductMessageProcessor.class.getDeclaredField("_setType").getGenericType(), null, set));
            final String _transformedSku = ((String) evaluateAndTransform(getMuleContext(), event, CreateProductMessageProcessor.class.getDeclaredField("_skuType").getGenericType(), null, sku));
            final CatalogProductCreateEntity _transformedAttributes = ((CatalogProductCreateEntity) evaluateAndTransform(getMuleContext(), event, CreateProductMessageProcessor.class.getDeclaredField("_attributesType").getGenericType(), null, attributes));
            final List<AssociativeEntity> _transformedAdditionalAttributes = ((List<AssociativeEntity> ) evaluateAndTransform(getMuleContext(), event, CreateProductMessageProcessor.class.getDeclaredField("_additionalAttributesType").getGenericType(), null, additionalAttributes));
            final String _transformedStoreViewIdOrCode = ((String) evaluateAndTransform(getMuleContext(), event, CreateProductMessageProcessor.class.getDeclaredField("_storeViewIdOrCodeType").getGenericType(), null, storeViewIdOrCode));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((MagentoCloudConnector) object).createProduct(_transformedType, _transformedSet, _transformedSku, _transformedAttributes, _transformedAdditionalAttributes, _transformedStoreViewIdOrCode);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(CatalogProductCreateEntity.class)));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(int.class)));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(MagentoCloudConnectorConnectionManager.class, true, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at MagentoCloudConnector at createProduct retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}
