create extension if not exists "uuid-ossp";

create table if not exists Cars (
    id uuid default uuid_generate_v4 (),
    brand varchar,
    model varchar,
    body_type varchar,
    year varchar,
    transmission varchar,
    fuel_type varchar,
    engine_volume float8,
    horse_power int4,
    tank_volume int4,
    fuel_consumption float8,
    bail float8,
    price float8,
    available boolean,
    preview_image_id uuid,
    primary key (id)
);

create table if not exists Images (
    id uuid default uuid_generate_v4 (),
    name varchar,
    file_name varchar,
    size int8,
    content_type varchar,
    bytes oid,
    car_id uuid,
    primary key (id),
    constraint car_fk foreign key (car_id)
        references Cars (id) match simple
        on update no action
        on delete no action
);

create table if not exists Users (
    first_name varchar not null,
    last_name varchar not null,
    email varchar not null,
    phone_number varchar not null,
    password varchar not null,
    primary key (email)
);

create table if not exists Roles (
    id uuid default uuid_generate_v4 (),
    user_id varchar,
    roles varchar,
    primary key(id),
     constraint user_fk foreign key (user_id)
        references Users (email) match simple
        on update no action
        on delete no action
);

create table if not exists Orders (
    id uuid default uuid_generate_v4 (),
    place_of_filing varchar,
    place_of_return varchar,
    filing_time timestamp,
    return_time timestamp,
    confirmed boolean,
    user_id varchar,
    car_id uuid,
    primary key (id),
    constraint car_fk foreign key (car_id)
        references Cars (id) match simple
        on update no action
        on delete no action,
    constraint user_fk foreign key (user_id)
        references Users (email) match simple
        on update no action
        on delete no action
);