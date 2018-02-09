package com.advanz101.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advanz101.dao.SearchPocDao;
import com.advanz101.model.Brand;
import com.advanz101.model.Category;
import com.advanz101.service.SearchPocService;


/**
 * @author sharm
 *
 */
@Service
public class SearchPocServiceImpl implements SearchPocService {

	@Autowired
	private SearchPocDao searchPocDao;

	/* (non-Javadoc)
	 * @see com.advanz101.service.SearchPocService#getCategories()
	 */
	@Override
	public List<String> getCategories() {
		// TODO Auto-generated method stub
		List<String> categoryNames = new ArrayList<String>();
		List<Category> list = searchPocDao.getCategories();
		for (Category category : list) {
			categoryNames.add(category.getCategoryName());
		}
		return categoryNames;
	}

	/* (non-Javadoc)
	 * @see com.advanz101.service.SearchPocService#getBrands(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Brand> getBrands(String brandName, String category) {
		List<Brand> brandList = searchPocDao.getBrands(brandName, category);
		List<Brand> brands = new ArrayList<Brand>();
		
		if (brandList.size() == 1) {
			return brandList;
		} else {
			findUniqueBrands(brandList,brands);
		}
		return brands;
	}
	
	private void findUniqueBrands(List<Brand> brandList,List<Brand> brands) {
		String brandN = null;
		for (Brand brand : brandList) {
			brandN = brand.getBrandName();
			if (brands.size() == 0) {
				brands.add(brand);
			} else {
				String latestBrand = brands.get(brands.size() - 1).getBrandName();

				if (!latestBrand.trim().equalsIgnoreCase(brandN.trim())) {
					brands.add(brand);
				}

			}
		}
	}

	/* (non-Javadoc)
	 * @see com.advanz101.service.SearchPocService#getAvailableLetters()
	 */
	@Override
	public List<String> getAvailableLetters() {
		List<Brand> brandList = searchPocDao.getBrands(null, null);
		Set<String> letters = new HashSet<String>();
		for (Brand brand : brandList) {
			letters.add(brand.getBrandName().trim().substring(0, 1));
		}
		return new ArrayList<String>(letters);
	}

}
