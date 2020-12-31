CREATE TABLE Towns (
                       id SERIAL UNIQUE NOT NULL,
                       code VARCHAR(10) NOT NULL, -- not unique
                       article TEXT,
                       name TEXT NOT NULL -- not unique
);
insert into towns (
    code, article, name
)
select
    left(md5(i::text), 10),
    md5(random()::text),
    md5(random()::text)
from generate_series(1, 1000000) s(i);


-- To see how long does it take to find a data:

explain analyze select * from towns where name='bd7555a25ccb6849938cc2f7e8c0d03f';
explain analyze select * from towns where id='457';

-- To see the index of an object:

SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;


-- create index:
create index idx_towns_name ON towns(name);
select * from towns;