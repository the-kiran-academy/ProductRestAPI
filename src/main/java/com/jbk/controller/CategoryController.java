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
import com.jbk.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping(value = "/save-category")
	public ResponseEntity<Boolean> saveCategory(@RequestBody Category category) {

		boolean isAdded = service.saveCategory(category);
		if (isAdded) {
			return new ResponseEntity<>(isAdded, HttpStatus.CREATED);
		} else {
			// throw new ResourceAlreadyExistsException("Category Already Exists ";)
			return new ResponseEntity<>(isAdded, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/get-category-by-id/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		Category category = service.getCategoryById(id);
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		} else {
			// throw new ResourceNotExistsException("Category Not Found For Id = "+id);
			return new ResponseEntity<>(category, HttpStatus.NO_CONTENT);

		}
	}

	@GetMapping(value = "/get-category-by-name/{name}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
		Category category = service.getCategoryByName(name);
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		} else {
			// throw new ResourceNotExistsException("Category Not Found For Id = "+id);
			return new ResponseEntity<>(category, HttpStatus.NO_CONTENT);

		}
	}

}
