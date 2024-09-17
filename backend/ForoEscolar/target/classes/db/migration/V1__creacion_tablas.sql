-- Tabla base para usuarios (incluyendo profesores, tutores legales y administradores)
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
                       rol ENUM('ADMINISTRADOR', 'PROFESOR', 'TUTOR'),
                       user_type VARCHAR(50)
);

-- Tabla para profesores (hereda de users)
CREATE TABLE profesores (
                            user_id BIGINT PRIMARY KEY,
                            materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA'),
                            FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tabla para tutores legales (hereda de users)
CREATE TABLE tutor_legal (
                             user_id BIGINT PRIMARY KEY,
                             FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tabla para administradores escolares (hereda de users)
CREATE TABLE administrador_escolar (
                                       user_id BIGINT PRIMARY KEY,
                                       FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE grado (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       aula ENUM('A', 'B', 'C'),
                       curso ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO'),
                       turno ENUM('MAÑANA', 'TARDE', 'NOCHE'),
                       materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA'),
                       profesor_id BIGINT,
                       FOREIGN KEY (profesor_id) REFERENCES profesores(user_id) ON DELETE SET NULL
);
-- Tabla para estudiantes (no hereda de users)
CREATE TABLE estudiantes (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             nombre VARCHAR(100),
                             apellido VARCHAR(100),
                             dni VARCHAR(50) UNIQUE,
                             genero ENUM('MASCULINO', 'FEMENINO'),
                             rol ENUM('ADMINISTRADOR', 'PROFESOR', 'TUTOR', 'ESTUDIANTE'),
                             fecha_nacimiento DATE,
                             activo TINYINT(1),
                             grado_id BIGINT,
                             tipo_documento ENUM('PASAPORTE', 'DNI', 'OTROS'),
                             tutor_legal_id BIGINT,
                             FOREIGN KEY (grado_id) REFERENCES grado(id),
                             FOREIGN KEY (tutor_legal_id) REFERENCES tutor_legal(user_id)
);

-- Tabla de relación entre profesores y estudiantes
CREATE TABLE profesor_estudiante (
                                     profesor_id BIGINT,
                                     estudiante_id BIGINT,
                                     materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA'),
                                     PRIMARY KEY (profesor_id, estudiante_id, materia),
                                     FOREIGN KEY (profesor_id) REFERENCES profesores(user_id),
                                     FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
);

CREATE TABLE asistencia (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            estudiante_id BIGINT,
                            dias_anio_escolar DOUBLE,
                            asistio TINYINT(1),
                            fecha DATE,
                            profesor_id BIGINT,
                            observaciones VARCHAR(255),
                            FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id),
                            FOREIGN KEY (profesor_id) REFERENCES profesores(user_id)
);

CREATE TABLE notificaciones (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                administrador_escolar_id BIGINT,
                                fecha_envio DATETIME,
                                tutor_legal_id BIGINT,
                                mensaje VARCHAR(255),
                                tipo_notificacion ENUM ('ALERTA','BOLETIN','EVENTO'),
                                titulo VARCHAR(100),
                                FOREIGN KEY (administrador_escolar_id) REFERENCES administrador_escolar(user_id),
                                FOREIGN KEY (tutor_legal_id) REFERENCES tutor_legal(user_id)
);
CREATE TABLE tarea (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       profesor_id BIGINT,
                       estudiante_id BIGINT,
                       titulo VARCHAR(100),
                       descripcion VARCHAR(255),
                       estado_de_entrega ENUM('PENDIENTE', 'APROBADO', 'RECHAZADO'),
                       fecha_entrega DATETIME,
                       activo TINYINT(1),
                       FOREIGN KEY (profesor_id) REFERENCES profesores(user_id),
                       FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)

);


