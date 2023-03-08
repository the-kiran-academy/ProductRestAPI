package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Category;
import com.jbk.entity.Supplier;
import com.jbk.service.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

	@Autowired
	private SupplierService service;

	@PostMapping(value = "/save-supplier")
	public ResponseEntity<Boolean> saveSupplier(@RequestBody Supplier supplier) {

		boolean isAdded = service.saveSupplier(supplier);
		if (isAdded) {
			return new ResponseEntity<>(isAdded, HttpStatus.CREATED);
		} else {
			// throw new ResourceAlreadyExistsException("Category Already Exists ";)
			return new ResponseEntity<>(isAdded, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/get-supplier-by-id/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
		Supplier supplier = service.getSupplierById(id);
		if (supplier != null) {
			return new ResponseEntity<>(supplier, HttpStatus.OK);
		} else {
			// throw new ResourceNotExistsException("Category Not Found For Id = "+id);
			return new ResponseEntity<>(supplier, HttpStatus.NO_CONTENT);

		}
	}

	@GetMapping(value = "/get-supplier-by-name/{name}")
	public ResponseEntity<Supplier> getSupplierByName(@PathVariable String name) {
		Supplier supplier = service.getSupplierByName(name);
		if (supplier != null) {
			return new ResponseEntity<>(supplier, HttpStatus.OK);
		} else {
			// throw new ResourceNotExistsException("Category Not Found For Id = "+id);
			return new ResponseEntity<>(supplier, HttpStatus.NO_CONTENT);

		}
	}

}
