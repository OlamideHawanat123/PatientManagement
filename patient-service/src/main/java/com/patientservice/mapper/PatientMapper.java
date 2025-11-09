package com.patientservice.mapper;

import com.patientservice.dto.PatientRequestDto;
import com.patientservice.dto.PatientResponseDto;
import com.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDto mapToDto(Patient patient){
        PatientResponseDto response = new PatientResponseDto();
        response.setId(patient.getId().toString());
        response.setName(patient.getName());
        response.setAddress(patient.getAddress());
        response.setEmail(patient.getEmail());
        response.setDateOfBirth(patient.getDateOfBirth().toString());
        return response;

    }

    public static Patient mapToModel(PatientRequestDto patientRequestDto){
        Patient patient = new Patient();
        patient.setName(patientRequestDto.getName());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDto.getRegisteredDate()));
        return patient;
    }
}
