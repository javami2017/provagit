DROP DATABASE IF EXISTS ristorante;
CREATE DATABASE ristorante CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE ristorante;

CREATE TABLE piatto (
	idpiatto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomepiatto VARCHAR(45),
    costo DECIMAL,
    portata VARCHAR(45)
);

CREATE TABLE ordine (
	idordine INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    x_idcliente INT,
    x_idpiatto INT,
	pagato INT,
	ready INT,
	dataordine DATETIME
);

CREATE TABLE cliente (
	idcliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    x_idtavolo INT,
	presente INT
);

CREATE TABLE tavolo (
	idtavolo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    x_idcameriere INT
);

CREATE TABLE cameriere (
	idcameriere INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45)
);

ALTER TABLE ordine ADD CONSTRAINT FK__ordine__x_idcliente__cliente__idcliente FOREIGN KEY (x_idcliente) REFERENCES cliente(idcliente) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ordine ADD CONSTRAINT FK__ordine__x_idpiatto__piatto__idpiatto FOREIGN KEY (x_idpiatto) REFERENCES piatto(idpiatto) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE cliente ADD CONSTRAINT FK__cliente__x_idtavolo__tavolo__idtavolo FOREIGN KEY (x_idtavolo) REFERENCES tavolo(idtavolo) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE tavolo ADD CONSTRAINT FK__tavolo__x_idcameriere__cameriere__idcameriere FOREIGN KEY (x_idcameriere) REFERENCES cameriere(idcameriere) ON UPDATE RESTRICT ON DELETE RESTRICT;

SET FOREIGN_KEY_CHECKS=0;
USE `ristorante`;
# Exporting data from `ristorante`
# Data for table `ristorante`.`cameriere`:
INSERT INTO `ristorante`.`cameriere` VALUES (1, 'Gerson');
INSERT INTO `ristorante`.`cameriere` VALUES (2, 'Greta');
INSERT INTO `ristorante`.`cameriere` VALUES (3, 'Riccardo');
# Data for table `ristorante`.`cliente`:
INSERT INTO `ristorante`.`cliente` VALUES (1, 'Giovanna', 1, 0);
INSERT INTO `ristorante`.`cliente` VALUES (2, 'Francesco', 1, 0);
INSERT INTO `ristorante`.`cliente` VALUES (3, 'Marcello', 1, 0);
INSERT INTO `ristorante`.`cliente` VALUES (4, 'Carmine', 2, 0);
INSERT INTO `ristorante`.`cliente` VALUES (5, 'Federico', 2, 0);
INSERT INTO `ristorante`.`cliente` VALUES (6, 'Marco', 2, 0);
INSERT INTO `ristorante`.`cliente` VALUES (7, 'Chiara', 3, 0);
INSERT INTO `ristorante`.`cliente` VALUES (8, 'Concettina', 3, 0);
INSERT INTO `ristorante`.`cliente` VALUES (9, 'Giulia', 3, 0);
INSERT INTO `ristorante`.`cliente` VALUES (10, 'Angela', 4, 0);
INSERT INTO `ristorante`.`cliente` VALUES (11, 'Giorgia', 4, 0);
INSERT INTO `ristorante`.`cliente` VALUES (12, 'Francesca', 4, 0);
# Data for table `ristorante`.`ordine`:
# Data for table `ristorante`.`piatto`:
INSERT INTO `ristorante`.`piatto` VALUES (1, 'pasta al pesto', 3, 'Primo');
INSERT INTO `ristorante`.`piatto` VALUES (2, 'pasta al sugo', 3, 'Primo');
INSERT INTO `ristorante`.`piatto` VALUES (3, 'risotto', 3, 'Primo');
INSERT INTO `ristorante`.`piatto` VALUES (4, 'bistecca', 4, 'Secondo');
INSERT INTO `ristorante`.`piatto` VALUES (5, 'petto di pollo', 4, 'Secondo');
INSERT INTO `ristorante`.`piatto` VALUES (6, 'pesce', 4, 'Secondo');
INSERT INTO `ristorante`.`piatto` VALUES (7, 'patate', 2, 'Contorno');
INSERT INTO `ristorante`.`piatto` VALUES (8, 'piselli', 2, 'Contorno');
INSERT INTO `ristorante`.`piatto` VALUES (9, 'carote', 2, 'Contorno');
INSERT INTO `ristorante`.`piatto` VALUES (10, 'torta', 2, 'Dolce');
# Data for table `ristorante`.`tavolo`:
INSERT INTO `ristorante`.`tavolo` VALUES (1, 1);
INSERT INTO `ristorante`.`tavolo` VALUES (4, 1);
INSERT INTO `ristorante`.`tavolo` VALUES (2, 2);
INSERT INTO `ristorante`.`tavolo` VALUES (3, 3);
#...done.
SET FOREIGN_KEY_CHECKS=1;
