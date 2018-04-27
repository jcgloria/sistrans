insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (1, 'Wenda', 'wwyon0@so-net.ne.jp', 'estudiante'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (2, 'Gerhardine', 'gwilcocks1@eventbrite.com', 'estudiante'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (3, 'Sasha', 'sisaak2@statcounter.com', 'estudiante'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (4, 'Addi', 'amcphaden3@craigslist.org', 'estudiante'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (5, 'Raf', 'rkuhlmey4@abc.net.au', 'estudiante');
 insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (6, 'Britte', 'bfarnsworth5@dell.com', 'estudiante'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (7, 'Nadya', 'nrosendale6@seattletimes.com', 'estudiante'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (8, 'Martynne', 'mgiovannardi7@github.io', 'estudiante');
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION)
values (9, 'Carlina', 'cethington8@hhs.gov', 'estudiante'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (10, 'Lotte', 'lmarini9@gizmodo.com', 'estudiante');
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (11, 'Felizio', 'flikely0@desdev.cn', 'profesor'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (12, 'Daphne', 'dblankhorn1@kickstarter.com', 'padre'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (13, 'Timothy', 'tbalchen2@yahoo.co.jp', 'padre'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (14, 'Marguerite', 'mmontel3@usatoday.com', 'egresado'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (15, 'Melba', 'mbrett4@wufoo.com', 'padre'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (16, 'Doralin', 'dmccreery5@typepad.com', 'padre'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (17, 'Addi', 'agonoude6@epa.gov', 'profesor'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (18, 'Sollie', 'sherety7@twitter.com', 'egresado'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (19, 'Annadiana', 'abraam8@51.la', 'egresado'); 
insert into PERSONAS (ID, NOMBRE, CORREO, AFILIACION) 
values (20, 'Malorie', 'mley9@europa.eu', 'profesor');

insert into OPERADORES_PERSONANATURAL (ID, COSTO_SERVICIOS, PERSONA) 
values (50, 200000, 12); 
insert into OPERADORES_PERSONANATURAL (ID, COSTO_SERVICIOS, PERSONA) 
values (51, 210000, 11); 
insert into OPERADORES_PERSONANATURAL (ID, COSTO_SERVICIOS, PERSONA) 
values (52, 220000, 11);

insert into OFERTAS_PERSONANATURAL (ID, PRECIO_MENSUAL, PRECIO_SEMESTRE, PERSONA_NATURAL) 
values (60, 200000, 1200000, 50); 
insert into OFERTAS_PERSONANATURAL (ID, PRECIO_MENSUAL, PRECIO_SEMESTRE, PERSONA_NATURAL) 
values (61, 210000, 1260000, 51); 
insert into OFERTAS_PERSONANATURAL (ID, PRECIO_MENSUAL, PRECIO_SEMESTRE, PERSONA_NATURAL) 
values (62, 220000, 1320000, 52);

insert into OFERTAS_APARTAMENTO (ID, COSTO, SERVICIOS, INTERNET_TV, ADMINISTRACION, PERSONA) 
values (70, 250000, null,' 1', '0', 14); 
insert into OFERTAS_APARTAMENTO (ID, COSTO, SERVICIOS, INTERNET_TV, ADMINISTRACION, PERSONA) 
values (71, 270000, null, '1', '0', 11); 
insert into OFERTAS_APARTAMENTO (ID, COSTO, SERVICIOS, INTERNET_TV, ADMINISTRACION, PERSONA) 
values (72, 280000, null, '1', '1', 14);

insert into OPERADORES_HOTEL (ID, NOMBRE, DIRECCION)
values (90, 'Hilton', '65999 Acker Plaza'); 
insert into OPERADORES_HOTEL (ID, NOMBRE, DIRECCION) 
values (91, 'Bogota Plaza', '27 Manufacturers Junction'); 
insert into OPERADORES_HOTEL (ID, NOMBRE, DIRECCION) 
values (92, 'Morros', '6 Continental Crossing');

insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (820, 'estandar', 400000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (821, 'semisuite', 600000, 90,'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (822, 'suite', 900000, 90, 'habilitado');
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (800, 'estandar', 750000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (801, 'estandar', 750000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (802, 'estandar', 900000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (803, 'estandar', 850000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (804, 'estandar', 800000, 91, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (805, 'estandar', 800000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (806, 'estandar', 750000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (807, 'estandar', 900000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (808, 'estandar', 750000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (809, 'estandar', 750000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (810, 'estandar', 850000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (811, 'estandar', 900000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (812, 'estandar', 750000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (813, 'estandar', 900000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (814, 'estandar', 800000, 91, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (815, 'estandar', 900000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (816, 'estandar', 800000, 90, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (817, 'estandar', 800000, 91, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (818, 'estandar', 850000, 92, 'habilitado'); 
insert into OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) 
values (819, 'estandar', 900000, 90, 'habilitado');

insert into OPERADORES_HOSTAL (ID, NOMBRE, DIRECCION, HORA_APERTURA, HORA_CIERRE) 
values (110, 'hostal1', '80 Eagan Terrace', '6:00', '23:30'); 
insert into OPERADORES_HOSTAL (ID, NOMBRE, DIRECCION, HORA_APERTURA, HORA_CIERRE) 
values (111, 'hostal2', '1 Ramsey Street', '6:00', '23:30'); 
insert into OPERADORES_HOSTAL (ID, NOMBRE, DIRECCION, HORA_APERTURA, HORA_CIERRE) 
values (112, 'hostal3', '40 Center Circle', '6:00', '23:30');

insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (120, 70000, 110, 'habilitado'); 
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (121, 100000, 111,'habilitado');  
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (122, 90000, 112,'habilitado');
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (123, 90000, 111, 'habilitado'); 
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (124, 90000, 110, 'habilitado'); 
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (125, 90000, 112, 'habilitado'); 
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (126, 90000, 111, 'habilitado'); 
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (127, 100000, 112, 'habilitado'); 
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (128, 90000, 110, 'habilitado'); 
insert into OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) 
values (129, 100000, 112, 'habilitado'); 

insert into OPERADORES_VIVIENDA (ID, NOMBRE, UBICACION) 
values (130, 'Rycca Checklin', '19058 Monica Hill'); 
insert into OPERADORES_VIVIENDA (ID, NOMBRE, UBICACION) 
values (131, 'Diego Belchamp', '7 International Place'); 
insert into OPERADORES_VIVIENDA (ID, NOMBRE, UBICACION) 
values (132, 'Neilla Simonin', '0 Mendota Point');

insert into OFERTAS_VIVIENDA (ID, COSTO_NOCHE, COSTO_MENSUAL, COSTO_SEMESTRE, MENAJE, CAPACIDAD, VIVIENDA) 
values (140, 20000, 600000, 2000000, null, 1, 130); 
insert into OFERTAS_VIVIENDA (ID, COSTO_NOCHE, COSTO_MENSUAL, COSTO_SEMESTRE, MENAJE, CAPACIDAD, VIVIENDA) 
values (141, 25000, 700000, 2500000, null, 3, 131); 
insert into OFERTAS_VIVIENDA (ID, COSTO_NOCHE, COSTO_MENSUAL, COSTO_SEMESTRE, MENAJE, CAPACIDAD, VIVIENDA) 
values (142, 30000, 800000, 300000, null, 2, 132);

insert into EVENTOS (ID, NOMBRE, FECHA_INICIO, FECHA_FINAL) 
values (150, 'Evento1', '26/04/2018', '26/05/2018'); 
insert into EVENTOS (ID, NOMBRE, FECHA_INICIO, FECHA_FINAL) 
values (151, 'Evento2', '26/04/2018', '26/05/2018'); 
insert into EVENTOS (ID, NOMBRE, FECHA_INICIO, FECHA_FINAL) 
values (152, 'Evento3', '26/04/2018', '26/05/2018');

insert into OFERTAS_EVENTO (ID, PRECIO, NUM_HABITACIONES, DIRECCION, MENAJE, EVENTO) 
values (160, 3000000, 10, '49280 Meadow Ridge Crossing', 'menaje', 150); 
insert into OFERTAS_EVENTO (ID, PRECIO, NUM_HABITACIONES, DIRECCION, MENAJE, EVENTO) 
values (161, 3500000, 15, '85077 Twin Pines Center', 'menaje', 151); 
insert into OFERTAS_EVENTO (ID, PRECIO, NUM_HABITACIONES, DIRECCION, MENAJE, EVENTO) 
values (162, 4000000, 20, '4 5th Pass', 'menaje', 152);

insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (500, null, 820, 'Baño propio'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (501, null, 140, 'jacuzzi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (502, null, 70, 'empleada');
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (503, null, 800, 'WiFi'); insert into 
SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (504, null, 801, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (505, null, 802, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (506, null, 803, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (507, null, 804, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (508, null, 805, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (509, null, 806, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (510, null, 807, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (511, null, 808, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (512, null, 809, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (513, null, 810, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (514, null, 811, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (515, null, 812, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (516, null, 813, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (517, null, 814, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (518, null, 815, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (519, null, 816, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (520, null, 817, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (521, null, 818, 'WiFi'); 
insert into SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) 
values (522, null, 819, 'WiFi');

insert into GUSTAN(PERSONA, SERVICIO) 
values (5, 'Baño propio'); 
insert into GUSTAN(PERSONA, SERVICIO) 
values (7, 'jacuzzi'); 
insert into GUSTAN(PERSONA, SERVICIO) 
values (6, 'empleada');

insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) 
values (1000, 'apartamento', 70, '24/04/2018', '26/04/2018', '26/05/2018', null, 150000, 'activa', 1); 
insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) 
values (1001, 'persona natural', 60, '24/04/2018', '26/04/2018', '26/05/2018', null, 250000, 'activa', 2); 
insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) 
values (1002, 'vivienda', 140, '24/04/2018', '26/04/2018', '26/05/2018', null, 10000, 'activa', 3); 
insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) 
values (1003, 'hotel', 800, '24/04/2018', '26/04/2018', '26/05/2018', null, 300000, 'activa', 4); 
insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) 
values (1004, 'evento', 160, '24/04/2018', '26/04/2018', '26/05/2018', null, 350000, 'activa', 5);
insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1005, 'hotel', 800, '24/04/2018', '28/04/2018', '07/05/2018', null, 4500000, 'activa', 1); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1006, 'hotel', 801, '24/04/2018', '01/05/2018', '24/05/2018', null, 5000000, 'activa', 7); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1007, 'hotel', 802, '24/04/2018', '30/04/2018', '29/05/2018', null, 4500000, 'activa', 9); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1008, 'hotel', 803, '24/04/2018', '28/04/2018', '07/05/2018', null, 3000000, 'activa', 2); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1009, 'hotel', 804, '24/04/2018', '27/04/2018', '29/05/2018', null, 5000000, 'activa', 9); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1010, 'hotel', 805, '24/04/2018', '29/04/2018', '30/05/2018', null, 5000000, 'activa', 2); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1011, 'hotel', 806, '24/04/2018', '30/04/2018', '24/05/2018', null, 4000000, 'activa', 10); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1012, 'hotel', 807, '24/04/2018', '29/04/2018', '08/05/2018', null, 4000000, 'activa', 2); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1013, 'hotel', 808, '24/04/2018', '30/04/2018', '30/05/2018', null, 5000000, 'activa', 8); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1014, 'hotel', 809, '24/04/2018', '27/04/2018', '29/05/2018', null, 3000000, 'activa', 2); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1015, 'hotel', 810, '24/04/2018', '29/04/2018', '29/05/2018', null, 2500000, 'activa', 1); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1016, 'hotel', 811, '24/04/2018', '27/04/2018', '24/05/2018', null, 4000000, 'activa', 1); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1017, 'hotel', 812, '24/04/2018', '28/04/2018', '07/05/2018', null, 3500000, 'activa', 3); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1018, 'hotel', 813, '24/04/2018', '30/04/2018', '07/05/2018', null, 3000000, 'activa', 10); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1019, 'hotel', 814, '24/04/2018', '26/04/2018', '24/05/2018', null, 5000000, 'activa', 8); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1020, 'hotel', 815, '24/04/2018', '01/05/2018', '08/05/2018', null, 4000000, 'activa', 10); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1021, 'hostal', 120, '24/04/2018', '29/04/2018', '08/05/2018', null, 1000000, 'activa', 2); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1022, 'hostal', 121, '24/04/2018', '28/04/2018', '29/05/2018', null, 1500000, 'activa', 3); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1023, 'hostal', 122, '24/04/2018', '29/04/2018', '07/05/2018', null, 950000, 'activa', 9); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1024, 'hostal', 123, '24/04/2018', '01/05/2018', '30/05/2018', null, 1500000, 'activa', 10); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1025, 'hostal', 124, '24/04/2018', '27/04/2018', '30/05/2018', null, 2000000, 'activa', 6); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1026, 'hostal', 125, '24/04/2018', '29/04/2018', '30/05/2018', null, 980000, 'activa', 4); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1027, 'hostal', 126, '24/04/2018', '29/04/2018', '08/05/2018', null, 1050000, 'activa', 3); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1028, 'hostal', 127, '24/04/2018', '26/04/2018', '08/05/2018', null, 1500000, 'activa', 4); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1029, 'hostal', 128, '24/04/2018', '26/04/2018', '24/05/2018', null, 950000, 'activa', 8); insert into RESERVAS (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) values (1030, 'hostal', 129, '24/04/2018', '27/04/2018', '24/05/2018', null, 2000000, 'activa', 6);
