/**
 * Authors:  césar, lucas
 * Created: 24 de out. de 2024
 */

create table credit_cards(
    id_credit_card int auto_increment primary key,
    id_user int,
    `number` text not null, -- uses encryption
    cvv text not null, -- uses encryption
    expiration_date text not null,
    holder text not null,
    create_date timestamp,
    view_date timestamp,
    foreign key(id_user) references users(id_user)
)
