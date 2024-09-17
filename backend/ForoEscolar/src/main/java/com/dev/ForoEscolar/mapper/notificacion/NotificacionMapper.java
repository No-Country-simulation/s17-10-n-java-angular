package com.dev.ForoEscolar.mapper.notificacion;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.model.Notificacion;
import com.dev.ForoEscolar.model.TutorLegal;
import com.dev.ForoEscolar.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public abstract class NotificacionMapper {


    @Mapping(source = "user", target = "user", qualifiedByName = "userToLong")
    @Mapping(source = "tutorLegal", target = "tutorLegal", qualifiedByName = "tutorLegalToLong")
    public abstract NotificacionDTO toResponseDto(Notificacion notificacion);

    @Mapping(source = "user", target = "user", qualifiedByName = "longToUser")
    @Mapping(source = "tutorLegal", target = "tutorLegal", qualifiedByName = "longToTutorLegal")
    public abstract Notificacion toEntity(NotificacionDTO notificacionDTO);

    @Named("longToUser")
    protected User longToUser(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

    @Named("userToLong")
    protected Long userToLong(User user) {
        return user != null ? user.getId() : null;
    }

    @Named("longToTutorLegal")
    protected TutorLegal longToTutorLegal(Long id) {
        if (id == null) {
            return null;
        }
        TutorLegal tutorLegal = new TutorLegal();
        tutorLegal.setId(id);
        return tutorLegal;
    }

    @Named("tutorLegalToLong")
    protected Long tutorLegalToLong(TutorLegal tutorLegal) {
        return tutorLegal != null ? tutorLegal.getId() : null;
    }

}
