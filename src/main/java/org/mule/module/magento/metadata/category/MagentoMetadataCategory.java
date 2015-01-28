/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.magento.metadata.category;

import com.magento.api.*;
import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.*;
import org.mule.module.magento.MagentoCloudConnector;

import java.util.ArrayList;
import java.util.List;

@MetaDataCategory
public class MagentoMetadataCategory {

    private MagentoCloudConnector magentoCloudConnector;

    private static final String ENTITY_PACKAGE = "com.magento.api";


    private MetaDataKey createKey(Class<?> cls) {
        return new DefaultMetaDataKey(cls.getSimpleName(), cls.getSimpleName());
    }

    @MetaDataKeyRetriever
    public List<MetaDataKey> getMetadataKeys() {
        List<MetaDataKey> keys = new ArrayList<MetaDataKey>();
        keys.add(this.createKey(ApiEntity.class));
        keys.add(this.createKey(ApiMethodEntity.class));
        keys.add(this.createKey(AssociativeEntity.class));
        keys.add(this.createKey(AssociativeMultiEntity.class));
        keys.add(this.createKey(CatalogAttributeEntity.class));
        keys.add(this.createKey(CatalogAttributeOptionEntity.class));
        keys.add(this.createKey(CatalogCategoryEntity.class));
        keys.add(this.createKey(CatalogInventoryStockItemEntity.class));
        keys.add(this.createKey(CatalogInventoryStockItemUpdateEntity.class));
        keys.add(this.createKey(CatalogProductAdditionalAttributesEntity.class));
        keys.add(this.createKey(CatalogProductAttributeEntity.class));
        keys.add(this.createKey(CatalogProductAttributeFrontendLabelEntity.class));
        keys.add(this.createKey(CatalogProductAttributeMediaCreateEntity.class));
        keys.add(this.createKey(CatalogProductAttributeMediaTypeEntity.class));
        keys.add(this.createKey(CatalogProductAttributeOptionLabelEntity.class));
        keys.add(this.createKey(CatalogProductAttributeSetEntity.class));
        keys.add(this.createKey(CatalogProductCreateEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionAdditionalFieldsEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionInfoEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionListEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionTypesEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionValueAddEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionValueInfoEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionValueListEntity.class));
        keys.add(this.createKey(CatalogProductCustomOptionValueUpdateEntity.class));
        keys.add(this.createKey(CatalogProductDownloadableLinkAddEntity.class));
        keys.add(this.createKey(CatalogProductDownloadableLinkAddSampleEntity.class));
        keys.add(this.createKey(CatalogProductDownloadableLinkEntity.class));
        keys.add(this.createKey(CatalogProductDownloadableLinkFileEntity.class));
        keys.add(this.createKey(CatalogProductDownloadableLinkFileInfoEntity.class));
        keys.add(this.createKey(CatalogProductDownloadableLinkInfoEntity.class));
        keys.add(this.createKey(CatalogProductDownloadableLinkSampleEntity.class));
        keys.add(this.createKey(CatalogProductEntity.class));
        keys.add(this.createKey(CatalogProductImageEntity.class));
        keys.add(this.createKey(CatalogProductImageFileEntity.class));
        keys.add(this.createKey(CatalogProductLinkAttributeEntity.class));
        keys.add(this.createKey(CatalogProductLinkEntity.class));
        keys.add(this.createKey(CatalogProductReturnEntity.class));
        keys.add(this.createKey(CatalogProductTagAddEntity.class));
        keys.add(this.createKey(CatalogProductTagInfoEntity.class));
        keys.add(this.createKey(CatalogProductTagListEntity.class));
        keys.add(this.createKey(CatalogProductTagUpdateEntity.class));
        keys.add(this.createKey(CatalogProductTierPriceEntity.class));
        keys.add(this.createKey(CatalogProductTypeEntity.class));
        keys.add(this.createKey(CustomerCustomerEntity.class));
        keys.add(this.createKey(CustomerGroupEntity.class));
        keys.add(this.createKey(DirectoryCountryEntity.class));
        keys.add(this.createKey(DirectoryRegionEntity.class));
        keys.add(this.createKey(ExistsFaltureEntity.class));
        keys.add(this.createKey(GiftMessageAssociativeProductsEntity.class));
        keys.add(this.createKey(MagentoInfoEntity.class));
        keys.add(this.createKey(SalesOrderAddressEntity.class));
        keys.add(this.createKey(SalesOrderCreditmemoCommentEntity.class));
        keys.add(this.createKey(SalesOrderCreditmemoEntity.class));
        keys.add(this.createKey(SalesOrderCreditmemoItemEntity.class));
        keys.add(this.createKey(SalesOrderEntity.class));
        keys.add(this.createKey(SalesOrderInvoiceCommentEntity.class));
        keys.add(this.createKey(SalesOrderInvoiceEntity.class));
        keys.add(this.createKey(SalesOrderInvoiceItemEntity.class));
        keys.add(this.createKey(SalesOrderItemEntity.class));
        keys.add(this.createKey(SalesOrderListEntity.class));
        keys.add(this.createKey(SalesOrderPaymentEntity.class));
        keys.add(this.createKey(SalesOrderShipmentCommentEntity.class));
        keys.add(this.createKey(SalesOrderShipmentEntity.class));
        keys.add(this.createKey(SalesOrderShipmentItemEntity.class));
        keys.add(this.createKey(SalesOrderShipmentTrackEntity.class));
        keys.add(this.createKey(SalesOrderStatusHistoryEntity.class));
        keys.add(this.createKey(ShoppingCartAddressEntity.class));
        keys.add(this.createKey(ShoppingCartCustomerAddressEntity.class));
        keys.add(this.createKey(ShoppingCartCustomerEntity.class));
        keys.add(this.createKey(ShoppingCartInfoEntity.class));
        keys.add(this.createKey(ShoppingCartItemEntity.class));
        keys.add(this.createKey(ShoppingCartLicenseEntity.class));
        keys.add(this.createKey(ShoppingCartPaymentEntity.class));
        keys.add(this.createKey(ShoppingCartPaymentMethodEntity.class));
        keys.add(this.createKey(ShoppingCartProductEntity.class));
        keys.add(this.createKey(ShoppingCartShippingMethodEntity.class));
        keys.add(this.createKey(ShoppingCartTotalsEntity.class));
        keys.add(this.createKey(StoreEntity.class));

        return keys;
    }

    @MetaDataRetriever
    public MetaData getMetadata(MetaDataKey key) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(String.format("%s.%s", ENTITY_PACKAGE, key.getId()));
        return new DefaultMetaData(new DefaultPojoMetaDataModel(clazz));
    }
}
