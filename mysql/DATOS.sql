use GYM_SPRING;

INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Marco Antonio", "Beltran", "98984510", "Delegados", "Lima", "901545198", "marco@gmail.com", "1234");
INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Gladys", "Trillo", "41155455", "Delegados", "Lima", "94554512", "gladys@gmail.com", "1234");
INSERT INTO usuario (nombre_completo, apellidos, dni, direccion, ciudad, celular, username, password) VALUES ("Laura", "Quiroz", "41155455", "Delegados", "Lima", "94554512", "laura@gmail.com", "1234");

INSERT INTO rol (nombre) values ("PARTICULAR");
INSERT INTO usuarios_roles (rol_id) values (1);

INSERT INTO detalle_compra (idusuario, idproducto, cantidad, monto_total, fecha) VALUES
(3, 1, 1, 12.00, '18/08/2023 10:03:38 p. m.');

INSERT INTO producto_cliente (tipo_producto, nombre_producto, descripcion, precio_uni) VALUES
("AWA", "ASDS", "DASD", 12.00);

SELECT * FROM usuario;
SELECT * FROM producto;
SELECT * FROM detalle_compra;
SELECT * FROM usuarios_roles;


DROP procedure IF EXISTS `sp_detalle_compra_idcli`;
DROP procedure IF EXISTS `gym_spring`.`sp_detalle_compra_idcli`;

/*DELIMITER $$*/
CREATE PROCEDURE sp_detalle_compra_idcli (idusu int)
SELECT iddetallecompra, idusuario, pro.tipo_producto, pro.nombre_producto, pro.descripcion, pro.precio_uni, cantidad, monto_total, fecha FROM detalle_compra dc
INNER JOIN producto pro ON dc.idproducto = pro.idproducto WHERE idusuario = idusu;
DELIMITER ;

CALL sp_detalle_compra_idcli (2);

/*DELIMITER $$*/
CREATE PROCEDURE sp_editar_compra_idcli (iddetalle int)
SELECT iddetallecompra, idusuario, pro.tipo_producto, pro.nombre_producto, pro.descripcion, pro.precio_uni, cantidad, monto_total, fecha FROM detalle_compra dc
INNER JOIN producto pro ON dc.idproducto = pro.idproducto WHERE iddetallecompra = iddetalle;
DELIMITER ;

CALL sp_editar_compra_idcli (26);

/*DELIMITER $$*/
CREATE PROCEDURE sp_monto_total_compra_idcli (idusu int)
SELECT iddetallecompra, idusuario FROM detalle_compra WHERE iddetallecompra = idusu;
DELIMITER ;

CALL sp_monto_total_compra_idcli (1);

/*DELIMITER $$*/
CREATE PROCEDURE sp_eliminar_compra (iddc int)
DELETE FROM detalle_compra WHERE iddetallecompra = iddc;
DELIMITER ;

CALL sp_eliminar_compra (5);

/*DELIMITER $$*/
CREATE PROCEDURE sp_update_compra (iddc int, cant int, montot decimal(10,2))
UPDATE detalle_compra SET cantidad = cant, monto_total = montot WHERE iddetallecompra = iddc;
DELIMITER ;

CALL sp_update_compra (25, 4, 1500.05);


SELECT * FROM usuario;
SELECT * FROM producto;
SELECT * FROM detalle_compra WHERE iddetallecompra = 3;
SELECT * FROM usuarios_roles;


/*DELIMITER prueba $$*/
CREATE PROCEDURE sp_editar_compra_idcli2 (iddetalle int)
SELECT * FROM detalle_compra WHERE iddetallecompra = iddetalle;
DELIMITER ;

CALL sp_editar_compra_idcli2 (25);

