create sequence hibernate_sequence start 1 increment 1;
create table product (id int8 not null, created_at timestamp, description varchar(255), name varchar(255), price numeric(19, 2), updated_at timestamp, primary key (id));
create sequence hibernate_sequence start 1 increment 1;
create table product (id int8 not null, created_at timestamp, description varchar(255), name varchar(255), price numeric(19, 2), updated_at timestamp, primary key (id));
