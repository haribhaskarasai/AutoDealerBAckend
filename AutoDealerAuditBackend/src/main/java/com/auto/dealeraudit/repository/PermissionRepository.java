package com.auto.dealeraudit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.Permission;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

	public abstract Optional<List<Permission>> findByTitle(String title);

}
