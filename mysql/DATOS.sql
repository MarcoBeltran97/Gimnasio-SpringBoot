use GYM_SPRING;

INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Marco Antonio", "Beltran", "98984510", "Delegados", "Lima", "901545198", "marco@gmail.com", "1234");
INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Gladys", "Trillo", "41155455", "Delegados", "Lima", "94554512", "gladys@gmail.com", "1234");

<<<<<<< HEAD
INSERT INTO detalle_compra (idusuario, idproducto, cantidad, monto_total) VALUES
(1, 1, 1, 12.00);
=======
INSERT INTO producto_cliente (tipo_producto, nombre_producto, descripcion, precio_uni) VALUES
("AWA", "ASDS", "DASD", 12.00);
>>>>>>> a233689389d1144e4f7249b103394cf42e7c7698
SELECT * FROM usuario;
SELECT * FROM producto;
SELECT * FROM detalle_compra;
