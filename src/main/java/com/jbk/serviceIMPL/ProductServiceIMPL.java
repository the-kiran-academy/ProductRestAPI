package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.model.Charges;
import com.jbk.model.FinalProduct;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {
	
	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		String id = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductId(id);
		
		return dao.saveProduct(product);
	}

	@Override
	public Product getProductById(String productId) {
		return dao.getProductById(productId);
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

	@Override
	public FinalProduct getFinalProductById(String productId) {
		Product product = dao.getProductById(productId);

		FinalProduct finalProduct = new FinalProduct();

		Charges charges = new Charges();
		charges.setGst(product.getCategory().getGst());
		charges.setDeliveryCharge(product.getCategory().getDeliveryCharge());

		// calculate

		double discountAmount = (product.getProductPrice() * product.getCategory().getDiscount()) / 100;
		double gstAmount = (product.getProductPrice() * product.getCategory().getGst()) / 100;

		finalProduct.setProductId(productId);
		finalProduct.setProductName(product.getProductName());
		finalProduct.setSupplier(product.getSupplier());
		finalProduct.setCategory(product.getCategory());
		finalProduct.setProductQTY(product.getProductQTY());
		finalProduct.setProductPrice(product.getProductPrice());
		finalProduct.setCharges(charges);

		finalProduct.setDiscountAmount(discountAmount);
		finalProduct.setFinalProductPrice(
				(product.getProductPrice() + gstAmount + product.getCategory().getDeliveryCharge()) - discountAmount);

		return finalProduct;
	}

}
