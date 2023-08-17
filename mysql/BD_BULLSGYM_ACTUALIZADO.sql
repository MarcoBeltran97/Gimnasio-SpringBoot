create database GYM_SPRING;
use GYM_SPRING;

/*TABLAS*/
create table usuario
(
<<<<<<< HEAD
idusuario int not null auto_increment,
=======
idusuario int primary key auto_increment,
>>>>>>> a233689389d1144e4f7249b103394cf42e7c7698
nombre_completo varchar(100) not null,
apellidos varchar(100) not null,
dni char(8) not null,
direccion varchar(300) not null,
ciudad varchar(20),
celular char(9) not null,
username varchar(70)  not null unique,
<<<<<<< HEAD
password varchar(20) not null,
primary key (idusuario)
=======
password varchar(20) not null
>>>>>>> a233689389d1144e4f7249b103394cf42e7c7698
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

<<<<<<< HEAD
create table detalle_compra
(
iddetallcompra int primary key not null auto_increment,
idusuario int null,
idproducto int null,
cantidad int not null,
monto_total decimal,
fecha varchar(100),
foreign key (idusuario) references usuario(idusuario),
foreign key (idproducto) references producto(idproducto)
=======

create table producto_cliente
(
idproductocliente int not null auto_increment,
tipo_producto varchar(30) null,
nombre_producto varchar(30) null,
descripcion varchar(100) null,
precio_uni decimal(10,2) null,
primary key (idproductocliente)
);

create table detalle_venta
(
iddetalleventa int primary key not null auto_increment,
usuario varchar(70) references usuario(username),
idproductocliente int null,
cantidad int not null,
monto_total decimal,
fechaVenta date,
foreign key (idproductocliente) references producto_cliente(idproductocliente)
>>>>>>> a233689389d1144e4f7249b103394cf42e7c7698
);
