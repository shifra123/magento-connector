
package org.mule.module.magento.process;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.module.magento.adapters.MagentoCloudConnectorConnectionIdentifierAdapter;
import org.mule.module.magento.connection.ConnectionManager;
import org.mule.module.magento.connection.UnableToAcquireConnectionException;
import org.mule.module.magento.connection.UnableToReleaseConnectionException;
import org.mule.module.magento.connectivity.MagentoCloudConnectorConnectionKey;
import org.mule.module.magento.processors.ConnectivityProcessor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.0-RC1", date = "2014-05-05T03:23:13-05:00", comments = "Build master.1926.b0106b2")
public class ManagedConnectionProcessInterceptor<T >
    extends ExpressionEvaluatorSupport
    implements ProcessInterceptor<T, MagentoCloudConnectorConnectionIdentifierAdapter>
{

    private static Logger logger = LoggerFactory.getLogger(ManagedConnectionProcessInterceptor.class);
    private final ConnectionManager<MagentoCloudConnectorConnectionKey, MagentoCloudConnectorConnectionIdentifierAdapter> connectionManager;
    private final MuleContext muleContext;
    private final ProcessInterceptor<T, MagentoCloudConnectorConnectionIdentifierAdapter> next;

    public ManagedConnectionProcessInterceptor(ProcessInterceptor<T, MagentoCloudConnectorConnectionIdentifierAdapter> next, ConnectionManager<MagentoCloudConnectorConnectionKey, MagentoCloudConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        this.next = next;
        this.connectionManager = connectionManager;
        this.muleContext = muleContext;
    }

    @Override
    public T execute(ProcessCallback<T, MagentoCloudConnectorConnectionIdentifierAdapter> processCallback, MagentoCloudConnectorConnectionIdentifierAdapter object, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        MagentoCloudConnectorConnectionIdentifierAdapter connection = null;
        MagentoCloudConnectorConnectionKey key = null;
        if (hasConnectionKeysOverride(messageProcessor)) {
            ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
            final String _transformedUsername = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_usernameType"), null, connectivityProcessor.getUsername()));
            if (_transformedUsername == null) {
                throw new UnableToAcquireConnectionException("Parameter username in method initialiseConnector can't be null because is not @Optional");
            }
            final String _transformedPassword = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_passwordType"), null, connectivityProcessor.getPassword()));
            if (_transformedPassword == null) {
                throw new UnableToAcquireConnectionException("Parameter password in method initialiseConnector can't be null because is not @Optional");
            }
            final String _transformedAddress = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_addressType"), null, connectivityProcessor.getAddress()));
            if (_transformedAddress == null) {
                throw new UnableToAcquireConnectionException("Parameter address in method initialiseConnector can't be null because is not @Optional");
            }
            key = new MagentoCloudConnectorConnectionKey(_transformedUsername, _transformedPassword, _transformedAddress);
        } else {
            key = connectionManager.getEvaluatedConnectionKey(event);
        }
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(("Attempting to acquire connection using "+ key.toString()));
            }
            connection = connectionManager.acquireConnection(key);
            if (connection == null) {
                throw new UnableToAcquireConnectionException();
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug((("Connection has been acquired with [id="+ connection.getConnectionIdentifier())+"]"));
                }
            }
            return next.execute(processCallback, connection, messageProcessor, event);
        } catch (Exception e) {
            if (processCallback.getManagedExceptions()!= null) {
                for (Class exceptionClass: ((List<Class<? extends Exception>> ) processCallback.getManagedExceptions())) {
                    if (exceptionClass.isInstance(e)) {
                        if (logger.isDebugEnabled()) {
                            logger.debug((((("An exception ( "+ exceptionClass.getName())+") has been thrown. Destroying the connection with [id=")+ connection.getConnectionIdentifier())+"]"));
                        }
                        try {
                            if (connection!= null) {
                                connectionManager.destroyConnection(key, connection);
                                connection = null;
                            }
                        } catch (Exception innerException) {
                            logger.error(innerException.getMessage(), innerException);
                        }
                    }
                }
            }
            throw e;
        } finally {
            try {
                if (connection!= null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug((("Releasing the connection back into the pool [id="+ connection.getConnectionIdentifier())+"]"));
                    }
                    connectionManager.releaseConnection(key, connection);
                }
            } catch (Exception e) {
                throw new UnableToReleaseConnectionException(e);
            }
        }
    }

    /**
     * Validates that the current message processor has changed any of its connection parameters at processor level. If so, a new MagentoCloudConnectorConnectionKey must be generated
     * 
     * @param messageProcessor
     *     the message processor to test against the keys
     * @return
     *     true if any of the parameters in @Connect method annotated with @ConnectionKey was override in the XML, false otherwise  
     */
    private Boolean hasConnectionKeysOverride(MessageProcessor messageProcessor) {
        if ((messageProcessor == null)||(!(messageProcessor instanceof ConnectivityProcessor))) {
            return false;
        }
        ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
        if (connectivityProcessor.getUsername()!= null) {
            return true;
        }
        return false;
    }

    public T execute(ProcessCallback<T, MagentoCloudConnectorConnectionIdentifierAdapter> processCallback, MagentoCloudConnectorConnectionIdentifierAdapter object, Filter filter, MuleMessage message)
        throws Exception
    {
        throw new UnsupportedOperationException();
    }

}
