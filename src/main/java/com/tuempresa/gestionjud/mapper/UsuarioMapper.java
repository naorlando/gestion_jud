package com.tuempresa.gestionjud.mapper;

import com.tuempresa.gestionjud.domain.Usuario;
import com.tuempresa.gestionjud.dto.CreateUsuarioDto;
import com.tuempresa.gestionjud.dto.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDto toDto(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    Usuario fromCreateDto(CreateUsuarioDto dto);
}
