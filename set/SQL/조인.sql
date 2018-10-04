--크로스 조인
select e.last_name , d.department_name
from employees e 
    CROSS JOIN departments d 
;
--이너 조인
-- 2개 테이블 조인
SELECT e.employee_id, 
          e.last_name, 
          d.department_name 
FROM   employees e 
          JOIN departments d 
          on e.department_id = d.department_id and (e.last_name like 'A%' OR e.last_name like 'S%')
          --using(department_id) 
WHERE  e.salary >= 3000; 

-- 3개 이상 테이블 조인
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

-- employees 테이블에에서 부서번호가 NULL 인 Kimberely는 
-- EQUI Join만으로는 검색되지 않음
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- 소속부서가 없는 사원도 출력!
-- 오라클 OUTER JOIN
SELECT e.employee_id, 
          e.first_name, 
          e.last_name, 
          d.department_name 
FROM   employees e, 
          departments d 
WHERE  e.department_id = d.department_id(+);  -- 구식
-- ANSI 표준 OUTER JOIN(LEFT, RIGHT, FULL 예약어 사용)
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

-- 사원별 상사 검색
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id;

--매니저별 관리하는 사원수
select e1.first_name, count(e2.first_name)
from employees e1 right outer join employees e2
on e1.employee_id = e2.manager_id
group by e1.first_name
order by count(e2.first_name) desc;


-- 상사가 없는 사원도 검색 시 OUTER JOIN 필요
SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee, EMPLOYEES manager
WHERE employee.manager_id = manager.employee_id(+);

SELECT employee.first_name , manager.first_name
FROM EMPLOYEES employee LEFT OUTER JOIN EMPLOYEES manager
                              ON employee.manager_id = manager.employee_id;
                              
SELECT manager.first_name, employee.first_name
FROM EMPLOYEES manager right OUTER JOIN EMPLOYEES employee
                              ON  manager.employee_id = employee.manager_id;                             