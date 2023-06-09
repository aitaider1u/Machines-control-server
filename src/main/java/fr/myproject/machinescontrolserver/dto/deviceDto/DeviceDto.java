package fr.myproject.machinescontrolserver.dto.deviceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    private long id;
    private String name;
    private String description;
    private boolean isOn;
    private Date launchedAt;
    private long operatingTime;
}
