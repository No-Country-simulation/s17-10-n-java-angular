-- Insertar usuarios
INSERT INTO users (dni, tipo_documento, activo, nombre, apellido, contraseña, email, institucion, telefono, rol, user_type)
VALUES ('12345678A', 'DNI', 1, 'Juan', 'Pérez', '$2a$10$I0gnxgl3zHLeuDQWurpwce8/rvcwOAjCM0kOlVazBv9WVbrReovq6', 'profesor@gmail.com', 'Instituto ABC', '123456789', 'PROFESOR', 'PROFESOR'),
       ('12345678D', 'DNI', 1, 'Juan2', 'Pérez2', '$2a$10$I0gnxgl3zHLeuDQWurpwce8/rvcwOAjCM0kOlVazBv9WVbrReovq6', 'profesor2@gmail.com', 'Instituto ABC', '123456789', 'PROFESOR', 'PROFESOR'),
       ('12345678E', 'DNI', 1, 'Juan3', 'Pérez3', '$2a$10$I0gnxgl3zHLeuDQWurpwce8/rvcwOAjCM0kOlVazBv9WVbrReovq6', 'profesor3@gmail.com', 'Instituto ABC', '123456789', 'PROFESOR', 'PROFESOR'),
       ('23456789B', 'DNI', 1, 'Ana', 'Gómez', '$2a$10$I0gnxgl3zHLeuDQWurpwce8/rvcwOAjCM0kOlVazBv9WVbrReovq6', 'tutor@gmail.com', 'Instituto ABC', '987654321', 'TUTOR', 'TUTOR_LEGAL'),
       ('34567890C', 'DNI', 1, 'Luis', 'Martínez', '$2a$10$I0gnxgl3zHLeuDQWurpwce8/rvcwOAjCM0kOlVazBv9WVbrReovq6', 'admin@gmail.com', 'Instituto XYZ', '456789123', 'ADMINISTRADOR', 'User');

-- Insertar profesores
INSERT INTO profesores (user_id, materia)
VALUES (1, 'MATEMATICAS'),
       (2, 'LENGUAJE'),
       (3, 'CIENCIAS');

-- Insertar tutores legales
INSERT INTO tutor_legal (user_id)
VALUES (4);

-- Insertar administradores escolares
INSERT INTO administrador_escolar (user_id)
VALUES (5);
-- Insertar grados
INSERT INTO grado (aula, curso, turno, materia, profesor_id)
VALUES ('A', 'PRIMERO', 'MAÑANA', 'MATEMATICAS', 1),
       ('B', 'SEGUNDO', 'TARDE', 'LENGUAJE', 2),
       ('C', 'TERCERO', 'NOCHE', 'CIENCIAS', 3);


-- Insertar estudiantes
INSERT INTO estudiantes (nombre, apellido, dni, genero, rol, fecha_nacimiento, activo, tipo_documento, grado_id ,tutor_legal_id)
VALUES ('Carlos', 'Sánchez', '45678901D', 'MASCULINO', 'ESTUDIANTE', '2010-04-15', 1,  'DNI',1 ,4),
       ('Carlos2', 'Sánchez2', '45678901F', 'MASCULINO', 'ESTUDIANTE', '2010-04-15', 1,  'DNI',1 ,4);

-- Insertar relación entre profesores y estudiantes
INSERT INTO profesor_estudiante (profesor_id, estudiante_id, materia)
VALUES (1, 1, 'MATEMATICAS'),
       (2, 1, 'LENGUAJE'),
       (3, 1, 'CIENCIAS');

-- Insertar asistencia
INSERT INTO asistencia (estudiante_id, dias_anio_escolar, asistio, fecha, profesor_id, observaciones)
VALUES (1, 180, 1, '2024-09-14', 1, 'Ninguna'),
       (1, 180, 1, '2024-09-15', 2, 'Ninguna'),
       (1, 180, 1, '2024-09-16', 3, 'Ninguna');

-- Insertar notificaciones
INSERT INTO notificaciones (administrador_escolar_id, fecha_envio, tutor_legal_id, mensaje, tipo_notificacion, titulo)
VALUES (5, NOW(), 4, 'Reunión de seguimiento', 'EVENTO', 'Reunión de seguimiento para Carlos');

-- Insertar tareas
INSERT INTO tarea (profesor_id, estudiante_id, titulo, descripcion, estado_de_entrega, fecha_entrega, activo)
VALUES (1, 1, 'Tarea de Matemáticas', 'Resolver problemas del capítulo 3', 'PENDIENTE', '2024-09-30', 1),
       (2, 1, 'Tarea de lENGUAJE', 'Resolver cuestionario del capítulo 4', 'PENDIENTE', '2024-09-30', 1);

-- Insertar boletines
INSERT INTO boletin (estudiante_id, profesor_id, periodo, promedio, fecha, curso, observaciones)
VALUES (1, 1, 'Primer trimestre', 8.5, NOW(), 'PRIMERO', 'Buen desempeño');

-- Insertar calificaciones
INSERT INTO calificaciones (estudiante_id, profesor_id, boletin_id, materia, nota, promedio, comentario, fecha, periodo)
VALUES (1, 1, 1, 'MATEMATICAS', 9.0, 8.5, 'Excelente', NOW(), 'Primer trimestre'),
       (1, 2, 1, 'LENGUAJE', 9.0, 8.5, 'Excelente', NOW(), 'Primer trimestre');

