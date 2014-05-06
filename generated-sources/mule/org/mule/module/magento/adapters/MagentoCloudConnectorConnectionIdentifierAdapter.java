
package org.mule.module.magento.adapters;

import javax.annotation.Generated;
import org.mule.module.magento.MagentoCloudConnector;
import org.mule.module.magento.connection.Connection;


/**
 * A <code>MagentoCloudConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link MagentoCloudConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-RC1", date = "2014-05-06T10:53:30-05:00", comments = "Build master.1926.b0106b2")
public class MagentoCloudConnectorConnectionIdentifierAdapter
    extends MagentoCloudConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
