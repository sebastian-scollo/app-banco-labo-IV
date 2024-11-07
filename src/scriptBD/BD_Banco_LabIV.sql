create database BancoGestionLab4;

use BancoGestionLab4;
DROP DATABASE  BancoGestionLab4
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
(1, 'homero', 'donuts123', 1, 1),
(2, 'marge', 'maggie123', 2, 1),
(3, 'bart', 'skateboard', 2, 1),
(4, 'lisa', 'jazz123', 2, 1),
(5, 'maggie', 'pacifier123', 2, 1);

INSERT INTO Provincias (IDProvincia, Nombre) VALUES
(1, 'Buenos Aires'),
(2, 'Catamarca'),
(3, 'Chaco'),
(4, 'Chubut'),
(5, 'CABA'),
(6, 'Corrientes'),
(7, 'Entre Ríos'),
(8, 'Formosa'),
(9, 'Jujuy'),
(10, 'La Pampa'),
(11, 'La Rioja'),
(12, 'Mendoza'),
(13, 'Misiones'),
(14, 'Neuquén'),
(15, 'Río Negro'),
(16, 'Salta'),
(17, 'San Juan'),
(18, 'San Luis'),
(19, 'Santa Cruz'),
(20, 'Santa Fe'),
(21, 'Santiago del Estero'),
(22, 'Tierra del Fuego'),
(23, 'Tucumán');

	
-- Localidades para Buenos Aires
INSERT INTO Localidades (Nombre, ProvinciaID) VALUES
('La Plata', 1),
('Mar del Plata', 1),
('Avellaneda', 1),
('Lomas de Zamora', 1),
('San Isidro', 1);

-- Localidades para CABA
INSERT INTO Localidades (Nombre, ProvinciaID) VALUES
('Balvanera', 5),
('Villa Devoto', 5),
('Palermo', 5),
('Recoleta', 5),
('Caballito', 5);

-- Localidades para Mendoza
INSERT INTO Localidades (Nombre, ProvinciaID) VALUES
('Mendoza', 12),
('San Rafael', 12),
('Godoy Cruz', 12);


INSERT INTO Clientes (DNI, CUIL, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, Telefono, CorreoElectronico, UsuarioID) VALUES
('12345678', '20-12345678-9', 'Homer', 'Simpson', 'Masculino', 'Argentina', '1970-05-12', '01112345678', 'homer@simpson.com', 1),
('87654321', '27-87654321-9', 'Marge', 'Simpson', 'Femenino', 'Argentina', '1970-02-20', '01198765432', 'marge@simpson.com', 2),
('11223344', '20-11223344-2', 'Bart', 'Simpson', 'Masculino', 'Argentina', '1990-03-07', '01111223344', 'bart@simpson.com', 3),
('22334455', '27-22334455-8', 'Lisa', 'Simpson', 'Femenino', 'Argentina', '1993-09-11', '01122334455', 'lisa@simpson.com', 4),
('33445566', '20-33445566-6', 'Maggie', 'Simpson', 'Femenino', 'Argentina', '2000-01-01', '01133445566', 'maggie@simpson.com', 5);

INSERT INTO Direcciones (Calle, Numero, Piso, Departamento, LocalidadID, ClienteID) VALUES
('Avenida 9 de Julio', 500, 3, 'A', 5, 1),
('Calle Ficticia', 123, NULL, NULL, 5, 2),
('Calle Springfield', 101, 2, 'B', 12, 3),
('Avenida Los Simpsons', 999, NULL, NULL, 5, 4),
('Calle de los Simpsons', 77, 1, 'C', 5, 5);

INSERT INTO TipoCuentas (Descripcion) VALUES
('Ahorro'),
('Corriente'),
('Plazo Fijo');

INSERT INTO Cuentas (NumeroCuenta, CBU, Saldo, ClienteID, TipoCuentaID) VALUES
('1234567890123', '0123456789012345678901', 10000.00, 1, 1),
('2345678901234', '1234567890123456789012', 20000.00, 2, 2),
('3456789012345', '2345678901234567890123', 30000.00, 3, 3),
('4567890123456', '3456789012345678901234', 15000.00, 4, 1),
('5678901234567', '4567890123456789012345', 5000.00, 5, 2);


 INSERT INTO Cuentas (NumeroCuenta, CBU, Saldo, ClienteID, TipoCuentaID) VALUES
('12345', 'C111', 10000.00, 1, 1),
('23456', 'C222', 20000.00, 2, 2),
('34567', 'C333', 30000.00, 3, 3),
('45678', 'C444', 15000.00, 4, 1),
('56789', 'C555', 5000.00, 5, 2);

INSERT INTO TipoMovimientos (Descripcion) VALUES
('Transferencia'),
('Alta Cuenta'),
('Alta Prestamo'),
('Pago de prestamo');

INSERT INTO Movimientos (Detalle, Importe, IDCuentaEmisor, IDCuentaReceptor, TipoMovimientoID) VALUES
('Transferencia a cuenta de Marge', 500.00, 1, 2, 1),  
('Depósito de salario', 2000.00, 2, 2, 2),           
('Retiro en cajero', 1000.00, 3, NULL, 3),            
('Pago de préstamo de Lisa', 1500.00, 4, NULL, 4);     

INSERT INTO Prestamos (MontoSolitado, ImporteAPagar, Plazo, Estado, FechaSolicitado, ClienteID) VALUES
(10000.00, 12000.00, 12, 'En tramite', '2024-10-01', 1),
(5000.00, 6000.00, 6, 'Aprobado', '2024-09-15', 2),
(15000.00, 18000.00, 24, 'En tramite', '2024-08-20', 3);

INSERT INTO Cuotas (FechaAbonada, NumeroCuota, ImporteAbonado, Estado, PrestamoID) VALUES
('2024-10-01', 1, 1000.00, 1, 1),
('2024-09-20', 6, 1000.00, 1, 2),
('2024-08-25', 1, 1000.00, 1, 3);

   
    
    
    
    
    
    
	






    
    
    
    
    
    
    