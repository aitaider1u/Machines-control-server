package fr.myproject.machinescontrolserver.repository;

import fr.myproject.machinescontrolserver.model.Device;
import fr.myproject.machinescontrolserver.model.Role;
import fr.myproject.machinescontrolserver.model.UserEntity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findById(long id);
    boolean existsByCode(String code);

}
