package com.tuempresa.gestionjud.mapper;

import com.tuempresa.gestionjud.domain.Documento;
import com.tuempresa.gestionjud.dto.DocumentoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
    @Mapping(source = "expediente.id", target = "expedienteId")
    @Mapping(source = "parentDocumento.id", target = "parentDocumentoId")
    @Mapping(source = "rutaArchivo", target = "url")
    DocumentoDto toDto(Documento documento);
}
