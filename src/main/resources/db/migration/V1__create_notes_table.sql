/**
 * Authors:  césar, lucas
 * Created: 24 de out. de 2024
 */

create table notes(
    id_note int auto_increment primary key,
    id_user int,
    id_category int,
    id_password int default null,
    title text not null, -- uses encryption
    document text not null, -- uses encryption
    create_date timestamp,
    edit_date timestamp,
    view_date timestamp,
    foreign key(id_user) references users(id_user),
    foreign key(id_category) references categories(id_category),
    foreign key(id_password) references passwords(id_password)
);
