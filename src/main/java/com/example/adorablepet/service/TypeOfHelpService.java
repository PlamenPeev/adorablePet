package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.repository.TypeOfHelpRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TypeOfHelpService {

    private final TypeOfHelpRepository typeOfHelpRepository;

    public TypeOfHelpService(TypeOfHelpRepository typeOfHelpRepository) {
        this.typeOfHelpRepository = typeOfHelpRepository;
    }

    public void initTypeOfHelps() {
        if(typeOfHelpRepository.count()==0){

            Arrays.stream(TypeOfHelpEnumName.values())
                    .forEach(typeOfHelpEnumName -> {
                        this.typeOfHelpRepository
                                .save(new TypeOfHelp(typeOfHelpEnumName,String.format("Description for %s",
                                        typeOfHelpEnumName.name())));
                    });

        }
    }

    public TypeOfHelp findTypeOfHelpByTypeOfHelpEnumName(TypeOfHelpEnumName typeOfHelpEnumName){
return this.typeOfHelpRepository.
        findTypeOfHelpByTypeOfHelpEnumName(typeOfHelpEnumName).orElse(null);
    }
}
