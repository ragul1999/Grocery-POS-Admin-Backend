package com.pos.admin.service;

import java.util.List;

import com.pos.admin.entity.Inventory;

public interface InventoryService {

	public String deleteInventory(Long id);

	public String updateInventory(Long id, Inventory inventoryUpdated);

	public String addInventory(Long productId, Long vendorId, Inventory inventory);

	public Inventory getInventoryById(Long id);

	public List<Inventory> getAllInventory();
}
