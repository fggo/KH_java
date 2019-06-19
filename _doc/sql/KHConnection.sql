--NUMBER(p 전체자리 수, s 전체자리수 중 소숫점 수);

CREATE TABLE NUMBERTEST(
    A NUMBER(7,3),
    B NUMBER(7),
    C NUMBER,
    D NUMBER(7,1),
    E NUMBER(5,-1)
);

SELECT * FROM NUMBERTEST;

INSERT INTO NUMBERTEST
    VALUES(1234.567, 1234.567, 1234.567, 1234.567, 1234.567);

--char 고정길이 최대 2000byte
--nchar 유니코드 고정길이 (갯수로 처리) 최대 글자수 1000개
--varchar2 가변길이 최대 4000byte
--nvarchar2 유니코드 가변길이 최대 글자수 2000개까지
--
--char(10) 10 byte 만큼 저장이 되는 공간. 무조건 10byte 다 사용
--	남은 공간은 whitespace로 채워짐
--varchar2(10) 10 byte만큼 저장이 되는 공간, 대입되는 값의
--	크기에 따라 사용 공간이 정해짐
--	오라클 express버젼에서 한글은 3byte로 처리; 한글 4글자이상 ERROR
--nchar(10) nvarchar(10) 글자수 설정 10글자 만큼 저장되는 공간 확보

create table chartest(
    a char(6),
    b varchar2(6),
    c nchar(6),
    d nvarchar2(6)
);

insert into chartest values('abc','abc','abcdef','abcdef');

insert into chartest values('abcefg','abcefg','abcdef','abcdef');

--ERROR
insert into chartest values('abcefg123','abcefg123','abcdef','abcdef');

insert into chartest values('바바', '바바', '바바바', '바바바');

insert into chartest values('바바', '바바', '바바바천재', '바바바천재');

DELETE FROM CHARTEST;

select * from chartest;

--메모리 공간에서 저장하고 있는 상태 트랜젝션 관리!
--commit 하기 전에 sqlplus kh/kh로 select하면 반영 안되어 있음
--develop 램공간 안에만 데이터 저장하고 select 하면 데이터 나오지만
--sqlplus로는 database(영속적 저장공간)에서 조회하니, 데이터 안나옴
--commit으로 영속적 저장공간에 집어넣으면 sqlplus조회 가능

commit;

--length
select a, length(a) length_A_char, lengthb(a) lengthb_A_char,
    b, length(b) length_B_varchar2, lengthb(b) lengthb_B_varchar2,
    c, length(c) length_C_nchar, lengthb(c) lengthb_C_nchar,
    d, length(d) length_D_nvarchar2, lengthb(d) lengthb_D_nvarchar2
from chartest;

--날짜자료형
--현재날짜를 표시해주는 system 컬럼: sysdate
--dual: 오라클에서 제공하는 template 테이블(테스트용)
select sysdate from dual;

select length('큰언니'), lengthb('큰언니') from dual;

select * from dual;

--날짜의 산술 연산
select sysdate-1 어제, sysdate 오늘, sysdate+1 내일 from dual;

select to_char(sysdate, 'mm-dd-yyyy hh24:mi:ss') "NOW" from dual;

--날짜와 날짜끼리의 산술 연산
--일수(int) 값으로 출력
select sysdate - to_date('19990224', 'yyyymmdd') from dual;

--시간까지 출력
select systimestamp from dual;

select to_date('19990224', 'yyyy-mm-dd') from dual;

create table datetest(
    today date,
    birthday date,
    temp timestamp);

insert into datetest values('19/06/13', '00/02/24', '19/06/13 11:15:00');

insert into datetest
values(to_date('20190613'), to_date('19990224'),
    to_timestamp('20190613111500'));
    
select * from datetest;

--테이블 컬럼의 자료형을 확인하고 싶을때
desc chartest;

desc datetest;

create table member_table (
    id CHAR(15), --변동x 6-15자리
    password VARCHAR2(15), --8-15자리
    name VARCHAR2(15), --한글입력
    phone NUMBER(11), --핸드폰 -없이
    ssn NUMBER(13), --주민번호
    mileage NUMBER, --마일리지
    reg_date DATE);

select * from member_table;

desc member_table;

-- 테이블에 있는 데이터 조회하기
-- 명령어 select
-- 명령구조 select 컬럼1,...,컬럼n from 테이블명 where 검색조건

select * from kh.employee;

select dept_id, dept_title from department;

select emp_name, email, phone, ent_date from employee;

--select 문에서는 산술 연산도 가능
--연산을 하기 위해서는 연산식의 컬럼명이 들어가는 곳에서
--연산을 해주면 그 연산 명이 컬럼명이 되고, 계산된 값이
--각 row에 들어간다.

--ERROR
select emp_name, salary, email*12 from employee;

--select bonus %12 from employee;
--%연산자는 기본 산술연산자로 등록되어 있지 않음
--mod라는 함수 이용

--nvl함수는 컬럼데이터가 null일때,
--그 값을 대체해줄 값을 지정
--nvl(컬럼명, null 대체값)
select emp_name 이름,
    salary*12 AS "1년 급여(연봉)",
    12*salary*(1+ nvl(bonus,0)) AS 총수령액,
    12*salary*((1-.03) + nvl(bonus,0)) 실수령액,
    '원' AS 통화
from employee;

select emp_name, sysdate-hire_date from employee;

--DISTINCT 중복된 값이 있으면 한번만 출력
select emp_name, dept_code from employee;

select distinct dept_code from employee;

--(dept_code, job_code)를 한개 데이터로 distinct인 것을 select
select distinct dept_code, job_code from employee;

--비교 연산자 : where절에서
--where절 사용하기 : resultSet에 필요한 row들만 필터링
--select 컬럼1,...,컬럼n from 테이블명 where 컬럼명 비교연산자 값;
select * from employee where job_code = 'J5';

select * from tab where tname='EMPLOYEE';

select emp_name, salary, hire_date, phone from employee
where sal_level='S1';

select emp_name, salary,
    12*salary*(1+nvl(bonus, 0)-.03) AS 실수령액
