-----실습문제-----
--1
select emp_name AS 이름, email AS 이메일, length(email) AS 이메일길이 from employee;

--2
select emp_name AS 이름, substr(email, 1, instr(email, '@')-1) AS 이메일아이디 from employee;

--3
select emp_name AS 직원명,
    TO_NUMBER(substr(emp_no,1,2))+1900 AS 년생,
    nvl(bonus, 0) AS 보너스
from employee
where substr(emp_no,1,1) =6;

--4
select count(*) ||'명' AS 인원
from employee
where substr(phone,1,3) !='010';

--5
select emp_name as 직원명,
    EXTRACT(year from hire_date) || '년 ' 
        || EXTRACT(month from hire_date) || '월' as 입사년월
from employee;

--6
select emp_name AS 직원명,
    RPAD(substr(emp_no,1,8), 13, '*') AS 주민번호
from employee;

--7
select emp_name 직원명, dept_code 직급코드, 
    TO_CHAR(salary, 'L999,999,999') AS 연봉
from employee;

--8
select emp_id 사번,
    emp_name 사원명,
    dept_code 부서코드,
    hire_date 입사일
from employee
where dept_code in('D5', 'D9')
    and EXTRACT(year from hire_date) = 2004;

--9
select emp_name 직원명,
    hire_date 입사일,
    TO_CHAR(FLOOR(sysdate-hire_date), '999,999') ||'일' 근무일수
from employee;

--10
select emp_name AS 직원명,
    dept_code AS 부서명,
    substr(emp_no, 1,6) AS 생년월일,
    TO_NUMBER(EXTRACT(year from sysdate))
        - TO_NUMBER(substr(emp_no,1,2)
            + CASE WHEN substr(emp_no, 8,1) in (1,2) THEN 1900
                    ELSE 2000 END) 
        + TO_NUMBER( CASE WHEN REPLACE(substr(sysdate,4), '/', '')
                        - substr(emp_no, 3,4) > 0 THEN 0 ELSE -1 END)
            AS "나이(만)"
from employee;

--11
select emp_name 사원명, dept_code 부서코드,
    CASE WHEN dept_code='D5' THEN '총무부'
        WHEN dept_code='D6' THEN '기획부'
        WHEN dept_code='D9' THEN '영업부' END
    AS 부서명
from employee
where dept_code in ('D5', 'D6','D9')
order by dept_code;

--12
select job_code 직급, count(*) 인원수, 
TO_CHAR(FLOOR(avg(salary)), 'L999,999,999') 평균급여
from employee
where job_code != 'J1'
group by job_code
order by job_code;

--13
select EXTRACT(year from hire_date) 입사년도, count(*) 인원수
from employee
where job_code != 'J1'
GROUP BY EXTRACT(year from hire_date)
order by EXTRACT(year from hire_date);

--14
select
    CASE WHEN substr(emp_no, 8,1) in (1,3) THEN '남'
        WHEN substr(emp_no, 8,1) in (2,4) THEN '여' END
            AS 성별,
    TO_CHAR(FLOOR(avg(salary)), 'L999,999,999') 급여평균,
    TO_CHAR(sum(salary), 'L999,999,999') 급여합계,
    count(*) 인원수
from employee
GROUP BY
    CASE WHEN substr(emp_no, 8,1) in (1,3) THEN '남'
        WHEN substr(emp_no, 8,1) in (2,4) THEN '여' END
order by count(*);

--15
select dept_code 부서코드, job_code 직급코드, count(*) 인원수
from employee
GROUP BY dept_code, job_code
HAVING count(*) >= 3
order by dept_code, job_code;

