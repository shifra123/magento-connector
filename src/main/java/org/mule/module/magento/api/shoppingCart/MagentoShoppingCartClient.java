/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.api.shoppingCart;

import java.util.List;
import java.util.Map;

public interface MagentoShoppingCartClient<AttributesType, AttributesCollectionType, ExceptionType extends Exception>
{
    int createShoppingCart(String storeId) throws ExceptionType;

    AttributesType getShoppingCartInfo(int quoteId, String storeId) throws ExceptionType;

    AttributesCollectionType listShoppingCartTotals(int quoteId, String storeId) throws ExceptionType;

    String createShoppingCartOrder(int quoteId, String storeId, List<String> licenses) throws ExceptionType;

    AttributesCollectionType listShoppingCartLicenses(int quoteId, String storeId) throws ExceptionType;

    boolean addShoppingCartProduct(int quoteId,
                                   List<Map<String, Object>> productsAttributes,
                                   List<Map<String, Object>> productsOptions,
                                   List<Map<String, Object>> productsBundleOptions,
                                   List<Map<String, Object>> productsBundleOptionsQty,
                                   String storeId) throws ExceptionType;

    boolean updateShoppingCartProduct(int quoteId,
                                              List<Map<String, Object>> productsAttributes,
                                              List<Map<String, Object>> productsOptions,
                                              List<Map<String, Object>> productsBundleOptions,
                                              List<Map<String, Object>> productsBundleOptionsQty,
                                              String storeId) throws ExceptionType;

    boolean removeShoppingCartProduct(int quoteId,
                                      List<Map<String, Object>> productsAttributes,
                                      List<Map<String, Object>> productsOptions,
                                      List<Map<String, Object>> productsBundleOptions,
                                      List<Map<String, Object>> productsBundleOptionsQty,
                                      String storeId) throws ExceptionType;

    AttributesCollectionType listShoppingCartProducts(int quoteId, String storeId) throws ExceptionType;

    boolean moveShoppingCartProductToCustomerQuote(int quoteId,
                                                   List<Map<String, Object>> productsAttributes,
                                                   List<Map<String, Object>> productsOptions,
                                                   List<Map<String, Object>> productsBundleOptions,
                                                   List<Map<String, Object>> productsBundleOptionsQty,
                                                   String storeId) throws ExceptionType;

    boolean setShoppingCartCustomer(int quoteId, Map<String, Object> customer, String storeId) throws ExceptionType;

    boolean setShoppingCartCustomerAddresses(int quoteId, List<Map<String, Object>> addresses, String storeId) throws ExceptionType;

    boolean setShoppingCartShippingMethod(int quoteId, String method, String storeId) throws ExceptionType;

    AttributesCollectionType listShoppingCartShippingMethods(int quoteId, String storeId) throws ExceptionType;

    boolean setShoppingCartPaymentMethod(int quoteId, Map<String, Object> method, String storeId) throws ExceptionType;

    AttributesType listShoppingCartPaymentMethods(int quoteId, String storeId) throws ExceptionType;

    boolean addShoppingCartCoupon(int quoteId, String couponCode, String storeId) throws ExceptionType;

    boolean removeShoppingCartCoupon(int quoteId, String storeId) throws ExceptionType;
}
