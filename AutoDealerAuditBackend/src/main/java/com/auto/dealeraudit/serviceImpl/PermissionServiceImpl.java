package com.auto.dealeraudit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.dealeraudit.entity.Permission;
import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.repository.PermissionRepository;
import com.auto.dealeraudit.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public Permission createPermission(Permission permission) {
		try {
			this.readPermissionById(permission.getPermissionId());
		} catch (CustomException e) {
			return this.permissionRepository.save(permission);
		}
		throw new CustomException("Permission id already exist !");
	}

	@Override
	public Permission updatePermission(Permission permission) {
		this.readPermissionById(permission.getPermissionId());
		return this.permissionRepository.save(permission);
	}

	@Override
	public Permission readPermissionById(int permissionId) {
		return this.permissionRepository.findById(permissionId)
				.orElseThrow(() -> new CustomException("Permission not found !"));
	}

	@Override
	public List<Permission> readPermissionsByTitle(String title) {
		return this.permissionRepository.findByTitle(title)
				.orElseThrow(() -> new CustomException("Permissions not found !"));
	}

	@Override
	public List<Permission> readAllPermissions() {
		return this.permissionRepository.findAll();
	}

	@Override
	public void deletePermissionById(int permissionId) {
		this.readPermissionById(permissionId);
		this.permissionRepository.deleteById(permissionId);
	}

}
