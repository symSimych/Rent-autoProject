create table if not exists Orders (
    id uuid default uuid_generate_v4 (),
    place_of_filing varchar not null,
    place_of_return varchar not null,
    filing_time timestamp not null,
    return_time timestamp not null,
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