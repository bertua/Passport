/**
 * Authors:  césar, lucas
 * Created: 24 de out. de 2024
 */

create table categories(
    id_category int auto_increment primary key,
    id_user int,
    name text not null,
    color text not null,
    foreign key (id_user) references users(id_user)
);
