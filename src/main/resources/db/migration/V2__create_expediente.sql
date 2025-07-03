CREATE TABLE expediente (
    id SERIAL PRIMARY KEY,
    tipo_siniestro VARCHAR(100) NOT NULL,
    fecha_inicio DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    provision_contable NUMERIC(15,2) DEFAULT 0
);
CREATE INDEX idx_expediente_estado ON expediente(estado);
