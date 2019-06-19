-------------------------
--- PRACTICE HOMEWORK 03 ---

--심봉선 사원과 같은 부서의 사원의 
--부서title, 사원명, 월평균급여조회
select dept_title, dept_code, trunc(avg(salary)) 월평균급여
from employee JOIN department ON dept_code = dept_id
where dept_code = (select dept_code from employee where emp_name='심봉선')
group by dept_title, dept_code;

select dept_title, dept_code, trunc(avg(salary)) 월평균급여
from employee E1 LEFT JOIN department ON dept_code = dept_id
where EXISTS (select dept_code from employee E2 where E2.emp_name='심봉선'
    and E1.dept_code = E2.dept_code)
group by dept_title, dept_code;

select dept_title, emp_name, dept_code
from employee E1
LEFT JOIN department ON dept_code = dept_id
where exists 
    (select 1 from employee E2 
        where E2.emp_name='심봉선'
    and E1.dept_code = E2.dept_code);

select dept_title, trunc(avg(salary)) 평균급여
from employee e left join department ON dept_code = dept_id
where exists (select 1 from employee where dept_code =e.dept_code and 
emp_name = '심봉선')
group by dept_title;

--가장많은 급여를 받는 사원을 exists 상관서브쿼리를 이용하여 구하여라
select emp_name, dept_code, salary, hire_date
from employee E1
where EXISTS (select max(E2.salary) from employee E2 
                HAVING E1.salary = max(E2.salary));

--NONEXISTS 이용
--윤은혜와 급여가 같은 사원들을 검색해서, 사번, 사원이름, 급여출력
select emp_id, emp_name, salary
from employee E1
where exists (select * from employee E2
            where E1.salary = E2.salary 
                and E2.emp_name = '윤은해'
                and E1.emp_name!= E2.emp_name);

--EMPLOYEE테이블에서 기본급여 제일 많은 사람과 제일적은 사람의 정보를 
--사번,사원명,월급출력
select emp_id, emp_name, salary
from employee E1
where salary = (select max(salary) from employee)
    or salary = (select min(salary) from employee);

--D1,D2부서에 근무하는 사원들 중에서 기본급여가 D5부서 직원들의 평균월급보다 
--많은 사람들만 부서번호, 사번,사원명, 월급출력
select dept_code, emp_id, emp_name, salary
from employee 
where dept_code in('D1','D2')
    and salary > (select AVG(salary) from employee where dept_code='D5');

--차태현 전지연 사원의 급여등급과 같은 사원의 직급명, 사원명 출력
select job_name, emp_name, sal_level
from employee E1 JOIN job J ON E1.job_code = J.job_code
where E1.sal_level in 
    (select sal_level from employee E2
        where E2.emp_name in ('차태연','전지연')
            and E1.emp_name != E2.emp_name);

--직급이 대표, 부사장이 아닌 모든 사원을 부서별로 출력
select nvl(D.dept_title, '인턴') dept_title, emp_name, J.job_name
from employee E
    JOIN job J USING(job_code)
    LEFT JOIN department D ON E.dept_code = D.dept_id
where J.job_name Not in ('대표', '부사장')
order by E.dept_code, J.job_name;

--ASIA1지역에 근무하는 사원정보출력 부서코드, 사원명(서브쿼리이용)
select dept_code, emp_name, location_id
from employee
    JOIN department ON dept_code= dept_id
    JOIN location L ON location_id = L.local_code
where L.local_name = 'ASIA1';

--2000년1월1일 이전 입자사중에 2000년1월1일이후 입사자보다 급여을 (가장높게
--받는사원보다) 적게 받는 사원의 사원명과 월급여를 출력
select emp_name, salary, hire_date from employee E1
where hire_date <TO_DATE('2000/01/01')
    and salary < (select max(salary) from employee
            where hire_date > TO_DATE('2000/01/01'));

--'J4'직급의 사원보다 많은 급여를 받는 직급이 J5,J6,J7인 사원 출력
select emp_name, job_code, salary from employee
where job_code in ('J5','J6', 'J7')
and salary > ALL(select salary from employee where job_code='J4');

--D1부서의 사원(전체)보다 입사가 늧은 사원들의 정보를 검색하고, 
--사원명, 부서번호 입사일을 출력
select emp_name, dept_code, hire_date from employee
where hire_date > ALL(select hire_date from employee where dept_code='D1');

--인사관리부의 사원전체보다 입사가 늦은 사원들의정보를 검색, 
--사원명, 부서명, 입사일
select emp_name, dept_code, hire_date
from employee E 
    LEFT JOIN department D ON E.dept_code = D.dept_id
where hire_date > ALL(select hire_date from employee E2
                JOIN department D2 ON E2.dept_code = D2.dept_id
                where D2.dept_title='인사관리부');

--기술지원부이면서 급여가 2000000인 사원의 
--사원명, 부서코드, 급여출력
select emp_name, dept_code, salary from employee
    JOIN department ON dept_code = dept_id
where salary = 2000000 
    and dept_title = '기술지원부';

--부서별 최대급여를 받는 사원의 
--사원명, 부서명, 급여를 출력
select emp_name, dept_title, salary
from employee
    JOIN department ON dept_code = dept_id
where (dept_code, salary) in (select dept_code, max(salary)
    from employee group by dept_code)
order by dept_title;

--직급이 J1, J2, J3이 아닌 사원중에서 
--자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드, 사원명, 급여, 부서별 급여평균
select E.dept_code, E.emp_id, E.emp_name, E.salary, E2.AVG_SAL
from employee E
    JOIN department D on E.dept_code = D.dept_id
    JOIN ( select dept_code, ROUND(avg(salary)) AVG_SAL
            from employee
            group by dept_code) E2 ON (E.dept_code = E2.dept_code)
where EXISTS(select E3.dept_code, avg(E3.salary) from employee E3
        where E.dept_code = E3.dept_code
        group by E3.dept_code
        HAVING E.salary > avg(E3.salary))
    and E.job_code not in ('J1','J2','J3')
order by dept_code;
