create extension if not exists "uuid-ossp";

create table if not exists Users (
    id uuid default uuid_generate_v4 (),
    first_name varchar not null,
    last_name varchar not null,
    email varchar,
    phone varchar,
    primary key (id),
    unique (email)
);

insert into Users (first_name, last_name, email, phone) values
('Ihor', 'Bibichkov', 'work.bibi4kov@gmail.com', '+380 (784) 454 - 7747'),
('Ivan', 'Susanin', 'ivan.susanin@gmail.com', '+380 (555) 483 - 4746'),
('Abdula', 'Zade', 'abdula.zade@gmail.com', '+380 (088) 475 - 4767'),
('Arinstotel', 'Philosophy', 'aristotel.philosophy@gmail.com', '+380 (072)445 - 4747'),
('Archimed', 'Physics', 'archimed.physics@gmail.com', '+380 (048) 446 - 4777');

create table if not exists Roles (
    id uuid default uuid_generate_v4 (),
    role_name varchar not null,
    primary key (id),
    unique (role_name)
);

insert into Roles (role_name) values
('USER'),
('ADMIN');

create table if not exists Users_Roles (
    users_id uuid not null,
    roles_id uuid not null,
    constraint fk_roles foreign key (roles_id)
        references Roles (id)
        on update no action
        on delete no action,
    constraint fk_users foreign key (users_id)
        references Users (id)
        on update no action
        on delete no action
);



