package fr.myproject.machinescontrolserver.repository;

import fr.myproject.machinescontrolserver.model.Role;
import fr.myproject.machinescontrolserver.model.UsageHistory;
import fr.myproject.machinescontrolserver.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
