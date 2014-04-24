
package org.mule.module.magento.processors;

import java.util.List;
import javax.annotation.Generated;
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
 * UpdateCategoryProductMessageProcessor invokes the {@link org.mule.module.magento.MagentoCloudConnector#updateCategoryProduct(int, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)} method in {@link MagentoCloudConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-24T12:56:20-05:00", comments = "Build master.1920.518defc")
public class UpdateCategoryProductMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object categoryId;
    protected int _categoryIdType;
    protected Object productId;
    protected Integer _productIdType;
    protected Object productSku;
    protected String _productSkuType;
    protected Object productIdOrSku;
    protected String _productIdOrSkuType;
    protected Object position;
    protected String _positionType;

    public UpdateCategoryProductMessageProcessor(String operationName) {
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
     * Sets position
     * 
     * @param value Value to set
     */
    public void setPosition(Object value) {
        this.position = value;
    }

    /**
     * Sets productIdOrSku
     * 
     * @param value Value to set
     */
    public void setProductIdOrSku(Object value) {
        this.productIdOrSku = value;
    }

    /**
     * Sets productSku
     * 
     * @param value Value to set
     */
    public void setProductSku(Object value) {
        this.productSku = value;
    }

    /**
     * Sets categoryId
     * 
     * @param value Value to set
     */
    public void setCategoryId(Object value) {
        this.categoryId = value;
    }

    /**
     * Sets productId
     * 
     * @param value Value to set
     */
    public void setProductId(Object value) {
        this.productId = value;
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
            final Integer _transformedCategoryId = ((Integer) evaluateAndTransform(getMuleContext(), event, UpdateCategoryProductMessageProcessor.class.getDeclaredField("_categoryIdType").getGenericType(), null, categoryId));
            final Integer _transformedProductId = ((Integer) evaluateAndTransform(getMuleContext(), event, UpdateCategoryProductMessageProcessor.class.getDeclaredField("_productIdType").getGenericType(), null, productId));
            final String _transformedProductSku = ((String) evaluateAndTransform(getMuleContext(), event, UpdateCategoryProductMessageProcessor.class.getDeclaredField("_productSkuType").getGenericType(), null, productSku));
            final String _transformedProductIdOrSku = ((String) evaluateAndTransform(getMuleContext(), event, UpdateCategoryProductMessageProcessor.class.getDeclaredField("_productIdOrSkuType").getGenericType(), null, productIdOrSku));
            final String _transformedPosition = ((String) evaluateAndTransform(getMuleContext(), event, UpdateCategoryProductMessageProcessor.class.getDeclaredField("_positionType").getGenericType(), null, position));
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
                    return ((MagentoCloudConnector) object).updateCategoryProduct(_transformedCategoryId, _transformedProductId, _transformedProductSku, _transformedProductIdOrSku, _transformedPosition);
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
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(boolean.class)));
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
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at MagentoCloudConnector at updateCategoryProduct retrieving was successful but result is null");
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
