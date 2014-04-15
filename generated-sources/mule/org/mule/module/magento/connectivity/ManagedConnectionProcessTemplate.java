
package org.mule.module.magento.connectivity;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.module.magento.adapters.MagentoCloudConnectorConnectionIdentifierAdapter;
import org.mule.module.magento.connection.ConnectionManager;
import org.mule.module.magento.process.ManagedConnectionProcessInterceptor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.process.ProcessCallbackProcessInterceptor;
import org.mule.security.oauth.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-15T03:23:30-05:00", comments = "Build master.1915.dd1962d")
public class ManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, MagentoCloudConnectorConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, MagentoCloudConnectorConnectionIdentifierAdapter> processInterceptor;

    public ManagedConnectionProcessTemplate(ConnectionManager<MagentoCloudConnectorConnectionKey, MagentoCloudConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, MagentoCloudConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, MagentoCloudConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, MagentoCloudConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new ManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, MagentoCloudConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, MagentoCloudConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, MagentoCloudConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, MagentoCloudConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
