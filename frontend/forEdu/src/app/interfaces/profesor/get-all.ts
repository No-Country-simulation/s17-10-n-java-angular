import { Materia } from "../profesor";

export interface GetAll {
    estado:       boolean;
    message:      string;
    dataIterable: DataIterable[];
}

export interface DataIterable {
    grados:          string[];
    id:              number;
    email:           string;
    nombre:          string;
    tipoDocumento:   string;
    dni:             string;
    apellido:        string;
    telefono:        string;
    institucion:     string;
    rol:             Rol;
    activo:          boolean;
    materia:         Materia;
    estudianteIds:   any[]; //TODO
    boletinIds:      any[]; //TODO
    asistenciaIds:   any[]; //TODO
    tareaIds:        any[]; //TODO
    calificacionIds: any[]; //TODO
    gradoIds:        number[];
}
export type Rol = 'PROFESOR' | null;