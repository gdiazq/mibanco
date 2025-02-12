package com.mibanco.mcsv_auth.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;
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
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contraseña", nullable = false, unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    @Builder.Default
    private Rol rol = Rol.CLIENTE;

        public enum Rol {
            CLIENTE, ADMINISTRADOR, EMPLEADO
        }

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha_registro;

    @Column(name = "fecha_actualizacion", nullable = false, updatable = true )
    @LastModifiedDate
    private LocalDateTime fecha_actualizacion;

}
