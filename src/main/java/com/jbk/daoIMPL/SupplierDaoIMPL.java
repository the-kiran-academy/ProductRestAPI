package com.jbk.daoIMPL;

import javax.persistence.RollbackException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.Category;
import com.jbk.entity.Supplier;

@Repository
public class SupplierDaoIMPL implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveSupplier(Supplier supplier) {
		// Session session = null;
				boolean isAdded = false;
				try (Session session = sessionFactory.openSession();

				) {
					Transaction transaction = session.beginTransaction();

					session.save(supplier);
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
//				}
				return isAdded;
			}

	@Override
	public Supplier getSupplierById(int id) {
		Supplier supplier= null;
		try (Session session = sessionFactory.openSession();) {
			supplier = session.get(Supplier.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}

	@Override
	public Supplier getSupplierByName(String name) {
		Supplier supplier = null;
		try (Session session = sessionFactory.openSession();) {
			Criteria criteria = session.createCriteria(Supplier.class);
			criteria.add(Restrictions.eq("supplierName", name));
			supplier = (Supplier) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}

}
