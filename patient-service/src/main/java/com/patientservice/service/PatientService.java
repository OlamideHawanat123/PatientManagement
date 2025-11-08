package com.patientservice.service;

import com.patientservice.dto.PatientResponseDto;
import com.patientservice.model.Patient;
import com.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDto> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();
//        return
    }
}
