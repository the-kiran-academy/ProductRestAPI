package com.jbk.controller;

import javax.validation.Valid;

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
import com.jbk.entity.Product;
import com.jbk.exceptions.ResourceAlreadyExistsException;
import com.jbk.exceptions.ResourceNotExistsException;
import com.jbk.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/save-product")
	public ResponseEntity<Boolean> saveProduct(@Valid @RequestBody Product product){
		boolean isAdded = service.saveProduct(product);
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}else {
			 throw new ResourceAlreadyExistsException("Product Already Exists With Product Name  = "+product.getProductName());
			//return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/get-product-by-id/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		Product product = service.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			 throw new ResourceNotExistsException("Product Not Found For Id = "+id);
			//return new ResponseEntity<>(product, HttpStatus.NO_CONTENT);

		}
	}


}