from employee
where 12*salary*(1-.03 + nvl(bonus,0)) > 50000000;

--논리연산자 사용하기
--AND/OR
select * from employee
where dept_code != 'D6' AND salary >= 3000000;

select emp_name, hire_date, salary from employee
where job_code='J3' OR sal_level='S5';

--비교연산자를 여러개
select * from employee
where dept_code='D5'
    AND hire_date >'02/01/01';

select distinct sal_level from employee
--where job_code != 'J1'
where job_code ^= 'J1'
group by sal_level
order by sal_level;

select emp_name, salary
from employee
where salary between 3500000 and 6000000;
--where salary >=3500000 and salary <= 6000000;

select emp_no || emp_name || email from employee;

select emp_name ||'님 안녕하세요 당신은 '|| salary || '원 만큼 받나요?' from employee;

select emp_name, hire_date, dept_code, salary from employee
where hire_date between '90/01/01' and '01/01/01';
--where hire_date >= '90/01/01' and hire_date <='01/01/01';

--부정연산자를 이용하고 범위 밖의 값을 출력할 수 있음
select emp_name, dept_code, hire_date from employee
where salary not between 3500000 and 6000000;

--LIKE 문자 패턴이용하여 검색
select * from employee where emp_name like '%희';

-- 언더바는 자릿수 표시
select * from employee where emp_name like '__희';

-- email 세번째 자리가 'n'인 사람
select * from employee where email like '__n%';

select * from employee where emp_name like '__석';

select * from employee where emp_name like '_옹_';
    
select * from employee where emp_name like '%이%';

select * from employee
where email like '___#_%' ESCAPE '#';

select * from employee
where email like '____^_%' ESCAPE '^' 
    and dept_code in ('D6', 'D9')
    and hire_date between '90/01/01' and '00/12/01'
    and salary >= 2700000;

create table tbl_escape_watch(
    watchname   varchar2(40),
    description varchar2(200)
);

insert into tbl_escape_watch values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch values(
	'은시계', '고객만족도 99.99점을 획득한 고급시계');

--description에 '99.99%' 라는 말이 들어가 있는 행만 추출?
select * from tbl_escape_watch
where description like '%99.99^%%' ESCAPE '^';

select emp_name, phone from employee
where phone not like '010%';

select * from employee
where email like '%_____^_%' ESCAPE '^'
and dept_code in ('D6', 'D9');


--is null / is not null : null값을 찾을때 사용
-- 사용: 컬럼명 is null or 컬럼명 is not null
select * from employee where bonus is null;

select salary + bonus AS totalPay from employee
where bonus is not null;

select emp_name, salary, dept_code from employee
where dept_code is null;

select * from employee where nvl(bonus, 0)=0;


--subquery 썼을때, 컬럼이 한개 이상일때, 'IN' 사용
--여러값을 or로 연결하여 동등비교하는 것!
-- 사용: 컬럼값 in (비교값1,...,비교값n);

select * from employee
where job_code in ('J3', 'J2');
-- job_code ='J3' or job_code='J2';

select emp_name, job_code from employee
where job_code in
    (select job_code from employee
        where salary > 3000000);

select emp_name, dept_code, salary, sal_level from employee
where emp_name in ('전형돈', '유재식', '이태림');

--AND가 OR보다 우선시 됨!

select * from employee
where dept_code='D9' or dept_code='D6'
    and hire_date between'99/01/01'and '00/12/01';

select * from employee
--where job_code='J7' or job_code='J2' and salary > 2000000;
--where (job_code='J7' or job_code='J2') and salary > 2000000;
where salary > 2000000 and job_code='J7' or job_code='J2';

--order by 를 이용한 데이터 정렬
--order by는 마지막에 작성
--order by 컬럼명 ASC(디폴트) DESC;
--기본적으로 primary key로 정렬
--order by 컬럼1, 컬럼2;
select * from employee order by emp_name desc;

--null을 order by ASC 했을때 null은 맨뒤로
select emp_name, salary, bonus from employee
order by bonus DESC;

-- null의 변경순서를 변경하고 싶을떄, nulls 옵션 사용
select emp_name, salary, bonus from employee
order by bonus ASC nulls first;

select emp_name, salary, bonus from employee
order by bonus nulls last;

select emp_name, dept_code, job_code from employee
order by emp_name, dept_code desc;

--컬럼명이 아닌 index 번호로 정렬 가능
select emp_name, salary, bonus from employee
order by 2;
--order by salary;
--2번째 select컬럼 salary 기준으로 정렬

--함수 function
select emp_name, 
    length(emp_name), 
    lengthb(emp_name),
    email, 
    length(email),
    lengthb(email)
from employee;

desc employee;

select length('바바바') from dual;
select lengthb('바바바') from dual;

--INSTR(문자, 찾는문자, +/-방향몇칸, 몇번째문자인지)
--매개 변수로 들어온 문자에서 특정문자의 위치를 찾을때
select INSTR('바바바', '바') from dual;

select INSTR('monkkky', 'k') from dual;

select INSTR('monkkkaaakay', 'k', -4, 2) from dual;

select INSTR('monkkkaaakay', 'a', -4, 2) from dual;

select INSTR('monkkkaaakay', 'a', 1, 1) from dual;

select email, INSTR(email, '_') from employee;

select email, substr(email, instr(email, '@'))
from employee;

select rpad('monkey', 10, '^') from dual;

select rpad('바바', 10, '^') from dual;

select rpad(emp_name, 8, '님') from employee;

--LTRIM/RTRIM 문자열의 왼쪽 또는 오른쪽의 지정된 문자를 제거
--false 조건되는 순간 TRIM 중단
select LTRIM('     TRIM') from dual;

select 'kkkkktrim', LTRIM('kkkkktrim', 'k') from dual;

select LTRIM('hhhkhkhkhkhakhzzzz', 'kh') from dual;

select RTRIM('kkkkahhhhtrim', 'kh') from dual;

select substr('1523213213213유병승',
    instr('1523213213213유병승', '유')) from dual;

select LTRIM('321389219328913유병승', '0123456789') from dual;

select RTRIM(LTRIM('32132132132유병승321321321321',
    '0123456789'), '0123456789') from dual;

