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