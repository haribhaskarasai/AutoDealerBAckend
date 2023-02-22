package com.auto.dealeraudit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auto.dealeraudit.entity.Permission;
import com.auto.dealeraudit.entity.Role;
import com.auto.dealeraudit.service.PermissionService;
import com.auto.dealeraudit.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/roleAndPermission")
public class RoleAndPermissionController {
	@Autowired
	private PermissionService permissionService;

	@PostMapping(value = "createpermission")
	public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
		return new ResponseEntity<Permission>(this.permissionService.createPermission(permission), HttpStatus.CREATED);
	}

	@PutMapping(value = "updatepermission")
	public ResponseEntity<Permission> updatePermission(@RequestBody Permission permission) {
		return new ResponseEntity<Permission>(this.permissionService.updatePermission(permission), HttpStatus.CREATED);
	}

	@GetMapping(value = "allPermissions")
	public ResponseEntity<List<Permission>> getAllPermissions() {
		return new ResponseEntity<List<Permission>>(this.permissionService.readAllPermissions(), HttpStatus.OK);
	}

	@GetMapping(value = "permissionsByTitle/{title}")
	public ResponseEntity<List<Permission>> getPermissionsByTitle(@RequestParam("title") String title) {
		return new ResponseEntity<List<Permission>>(this.permissionService.readPermissionsByTitle(title),
				HttpStatus.OK);
	}

	@GetMapping(value = "permissionsById/{id}")
	public ResponseEntity<Permission> getPermissionById(@RequestParam("id") int id) {
		return new ResponseEntity<Permission>(this.permissionService.readPermissionById(id), HttpStatus.OK);
	}

	@Autowired
	private RoleService roleService;

	@PostMapping("/saveRole")
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		Role roleSaved = roleService.addRole(role);
		return new ResponseEntity<Role>(roleSaved, HttpStatus.ACCEPTED);
	};

	@GetMapping("/allRoles")
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> roles = roleService.getAllRoles();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);

	}

	@GetMapping("/roleById/{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable("roleId") int roleId) {
		Role role = roleService.getRoleById(roleId);
		return new ResponseEntity<Role>(role, HttpStatus.OK);

	}

	@DeleteMapping("deleteRole/{roleId}")
	public ResponseEntity<String> deleteRoleById(@PathVariable("roleId") int roleId) {
		String message = roleService.deleteRoleById(roleId);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);

	}

	@PutMapping("updateRole/{roleId}")
	public ResponseEntity<Role> updateRoleById(@PathVariable("roleId") int roleId, @RequestBody Role role) {
		Role roleUpdated = roleService.updateRoleById(roleId, role);
		return new ResponseEntity<Role>(roleUpdated, HttpStatus.OK);

	}
}
