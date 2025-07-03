package com.tuempresa.gestionjud.mapper;

import com.tuempresa.gestionjud.domain.Expediente;
import com.tuempresa.gestionjud.dto.CreateExpedienteDto;
import com.tuempresa.gestionjud.dto.ExpedienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpedienteMapper {
    ExpedienteDto toDto(Expediente expediente);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "provisionContable", ignore = true)
    Expediente fromCreateDto(CreateExpedienteDto dto);
}
