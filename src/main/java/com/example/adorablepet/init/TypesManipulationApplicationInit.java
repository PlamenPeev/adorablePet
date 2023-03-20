package com.example.adorablepet.init;

import com.example.adorablepet.models.dtos.TypeOfManipulationDTO;
import com.example.adorablepet.models.entities.ManipulationEntity;
import com.example.adorablepet.models.entities.TypeOfManipulation;
import com.example.adorablepet.repository.ManipulationEntityRepository;
import com.example.adorablepet.repository.TypeOfManipulationRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            initExaminations();
            initInjections();
            initPuncture();
            initBandages();
            initSkinDiagnosis();
            initBloodTests();
            initImagingDiagnostics();
        }
    }

    private void initExaminations() {
        initManipulation("EXAMINATION",
                List.of(new TypeOfManipulationDTO().setTitle("Dog and Cat").setPrice(new BigDecimal(22)),
                        new TypeOfManipulationDTO().setTitle("CONTROL OR PARTIAL REVIEW").setPrice(new BigDecimal(10)),
                        new TypeOfManipulationDTO().setTitle("DECORATIVE ANIMALS").setPrice(new BigDecimal(13)),
                        new TypeOfManipulationDTO().setTitle("EXOTIC BIRDS - Parrots").setPrice(new BigDecimal(18)),
                        new TypeOfManipulationDTO().setTitle("VAGINAL EXAMINATION").setPrice(new BigDecimal(12)),
                        new TypeOfManipulationDTO().setTitle("RECTAL EXAMINATION").setPrice(new BigDecimal(6)),
                        new TypeOfManipulationDTO().setTitle("OTOSCOPE").setPrice(new BigDecimal(10)),
                        new TypeOfManipulationDTO().setTitle("DENTAL").setPrice(new BigDecimal(20)),
                        new TypeOfManipulationDTO().setTitle("OPHTHALMOLOGICAL").setPrice(new BigDecimal(15))));
    }

    private void initInjections() {
        initManipulation("INJECTIONS",
                List.of(new TypeOfManipulationDTO().setTitle("SUBCUTANEOUS INJECTION").setPrice(new BigDecimal(5)),
                        new TypeOfManipulationDTO().setTitle("MUSCLE INJECTION ").setPrice(new BigDecimal(6)),
                        new TypeOfManipulationDTO().setTitle("VENOUS INJECTION (up to 20 ml.)").setPrice(new BigDecimal(12)),
                        new TypeOfManipulationDTO().setTitle("SUBCONJUNCTIVE INJECTION ").setPrice(new BigDecimal(15)),
                        new TypeOfManipulationDTO().setTitle("INTRAARTICULAR, INTRACARDIAC, INTRATRACHEAL").setPrice(new BigDecimal(20))));
    }

    private void initPuncture() {
        initManipulation("PUNCTURE",
                List.of(new TypeOfManipulationDTO().setTitle("Puncture of the chest (Thoracentesis)").setPrice(new BigDecimal(30)),
                        new TypeOfManipulationDTO().setTitle("PUNCTURE of the abdominal cavity (Abdomenocentesis)").setPrice(new BigDecimal(25)),
                        new TypeOfManipulationDTO().setTitle("with an ultrasound").setPrice(new BigDecimal(40)),
                        new TypeOfManipulationDTO().setTitle("BLADDER PUNCTURE (Cystosynthesis)").setPrice(new BigDecimal(12)),
                        new TypeOfManipulationDTO().setTitle("with an ultrasound").setPrice(new BigDecimal(25))));
    }

    private void initBandages() {
        initManipulation("Bandages",
                List.of(new TypeOfManipulationDTO().setTitle("Plain (consisting of a bandage and gauze)").setPrice(new BigDecimal(12)),
                        new TypeOfManipulationDTO().setTitle("Robert Jones dressing (consisting of bandage, gauze, cotton and patch)").setPrice(new BigDecimal(25)),
                        new TypeOfManipulationDTO().setTitle("splinting complex bandage with an immobilizing element").setPrice(new BigDecimal(40))));
    }


    private void initSkinDiagnosis() {
        initManipulation("Diagnosis of skin diseases",
                List.of(new TypeOfManipulationDTO().setTitle("Taking material for research").setPrice(new BigDecimal(11)),
                        new TypeOfManipulationDTO().setTitle("Microscopic examination for scabies").setPrice(new BigDecimal(10)),
                        new TypeOfManipulationDTO().setTitle("Fungal Culture").setPrice(new BigDecimal(27))));
    }

    private void initBloodTests() {
        initManipulation("Blood tests",
                List.of(new TypeOfManipulationDTO().setTitle("Taking blood from a dog").setPrice(new BigDecimal(10)),
                        new TypeOfManipulationDTO().setTitle("Taking blood from a cat").setPrice(new BigDecimal(15)),
                        new TypeOfManipulationDTO().setTitle("Complete blood count (CBC)").setPrice(new BigDecimal(15)),
                        new TypeOfManipulationDTO().setTitle("Differential Blood Picture").setPrice(new BigDecimal(20))));
    }

    private void initImagingDiagnostics() {

        initManipulation("Imaging diagnostics",
                List.of(new TypeOfManipulationDTO().setTitle("Ultrasound").setPrice(new BigDecimal(45)),
                        new TypeOfManipulationDTO().setTitle("Radiography, Photographic diagnosis")
                                .setPrice(new BigDecimal(15))));
    }



    private void initManipulation(String manipulationName, List<TypeOfManipulationDTO> types) {
        ManipulationEntity manipulation = new ManipulationEntity();
        manipulation.setName(manipulationName);
        manipulation = manipulationRepository.save(manipulation);

        List<TypeOfManipulation> allTypes = new ArrayList<>();


        for (TypeOfManipulationDTO type: types) {

            TypeOfManipulation aType = new TypeOfManipulation();

            aType.setManipulation(manipulation);
            aType.setTitle(type.getTitle());
            aType.setPrice(type.getPrice());
            allTypes.add(aType);
        }

        manipulation.setTypes(allTypes);
        manipulationRepository.save(manipulation);

        typeOfManipulationRepository.saveAll(allTypes);
    }


}
