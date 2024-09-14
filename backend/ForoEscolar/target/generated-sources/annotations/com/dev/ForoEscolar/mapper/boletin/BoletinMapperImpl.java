package com.dev.ForoEscolar.mapper.boletin;

import com.dev.ForoEscolar.dtos.boletin.BoletinDto;
import com.dev.ForoEscolar.model.Boletin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T17:38:34-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BoletinMapperImpl extends BoletinMapper {

    @Override
    public BoletinDto toResponseDto(Boletin boletin) {
        if ( boletin == null ) {
            return null;
        }

        BoletinDto.BoletinDtoBuilder boletinDto = BoletinDto.builder();

        boletinDto.estudiante( estudianteToLong( boletin.getEstudiante() ) );
        boletinDto.id( boletin.getId() );
        boletinDto.promedio( boletin.getPromedio() );
        boletinDto.observaciones( boletin.getObservaciones() );
        boletinDto.periodo( boletin.getPeriodo() );
        boletinDto.curso( boletin.getCurso() );
        boletinDto.fecha( boletin.getFecha() );

        return boletinDto.build();
    }

    @Override
    public Boletin toEntity(BoletinDto boletinDto) {
        if ( boletinDto == null ) {
            return null;
        }

        Boletin.BoletinBuilder boletin = Boletin.builder();

        boletin.estudiante( longToEstudiante( boletinDto.getEstudiante() ) );
        boletin.id( boletinDto.getId() );
        boletin.promedio( boletinDto.getPromedio() );
        boletin.observaciones( boletinDto.getObservaciones() );
        boletin.periodo( boletinDto.getPeriodo() );
        boletin.fecha( boletinDto.getFecha() );
        boletin.curso( boletinDto.getCurso() );

        return boletin.build();
    }
}
