create extension if not exists pgcrypto;

insert into Users (first_name, last_name, email, phone_number, password, user_role) values
('Maksim', 'Alenevskyi', 'name@gmail.com', '0665891922', crypt('password', gen_salt('bf')), 'ROLE_USER');