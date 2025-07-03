CREATE TABLE documento (
    id SERIAL PRIMARY KEY,
    expediente_id INTEGER REFERENCES expediente(id),
    tipo_documento VARCHAR(100) NOT NULL,
    fecha_emision DATE NOT NULL,
    parent_id INTEGER REFERENCES documento(id),
    ruta_archivo VARCHAR(255)
);
CREATE INDEX idx_documento_expediente ON documento(expediente_id);
