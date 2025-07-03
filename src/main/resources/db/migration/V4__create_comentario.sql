CREATE TABLE comentario (
    id SERIAL PRIMARY KEY,
    expediente_id INTEGER REFERENCES expediente(id),
    usuario_id INTEGER REFERENCES usuario(id),
    texto TEXT NOT NULL,
    fecha TIMESTAMP NOT NULL
);
CREATE INDEX idx_comentario_expediente ON comentario(expediente_id);
