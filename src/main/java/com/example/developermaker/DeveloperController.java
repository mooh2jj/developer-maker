package com.example.developermaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {


    @GetMapping
    public String getDevelopers() {
        return List.of("Developer 1", "Developer 2", "Developer 3").toString();
    }
}
