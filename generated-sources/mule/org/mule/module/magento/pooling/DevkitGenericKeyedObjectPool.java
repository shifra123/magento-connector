
package org.mule.module.magento.pooling;

import javax.annotation.Generated;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-23T03:47:06-05:00", comments = "Build master.1920.518defc")
public class DevkitGenericKeyedObjectPool
    extends GenericKeyedObjectPool
{

        public DevkitGenericKeyedObjectPool(org.apache.commons.pool.KeyedPoolableObjectFactory factory, org.mule.config.PoolingProfile connectionPoolingProfile) {
        super(factory,toConfig(connectionPoolingProfile));
    }

    private static org.apache.commons.pool.impl.GenericKeyedObjectPool.Config toConfig(org.mule.config.PoolingProfile connectionPoolingProfile) {
        org.apache.commons.pool.impl.GenericKeyedObjectPool.Config config = new org.apache.commons.pool.impl.GenericKeyedObjectPool.Config();
        if (connectionPoolingProfile!= null) {
            config.maxIdle = connectionPoolingProfile.getMaxIdle();
            config.maxActive = connectionPoolingProfile.getMaxActive();
            config.maxWait = connectionPoolingProfile.getMaxWait();
            config.whenExhaustedAction = ((byte) connectionPoolingProfile.getExhaustedAction());
            config.timeBetweenEvictionRunsMillis = connectionPoolingProfile.getEvictionCheckIntervalMillis();
            config.minEvictableIdleTimeMillis = connectionPoolingProfile.getMinEvictionMillis();
        }
        return config;
    }
}
