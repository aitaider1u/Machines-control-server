package fr.myproject.machinescontrolserver.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsageHistoryDto {
    private Long id;
    private Date actionDate;
    private boolean isOn;
}
