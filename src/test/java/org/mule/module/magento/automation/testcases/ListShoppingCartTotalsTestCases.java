package org.mule.module.magento.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;

import com.magento.api.CatalogProductCreateEntity;
import com.magento.api.ShoppingCartCustomerAddressEntity;
import com.magento.api.ShoppingCartProductEntity;
import com.magento.api.ShoppingCartTotalsEntity;

public class ListShoppingCartTotalsTestCases extends MagentoTestParent {

	@Before
	public void setUp() {
		try {
			testObjects = (HashMap<String, Object>) context.getBean("listShoppingCartTotals");

			List<HashMap<String, Object>> productDefinitions = (List<HashMap<String, Object>>) testObjects.get("products");

			double totalProductPrice = 0;
			HashMap<Integer, Double> productPrices = new HashMap<Integer, Double>();
			List<ShoppingCartProductEntity> shoppingCartEntities = new ArrayList<ShoppingCartProductEntity>();
			
			// Iterate over each product definition and insert
			for (HashMap<String, Object> productDefinition : productDefinitions) {
				String productType = (String) productDefinition.get("type");
				int productSet = (Integer) productDefinition.get("set");
				String productSKU = (String) productDefinition.get("sku");
				CatalogProductCreateEntity attributes = (CatalogProductCreateEntity) productDefinition.get("attributesRef");

				double price = Double.parseDouble(attributes.getPrice());
				
				// Get the product ID and the number of items we want to place in the shopping cart
				int productId = createProduct(productType, productSet, productSKU, attributes);
				double qtyToPlace = (Double) productDefinition.get("qtyToPlace");
				
				ShoppingCartProductEntity shoppingCartEntity = new ShoppingCartProductEntity();
				shoppingCartEntity.setProduct_id(productId + "");
				shoppingCartEntity.setQty(qtyToPlace);
								
				shoppingCartEntities.add(shoppingCartEntity);
			
				double totalPrice = price * qtyToPlace;
				totalProductPrice += totalPrice;
				productPrices.put(productId, totalPrice);
			}
			
			// Create the shopping cart
			int shoppingCartId = createShoppingCart();
			// Add the products to the shopping cart
			addProductsToShoppingCart(shoppingCartId, shoppingCartEntities);
			
			// Add the customer addresses
			List<ShoppingCartCustomerAddressEntity> addresses = (List<ShoppingCartCustomerAddressEntity>) testObjects.get("addresses");
			setCustomerAddressesToShoppingCart(shoppingCartId, addresses);
			
			testObjects.put("quoteId", shoppingCartId);
			testObjects.put("shoppingCartEntities", shoppingCartEntities);
			testObjects.put("productPrices", productPrices);
			testObjects.put("totalPrice", totalProductPrice);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testListShoppingCartTotals() {
		try {
			HashMap<Integer, Double> productPrices = (HashMap<Integer, Double>) testObjects.get("productPrices");
			double totalPrice = (Double) testObjects.get("totalPrice");
			
			MessageProcessor flow = lookupFlowConstruct("list-shopping-cart-totals");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			List<ShoppingCartTotalsEntity> totals = (List<ShoppingCartTotalsEntity>) response.getMessage().getPayload();
			for (ShoppingCartTotalsEntity total : totals) {
				if (total.getTitle().equals("Subtotal")) {
					assertTrue(total.getAmount().doubleValue() == totalPrice);
				}
				else if (total.getTitle().equals("Grant Total")) {
					assertTrue(total.getAmount().doubleValue() == totalPrice);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@After
	public void tearDown() {
		try {
			HashMap<Integer, Double> productPrices = (HashMap<Integer, Double>) testObjects.get("productPrices");
			for (Map.Entry<Integer, Double> product : productPrices.entrySet()) {
				Integer productId = product.getKey();
				deleteProductById(productId);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
}
