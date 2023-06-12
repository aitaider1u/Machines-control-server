package fr.myproject.machinescontrolserver.service;

import fr.myproject.machinescontrolserver.exception.roleException.RoleDoesNotExistException;
import fr.myproject.machinescontrolserver.exception.roleException.RoleExistYetException;
import fr.myproject.machinescontrolserver.model.Role;
import fr.myproject.machinescontrolserver.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role role) throws RoleExistYetException {
        if (roleRepository.existsByCode(role.getCode())){
            throw new RoleExistYetException("The role "+ role.getCode() +" already exists");
        }
        return this.roleRepository.save(role);
    }

    @Override
    public Role updateRole(long id, Role roleRequest) throws RoleDoesNotExistException {
        Role role = roleRepository.findById(id);
        if(role == null)
            throw new RoleDoesNotExistException("Role with id :  "+ id+" does not exist");
        role.setCode(roleRequest.getCode());
        role.setDescription(roleRequest.getDescription());
        roleRepository.save(role);
        return role;
    }
}
