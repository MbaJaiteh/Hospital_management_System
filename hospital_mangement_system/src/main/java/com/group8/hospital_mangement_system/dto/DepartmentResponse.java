package com.group8.hospital_mangement_system.dto;

public record DepartmentResponse(
        short id,
        String name,
        int doctorCount) {
}
