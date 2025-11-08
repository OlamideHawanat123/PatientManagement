package com.patientservice.mapper;

import com.patientservice.dto.PatientResponseDto;
import com.patientservice.model.Patient;

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
}
