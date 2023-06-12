package fr.myproject.machinescontrolserver.repository;

import fr.myproject.machinescontrolserver.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(long id);
    boolean existsById(long id);
}
