package com.ish.ars.binding;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CitizenAppRegistrationInput {
    private String fullName;
    private String email;
    private String gender;
    private Long phoneNo;
    private Long ssn;
    private LocalDate dob;

}
