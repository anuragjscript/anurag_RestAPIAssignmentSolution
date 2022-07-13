package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Role;
import com.ems.service.RoleService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> allRoles = roleService.getAllRoles();
		return ResponseEntity.ok().body(allRoles);
	}
	
	@GetMapping("/getRoleById/{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable Integer roleId) {
		Role role = roleService.getRoleById(roleId);
		return ResponseEntity.ok().body(role);
	}
	
	@PostMapping("/addNewRole")
	public ResponseEntity<Role> addNewRole(@RequestBody Role role) {
		Role savedRole = roleService.saveRole(role);
		return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
	}
	
	@PutMapping("/editRoleById/{roleId}")
	public ResponseEntity<Role> editRoleById(@PathVariable Integer roleId, @RequestBody Role role) {
		Role savedRole = roleService.editRoleById(roleId, role.getName());
		return ResponseEntity.ok().body(savedRole);
	}
	
	@DeleteMapping("/deleteRole/{roleId}")
	public ResponseEntity<Object> deleteRole(@PathVariable Integer roleId) {
		roleService.deleteRoleById(roleId);
		return ResponseEntity.noContent().build();
	}
	

}
