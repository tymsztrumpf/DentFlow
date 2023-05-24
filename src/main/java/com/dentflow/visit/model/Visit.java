package com.dentflow.visit.model;

import com.dentflow.patient.model.Patient;
import com.dentflow.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visit_date")
    private LocalDateTime visitDate;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    private Type type;

    private int lengthOfTheVisit;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "doctor_description")
    private String doctorDescription;

    @Column(name = "receptionist_description")
    private String receptionistDescription;
}