select SUBSTR('321312321유병승321321312',
    INSTR('321312321유병승321321312', '유'),3)
from dual;

select '    kh    ', TRIM('     kh    ') from dual;

--ERROR only one character
select 'zzzzzzkhzzzz', 
    TRIM(leading 'za' from 'zzzzzkhzzzz') from dual;
select 'zzzzzzkhzzzz', 
    TRIM(leading 'z' from 'zzzzzkhzzzz') from dual;
select 'zzzzzzkhzzzz', 
    TRIM(trailing 'z' from 'zzzzzkhzzzz') from dual;
select 'zzzzzzkhzzzz', 
    TRIM(both 'z' from 'zzzzzkhzzzz') from dual;

--substr 특정 문자열을 잘라낸
select substr('abcdefg', 3,2) from dual;

select substr('showmethemoney', '5', '2') from dual;

select substr('showmethemoney', 5) from dual;

select substr('showmethemoney', -8, 3) from dual;

select substr('가나다라마 바사아자차 카타', 7, 5) from dual;

select distinct substr(emp_name,1,1) AS name from employee
--order by substr(emp_name,1,1);
--order by 1;
--order by emp_name --ERROR
--order by는 select문에 있는 컬럼만
order by name;


--영문자 대문자 소문자 camel case
--UPPER LOWER INITCAP
select upper('hello world'), lower('HELLO WORLD'), INITCAP('hello world')
from dual;

select INITCAP('show me the money') from dual;

--CONCAT 문자열을 결합하는 함수
select CONCAT(emp_name, hire_date) from employee;
select emp_name || email from employee;

--REPLACE 특정 문자를 변경
select REPLACE('monkey', 'o', '@') from dual;

select REPLACE(email, substr(email, instr(email,'@')), '@naver.com')
from employee;

select * from employee
where substr(emp_no,8,1) = 1;

--숫자 처리함수 ABS MOD ROUND TRUNC FLOOR CEIL
select ABS(-3.1415) from dual;

select MOD(10, 3) from dual;

select ROUND(33.1415, -1) from dual;
select ROUND(33.1415, 1) from dual;
select ROUND(33.1415, 2) from dual;
select ROUND(33.1415, 3) from dual;
select ROUND(33.1415, 4) from dual;

select round(nvl(bonus,0), 2) from employee;

select round(sysdate-hire_date) from employee;

--FLOOR 소숫점을 전부 버림
select FLOOR(33.1415) from dual;

select FLOOR(bonus) from employee;

--TRUNC 특정 위치에서 소숫점을 버림
select TRUNC(33.1415, -1) from dual;
select TRUNC(33.1415, 1) from dual;
select TRUNC(33.1415, 2) from dual;
select TRUNC(33.1415, 3) from dual;
select TRUNC(33.1415, 4) from dual;

--CEIL 소숫점 전부 올림
select CEIL(nvl(bonus,0)) from employee;

create table tbl_files(
    fileno number(3), filepath varchar2(500));

insert into tbl_files values(1, 'c:\abc\deft\salesinfo.xls');
insert into tbl_files values(2, 'c:\music.mp3');
insert into tbl_files values(3, 'c:\documents\resume.hwp');

select * from tbl_files;

