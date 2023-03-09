package com.example.adorablepet.init;

import com.example.adorablepet.service.TypeOfHelpService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final TypeOfHelpService typeOfHelpService;

    public DatabaseInit(TypeOfHelpService typeOfHelpService) {
        this.typeOfHelpService = typeOfHelpService;
    }

    @Override
    public void run(String... args) throws Exception {
typeOfHelpService.initTypeOfHelps();
    }
}
