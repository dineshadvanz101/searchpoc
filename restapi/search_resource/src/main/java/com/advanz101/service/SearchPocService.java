package com.advanz101.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advanz101.model.Brand;


/**
 * @author sharm
 *
 */
@Service
public interface SearchPocService {
	
	public List<String> getCategories();
	
	public List<Brand> getBrands(String brand,String category);
	
	public List<String> getAvailableLetters();
	

}
