use GYM_SPRING;

INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Marco Antonio", "Beltran", "98984510", "Delegados", "Lima", "901545198", "marco@gmail.com", "1234");
INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Gladys", "Trillo", "41155455", "Delegados", "Lima", "94554512", "gladys@gmail.com", "1234");
INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Laura", "Quiroz", "41155455", "Delegados", "Lima", "94554512", "laura@gmail.com", "1234");


INSERT INTO detalle_compra (idusuario, idproducto, cantidad, monto_total, fecha) VALUES
(3, 1, 1, 12.00, '18/08/2023 10:03:38 p. m.');

INSERT INTO producto_cliente (tipo_producto, nombre_producto, descripcion, precio_uni) VALUES
("AWA", "ASDS", "DASD", 12.00);

SELECT * FROM usuario;
SELECT * FROM producto;
SELECT * FROM detalle_compra;


DROP procedure IF EXISTS `sp_detalle_compra_idcli`;
DROP procedure IF EXISTS `gym_spring`.`sp_detalle_compra_idcli`;

/*DELIMITER $$*/
CREATE PROCEDURE sp_detalle_compra_idcli (idusu int)
SELECT iddetallecompra, idusuario, pro.tipo_producto, pro.nombre_producto, pro.descripcion, pro.precio_uni, cantidad, monto_total, fecha FROM detalle_compra dc
INNER JOIN producto pro ON dc.idproducto = pro.idproducto WHERE idusuario = idusu;
DELIMITER ;


CALL sp_detalle_compra_idcli (1);

update detalle_compra set idusuario=2 where iddetallecompra = 6
