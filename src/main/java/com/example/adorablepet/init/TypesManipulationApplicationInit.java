package com.example.adorablepet.init;

import com.example.adorablepet.models.entities.ManipulationEntity;
import com.example.adorablepet.models.entities.TypeOfManipulation;
import com.example.adorablepet.repository.ManipulationEntityRepository;
import com.example.adorablepet.repository.TypeOfManipulationRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypesManipulationApplicationInit implements CommandLineRunner {
    private final ManipulationEntityRepository manipulationRepository;
    private final TypeOfManipulationRepository typeOfManipulationRepository;


    public TypesManipulationApplicationInit(ManipulationEntityRepository manipulationRepository,
                                            TypeOfManipulationRepository typeOfManipulationRepository) {
        this.manipulationRepository = manipulationRepository;
        this.typeOfManipulationRepository = typeOfManipulationRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (typeOfManipulationRepository.count() == 0 && manipulationRepository.count() == 0) {
            initInjections();
            initPuncture();
            initBandages();
            initBloodTests();
            initImagingDiagnostics();
        }
    }

    private void initInjections() {
        initManipulation("INJECTIONS",
                "SUBCUTANEOUS INJECTION - 5",
                "MUSCLE INJECTION - 6",
                "VENOUS INJECTION (up to 20 ml.) - 12",
                "SUBCONJUNCTIVE INJECTION - 15",
                "INTRAARTICULAR, INTRACARDIAC, INTRATRACHEAL - 20"
        );
    }

    private void initPuncture() {
        initManipulation("PUNCTURE",
                "Puncture of the chest (Thoracentesis) - 30",
                "PUNCTURE of the abdominal cavity (Abdomenocentesis) - 25",
                "with an ultrasound - 40",
                "BLADDER PUNCTURE (Cystosynthesis) - 12",
                "with an ultrasound - 25"
        );
    }

    private void initBandages() {
        initManipulation("Bandages",
                "Plain (consisting of a bandage and gauze) - 12",
                "Robert Jones dressing (consisting of bandage, gauze, cotton and patch) - 25",
                "splinting complex bandage with an immobilizing element - 40"
        );
    }

    private void initBloodTests() {
        initManipulation("Blood tests",
                "Taking blood from a dog - 10",
                "Taking blood from a cat - 15",
                "Complete blood count (CBC) - 15",
                "Differential Blood Picture - 20"
        );
    }

    private void initImagingDiagnostics() {

        initManipulation("Imaging diagnostics",
                "Radiography, Photographic diagnosis - 15",
                "Ultrasound - 45");
    }


    private void initManipulation(String manipulationName, String... types) {
        ManipulationEntity manipulation = new ManipulationEntity();
        manipulation.setName(manipulationName);
        manipulation = manipulationRepository.save(manipulation);

        List<TypeOfManipulation> allTypes = new ArrayList<>();


        for (String type: types) {

            TypeOfManipulation aType = new TypeOfManipulation();
            aType.setManipulation(manipulation);
            aType.setTitle(type);
//            String substring= aType.getTitle().
//             substring(Math.max(type.length() - 2,0));
            aType.setPrice(new BigDecimal("1"));
            allTypes.add(aType);
        }

        manipulation.setTypes(allTypes);
        manipulationRepository.save(manipulation);

        typeOfManipulationRepository.saveAll(allTypes);
    }

}
