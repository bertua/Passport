/**
 * Authors:  césar, lucas
 * Created: 24 de out. de 2024
 */

create table passwords(
    id_password int auto_increment primary key, 
    id_user int,
    id_category int,
    service_name text not null,  -- uses encryption
    user_name text,  -- uses encryption
    password text not null, -- use sencryption
    create_date timestamp,
    edit_date timestamp,
    view_date timestamp,
    color text not null,
    foreign key(id_user) references users(id_user),
    foreign key(id_category) references categories(id_category)
);
