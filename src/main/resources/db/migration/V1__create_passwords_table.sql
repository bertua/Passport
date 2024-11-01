/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Authors:  césar, lucas
 * Created: 24 de out. de 2024
 */
create table categories(
    id_category int auto_increment primary key,
    name text not null,
    color text not null
);

create table passwords(
    id_password int auto_increment primary key, 
    service_name text not null, 
    username text, 
    password text not null,
    create_date timestamp,
    edit_date timestamp,
    view_date timestamp,
    id_category int,
    color text not null,

    foreign key(id_category) references categories(id_category)
);