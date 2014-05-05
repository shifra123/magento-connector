
package com.magento.api.holders;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.5.0-RC1", date = "2014-05-05T03:23:13-05:00", comments = "Build master.1926.b0106b2")
public class OrderItemIdQtyExpressionHolder {

    protected Object order_item_id;
    protected int _order_item_idType;
    protected Object qty;
    protected double _qtyType;

    /**
     * Sets order_item_id
     * 
     * @param value Value to set
     */
    public void setOrder_item_id(Object value) {
        this.order_item_id = value;
    }

    /**
     * Retrieves order_item_id
     * 
     */
    public Object getOrder_item_id() {
        return this.order_item_id;
    }

    /**
     * Sets qty
     * 
     * @param value Value to set
     */
    public void setQty(Object value) {
        this.qty = value;
    }

    /**
     * Retrieves qty
     * 
     */
    public Object getQty() {
        return this.qty;
    }

}
