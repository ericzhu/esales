package ca.webvue.ecom.esales.service;

import java.util.List;

import ca.webvue.ecom.esales.entity.Brand;
import ca.webvue.ecom.esales.search.Filter;
import ca.webvue.ecom.esales.search.Order;

public interface BrandService extends BaseService<Brand, Long> {
	
	List<Brand> findList(Integer count, List<Filter> filters, List<Order> orders, String cacheRegion);

}
