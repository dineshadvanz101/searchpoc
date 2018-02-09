package com.advanz101.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sharm
 *
 */
public class Category {

	@JsonProperty(value = "category_id")
	private int categoryId;
	@JsonProperty(value = "category_name")
	private String categoryName;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
