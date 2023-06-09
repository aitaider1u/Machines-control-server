package fr.myproject.machinescontrolserver.service;

import fr.myproject.machinescontrolserver.model.Device;

import java.util.List;

public interface DeviceService {
    List<Device> getAllDevices();
    Device createDevice(Device device);
    Device updateDevice(long id, Device device);
    void deleteDevice(long id);
    Device getDeviceById(long id);
}
