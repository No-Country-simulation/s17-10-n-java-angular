export interface GradeRegister {
   id?: number ,
   aula: Aula;
   curso: Curso;
   turno: Turno;
   materia: Materia;
   profesor: number;
 }

 export type Aula = 'A' | 'B' | 'C';
 export type Curso = 'PRIMERO' | 'SEGUNDO' | 'TERCERO' | 'CUARTO' | 'QUINTO' | 'SEXTO';
 export type Turno = 'MAÑANA' | 'TARDE' | 'NOCHE';
 export type Materia = 'MATEMATICAS' | 'CIENCIAS' | 'LENGUAJE' | 'HISTORIA';

/* CREATE TABLE grado (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   aula ENUM('A', 'B', 'C'),
   curso ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO'),
   turno ENUM('MAÑANA', 'TARDE', 'NOCHE'),
   materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA'),
   profesor_id BIGINT,
   FOREIGN KEY (profesor_id) REFERENCES profesores(user_id) ON DELETE SET NULL
);
 */
