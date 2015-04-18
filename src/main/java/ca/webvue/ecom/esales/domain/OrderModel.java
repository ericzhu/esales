package ca.webvue.ecom.esales.domain;

import javax.persistence.Column;
import javax.validation.constraints.Min;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	public static final String ORDER_PROPERTY_NAME = "order";
	
	private Integer order;
	
	@JsonProperty
	@Field(store = Store.YES, index = Index.UN_TOKENIZED)
	@Min(0)
	@Column(name = "orders")
	public Integer getOrder() {
		return order;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public int compareTo(OrderModel orderModel) {
		return new CompareToBuilder().append(getOrder(), orderModel.getOrder()).append(getId(), orderModel.getId()).toComparison();
	}
}
