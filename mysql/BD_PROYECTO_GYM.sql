create database GYM;
use GYM;

/*USUARIO*/
CREATE TABLE login(
id int primary key not null auto_increment,
username varchar(70),
password varchar(20)
);

/*TABLAS*/
create table cliente
(
id int not null auto_increment,
nombre_completo varchar(100) not null,
apellidos varchar(100) not null,
dni char(8) not null,
direccion varchar(300) not null,
ciudad varchar(20),
celular char(9) not null,
email varchar(70) not null,
contra varchar(20) not null,
primary key (id)
);

create table producto
(
id int not null auto_increment,
cliente int not null,
tipo_producto varchar(30) not null,
nombre_producto varchar(30) not null,
descripcion varchar(100) not null,
cantidad int not null,
precio_uni decimal(10,2) not null,
precio_total decimal(10,2) not null,
primary key (id)
);

create table entrenador
(
identrenador int not null auto_increment,
nombre_completo varchar(100) not null,
primary key (identrenador)
);

create table actividades
(
idactividades int auto_increment,
entrenador int,
tipo_actividad varchar(20) not null,
nombre_actividad varchar(20) not null,
descripcion varchar(50) not null,
primary key (idactividades)
);

create table inscripcion
(
idinscripcion int not null auto_increment,
cliente int,
actividad int,
costo decimal(10,2) not null,
primary key (idinscripcion)
);

/*LLAVES FORANEAS*/
alter table producto
add foreign key (cliente) references cliente (id) on update cascade;

alter table actividades
add foreign key (entrenador) references entrenador (identrenador) on update cascade;

alter table inscripcion
add foreign key (cliente) references cliente (id) on update cascade,
add foreign key (actividad) references actividades (idactividades) on update cascade;




/*CRUD*/

/*CLIENTE*/
DELIMITER //
create procedure view_cliente()
begin
select * from cliente;
end //
DELIMITER ;

DELIMITER //
create procedure add_cliente
(
in nombre_completo varchar(100),
in apellidos varchar(100),
in dni char(8),
in direccion varchar(300),
in ciudad varchar(20),
in celular char(9),
in email varchar(70),
in contra varchar(20)
)
begin
insert into cliente (nombre_completo, apellidos, dni, direccion, ciudad, celular, email, contra) values
(nombre_completo, apellidos, dni, direccion, ciudad, celular, email, contra);
end //
DELIMITER ;

DELIMITER //
create procedure update_cliente
(
in id int,
in nombre_completo varchar(100),
in apellidos varchar(100),
in dni char(8),
in direccion varchar(300),
in ciudad varchar(20),
in celular char(9),
in email varchar(70),
in contra varchar(20)
)
begin
update cliente set `nombre_completo` = nombre_completo, `apellidos` = apellidos, `dni` = dni, `direccion` = direccion,
`ciudad` = ciudad, `celular` = celular, `email` = email, `contra` = contra where `id` = id;
end //
DELIMITER ;

DELIMITER //
create procedure delete_cliente (id int)
begin
delete from cliente where id = id;
end //
DELIMITER ;

DELIMITER //
create procedure view_cliente_email (email varchar(70))
begin
select id, nombre_completo, apellidos, dni, direccion, ciudad, celular, email, contra from cliente
where `email` = email;
end //
DELIMITER ;

/*PRODUCTO*/
DELIMITER //
create procedure view_producto()
begin
select * from producto;
end //
DELIMITER ;

DELIMITER //
create procedure add_producto
(
in cliente int,
in tipo_producto varchar(30),
in nombre_producto varchar(30),
in descripcion varchar(100),
in cantidad int,
in precio_uni decimal(10,2),
in precio_total decimal(10,2)
)
begin
insert into producto (cliente, tipo_producto, nombre_producto, descripcion, cantidad, precio_uni, precio_total) values
(cliente, tipo_producto, nombre_producto, descripcion, cantidad, precio_uni, precio_total);
end //
DELIMITER ;

DELIMITER //
create procedure update_producto
(
in id int,
in cliente int,
in tipo_producto varchar(30),
in nombre_producto varchar(30),
in descripcion varchar(100),
in cantidad int,
in precio_uni decimal(10,2),
in precio_total decimal(10,2)
)
begin
update producto set `cliente` = cliente, `tipo_producto` = tipo_producto, `nombre_producto` = nombre_producto,
`descripcion` = descripcion, `cantidad` = cantidad, `precio_uni` = precio_uni, `precio_total` = precio_total
where `id` = id;
end //
DELIMITER ;

DELIMITER //
create procedure delete_producto (id int)
begin
delete from producto where id = id;
end //
DELIMITER ;

DELIMITER //
create procedure view_producto_id (id int)
begin
select id, cliente, tipo_producto, nombre_producto, descripcion, cantidad, precio_uni, precio_total from producto
where `id` = id;
end //
DELIMITER ;

/*ACTIVIDADES*/
DELIMITER //
create procedure view_actividades()
begin
select * from actividades;
end //
DELIMITER ;

DELIMITER //
create procedure add_actividades
(
in entrenador int,
in tipo_actividad varchar(20),
in nombre_actividad varchar(20),
in descripcion varchar(50)
)
begin
insert into actividades (entrenador, tipo_actividad, nombre_actividad, descripcion) values
(entrenador, tipo_actividad, nombre_actividad, descripcion);
end //
DELIMITER ;

DELIMITER //
create procedure update_actividades
(
in idactividades int,
in entrenador int,
in tipo_actividad varchar(20),
in nombre_actividad varchar(20),
in descripcion varchar(50)
)
begin
update actividades set `entrenador` = entrenador, `tipo_actividad` = tipo_actividad, `nombre_actividad` = nombre_actividad,
`descripcion` = descripcion
where `idactividades` = idactividades;
end //
DELIMITER ;

DELIMITER //
create procedure delete_actividades (id int)
begin
delete from actividades where idactividades = id;
end //
DELIMITER ;

DELIMITER //
create procedure view_actividades_id (idactividades int)
begin
select idactividades, entrenador, tipo_actividad, nombre_actividad, descripcion from actividades
where `idactividades` = idactividades;
end //
DELIMITER ;





