/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.api.inventory;

import com.magento.api.*;
import org.apache.commons.lang.Validate;
import org.mule.module.magento.api.AbstractMagentoClient;
import org.mule.module.magento.api.AxisPortProvider;

import javax.validation.constraints.NotNull;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import static org.mule.module.magento.filters.FiltersParser.parse;

public class AxisMagentoCustomerClient extends AbstractMagentoClient
    implements MagentoCustomerClient<RemoteException>
{
    public AxisMagentoCustomerClient(AxisPortProvider provider)
    {
        super(provider);
    }

    public int createCustomer(@NotNull CustomerCustomerEntityToCreate customerEntityToCreate) throws RemoteException
    {
        return getPort().customerCustomerCreate(getSessionId(), customerEntityToCreate);
    }

    public boolean deleteCustomer(int customerId) throws RemoteException
    {
        return getPort().customerCustomerDelete(getSessionId(), customerId);
    }

    @NotNull
    public CustomerCustomerEntity getCustomer(int customerId, @NotNull List<String> attributeNames)
        throws RemoteException
    {
        Validate.notEmpty(attributeNames);
        return getPort().customerCustomerInfo(getSessionId(), customerId,
            toArray(attributeNames, String.class));
    }

    @NotNull
    public List<CustomerCustomerEntity> listCustomers(String filters) throws RemoteException
    {
        return Arrays.asList(getPort().customerCustomerList(getSessionId(), parse(filters)));
    }

    public boolean updateCustomer(int customerId, @NotNull CustomerCustomerEntityToCreate attributes)
        throws RemoteException
    {
        Validate.notNull(attributes);
        return getPort().customerCustomerUpdate(getSessionId(), customerId, attributes);
    }

    public int createCustomerAddress(int customerId, CustomerAddressEntityCreate attributes) throws RemoteException
    {
        return getPort().customerAddressCreate(getSessionId(), customerId, attributes);
    }

    public boolean deleteCustomerAddress(int addressId) throws RemoteException
    {
        return getPort().customerAddressDelete(getSessionId(), addressId);
    }

    public CustomerAddressEntityItem getCustomerAddress(int addressId) throws RemoteException
    {
        return getPort().customerAddressInfo(getSessionId(), addressId);
    }

    public List<CustomerAddressEntityItem> listCustomerAddresses(int customerId) throws RemoteException
    {
        return Arrays.asList(getPort().customerAddressList(getSessionId(), customerId));
    }

    public boolean updateCustomerAddress(int addressId, CustomerAddressEntityCreate attributes)
        throws RemoteException
    {
        return getPort().customerAddressUpdate(getSessionId(), addressId, attributes);
    }

    public List<CustomerGroupEntity> listCustomerGroups() throws RemoteException
    {
        return Arrays.asList(getPort().customerGroupList(getSessionId()));
    }
}
