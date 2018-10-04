select *
from employees 
where salary = (select salary
                from employees 
                where lower(last_name)= 'seo')
      and lower(last_name) <> 'seo' ;
      
SELECT * 
FROM   employees 
WHERE  salary > (SELECT AVG(salary) 
                      FROM    employees);

select * from employees where  salary = ALL(3000);
select * from employees where  salary = 3000;

-- IN ������ Ȱ��
-- 30�� �μ��� �Ҽӵ� ������ ������ ������ ������ ��ü ������ ��ȸ
SELECT last_name, 
          job_id, 
          department_id 
FROM   employees 
WHERE  job_id IN (SELECT job_id 
                       FROM   employees 
                       WHERE  department_id = 30);

-- ANY ������ Ȱ��
-- 30�� �μ��� �ּұ޿��� ����  �� ���� �޿��� �޴� ��ü ������ ��ȸ
SELECT * 
FROM   employees 
WHERE  salary > ANY (SELECT salary 
                             FROM   employees 
                             WHERE  department_id = 30);
                             SELECT * 
FROM   employees 
WHERE  salary < ANY (SELECT salary 
                             FROM   employees 
                             WHERE  department_id = 30);
-- ALL ������ Ȱ��
-- 30�� �μ��� �ִ�޿��� ���� �� ���� �޿��� �޴� ��ü ������ ��ȸ
SELECT * 
FROM   employees 
WHERE  salary > ALL (SELECT salary 
                            FROM   employees 
                            WHERE  department_id = 30);
SELECT * 
FROM   employees 
WHERE  salary < ALL (SELECT salary 
                            FROM   employees 
                            WHERE  department_id = 30);
-- EXISTS ������ Ȱ��
-- ���������� ��� ������ ���� ��ȸ
SELECT * 
FROM   employees 
WHERE  EXISTS(SELECT * 
                     FROM   departments 
                     WHERE  department_id = 30)
           AND department_id = 30;

SELECT * 
FROM   employees 
WHERE  EXISTS(SELECT department_id 
                     FROM   departments 
                     WHERE  department_id = 30)
           AND department_id = 30;
-- �μ��� �ּұ޿��� ����
SELECT * 
FROM   employees 
WHERE  ( department_id, salary ) IN(SELECT department_id, 
                                                         MIN(salary) 
                                              FROM   employees 
                                              GROUP  BY department_id) 
ORDER  BY department_id;

-- �����÷�(ROWID, ROWNUM)
SELECT ROWID, 
       ROWNUM, 
       employee_id,
       last_name
FROM   employees;
-- ���̺��� ���� ���̶� ���� �ٸ� ROWNUM�� ���� �� �ִ�
SELECT ROWNUM, employee_id
FROM   employees;

SELECT ROWNUM, employee_id
FROM   employees
ORDER BY employee_id DESC;

SELECT *
FROM   employees
WHERE  ROWNUM > 0;


-- ù��° ���� rownum�� 1�̹Ƿ�
-- 1 > 1�� false�� �Ǿ� rownum�� ���̻� �������� ������, �ϳ��� �൵ ��ȯ���� ����
SELECT *
FROM   employees
WHERE  ROWNUM > 1;
-- ù��° 10����(����)���� ��ȸ�� ���
-- ù��° ���� rownum�� 1�̹Ƿ�
-- 1 <= 10�� true�� �Ǿ� ù��° �࿡ 1�� �Ҵ�ǰ� rownum�� 2�� ����
SELECT *
FROM   employees
WHERE  ROWNUM <= 10;


/* Ư�� �÷��� �������� �����Ͽ� ���� 5��(����)�� ��ȸ�ϰ��� �Ѵٸ� */
-- ��)��ü ����� �޿������� 5�� ��������
-- ��ü �޿� ������ �ƴ� ó�� 5��ȿ����� �޿������� ��
SELECT first_name , salary
FROM   (SELECT * 
           FROM   employees 
           ORDER  BY salary DESC)
WHERE  ROWNUM <=7
minus
SELECT first_name , salary
FROM   (SELECT * 
           FROM   employees 
           ORDER  BY salary DESC)
WHERE  ROWNUM <=2 
ORDER  BY salary DESC;




-- FROM������ ��������(Inline View)�� ����ؾ� �Ѵ�
SELECT * 
FROM   (SELECT * 
           FROM   employees 
           ORDER  BY salary DESC) 
WHERE  ROWNUM <= 5;

-- �޿������� 11 ~ 20 ����
SELECT page, 
          employee_id, 
          first_name, 
          salary 
FROM   (SELECT CEIL(ROWNUM / 10) page, 
                     employee_id, 
                     first_name, 
                     salary 
           FROM   (SELECT ROWNUM, 
                                employee_id, 
                                first_name, 
                                salary 
                      FROM   employees 
                      ORDER  BY salary DESC)) 
WHERE  page = 2; 
