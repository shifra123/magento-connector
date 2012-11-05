/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.api.inventory;

import com.magento.api.CustomerAddressEntityCreate;
import com.magento.api.CustomerCustomerEntityToCreate;
import org.apache.commons.lang.Validate;
import org.mule.module.magento.api.AbstractMagentoClient;
import org.mule.module.magento.api.AxisPortProvider;

import javax.validation.constraints.NotNull;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import static org.mule.module.magento.api.util.MagentoObject.fromMap;
import static org.mule.module.magento.filters.FiltersParser.parse;

public class AxisMagentoCustomerClient extends AbstractMagentoClient
    implements MagentoCustomerClient<Object, Object[], RemoteException>
{
    public AxisMagentoCustomerClient(AxisPortProvider provider)
    {
        super(provider);
    }

    public int createCustomer(@NotNull Map<String, Object> attributes) throws RemoteException
    {
        return getPort().customerCustomerCreate(getSessionId(),
            fromMap(CustomerCustomerEntityToCreate.class, attributes));
    }

    public boolean deleteCustomer(int customerId) throws RemoteException
    {
        return getPort().customerCustomerDelete(getSessionId(), customerId);
    }

    @NotNull
    public Object getCustomer(int customerId, @NotNull List<String> attributeNames)
        throws RemoteException
    {
        Validate.notEmpty(attributeNames);
        return getPort().customerCustomerInfo(getSessionId(), customerId,
            toArray(attributeNames, String.class));
    }

    @NotNull
    public Object[] listCustomers(String filters) throws RemoteException
    {
        return getPort().customerCustomerList(getSessionId(), parse(filters));
    }

    public void updateCustomer(int customerId, @NotNull Map<String, Object> attributes)
        throws RemoteException
    {
        Validate.notNull(attributes);
        getPort().customerCustomerUpdate(getSessionId(), customerId,
            fromMap(CustomerCustomerEntityToCreate.class, attributes));
    }

    public int createCustomerAddress(int customerId, Map<String, Object> attributes) throws RemoteException
    {
        return getPort().customerAddressCreate(getSessionId(), customerId,
            fromMap(CustomerAddressEntityCreate.class, attributes));
    }

    public boolean deleteCustomerAddress(int addressId) throws RemoteException
    {
        return getPort().customerAddressDelete(getSessionId(), addressId);
    }

    public Object getCustomerAddress(int addressId) throws RemoteException
    {
        return getPort().customerAddressInfo(getSessionId(), addressId);
    }

    public Object[] listCustomerAddresses(int customerId) throws RemoteException
    {
        return getPort().customerAddressList(getSessionId(), customerId);
    }

    public void updateCustomerAddress(int addressId, Map<String, Object> attributes)
        throws RemoteException
    {
        getPort().customerAddressUpdate(getSessionId(), addressId,
            fromMap(CustomerAddressEntityCreate.class, attributes));
    }

    public Object[] listCustomerGroups() throws RemoteException
    {
        return getPort().customerGroupList(getSessionId());
    }
}
