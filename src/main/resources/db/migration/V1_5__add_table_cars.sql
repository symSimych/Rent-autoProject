create extension if not exists "uuid-ossp";

create table if not exists Cars (
    id uuid default uuid_generate_v4 (),
    brand varchar not null,
    model varchar not null,
    body_type varchar,
    year varchar not null,
    transmission varchar,
    fuel_type varchar not null,
    engine_volume float8,
    horse_power int4 not null,
    tank_volume int4,
    fuel_consumption float8,
    bail float8 not null,
    price float8 not null,
    available boolean,
    preview_image_id uuid,
    primary key (id)
);

insert into Cars (brand, model, body_type, year, transmission, fuel_type, engine_volume,
                    horse_power, tank_volume, fuel_consumption, bail, price, available) values
('Volkswagen', 'Jetta', 'sedan', '2012', 'manual', 'gas/gasoline', 1.4, 140, 55, 4.5, 600.0, 38.0, true),
('Volkswagen', 'Polo', 'sedan', '2014', 'automatic', 'gasoline', 1.6, 105, 55, 5, 400.0, 33.0, true),
('Ford', 'Mustang', 'coupe', '2016', 'manual', 'gasoline', 5.2, 700, 60, 14, 1200.0, 90.0, true),
('Mercedes-benz', 'W222 S-Class', 'sedan', '2016', 'automatic', 'gasoline', 5.2, 360, 70, 7.5, 3000.0, 120.0, true),
('Toyota', 'Camry', 'sedan', '2017', 'automatic', 'gasoline', 2.5, 180, 60, 6, 1000.0, 50.0, true),
('Porsche', 'Cayenne', 'SUV', '2013', 'automatic', 'diesel', 3.0, 245, 70, 6, 1500.0, 60.0, true);