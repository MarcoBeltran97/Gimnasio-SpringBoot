create database GYM_SPRING;
use GYM_SPRING;

/*TABLAS*/
create table usuario
(
idusuario int primary key auto_increment,
nombre_completo varchar(100) not null,
apellidos varchar(100) not null,
dni char(8) not null,
direccion varchar(300) not null,
ciudad varchar(20),
celular char(9) not null,
username varchar(70)  not null unique,
password varchar(20) not null
);

create table producto
(
idproducto int not null auto_increment,
tipo_producto varchar(30) null,
imagen_producto mediumblob,
nombre_producto varchar(30) null,
descripcion varchar(100) null,
cantidad int not null,
precio_uni decimal(10,2) null,
primary key (idproducto)
);

create table entrenador
(
identrenador int not null auto_increment,
nombre_completo varchar(100) not null,
estado int default 1,
primary key (identrenador)
);

create table actividades
(
idactividades int primary key auto_increment,
entrenadorid int,
tipo_actividad varchar(20) not null,
nombre_actividad varchar(20) not null,
descripcion varchar(50) not null,
costo decimal ,
estado int default 1,
foreign key (entrenadorid) references entrenador(identrenador)
);

create table inscripcion
(
idinscripcion int primary key auto_increment,
actividad int,
idusuario int,
fecha_inicio date,
estado int default 1,
foreign key (idusuario) references usuario(idusuario),
foreign key (actividad) references actividades(idactividades)
);

create table ventas
(
idventa int primary key auto_increment,
fechaVenta date,
idusuario int  ,
monto_total decimal,
descuento decimal,
estado int default 1,
foreign key (idusuario) references usuario(idusuario)

);

create table detalle_venta
(
item int not null,
idventa int ,
idactividad int null ,
idproducto int null,
cantidad int,
estado int default 1,
foreign key (idventa) references ventas(idventa),
foreign key (idactividad) references actividades(idactividades),
foreign key (idproducto) references producto(idproducto)

);

create table plan_alimenticio
(
idplan int primary key auto_increment,
nombre_plan varchar(20) not null,
desayuno varchar(200) not null,
almuerzo  varchar(200) not null,
cena varchar(200) not null
);

create table progreso
(
idprogreso int primary key auto_increment,
idinscripcion int unique ,
id_plan_alimento int,
peso_inicial decimal,
foreign key (idinscripcion) references inscripcion(idinscripcion),
foreign key (id_plan_alimento) references plan_alimenticio(idplan)

);

create table detalle_progreso
(
iddetalle int primary key auto_increment,
idprogreso int,
fecha date,
peso decimal,
foreign key (idprogreso) references progreso(idprogreso)
);

