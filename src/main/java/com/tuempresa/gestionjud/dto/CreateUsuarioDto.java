package com.tuempresa.gestionjud.dto;

import com.tuempresa.gestionjud.domain.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUsuarioDto {
    private String nombre;
    private String email;
    private String password;
    private Rol rol;
}
