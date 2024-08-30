CREATE TABLE calificaciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    materia ENUM('MATEMATICAS', 'CIENCIAS', 'LENGUAJE', 'HISTORIA') NOT NULL,
    nota DOUBLE NOT NULL,
    promedio DOUBLE NOT NULL,
    comentario VARCHAR(255),
    fecha DATETIME,
    id_profesor BIGINT,
    id_estudiante BIGINT,
    FOREIGN KEY (id_profesor) REFERENCES profesores(id),
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id)
);