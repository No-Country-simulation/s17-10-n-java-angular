export interface StudentSuccess {



      id: number;
      nombre: string;
      apellido: string;
      dni: string;
      genero: Genero;
      fechaNacimiento: string;
      curso: Curso;
      aula: Aula;
      tipoDocumento: TipoDocumento;
      activo: boolean;
      tutor: number;
      asistencia: number[];
      boletin: number[];
      tarea: number[];
      calificaciones: number[];


}
export interface ApiResponse {
   estado: boolean;
   message: string;
   data: StudentSuccess;
   dataIterable: Record<string, any>;
 }

export type TipoDocumento = 'PASAPORTE' | 'DNI' | 'OTROS';
export type Materia = 'MATEMATICAS' | 'CIENCIAS' | 'LENGUAJE' | 'HISTORIA';
export type Aula = 'A' | 'B' | 'C';
export type Curso = 'PRIMERO' | 'SEGUNDO' | 'TERCERO' | 'CUARTO' | 'QUINTO' | 'SEXTO';
export type Turno = 'MAÑANA' | 'TARDE' | 'NOCHE';
export type Genero = 'MASCULINO' | 'FEMENINO';

