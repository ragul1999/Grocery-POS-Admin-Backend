package com.pos.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.admin.entity.Inventory;

@Repository
public interface InventoryDao extends JpaRepository<Inventory,Long> {

}
