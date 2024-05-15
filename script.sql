create database bd_internet;

use bd_internet;

CREATE TABLE estudiante(
    id int not null auto_increment,
    nombre varchar(50),
    apellido varchar(50),
    seminario varchar(100),
    confirmado varchar(2),
    fecha date
);