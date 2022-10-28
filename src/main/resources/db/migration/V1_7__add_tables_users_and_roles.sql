create table if not exists Users (
    first_name varchar not null,
    last_name varchar not null,
    email varchar not null,
    phone_number varchar not null,
    password varchar not null,
    user_role varchar not null,
    primary key (email)
);

