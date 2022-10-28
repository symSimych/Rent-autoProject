insert into Users (first_name, last_name, email, phone_number, password, user_role) values
('Ihor', 'Bibichkov', 'ihor@gmail.com', '0504866819', crypt('ihor', gen_salt('bf')), 'ROLE_ADMIN');