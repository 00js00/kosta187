select employee_id, last_name , salary, hire_date
from employees
where hire_date like '02%';

select employee_id, last_name, salary, hire_date
from employees
--order by EMPLOYEE_ID desc;
order by last_name asc , salary desc;

--group by 절
select *
from employees
group by department_id;
-- 그룹핑을 했기 때문에 전체(*) 를 가지고 올 수 없음 
select department_id, count(department_id)
from employees
group by department_id
having department_id is not null
order by department_id desc;

--서브쿼리(내부쿼리)를 이용한 table 복사
create table emp AS
select *
from employees;

-- union 
select * from employees
union 
select * from emp;

select * from 
( select * from employees 
  union all
  select * from emp
) team
order by team.employee_id;

select * from 
( select * from employees 
  union all
  select * from emp 
) 
order by employee_id;

select * from employees
intersect
select * from emp;

select * from employees
minus
select * from emp;

