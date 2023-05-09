package com.dentflow.patient.model;


import com.dentflow.tooth.model.Tooth;
import com.dentflow.visit.model.Visit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    private String phoneNumber;

    @JsonIgnore
    @OneToMany
    private Set<Visit> visits;

    @OneToMany
    private Set<Tooth> teeth;

    public void addTooth(Tooth tooth){
        teeth.add(tooth);
    }
}