--파일명만 출력
--select substr(filepath, instr(filepath, '\', -1) + 1)
--from tbl_files;


--날짜 처리 함수
select sysdate from dual;

select FLOOR(months_between(sysdate, to_date('20000224', 'yyyymmdd'))) ||''
from dual;

select ROUND(months_between(sysdate, hire_date), 0) months from employee;

select add_months(to_date('20000224', 'yyyy/mm/dd'), 3) from dual;

--오늘부로 군대 입대, 1년6개월 군복무 기간 가정.
--1.제대일,2.먹을짬밥수--하루에 세끼
select sysdate AS 입대일,
    add_months(sysdate, 18) AS 제대일,
    add_months(sysdate,18) - sysdate AS 군생활일수, 
    3*(add_months(sysdate,18) - sysdate) AS 짬밥수
from dual;

--next_day : 지정한 날짜의 지정한 요일의 날짜를 구해줌
--일:1 월:2 화:3 수:4 목:5 금:6 토:7
select next_day(sysdate, '월요일') from dual;
select next_day(sysdate, '월') from dual;
select next_day(sysdate, 2) from dual;

--로케일에 따라 대입하는 걸 다르게 해야. 한국 기준 MON 사용 불가
select next_day(sysdate, 'MON') from dual;
select next_day(sysdate, 'MONDAY') from dual;

select * from V$NLS_PARAMETERS;

alter session set NLS_LANGUAGE=AMERICAN;

alter session set NLS_LANGUAGE=KOREAN;

--LAST_DAY 전달받은 날짜가 속한 달의 마지막 날을 표시

select LAST_DAY(sysdate) from dual;

select LAST_DAY('00/02/24') from dual;

--세달 후 마지막날
select LAST_DAY(ADD_MONTHS(sysdate, 3)) from dual;

--EXTRACT 날짜의 년 월 일을 따로 구분하여 관리
select EXTRACT(year from sysdate) AS 년,
    EXTRACT(month from sysdate) AS 월,
    EXTRACT(day from sysdate) AS 일,
    EXTRACT(hour from CAST(sysdate as timestamp)) AS 시,
    EXTRACT(minute from CAST(sysdate as timestamp)) AS 분,
    EXTRACT(second from CAST(sysdate as timestamp)) AS 초
from dual;


--TO_CHAR 문자열로 변경해주는 함수
--변경시 문자 기호
-- yyyy, yy (연도 4자리, 2자리)
-- month: locale 설정에 맞게 출력
-- mm: 월을 숫자로 표현
-- mon: 월을 알파벳으로 표현
-- dd: 날짜를 표현
-- d: 요일 수자로 표현
-- dy: 요일을 약어로 표현: 월화수목금토일
-- day: 요일 (예: 월요일)
-- hh: 시간, hh24: 24시간, hh12: 12시간
-- mi: 분
-- si: 초
select TO_CHAR(
sysdate, 'yyyy-mm-dd day hh24:mi:ss') from dual;

select TO_CHAR(
sysdate-1, 'yyyy-mm-dd dy hh24:mi:ss') from dual;

select TO_CHAR(
sysdate+1, 'yyyy-mm-dd dy hh24:mi:ss') from dual;

select emp_name,hire_date,
TO_CHAR(hire_date, 'yyyy/mm/dd hh24:mi:ss') from employee;

select emp_name, TO_CHAR(hire_date, 'yyyy-mm-dd(dy)') from employee;


--문자열로 변경시 포멧형식
--, comma 형식으로 변환(3째자리에 , 붙이기) : 1,900,000
--. period 소숫점 형식으로 변환: 3.1415
--9 해당자리의 숫자의미: 값이 없을경우 소숫점 이상은 공백, 
--      소수점이하는 0
--0 해당자리의 숫자의미: 값이 없을경우 0으로 무조건 표시,
--      숫자를 고정적으로 표시할 경우
--$ 통화 표시(돈) : 달러$ 표시
--L 로컬통화로 표시 (예: 원화표시)
select TO_CHAR(123456, '999,999,999') from dual; --123,456

select TO_CHAR(123456, '000,000,000') from dual; --000,123,456

select TO_CHAR(123456, '99,999') from dual; --#######

select TO_CHAR(34.56, '$99.99') from dual;

select TO_CHAR(34.56, 'L99.99') from dual;

select TO_CHAR(1234.56, '99999.9999') from dual;

select TO_CHAR(1234.56, '00000.0000') from dual;

--1.salary를 원화표시로 쉼표 바꿔서
--2.연봉을 계산하여 원화표시로
select emp_name, TO_CHAR(salary, 'L999,999,999') AS 월급,
    TO_CHAR(12*salary, 'L999,999,999,999') AS 연봉
from employee;

--TO_DATE: 날짜형식으로 변환
-- 작성법: TO_DATE(char, format): 문자를 날짜로 변경
--      TO_DATE(number, format): 숫자를 날짜로 변경
--  시간까지 날짜로 변경가능
select TO_CHAR(
TO_DATE('19500101 15:30:20', 'yyyymmdd hh24:mi:ss'),
'yyyymmdd hh24:mi:ss')
    AS 생신 from dual;

select TO_CHAR(hire_date, 'yyyymmdd hh24:mi:ss')
from employee
where hire_date > '00/01/01';
--where hire_date > TO_DATE('20000101', 'yyyymmdd');

--숫자 날짜로 전환
select TO_DATE(19960626, 'yyyy-mm-dd') from dual;

--ERROR! 주의! 앞에 0이 들어가는 연도가 나오면 안됨
select TO_DATE(010224, 'yy-mm-dd') from dual;
--OK!
select TO_DATE('010224', 'yy-mm-dd') from dual;

--DECODE 조건문 (switch문과 비슷)
-- 사용법: decode(조건식,
--                  조건1, 조건1결과,
--                  ...
--                  조건n, 조건n결과,
--                  default)
select emp_name, emp_no,
    DECODE( substr(emp_no,8, 1),
        '1', '남', '2', '여',
        '3', '남', '4', '여') AS 성별
from employee;

--dept_code: D1이면
select emp_name AS 사원명,
    nvl(dept_code,'NULL') AS 부서코드,
    DECODE(dept_code,
        'D1', '인사관리',
        'D2', '회계관리',
        'D3', '마케팅',
        'D4', '국내영업',
        'D5', '해외영업1',
        'D6', '해외영업2',
        'D8', '기술지원',
        'D9', '총무',
        '부서없음') AS 부서명
from employee;

select emp_name AS 사원명,
    nvl(dept_code, 'NULL') AS 부서코드,
    CASE WHEN dept_code='D1' THEN '인사관리'
        WHEN dept_code='D2' THEN '회계관리'
        WHEN dept_code='D3' THEN '마케팅'
        WHEN dept_code='D4' THEN '국내영업'
        WHEN dept_code='D5' THEN '해외영업1'
        WHEN dept_code='D6' THEN '해외영업2'
        WHEN dept_code='D8' THEN '기술지원'
        WHEN dept_code='D9' THEN '총무'
    ELSE '부서없음' END AS 부서명
from employee;

select emp_name AS 사원명, emp_no AS 주민등록번호,
    CASE
        WHEN substr(emp_no, 8,1)=1 THEN '남'
        ELSE '여' END AS 성별
from employee;

insert into employee values(
    '250', '고두밋', '470808-2123341', 'go@kh.or.kr', 
    null, 'D2', 'J2', 'S5', 448000, null, null, 
    TO_DATE('94/01/20', 'rr/mm/dd'), null, 'N');

commit;

select emp_id AS 사원번호, 
    emp_name AS 사원명,
    RPAD(substr(emp_no, 1,8), 13, '*') AS 주민번호,
    CASE WHEN substr(emp_no, 8,1) in (1,3) THEN '남'
        WHEN substr(emp_no, 8,1) in (2,4) THEN '여'
    ELSE '?' END AS 성별,
    EXTRACT(year from sysdate) 
        - EXTRACT(year from TO_DATE(substr(emp_no, 1,2), 'RR')) + 1 AS 나이,
    TO_NUMBER(EXTRACT(year from sysdate))- 
        TO_NUMBER(substr(emp_no,1,2) + 
            CASE WHEN substr(emp_no,8,1) in(1,2) THEN 1900
                    ELSE 2000 END) + 1 AS 현재나이
from employee
order by 현재나이 DESC;
-- yy는 20이 붙음(현재 세기).  rr로 변환
-- rr은 1950 이전에 태어난 사람은 계산오류 
--      ex) 고두미 2019 - (1947->2047) + 1 = -27
--      rr은 50보다 작으면 '20xx' 50보다 크면 '19xx'
-- 날짜의 연도는 yy 두글자만 가져올때,
--      YY: 현재 세기로 계산 (99 -> 2099)
--      RR: 
--    TO_CHAR(sysdate, 'yyyy')- CONCAT(19,substr(emp_no,1,2)) +1 AS 나이


--RR 변환 공식
--현재연도   입력연도  계산연도
-------------------------------
--  00~49      00~49   현재세기
--  00~49      50~99   전세기
--  50~99      00~49   다음세기
--  50~99      50~99   현재세기

select TO_DATE('880101', 'RR') from dual;

--그룹함수
--COUNT, MAX, SUM, AVG,
--result 셋이 한개의 row로 되어 있기 때문에,
--  컬럼을 선택할 수 없다.
select emp_name, SUM(salary) from employee
--where substr(emp_no, 8,1) in (1,3);
where emp_name like '유__'
GROUP BY emp_name;

select SUM(salary*12) AS 연봉,
    SUM(12*salary*(1-.03 +nvl(bonus,0))) AS 실수령액
from employee;

--null 값은 sum에서 자동으로 제외
select SUM(bonus) from employee;

select bonus from employee
where bonus is not null;

--null이면 보너스 합계를 나눌 사원 명수도 달라지므로
--값에 차이가 남
select ROUND(avg(bonus), 3), ROUND(AVG(nvl(bonus, 0)),3) from employee;

select ROUND(avg(bonus), 3) from employee
where bonus is not null;

--테이블 전체 행 수
--count(컬럼명 or *)
select COUNT(*) from employee
where dept_code='D9';

select COUNT(*) from employee
where salary >= 3000000;

select COUNT(emp_name) from employee;

--dept_code null값은 빼버림
select COUNT(dept_code) from employee;
select COUNT(*) from employee where dept_code is not null;

select COUNT(distinct dept_code) from employee;

select MAX(salary), MIN(salary) from employee;

select MAX(hire_date), MIN(hire_date) from employee;

--GROUP BY
--부서별 월급의 평균
select dept_code, FLOOR(AVG(salary)) from employee
GROUP BY dept_code
HAVING dept_code='D5';

--group by 선언하면 그 그룹으로 계산되는 그룹함수를 사용가능
select dept_code, count(dept_code), sum(salary),
floor(avg(salary)), min(salary)
from employee
GROUP BY dept_code
HAVING dept_code IS NOT NULL
order by dept_code;

--성별컬럼으로 남여 평균월급, 합계 인원수
select CASE WHEN substr(emp_no, 8,1)=1 then '남'
            ELSE '여'
           END AS GENDER,
       COUNT(*) AS 인원수,
       TO_CHAR(sum(salary), 'L999,999,999') AS 월급합계,
       TO_CHAR(FLOOR(AVG(salary)), 'L999,999,999') AS 월급평균
from employee
GROUP BY 
        CASE WHEN substr(emp_no, 8,1)=1 THEN '남'
        ELSE '여'
END;

--dept_code를 기준으로 salary 합계와 평균
--WHERE절에는 그룹함수 쓸수 없음.
--HAVING절에 그룹함수 조건 가능
select job_code,
    sum(salary) AS 월급총액,
    FLOOR(avg(salary)) AS 월급평균
from employee
where dept_code is not NULL
GROUP BY job_code
HAVING sum(salary) > 9000000
ORDER BY job_code;

--부서인원수가 4명이상인 부서만
select dept_code, count(*)
    from employee
where dept_code is not null
GROUP BY dept_code
HAVING count(*) >= 4
order by dept_code;

--GROUP BY로 묶인 합 뿐아니라
--그룹집계 함수 ROLLUP CUBE로 그룹에 대한 총합계 구함
--두개이상 컬럼을 GROUP BY 하면 CUBE는 

select dept_code, sum(salary)
from employee
GROUP BY dept_code
order by 1;

select dept_code, sum(salary)
from employee
GROUP BY ROLLUP(dept_code)
order by 1;

--두개 컬럼에 대한 총계를 계산
--합계는 앞에 있는 dept_code를 기준으로 묶음
select dept_code, job_code, sum(salary)
from employee
GROUP BY ROLLUP(dept_code, job_code)
order by 1;
--D1 J7이 묶인 row가 한개의 그룹이 됨
--(dept_code, job_code)가 그룹이 됨
--job_code=null 인것은 dept_code에 대한 합계
--다만 
--dept_code is null: 인것은 
--	J6	2320000
--	J7	2890000

select job_code, dept_code, sum(salary)
from employee
GROUP BY ROLLUP(job_code, dept_code)
order by 1;

--부서별 인원 정보를 출력하는데, 총인원까지 출력
select dept_code, count(*) AS 인원
from employee
GROUP BY ROLLUP(dept_code);
--GROUP BY CUBE(dept_code); --단일행 group 일때는 CUBE하고 같은결과

--부서별, 직급별 인원수 출력하고 부서별 소계전체 총계를 출력
select dept_code, job_code, 
    count(*) AS 인원수,
    sum(salary) AS 월급합계
from employee
GROUP BY ROLLUP(dept_code, job_code)
order by 1;

--CUBE는 한개 그룹만 처리할때는 ROLLUP과 결과 동일
--  두개 이상 컬럼이 그룹으로 설정될 경우 추가로
--  두번째 이상 컬럼 기준으로 합계도 전부 구함
-- 1.job_code 기준으로 Group + 합계
-- 2.dept_code기준 Group,
-- 3.(job_code,dept_code) 기준 Group


select dept_code, job_code,
    count(*) AS 인원수, 
    sum(salary) AS 월급합계
from employee
GROUP BY CUBE(dept_code, job_code)
order by 1;
-- (null)   J6	1	2320000  --dept_code NULL인 행
-- (null)   J6	6	15746240 --job_code=6인 행의 합계

--D1   NULL   3	7820000
--D2   NULL   4	6968000
--D5   NULL   6	15760000
--D6   NULL   3	10100000
--D8   NULL   3	6986240
--D9   NULL   3	17700000
--NULL NULL   2	5210000 --DEPT_CODE=NULL인 행
--
--NULL J1     1	 8000000
--NULL J2     3	 10148000
--NULL J3	  3	 10800000
--NULL J4	  4	 9320000
--NULL J5	  3  8460000
--NULL J6	  6	 15746240
--NULL J7	  4	 8070000
--NULL NULL   24 70544240

--GROUP별 함수
select dept_code, job_code,
count(*) AS 인원수,
sum(salary) AS 총월급,
CASE
    WHEN GROUPING(dept_code)=0 AND GROUPING(job_code)=1
        THEN '부서별합계'
    WHEN GROUPING(dept_code)=1 AND GROUPING(job_code)=0
        THEN '직급별합계'
    WHEN GROUPING(dept_code)=1 AND GROUPING(job_code)=1
        THEN '총합계'
    WHEN GROUPING(dept_code)=0 AND GROUPING(job_code)=0
        THEN '그룹별 합계'
    ELSE '??' END
  AS "GROUPING"
from employee
GROUP BY CUBE(dept_code, job_code)
order by "GROUPING", 1, 2;

--집합 연산자 (set operation)
--UNION UNION ALL
-- 1.컬럼수 일치해야 2.자료형 일치해야
select emp_id, emp_name, dept_code, salary
    from employee
    where dept_code= 'D5'    
UNION
select emp_id, emp_name, dept_code, salary
    from employee
    where salary >= 3000000
order by dept_code;

--UNION
--컬럼 데이터는 꼭 컬럼명에 요구하는
--자료가 들어가지 않아도 됨:
--열의 개수와 자료형만 서로 같으면 UNION 가능
select emp_name, emp_no
from employee
where salary > 3000000
UNION
select dept_title, dept_id
from department;

--다른 컬럼들 UNION할떄 데이터 사이즈 
--큰값으로 캐스팅 되어 들어감
select dept_title, dept_id
from department
UNION
select emp_name, emp_no
from employee
where salary > 3000000;

--UNION ALL 중복값 모두 출력
select emp_id, emp_name, dept_code, salary
    from employee
    where dept_code= 'D5'
UNION ALL
select emp_id, emp_name, dept_code, salary
    from employee
    where salary >= 3000000
order by dept_code;

--INTERSECT: 두개이상의 result set의 중복값만 출력
select emp_id, emp_name , dept_code, salary
from employee
where dept_code = 'D5'
INTERSECT
select emp_id, emp_name , dept_code, salary
from employee
where salary > 3000000;

--MINUS: 두개 이상의 result set에서
--위 select 무에서 중복값을 빼버림
select emp_id, emp_name , dept_code, salary
from employee
where dept_code = 'D5'
MINUS
select emp_id, emp_name , dept_code, salary
from employee
where salary > 3000000;

--INTERSECT가 없으므로, 위에 select문 result 그대로 조회
select emp_id, emp_name , dept_code, salary
from employee
where dept_code = 'D8'
MINUS
select emp_id, emp_name , dept_code, salary
from employee
where salary > 3000000;

select dept_code
from employee
where dept_code = 'D8'
MINUS
select dept_id
from department;

--GROUPING SETS: GROUP BY 된 result 테이블을 합쳐 보여줌
--group by GROUPING SETS
--group by로 설정되어 있는 result set들을 결합하여 보여줌
--GROUPING SETS는 순서 상관없음
select dept_code, job_code, manager_id,
    count(*) AS 인원수,
    floor(AVG(salary))
from employee
group by GROUPING SETS(
    (dept_code, job_code, manager_id),
    (dept_code, manager_id),
    (job_code, manager_id)
)
order by 1 NULLS LAST, 2 NULLS LAST, 3 NULLS LAST;

--위에 GROUPING_SETS는 밑에 3개를 합친것
select dept_code, job_code, manager_id,
    count(*) AS 인원수,
    floor(AVG(salary))
from employee
group by dept_code, job_code, manager_id
order by 1,2;

select dept_code, manager_id,
    count(*) AS 인원수,
    floor(AVG(salary))
from employee
group by dept_code, manager_id
order by 1,2;

select job_code, manager_id,
    count(*) AS 인원수,
    floor(AVG(salary))
from employee
group by job_code, manager_id
order by 1,2;

--JOIN : 두개의 테이블을 결합하여, 한개의 테이블로 출력
--row 단위로 결합하기 때문에, 서로 맵핑되는 값이 필요함
--대부분의 경우 : 테이블1의 FOREGIN KEY와 
--                테이블2의 PRIMARY KEY가 연결됨

--1. 오라클 전용 INNER JOIN(or JOIN)
select emp_name, e.job_code, j.job_name
from employee e, job j
where e.job_code = j.job_code;

select e.emp_name, d.dept_id, d.dept_title
from employee e, department d
where dept_code = dept_id
order by 2,1;

--2. ANSI 표준 = SQL 표준 INNER JOIN
--(1). 컬럼명이 일치할때
--  select 컬럼1,...,컬럼n 
--  from 테이블1 JOIN 테이블2
--  USING 비교컬럼
--   where [조건]
select emp_id, emp_name, job_code, job_name
from employee
JOIN JOB USING(JOB_CODE);

--(2). 컬럼명이 다를때
--  select 컬럼1,...,컬럼n 
--  from 테이블1 JOIN 테이블2
--   on 비교컬럼1=비교컬럼2
--  where [조건]
select emp_name, job_name
from employee e JOIN job j 
    ON e.job_code = j.job_code;

select emp_name, dept_title
from employee INNER JOIN department 
    ON dept_code= dept_id
where dept_title='총무부';

--OUTER JOIN
--기준이 되는 값이랑 일치하는 값이 없으면 그 row를
--출력하지 않음.
--22개 출력됨: dept_code 가 null인 row 제외
select count(*) from employee
    JOIN department ON dept_code = dept_id;

--한쪽컬럼이 없어도(null), OUTER JOIN으로
--한쪽(LEFT, RIGHT)기준으로 한쪽은 모두 출력가능

--LEFT JOIN : 오른쪽 컬럼을 기준으로 
select emp_name, e.dept_code, dept_title
    from employee e LEFT JOIN department d
        ON e.dept_code = d.dept_id;

select emp_name, e.dept_code, dept_title
    from department d LEFT JOIN employee e
        ON e.dept_code = d.dept_id;

--RIGHT JOIN : 오른쪽 컬럼을 기준으로 
select emp_name, e.dept_code, dept_title
    from employee e RIGHT JOIN department d
        ON e.dept_code = d.dept_id;

select emp_name, e.dept_code, dept_title
    from department d RIGHT JOIN employee e
        ON e.dept_code = d.dept_id;

--오라클 OUTER 조인 방법
-- +없는것이 기준: LEFT JOIN
select emp_name, dept_code, dept_title, dept_id
from employee, department
where dept_code =dept_id(+);

--RIGHT JOIN
select emp_name, dept_code, dept_title, dept_id
from employee, department
where dept_code(+) =dept_id;

--FULL JOIN : 일치되는것이 없어도
--양쪽 테이블 데이터 모두 출력
select emp_name, dept_code, dept_title, dept_id
from employee FULL JOIN department 
        ON dept_code=dept_id;

--CARTESIAN product (NOT USED OFTEN)
--28 * 9
select emp_name, dept_code, dept_title, dept_id
from employee, department
order by 1,3;
--from employee department;
--각각의 row기 결과됨

--NON-EQUAL JOIN: 동등비교가 아니라, 값크기 비교로 조인
select * from sal_grade;

select emp_name, salary, s.sal_level, s.min_sal, s.max_sal
from employee JOIN sal_grade s
    ON (salary between min_sal and max_sal);

--SELF JOIN: 본인 테이블을 본인참조하여 연결하는 것
--  자기 테이블의 컬럼값(구분되는)을 갖고있는 컬럼이 존재해야함
-- employee : emp_id = manager_id
--1. SELF INNER JOIN
select E.emp_id, 
    E.emp_name 사원이름, 
    E.dept_code, 
    E.manager_ID 매니져,
    M.emp_name AS 매니져이름
from employee E JOIN employee M
    ON E.manager_id = M.emp_id;

--2. SELF OUTER JOIN
--    M 매니져 데이터 NULL인것도 출력되도록
select E.emp_id, 
    E.emp_name 사원이름, 
    E.dept_code, 
    E.manager_ID 매니져,
    M.emp_name AS 매니져이름
from employee E LEFT JOIN employee M
    ON E.manager_id = M.emp_id;
--where E.emp_name = '선동일';

--  manager_id가 100인 잘못된 데이터!
--  FOREIGN_KEY로 설정하면 100 자체가 안나오게 가능

--다중조인: 테이블을 두개이상 결합하는 것을 의미한다
--  from 절에 join구문을 계속 사용하면 됨
--  join을 할때 연결되는 컬럼이 반드시 이전에 결합된 테이블에 존재
select E.emp_id, nvl(D.dept_title, '인턴') dept, 
    E.dept_code,
    J.job_name,
    E.job_code,
    E.emp_name,
    L.local_name
from employee E
    LEFT JOIN department D ON(E.dept_code=D.dept_id)
    JOIN location L ON D.location_id = L.local_code
    JOIN job J ON E.job_code = J.job_code;
--    JOIN job J USING (job_code);

--직급이 대리이면서, ASIA지역에 근무하는 직원을 조회
--사번, 이름, 직급명, 부서명, 근무지역명, 급여
select E.emp_id, E.emp_name, J.job_name,
    nvl(D.dept_title, '사원'), L.local_name, E.salary
from employee E 
    LEFT JOIN department D ON (E.dept_code=D.dept_id)
    JOIN location L ON(D.location_id=L.local_code)
    JOIN job J ON (E.job_code = J.job_code)
where L.local_name = 'ASIA1';

--주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원
--사원명, 주민번호, 부서명, 직급명
select E.emp_name, E.emp_id, D.dept_title, J.job_name
from employee E 
    JOIN department D ON (E.dept_code = D.dept_id)
    JOIN job J ON E.job_code = J.job_code;

--이름에 '형'자가 들어가는 직원
--사번, 사원명, 부서명
select E.emp_id, E.emp_name, D.dept_title
from employee E
    JOIN department D ON E.dept_code = D.dept_id
where E.emp_name like '%형%';

--해외영업부에 근무하는 직원
--사원명, 직급명, 부서코드, 부서명
select E.emp_name, J.job_name, E.dept_code, D.dept_title
from employee E
    JOIN job J ON E.job_code = J.job_code
    JOIN department D ON E.dept_code = D.dept_id
where D.dept_title like '%해외영업%';
    
--보너스를 받는 직원
--사원명, 보너스, 부서명, 근무지역명
select E.emp_name, E.bonus, D.dept_title, L.local_name
from employee E
    JOIN department D ON E.dept_code = D.dept_id
    JOIN location L ON D.location_id= L.local_code
where E.bonus IS NOT NULL;

--부서코드가 D2인 직원
--사원명, 직급명, 부서명, 근무지역명
select E.emp_name, J.job_name, E.dept_code, D.dept_title, L.local_name
from employee E
    JOIN job J ON E.job_code = J.job_code
    JOIN department D ON E.dept_code = D.dept_id
    JOIN location L ON D.location_id = L.local_code
where E.dept_code = 'D2';

--급여등급테이블의 최대급여(MAX_SAL)보다 많이 받는 직원들
--사원명, 직급명, 급여, 연봉
select E.emp_name, J.job_name, E.salary, 12*E.salary AS 연봉
from employee E
    JOIN job J ON E.job_code = J.job_code
where e.salary > (select MAX(salary) from  employee);

--한국(KO)와 일본(JP)에 근무하는 직원
--사원명,부서명, 지역명, 국가명
select E.emp_name, D.dept_title, L.local_name, L.national_code
from employee E
    JOIN department D ON E.dept_code = D.dept_id
    JOIN location L ON D.location_id = L.local_code;

--같은부서에 근무하는 직원(self join)
--사원명, 부서명, 동료이름
select distinct E1.emp_name 사원명,
    D.dept_title 부서명,
    E2.emp_name 동료명
from employee E1
    JOIN employee E2 USING(dept_code)
    JOIN department D ON dept_code = D.dept_id
where E1.emp_name != E2.emp_name;

--보너스가 없는 직원 중 직급이 차장과 사원인 직원
--사원명, 직급명, 급여조회 join, in 사용
select E.emp_name, D.dept_title, J.job_name, E.salary
from employee E
    JOIN department D ON E.dept_code = D.dept_id
    JOIN job J ON E.job_code = J.job_code
where J.job_name IN ('차장', '사원');

--재직중인 직원과 퇴사한 직원의 수
select CASE WHEN ent_yn ='N'
            THEN '재직중' ELSE '퇴사' END AS 재직여부,
        count(*) AS "인원(명)"
from employee
GROUP BY CASE WHEN ent_yn ='N'
        THEN '재직중' ELSE '퇴사' END;

--SUBQUERY 서브쿼리

--단일행 서브쿼리
select dept_id, dept_title
from department
where dept_id=
    (select dept_id from department where dept_title='해외영업1부');

select emp_name, salary, dept_code from employee
where salary > (select avg(salary) from employee);

select emp_name, dept_code, salary
from employee
where dept_code = (select dept_id 
                    from department where dept_title='총무부')
    and salary > (select AVG(salary) from employee);

--다중행 서브쿼리 : result set의 행이 여러행인 경우
--  송중기 박나래와 같은부서인 직원들
select emp_name, dept_code, salary
from employee
where dept_code in (select dept_code from employee 
    where emp_name in ('송종기', '박나라'));


--다중열 서브쿼리: select문에서 컬럼을 다수선택하는 경우
--비교대상도 1:1매칭이 되야 한다.
--  퇴사한 여직원과 같은 직급, 같은 부서인 사원
select emp_name, emp_no, job_code, dept_code, ent_yn
from employee 
where (job_code, dept_code) IN
    (select job_code, dept_code from employee where
        substr(emp_no, 8,1) in (2,4) and ent_yn='Y');

--다중열 다중서브쿼리: 서브쿼리의 result set의
--  결과 row가 2개이상, column도 2개이상의 결과를 가지는 
--  select문을 사용 했을때.
--  직급별 최소급여를 받는 직원의
--  사번 이름 직급 급여 조회
select emp_id, emp_name, job_code, salary
from employee where (job_code, salary) in
    (select job_code, MIN(salary)
        from employee group by job_code)
order by job_code;


--다중행 서브쿼리로 대소비교 할때 ANY, ALL


--ALL: 서브쿼리에 결과중 하나라도 참이면 참이다.
--  x>ANY(subquery) 어떤값보다 크기만 하면 참

--최소값보다 크면 됨
select emp_name, salary from employee 
where salary > ANY(select min(salary) from employee);

select emp_name, salary from employee 
where salary = ANY(select salary from employee);

--최대값보다만 작으면 됨
select emp_name, salary from employee 
where salary < ANY(select salary from employee);

--ALL: 서브쿼리의 결과값 모두 참이면 참
-- X > ALL : 서브쿼리의 모든 값보다 크면 참
--      최대값보다 크면 참.
-- X < ALL : 서브쿼리의 모든 값보다 작으면 참
--      최소값보다 작으면 참.
select emp_name, salary from employee 
where salary > ALL(select min(salary) from employee
                    HAVING min(salary) < 6000000);

--상관 서브쿼리: MAIN select문과 subselect문이 서로 결과에 영향을 주는것
--매니져 아이디 있는 직원만 return
--기준값 E.manager_id에 대응되는 값이 EXIST인경우 출력 M.emp_id IS NOT NULL
select emp_id, emp_name, manager_id
from employee E
where EXISTS(select * from employee M
                where E.manager_id = M.emp_id);
                
--기준값 E.manager_id에 대응되는 값이 NOT EXIST인경우 출력 M.emp_id IS NULL
select emp_id, emp_name, manager_id
from employee E
where NOT EXISTS(select * from employee M
                where E.manager_id = M.emp_id);



--심봉선 사원과 같은 부서의 사원의 
--부서코드, 사원명, 월평균급여조회
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

--???
--가장많은 급여를 받는 사원을 exists 상관서브쿼리를 이용하여 구하여라
select emp_name, salary
from employee E1
where EXISTS
(select salary from employee E2 
where E1.salary >=E2.salary);

--NONEXISTS 이용
--윤은혜와 급여가 같은 사원들을 검색해서, 사번, 사원이름, 급여출력
select emp_id, emp_name, salary
from employee E1
where exists (select * from employee E2
            where E1.salary = E2.salary and E2.emp_name = '윤은해');

--EMPLOYEE테이블에서 기본급여 제일 많은 사람과 제일적은 사람의 정보를 
--사번,사원명,월급출력
select emp_id, emp_name, salary
from employee E1
where salary in (max(salary), max(salary));

--D1,D2부서에 근무하는 사원들 중에서 기본급여가 D5부서 직원들의 평균월급보다 
--많은 사람들만 부서번호, 사번,사원명, 월급출력
select dept_code, emp_id, emp_name, salary
from employee 
where dept_code in('D1','D2')
    and salary > (select AVG(salary) from employee where dept_code='D5');

--차태현 전지연 사원의 급여등급과 같은 사원의 직급명, 사원명 출력
select job_code, emp_name, sal_level
from employee E1 where sal_level in 
    (select sal_level from employee E2
        where E2.emp_name in ('차태연','전지연'));

--직급이 대표, 부사장이 아닌 모든 사원을 부서별로 출력
select emp_name, dept_code, job_code, J.job_name
from employee E
JOIN job J USING(job_code)
where J.job_name Not in ('대표', '부사장')
order by dept_code;

--ASIA1지역에 근무하는 사원정보출력 부서코드, 사원명(서브쿼리이용)
select dept_code, emp_name, location_id
from employee
JOIN department ON dept_code= dept_id
where location_id =
(select location_id from location where local_name='ASIA1');

--2000년1월1일 이전 입자사중에 2000년1월1일이후 입사자보다 급여을 (가장높게
--받는사원보다) 적게 받는 사원의 사원명과 월급여를 출력
select emp_name, salary from employee E1
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
select emp_name, dept_code
from employee E Join department D ON E.dept_code = D.dept_id;


--기술지원부이면서 급여가 2000000인 사원의 
--사원명, 부서코드, 급여출력

--부서별 최대급여를 받는 사원의 
--사원명, 부서명, 급여를 출력

--직급이 J1, J2, J3이 아닌 사원중에서 
--자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드, 사원명, 급여, 부서별 급여평균
