delete from Roles where user_id = 'm@gmail.com';
delete from Roles where user_id = 'a@gmail.com';

delete from Orders where user_id = 'm@gmail.com';

delete from Users where email = 'm@gmail.com';
delete from Users where email = 'a@gmail.com';

create table if not exists Users (
    first_name varchar not null,
    last_name varchar not null,
    email varchar not null,
    phone_number varchar not null,
    password varchar not null,
    primary key (email)
);

insert into Users (first_name, last_name, email, phone_number, password) values
('Maksim', 'Alenevskyi', 'm@gmail.com', '05651', crypt('password', gen_salt('bf')));

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

insert into Roles (user_id, roles) values
('m@gmail.com', 'ROLE_MANAGER'),
('m@gmail.com', 'ROLE_ADMIN');