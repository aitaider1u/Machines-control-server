package fr.myproject.machinescontrolserver.service;
import fr.myproject.machinescontrolserver.model.UsageHistory;

import java.util.List;

public interface UsageHistoryService {
    List<UsageHistory> getUsageHistoryOfADevice(long deviceId);
}
