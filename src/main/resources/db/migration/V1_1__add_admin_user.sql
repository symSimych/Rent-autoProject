create extension if not exists pgcrypto;

insert into Users (first_name, last_name, email, phone_number, password) values
('Maksim', 'Alenevskyi', 'name@gmail.com', '0665891922', crypt('password', gen_salt('bf')));

insert into Roles (user_id, roles) values
('name@gmail.com', 'ROLE_ADMIN');

