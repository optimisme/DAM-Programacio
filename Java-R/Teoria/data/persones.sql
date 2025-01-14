DROP DATABASE IF EXISTS persones;
CREATE DATABASE IF NOT EXISTS persones;
USE persones;

-- Esborra la taula si ja existeix per començar de zero
DROP TABLE IF EXISTS persones;

-- Crea la taula 'persones'
CREATE TABLE persones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    edat INT NOT NULL
);

-- Inserir dades inicials a la taula 'persones'
INSERT INTO persones (nom, edat) VALUES ('Anna', 25);
INSERT INTO persones (nom, edat) VALUES ('Marc', 30);
INSERT INTO persones (nom, edat) VALUES ('Jordi', 45);
INSERT INTO persones (nom, edat) VALUES ('Clara', 22);
INSERT INTO persones (nom, edat) VALUES ('Pau', 35);
