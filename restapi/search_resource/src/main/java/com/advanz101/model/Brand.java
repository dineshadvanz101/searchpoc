package com.advanz101.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sharm
 *
 */
public class Brand {

	@JsonProperty(value = "brand_name")
	private String brandName;
	@JsonProperty(value = "brand_image_url")
	private String brandUrl;

	@JsonProperty(value = "category_name")
	private String categoryName;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandUrl() {
		return brandUrl;
	}

	public void setBrandUrl(String brandUrl) {
		this.brandUrl = brandUrl;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
