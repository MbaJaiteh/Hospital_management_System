package com.group8.hospital_mangement_system.dto;

import jakarta.validation.constraints.NotBlank;

public record DepartmentRequest(
        @NotBlank(message = "Department name is required") String name) {
}
