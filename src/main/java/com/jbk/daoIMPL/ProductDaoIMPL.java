package com.jbk.daoIMPL;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Category;
import com.jbk.entity.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveProduct(Product product) {
				boolean isAdded = false;
				try (Session session = sessionFactory.openSession();

				) {
					Transaction transaction = session.beginTransaction();
					session.save(product);
					transaction.commit();
					isAdded = true;
				} catch (RollbackException e) {
					System.out.println(" rollback Duplicate Entry");
				} catch (DataIntegrityViolationException e) {
					System.out.println("Duplicate Entry");
				} catch (Exception e) {
					System.out.println();
					e.printStackTrace();
				}
				
				return isAdded;
	}

	@Override
	public Product getProductById(String productId) {
		Product product = null;
		try (Session session = sessionFactory.openSession();) {
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
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
