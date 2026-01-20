package com.group8.hospital_mangement_system.service;

import com.group8.hospital_mangement_system.dto.DepartmentDoctorResponse;
import com.group8.hospital_mangement_system.dto.DepartmentRequest;
import com.group8.hospital_mangement_system.dto.DepartmentResponse;
import com.group8.hospital_mangement_system.dto.MessageResponse;
import com.group8.hospital_mangement_system.model.Department;
import com.group8.hospital_mangement_system.model.Doctor;
import com.group8.hospital_mangement_system.reposotory.DepartmentRepository;
import com.group8.hospital_mangement_system.reposotory.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public DepartmentResponse createDepartment(DepartmentRequest request) {
        String name = normalizeName(request.name());

        if (departmentRepository.existsByNameIgnoreCase(name)) {
            throw new IllegalStateException("Department already exists");
        }

        Department department = new Department();
        department.setName(name);
        Department saved = departmentRepository.save(department);

        return toResponse(saved);
    }

    public DepartmentResponse updateDepartment(short id, DepartmentRequest request) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        String name = normalizeName(request.name());
        Department existing = departmentRepository.findByNameIgnoreCase(name).orElse(null);
        if (existing != null && existing.getId() != id) {
            throw new IllegalStateException("Department name already in use");
        }

        department.setName(name);
        Department saved = departmentRepository.save(department);
        return toResponse(saved);
    }

    public MessageResponse deleteDepartment(short id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        List<Doctor> doctors = doctorRepository.findByDepartmentId(id);
        if (!doctors.isEmpty()) {
            throw new IllegalStateException("Cannot delete department while doctors are assigned to it");
        }

        departmentRepository.delete(department);
        return new MessageResponse("Department deleted");
    }

    public DepartmentResponse getDepartmentById(short id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));
        return toResponse(department);
    }

    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<DepartmentDoctorResponse> getDoctorsByDepartment(short departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        return doctorRepository.findByDepartmentId(department.getId())
                .stream()
                .map(doctor -> new DepartmentDoctorResponse(
                        doctor.getId(),
                        doctor.getUser() != null ? doctor.getUser().getFirstName() : null,
                        doctor.getUser() != null ? doctor.getUser().getLastName() : null,
                        doctor.getSpecialty(),
                        doctor.isAvailable()))
                .collect(Collectors.toList());
    }

    private DepartmentResponse toResponse(Department department) {
        int doctorCount = department.getDoctors() == null ? 0 : department.getDoctors().size();
        return new DepartmentResponse(department.getId(), department.getName(), doctorCount);
    }

    private String normalizeName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Department name is required");
        }
        String normalized = name.trim();
        if (normalized.isBlank()) {
            throw new IllegalArgumentException("Department name is required");
        }
        return normalized;
    }
}
