create table if not exists category
(
    id uuid primary key default gen_random_uuid(),
    name varchar(255)
);