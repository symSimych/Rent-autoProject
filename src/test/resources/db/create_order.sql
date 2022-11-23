delete from Orders where id = 'be135665-3923-4c6f-af04-698d45ac36b9';

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

insert into Orders (id, place_of_filing, place_of_return, filing_time, return_time, confirmed, user_id, car_id) values
('be135665-3923-4c6f-af04-698d45ac36b9', 'qwrqws0', 'asgsfdas0', '2022-11-23T17:45', '2022-11-25T17:45', false, 'm@gmail.com', 'a327a4df-a3ef-4aff-96dc-2f6548a22cd4');