export interface StudentRegister {
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
   tutorLegalId: number;


/*    asistencia: number[];
   boletin: number[];
   tarea: number[];
   calificaciones: number[]; */
 }

 export type TipoDocumento = 'PASAPORTE' | 'DNI' | 'OTROS';
 export type Materia = 'MATEMATICAS' | 'CIENCIAS' | 'LENGUAJE' | 'HISTORIA';
 export type Genero = 'MASCULINO' | 'FEMENINO';
 export type Curso = 'PRIMERO' | 'SEGUNDO' | 'TERCERO' | 'CUARTO' | 'QUINTO' | 'SEXTO';
 export type Aula = 'A' | 'B' | 'C';


/*
CREATE TABLE estudiantes (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   nombre VARCHAR(100),
   apellido VARCHAR(100),
   dni VARCHAR(50) UNIQUE,
   genero ENUM('MASCULINO', 'FEMENINO'),
   rol ENUM('ADMINISTRADOR', 'PROFESOR', 'TUTOR', 'ESTUDIANTE'),
   fecha_nacimiento DATE,
   activo TINYINT(1),
   curso ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO'),
   aula ENUM('A', 'B', 'C'),
   tipo_documento ENUM('PASAPORTE', 'DNI', 'OTROS'),
   tutor_legal_id BIGINT,
   FOREIGN KEY (tutor_legal_id) REFERENCES tutor_legal(user_id)
); */
