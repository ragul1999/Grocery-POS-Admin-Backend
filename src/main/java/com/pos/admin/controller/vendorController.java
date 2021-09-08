package com.pos.admin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.pos.admin.service.vendorService;
import com.pos.admin.entity.Vendor;
import com.pos.admin.exception.DuplicateIdException;
import com.pos.admin.exception.IdNotFoundException;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@Scope("prototype")
public class vendorController {

	 @Autowired
	   private vendorService vendorService;

    @PostMapping("/addVendor")
    public Vendor addVendor(@RequestBody Vendor Vendor) {
        return vendorService.addVendor(Vendor);
    }
    @GetMapping("/getVendor")
    public List<Vendor> getVendor() {
        return vendorService.getVendor();
    }
    @GetMapping("/getVendor/{idVendor}")
    public Vendor getVendor(@PathVariable("idVendor") Long idVendor) {
        return vendorService.getVendor(idVendor);
    }
    
    @DeleteMapping("/deleteVendor/{id}")
public String deleteVendor(@PathVariable Long id){
		
		return vendorService.deleteEmployee(id);
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
