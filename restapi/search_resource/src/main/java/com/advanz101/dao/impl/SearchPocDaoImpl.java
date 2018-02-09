package com.advanz101.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.advanz101.dao.SearchPocDao;
import com.advanz101.model.Brand;
import com.advanz101.model.Category;

/**
 * @author sharm
 *
 */
@Repository
@Transactional
public class SearchPocDaoImpl implements SearchPocDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * This method gets all the categories
	 * @see com.advanz101.dao.SearchPocDao#getCategories()
	 */
	@Override
	
	public List<Category> getCategories() {
		
		List<Category> list = jdbcTemplate.query("select * from search_category", 
				new RowMapper<Category>() {
					@Override
					public Category mapRow(ResultSet rs, int arg1) throws SQLException {
						Category entity = new Category();
						entity.setCategoryId(rs.getInt("category_id"));
						entity.setCategoryName(rs.getString("category_name"));												
						return entity;
					}
				});

		return list;
	}

	
	/* (non-Javadoc)
	 * This method get Brands with different cases like all the brands, brands with category filter, brands with search text and category etc
	 * @see com.advanz101.dao.SearchPocDao#getBrands(java.lang.String, java.lang.String)
	 */
	@Override
	
	public List<Brand> getBrands(String brand, String category) {
		Object objects[] = getParameters(brand,category);
		String query = "SELECT sb.brand_id, sb.brand_name, sb.brand_image_url, sc.category_name FROM search_brand sb, search_category sc" +
												" WHERE sb.category_id = sc.category_id";
		if(!StringUtils.isEmpty(category)) {
		    query = query + " and sc.category_name = ?";
		}
		
		if(!StringUtils.isEmpty(brand)){
			 query = query + " and sb.brand_name like ?";
		}
		
		query = query + " order by sb.brand_name";
		List<Brand> list = jdbcTemplate.query(query, objects,
				new RowMapper<Brand>() {
					@Override
					public Brand mapRow(ResultSet rs, int arg1) throws SQLException {
						Brand entity = new Brand();
						entity.setBrandName(rs.getString("brand_name"));
						entity.setBrandUrl(rs.getString("brand_image_url"));
						entity.setCategoryName(rs.getString("category_name"));	
						
						return entity;
					}
				});

		return list;
	}
	
	
	private Object[] getParameters(String brand, String category) {
	
		if(brand == null && category == null) {
			return null;
		}
		
		if(StringUtils.isEmpty(brand) && !StringUtils.isEmpty(category)) {
			Object objects[] = {category};
			return objects;
		}
		
		if(!StringUtils.isEmpty(brand) && StringUtils.isEmpty(category)) {
			Object objects[] = {brand+"%"};
			return objects;
		}
		
		if(!StringUtils.isEmpty(brand) && !StringUtils.isEmpty(category)) {
			Object objects[] = {category,brand+"%"};
			return objects;
		}
		
		return null;
	}

}
