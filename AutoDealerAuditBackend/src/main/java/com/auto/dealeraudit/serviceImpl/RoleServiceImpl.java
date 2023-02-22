package com.auto.dealeraudit.serviceImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.dealeraudit.entity.Role;
import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.repository.RoleRepository;
import com.auto.dealeraudit.service.RoleService;



@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	
	//creating role
	@Override
	public Role addRole(Role role) {
	Role savedRole =	roleRepository.save(role);
	return savedRole;
		
	}

	//Get Role By Id
	@Override
	public Role getRoleById(int roleId) {
		Role role;
		
		try {
			role = roleRepository.findById(roleId).get();
		} catch (Exception e) {
			throw new CustomException("Invalid Role Id");
		}

		return role;
	}
	
	//Update Role By Id
	@Override
	public Role updateRoleById(int roleId, Role role) {
		Optional<Role > optional = roleRepository.findById(roleId);
		if (optional.isPresent()) {
			role.setRoleId(roleId);;
			return roleRepository.save(role);

		} else {
			throw new  CustomException("Invalid Role Id");
		}

	}

	//Delete Role By Id
	@Override
	public String deleteRoleById(int roleId) {
		try {
			roleRepository.deleteById(roleId);
		} catch (Exception e) {
			throw new CustomException("Role doesn't exsit");
		}

		return "deleted";
		
		
	}

	
	@Override
	public List<Role> getAllRoles() {
		 List<Role> roles= roleRepository.findAll();
		 
		 if(roles.size()!=0) {
			 return roles;
		 }
		 else {
			 throw new CustomException("Roles doesn't exsit");
		 }
		
		
	}
	

}
