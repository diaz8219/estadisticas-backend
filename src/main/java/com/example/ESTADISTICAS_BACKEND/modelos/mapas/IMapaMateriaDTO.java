package com.example.ESTADISTICAS_BACKEND.modelos.mapas;

import com.example.ESTADISTICAS_BACKEND.modelos.Materia;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.MateriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaMateriaDTO {

    IMapaMateriaDTO INSTANCE = Mappers.getMapper(IMapaMateriaDTO.class);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "codigo", target = "codigo")
    MateriaDTO convertirModeloADTO(Materia materia);

    List<MateriaDTO> convertirModelosADTOS(List<Materia> materias);

}
