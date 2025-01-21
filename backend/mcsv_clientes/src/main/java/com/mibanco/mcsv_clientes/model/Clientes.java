package com.mibanco.mcsv_clientes.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "rut", nullable = false, unique = true)
    private String rut;

    @Column(name = "fechaNacimiento", nullable = false)
    private String fechaNacimiento;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "fechaRegistro", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    @Builder.Default
    private Estado estado = Estado.ACTIVO;

    public enum Estado {
        ACTIVO, INACTIVO
    }








}
