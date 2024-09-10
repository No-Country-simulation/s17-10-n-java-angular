package com.dev.ForoEscolar.mapper.grado;

import com.dev.ForoEscolar.dtos.grado.GradoDto;
import com.dev.ForoEscolar.model.Grado;
import com.dev.ForoEscolar.model.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class GradoMapper {

    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "profesorToLong")
   public abstract GradoDto toResponseDto(Grado grado);

    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "longToProfesor")
    public abstract Grado toEntity(GradoDto gradoDto);

    @Named("longToProfesor")
    protected Profesor longToProfesor(Long id) {
        if (id == null) {
            return null;
        }
        Profesor profesor = new Profesor();
        profesor.setId(id);
        return profesor;
    }
    @Named("profesorToLong")
    protected Long profesorToLong(Profesor profesor) {
        return profesor != null ? profesor.getId() : null;
    }
}
