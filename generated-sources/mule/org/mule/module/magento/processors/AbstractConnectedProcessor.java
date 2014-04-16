
package org.mule.module.magento.processors;

import java.lang.reflect.Type;
import javax.annotation.Generated;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-16T10:50:08-05:00", comments = "Build master.1915.dd1962d")
public abstract class AbstractConnectedProcessor
    extends DevkitBasedMessageProcessor
    implements ConnectivityProcessor
{

    protected Object username;
    protected String _usernameType;
    protected Object password;
    protected String _passwordType;
    protected Object address;
    protected String _addressType;

    public AbstractConnectedProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(Object value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    @Override
    public Object getUsername() {
        return this.username;
    }

    /**
     * Sets address
     * 
     * @param value Value to set
     */
    public void setAddress(Object value) {
        this.address = value;
    }

    /**
     * Retrieves address
     * 
     */
    @Override
    public Object getAddress() {
        return this.address;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(Object value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    @Override
    public Object getPassword() {
        return this.password;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public Type typeFor(String fieldName)
        throws NoSuchFieldException
    {
        return AbstractConnectedProcessor.class.getDeclaredField(fieldName).getGenericType();
    }

}
