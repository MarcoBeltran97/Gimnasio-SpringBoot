use GYM;

CALL add_cliente("Marco","Beltran","99887751","Los Delegados","Lima","987987987","marco@gmail.com","1234");
CALL add_producto(1,"Colágeno","Pro BCAA 400gr","Sabor: Fruit Punch",1,95.00,95.00);

insert into producto (cliente, tipo_producto, nombre_producto, descripcion, cantidad, precio_uni, precio_total) values
(1,"Colágeno","Pro BCAA 400gr","Sabor: Fruit Punch",1,95.00,95.00);


INSERT INTO login (username, password) VALUES ("MARCO", "1234");