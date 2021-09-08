package com.pos.admin.service;

import java.util.List;

import com.pos.admin.entity.Vendor;

public interface vendorService {

	public Vendor addVendor(Vendor Vendor);
	public List<Vendor> getVendor();
	public Vendor getVendor(Long idVendor);
	public String deleteEmployee(Long id);
}
