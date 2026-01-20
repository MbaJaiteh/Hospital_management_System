error id: file:///C:/Users/EbrimaMbye/Desktop/A_Teaching/binta/FINAL%20PROJECT%20-%20PROGRAMMING%20II/Hospital_management_System/hospital_mangement_system/src/main/java/com/group8/hospital_mangement_system/model/Department.java:com/fasterxml/jackson/annotation/JsonIgnore#
file:///C:/Users/EbrimaMbye/Desktop/A_Teaching/binta/FINAL%20PROJECT%20-%20PROGRAMMING%20II/Hospital_management_System/hospital_mangement_system/src/main/java/com/group8/hospital_mangement_system/model/Department.java
empty definition using pc, found symbol in pc: com/fasterxml/jackson/annotation/JsonIgnore#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 95
uri: file:///C:/Users/EbrimaMbye/Desktop/A_Teaching/binta/FINAL%20PROJECT%20-%20PROGRAMMING%20II/Hospital_management_System/hospital_mangement_system/src/main/java/com/group8/hospital_mangement_system/model/Department.java
text:
```scala
package com.group8.hospital_mangement_system.model;

import com.fasterxml.jackson.annotation.@@JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @NotBlank
    @Column(nullable = false, unique = true)
```


#### Short summary: 

empty definition using pc, found symbol in pc: com/fasterxml/jackson/annotation/JsonIgnore#