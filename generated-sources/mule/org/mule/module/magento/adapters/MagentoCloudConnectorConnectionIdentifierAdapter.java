
package org.mule.module.magento.adapters;

import javax.annotation.Generated;
import org.mule.module.magento.MagentoCloudConnector;
import org.mule.module.magento.connection.Connection;


/**
 * A <code>MagentoCloudConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link MagentoCloudConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-02-14T12:22:33-06:00", comments = "Build UNKNOWN_BUILDNUMBER")
public class MagentoCloudConnectorConnectionIdentifierAdapter
    extends MagentoCloudConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
