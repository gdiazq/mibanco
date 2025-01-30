package com.mibanco.mcsv_auth.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mibanco.mcsv_auth.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, UUID> {

    Optional<Usuarios> findByUsuario(String usuario);

    boolean existsByUsuario(String usuario);

    boolean existsByCorreo(String correo);

}
