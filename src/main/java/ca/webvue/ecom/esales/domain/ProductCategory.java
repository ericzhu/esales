package ca.webvue.ecom.esales.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "xx_product_category")
public class ProductCategory extends OrderModel {

	private static final long serialVersionUID = 1L;
	
	public static final String TREE_PATH_SEPARATOR = ",";
	private static final String PATH_PREFIX = "/product/list";
	private static final String PATH_SUFFIX = ".action";
	
	private String name;
	
	private String seoTitle;
	
	private String seoKeywords;
	
	private String seoDescription;
	
	private String treePath;
	
	private Integer grade;
	
	private ProductCategory parent;
	
	private Set<ProductCategory> children = new HashSet<ProductCategory>();


}
