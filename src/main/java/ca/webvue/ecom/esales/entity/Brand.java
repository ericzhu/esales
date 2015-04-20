package ca.webvue.ecom.esales.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.PreRemove;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Brand extends OrderEntity {

	private static final long serialVersionUID = 1L;
	
	private static final String PATH_PREFIX = "/brand/content";

	private static final String PATH_SUFFIX = ".action";

	public enum Type {
		text, image
	}
	
	private String name;

	private Type type;

	private String logo;

	private String url;

	private String introduction;

	private Set<ProductCategory> productCategories = new HashSet<ProductCategory>();
	
	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取类型
	 * 
	 * @return 类型
	 */
	@NotNull
	@Column(nullable = false)
	public Type getType() {
		return type;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * 获取logo
	 * 
	 * @return logo
	 */
	@Length(max = 200)
	public String getLogo() {
		return logo;
	}

	/**
	 * 设置logo
	 * 
	 * @param logo
	 *            logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * 获取网址
	 * 
	 * @return 网址
	 */
	@Length(max = 200)
	public String getUrl() {
		return url;
	}

	/**
	 * 设置网址
	 * 
	 * @param url
	 *            网址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取介绍
	 * 
	 * @return 介绍
	 */
	@Lob
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * 设置介绍
	 * 
	 * @param introduction
	 *            介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * 获取商品分类
	 * 
	 * @return 商品分类
	 */
	@ManyToMany(mappedBy = "brands", fetch = FetchType.LAZY)
	@OrderBy("order asc")
	public Set<ProductCategory> getProductCategories() {
		return productCategories;
	}

	/**
	 * 设置商品分类
	 * 
	 * @param productCategories
	 *            商品分类
	 */
	public void setProductCategories(Set<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}


	/**
	 * 获取访问路径
	 * 
	 * @return 访问路径
	 */
	@Transient
	public String getPath() {
		if (getId() != null) {
			return PATH_PREFIX + "/" + getId() + PATH_SUFFIX;
		}
		return null;
	}

	/**
	 * 删除前处理
	 */
	@PreRemove
	public void preRemove() {
//		Set<Product> products = getProducts();
//		if (products != null) {
//			for (Product product : products) {
//				product.setBrand(null);
//			}
//		}
		Set<ProductCategory> productCategories = getProductCategories();
		if (productCategories != null) {
			for (ProductCategory productCategory : productCategories) {
				productCategory.getBrands().remove(this);
			}
		}
//		Set<Promotion> promotions = getPromotions();
//		if (promotions != null) {
//			for (Promotion promotion : promotions) {
//				promotion.getBrands().remove(this);
//			}
//		}
	}
}
