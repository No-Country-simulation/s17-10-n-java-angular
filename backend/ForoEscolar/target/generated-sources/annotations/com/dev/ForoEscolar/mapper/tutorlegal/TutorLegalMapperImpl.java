package com.dev.ForoEscolar.mapper.tutorlegal;

import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalRequestDTO;
import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalResponseDTO;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import com.dev.ForoEscolar.model.TutorLegal;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T16:44:15-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class TutorLegalMapperImpl implements TutorLegalMapper {

    @Override
    public TutorLegal toEntity(TutorLegalRequestDTO tutorLegalRequestDTO) {
        if ( tutorLegalRequestDTO == null ) {
            return null;
        }

        TutorLegal tutorLegal = new TutorLegal();

        tutorLegal.setNombre( tutorLegalRequestDTO.nombre() );
        tutorLegal.setApellido( tutorLegalRequestDTO.apellido() );
        tutorLegal.setDni( tutorLegalRequestDTO.dni() );
        if ( tutorLegalRequestDTO.tipoDocumento() != null ) {
            tutorLegal.setTipoDocumento( Enum.valueOf( TipoDocumentoEnum.class, tutorLegalRequestDTO.tipoDocumento() ) );
        }
        tutorLegal.setEmail( tutorLegalRequestDTO.email() );
        tutorLegal.setTelefono( tutorLegalRequestDTO.telefono() );
        tutorLegal.setContrasena( tutorLegalRequestDTO.contrasena() );
        tutorLegal.setInstitucion( tutorLegalRequestDTO.institucion() );

        return tutorLegal;
    }

    @Override
    public TutorLegalResponseDTO toResponseDTO(TutorLegal tutorLegal) {
        if ( tutorLegal == null ) {
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

        id = tutorLegal.getId();
        email = tutorLegal.getEmail();
        nombre = tutorLegal.getNombre();
        if ( tutorLegal.getTipoDocumento() != null ) {
            tipoDocumento = tutorLegal.getTipoDocumento().name();
        }
        dni = tutorLegal.getDni();
        apellido = tutorLegal.getApellido();
        telefono = tutorLegal.getTelefono();
        institucion = tutorLegal.getInstitucion();
        if ( tutorLegal.getRol() != null ) {
            rol = tutorLegal.getRol().name();
        }
        activo = tutorLegal.isActivo();

        List<Long> estudiante = null;

        TutorLegalResponseDTO tutorLegalResponseDTO = new TutorLegalResponseDTO( id, email, nombre, tipoDocumento, dni, apellido, telefono, institucion, rol, activo, estudiante );

        return tutorLegalResponseDTO;
    }

    @Override
    public TutorLegalRequestDTO toRequestDTO(TutorLegal tutorLegal) {
        if ( tutorLegal == null ) {
            return null;
        }

        String email = null;
        String nombre = null;
        String apellido = null;
        String dni = null;
        String tipoDocumento = null;
        String telefono = null;
        String contrasena = null;
        String institucion = null;

        email = tutorLegal.getEmail();
        nombre = tutorLegal.getNombre();
        apellido = tutorLegal.getApellido();
        dni = tutorLegal.getDni();
        if ( tutorLegal.getTipoDocumento() != null ) {
            tipoDocumento = tutorLegal.getTipoDocumento().name();
        }
        telefono = tutorLegal.getTelefono();
        contrasena = tutorLegal.getContrasena();
        institucion = tutorLegal.getInstitucion();

        List<Long> estudiante = null;

        TutorLegalRequestDTO tutorLegalRequestDTO = new TutorLegalRequestDTO( email, nombre, apellido, dni, tipoDocumento, telefono, contrasena, institucion, estudiante );

        return tutorLegalRequestDTO;
    }
}
