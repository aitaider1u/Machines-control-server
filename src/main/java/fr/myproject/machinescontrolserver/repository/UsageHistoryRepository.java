package fr.myproject.machinescontrolserver.repository;
import fr.myproject.machinescontrolserver.model.Device;
import fr.myproject.machinescontrolserver.model.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsageHistoryRepository extends JpaRepository<UsageHistory,Long>{
    List<UsageHistory> findByDevice(Device device);
}
