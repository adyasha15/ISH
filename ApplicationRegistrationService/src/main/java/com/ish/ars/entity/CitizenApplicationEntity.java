package com.ish.ars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CITIZEN_APPLICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenApplicationEntity {
    @Id
    @SequenceGenerator(name="gen1_seq",sequenceName = "App_ID_SEQ",initialValue = 1000,allocationSize = 1)
    @GeneratedValue(generator = "gen1_seq",strategy = GenerationType.SEQUENCE)
    private Integer appId;
    @Column(length = 30)
    private String fullName;
    @Column(length = 1)
    private String gender;
    @Column(length = 30)
    private String email;
    private Long phoneNo;
    private Long ssn;
    @Column(length = 30)
    private String stateName;
    private LocalDateTime dob;
    @Column(length = 30)
    private String createdBy;
    @Column(length = 30)
    private String updatedBy;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updationDate;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate creationDate;


}
