--SCOTT DB 과제
--SCOTT_DB를 가지고 있는 계정으로 접속
--1. 계정이 가지고 있는 테이블을 모두 검색하는 구문을 작성하시오.
select * from tab;

--2. EMP테이블의 컬럼을 출력하는 구문을 작성하시오.
desc emp;

--3. EMP테이블에서 ENAME, SAL, 연봉, 월 수령액(보너스 SALARY의
--5%), 월 실수령액(세금 3%, 보너스는 세금에서 제외)을 출력하는 구문
--을 작성하시오.
select ename, sal, 12*sal AS 연봉,
    FLOOR(1.05*sal) AS 월수령액,
    FLOOR(sal*(1-.03 +.05)) AS "월 실수령액"
from emp;

--4. EMP테이블에서 ENAME, SAL, COMM 계산금액(SAL*12+COMM)를 출력
--하는 구문을 작성하시오.
select ename, sal, comm, sal*12 +nvl(comm,0) AS 계산금액
from emp;

--5. EMP테이블의 ENAME, JOB을 이용하여 아래와 같이 출력하는 구문을 작
--성하시오.
select ename||'는 직책이 ' || job||'입니다.' AS 출력문 from emp;

--6. EMP테이블에서 JOB출력시 중복값을 제거하고 출력하는 구문을 작성하시오.
select distinct job from emp;

--7. SQL*PLUS명령어
--SELECT ENAME, JOB, SAL, COMM FROM EMP 입력 후
--1) 버퍼에 있는 내용을 실행하는 명령어를 이용하여 재출력 하세요
    /
--2) 편집기 실행하는 명령어로 메모장 띄워보시오
    edit
--3) 퍼버에 있는 내용을 파일로 저장하는 명령어를 이용하여 저장하시오.
    save filename
--4) 파일에 있는 내용 실행하는 명령어를 사용하시오
    @filename
--5) 파일에 있는 내용 퍼버로 읽어오시오.
    L

--8. EMP테이블에서 SAL이 3000이상인 사원의 전체 컬럼을 출력하시오.
select * from emp where sal >= 3000;

--9. EMP테이블에서 DEPTNO가 10이거나 JOB이 MANAGER인 사원을 출력하시오.
select * from emp where deptno=10 or job='MANAGER';

--10. EMP테이블에서 DEPTNO가 20이 아니고 JOB이 MANAGER인 사원을 출력하시오.
select * from emp where deptno!=20 and job='MANAGER';

--11. EMP 테이블에서 JOB이 MANAGER이거나 PRESIDENT이거나 ANALYST
--인 사원을 출력하시오.
select * from emp where job in ('MANAGER', 'PRESIDENT', 'ANALYST');

--12. EMP테이블에서 SAL이 2000이하이거나 SAL이 3000이상이고 고용일이
--81/01/01 ~ 82/12/31의 사원 출력하시오.
select * from emp where sal <= 2000 or sal>= 3000
and hiredate between TO_DATE('81/01/01') and TO_DATE('82/12/31');

--13. EMP테이블에서 SAL이 2000미만이거나 SAL이 3000초과인 사원을
--BETWEEN을 사용하여 출력하세요.
select * from emp where sal not between 2000 and 3000;

--14. EMP테이블에서 이름에 ‘K‘가 포함되지 않거나 ’A‘포함되지 않거나 'M'
--포함되지 않는 사원의 이름, 직책, 고용일을 출력하세요.
select ename, job, hiredate from emp
where ename not like '%K%' or ename not like '%A%' or ename not like '%M%';

--15. EMP테이블에서 DEPTNO가 20,30,10인 사원의 ENAME, DEPTNO를 출
--력하세요.
select ename, deptno from emp where deptno in (20,30,10);

--16. EMP테이블에서 MGR의 2,3번째가 6,9인 사원의 ENAME, MGR을 출력하세요.
select ename, mgr from emp where substr(mgr,2,2) = 69;

--17. EMP테이블에서 COMM이 NULL이고 HIREDATE가 81년도인 사원의
--ENAME, HIREDATE, SAL, COMM을 출력하세요.
select ename, hiredate, sal, comm from emp
where comm is null and EXTRACT(year from hiredate) = 1981;

--18. EMP테이블에서 SAL이 2500이상이고, HIREDATE가 81년인 사원의
--EMPNO, ENAME, HIREDATE, SAL을 EMPNO를 오름차순정렬하고
--ENAME을 내림차순 정렬하여 출력하세요.
select empno, ename, hiredate, sal from emp
where sal>=2500 and EXTRACT(year from hiredate) =1981
order by empno asc, ename desc;

--19. EMP테이블에서 SAL을 12로 나누고 소수점을 버림을 하고 SAL기준으로
--내림차순정렬하여 출력하세요.
select floor(sal/12) from emp order by sal desc;

--20. DUAL테이블에서 숫자함수를 이용하여 값을 출력해보자.
--1) 233에 2를 나눈 나머지값 출력
select mod(233,2) from dual;

--2) 233.15123에서 소수 첫번째 자리까지 출력(버림)
select TRUNC(233.15123, 1) from dual;

--3) 233.15123에서 두 번째 자리에서 반올림
select ROUND(233.15123, -2) from dual;

--21. EMP테이블에서 ENAME에 A가 포함되고 ENAME길이가 5인 사원의
--ENAME, ENAME의 첫글자만 대문자, HIREDATE의 년도, ‘A'있는 위치
--값, ENAME앞에 @를 넣은 값, A를*로 변경한 값을 출력하시오.
select ename, INITCAP(ename),
    EXTRACT(year from hiredate) As 년도,
    INSTR(ename, 'A',1) AS A위치값,
    '@'||ename, REPLACE(ename, 'A', '*')
from emp
where length(ename)=5 and ename like '%A%';
    

--22. EMP테이블에서 HIREDATE부터 현재일까지 지난달이 420이상이고,
--HIREDATE로부 5개월이 지난 날이 82/01/01 ~ 82/12/31사이이고,
--HIREDATE의 월이 9월달 초과인 사원의 ENAME, 현재일, HIREDATE,
--지난달수, 5개월후, 고용일을 출력하세요
select ename, sysdate AS 현재일, hiredate AS 고용일,
    FLOOR(months_between(sysdate, hiredate)) ||' 개월' AS 지난달수,
    add_months(hiredate, 5) AS 고용일5개월후
from emp
where months_between(sysdate, hiredate) >=420  
    and add_months(hiredate, 5) between '82/01/01' and '82/12/31'
    and add_months(hiredate, 9) <sysdate;
