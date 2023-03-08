package com.jbk.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.Supplier;
import com.jbk.service.SupplierService;

@Service
public class SupplierServiceIMPL implements SupplierService {
	@Autowired
	private SupplierDao dao;

	@Override
	public boolean saveSupplier(Supplier supplier) {
		return dao.saveSupplier(supplier);
	}

	@Override
	public Supplier getSupplierById(int id) {
		return dao.getSupplierById(id);
	}

	@Override
	public Supplier getSupplierByName(String name) {
		return dao.getSupplierByName(name);
	}

}
