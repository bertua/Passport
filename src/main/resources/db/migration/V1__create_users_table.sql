/**
 * Authors:  césar, lucas
 * Created: 6 de nov. de 2024
 */

create table users(
    id_user int auto_increment primary key,
    username text not null,
    nickname text not null,
    email text not null,
    password text not null, -- uses encryption
);