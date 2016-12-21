drop database if exists etakemondb;
create database etakemondb;

use etakemondb;

CREATE TABLE etakemon (
    id INTEGER NOT NULL auto_increment,
    tipus ENUM ('director', 'professor', 'alumne') NOT NULL,
    nom VARCHAR(100) NOT NULL,
    descripcio VARCHAR(500) NOT NULL,
    puntuacio INTEGER NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO etakemon (tipus, nom, descripcio, puntuacio) VALUES ("director", "Alonso", "Es professor de CSF", "200");
INSERT INTO etakemon (tipus, nom, descripcio, puntuacio) VALUES ("professor", "Toni", "Es el coordinador", "100");
INSERT INTO etakemon (tipus, nom, descripcio, puntuacio) VALUES ("Rosa", "alumne", "Estudiant de DSA", "50");
