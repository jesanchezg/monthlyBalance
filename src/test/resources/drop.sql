--ALTER TABLE group_users DROP CONSTRAINT IF EXISTS CONSTRAINT_5D;
--DROP CONSTRAINT IF EXISTS CONSTRAINT_5D;
--DROP CONSTRAINT IF EXISTS CONSTRAINT_FB;
--DROP CONSTRAINT IF EXISTS CONSTRAINT_5;
--DROP CONSTRAINT IF EXISTS CONSTRAINT_6;
--DROP CONSTRAINT IF EXISTS CONSTRAINT_F;
-----------PostgresQL Syntax--------
drop sequence if exists group_user_seq ;
drop sequence  if exists utilisateur_seq;
drop sequence if exists payment_seq;

drop table IF EXISTS group_users;
--drop table IF EXISTS utilisateur;
drop table IF EXISTS payment;
-----------H2 Syntax------------------- avec 
--drop sequence group_user_seq if exists;
--drop sequence utilisateur_seq if exists;
--drop sequence payment_seq if exists;

--drop table group_users IF EXISTS;
--drop table utilisateur IF EXISTS;
--drop table payment IF EXISTS;
