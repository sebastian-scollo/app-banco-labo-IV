DROP DATABASE IF EXISTS BancoGestionLab4;
create database BancoGestionLab4;


use BancoGestionLab4;
create table Usuarios(
	IDUsuario  INT auto_increment,
    NombreUsuario varchar (20) not null,
    Contrasenia varchar (100) not null,
    TipoUsuario tinyint ,
    Estado bit not null default 1,
   CONSTRAINT validarTipoUsuario CHECK (TipoUsuario=1 OR TipoUsuario=2), # recordar de que 1 es ADMIN y 2 es Cliente solo vamos usar 2 valores.
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
    cbuEmisor char(22),
    cbuReceptor char(22),
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
    Estado bit default 0, -- cero es no pagado, 1 es cuota ya pagada o abonada
    PrestamoID int not null,
constraint PK_CUOTA primary key(IDCuota),
 constraint foreign key (PrestamoID) references Prestamos (IDPrestamo)

);

INSERT INTO Usuarios (IDUsuario, NombreUsuario, Contrasenia, TipoUsuario, Estado) VALUES
(1, 'HomeroJ', 'D0H!', 1, 1),
(2, 'Marge', 'Maggie123', 2, 1), 
(3, 'Bart', 'barto123', 2, 1),
(4, 'Lisa', '12345', 2, 1),
(5, 'Maggie', 'Baby123', 2, 1),
(6, 'Ned', 'Flanders123', 2, 1),
(7, 'Mr_Burns', 'plata123', 2, 1),
(8, 'Milhouse', '4ojos123', 1, 1),
(9, 'Ralph', 'dolape123', 2, 1),
(10, 'Apu', 'nahaza123', 1, 1),
(11, 'Barney', 'Duff123', 2, 1),
(12, 'Krusty', 'burger123', 2, 1),
(13, 'Smithers', 'Mr_Burns123', 2, 1),
(14, 'Edna', 'clavadosl123', 2, 1),
(15, 'Groundskeeper_Willie', 'Escocia123', 2, 1);


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
(1, '12345', '20123455', 'Homero', 'Simpson', 'Masculino', 'Argentina', '1956-05-12', '1234567890', 'homer@simpson.com', 1, 1),
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
(1, '123456', '0000000000000000000001', 1, 1, '2023-01-01', 1),
(2, '234567', '0000000000000000000002', 2, 2, '2023-02-01', 1),
(3, '345678', '0000000000000000000003', 3, 1, '2023-03-01', 1),
(4, '456789', '0000000000000000000004', 4, 3, '2023-04-01 ', 1),
(5, '567890', '0000000000000000000005', 5, 1, '2023-05-01', 1),
(6, '678901', '0000000000000000000006', 6, 2, '2023-06-01', 1),
(7, '789012', '0000000000000000000007', 7, 3, '2023-07-01', 1),
(8, '890123', '0000000000000000000008', 8, 1, '2023-08-01', 1),
(9, '901234', '0000000000000000000009', 9, 2, '2023-09-01', 1),
(10, '012345', '0000000000000000000010', 10, 3, '2023-10-01', 1),
(11, '123456', '0000000000000000000011', 11, 1, '2023-11-01', 1),
(12, '234567', '0000000000000000000012', 12, 2, '2023-12-01', 1),
(13, '345678', '0000000000000000000013', 13, 3, '2023-01-01', 1),
(14, '456789', '0000000000000000000014', 14, 1, '2023-02-01', 1),
(15, '567890', '0000000000000000000015', 15, 2, '2023-03-01', 1);

INSERT INTO TipoMovimientos (IDTipoMovimiento, Descripcion) VALUES
(1, 'Alta de cuenta'),
(2, 'Alta de un prestamo'),
(3, 'Pago de prestamo'),
(4, 'Transferencia');


