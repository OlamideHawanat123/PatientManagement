package com.patientservice.controller;

import com.patientservice.dto.PatientRequestDto;
import com.patientservice.dto.PatientResponseDto;
import com.patientservice.repository.PatientRepository;
import com.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<?> getPatients(){
        List<PatientResponseDto> patients = patientService.getAllPatients();
        return ResponseEntity.ok().body(patients);

    }

    @PostMapping
    public ResponseEntity<?> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

}
