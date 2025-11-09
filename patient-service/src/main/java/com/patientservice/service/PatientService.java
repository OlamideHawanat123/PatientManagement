package com.patientservice.service;

import com.patientservice.dto.PatientRequestDto;
import com.patientservice.dto.PatientResponseDto;
import com.patientservice.exception.EmailAlreadyExistsException;
import com.patientservice.mapper.PatientMapper;
import com.patientservice.model.Patient;
import com.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) throw new EmailAlreadyExistsException("A patient with this email" + "already exist" + patientRequestDto.getEmail());
        Patient patient = patientRepository.save(PatientMapper.mapToModel(patientRequestDto));
        return PatientMapper.mapToDto(patient);
    }

    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto){
//        Patient patient = patientRepository.findById(id).orElse(()->{ throw new PatientNotFoundException})
    }
}

