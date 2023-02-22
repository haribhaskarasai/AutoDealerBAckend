package com.auto.dealeraudit.service;

import java.util.List;

import com.auto.dealeraudit.entity.Permission;
import com.auto.dealeraudit.exception.CustomException;

public interface PermissionService {
	
	public abstract Permission createPermission(Permission permission) throws CustomException;

	public abstract Permission updatePermission(Permission permission) throws CustomException;

	public abstract Permission readPermissionById(int permissionId) throws CustomException;

	public abstract List<Permission> readPermissionsByTitle(String title) throws CustomException;

	public abstract List<Permission> readAllPermissions() throws CustomException;

	public abstract void deletePermissionById(int permissionId) throws CustomException;


}
