create database BancoGestionLab4;

use BancoGestionLab4;
create table Usuarios(
	IDUsuario  INT not null,
    NombreUsuario varchar (20) not null,
    Contrasenia varchar (100) not null,
    TipoUsuario tinyint not null,
    Estado bit not null default 1,
    CONSTRAINT PK_usuarios PRIMARY KEY(IDUsuario)
);

create table Clientes(
	IDCliente int auto_increment,
    DNI varchar(8) unique not null,
    CUIL varchar(13) unique not null,
    Nombre varchar(50) not null,
    Apellido varchar(50) not null,
    Sexo ENUM('Masculino', 'Femenino', 'No binario') not null,
    Nacionalidad varchar(50) not null,
    FechaNacimiento date not null,
    Telefono varchar(20),
    CorreoElectronico varchar(254) not null,
    UsuarioID int unique not null,
    activo boolean not null default 1,
    constraint pk_cliente primary key(IDCliente),
   constraint fk_clienteUsuario foreign key (UsuarioID) references Usuarios (IDUsuario)
);
-- SELECT IDCliente,DNI,CUIL,Nombre,Apellido,Sexo,Nacionalidad,FechaNacimiento,Telefono,CorreoElectronico,UsuarioID FROM Clientes WHERE activo=1


create table Provincias(
	IDProvincia int,
    Nombre varchar(50) not null,
    constraint pk_provincia primary key(IDProvincia)
);

create table Localidades(
	IDLocalidad int auto_increment,
    Nombre varchar(50),
    ProvinciaID int NOT NULL,
    constraint PK_Localidad primary key(IDLocalidad),
 constraint FK_ProvinciaLocalidad foreign key (ProvinciaID) references Provincias(IDProvincia)   
);
 
CREATE TABLE Direcciones (
    IDDireccion INT AUTO_INCREMENT,
    Calle VARCHAR(50) NOT NULL,
    Numero INT NOT NULL,
    Piso INT,
    Departamento VARCHAR(10),
    LocalidadID INT,
    ClienteID INT,
    CONSTRAINT pkDireccion PRIMARY KEY (IDDireccion),
    CONSTRAINT fk_localidad FOREIGN KEY (LocalidadID) REFERENCES Localidades (IDLocalidad),
    CONSTRAINT fk_cliente FOREIGN KEY (ClienteID) REFERENCES Clientes (IDCliente)
);

create table TipoCuentas(
	IDTipoCuenta int auto_increment,
    Descripcion varchar(20),
    constraint pkTipoCuenta primary key(IDTipoCuenta)
);

create table Cuentas(
	IDCuenta int auto_increment,
    NumeroCuenta varchar(13) not null,
    CBU char(22) unique not null,
    Saldo decimal(15,2) not null default 10000,
    ClienteID int not null,
    TipoCuentaID int not null,
    FechaCreacion datetime not null default current_timestamp,
    Estado bit not null default 1,
    CONSTRAINT PK_CUENTA primary key(IDCuenta),
   CONSTRAINT fk_clienteCuenta foreign key (ClienteID) references Clientes (IDCliente),
   CONSTRAINT fk_TipoCuenta_cuenta foreign key (TipoCuentaID) references TipoCuentas (IDTipoCuenta)
);

create table TipoMovimientos(
	IDTipoMovimiento int auto_increment,
    Descripcion varchar(100) not null,
    CONSTRAINT PK_TIPOMOV PRIMARY KEY(IDTipoMovimiento)
);

create table Movimientos(
	IDMovimiento int auto_increment,
    Detalle varchar(200),
    Importe decimal(15,2) not null,
    IDCuentaEmisor int,
    IDCuentaReceptor int,
    TipoMovimientoID int not null,
    constraint pk_movimiento primary key(IDMovimiento),
    constraint foreign key (TipoMovimientoID) references TipoMovimientos (IDTipoMovimiento)
);

create table Prestamos(
	IDPrestamo int auto_increment,
    MontoSolitado decimal(15,2) not null,
    ImporteAPagar decimal(15,2) not null,
    Plazo int not null,
    Estado varchar(50) default 'En tramite',
    FechaSolicitado datetime not null default current_timestamp,
    FechaRespuesta datetime,
    ClienteID int not null,
    constraint pk_Prestamo primary key(IDPrestamo),
    constraint foreign key (ClienteID) references Clientes (IDCliente)
);

