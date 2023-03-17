package com.example.adorablepet.web;


import com.example.adorablepet.models.dtos.TypeOfManipulationDTO;
import com.example.adorablepet.service.TypeOfManipulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/manipulations")
public class PriceListController {

    private final TypeOfManipulationService typeOfManipulationService;

    public PriceListController(TypeOfManipulationService typeOfManipulationService) {
        this.typeOfManipulationService = typeOfManipulationService;
    }

    @GetMapping
    public ResponseEntity<List<TypeOfManipulationDTO>> getAllType() {
        return ResponseEntity.
                ok(typeOfManipulationService.getAllTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeOfManipulationDTO> getTypeOfManipulationById(
            @PathVariable("id") Long typeId) {
        Optional<TypeOfManipulationDTO> theType = typeOfManipulationService.
                findTypeOfManipulationById(typeId);

        return
                theType.
                        map(ResponseEntity::ok).
                        orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<TypeOfManipulationDTO> createType(@RequestBody TypeOfManipulationDTO newType,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        long newTypeId = typeOfManipulationService.createTypeOfManipulation(newType);

        return ResponseEntity.created(uriComponentsBuilder.
                        path("/api/manipulations/{id}").build(newTypeId)).
                build();
    }


}
