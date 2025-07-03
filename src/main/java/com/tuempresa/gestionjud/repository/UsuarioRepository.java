package com.tuempresa.gestionjud.repository;

import com.tuempresa.gestionjud.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
