error id: file:///C:/Users/EbrimaMbye/Desktop/A_Teaching/binta/FINAL%20PROJECT%20-%20PROGRAMMING%20II/Hospital_management_System/hospital_mangement_system/src/main/java/com/group8/hospital_mangement_system/controller/DepartmentController.java:java/util/List#
file:///C:/Users/EbrimaMbye/Desktop/A_Teaching/binta/FINAL%20PROJECT%20-%20PROGRAMMING%20II/Hospital_management_System/hospital_mangement_system/src/main/java/com/group8/hospital_mangement_system/controller/DepartmentController.java
empty definition using pc, found symbol in pc: java/util/List#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 709
uri: file:///C:/Users/EbrimaMbye/Desktop/A_Teaching/binta/FINAL%20PROJECT%20-%20PROGRAMMING%20II/Hospital_management_System/hospital_mangement_system/src/main/java/com/group8/hospital_mangement_system/controller/DepartmentController.java
text:
```scala
package com.group8.hospital_mangement_system.controller;

import com.group8.hospital_mangement_system.dto.DepartmentDoctorResponse;
import com.group8.hospital_mangement_system.dto.DepartmentRequest;
import com.group8.hospital_mangement_system.dto.DepartmentResponse;
import com.group8.hospital_mangement_system.dto.MessageResponse;
import com.group8.hospital_mangement_system.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.@@List;

@RestController
@RequestMapping({ "/api/department", "/api/departments" })
@RequiredArgsConstructor
@Validated
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody @Valid DepartmentRequest request) {
        try {
            DepartmentResponse created = departmentService.createDepartment(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable short id) {
        try {
            return ResponseEntity.ok(departmentService.getDepartmentById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable short id, @RequestBody @Valid DepartmentRequest request) {
        try {
            return ResponseEntity.ok(departmentService.updateDepartment(id, request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable short id) {
        try {
            return ResponseEntity.ok(departmentService.deleteDepartment(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/{id}/doctors")
    public ResponseEntity<?> getDoctorsForDepartment(@PathVariable short id) {
        try {
            List<DepartmentDoctorResponse> doctors = departmentService.getDoctorsByDepartment(id);
            return ResponseEntity.ok(doctors);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(e.getMessage()));
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/List#