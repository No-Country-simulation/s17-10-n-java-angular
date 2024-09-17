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

CREATE TABLE calificaciones (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                estudiante_id BIGINT,
                                profesor_id BIGINT,
                                boletin_id BIGINT,
                                materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA') NOT NULL,
                                nota DOUBLE NOT NULL,
                                promedio DOUBLE,
                                comentario VARCHAR(255),
                                fecha DATETIME,
                                periodo VARCHAR(50),
                                FOREIGN KEY (profesor_id) REFERENCES profesores(user_id),
                                FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id),
                                FOREIGN KEY (boletin_id) REFERENCES boletin(id)
);



