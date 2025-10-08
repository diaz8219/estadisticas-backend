package com.example.ESTADISTICAS_BACKEND.modelos.mapas;

import com.example.ESTADISTICAS_BACKEND.modelos.Usuario;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaUsuarioDTO {
    IMapaUsuarioDTO INSTANCE = Mappers.getMapper(IMapaUsuarioDTO.class);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "rol", target = "rol")
    @Mapping(source = "estado", target = "estado")
    UsuarioDTO convertirModeloADTO(Usuario usuario);

    List<UsuarioDTO> convertirModelosADTOS(List<Usuario> usuarios);
}
