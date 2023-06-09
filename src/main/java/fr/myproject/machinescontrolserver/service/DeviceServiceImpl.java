package fr.myproject.machinescontrolserver.service;


import fr.myproject.machinescontrolserver.exception.DeviceDoesNotExistException;
import fr.myproject.machinescontrolserver.model.Device;
import fr.myproject.machinescontrolserver.model.UsageHistory;
import fr.myproject.machinescontrolserver.repository.DeviceRepository;
import fr.myproject.machinescontrolserver.repository.UsageHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.EnumMap;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{
    private final DeviceRepository deviceRepository;
    private final UsageHistoryRepository usageHistoryRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository, UsageHistoryRepository usageHistoryRepository ) {
        super();
        this.deviceRepository = deviceRepository;
        this.usageHistoryRepository = usageHistoryRepository;

    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device createDevice(Device device) {
        device.setOn(false);
        device.setLaunchedAt(null);
        device.setOperatingTime(0);
        return this.deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(long id, Device deviceRequest) {
        Device device = deviceRepository.findById(id);
        if(device == null)
            throw new DeviceDoesNotExistException(id);
        if(deviceRequest.getName() !=null)
            device.setName(deviceRequest.getName());
        if(deviceRequest.getDescription() != null)
            device.setDescription(deviceRequest.getDescription());
        if(device.isOn() != deviceRequest.isOn()){
            UsageHistory usageHistory = new UsageHistory(null, new Date(), deviceRequest.isOn(),device);
            usageHistoryRepository.save(usageHistory);
            if (!device.isOn()) {
                device.setLaunchedAt(new Date());
            }else{
                Date currentDate = new Date();
                long msCurrentDate = currentDate.getTime();
                long msLaunchedAt = device.getLaunchedAt().getTime();
                device.setOperatingTime(device.getOperatingTime()+ (msCurrentDate - msLaunchedAt)/1000);
                device.setLaunchedAt(null);
            }
        }
        device.setOn(deviceRequest.isOn());
        return deviceRepository.save(device);
    }

    @Override
    public void deleteDevice(long id) {
        Device device = this.deviceRepository.findById(id);
        if(device == null)
            throw  new DeviceDoesNotExistException(id);
        this.deviceRepository.delete(device);
    }

    @Override
    public Device getDeviceById(long id) {
        Device device = this.deviceRepository.findById(id);
        if(device == null)
            throw  new DeviceDoesNotExistException(id);
        return device;
    }
}
