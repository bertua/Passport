/**
 * Authors:  césar, lucas
 * Created: 24 de out. de 2024
 */

create table login_attempts(
    id_attempt int auto_increment primary key,
    id_user int,
    event timestamp,
    succesful boolean,
    foreign key (id_user) references users(id_user)
);