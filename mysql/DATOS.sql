use GYM_SPRING;

INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Marco Antonio", "Beltran", "98984510", "Delegados", "Lima", "901545198", "marco@gmail.com", "1234");
INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Gladys", "Trillo", "41155455", "Delegados", "Lima", "94554512", "gladys@gmail.com", "1234");


INSERT INTO detalle_compra (idusuario, idproducto, cantidad, monto_total) VALUES
(1, 1, 1, 12.00);

INSERT INTO producto_cliente (tipo_producto, nombre_producto, descripcion, precio_uni) VALUES
("AWA", "ASDS", "DASD", 12.00);

SELECT * FROM usuario;
SELECT * FROM producto;
SELECT * FROM detalle_compra;


DROP procedure IF EXISTS `SP_DETALLE_VIEW`;
DROP procedure IF EXISTS `gym_spring`.`SP_DETALLE_VIEW`;

/*DELIMITER $$*/
CREATE PROCEDURE SP_DETALLE_VIEW (idusu int)
SELECT iddetallecompra, idusuario, pro.tipo_producto, pro.nombre_producto, pro.descripcion, pro.precio_uni, cantidad, monto_total, fecha FROM detalle_compra dc
INNER JOIN producto pro ON dc.idproducto = pro.idproducto WHERE idusuario = idusu;
DELIMITER ;


CALL SP_DETALLE_VIEW (2);

update detalle_compra set idusuario=2 where iddetallecompra = 6
