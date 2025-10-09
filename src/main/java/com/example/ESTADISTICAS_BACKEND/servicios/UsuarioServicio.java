package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Usuario;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.UsuarioDTO;
import com.example.ESTADISTICAS_BACKEND.modelos.mapas.IMapaUsuarioDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    @Autowired
    private IMapaUsuarioDTO mapaUsuarioDTO;

    public UsuarioDTO guardarUsuario(Usuario usuario) throws Exception {
        try {
            Usuario usuarioGuardado = usuarioRepositorio.save(usuario);
            return mapaUsuarioDTO.convertirModeloADTO(usuarioGuardado);
        } catch (Exception e) {
            throw new Exception(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    public List<UsuarioDTO> listarUsuarios() throws Exception {
        try {
            List<Usuario> usuarios = usuarioRepositorio.findAll();

            if (usuarios.isEmpty()) {
                throw new Exception(
                        MensajesError.ERROR_LISTAR_USUARIO.getDescripcion() + ": No hay usuarios registrados."
                );
            }

            return mapaUsuarioDTO.convertirModelosADTOS(usuarios);
        } catch (Exception e) {
            throw new Exception(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    public UsuarioDTO obtenerUsuarioPorId(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioOpt = usuarioRepositorio.findById(id);

            if (usuarioOpt.isEmpty()) {
                throw new Exception(
                        MensajesError.ERROR_USUARIO_NO_ENCONTRADO.getDescripcion()
                                + ": No se encontró un usuario con el ID " + id
                );
            }

            return mapaUsuarioDTO.convertirModeloADTO(usuarioOpt.get());
        } catch (Exception e) {
            throw new Exception(MensajesError.ERROR_USUARIO_NO_ENCONTRADO.getDescripcion() + ": " + e.getMessage());
        }
    }

}
