package com.group8.hospital_mangement_system.dto;

public record DepartmentDoctorResponse(
        int id,
        String firstName,
        String lastName,
        String specialty,
        boolean available) {
}
