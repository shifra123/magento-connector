
package com.magento.api.holders;

import javax.annotation.Generated;
import com.magento.api.AssociativeEntity;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-24T12:56:20-05:00", comments = "Build master.1920.518defc")
public class ShoppingCartProductEntityExpressionHolder {

    protected Object product_id;
    protected String _product_idType;
    protected Object sku;
    protected String _skuType;
    protected Object qty;
    protected Double _qtyType;
    protected Object options;
    protected AssociativeEntity[] _optionsType;
    protected Object bundle_option;
    protected AssociativeEntity[] _bundle_optionType;
    protected Object bundle_option_qty;
    protected AssociativeEntity[] _bundle_option_qtyType;
    protected Object links;
    protected String[] _linksType;

    /**
     * Sets product_id
     * 
     * @param value Value to set
     */
    public void setProduct_id(Object value) {
        this.product_id = value;
    }

    /**
     * Retrieves product_id
     * 
     */
    public Object getProduct_id() {
        return this.product_id;
    }

    /**
     * Sets sku
     * 
     * @param value Value to set
     */
    public void setSku(Object value) {
        this.sku = value;
    }

    /**
     * Retrieves sku
     * 
     */
    public Object getSku() {
        return this.sku;
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

    /**
     * Sets options
     * 
     * @param value Value to set
     */
    public void setOptions(Object value) {
        this.options = value;
    }

    /**
     * Retrieves options
     * 
     */
    public Object getOptions() {
        return this.options;
    }

    /**
     * Sets bundle_option
     * 
     * @param value Value to set
     */
    public void setBundle_option(Object value) {
        this.bundle_option = value;
    }

    /**
     * Retrieves bundle_option
     * 
     */
    public Object getBundle_option() {
        return this.bundle_option;
    }

    /**
     * Sets bundle_option_qty
     * 
     * @param value Value to set
     */
    public void setBundle_option_qty(Object value) {
        this.bundle_option_qty = value;
    }

    /**
     * Retrieves bundle_option_qty
     * 
     */
    public Object getBundle_option_qty() {
        return this.bundle_option_qty;
    }

    /**
     * Sets links
     * 
     * @param value Value to set
     */
    public void setLinks(Object value) {
        this.links = value;
    }

    /**
     * Retrieves links
     * 
     */
    public Object getLinks() {
        return this.links;
    }

}
