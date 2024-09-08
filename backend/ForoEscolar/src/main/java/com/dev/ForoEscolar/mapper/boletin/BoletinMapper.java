package com.dev.ForoEscolar.mapper.boletin;

import com.dev.ForoEscolar.dtos.boletin.BoletinDto;
import com.dev.ForoEscolar.model.Boletin;
import com.dev.ForoEscolar.model.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class BoletinMapper {

    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "estudianteToLong")
    public abstract BoletinDto toResponseDto(Boletin boletin);

    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "longToEstudiante")
    public abstract Boletin toEntity(BoletinDto boletinDto);

    @Named("estudianteToLong")
    protected Long estudianteToLong(Estudiante estudiante) {
        return estudiante != null ? estudiante.getId() : null;
    }

    @Named("longToEstudiante")
    protected Estudiante longToEstudiante(Long id) {
        if (id == null) {
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        return estudiante;
    }
}