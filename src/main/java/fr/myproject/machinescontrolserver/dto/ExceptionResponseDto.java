package fr.myproject.machinescontrolserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponseDto {
    private String errorMessage;
    private String requestedURI;

}
