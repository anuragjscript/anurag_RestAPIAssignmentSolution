package com.ems.service;

import java.util.List;

import com.ems.model.Role;

public interface RoleService {
	
	List<Role> getAllRoles();
	Role getRoleById(Integer roleId);
	Role saveRole(Role role);
	Role editRoleById(Integer roleId, String name);
	void deleteRoleById(Integer roleId);

}
