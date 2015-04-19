package ca.webvue.ecom.esales.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

import ca.webvue.ecom.esales.search.Filter;
import ca.webvue.ecom.esales.search.Order;
import ca.webvue.ecom.esales.search.Page;
import ca.webvue.ecom.esales.search.Pageable;

public interface BaseDao<T, ID extends Serializable> {

	T find(ID id);

	T find(ID id, LockModeType lockModeType);

	List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	Page<T> findPage(Pageable pageable);

	long count(Filter... filters);

	void persist(T entity);

	T merge(T entity);

	void remove(T entity);

	/**
	 * Refresh the in-memory entity with the latest state in database
	 */
	void refresh(T entity);

	void refresh(T entity, LockModeType lockModeType);

	ID getIdentifier(T entity);

	boolean isManaged(T entity);

	void detach(T entity);

	void lock(T entity, LockModeType lockModeType);

	/**
	 * Clear the cache
	 */
	void clear();

	/**
	 * Flush the cached data into database
	 */
	void flush();
}
