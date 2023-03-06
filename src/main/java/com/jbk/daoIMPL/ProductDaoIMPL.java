package com.jbk.daoIMPL;

import java.util.List;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;

public class ProductDaoIMPL implements ProductDao {

	@Override
	public boolean saveProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProductById(String productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> sortProductsById_ASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortProductsByName_DESC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxPriceProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countSumOfProductPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCountOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String importSheet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportSheet() {
		// TODO Auto-generated method stub
		return null;
	}

}
