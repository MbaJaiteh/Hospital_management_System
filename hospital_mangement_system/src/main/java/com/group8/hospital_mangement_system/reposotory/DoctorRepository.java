package com.group8.hospital_mangement_system.reposotory;

import com.group8.hospital_mangement_system.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findByDepartmentId(short departmentId);
}
