package com.example.ESTADISTICAS_BACKEND.modelos.mapas;

import com.example.ESTADISTICAS_BACKEND.modelos.Estudiante;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.EstudianteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaEstudianteDTO {

    IMapaEstudianteDTO INSTANCE = Mappers.getMapper(IMapaEstudianteDTO.class);

    @Mapping(source = "usuario.nombre", target = "nombre")
    @Mapping(source = "usuario.correo", target = "correo")
    @Mapping(source = "programa", target = "programa")
    @Mapping(source = "grupo.nombre", target = "grupo")
    @Mapping(source = "semestre", target = "semestre")
    EstudianteDTO convertirModeloADTO(Estudiante estudiante);

    List<EstudianteDTO> convertirModelosADTOS(List<Estudiante> estudiantes);
}
