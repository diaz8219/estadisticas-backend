package com.example.ESTADISTICAS_BACKEND.modelos.mapas;

import com.example.ESTADISTICAS_BACKEND.modelos.Grupo;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.GrupoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaGrupoDTO {

    IMapaGrupoDTO INSTANCE = Mappers.getMapper(IMapaGrupoDTO.class);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "semestre", target = "semestre")
    @Mapping(source = "materia.nombre", target = "materia")
    GrupoDTO convertirModeloADTO(Grupo grupo);

    List<GrupoDTO> convertirModelosADTOS(List<Grupo> grupos);
}
