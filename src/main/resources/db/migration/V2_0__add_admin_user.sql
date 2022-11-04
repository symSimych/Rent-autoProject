insert into Users (first_name, last_name, email, phone_number, password) values
('Ihor', 'Bibichkov', 'ihor@gmail.com', '0504866819', crypt('ihor', gen_salt('bf')));