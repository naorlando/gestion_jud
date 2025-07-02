CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL
);

CREATE TABLE expedientes (
    id SERIAL PRIMARY KEY,
    tipo_siniestro VARCHAR(255),
    fecha_inicio DATE,
    estado VARCHAR(20),
    provision_contable NUMERIC(15,2)
);

CREATE TABLE documentos (
    id SERIAL PRIMARY KEY,
    expediente_id BIGINT REFERENCES expedientes(id) ON DELETE CASCADE,
    tipo_documento VARCHAR(255),
    fecha_emision DATE,
    parent_documento_id BIGINT REFERENCES documentos(id),
    ruta_archivo VARCHAR(500)
);
CREATE INDEX idx_documentos_expediente ON documentos(expediente_id);

CREATE TABLE comentarios (
    id SERIAL PRIMARY KEY,
    expediente_id BIGINT REFERENCES expedientes(id) ON DELETE CASCADE,
    usuario_id BIGINT REFERENCES usuarios(id) ON DELETE SET NULL,
    texto TEXT,
    timestamp TIMESTAMP
);
CREATE INDEX idx_comentarios_expediente ON comentarios(expediente_id);
