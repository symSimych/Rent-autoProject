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