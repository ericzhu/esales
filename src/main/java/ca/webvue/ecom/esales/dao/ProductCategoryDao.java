package ca.webvue.ecom.esales.dao;

import java.util.List;

import ca.webvue.ecom.esales.entity.ProductCategory;

public interface ProductCategoryDao extends BaseDao<ProductCategory, Long> {
	
	List<ProductCategory> findRoots(Integer count);

	List<ProductCategory> findParents(ProductCategory productCategory, Integer count);

	List<ProductCategory> findChildren(ProductCategory productCategory, Integer count);
}
