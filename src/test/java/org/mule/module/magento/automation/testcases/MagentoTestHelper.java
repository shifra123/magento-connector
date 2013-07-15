package org.mule.module.magento.automation.testcases;

import java.util.ArrayList;
import java.util.List;

import com.magento.api.CatalogProductEntity;
import com.magento.api.ShoppingCartProductEntity;

public class MagentoTestHelper {

	public static List<Integer> getIntegerList(List<String> stringList) {
		List<Integer> integerIds = new ArrayList<Integer>();
		
		for (String string : stringList) {
			integerIds.add(Integer.parseInt(string));
		}
		return integerIds;
	}
	
	public static List<String> getStringList(List<Integer> integerList) {
		List<String> stringList = new ArrayList<String>();
		
		for (Integer integer : integerList) {
			stringList.add(integer + "");
		}
		
		return stringList;
	}

	public static boolean isProductInShoppingCart(List<CatalogProductEntity> catalogProductEntities, ShoppingCartProductEntity shoppingCartProductEntity) {
		return isProductInShoppingCart(catalogProductEntities, shoppingCartProductEntity.getProduct_id());
	}
	
	public static boolean isProductInShoppingCart(List<CatalogProductEntity> catalogProductEntities, String productId) {
		for (CatalogProductEntity catalogProductEntity : catalogProductEntities) {
			if (catalogProductEntity.getProduct_id().equals(productId)) {
				return true;
			}
		}
		return false;
	}
	
}
