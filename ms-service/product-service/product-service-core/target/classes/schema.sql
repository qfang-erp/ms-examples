drop table USER if EXISTS ;
CREATE TABLE USER (id bigint generated by DEFAULT as IDENTITY , username VARCHAR(40), name VARCHAR(20),
age int(3), balance decimal(10, 2), PRIMARY KEY (id));

drop table product if EXISTS ;
CREATE TABLE product (id bigint generated by DEFAULT as IDENTITY , name VARCHAR2(100), price int(5), PRIMARY KEY (id));


create sequence hibernate_sequence start with 100;