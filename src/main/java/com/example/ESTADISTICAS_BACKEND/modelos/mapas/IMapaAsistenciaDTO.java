package com.example.ESTADISTICAS_BACKEND.modelos.mapas;

import com.example.ESTADISTICAS_BACKEND.modelos.Asistencia;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.AsistenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaAsistenciaDTO {

    IMapaAsistenciaDTO INSTANCE = Mappers.getMapper(IMapaAsistenciaDTO.class);

    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "observaciones", target = "observaciones")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "estudiante.usuario.nombre", target = "estudiante")
    AsistenciaDTO convertirModeloADTO(Asistencia asistencia);

    List<AsistenciaDTO> convertirModelosADTOS(List<Asistencia> asistencias);
}
