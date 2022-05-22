create table if not exists homework
(
    id          serial primary key,
    name        text      not null,
    publication timestamp not null,
    description text      not null,
    deadline    timestamp not null
);

create table if not exists submission
(
    id       serial primary key,
    homework int       not null references homework (id),
    solution text      not null,
    date     timestamp not null,
    mark     numeric,
    comment  text
);
