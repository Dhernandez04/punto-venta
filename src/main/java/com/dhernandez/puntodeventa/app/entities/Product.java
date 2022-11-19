package com.dhernandez.puntodeventa.app.entities;

import com.dhernandez.puntodeventa.app.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "price")
    @NotBlank
    private BigDecimal price;

    @Column(name = "stock")
    @NotBlank
    private Integer stock;

    @Column(name = "image")
    private String image;

    @Column(name = "cost")
    @NotBlank
    private BigDecimal cost;

    @Column(name = "status")
    @NotBlank
    private Status status;

    @Column(name = "create_at")
    @NotBlank
    private LocalDate createAt;

    @Column(name = "category")
    @NotBlank
    private Category category;
}
