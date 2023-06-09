package fr.myproject.machinescontrolserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/d")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
