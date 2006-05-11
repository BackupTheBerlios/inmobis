#Para cargar este documento al mysql hacer: >>shell>> mysql -u root -p < tablas1.sql;
#Este es para crear la base con las tablas!!!

drop database inmobis;
create database inmobis;
use inmobis;

create table TLogin (
nombreUsuario  varchar(12) NOT NULL,
password  varchar(12) NOT NULL,
tipoUsuario varchar(12)NOT NULL,

PRIMARY KEY (nombreUsuario)
) TYPE=InnoDB;

create table TEmpleados (
 idEmpleado  varchar(12) NOT NULL,
 nombre  varchar(12) NOT NULL,
 apellido1 varchar(12) NOT NULL,
 apellido2 varchar(12) NOT NULL,
 fechNacimiento date NOT NULL,

 PRIMARY KEY (idEmpleado)
) TYPE=InnoDB;

create table TCliente
(
 idCliente  varchar(12) NOT NULL,
 nombre  varchar(12) NOT NULL,
 apellido1 varchar(12) NOT NULL,
 apellido2 varchar(12) NOT NULL,
 fechNacimiento date NOT NULL,
 PRIMARY KEY (idCliente)
) TYPE=InnoDB;

create table TInmueble
(
 idInmueble  varchar(12) NOT NULL,
 metros varchar(10) NOT NULL,
 regimen varchar (12) NOT NULL,
 precio integer NOT NULL,
 datosdeinteres varchar (50),
 PRIMARY KEY (idInmueble)
) TYPE=InnoDB;

create table TDirInmueble
(
 idGeneral     varchar(30) NOT NULL,
 descDir        varchar(50) NOT NULL,
 calle          varchar(30) NOT NULL,
 num            varchar(4) NOT NULL,
 piso           varchar(10) NOT NULL,
 codPostal      varchar(5) NOT NULL,
 poblacion      varchar(30) NOT NULL,
 provincia      varchar(30) NOT NULL,
 pais           varchar(30) NOT NULL,

 Primary KEY (idGeneral,descDir),
 FOREIGN KEY (idGeneral)
 REFERENCES TInmueble(idInmueble)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;

create table TDirCliente
(
 descDir        varchar(50) NOT NULL,
 calle          varchar(30) NOT NULL,
 num            varchar(4) NOT NULL,
 piso           varchar(10) NOT NULL,
 codPostal      varchar(5) NOT NULL,
 poblacion      varchar(30) NOT NULL,
 provincia      varchar(30) NOT NULL,
 pais           varchar(30) NOT NULL,
idGeneral varchar(30) NOT NULL,
 Primary KEY (idGeneral,descDir),
 FOREIGN KEY (idGeneral)
 REFERENCES TCliente(idCliente)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;

create table TMailCliente
(
 idGeneral        varchar(30) NOT NULL,
 dirMail          varchar(30) NOT NULL,
 descMail    varchar(50) NOT NULL, 
 PRIMARY KEY (idGeneral,descMail),
 FOREIGN KEY (idGeneral)
 REFERENCES TCliente(idCliente)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;

create table TTelfCliente
(
 idGeneral             varchar(30) NOT NULL,
 descTelefono       varchar(50) NOT NULL,
 telefono              varchar(9) NOT NULL,
 telefono2            varchar (9),
 PRIMARY KEY (idGeneral,descTelefono),
 FOREIGN KEY (idGeneral)
 REFERENCES TCliente(idCliente)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;

create table TDirEmpleado
(
 idGeneral varchar(30)  NOT NULL,
 descDir        varchar(50) NOT NULL,
 calle         varchar(30)  NOT NULL,
 num            varchar(4)  NOT NULL,
 piso           varchar(10)  NOT NULL,
 codPostal      varchar(5)  NOT NULL,
 poblacion      varchar(30) NOT NULL,
 provincia      varchar(30) NOT NULL,
 pais           varchar(30)  NOT NULL,
 PRIMARY KEY (idGeneral,descDir),
 FOREIGN KEY (idGeneral)
 REFERENCES TEmpleados(idEmpleado)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;


create table TMailEmpleado
(
 idGeneral        varchar(30) NOT NULL,
 dirMail          varchar(30) NOT NULL,
 descMail    varchar(50) NOT NULL, 
 Primary KEY (descMail,idGeneral),
 FOREIGN KEY (idGeneral)
 REFERENCES TEmpleados(idEmpleado)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;

create table TTelfEmpleado
(
 idGeneral        varchar(30) NOT NULL,
 descTelefono     varchar(50) NOT NULL,
 telefono         varchar(9) NOT NULL,
 telefono2        varchar(9),


 PRIMARY KEY (idGeneral,descTelefono),
 FOREIGN KEY (idGeneral)
 REFERENCES TEmpleados(idEmpleado)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;

create table TContable
( 
 idContable varchar(30) NOT NULL,
 PRIMARY KEY (idContable), 
 FOREIGN KEY (idContable)
 REFERENCES TEmpleados(idEmpleado)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;

create table TGerente
( 
 idGerente  varchar(30) NOT NULL,
 Primary KEY (idGerente),
 FOREIGN KEY (idGerente)
 REFERENCES TEmpleados(idEmpleado)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;


create table TAdministrador
( 
 idAdministrador varchar(30) NOT NULL,
 Primary KEY (idAdministrador),
 FOREIGN KEY (idAdministrador)
 REFERENCES TEmpleados(idEmpleado)
 ON UPDATE CASCADE ON DELETE CASCADE
) TYPE=InnoDB;


#TINYTEXT:para un máximo de 255 caracteres
#TEXT: se usa para cadenas con un rango de 255 - 65535 caracteres. 
#MEDIUMTEXT:textos de hasta 16777215 caracteres.
#LONGTEXT:hasta máximo de 4.294.967.295 caracteres
