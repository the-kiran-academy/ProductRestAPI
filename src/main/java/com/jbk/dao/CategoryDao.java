package com.jbk.dao;

import com.jbk.entity.Category;

public interface CategoryDao {
	
	public boolean saveCategory(Category category);
	public Category getCategoryById(int id);
	public Category getCategoryByName( String name);

}
