package com.pos.admin.service;

import java.util.List;

import com.pos.admin.entity.vendor;

public interface vendorService {

	public vendor addVendor(vendor Vendor);
	public List<vendor> getVendor();
	public vendor getVendor(Long idVendor);
	public String deleteEmployee(Long id);
}
