
package org.mule.module.magento.adapters;

import javax.annotation.Generated;
import org.mule.module.magento.MagentoCloudConnector;
import org.mule.module.magento.connection.Connection;


/**
 * A <code>MagentoCloudConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link MagentoCloudConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-15T03:23:30-05:00", comments = "Build master.1915.dd1962d")
public class MagentoCloudConnectorConnectionIdentifierAdapter
    extends MagentoCloudConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
