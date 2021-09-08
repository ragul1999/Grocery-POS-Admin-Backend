package com.pos.admin.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.admin.dao.vendorDao;
import com.pos.admin.entity.Vendor;
import com.pos.admin.exception.IdNotFoundException;
@Transactional
@Service
@Component
public class vendorServiceImpl implements vendorService{
	@Autowired
	 private vendorDao VendorDao;
@Override
	public Vendor addVendor(Vendor Vendor) {
	
		 return VendorDao.save(Vendor);
	 }
@Override
public List<Vendor> getVendor()
{
	return VendorDao.findAll();
	}
@Override
public String deleteEmployee(Long id) {
	
	Vendor obj= VendorDao.findById(id).get();
	VendorDao.delete(obj);
	return "Deleted";
	
           
}
@Override
public Vendor getVendor(Long idVendor)
{
	return VendorDao.findById(idVendor).get();
}
}


