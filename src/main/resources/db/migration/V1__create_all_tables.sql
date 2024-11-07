/**
 * Author:  cesar, lucas
 * Created: 6 de nov. de 2024
 */

create table users(
    id_user INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL,
    nickname TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL -- uses encryption
);

create table login_attempts(
    id_attempt INTEGER PRIMARY KEY AUTOINCREMENT,
    id_user INTEGER,
    event TIMESTAMP,
    successful INTEGER,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

create table categories(
    id_category INTEGER PRIMARY KEY AUTOINCREMENT,
    id_user INTEGER,
    name TEXT NOT NULL,
    color TEXT NOT NULL,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

create table passwords(
    id_password INTEGER PRIMARY KEY AUTOINCREMENT,
    id_user INTEGER,
    id_category INTEGER,
    service_name TEXT NOT NULL, -- uses encryption
    user_name TEXT, -- uses encryption
    password TEXT NOT NULL, -- uses encryption
    create_date TIMESTAMP,
    edit_date TIMESTAMP,
    view_date TIMESTAMP,
    color TEXT NOT NULL,
    FOREIGN KEY(id_user) REFERENCES users(id_user),
    FOREIGN KEY(id_category) REFERENCES categories(id_category)
);

create table notes(
    id_note INTEGER PRIMARY KEY AUTOINCREMENT,
    id_user INTEGER,
    id_category INTEGER,
    id_password INTEGER DEFAULT NULL,
    title TEXT NOT NULL, -- uses encryption
    document TEXT NOT NULL, -- uses encryption
    create_date TIMESTAMP,
    edit_date TIMESTAMP,
    view_date TIMESTAMP,
    FOREIGN KEY(id_user) REFERENCES users(id_user),
    FOREIGN KEY(id_category) REFERENCES categories(id_category),
    FOREIGN KEY(id_password) REFERENCES passwords(id_password)
);

create table credit_cards(
    id_credit_card INTEGER PRIMARY KEY AUTOINCREMENT,
    id_user INTEGER,
    `number` TEXT NOT NULL, -- uses encryption
    cvv TEXT NOT NULL, -- uses encryption
    expiration_date TEXT NOT NULL,
    holder TEXT NOT NULL,
    create_date TIMESTAMP,
    view_date TIMESTAMP,
    FOREIGN KEY(id_user) REFERENCES users(id_user)
);