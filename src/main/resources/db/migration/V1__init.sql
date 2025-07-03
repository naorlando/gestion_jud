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

CREATE INDEX idx_expedientes_estado ON expedientes(estado);

CREATE TABLE documentos (
    id SERIAL PRIMARY KEY,
    expediente_id BIGINT NOT NULL,
    tipo_documento VARCHAR(255),
    fecha_emision DATE,
    parent_documento_id BIGINT,
    ruta_archivo VARCHAR(500),
    CONSTRAINT fk_documento_expediente FOREIGN KEY (expediente_id) REFERENCES expedientes(id) ON DELETE CASCADE,
    CONSTRAINT fk_documento_parent FOREIGN KEY (parent_documento_id) REFERENCES documentos(id)
);
CREATE INDEX idx_documentos_expediente ON documentos(expediente_id);
CREATE INDEX idx_documentos_parent ON documentos(parent_documento_id);

CREATE TABLE comentarios (
    id SERIAL PRIMARY KEY,
    expediente_id BIGINT NOT NULL,
    usuario_id BIGINT,
    texto TEXT,
    timestamp TIMESTAMP,
    CONSTRAINT fk_comentario_expediente FOREIGN KEY (expediente_id) REFERENCES expedientes(id) ON DELETE CASCADE,
    CONSTRAINT fk_comentario_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE SET NULL
);
CREATE INDEX idx_comentarios_expediente ON comentarios(expediente_id);
CREATE INDEX idx_comentarios_usuario ON comentarios(usuario_id);

