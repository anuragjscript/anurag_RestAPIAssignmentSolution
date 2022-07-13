package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.exception.ResourceNotFoundException;
import com.ems.model.Role;
import com.ems.repository.RoleDao;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getAllRoles() {
		return roleDao.findAll();
	}

	@Override
	public Role getRoleById(Integer roleId) {
		return roleDao.findById(roleId)
			.orElseThrow( () -> new ResourceNotFoundException("Role", "roleId", roleId) );
		
	}

	@Override
	public Role saveRole(Role role) {
		return roleDao.save(role);
	}

	@Override
	public Role editRoleById(Integer roleId, String name) {
		Role role = getRoleById(roleId);
		role.setName(name);
		return roleDao.save(role);
	}

	@Override
	public void deleteRoleById(Integer roleId) {
		Role role = getRoleById(roleId);
		roleDao.delete(role);
	}

}
