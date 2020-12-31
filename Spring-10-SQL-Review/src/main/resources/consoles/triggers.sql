-- trigger is a function invoked automatically whenever an event such as insert, update, or delete occurs.
-- trigger operations: create, drop, alter, disable, enable
-- why do we need triggers?
-- in security and log in purposes knowing the updated data is important. so let's say the password of a user changed,
--      just before/after this action, a function is triggered automatically about the data change with the time stamp in DB
DROP TABLE IF EXISTS mentors;
CREATE TABLE mentors(
--     GENERATED ALWAYS AS IDENTITY --> if you put this description, postgres will automatically create the id for you.
--              spring uses the same description behind the scene
    id INT GENERATED ALWAYS AS IDENTITY,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    primary key(id)
     );

DROP TABLE IF EXISTS mentor_audit;
CREATE TABLE mentor_audit(
--     GENERATED ALWAYS AS IDENTITY --> if you put this description, postgres will automatically create the id for you.
--              spring uses the same description behind the scene
    id INT GENERATED ALWAYS AS IDENTITY,
    mentor_id INT not null,
    last_name varchar(40) not null,
    changed_on timestamp(6) not null,
    primary key(id)
);

insert into mentors(first_name, last_name) values ('Mike', 'Smith');
insert into mentors(first_name, last_name) values ('Tom', 'Hanks');
-- now in any change happens in the last_name, i need to record it meaning i will log it to mentor_audit
-- to trigger it, first i am going to create function then i will create the trigger.
-- first let's create the function:
CREATE OR REPLACE FUNCTION  log_last_name_changes()
returns trigger
language plpgsql
as
    $$
    begin
        IF NEW.last_name <> OLD.last_name THEN
            INSERT INTO mentor_audit(mentor_id, last_name, changed_on) VALUES
            (OLD.id, OLD.last_name, now());
        end if;
        RETURN new;
    end;
    $$
-- second let's create the trigger the function i created above:
CREATE TRIGGER last_name_change
--     Below you can say either BEFORE or AFTER depending on when you want to trigger. You can use them both for the
--          same function, then it will record into the mentor_audit twice.
    BEFORE update
    ON mentors
    FOR EACH ROW
    EXECUTE  PROCEDURE log_last_name_changes();
-- now anytime i change the last_name, it will automatically recorded in mentor_audit table

-- You can list down all the triggers in the current database from pg_trigger table as follows
select * from pg_trigger;

-- Remember if you have just the function but not the trigger then the function will not run.
-- You can drop the triggers as follow:
DROP trigger if exists last_name_change2 ON mentors;