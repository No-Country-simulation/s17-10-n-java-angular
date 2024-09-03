CREATE TABLE users (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            dni VARCHAR(50) UNIQUE,
                            tipo_documento ENUM('PASAPORTE', 'DNI', 'OTROS'),
                            activo TINYINT(1),
                            nombre VARCHAR(100),
                            apellido VARCHAR(100),
                            contraseña VARCHAR(255),
                            email VARCHAR(255) UNIQUE,
                            institucion VARCHAR(255),
                            telefono VARCHAR(20),
                            rol ENUM('ADMINISTRADOR', 'PROFESOR', 'ESTUDIANTE', 'TUTOR')
);
CREATE TABLE tutor_legal (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             user_id BIGINT UNIQUE,
                             FOREIGN KEY (user_id) REFERENCES users(id)

);
CREATE TABLE estudiantes (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             user_id BIGINT UNIQUE,
                             fecha_nacimiento DATE,
                             tutor_legal_id BIGINT,
                             curso ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO'),
                             aula ENUM('A', 'B', 'C'),
                             tipo_identificacion ENUM('DNI', 'PASAPORTE','OTROS'),
                             FOREIGN KEY (tutor_legal_id) REFERENCES tutor_legal(id),
                             FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE profesores (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            calificaciones DOUBLE,
                            estudiante_id BIGINT,
                            user_id BIGINT,
                            comentario VARCHAR(255),
                            periodo VARCHAR(50),
                            curso ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO'),
                            materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA'),
                            FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id),
                            FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE profesor_estudiante (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     profesor_id BIGINT,
                                     estudiante_id BIGINT,
                                     materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA'),
                                     FOREIGN KEY (profesor_id) REFERENCES profesores(id),
                                     FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
);
CREATE TABLE administrador_escolar (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       FOREIGN KEY (id) REFERENCES users(id)
);

CREATE TABLE asistencia (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            contador_asistencias INT,
                            dias_anio_escolar DOUBLE,
                            estudiante_id BIGINT,
                            fecha DATETIME,
                            profesor_id BIGINT,
                            estado VARCHAR(50),
                            observaciones VARCHAR(255),
                            FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id),
                            FOREIGN KEY (profesor_id) REFERENCES profesores(id)
);
CREATE TABLE notificaciones (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                administrador_escolar_id BIGINT,
                                fecha_envio DATETIME,
                                tutor_legal_id BIGINT,
                                mensaje VARCHAR(255),
                                tipo_notificacion ENUM ('ALERTA','BOLETIN','EVENTO'),
                                titulo VARCHAR(100),
                                FOREIGN KEY (administrador_escolar_id) REFERENCES administrador_escolar(id),
                                FOREIGN KEY (tutor_legal_id) REFERENCES tutor_legal(id)
);
CREATE TABLE tarea (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       estudiante_id BIGINT,
                       fecha_entrega DATETIME,
                       profesor_id BIGINT,
                       descripcion VARCHAR(255),
                       titulo VARCHAR(100),
                       FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id),
                       FOREIGN KEY (profesor_id) REFERENCES profesores(id)
);
CREATE TABLE boletin (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         calificaciones DOUBLE,
                         estudiante_id BIGINT,
                         profesor_id BIGINT,
                         comentario VARCHAR(255),
                         periodo VARCHAR(50),
                         curso ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO'),
                         materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA'),
                         FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id),
                         FOREIGN KEY (profesor_id) REFERENCES profesores(id)
);

