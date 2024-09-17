package com.dev.ForoEscolar.mapper.grado;

import com.dev.ForoEscolar.dtos.grado.GradoDto;
import com.dev.ForoEscolar.model.Grado;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-17T11:57:18-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class GradoMapperImpl extends GradoMapper {

    @Override
    public GradoDto toResponseDto(Grado grado) {
        if ( grado == null ) {
            return null;
        }

        GradoDto.GradoDtoBuilder gradoDto = GradoDto.builder();

        gradoDto.profesor( profesorToLong( grado.getProfesor() ) );
        gradoDto.id( grado.getId() );
        gradoDto.aula( grado.getAula() );
        gradoDto.curso( grado.getCurso() );
        gradoDto.turno( grado.getTurno() );
        gradoDto.materia( grado.getMateria() );

        return gradoDto.build();
    }

    @Override
    public Grado toEntity(GradoDto gradoDto) {
        if ( gradoDto == null ) {
            return null;
        }

        Grado.GradoBuilder grado = Grado.builder();

        grado.profesor( longToProfesor( gradoDto.getProfesor() ) );
        grado.id( gradoDto.getId() );
        grado.aula( gradoDto.getAula() );
        grado.curso( gradoDto.getCurso() );
        grado.turno( gradoDto.getTurno() );
        grado.materia( gradoDto.getMateria() );

        return grado.build();
    }
}