create table Cuotas(
	IDCuota int auto_increment,
    FechaAbonada datetime,
    NumeroCuota int not null,
    ImporteAbonado decimal(15,2),
    Estado bit default 0,
    PrestamoID int not null,
constraint PK_CUOTA primary key(IDCuota),
 constraint foreign key (PrestamoID) references Prestamos (IDPrestamo)

);

INSERT INTO Usuarios (IDUsuario, NombreUsuario, Contrasenia, TipoUsuario, Estado) VALUES
(1, 'Homer', 'D0H!', 1, 1),
(2, 'Marge', 'Maggie123', 1, 1), 
(3, 'Bart', 'Prank123', 1, 1),
(4, 'Lisa', 'Smart123', 1, 1),
(5, 'Maggie', 'Baby123', 1, 1),
(6, 'Ned', 'Flanders123', 2, 1),
(7, 'Mr_Burns', 'Money123', 2, 1),
(8, 'Milhouse', 'Bestfriend123', 1, 1),
(9, 'Ralph', 'Wiggum123', 1, 1),
(10, 'Apu', 'Kwik-E-Mart123', 1, 1),
(11, 'Barney', 'Duff123', 1, 1),
(12, 'Krusty', 'Clown123', 2, 1),
(13, 'Smithers', 'Mr_Burns123', 2, 1),
(14, 'Edna', 'Krabappel123', 1, 1),
(15, 'Groundskeeper_Willie', 'Scotsman123', 1, 1);


INSERT INTO Provincias (IDProvincia, Nombre) VALUES
(1, 'Buenos Aires'),
(2, 'Catamarca'),
(3, 'Chaco'), 
(4, 'Chubut'),
(5, 'Córdoba'),
(6, 'Corrientes'),
(7, 'Entre Ríos'),
(8, 'Formosa'),
(9, 'Jujuy'),
(10, 'La Pampa'),
(11, 'La Rioja'),
(12, 'Mendoza'),
(13, 'Misiones'),
(14, 'Neuquén'),
(15, 'Río Negro');

INSERT INTO Localidades (IDLocalidad, Nombre, ProvinciaID) VALUES
(1, 'Springfield', 1),
(2, 'Córdoba', 5),
(3, 'Buenos Aires', 1),
(4, 'Resistencia', 3),
(5, 'Trelew', 4),
(6, 'Mendoza', 12),
(7, 'Posadas', 13),
(8, 'Neuquén', 14),
(9, 'San Carlos de Bariloche', 15),
(10, 'Paraná', 7),
(11, 'Formosa', 8),
(12, 'San Salvador de Jujuy', 9),
(13, 'Santa Rosa', 10),
(14, 'La Rioja', 11),
(15, 'Catamarca', 2);

INSERT INTO Clientes (IDCliente, DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, Telefono, CorreoElectronico, UsuarioID, activo) VALUES
(1, '12345', '20123455', 'Homer', 'Simpson', 'Masculino', 'Argentina', '1956-05-12', '1234567890', 'homer@simpson.com', 1, 1),
(2, '23456', '20234566', 'Marge', 'Simpson', 'Femenino', 'Argentina', '1958-06-19', '2345678901', 'marge@simpson.com', 2, 1),
(3, '34567', '20345677', 'Bart', 'Simpson', 'Masculino', 'Argentina', '1980-04-01', '3456789012', 'bart@simpson.com', 3, 1),
(4, '45678', '20456788', 'Lisa', 'Simpson', 'Femenino', 'Argentina', '1982-05-09', '4567890123', 'lisa@simpson.com', 4, 1),
(5, '56789', '20567899', 'Maggie', 'Simpson', 'Femenino', 'Argentina', '1988-01-21', '5678901234', 'maggie@simpson.com', 5, 1),
(6, '67890', '20678900', 'Ned', 'Flanders', 'Masculino', 'Argentina', '1960-06-01', '6789012345', 'ned@flanders.com', 6, 1),
(7, '78901', '20789011', 'Mr.', 'Burns', 'Masculino', 'Argentina', '1920-09-15', '7890123456', 'burns@power-plant.com', 7, 1),
(8, '89012', '20890122', 'Milhouse', 'Van Houten', 'Masculino', 'Argentina', '1980-09-01', '8901234567', 'milhouse@vanhouten.com', 8, 1),
(9, '90123', '20901233', 'Ralph', 'Wiggum', 'Masculino', 'Argentina', '1982-06-15', '9012345678', 'ralph@wiggum.com', 9, 1),
(10, '01234', '20012344', 'Apu', 'Nahasapeemapetilon', 'Masculino', 'Argentina', '1962-07-25', '0123456789', 'apu@kwik-e-mart.com', 10, 1),
(11, '12399', '20123459', 'Barney', 'Gumble', 'Masculino', 'Argentina', '1960-02-10', '1234567890', 'barney@duff.com', 11, 1),
(12, '234566', '20234569', 'Krusty', 'The Clown', 'Masculino', 'Argentina', '1952-08-01', '2345678901', 'krusty@krustyburger.com', 12, 1),
(13, '34567777', '203456777', 'Waylon', 'Smithers', 'Masculino', 'Argentina', '1961-04-18', '3456789012', 'smithers@power-plant.com', 13, 1),
(14, '4567888', '2045678888', 'Edna', 'Krabappel', 'Femenino', 'Argentina', '1955-09-27', '4567890123', 'edna@springfieldschool.edu', 14, 1),
(15, '5678989', '2056789989', 'Groundskeeper', 'Willie', 'Masculino', 'Argentina', '1958-03-05', '5678901234', 'willie@springfieldschool.edu', 15, 1);

