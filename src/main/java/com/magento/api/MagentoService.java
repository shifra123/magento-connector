/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

/**
 * MagentoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.magento.api;

public interface MagentoService extends javax.xml.rpc.Service {
    public java.lang.String getMage_Api_Model_Server_V2_HandlerPortAddress();

    public com.magento.api.Mage_Api_Model_Server_V2_HandlerPortType getMage_Api_Model_Server_V2_HandlerPort() throws javax.xml.rpc.ServiceException;

    public com.magento.api.Mage_Api_Model_Server_V2_HandlerPortType getMage_Api_Model_Server_V2_HandlerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
