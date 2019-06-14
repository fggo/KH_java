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
--사용법 자료형 (길이)
--char(10) 10 byte 만큼 저장이 되는 공간. 무조건 10byte 다 사용
--	남은 공간은 whitespace로 채워짐
--varchar2(10) 10 byte만큼 저장이 되는 공간, 대입되는 값의
--	크기에 따라 사용 공간이 정해짐
--	오라클 express버젼에서 한글은 3byte로 처리됨
--	한글 4글자 이상 ERROR
--nchar(10) nvarchar(10) 글자수 설정 10글자 만큼 저장되는
--	공간 확보

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

insert into datetest 
values('19/06/13', '00/02/24', '19/06/13 11:15:00');

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
	watchname	varchar2(40),
	description 	varchar2(200)
);

insert into tbl_escape_watch
values('금시계', '순금 99.99% 함유 고급시계');

insert into tbl_escape_watch
values('은시계', '고객만족도 99.99점을 획득한 고급시계');

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
select 'zzzzzzkhzzzz' , 
	TRIM(leading 'za' from 'zzzzzkhzzzz') from dual;

select 'zzzzzzkhzzzz' , 
	TRIM(leading 'z' from 'zzzzzkhzzzz') from dual;
select 'zzzzzzkhzzzz' , 
	TRIM(trailing 'z' from 'zzzzzkhzzzz') from dual;
select 'zzzzzzkhzzzz' , 
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

create table tbl_files
(fileno number(3), filepath varchar2(500));

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
select sysdate AS 입대일, add_months(sysdate, 18) AS 제대일,
add_months(sysdate,18) - sysdate AS 군생활일수, 
(add_months(sysdate,18) - sysdate) * 3 AS 짬밥수
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
