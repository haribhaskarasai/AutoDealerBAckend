package com.auto.dealeraudit.service;

import java.util.List;

import com.auto.dealeraudit.entity.Role;

public interface RoleService {
	public Role addRole(Role role);
	public abstract Role getRoleById(int roleId);
	public abstract Role updateRoleById(int roleId, Role role);
	public abstract String deleteRoleById(int roleId);
	public List<Role> getAllRoles(); 

}
