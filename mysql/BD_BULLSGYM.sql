create database GYM_SPRING;
use GYM_SPRING;

/*TABLAS*/
create table usuario
(
idusuario int not null auto_increment,
nombre_completo varchar(100) not null,
apellidos varchar(100) not null,
dni char(8) not null,
direccion varchar(300) not null,
ciudad varchar(20),
celular char(9) not null,
username varchar(70)  not null unique,
password varchar(200) not null,
primary key (idusuario)
);

create table rol
(
idrol int not null auto_increment,
nombre varchar(50),
primary key (idrol)
);

create table usuarios_roles
(
idusuariorol int not null auto_increment,
rol_id int,
primary key (idusuariorol),
foreign key (rol_id) references rol (idrol)
);

create table producto
(
idproducto int not null auto_increment,
tipo_producto varchar(30) null,
imagen_producto mediumblob,
nombre_producto varchar(30) null,
descripcion varchar(100) null,
precio_uni decimal(10,2) null,
primary key (idproducto)
);

create table detalle_compra
(
iddetallecompra int not null auto_increment,
idusuario int null,
idproducto int null,
cantidad int not null,
monto_total decimal(10,2) null,
fecha varchar(100),
primary key (iddetallecompra),
foreign key (idusuario) references usuario(idusuario),
foreign key (idproducto) references producto(idproducto)
);