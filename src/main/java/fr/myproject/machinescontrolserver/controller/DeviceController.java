package fr.myproject.machinescontrolserver.controller;

import fr.myproject.machinescontrolserver.dto.deviceDto.DeviceDto;
import fr.myproject.machinescontrolserver.model.Device;
import fr.myproject.machinescontrolserver.service.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final ModelMapper modelMapper;
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService, ModelMapper modelMapper) {
        super();
        this.deviceService = deviceService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ResponseEntity<List<DeviceDto>>  getAllDevices(){
        return  ResponseEntity.ok().body(deviceService.getAllDevices().stream().map(device -> modelMapper.map(device, DeviceDto.class)).collect(Collectors.toList()));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceDto> createDevice(@RequestBody DeviceDto deviceDto) {
        // convert DTO to entity
        Device deviceRequest = modelMapper.map(deviceDto, Device.class);
        Device device = deviceService.createDevice(deviceRequest);
        // convert entity to DTO
        DeviceDto deviceResponse = modelMapper.map(device, DeviceDto.class);
        return ResponseEntity.ok().body(deviceResponse);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceDto> updateDevice(@PathVariable long id, @RequestBody DeviceDto deviceDto) {
        // convert DTO to entity
        Device deviceRequest = modelMapper.map(deviceDto, Device.class);
        Device device = deviceService.updateDevice(id,deviceRequest);
        // convert entity to DTO
        DeviceDto deviceResponse = modelMapper.map(device, DeviceDto.class);
        return ResponseEntity.ok().body(deviceResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable long id) {
        // convert DTO to entity
        Device device = deviceService.getDeviceById(id);
        // convert entity to DTO
        DeviceDto deviceResponse = modelMapper.map(device, DeviceDto.class);
        return ResponseEntity.ok().body(deviceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDevice(@PathVariable long id) {
        // convert DTO to entity
        deviceService.deleteDevice(id);
        // convert entity to DTO
        return ResponseEntity.ok().body(true);
    }
}
