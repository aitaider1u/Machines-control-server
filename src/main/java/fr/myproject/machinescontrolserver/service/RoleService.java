package fr.myproject.machinescontrolserver.service;

import fr.myproject.machinescontrolserver.exception.roleException.RoleDoesNotExistException;
import fr.myproject.machinescontrolserver.exception.roleException.RoleExistYetException;
import fr.myproject.machinescontrolserver.model.Device;
import fr.myproject.machinescontrolserver.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role createRole(Role role) throws RoleExistYetException;
    public Role updateRole(long id, Role deviceRequest) throws RoleDoesNotExistException;
}
