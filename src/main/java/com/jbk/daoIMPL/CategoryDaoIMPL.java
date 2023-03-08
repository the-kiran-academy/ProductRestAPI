package com.jbk.daoIMPL;

import javax.persistence.RollbackException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.jbk.dao.CategoryDao;
import com.jbk.entity.Category;

@Repository
public class CategoryDaoIMPL implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveCategory(Category category) {
		// Session session = null;
		boolean isAdded = false;
		try (Session session = sessionFactory.openSession();

		) {
			Transaction transaction = session.beginTransaction();

			session.save(category);
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
		// finally {
//
//		}
		return isAdded;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = null;
		try (Session session = sessionFactory.openSession();) {
			category = session.get(Category.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public Category getCategoryByName(String name) {
		Category category = null;
		try (Session session = sessionFactory.openSession();) {
			Criteria criteria = session.createCriteria(Category.class);
			criteria.add(Restrictions.eq("categoryName", name));
			category = (Category) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

}
