package com.pos.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.admin.entity.Product;
import com.pos.admin.exception.DuplicateIdException;
import com.pos.admin.exception.IdNotFoundException;
import com.pos.admin.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct(){
		return new ResponseEntity<>(productService.getAllProduct(),new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		return new ResponseEntity<>(productService.getProductById(id),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/category/{id}/product")
	public ResponseEntity<String> addProduct(@PathVariable Long id,@RequestBody Product product){
		
		return new ResponseEntity<>(productService.addProduct(id,product),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/category/{cid}/product/{pid}")
	public ResponseEntity<String> updateEmployee(@PathVariable("cid") Long cid, @PathVariable("pid") Long pid,@RequestBody Product product){
		
		return new ResponseEntity<>(productService.updateProduct(cid,pid, product),new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{cid}/product/{pid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("cid") Long cid,@PathVariable("pid") Long pid){
		
		return new ResponseEntity<>(productService.deleteProduct(cid, pid),new HttpHeaders(),HttpStatus.OK);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(DuplicateIdException.class)
	public ResponseEntity<String> duplicateIdFound(DuplicateIdException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	
}
