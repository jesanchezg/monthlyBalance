INSERT INTO GROUP_USER (group_user_id, name) VALUES (nextval('group_user_seq'), 'casa');
INSERT INTO GROUP_USER VALUES (nextval('group_user_seq'), 'SuperMarket');
INSERT INTO GROUP_USER VALUES (nextval('group_user_seq'), 'Empresa');

INSERT INTO UTILISATEUR VALUES (nextval('utilisateur_seq'), 23, 'Jairo1978@hotmail.com', FALSE, 'Jairo Ernesto Sanchez Galvis', 'Masculin',(select group_user_id from group_user where name = 'casa'));
INSERT INTO UTILISATEUR VALUES (nextval('utilisateur_seq'), 32, 'limimariaco@gmail.com', FALSE, 'Lina Maturana', 'Femenin',(select group_user_id from group_user where name = 'SuperMarket'));
INSERT INTO UTILISATEUR VALUES (nextval('utilisateur_seq'), 34, 'culius@gmail.com', FALSE, 'Culiuscucu', 'Trans',(select group_user_id from group_user where name = 'casa'));

INSERT INTO PAYMENT VALUES (nextval('payment_seq'), TIMESTAMP '2020-02-06 00:00:00', 'SuperC', 12.0, (select utilisateur_id from utilisateur where full_name = 'Jairo Ernesto Sanchez Galvis'));
INSERT INTO PAYMENT VALUES (nextval('payment_seq'), TIMESTAMP '2020-02-24 00:00:00', 'Maxi', 123.0, (select utilisateur_id from utilisateur where full_name = 'Jairo Ernesto Sanchez Galvis'));
INSERT INTO PAYMENT VALUES (nextval('payment_seq'), TIMESTAMP '2020-02-20 00:00:00', 'Dollarama', 345.0, (select utilisateur_id from utilisateur where full_name = 'Choncho'));


--INSERT INTO GROUP_USER VALUES (nextval('group_user_seq'), 'casa');
--INSERT INTO GROUP_USER VALUES (nextval('group_user_seq'), 'SuperMarket');
--INSERT INTO GROUP_USER VALUES (nextval('group_user_seq'), 'Empresa');

--INSERT INTO UTILISATEUR VALUES (nextval('utilisateur_seq'), 23, 'Jairo1978@hotmail.com', FALSE, 'Jairo Ernesto Sanchez Galvis', 'Masculin',(select group_user_id from group_user where name = 'casa'));
--INSERT INTO UTILISATEUR VALUES (nextval('utilisateur_seq'), 32, 'limimariaco@gmail.com', FALSE, 'Lina Maturana', 'Femenin',(select group_user_id from group_user where name = 'SuperMarket'));
--INSERT INTO UTILISATEUR VALUES (nextval('utilisateur_seq'), 34, 'culius@gmail.com', FALSE, 'Culiuscucu', 'Trans',(select group_user_id from group_user where name = 'casa'));

--INSERT INTO PAYMENT VALUES (nextval('payment_seq'), TIMESTAMP '2020-02-06 00:00:00', 'SuperC', 12.0, select utilisateur_id from utilisateur where full_name = 'Jairo Ernesto Sanchez Galvis');
--INSERT INTO PAYMENT VALUES (nextval('payment_seq'), TIMESTAMP '2020-02-24 00:00:00', 'Maxi', 123.0, select utilisateur_id from utilisateur where full_name = 'Jairo Ernesto Sanchez Galvis');
--INSERT INTO PAYMENT VALUES (nextval('payment_seq'), TIMESTAMP '2020-02-20 00:00:00', 'Dollarama', 345.0, select utilisateur_id from utilisateur where full_name = 'Choncho');