drop database if exists planilla;
create database planilla;
use planilla;

create table Varios (
  id int auto_increment primary key,
  Codigo int not null,
  Inicial char(1) not null,
  Detalle char(50) );

create table Cargo (
  id int auto_increment primary key,
  Detalle char(30) unique,
  Estado char(1) default 'C',
  created_at datetime default current_timestamp,
  updated_at datetime default current_timestamp );

create table CentroCosto (
  id int auto_increment primary key,
  Detalle char(30) unique,
  Estado char(1) default 'C',
  created_at datetime default current_timestamp,
  updated_at datetime default current_timestamp );

create table Departamento (
  id int auto_increment primary key,
  RazonSocial char(30) unique,
  Cuenta char(20),
  Estado char(1) default 'C',
  created_at datetime default current_timestamp,
  updated_at datetime default current_timestamp );

create table Sede (
  id int auto_increment primary key,
  RazonSocial char(30) unique,
  Direccion char(50),
  idDepartamento int not null,
  idProvincia int not null,
  idDistrito int not null,
  Estado char(1) default 'C',
  created_at datetime default current_timestamp,
  updated_at datetime default current_timestamp );

create table Empleado (
  id int auto_increment primary key,
  Dni char(8) unique,
  RUC char(11) unique,
  Nombres char(50) not null,
  ApellidoPaterno char(50) not null,
  ApellidoMaterno char(50) not null,
  FechaNacimiento char(10) not null,
  Direccion char(100) not null,
  Correo char(50) not null,
  Celular char(10) not null,
  Passwordd char(6) not null,
  idDomicialiado int references Varios,
  idEstadoCivil int references Varios,
  idNivelEducativo int references Varios,
  idDepartamento int not null,
  idProvincia int not null,
  idDistrito int not null,
  created_at datetime default current_timestamp,
  updated_at datetime default current_timestamp );

/* ----- Insert ----- */

insert Cargo(Detalle) values ('Administrador'), ('Vendedor'), ('Recepcionista');
insert Varios(Codigo, Inicial, Detalle) values
	(1,'','Domicialiado'),
    (2,'S','Soltero'),(2,'C','Casado'),(2,'D','Divorciado'),(2,'V','Viudo'),
    (3,'','Sin Educación'),(3,'','Primaria incompleta'),(3,'','Primaria completa'),
		(3,'','Secundaria incompleta'), (3,'','Secundaria Completa'),
		(3,'','Técnico incompleto'),(3,'','Técnico completo'),(3,'','Técnico Titulado'),
        (3,'','Universitario incompleto'),(3,'','Universitario completo'),
    (4,'C','Creado'),(4,'E','Editado'),(4,'O','Anulado'),(4,'A','Activo'),(4,'I','Inactivo');
        
insert Empleado values 
	(null, '99887766','10998877660','Omar','Espinoza','Manrique de Lara','17/09/1973','Puente Piedra','omar@gmail.com','993217610','123456',1,3,14,1,1,1, current_timestamp(), current_timestamp() );

/* ----- Procedimiento Almacenados ----- */

create procedure sp_getEstados(in _id int)
   select Inicial, Detalle from Varios where Codigo = _id;

create procedure sp_getCargos()
   select *, lower(Detalle) from Cargo order by id;

create procedure sp_getCentroCostos()
   select *, lower(Detalle) from CentroCosto order by id;

create procedure sp_getDepartamentos()
   select *, lower(RazonSocial) from Departamento order by id;

create procedure sp_getSede(in _id int)
   select * from Sede where id = _id;

create procedure sp_getSedes()
   select id, RazonSocial, lower(RazonSocial) from Sede order by id;

create procedure sp_getEmpleadoLogin(in _dni char(8), in _passwordd char(6))
	select * from Empleado where Dni = _dni and Passwordd = _passwordd;

create procedure sp_getEmpleado(in _id int)
	select * from Empleado where id = _id;

delimiter //
create procedure sp_GuardarCargo( in _id int, in _detalle char(30) )
	if ( _id = -1 ) then
    -- select 0
		insert Cargo(Detalle) values ( _detalle );
	else update Cargo set Detalle = _detalle, Estado = 'E', updated_at = current_timestamp() where id = _id;
    end if;
//

delimiter //
create procedure sp_GuardarCentroCosto( in _id int, in _detalle char(30) )
	if ( _id = -1 ) then
		insert CentroCosto(Detalle) values (_detalle);
	else update CentroCosto set Detalle = _detalle, Estado = 'E', updated_at = current_timestamp() where id = _id;
    end if;
//

delimiter //
create procedure sp_GuardarDepartamento( in _id int, in _razonSocial char(30), in _cuenta char(20) )
	if ( _id = -1 ) then
		insert Departamento(RazonSocial,Cuenta) values (_razonSocial, _cuenta);
	else update Departamento set RazonSocial = _razonSocial, Cuenta = _cuenta, Estado = 'E', updated_at = current_timestamp() where id = _id;
    end if;
//

delimiter //
create procedure sp_GuardarSede( in _id int, in _razonSocial char(30), in _direccion char(50), in _idDepartamento int, in _idProvincia int, in _idDistrito int )
	if ( _id = -1 ) then
		insert Sede(RazonSocial, Direccion, idDepartamento, idProvincia, idDistrito) values ( _razonSocial, _direccion, _idDepartamento, _idProvincia, _idDistrito );
	else update Sede set RazonSocial = _razonSocial, Direccion = _direccion,
			idDepartamento = _idDepartamento, idProvincia = _idProvincia, idDistrito = _idDistrito,
			Estado = 'E', updated_at = current_timestamp() where id = _id;
    end if;
//

insert into centrocosto (Detalle) values ('Produccion'),('Ventas');
insert into sede(RazonSocial,Direccion,idDepartamento,idProvincia,idDistrito) values ('Sede princiapl','Av. Los Olivos',1,1,1);
insert into Departamento (RazonSocial,Cuenta) values ('taller','');

/*
call sp_getCargos()
call sp_GuardarCargo(-1,'Cajeros')
call sp_GuardarCentroCosto(-1,'Produccion')
call sp_getCentroCostos()
call sp_getDepartamentos()
call sp_getSedes()
call sp_getSede(2)

call sp_guardarSede(-1,'xx','qww',2,3,2)
call sp_getEmpleadoLogin('99887766','123456')
call sp_getEmpleado(1)

*/