create table if not exists category
(
    category_id uuid primary key default gen_random_uuid(),
    category_name varchar(255)
);
