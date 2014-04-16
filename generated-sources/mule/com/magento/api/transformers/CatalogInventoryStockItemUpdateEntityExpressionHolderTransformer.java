
package com.magento.api.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.magento.api.CatalogInventoryStockItemUpdateEntity;
import com.magento.api.holders.CatalogInventoryStockItemUpdateEntityExpressionHolder;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-16T10:50:08-05:00", comments = "Build master.1915.dd1962d")
public class CatalogInventoryStockItemUpdateEntityExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == CatalogInventoryStockItemUpdateEntityExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CatalogInventoryStockItemUpdateEntityExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CatalogInventoryStockItemUpdateEntityExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CatalogInventoryStockItemUpdateEntityExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return CatalogInventoryStockItemUpdateEntity.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CatalogInventoryStockItemUpdateEntity.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        CatalogInventoryStockItemUpdateEntityExpressionHolder holder = ((CatalogInventoryStockItemUpdateEntityExpressionHolder) src);
        CatalogInventoryStockItemUpdateEntity result = new CatalogInventoryStockItemUpdateEntity();
        try {
            final String _transformedQty = ((String) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_qtyType").getGenericType(), null, holder.getQty()));
            result.setQty(_transformedQty);
            final Integer _transformedIs_in_stock = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_is_in_stockType").getGenericType(), null, holder.getIs_in_stock()));
            result.setIs_in_stock(_transformedIs_in_stock);
            final Integer _transformedManage_stock = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_manage_stockType").getGenericType(), null, holder.getManage_stock()));
            result.setManage_stock(_transformedManage_stock);
            final Integer _transformedUse_config_manage_stock = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_use_config_manage_stockType").getGenericType(), null, holder.getUse_config_manage_stock()));
            result.setUse_config_manage_stock(_transformedUse_config_manage_stock);
            final Integer _transformedMin_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_min_qtyType").getGenericType(), null, holder.getMin_qty()));
            result.setMin_qty(_transformedMin_qty);
            final Integer _transformedUse_config_min_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_use_config_min_qtyType").getGenericType(), null, holder.getUse_config_min_qty()));
            result.setUse_config_min_qty(_transformedUse_config_min_qty);
            final Integer _transformedMin_sale_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_min_sale_qtyType").getGenericType(), null, holder.getMin_sale_qty()));
            result.setMin_sale_qty(_transformedMin_sale_qty);
            final Integer _transformedUse_config_min_sale_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_use_config_min_sale_qtyType").getGenericType(), null, holder.getUse_config_min_sale_qty()));
            result.setUse_config_min_sale_qty(_transformedUse_config_min_sale_qty);
            final Integer _transformedMax_sale_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_max_sale_qtyType").getGenericType(), null, holder.getMax_sale_qty()));
            result.setMax_sale_qty(_transformedMax_sale_qty);
            final Integer _transformedUse_config_max_sale_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_use_config_max_sale_qtyType").getGenericType(), null, holder.getUse_config_max_sale_qty()));
            result.setUse_config_max_sale_qty(_transformedUse_config_max_sale_qty);
            final Integer _transformedIs_qty_decimal = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_is_qty_decimalType").getGenericType(), null, holder.getIs_qty_decimal()));
            result.setIs_qty_decimal(_transformedIs_qty_decimal);
            final Integer _transformedBackorders = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_backordersType").getGenericType(), null, holder.getBackorders()));
            result.setBackorders(_transformedBackorders);
            final Integer _transformedUse_config_backorders = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_use_config_backordersType").getGenericType(), null, holder.getUse_config_backorders()));
            result.setUse_config_backorders(_transformedUse_config_backorders);
            final Integer _transformedNotify_stock_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_notify_stock_qtyType").getGenericType(), null, holder.getNotify_stock_qty()));
            result.setNotify_stock_qty(_transformedNotify_stock_qty);
            final Integer _transformedUse_config_notify_stock_qty = ((Integer) evaluateAndTransform(this.muleContext, event, CatalogInventoryStockItemUpdateEntityExpressionHolder.class.getDeclaredField("_use_config_notify_stock_qtyType").getGenericType(), null, holder.getUse_config_notify_stock_qty()));
            result.setUse_config_notify_stock_qty(_transformedUse_config_notify_stock_qty);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
