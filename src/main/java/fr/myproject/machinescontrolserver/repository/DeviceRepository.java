package fr.myproject.machinescontrolserver.repository;

import fr.myproject.machinescontrolserver.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long>{
    Device findById(long id);

}
