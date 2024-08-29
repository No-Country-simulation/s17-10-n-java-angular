package com.dev.ForoEscolar.mapper.boletin;

import com.dev.ForoEscolar.dtos.boletin.BoletinDto;
import com.dev.ForoEscolar.model.Boletin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoletinMapper {

    BoletinMapper INSTANCE= Mappers.getMapper(BoletinMapper.class);

    BoletinDto toResponseDto (Boletin boletin);

    Boletin toEntity(BoletinDto boletinDto);


}
