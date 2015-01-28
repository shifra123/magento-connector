/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.connection.strategy;


import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.*;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.module.magento.api.AxisPortProvider;
import org.mule.module.magento.api.DefaultAxisPortProvider;
import org.mule.module.magento.api.MagentoClientAdaptor;
import org.mule.module.magento.api.MagentoException;
import org.mule.module.magento.api.catalog.AxisMagentoCatalogClient;
import org.mule.module.magento.api.catalog.MagentoCatalogClient;
import org.mule.module.magento.api.customer.AxisMagentoInventoryClient;
import org.mule.module.magento.api.customer.MagentoInventoryClient;
import org.mule.module.magento.api.directory.AxisMagentoDirectoryClient;
import org.mule.module.magento.api.directory.MagentoDirectoryClient;
import org.mule.module.magento.api.inventory.AxisMagentoCustomerClient;
import org.mule.module.magento.api.inventory.MagentoCustomerClient;
import org.mule.module.magento.api.order.AxisMagentoOrderClient;
import org.mule.module.magento.api.order.MagentoOrderClient;
import org.mule.module.magento.api.shoppingCart.AxisMagentoShoppingCartClient;
import org.mule.module.magento.api.shoppingCart.MagentoShoppingCartClient;

@ReconnectOn(exceptions = {ConnectionException.class})
@ConnectionManagement(friendlyName = "Connection Management")
public class MagentoConnectionManagement {

    private MagentoOrderClient<MagentoException> orderClient;
    private MagentoCustomerClient<MagentoException> customerClient;
    private MagentoInventoryClient<MagentoException> inventoryClient;
    private MagentoDirectoryClient<MagentoException> directoryClient;
    private MagentoCatalogClient<MagentoException> catalogClient;
    private MagentoShoppingCartClient<MagentoException> shoppingCartClient;

    /**
     *
     */
    private String user;

    /**
     * The address to access Magento Web Services
     */
    private String serverAddress;

    /**
     * @param username The user name to access Magento Web Services
     * @param password The password to access Magento Web Services
     * @param address  The address to access Magento Web Services
     */
    @Connect
    @TestConnectivity
    public void initialiseConnector(@ConnectionKey String username, @Password String password, String address)
            throws ConnectionException {
        setUser(username);
        setServerAddress(address);
        PortProviderInitializer initializer = new PortProviderInitializer(username, password, address);
        setOrderClient(new AxisMagentoOrderClient(initializer.getPortProvider()));
        setCustomerClient(new AxisMagentoCustomerClient(initializer.getPortProvider()));
        setInventoryClient(new AxisMagentoInventoryClient(initializer.getPortProvider()));
        setDirectoryClient(new AxisMagentoDirectoryClient(initializer.getPortProvider()));
        setCatalogClient(new AxisMagentoCatalogClient(initializer.getPortProvider()));
        setShoppingCartClient(new AxisMagentoShoppingCartClient(initializer.getPortProvider()));

        //Dummy operation for connectivity testing
        try {
            catalogClient.getCatalogCurrentStoreView();
        } catch (Exception e) {
            final ConnectionException connectionException = new ConnectionException(ConnectionExceptionCode.INCORRECT_CREDENTIALS, null, e.getMessage());
            connectionException.initCause(e);
            throw connectionException;

        }
    }

    @ValidateConnection
    public boolean validateConnection() {
        return orderClient != null && customerClient != null && inventoryClient != null && directoryClient != null &&
                catalogClient != null && shoppingCartClient != null;
    }

    @Disconnect
    public void disconnect() {
        setOrderClient(null);
        setCustomerClient(null);
        setInventoryClient(null);
        setDirectoryClient(null);
        setCatalogClient(null);
        setShoppingCartClient(null);
    }

    @ConnectionIdentifier
    public String connectionId() {
        return String.format("%s-at-%s", getUser(), getServerAddress());
    }

    public void setOrderClient(MagentoOrderClient<?> magentoOrderClient) {
        this.orderClient = MagentoClientAdaptor.adapt(MagentoOrderClient.class, magentoOrderClient);
    }

    public void setCustomerClient(MagentoCustomerClient<?> customerClient) {
        this.customerClient = MagentoClientAdaptor.adapt(MagentoCustomerClient.class, customerClient);
    }

    public void setInventoryClient(MagentoInventoryClient<?> inventoryClient) {
        this.inventoryClient = MagentoClientAdaptor.adapt(MagentoInventoryClient.class, inventoryClient);
    }

    public void setDirectoryClient(MagentoDirectoryClient<?> directoryClient) {
        this.directoryClient = MagentoClientAdaptor.adapt(MagentoDirectoryClient.class, directoryClient);
    }

    public void setCatalogClient(MagentoCatalogClient<?> catalogClient) {
        this.catalogClient = MagentoClientAdaptor.adapt(MagentoCatalogClient.class, catalogClient);
    }

    public void setShoppingCartClient(MagentoShoppingCartClient<?> catalogClient) {
        this.shoppingCartClient = MagentoClientAdaptor.adapt(MagentoShoppingCartClient.class, catalogClient);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public MagentoOrderClient<MagentoException> getOrderClient() {
        return orderClient;
    }

    public MagentoCustomerClient<MagentoException> getCustomerClient() {
        return customerClient;
    }

    public MagentoInventoryClient<MagentoException> getInventoryClient() {
        return inventoryClient;
    }

    public MagentoDirectoryClient<MagentoException> getDirectoryClient() {
        return directoryClient;
    }

    public MagentoCatalogClient<MagentoException> getCatalogClient() {
        return catalogClient;
    }

    public MagentoShoppingCartClient<MagentoException> getShoppingCartClient() {
        return shoppingCartClient;
    }

    private class PortProviderInitializer {
        private DefaultAxisPortProvider provider;
        private String username;
        private String password;
        private String address;

        public PortProviderInitializer(String username, String password, String address) {
            this.username = username;
            this.password = password;
            this.address = address;
        }

        public AxisPortProvider getPortProvider() {
            if (provider == null) {
                provider = new DefaultAxisPortProvider(username, password, address);
            }
            return provider;
        }
    }
}
