package com.dhernandez.puntodeventa.app.entities;

import com.dhernandez.puntodeventa.app.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;


}
