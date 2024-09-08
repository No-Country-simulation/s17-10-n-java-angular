package com.dev.ForoEscolar.mapper.user;

import com.dev.ForoEscolar.dtos.user.UserRequestDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import com.dev.ForoEscolar.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T16:56:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDTO toResponseDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String nombre = null;
        String tipoDocumento = null;
        String dni = null;
        String apellido = null;
        String telefono = null;
        String institucion = null;
        String rol = null;
        boolean activo = false;

        id = user.getId();
        email = user.getEmail();
        nombre = user.getNombre();
        if ( user.getTipoDocumento() != null ) {
            tipoDocumento = user.getTipoDocumento().name();
        }
        dni = user.getDni();
        apellido = user.getApellido();
        telefono = user.getTelefono();
        institucion = user.getInstitucion();
        if ( user.getRol() != null ) {
            rol = user.getRol().name();
        }
        activo = user.isActivo();

        UserResponseDTO userResponseDTO = new UserResponseDTO( id, email, nombre, tipoDocumento, dni, apellido, telefono, institucion, rol, activo );

        return userResponseDTO;
    }

    @Override
    public User toEntity(UserRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        User user = new User();

        user.setNombre( userRequestDTO.nombre() );
        user.setApellido( userRequestDTO.apellido() );
        user.setDni( userRequestDTO.dni() );
        if ( userRequestDTO.tipoDocumento() != null ) {
            user.setTipoDocumento( Enum.valueOf( TipoDocumentoEnum.class, userRequestDTO.tipoDocumento() ) );
        }
        user.setEmail( userRequestDTO.email() );
        user.setTelefono( userRequestDTO.telefono() );
        user.setContrasena( userRequestDTO.contrasena() );
        user.setInstitucion( userRequestDTO.institucion() );

        return user;
    }
}
