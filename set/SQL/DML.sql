-- 명시적 NULL 입력 
-- data dictionary 조회
select *
from user_constraints;
INSERT INTO departments 
                  (department_id, 
                   department_name, 
                   manager_id, 
                   location_id) 
VALUES        (900, 
                   'KOSTA', 
                   NULL, 
                   NULL); 
select *
from departments;
-- 시퀀스를 이용한 부서번호 입력 
INSERT INTO departments (department_id,  department_name, manager_id, location_id) 
VALUES       (departments_seq.NEXTVAL, 'KOSTA', NULL, NULL); 
--시퀀스
SELECT * 
FROM   user_sequences; 
--시스템에 테이블 뭐뭐잇나~
SELECT * 
FROM   user_tables; 
-- 묵시적 NULL 입력 
INSERT INTO departments (department_id, department_name) 
VALUES     (510,  'KOSTA1'); 
-- 구조만 복사해오는 경우
CREATE TABLE dept
     AS SELECT * 
        FROM departments
        WHERE 0 = 1;
select * from dept;
INSERT INTO dept
     SELECT * FROM  departments ;
--UPDATE

--DELETE
DELETE FROM departments
WHERE department_name LIKE '%KOSTA%';

DELETE FROM employees 
WHERE  salary > (SELECT AVG(salary) 
                       FROM   employees); 
rollback;
select * from employees;
SELECT * 
FROM   user_sequences; 
select *
from user_constraints;
INSERT INTO employees (employee_id,  first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) 
VALUES       (employees_seq.NEXTVAL, 'Jiwon', 'Su', 'SKTEOO','010.9919.4591','2018/12/26', 'IT_PROG',3000,0.3,103,60); 
desc employees;
commit;

