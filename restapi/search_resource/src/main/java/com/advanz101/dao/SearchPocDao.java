package com.advanz101.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.advanz101.model.Brand;
import com.advanz101.model.Category;


/**
 * @author sharm
 *
 */
@Repository
@Transactional
public interface SearchPocDao {
	
	
	public List<Category> getCategories();
	
	public List<Brand> getBrands(String brand,String category);

}
