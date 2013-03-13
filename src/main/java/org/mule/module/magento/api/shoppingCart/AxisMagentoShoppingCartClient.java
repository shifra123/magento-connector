/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.api.shoppingCart;

import com.magento.api.*;
import org.apache.commons.lang.Validate;
import org.mule.module.magento.api.AbstractMagentoClient;
import org.mule.module.magento.api.AxisPortProvider;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.mule.module.magento.api.util.MagentoObject.fromMap;

public class AxisMagentoShoppingCartClient extends AbstractMagentoClient
    implements MagentoShoppingCartClient<RemoteException>
{
    public AxisMagentoShoppingCartClient(AxisPortProvider provider)
    {
        super(provider);
    }

    @Override
    public int createShoppingCart(String storeId) throws RemoteException
    {
        return getPort().shoppingCartCreate(getSessionId(), storeId);
    }

    @Override
    public ShoppingCartInfoEntity getShoppingCartInfo(int quoteId, String storeId) throws RemoteException
    {
        return getPort().shoppingCartInfo(getSessionId(), quoteId, storeId);
    }

    @Override
    public List<ShoppingCartTotalsEntity> listShoppingCartTotals(int quoteId, String storeId) throws RemoteException
    {
        return Arrays.asList(getPort().shoppingCartTotals(getSessionId(), quoteId, storeId));
    }

    @Override
    public String createShoppingCartOrder(int quoteId, String storeId, List<String> licenses) throws RemoteException
    {
        return getPort().shoppingCartOrder(getSessionId(), quoteId, storeId, licenses == null ? null : toArray(licenses, String.class));
    }

    @Override
    public List<ShoppingCartLicenseEntity> listShoppingCartLicenses(int quoteId, String storeId) throws RemoteException
    {
        return Arrays.asList(getPort().shoppingCartLicense(getSessionId(), quoteId, storeId));
    }

    @Override
    public boolean addShoppingCartProduct(int quoteId,
                                          List<ShoppingCartProductEntity> products,
                                          String storeId) throws RemoteException
    {
        return getPort().shoppingCartProductAdd(getSessionId(), quoteId, products.toArray(new ShoppingCartProductEntity[products.size()]), storeId);
    }

    @Override
    public boolean updateShoppingCartProduct(int quoteId,
                                             List<ShoppingCartProductEntity> products,
                                             String storeId) throws RemoteException
    {

        return getPort().shoppingCartProductUpdate(getSessionId(), quoteId, products.toArray(new ShoppingCartProductEntity[products.size()]), storeId);
    }

    @Override
    public boolean removeShoppingCartProduct(int quoteId,
                                             List<ShoppingCartProductEntity> products,
                                             String storeId) throws RemoteException
    {
        return getPort().shoppingCartProductRemove(getSessionId(), quoteId, products.toArray(new ShoppingCartProductEntity[products.size()]), storeId);
    }

    @Override
    public List<CatalogProductEntity> listShoppingCartProducts(int quoteId, String storeId) throws RemoteException
    {
        return Arrays.asList(getPort().shoppingCartProductList(getSessionId(), quoteId, storeId));
    }

    @Override
    public boolean moveShoppingCartProductToCustomerQuote(int quoteId,
                                                          List<ShoppingCartProductEntity> products,
                                                          String storeId) throws RemoteException
    {
        return getPort().shoppingCartProductMoveToCustomerQuote(getSessionId(), quoteId, products.toArray(new ShoppingCartProductEntity[products.size()]), storeId);
    }

    @Override
    public boolean setShoppingCartCustomer(int quoteId, ShoppingCartCustomerEntity customer, String storeId) throws RemoteException
    {
        return getPort().shoppingCartCustomerSet(getSessionId(), quoteId, customer, storeId);
    }

    @Override
    public boolean setShoppingCartCustomerAddresses(int quoteId, List<ShoppingCartCustomerAddressEntity> addresses, String storeId) throws RemoteException
    {
        return getPort().shoppingCartCustomerAddresses(getSessionId(), quoteId, addresses.toArray(new ShoppingCartCustomerAddressEntity[addresses.size()]), storeId);
    }

    @Override
    public boolean setShoppingCartShippingMethod(int quoteId, String method, String storeId) throws RemoteException
    {
        return getPort().shoppingCartShippingMethod(getSessionId(), quoteId, method, storeId);
    }

    @Override
    public List<ShoppingCartShippingMethodEntity> listShoppingCartShippingMethods(int quoteId, String storeId) throws RemoteException
    {
        return Arrays.asList(getPort().shoppingCartShippingList(getSessionId(), quoteId, storeId));
    }

    @Override
    public boolean setShoppingCartPaymentMethod(int quoteId, ShoppingCartPaymentMethodEntity method, String storeId) throws RemoteException
    {
        return getPort().shoppingCartPaymentMethod(getSessionId(), quoteId, method, storeId);
    }

    @Override
    public ShoppingCartPaymentMethodResponseEntityArray listShoppingCartPaymentMethods(int quoteId, String storeId) throws RemoteException
    {
        return getPort().shoppingCartPaymentList(getSessionId(), quoteId, storeId);
    }

    @Override
    public boolean addShoppingCartCoupon(int quoteId, String couponCode, String storeId) throws RemoteException
    {
        return getPort().shoppingCartCouponAdd(getSessionId(), quoteId, couponCode, storeId);
    }

    @Override
    public boolean removeShoppingCartCoupon(int quoteId, String storeId) throws RemoteException
    {
        return getPort().shoppingCartCouponRemove(getSessionId(), quoteId, storeId);
    }
}
