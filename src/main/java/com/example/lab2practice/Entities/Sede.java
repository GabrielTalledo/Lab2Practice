package com.example.lab2practice.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idSede;

    @Column(nullable = true)
    private String nombreSede;

    @Column(nullable = true)
    private String direccion;
}
