-- crete a function
CREATE OR REPLACE function get_department_count_by_name(dep_name varchar)
    returns int
    language plpgsql
as
$$
declare
--     declare is variable definition
    department_count integer;
begin
--     begin is the logic with sql
    select count(*)
--     into means store the value you created in this variable
    into department_count
    from employees
    where department=dep_name;
    return department_count;

end;
$$


select get_department_count_by_name(('Sports'));

CREATE OR REPLACE FUNCTION get_department(p_pattern varchar)
returns table(
    employee_name varchar,
    employee_email varchar
             )
 language plpgsql
as
    $$
    begin
        return query
        select first_name, email
        from employees
        where department like p_pattern;

    end;
    $$

select * from get_department('%oth%');

CREATE OR REPLACE FUNCTION get_department_case_insentive(p_pattern varchar)
    returns table(
                     employee_name varchar,
                     employee_email varchar
                 )
    language plpgsql
as
$$
begin
    return query
        select first_name, email
        from employees
        where department ilike p_pattern;

end;
$$

select * from get_department_case_insentive('%Oth%');

DROP FUNCTION  get_department_case_insentive(p_pattern varchar);

-- create a stored procedure
CREATE OR REPLACE PROCEDURE update_department(emp_id int)
language plpgsql
as
    $$
    declare
        begin
        update employees set department = 'Toys' where employee_id=emp_id;
        commit;
    end

    $$;

call update_department(1);

select * from employees where employee_id=1;

CREATE OR REPLACE PROCEDURE transfer(sender int, receiver int, amount dec)
    language plpgsql
as
$$
declare
begin
    update employees set salary = salary - amount
    where employee_id=sender;
    update employees set salary = salary+amount
    where employee_id=receiver;

    commit;
end

$$;

call transfer(1, 2, 44000);
select * from employees order by employee_id;