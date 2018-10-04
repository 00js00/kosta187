select employee_id, last_name , salary, hire_date
from employees
where hire_date like '02%';

select employee_id, last_name, salary, hire_date
from employees
--order by EMPLOYEE_ID desc;
order by last_name asc , salary desc;

--group by ��
select *
from employees
group by department_id;
-- �׷����� �߱� ������ ��ü(*) �� ������ �� �� ���� 
select department_id, count(department_id)
from employees
group by department_id
having department_id is not null
order by department_id desc;

--��������(��������)�� �̿��� table ����
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