INSERT INTO Movimientos (IDMovimiento, Detalle, Importe, cbuEmisor, cbuReceptor, TipoMovimientoID) VALUES
(1, 'Alta de cuenta', 10000.00, '0000000000000000000001','0000000000000000000002', 1),
(2, 'Alta de cuenta', 10000.00, '0000000000000000000002', '0000000000000000000003', 1),
(3, 'Alta de cuenta', 10000.00, '0000000000000000000003', '0000000000000000000004', 1), 
(4, 'Alta de cuenta', 10000.00, '0000000000000000000004', '0000000000000000000005', 1),
(5, 'Alta de cuenta', 10000.00, '0000000000000000000005','0000000000000000000006', 1),
(6, 'Alta de prestamo', 50000.00,'0000000000000000000001','0000000000000000000006', 2),
(7, 'Alta de prestamo', 75000.00,'0000000000000000000002','0000000000000000000001', 2),
(8, 'Alta de prestamo', 100000.00,'0000000000000000000003','0000000000000000000001', 2),
(9, 'Pago de prestamo', 5000.00,'0000000000000000000001','0000000000000000000004', 3),
(10, 'Pago de prestamo', 7500.00,'0000000000000000000002','0000000000000000000005', 3),
(11, 'Pago de prestamo', 10000.00,'0000000000000000000003','0000000000000000000002', 3),
(12, 'Transferencia', 1000.00,'0000000000000000000001','0000000000000000000004', 4),
(13, 'Transferencia', 2000.00,'0000000000000000000002','0000000000000000000006', 4),
(14, 'Transferencia', 3000.00,'0000000000000000000003','0000000000000000000005', 4),
(15, 'Transferencia', 4000.00,'0000000000000000000004','0000000000000000000001', 4);

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


INSERT INTO Cuotas (IDCuota, NumeroCuota, FechaAbonada, ImporteAbonado, Estado, PrestamoID) VALUES
(1, 1, '2023-04-15', 4583.33, 1, 1),
(2, 2, '2023-05-15', 4583.33, 1, 1),
(3, 3, '2023-06-15', 4583.34, 1, 1),
(4, 4, '2023-07-15', 4583.33, 1, 1),
(5, 5, '2023-08-15', 4583.33, 1, 1),
(6, 1, '2023-05-20', 4583.33, 1, 2), 
(7, 2, '2023-06-20', 4583.33, 1, 2),
(8, 3, '2023-07-20', 4583.34, 1, 2),
(9, 4, '2023-08-20', 4583.33, 1, 2),
(10, 5, '2023-09-20', 4583.33, 1, 2),
(11, 6, '2023-10-20', 4583.33, 1, 2),
(12, 7, '2023-11-20', 4583.34, 1, 2),
(13, 8, '2023-12-20', 4583.33, 1, 2),
(14, 9, '2024-01-20', 4583.33, 1, 2),
(15, 10, '2024-02-20', 4583.33, 1, 2),
(16, 1, '2023-06-25', 4583.33, 1, 3),
(17, 2, '2023-07-25', 4583.33, 1, 3),
(18, 3, '2023-08-25', 4583.34, 1, 3),
(19, 4, '2023-09-25', 4583.33, 1, 3),
(20, 5, '2023-10-25', 4583.33, 1, 3),
(21, 6, '2023-11-25', 4583.33, 1, 3),
(22, 7, '2023-12-25', 4583.34, 1, 3),
(23, 8, '2024-01-25', 4583.33, 1, 3),
(24, 9, '2024-02-25', 4583.33, 1, 3),
(25, 10, '2024-03-25', 4583.33, 1, 3),
(26, 1, '2023-07-30', 4583.33, 1, 4),
(27, 2, '2023-08-30', 4583.33, 1, 4),
(28, 3, '2023-09-30', 4583.34, 1, 4),
(29, 4, '2023-10-30', 4583.33, 1, 4),
(30, 5, '2023-11-30', 4583.33, 1, 4),
(31, 6, '2023-12-30', 4583.33, 1, 4),
(32, 1, '2023-08-05', 4583.33, 1, 5),
(33, 2, '2023-09-05', 4583.33, 1, 5),
(34, 3, '2023-10-05', 4583.34, 1, 5),
(35, 4, '2023-11-05', 4583.33, 1, 5),
(36, 5, '2023-12-05', 4583.33, 1, 5),
(37, 6, '2024-01-05', 4583.33, 1, 5),
(38, 7, '2024-02-05', 4583.34, 1, 5),
(39, 8, '2024-03-05', 4583.33, 1, 5),
(40, 9, '2024-04-05', 4583.33, 1, 5),
(41, 10, '2024-05-05', 4583.33, 1, 5),
(42, 11, '2024-06-05', 4583.34, 1, 5),
(43, 12, '2024-07-05', 4583.33, 1, 5);

#estoy cansado jefe