INSERT INTO Direcciones (IDDireccion, Calle, Numero, Piso, Departamento, LocalidadID, ClienteID) VALUES
(1, 'Avenida Rivadavia', 123, 1, 'A', 3, 1),
(2, 'Calle Florida', 456, 2, 'B', 3, 2),
(3, 'Avenida Corrientes', 789, 1, 'C', 3, 3),
(4, 'Calle Libertad', 321, 3, 'D', 3, 4),
(5, 'Avenida 9 de Julio', 654, 1, 'E', 3, 5),
(6, 'Calle Defensa', 987, 2, 'F', 3, 6),
(7, 'Avenida Santa Fe', 159, 2, 'G', 3, 7),
(8, 'Calle Arroyo', 753, 3, 'H', 3, 8),
(9, 'Avenida Callao', 951, 1, 'I', 3, 9),
(10, 'Calle Lavalle', 357, 2, 'J', 3, 10),
(11, 'Avenida Independencia', 852, 3, 'K', 3, 11),
(12, 'Calle Reconquista', 147, 1, 'L', 3, 12),
(13, 'Avenida General Paz', 963, 2, 'M', 3, 13),
(14, 'Calle Esmeralda', 258, 3, 'N', 3, 14),
(15, 'Avenida de Mayo', 369, 1, 'O', 3, 15);

INSERT INTO TipoCuentas (IDTipoCuenta, Descripcion) VALUES
(1, 'Ahorro'),
(2, 'Corriente'), 
(3, 'Plazo Fijo');


INSERT INTO Cuentas (IDCuenta, NumeroCuenta, CBU, ClienteID, TipoCuentaID, FechaCreacion, Estado) VALUES
(1, '123456', '12345', 1, 1, '2023-01-01', 1),
(2, '234567', '23456', 2, 2, '2023-02-01', 1),
(3, '345678', '34567', 3, 1, '2023-03-01', 1),
(4, '456789', '45678', 4, 3, '2023-04-01 ', 1),
(5, '567890', '56789', 5, 1, '2023-05-01', 1),
(6, '678901', '67890', 6, 2, '2023-06-01', 1),
(7, '789012', '78901', 7, 3, '2023-07-01', 1),
(8, '890123', '89012', 8, 1, '2023-08-01', 1),
(9, '901234', '90123', 9, 2, '2023-09-01', 1),
(10, '012345', '01234', 10, 3, '2023-10-01', 1),
(11, '123456', '1234589', 11, 1, '2023-11-01', 1),
(12, '234567', '234569', 12, 2, '2023-12-01', 1),
(13, '345678', '345679', 13, 3, '2023-01-01', 1),
(14, '456789', '4567888', 14, 1, '2023-02-01', 1),
(15, '567890', '5678989', 15, 2, '2023-03-01', 1);

INSERT INTO TipoMovimientos (IDTipoMovimiento, Descripcion) VALUES
(1, 'Alta de cuenta'),
(2, 'Alta de un prestamo'),
(3, 'Pago de prestamo'),
(4, 'Transferencia');

