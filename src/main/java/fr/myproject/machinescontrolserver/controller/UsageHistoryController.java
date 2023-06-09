package fr.myproject.machinescontrolserver.controller;


import fr.myproject.machinescontrolserver.dto.DeviceDto;
import fr.myproject.machinescontrolserver.model.UsageHistory;
import fr.myproject.machinescontrolserver.service.DeviceService;
import fr.myproject.machinescontrolserver.service.UsageHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/usageHistory")
public class UsageHistoryController {
    private final ModelMapper modelMapper;
    private final UsageHistoryService usageHistoryService;

    public UsageHistoryController(ModelMapper modelMapper,UsageHistoryService usageHistoryService) {
        super();
        this.modelMapper = modelMapper;
        this.usageHistoryService =  usageHistoryService;
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<List<UsageHistory>> getAllUsageHistoryOfADevice(@PathVariable String deviceId){
        return  ResponseEntity.ok().body(usageHistoryService.getUsageHistoryOfADevice(Long.parseLong(deviceId)).stream().map(device -> modelMapper.map(device, UsageHistory.class)).collect(Collectors.toList()));
    }

    @GetMapping("/toto")
    public ResponseEntity<String> toto(){
        return  ResponseEntity.ok().body("toto");
    }



}
