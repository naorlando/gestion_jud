package com.tuempresa.gestionjud.mapper;

import com.tuempresa.gestionjud.domain.Comentario;
import com.tuempresa.gestionjud.dto.ComentarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {
    @Mapping(source = "expediente.id", target = "expedienteId")
    @Mapping(source = "usuario.id", target = "usuarioId")
    ComentarioDto toDto(Comentario comentario);
}
