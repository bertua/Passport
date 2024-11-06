/**
 * Authors:  césar, lucas
 * Created: 24 de out. de 2024
 */

create table users(
    id_user int auto_increment primary key,
    username text not null,
    nickname text not null,
    email text not null,
    password text not null,
);

create table login_attempts(
    id_attempt int auto_increment primary key,
    id_user int,
    event timestamp,
    succesful boolean,
    foreign key (id_user) references users(id_user)
);

create table categories(
    id_category int auto_increment primary key,
    id_user int,
    name text not null,
    color text not null,
    foreign key (id_user) references users(id_user)
);

create table passwords(
    id_password int auto_increment primary key, 
    id_user int,
    id_category int,
    service_name text not null, 
    user_name text, 
    password text not null,
    create_date timestamp,
    edit_date timestamp,
    view_date timestamp,
    color text not null,
    foreign key(id_user) references users(id_user),
    foreign key(id_category) references categories(id_category)
);

create table notes(
    id_note int auto_increment primary key,
    id_user int,
    id_category int,
    id_password int default null,
    title text not null,
    document text not null,
    create_date timestamp,
    edit_date timestamp,
    view_date timestamp,
    foreign key(id_user) references users(id_user),
    foreign key(id_category) references categories(id_category),
    foreign key(id_password) references passwords(id_password)
);

create table credit_card(
    id_credit_card int auto_increment primary key,
    id_user int,
    `number` text not null,
    cvv text not null,
    expiration_date text not null,
    holder text not null,
    create_date timestamp,
    view_date timestamp,
    foreign key(id_user) references users(id_user)
)
