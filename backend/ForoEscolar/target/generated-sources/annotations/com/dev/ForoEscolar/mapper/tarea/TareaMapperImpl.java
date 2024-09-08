package com.dev.ForoEscolar.mapper.tarea;

import com.dev.ForoEscolar.dtos.tarea.TareaResponseDto;
import com.dev.ForoEscolar.model.Tarea;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T16:56:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TareaMapperImpl extends TareaMapper {

    @Override
    public TareaResponseDto toResponseDTO(Tarea tarea) {
        if ( tarea == null ) {
            return null;
        }

        TareaResponseDto.TareaResponseDtoBuilder tareaResponseDto = TareaResponseDto.builder();

        tareaResponseDto.profesor( profesorToLong( tarea.getProfesor() ) );
        tareaResponseDto.estudiante( estudianteToLong( tarea.getEstudiante() ) );
        tareaResponseDto.id( tarea.getId() );
        tareaResponseDto.descripcion( tarea.getDescripcion() );
        tareaResponseDto.titulo( tarea.getTitulo() );
        tareaResponseDto.fechaEntrega( tarea.getFechaEntrega() );
        tareaResponseDto.activo( tarea.isActivo() );
        tareaResponseDto.estadoDeEntrega( tarea.getEstadoDeEntrega() );

        return tareaResponseDto.build();
    }

    @Override
    public Tarea toEntity(TareaResponseDto tareaRequestDTO) {
        if ( tareaRequestDTO == null ) {
            return null;
        }

        Tarea.TareaBuilder tarea = Tarea.builder();

        tarea.profesor( longToProfesor( tareaRequestDTO.getProfesor() ) );
        tarea.estudiante( longToEstudiante( tareaRequestDTO.getEstudiante() ) );
        tarea.id( tareaRequestDTO.getId() );
        tarea.descripcion( tareaRequestDTO.getDescripcion() );
        tarea.titulo( tareaRequestDTO.getTitulo() );
        tarea.fechaEntrega( tareaRequestDTO.getFechaEntrega() );
        tarea.activo( tareaRequestDTO.isActivo() );
        tarea.estadoDeEntrega( tareaRequestDTO.getEstadoDeEntrega() );

        return tarea.build();
    }
}
