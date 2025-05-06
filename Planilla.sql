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

create table Departamentos (
	iddepartamento int auto_increment primary key,
    departamento char(50) unique
);
create table Provincia(
	idProvincia int auto_increment primary key,
    idDepartamento int references Departamentos,
    provincia char(30) unique
);
create table Distrito(
	idDistrito int auto_increment primary key,
    idProvincia int references Provincia,
    distrito char(30) unique
);
select * from Distrito;
/* ----- Insert ----- */
insert Departamentos(departamento)  values 
	('AMAZONAS'),('ANCASH'),('APURIMAC'),('AREQUIPA'),('AYACUCHO'),('CAJAMARCA'),('CALLAO'),('CUSCO');
insert Provincia(idDepartamento,provincia) values
 (1,'BAGUA'),(1,'BONGARA'),(1,'CHACHAPOYAS'),(1,'CONDORCANQUI'),(1,'LUYA'),(1,'RODRIGUEZ DE MENDOZA'),(1,'UTCUBAMBA');
insert Distrito(idProvincia,distrito) values
	(1,'ARAMANGO'),(1,'BAGUA'),(1,'COPALLIN'),(1,'EL PARCO'),(1,'IMAZA'),(1,'LA PECA');
-- ANCASH
insert Provincia(idDepartamento,provincia) values 
(2,'AIJA'),(2,'ANTONIO RAYMONDI'),(2,'ASUNCION'),(2,'BOLOGNESI'),(2,'CARHUAZ'),(2,'CARLOS FERMIN FITZCARRALD'),(2,'CASMA'),(2,'CORONGO'),(2,'HUARAZ'),(2,'HUARI'),(2,'HUARMEY'),(2,'HUAYLAS'),(2,'MARISCAL LUZURIAGA'),(2,'OCROS'),(2,'PALLASCA'),(2,'POMOBAMBA'),(2,'RECUAY'),(2,'SANTA'),(2,'SIHUAS'),(2,'YUNGAY');
insert Distrito(idProvincia,distrito) values
	(8,'AIJA'),(8,'CORIS'),(8,'HUACLLAN'),(8,'LA MERCED'),(8,'SUCCHA');
-- APURIMAC
insert Provincia(idDepartamento,provincia) values (3,'ABANCAY'),(3,'ANDAHUAYLAS'),(3,'ANTABAMBA'),(3,'AYMARAES'),(3,'CHINCHEROS'),(3,'COTABAMBAS'),(3,'GRAU');
insert Distrito(idProvincia,distrito) values
	(28,'ABANCAY'),(28,'CHACOCHE'),(28,'CIRCA'),(28,'CURAHUASI'),(28,'HUANIPACA');
-- AREQUIPA
insert Provincia(idDepartamento,provincia) values (4,'AREQUIPA'),(4,'CAMANA'),(4,'CARAVELI'),(4,'CASTILLA'),(4,'CAYLLOMA'),(4,'CONDESUYOS'),(4,'ISLAY'),(4,'LA UNION');
insert Distrito(idProvincia,distrito) values
	(35,'ALTO SELVA ALEGRE'),(35,'AREQUIPA'),(35,'CAYMA'),(35,'CERRO COLORADO'),(35,'CHARACATO');
-- AYACUCHO
insert Provincia(idDepartamento,provincia) values (5,'CANGALLO'),(5,'HUAMANGA'),(5,'HUANCA SANCOS'),(5,'HUANTA'),(5,'LA MAR'),(5,'LUCANAS'),(5,'PARINACOCHAS'),(5,'PAUCAR DEL SARA SARA'),(5,'SUCRE'),(5,'VICTOR FAJARDO'),(5,'VILCAS HUAMAN');
insert Distrito(idProvincia,distrito) values
    (43,'CANGALLO'),(43,'CHUSCHI'),(43,'LOS MOROCHUCOS'),(43,'MARIA PARADO DE BELLIDO'),(43,'PARAS');    
-- CAJAMARCA
insert Provincia(idDepartamento,provincia) values (6 ,'CAJABAMBA'),(6 ,'CAJAMARCA'),(6 ,'CELENDIN'),(6 ,'CHOTA'),(6 ,'CONTUMAZA'),(6 ,'CUTERVO'),(6 ,'HUALGAYOC'),(6 ,'JAEN'),(6 ,'SAN IGNACIO'),(6 ,'SAN MARCOS'),(6 ,'SAN MIGUEL'),(6 ,'SAN PABLO'),(6 ,'SANTA CRUZ');
insert Distrito(idProvincia,distrito) values
	(54,'CACHACHI'),(54,'CAJABAMBA'),(54,'CONDEBAMBA'),(54,'SITACOCHA'),
	(55,'ASUNCION');
-- CALLAO
insert Provincia(idDepartamento,provincia) values (7,'CALLAO');
insert Distrito(idProvincia,distrito) values
	(67,'BELLAVISTA'),(67,'CALLAO'),(67,'CARMEN DE LA LEGUA-REYNOSO'),(67,'LA PERLA'),(67,'LA PUNTA');
-- CUSCO
insert Provincia(idDepartamento,provincia) values (8,'ACOMAYO'),(8,'ANTA'),(8,'CALCA'),(8,'CANAS'),(8,'CANCHIS'),(8,'CHUMBIVILCAS'),(8,'CUSCO'),(8,'ESPINAR'),(8,'LA CONVENCION'),(8,'PARURO'),(8,'PAUCARTAMBO'),(8,'QUISPICANCHI'),(8,'URUBAMBA');
insert Distrito(idProvincia,distrito) values
	(68,'ACOMAYO'),(68,'ACOPIA'),(68,'ACOS'),(68,'MOSOC LLACTA'),(68,'POMACANCHI');
    
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
create procedure sp_getDepartamentoss(in _inicio int, in _fin int)
   select * from Departamentos where iddepartamento between _inicio and _fin;
   //
create procedure sp_getProvincias(in _idDepartamento int)
  select idProvincia, provincia from Provincia where idDepartamento = _idDepartamento;
  
create procedure sp_getDistritos(in _idProvincia int)
  select idDistrito, distrito from Distrito where idProvincia = _idProvincia;  
   ----------------------------------------------------------------------------------------------

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
insert into Departamento (RazonSocial,Cuenta) values ('Taller','')
/*

call sp_getCargos()
call sp_getCentroCostos()
call sp_getDepartamentos()
call sp_getSedes()
call sp_getSede(1)
call sp_GuardarCargo(-1,'Cajeros')
call sp_GuardarCentroCosto(-1,'Produccion')
call sp_GuardarDepartamento(1,'Taller','')

call sp_getDepartamentoss(1,8)
call sp_getProvincias(1)
call sp_getDistritos(1)


call sp_GuardarSede(-1,'xx','qww',2,3,2)
call sp_getEmpleadoLogin('99887766','123456')
call sp_getEmpleado(1)

*/