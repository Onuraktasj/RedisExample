comment on database "redis-example-db" is 'Redis Example DB';

create schema if not exists "redis-example";

comment on schema "redis-example" is 'Redis Example Schema';

alter schema "redis-example" owner to admin;