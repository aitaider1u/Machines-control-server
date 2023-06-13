package fr.myproject.machinescontrolserver.controller;
import fr.myproject.machinescontrolserver.dto.UsageHistoryDto;
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
    public ResponseEntity<List<UsageHistoryDto>> getAllUsageHistoryOfADevice(@PathVariable String deviceId){
        return  ResponseEntity.ok().body(usageHistoryService.getUsageHistoryOfADevice(Long.parseLong(deviceId)).stream().map(usageHistory -> modelMapper.map(usageHistory, UsageHistoryDto.class)).collect(Collectors.toList()));
    }

}
