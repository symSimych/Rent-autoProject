delete from Images where size = 3;
delete from Cars where id = 'a327a4df-a3ef-4aff-96dc-2f6548a22cd4';
delete from Cars where brand = 'qweqr';

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

insert into Cars (id, brand, model, body_type, year, transmission, fuel_type, engine_volume,
                    horse_power, tank_volume, fuel_consumption, bail, price, available) values
('a327a4df-a3ef-4aff-96dc-2f6548a22cd4', 'Volkswagen', 'Jetta', 'sedan', '2012', 'manual', 'gas/gasoline', 1.4, 140, 55, 4.5, 600.0, 38.0, true);