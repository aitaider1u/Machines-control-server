package fr.myproject.machinescontrolserver.repository;

import fr.myproject.machinescontrolserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findById(long id);
    Role findByCode(String code);
    boolean existsByCode(String code);

}
