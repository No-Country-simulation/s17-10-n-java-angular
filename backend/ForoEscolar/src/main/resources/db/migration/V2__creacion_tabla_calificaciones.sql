CREATE TABLE calificaciones (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                estudiante_id BIGINT,
                                profesor_id BIGINT,
                                materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA') NOT NULL,
                                nota DOUBLE NOT NULL,
                                comentario VARCHAR(255),
                                fecha DATETIME,
                                periodo VARCHAR(50),
                                FOREIGN KEY (profesor_id) REFERENCES profesores(user_id),
                                FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
);

-- Tabla para registrar las entregas de tareas por estudiantes
CREATE TABLE entrega_tarea (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               tarea_id BIGINT,
                               estudiante_id BIGINT,
                               fecha_entrega DATETIME,
                               estado ENUM('ENTREGADA', 'PENDIENTE', 'ATRASADA'),
                               FOREIGN KEY (tarea_id) REFERENCES tarea(id),
                               FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
);
CREATE TABLE boletin (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        estudiante_id BIGINT,
                        profesor_id BIGINT,
                        periodo VARCHAR(50),
                        promedio DOUBLE,
                        fecha DATETIME,
                        curso ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO'),
                        observaciones VARCHAR(255),
                        FOREIGN KEY (profesor_id) REFERENCES profesores(user_id),
                        FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
);