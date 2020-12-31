select * from employees;

select * from employees where department='Sports';

select * from employees where department like '%rt%';

select first_name, salary from employees where salary > 10000;
select first_name from employees where department='Clothing' and salary>90000;
select first_name from employees where department='Clothing' or salary>90000;
select first_name, department, salary from employees where salary<40000 and department in ('Clothing', 'Pharmacy');
select first_name, department from employees where department != 'Sports';
select first_name, department from employees where department in ('Sports', 'Toys', 'Garden');
select first_name, salary from employees where salary between 80000 and 100000;
select first_name, email from employees where gender='F' and department='Tools' and salary>110000;
select first_name, hire_date from employees where salary>165000 and (department='Sports' and gender='M');
select first_name from employees order by employee_id desc;
select distinct department from employees;
select distinct department from employees fetch first 3 rows only;
select upper(first_name) , lower(department) from employees;
select length(first_name) from employees;
select trim('              Hello         there     ');
select first_name || ' ' || last_name as name from employees;
select (salary>14000) as high from employees order by salary desc;
select department, (department like '%oth%') from employees;
select 'This is test data' test_data;
select substring('this is test data' from 1 for 7) as test_data;
select round(avg(salary)), avg(salary) from employees;
select last_name, salary, hire_date, substr(department, 1, 3) from professors;

select max(salary), min(salary) from professors where last_name != 'Wilson';
select count(*), department from employees group by department;
select sum(salary), department from employees group by department;
select sum(salary), department from employees where region_id in (4,5,6);
select department, count(*) from employees group by department having count(*)< 36 order by department;

select count(*), substring(email, position('@' in email) + 1) email_domain from employees where (email is not null) group by email_domain;
select e.department from employees e, departments d;
select * from employees where department not in (select department from departments);

select * from employees where region_id in (select region_id from regions where country in ('Asia', 'Canada'));
select first_name, salary - (select max(salary) from employees) as salary_difference from employees;
select max(salary) - min(salary) from employees;
select * from employees where department = any (select department from departments where division='Kids')
                          and hire_date > all(select hire_date from employees where department='Maintenance');
select student_name from students where student_no = any (select student_no from student_enrollment
                                                          where course_no = any (select course_no from courses where course_title in ('Physics', 'US History')));
select student_name from students where student_no in (select student_no from student_enrollment
                                                       where course_no in (select course_no from courses where course_title in ('Physics', 'US History')));

select first_name, salary,
       case
           when salary<100000 then 'under paid'
           when salary > 10000 then 'paid well'
           else 'unpaid'
           end as category
from employees;
select category, count(*)
from (select first_name,
             case
                 when salary<100000 then 'under paid'
                 when salary > 10000 then 'paid well'
                 else 'unpaid'
                 end as category
      from employees) a group by  category;

select first_name, country, department from employees, regions where employees.region_id=regions.region_id;

select first_name, email, division, d.department from employees e, departments d, regions r where e.department=d.department and e.region_id=r.region_id;
select e.first_name, d.department from employees e left outer join departments d on e.department=d.department;
select e.first_name, d.department from employees e , departments d where e.department=d.department;

select distinct  department from departments;
select distinct department from employees;
select e.email, d.department, e.department, d.division from employees e inner join departments d on e.department=d.department;