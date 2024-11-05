create database BancoGestionLab4;

use BancoGestionLab4;

create table Usuarios(
	IDUsuario int primary key not null,
    NombreUsuario varchar (20) not null,
    Contrasenia varchar (100) not null,
    TipoUsuario tinyint not null,
    Estado bit not null default 1
);

create table Clientes(
	IDCliente int primary key auto_increment,
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
    foreign key (UsuarioID) references Usuarios (IDUsuario)
);

create table Provincias(
	IDProvincia int primary key auto_increment,
    Nombre varchar(50) not null
);

create table Localidades(
	IDLocalidad int primary key auto_increment,
    Nombre varchar(50),
    ProvinciaID varchar(50),
    foreign key (ProvinciaID) references Provincias(IDProvincia)
);

create table Direcciones(
	IDDireccion int primary key auto_increment,
    Calle varchar(50) not null,
    Numero int not null,
    Piso int,
    Departamento varchar(10),
    LocalidadID int,
    ClienteID int,
    foreign key (LocalidadID) references Localidades (IDLocalidad),
    foreign key (ClienteID) references Clientes (IDClientes)
);

create table TipoCuentas(
	IDTipoCuenta int primary key auto_increment,
    Descripcion varchar(20)
);

create table Cuentas(
	IDCuenta int primary key auto_increment,
    NumeroCuenta varchar(13) not null,
    CBU char(22) unique not null,
    Saldo decimal(15,2) not null default 10000,
    ClienteID int not null,
    TipoCuentaID int not null,
    FechaCreacion datetime not null default current_timestamp,
    Estado bit not null default 1,
    foreign key (ClienteID) references Clientes (IDClientes),
    foreign key (TipoCuentaID) references TipoCuentas (IDTipoCuenta)
);

create table TipoMovimientos(
	IDTipoMovimiento int primary key auto_increment,
    Descripcion varchar(100)
);

create table Movimientos(
	IDMovimiento int primary key auto_increment,
    Detalle varchar(200),
    Importe decimal(15,2) not null,
    IDCuentaEmisor int,
    IDCuentaReceptor int,
    TipoMovimientoID int not null,
    foreign key (TipoMovimientoID) references TipoMovimientos (IDTipoMovimiento)
);

create table Prestamos(
	IDPrestamo int primary key auto_increment,
    MontoSolitado decimal(15,2) not null,
    ImporteAPagar decimal(15,2) not null,
    Plazo int not null,
    Estado varchar(50) default 'En tramite',
    FechaSolicitado datetime not null default current_timestamp,
    FechaRespuesta datetime,
    ClienteID int not null,
    foreign key (ClienteID) references Clientes (IDClientes)
);

create table Cuotas(
	IDCuota int primary key auto_increment,
    FechaAbonada datetime,
    NumeroCuota int not null,
    ImporteAbonado decimal(15,2),
    Estado bit default 0,
    PrestamoID int not null,
    foreign key (PrestamoID) references Prestamos (IDPrestamo)
);
    
	






    
    
    
    
    
    
    