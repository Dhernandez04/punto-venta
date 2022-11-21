package com.dhernandez.puntodeventa.app.entities;

import com.dhernandez.puntodeventa.app.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "created_at")
    @NotBlank
    private LocalDate createAt;

    @Column(name = "created_at")
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "role_id")
    @NotBlank
    private List<Role> roles;
    @Column(name = "detail_id")
    @NotBlank
    private DetailsUser details;

}
