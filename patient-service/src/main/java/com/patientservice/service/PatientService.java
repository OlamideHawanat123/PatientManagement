package com.patientservice.service;

import com.patientservice.dto.PatientRequestDto;
import com.patientservice.dto.PatientResponseDto;
import com.patientservice.mapper.PatientMapper;
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
        return patients.stream().map(PatientMapper::mapToDto).toList();
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto){
        Patient patient = patientRepository.save(PatientMapper.mapToModel(patientRequestDto));
        return PatientMapper.mapToDto(patient);
    }
}

