package ca.webvue.ecom.esales.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.webvue.ecom.esales.dao.ProductCategoryDao;
import ca.webvue.ecom.esales.entity.ProductCategory;
import ca.webvue.ecom.esales.service.ProductCategoryService;

@Service("productCategoryServiceImpl")
public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory, Long> implements ProductCategoryService {
	
	@Resource(name = "productCategoryDaoJpa")
	private ProductCategoryDao productCategoryDao;
	
	@Resource(name = "productCategoryDaoJpa")
	public void setBaseDao(ProductCategoryDao productCategoryDao) {
		super.setBaseDao(productCategoryDao);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<ProductCategory> findRoots() {
		return productCategoryDao.findRoots(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductCategory> findRoots(Integer count) {
		return productCategoryDao.findRoots(count);
	}

	@Transactional(readOnly = true)
	@Cacheable("productCategory")
	@Override
	public List<ProductCategory> findRoots(Integer count, String cacheRegion) {
		return productCategoryDao.findRoots(count);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductCategory> findParents(ProductCategory productCategory) {
		return productCategoryDao.findParents(productCategory, null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductCategory> findParents(ProductCategory productCategory, Integer count) {
		return productCategoryDao.findParents(productCategory, count);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable("productCategory")
	public List<ProductCategory> findParents(ProductCategory productCategory, Integer count, String cacheRegion) {
		return productCategoryDao.findParents(productCategory, count);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductCategory> findTree() {
		return productCategoryDao.findChildren(null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductCategory> findChildren(ProductCategory productCategory) {
		return productCategoryDao.findChildren(productCategory, null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductCategory> findChildren(ProductCategory productCategory, Integer count) {
		return productCategoryDao.findChildren(productCategory, count);
	}

	@Transactional(readOnly = true)
	@Cacheable("productCategory")
	@Override
	public List<ProductCategory> findChildren(ProductCategory productCategory, Integer count, String cacheRegion) {
		return productCategoryDao.findChildren(productCategory, count);
	}
	
	
	@Override
	@Transactional
	@CacheEvict(value = { "product", "productCategory", "review", "consultation" }, allEntries = true)
	public void save(ProductCategory productCategory) {
		super.save(productCategory);
	}
	
	
	@Override
	@Transactional
	@CacheEvict(value = { "product", "productCategory", "review", "consultation" }, allEntries = true)
	public ProductCategory update(ProductCategory productCategory) {
		return super.update(productCategory);
	}
	
	@Override
	@Transactional
	@CacheEvict(value = { "product", "productCategory", "review", "consultation" }, allEntries = true)
	public void delete(Long id) {
		super.delete(id);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "productCategory", "review", "consultation" }, allEntries = true)
	public void delete(Long... ids) {
		super.delete(ids);
	}

	@Override
	@Transactional
	@CacheEvict(value = { "product", "productCategory", "review", "consultation" }, allEntries = true)
	public void delete(ProductCategory productCategory) {
		super.delete(productCategory);
	}
}