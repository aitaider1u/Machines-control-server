package fr.myproject.machinescontrolserver.service;


import fr.myproject.machinescontrolserver.exception.DeviceDoesNotExistException;
import fr.myproject.machinescontrolserver.model.Device;
import fr.myproject.machinescontrolserver.model.UsageHistory;
import fr.myproject.machinescontrolserver.repository.DeviceRepository;
import fr.myproject.machinescontrolserver.repository.UsageHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsageHistoryServiceImpl implements UsageHistoryService{

    private final UsageHistoryRepository usageHistoryRepository;
    private final DeviceService deviceService;

    public UsageHistoryServiceImpl(UsageHistoryRepository usageHistoryRepository, DeviceServiceImpl deviceService) {
        this.usageHistoryRepository = usageHistoryRepository;
        this.deviceService = deviceService;
    }



    @Override
    public List<UsageHistory> getUsageHistoryOfADevice(long deviceId) {
        Device device = this.deviceService.getDeviceById(deviceId);
        return this.usageHistoryRepository.findByDevice(device);
    }
}
