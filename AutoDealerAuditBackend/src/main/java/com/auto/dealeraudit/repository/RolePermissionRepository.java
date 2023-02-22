package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.RolePermissions;


@Repository 
public interface RolePermissionRepository extends JpaRepository<RolePermissions, Integer> {

}
