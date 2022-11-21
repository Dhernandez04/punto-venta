package com.dhernandez.puntodeventa.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detail_user")
public class DetailsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "lastname")
    private String telephone;
    @Column(name = "lastname")
    private LocalDate dateOfBirth;


}
