package com.jbk.service;

import com.jbk.entity.Category;

public interface CategoryService {
	
	public boolean saveCategory(Category category);
	public Category getCategoryById(int id);
	public Category getCategoryByName( String name);

}
