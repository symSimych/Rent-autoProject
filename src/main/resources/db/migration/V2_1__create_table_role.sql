create table if not exists Roles (
    id uuid default uuid_generate_v4 (),
    user_id varchar,
    roles varchar,
    primary key(id),
     constraint user_fk foreign key (user_id)
        references Users (email) match simple
        on update no action
        on delete no action
);