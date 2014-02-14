
package com.magento.api.holders;

import javax.annotation.Generated;
import com.magento.api.AssociativeEntity;
import com.magento.api.AssociativeMultiEntity;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-02-14T12:22:33-06:00", comments = "Build UNKNOWN_BUILDNUMBER")
public class CatalogProductAdditionalAttributesEntityExpressionHolder {

    protected Object multi_data;
    protected AssociativeMultiEntity[] _multi_dataType;
    protected Object single_data;
    protected AssociativeEntity[] _single_dataType;

    /**
     * Sets multi_data
     * 
     * @param value Value to set
     */
    public void setMulti_data(Object value) {
        this.multi_data = value;
    }

    /**
     * Retrieves multi_data
     * 
     */
    public Object getMulti_data() {
        return this.multi_data;
    }

    /**
     * Sets single_data
     * 
     * @param value Value to set
     */
    public void setSingle_data(Object value) {
        this.single_data = value;
    }

    /**
     * Retrieves single_data
     * 
     */
    public Object getSingle_data() {
        return this.single_data;
    }

}
