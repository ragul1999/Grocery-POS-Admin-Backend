package com.pos.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.admin.dao.vendorDao;
import com.pos.admin.dao.InventoryDao;
import com.pos.admin.dao.ProductDao;
import com.pos.admin.entity.Inventory;
import com.pos.admin.entity.Product;
import com.pos.admin.entity.Vendor;
import com.pos.admin.exception.IdNotFoundException;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	static final String ID_NOT_FOUND="Inventory not found with id";
	static final String PRODUCT_NOT_FOUND="Product not found with id";
	static final String VENDOR_NOT_FOUND="Vendor not found with id";
	static final String COULDNT_UPDATE="Couldn't update Inventory...";
	
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private vendorDao vendorDao;
	
	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public String deleteInventory(Long id) {

		return inventoryDao.findById(id)
                .map(inventory -> {
                	inventoryDao.delete(inventory);
                    return "Inventory with id: "+id+" deleted Successfully!";
                }).orElseThrow(() -> new IdNotFoundException("Couldn't delete Inventory..."+ID_NOT_FOUND+ id));

	}

	@Override
	public String updateInventory(Long id, Inventory inventoryUpdated) {
		
		return inventoryDao.findById(id)
				.map(inventory -> {
				inventory.setQuantity(inventoryUpdated.getQuantity());
				inventory.setManufacturedDate(inventoryUpdated.getManufacturedDate());
				inventory.setPurchasedPrice(inventoryUpdated.getPurchasedPrice());
				inventory.setExpiryDate(inventoryUpdated.getExpiryDate());
				inventory.setTax(inventoryUpdated.getTax());
				inventoryDao.save(inventory);
				return "Inventory updated successfully!";
				}).orElseThrow(() -> new IdNotFoundException(COULDNT_UPDATE+ID_NOT_FOUND+ id)); 
	}

	@Override
	public String addInventory(Long productId, Long vendorId, Inventory inventory) {
		
		if(!productDao.existsById(productId)) {
    		throw new IdNotFoundException(PRODUCT_NOT_FOUND);
    	} else {
    		Product product = productDao.getById(productId);
    		inventory.setProduct(product);
    	}
		
		if(!vendorDao.existsById(vendorId)) {
    		throw new IdNotFoundException(VENDOR_NOT_FOUND);
    	} else {
    		Vendor vendor = vendorDao.getById(vendorId);
    		inventory.setVendor(vendor);
    	}
		
		inventoryDao.save(inventory);
		return "Inventory added Successfully...:)";
	}

	@Override
	public Inventory getInventoryById(Long id) {
		
		Optional<Inventory> list = inventoryDao.findById(id);
		  if(list.isPresent()) {
	    		return list.get();
	    	}else {
	    		throw new IdNotFoundException(ID_NOT_FOUND+ id);
	    	}
	}

	@Override
	public List<Inventory> getAllInventory() {
		
		return inventoryDao.findAll();
	}

}
