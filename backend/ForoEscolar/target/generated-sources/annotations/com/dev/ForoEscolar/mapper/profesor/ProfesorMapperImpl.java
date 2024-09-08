package com.dev.ForoEscolar.mapper.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import com.dev.ForoEscolar.model.Profesor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T17:36:51-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProfesorMapperImpl implements ProfesorMapper {

    @Override
    public ProfesorResponseDTO toResponseDTO(Profesor profesor) {
        if ( profesor == null ) {
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
        String materia = null;

        id = profesor.getId();
        email = profesor.getEmail();
        nombre = profesor.getNombre();
        if ( profesor.getTipoDocumento() != null ) {
            tipoDocumento = profesor.getTipoDocumento().name();
        }
        dni = profesor.getDni();
        apellido = profesor.getApellido();
        telefono = profesor.getTelefono();
        institucion = profesor.getInstitucion();
        if ( profesor.getRol() != null ) {
            rol = profesor.getRol().name();
        }
        activo = profesor.isActivo();
        if ( profesor.getMateria() != null ) {
            materia = profesor.getMateria().name();
        }

        List<Long> estudiante = null;

        ProfesorResponseDTO profesorResponseDTO = new ProfesorResponseDTO( id, email, nombre, tipoDocumento, dni, apellido, telefono, institucion, rol, activo, materia, estudiante );

        return profesorResponseDTO;
    }

    @Override
    public Profesor toEntity(ProfesorRequestDTO profesorRequestDTO) {
        if ( profesorRequestDTO == null ) {
            return null;
        }

        Profesor profesor = new Profesor();

        profesor.setNombre( profesorRequestDTO.nombre() );
        profesor.setApellido( profesorRequestDTO.apellido() );
        profesor.setDni( profesorRequestDTO.dni() );
        if ( profesorRequestDTO.tipoDocumento() != null ) {
            profesor.setTipoDocumento( Enum.valueOf( TipoDocumentoEnum.class, profesorRequestDTO.tipoDocumento() ) );
        }
        profesor.setEmail( profesorRequestDTO.email() );
        profesor.setTelefono( profesorRequestDTO.telefono() );
        profesor.setContrasena( profesorRequestDTO.contrasena() );
        profesor.setInstitucion( profesorRequestDTO.institucion() );
        if ( profesorRequestDTO.materia() != null ) {
            profesor.setMateria( Enum.valueOf( MateriaEnum.class, profesorRequestDTO.materia() ) );
        }

        return profesor;
    }

    @Override
    public ProfesorRequestDTO toRequestDTO(Profesor profesor) {
        if ( profesor == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String nombre = null;
        String apellido = null;
        String dni = null;
        String tipoDocumento = null;
        String telefono = null;
        String contrasena = null;
        String institucion = null;
        String materia = null;

        id = profesor.getId();
        email = profesor.getEmail();
        nombre = profesor.getNombre();
        apellido = profesor.getApellido();
        dni = profesor.getDni();
        if ( profesor.getTipoDocumento() != null ) {
            tipoDocumento = profesor.getTipoDocumento().name();
        }
        telefono = profesor.getTelefono();
        contrasena = profesor.getContrasena();
        institucion = profesor.getInstitucion();
        if ( profesor.getMateria() != null ) {
            materia = profesor.getMateria().name();
        }

        List<Long> estudiante = null;

        ProfesorRequestDTO profesorRequestDTO = new ProfesorRequestDTO( id, email, nombre, apellido, dni, tipoDocumento, telefono, contrasena, institucion, materia, estudiante );

        return profesorRequestDTO;
    }
}
