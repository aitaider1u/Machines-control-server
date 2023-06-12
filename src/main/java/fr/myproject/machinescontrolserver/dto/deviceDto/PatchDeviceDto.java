package fr.myproject.machinescontrolserver.dto.deviceDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//https://examples.javacodegeeks.com/spring-boot-patch-request-example/#:~:text=PATCH%20is%20used%20when%20we,requests%20onto%20the%20controller%20methods.
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatchDeviceDto {   // useful for a partial update.
    private String op;
    private String key;
    private String value;
}
