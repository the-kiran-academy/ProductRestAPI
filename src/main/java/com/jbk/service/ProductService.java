package com.jbk.service;

import java.util.List;

import com.jbk.entity.Product;
import com.jbk.model.FinalProduct;

public interface ProductService {
	public boolean saveProduct(Product product);

	public Product getProductById(String productId);

	public FinalProduct getFinalProductById(String productId);

	public List<Product> getAllProducts();

	public boolean deleteProductById(String productId);

	public boolean updateProduct(Product product);

	public List<Product> sortProductsById_ASC();

	public List<Product> sortProductsByName_DESC();

	public Product getMaxPriceProducts();

	public long countSumOfProductPrice();

	public int getTotalCountOfProducts();

	public String importSheet();

	public String exportSheet();

}
