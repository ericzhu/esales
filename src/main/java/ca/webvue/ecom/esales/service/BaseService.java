package ca.webvue.ecom.esales.service;

import java.io.Serializable;
import java.util.List;

import ca.webvue.ecom.esales.search.Filter;
import ca.webvue.ecom.esales.search.Order;
import ca.webvue.ecom.esales.search.Page;
import ca.webvue.ecom.esales.search.Pageable;

public interface BaseService<T, ID extends Serializable> {

	T find(ID id);

	List<T> findAll();

	@SuppressWarnings("unchecked")
	List<T> findList(ID... ids);

	List<T> findList(Integer count, List<Filter> filters, List<Order> orders);

	List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	Page<T> findPage(Pageable pageable);

	long count();

	long count(Filter... filters);

	boolean exists(ID id);

	boolean exists(Filter... filters);

	void save(T entity);

	T update(T entity);

	T update(T entity, String... ignoreProperties);

	void delete(ID id);

	@SuppressWarnings("unchecked")
	void delete(ID... ids);

	void delete(T entity);
}
