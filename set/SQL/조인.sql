--ũ�ν� ����
select e.last_name , d.department_name
from employees e 
    CROSS JOIN departments d 
;
--�̳� ����
-- 2�� ���̺� ����
SELECT e.employee_id, 
          e.last_name, 
          d.department_name 
FROM   employees e 
          JOIN departments d 
          on e.department_id = d.department_id and (e.last_name like 'A%' OR e.last_name like 'S%')
          --using(department_id) 
WHERE  e.salary >= 3000; 

-- 3�� �̻� ���̺� ����
SELECT e.employee_id, 
          e.last_name, 
          d.department_name, 
          l.city, 
          l.state_province, 
          c.country_name 
FROM   employees e 
         JOIN departments d 
            ON e.department_id = d.department_id 
         JOIN locations l 
            ON d.location_id = l.location_id 
         JOIN countries c 
            ON l.country_id = c.country_id; 
            
select e.employee_id, e.last_name, e.salary, j.job_title
from employees e join jobs j
on e.salary between j.min_salary and j.max_salary
order by e.employee_id;

-- employees ���̺����� �μ���ȣ�� NULL �� Kimberely�� 
-- EQUI Join�����δ� �˻����� ����
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- �ҼӺμ��� ���� ����� ���!
-- ����Ŭ OUTER JOIN
SELECT e.employee_id, 
          e.first_name, 
          e.last_name, 
          d.department_name 
FROM   employees e, 
          departments d 
WHERE  e.department_id = d.department_id(+);  -- ����
-- ANSI ǥ�� OUTER JOIN(LEFT, RIGHT, FULL ����� ���)
--  LEFT OUTER JOIN
SELECT e.first_name, 
          d.department_name 
FROM   employees e 
          LEFT OUTER JOIN departments d 
             ON e.department_id = d.department_id; 

-- RIGHT OUTER JOIN
SELECT e.first_name, 
          d.department_name 
FROM   employees e 
          RIGHT OUTER JOIN departments d 
             ON e.department_id = d.department_id; 

-- FULL OUTER JOIN
SELECT e.first_name, 
          d.department_name 
FROM   employees e 
          FULL OUTER JOIN departments d 
             ON e.department_id = d.department_id; 

-- ����� ��� �˻�
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id;

--�Ŵ����� �����ϴ� �����
select e1.first_name, count(e2.first_name)
from employees e1 right outer join employees e2
on e1.employee_id = e2.manager_id
group by e1.first_name
order by count(e2.first_name) desc;


-- ��簡 ���� ����� �˻� �� OUTER JOIN �ʿ�
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id(+);

SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee LEFT OUTER JOIN EMPLOYEES manager
                              ON employee.manager_id = manager.employee_id;
                              
SELECT manager.first_name, employee.first_name
FROM EMPLOYEES manager right OUTER JOIN EMPLOYEES employee
                              ON  manager.employee_id = employee.manager_id;                             