INSERT INTO Movimientos (IDMovimiento, Detalle, Importe, IDCuentaEmisor, IDCuentaReceptor, TipoMovimientoID) VALUES
(1, 'Alta de cuenta', 10000.00, NULL, 1, 1),
(2, 'Alta de cuenta', 10000.00, NULL, 2, 1), 
(3, 'Alta de cuenta', 10000.00, NULL, 3, 1),
(4, 'Alta de cuenta', 10000.00, NULL, 4, 1),
(5, 'Alta de cuenta', 10000.00, NULL, 5, 1),
(6, 'Alta de préstamo', 50000.00, NULL, 1, 2),
(7, 'Alta de prestamo', 75000.00, NULL, 2, 2),
(8, 'Alta de prestamo', 100000.00, NULL, 3, 2),
(9, 'Pago de prestamo', 5000.00, 1, NULL, 3),
(10, 'Pago de prestamo', 7500.00, 2, NULL, 3),
(11, 'Pago de prestamo', 10000.00, 3, NULL, 3),
(12, 'Transferencia', 1000.00, 1, 2, 4),
(13, 'Transferencia', 2000.00, 2, 3, 4),
(14, 'Transferencia', 3000.00, 3, 4, 4),
(15, 'Transferencia', 4000.00, 4, 5, 4);

INSERT INTO Movimientos (IDMovimiento, Detalle, Importe, IDCuentaEmisor, IDCuentaReceptor, TipoMovimientoID) VALUES
(1, 'Alta de cuenta', 10000.00, 1, 1, 1),
(2, 'Alta de cuenta', 10000.00, 2, 2, 1),
(3, 'Alta de cuenta', 10000.00, 3, 3, 1), 
(4, 'Alta de cuenta', 10000.00, 4, 4, 1),
(5, 'Alta de cuenta', 10000.00, 5, 5, 1),
(6, 'Alta de prestamo', 50000.00, 1, 1, 2),
(7, 'Alta de prestamo', 75000.00, 2, 2, 2),
(8, 'Alta de prestamo', 100000.00, 3, 3, 2),
(9, 'Pago de prestamo', 5000.00, 1, 1, 3),
(10, 'Pago de prestamo', 7500.00, 2, 2, 3),
(11, 'Pago de prestamo', 10000.00, 3, 3, 3),
(12, 'Transferencia', 1000.00, 1, 2, 4),
(13, 'Transferencia', 2000.00, 2, 3, 4),
(14, 'Transferencia', 3000.00, 3, 4, 4),
(15, 'Transferencia', 4000.00, 4, 5, 4);

INSERT INTO Prestamos (IDPrestamo, MontoSolitado, ImporteAPagar, Plazo, FechaSolicitado, ClienteID) VALUES
(1, 50000.00, 55000.00, 12, '2023-04-01', 1),
(2, 75000.00, 82500.00, 18, '2023-05-01', 2),
(3, 100000.00, 110000.00, 24, '2023-06-01', 3),
(4, 25000.00, 27500.00, 6, '2023-07-01', 4),
(5, 150000.00, 165000.00, 36, '2023-08-01', 5),
(6, 40000.00, 44000.00, 9, '2023-09-01', 6), 
(7, 200000.00, 220000.00, 48, '2023-10-01', 7),
(8, 60000.00, 66000.00, 15, '2023-11-01', 8),
(9, 80000.00, 88000.00, 21, '2023-12-01', 9),
(10, 30000.00, 33000.00, 7, '2024-01-01', 10),
(11, 120000.00, 132000.00, 30, '2024-02-01', 11),
(12, 90000.00, 99000.00, 24, '2024-03-01', 12),
(13, 140000.00, 154000.00, 42, '2024-04-01', 13),
(14, 35000.00, 38500.00, 8, '2024-05-01', 14),
(15, 110000.00, 121000.00, 27, '2024-06-01', 15);


INSERT INTO Cuotas (IDCuota, NumeroCuota, PrestamoID) VALUES
(1, 1, 1), (2, 2, 1), (3, 3, 1), (4, 4, 1), (5, 5, 1), 
(6, 1, 2), (7, 2, 2), (8, 3, 2), (9, 4, 2), (10, 5, 2), (11, 6, 2), (12, 7, 2), (13, 8, 2), (14, 9, 2), (15, 10, 2),
(16, 1, 3), (17, 2, 3), (18, 3, 3), (19, 4, 3), (20, 5, 3), (21, 6, 3), (22, 7, 3), (23, 8, 3), (24, 9, 3), (25, 10, 3),
(26, 1, 4), (27, 2, 4), (28, 3, 4), (29, 4, 4), (30, 5, 4), (31, 6, 4),
(32, 1, 5), (33, 2, 5), (34, 3, 5), (35, 4, 5), (36, 5, 5), (37, 6, 5), (38, 7, 5), (39, 8, 5), (40, 9, 5), (41, 10, 5), (42, 11, 5), (43, 12, 5);