package com.pos.admin.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.admin.entity.vendor;


@Repository
@Scope("prototype")

public interface vendorDao extends JpaRepository<vendor, Long> {

}
