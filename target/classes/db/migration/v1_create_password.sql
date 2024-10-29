/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  flarom
 * Created: 24 de out. de 2024
 */
create table passwords(
    id_password int auto_increment primary key, 
    serviceName text not null, 
    username text, 
    password text not null, 
    color text not null
);
