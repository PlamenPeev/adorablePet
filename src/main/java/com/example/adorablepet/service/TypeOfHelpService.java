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

                        TypeOfHelp typeOfHelp = new TypeOfHelp();

                        typeOfHelp.setTypeOfHelpEnumName(typeOfHelpEnumName);
                        switch (typeOfHelpEnumName){
                            case TREATMENT -> typeOfHelp.setDescription("Medical treatment for pets who are sick or " +
                                    "injured. This may include examinations, diagnostic tests, surgery, medication, " +
                                    "and other forms of medical care.");
                            case PREVENTION-> typeOfHelp.setDescription("Preventive care services to help keep pets" +
                                    " healthy. This includes vaccinations, parasite control, dental care, and " +
                                    "nutrition counseling.");
                            case GROOMING-> typeOfHelp.setDescription("Grooming services for pets. This may include " +
                                    "bathing, haircuts, nail trimming, and other grooming services to help pets " +
                                    "look and feel their best.");
                            case HOTEL-> typeOfHelp.setDescription("Pet boarding services. This means that pet owners " +
                                    "can leave their pets at the clinic while they are away, knowing that their pets " +
                                    "are being cared for by trained professionals.");
                            case SCHOOL-> typeOfHelp.setDescription("Training or behavior modification programs for pets." +
                                    " This can be particularly helpful for pet owners who are struggling with obedience " +
                                    "or behavior issues.");

                        }
                        this.typeOfHelpRepository
                                .save(typeOfHelp);
                    });

        }
    }

    public TypeOfHelp findByTypeOfHelpEnumName(TypeOfHelpEnumName typeOfHelpEnumName){
return this.typeOfHelpRepository.
        findByTypeOfHelpEnumName(typeOfHelpEnumName).orElse(null);
    }
}
