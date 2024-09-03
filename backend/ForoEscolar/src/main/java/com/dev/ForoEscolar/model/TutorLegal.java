package com.dev.ForoEscolar.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "tutor_legal")
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("TUTOR_LEGAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TutorLegal extends User{

    @OneToMany(mappedBy = "tutor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes;

}
