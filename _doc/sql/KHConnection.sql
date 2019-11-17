select * from employee;
select * from department;
select * from job;

--200	선동일	621235-1985634	sun_di@kh.or.kr	01099546325	D9	J1	S1	8000000	0.3		90/02/06
--222	이태림	760918-2854697	lee_tr@kh.or.kr	01033000002	D8	J6	S5	2436240	0.35	100	97/09/12
--904	서현희	910804-2123412				J3	S1				
--905	M0NK	980101-1111222	monk@bb.com	01011112222	D1	J1	S1	99822201	0.5	200	19/07/01
--906	BABA	911111-1122333	BABA@baba.com	01011111111	D2	J2	S2	800000	0.7	201	19/07/06
--909	abb	2929292-2     	dsadsa	1001223	O2	O2	O2	9002202	0.6	200	19/07/07

--D1	인사관리부	L1
--D2	회계관리부	L1
--D3	마케팅부	L1
--D4	국내영업부	L1
--D5	해외영업1부	L2
--D6	해외영업2부	L3
--D7	해외영업3부	L4
--D8	기술지원부	L5
--D9	총무부	L1

--J1	대표
--J2	부사장
--J3	부장
--J4	차장
--J5	과장
--J6	대리
--J7	사원

select * from user_cons_columns where table_name='EMPLOYEE';
select * from user_constraints where table_name='EMPLOYEE';


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

--날짜의 산술 연산
select sysdate-1 어제, sysdate 오늘, sysdate+1 내일 from dual;

select to_char(sysdate, 'mm-dd-yyyy hh24:mi:ss') "NOW" from dual;

--날짜와 날짜끼리의 산술 연산
--일수(int) 값으로 출력
select sysdate - to_date('19990224', 'yyyymmdd') from dual;
select sysdate - to_date('19990224') from dual;

--시간까지 출력
select systimestamp from dual;

select to_date('19990224', 'yyyy-mm-dd') from dual;

create table datetest(
    today date,
    birthday date,
    temp timestamp);

insert into datetest values(
        '19/06/13', '00/02/24', '19/06/13 11:15:00');
insert into datetest values(
        to_date('20190613'), to_date('19990224'), to_timestamp('20190613111500'));
    
select * from datetest;

--테이블 컬럼의 자료형을 확인하고 싶을때
DESC chartest;
DESC datetest;

create table member_table (
    id CHAR(15), --변동x 6-15자리
    password VARCHAR2(15), --8-15자리
    name VARCHAR2(15), --한글입력
    phone NUMBER(11), --핸드폰 -없이
    ssn NUMBER(13), --주민번호
    mileage NUMBER, --마일리지
    reg_date DATE);

select * from member_table;

-- 테이블에 있는 데이터 조회하기
-- 명령어 select
-- 명령구조 select 컬럼1,...,컬럼n from 테이블명 where 검색조건
select emp_name, email, ent_date from kh.employee;
select emp_name, email, ent_date from employee;

select dept_id, dept_title from department;

--select 문에서는 산술 연산도 가능
--연산을 하기 위해서는 연산식의 컬럼명이 들어가는 곳에서
--연산을 해주면 그 연산 명이 컬럼명이 되고, 계산된 값이
--각 row에 들어간다.

--ERROR
select emp_name, salary, email*12 from employee;

--%함수 없음. MOD이용
--select bonus %12 from employee; --ERROR
select MOD(salary, 12) from employee;

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
select distinct dept_code from employee;

--(dept_code, job_code)를 한개 데이터로 distinct인 것을 select
select distinct dept_code, job_code from employee;

--비교 연산자: where clause filters resultset
--select 컬럼1,...,컬럼n from 테이블명 where 컬럼명 비교연산자 값;
select * from employee where job_code = 'J5';

select emp_name, salary, hire_date, phone from employee
    where sal_level='S1';

select emp_name, salary,
    12*salary*(1+nvl(bonus, 0)-.03) AS 실수령액
from employee
where 12*salary*(1-.03 + nvl(bonus,0)) > 50000000;

--논리연산자 사용하기 AND/OR
select * from employee
    where dept_code != 'D6' AND salary >= 3000000;

select emp_name, hire_date, salary from employee
    where job_code='J3' OR sal_level='S5';

--비교연산자를 여러개
select * from employee where dept_code='D5' AND hire_date >'02/01/01';

select distinct sal_level from employee
where job_code ^= 'J1'; --job_code != 'J1'

select emp_no || emp_name || email from employee;
select emp_name ||'님 '|| salary || '원' from employee;

select emp_name, salary from employee
where salary between 3500000 and 6000000;
--where salary >=3500000 and salary <= 6000000;

select emp_name, dept_code, hire_date from employee
    where salary not between 3500000 and 6000000;

select emp_name, hire_date, dept_code, salary from employee
    where hire_date between '90/01/01' and '01/01/01';
--where hire_date >= '90/01/01' and hire_date <='01/01/01';

--LIKE 문자 패턴이용하여 검색
select * from employee where emp_name like '%희';

-- 언더바는 자릿수 표시
select * from employee where emp_name like '__희';

-- email 세번째 자리가 'n'인 사람
select * from employee where email like '__n%';

select * from employee where emp_name like '__석';

select * from employee where emp_name like '_옹_';
    
select * from employee where emp_name like '%이%';

--ESCAPE CHARACTER
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

--description에 '99.99%' 라는 말이 들어가 있는 행만 추출하세요
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

select * from employee where job_code in ('J3', 'J2');
-- job_code ='J3' or job_code='J2';

select emp_name, job_code from employee
where job_code in (select job_code from employee
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

--order by는 마지막에 작성 ASC(디폴트), DESC;
--기본적으로 primary key로 정렬됨
--order by 컬럼1, 컬럼2;
select * from employee order by emp_name desc;

--null을 order by ASC 했을때 null은 맨뒤로
select emp_name, salary, bonus from employee
order by bonus DESC;

-- null의 변경순서를 변경하고 싶을, nulls 옵션 사용
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
select length(emp_name), lengthb(emp_name),
       length(email), lengthb(email)
from employee;

select length('바바바') from dual;
select lengthb('바바바') from dual;

--INSTR(문자, 찾는문자, +/-방향몇칸, 몇번째문자인지)
--매개 변수로 들어온 문자에서 특정문자의 위치를 찾을때
select INSTR('monkkky', 'k') from dual;
select INSTR('monkkkaaakay', 'k', -4, 2) from dual;
select INSTR('monkkkaaakay', 'a', -4, 2) from dual;
select INSTR('monkkkaaakay', 'a', 1, 1) from dual;

select email, INSTR(email, '_') from employee;

select email, substr(email, 1, instr(email, '@') -1) from employee;

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

--다른 컬럼들 UNION할 데이터 사이즈 
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
select e.emp_name, e.dept_code, d.dept_title
    from employee e LEFT JOIN department d
        ON e.dept_code = d.dept_id;

select d.dept_title, e.dept_code, e.emp_name
    from department d LEFT JOIN employee e
        ON e.dept_code = d.dept_id;

--RIGHT JOIN : 오른쪽 컬럼을 기준으로 
select e.emp_name, e.dept_code, d.dept_title
    from employee e RIGHT JOIN department d
        ON e.dept_code = d.dept_id;

select d.dept_title, e.emp_name, e.dept_code
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
select emp_name, salary, s.sal_level, s.min_sal, s.max_sal
from employee JOIN sal_grade s
    ON (salary between min_sal and max_sal);

--SELF JOIN: 본인 테이블을 본인참조하여 연결하는 것
--  자기 테이블의 컬럼값(구분되는)을 갖고있는 컬럼이 존재해야함
-- employee : emp_id = manager_id
--1. SELF INNER JOIN
select E.emp_id, E.emp_name 사원이름, E.dept_code, 
    E.manager_ID AS 매니져ID,
    M.emp_name AS 매니져이름
from employee E JOIN employee M
    ON E.manager_id = M.emp_id;

--2. SELF OUTER JOIN
--    M 매니져 데이터 NULL인것도 출력되도록
select E.emp_id, E.emp_name 사원이름, E.dept_code, 
    E.manager_ID 매니져, M.emp_name AS 매니져이름
from employee E LEFT JOIN employee M
    ON E.manager_id = M.emp_id;
--where E.emp_name = '선동일';

--  manager_id가 100인 잘못된 데이터!
--  FOREIGN KEY로 설정하면 100 자체가 안나오게 가능

--다중JOIN: 테이블을 두개이상 결합하는 것을 의미한다
--  from 절에 join구문을 계속 사용하면 됨
--  join을 할때 연결되는 컬럼이 반드시 이전에 결합된 테이블에 존재
select E.emp_id, nvl(D.dept_title, '인턴') 부서명, 
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


--SUBQUERY 서브쿼리
--  JOIN이 SUBQUERY보다 성능은 좋음

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


--직급이 J1, J2, J3이 아닌 사원중에서 
--자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드, 사원명, 급여, 부서별 급여평균
select E.dept_code, E.emp_name, E.salary, E2.AVG_SAL
from employee E
    JOIN ( select dept_code, ROUND(avg(salary)) AVG_SAL
            from employee
            group by dept_code) E2 ON (E.dept_code = E2.dept_code)
where EXISTS(select E3.dept_code, avg(E3.salary) from employee E3
        where E.dept_code = E3.dept_code
        group by E3.dept_code
        HAVING E.salary > avg(E3.salary))
    and E.job_code not in ('J1','J2','J3')
order by dept_code;


select E1.dept_code, emp_name, salary, E2.AVG_SAL
from employee E1
    JOIN ( select dept_code, 
                  round(avg(salary)) AS AVG_SAL
            from employee
        GROUP BY dept_code) E2 ON E1.dept_code = E2.dept_code
where job_code NOT IN ('J1', 'J2', 'J3')
    AND salary > E2.AVG_SAL
order by dept_code;


--스칼라 서브쿼리: 상관쿼리인데 그결과 result set이 무조건 한개만 있는것!
--AVG_SAL는 where절에서 접근 못함. select문은 마지막에 실행 되므로
--스칼라: sql에서 단일값을 갖는 데이터를 ㅡ칼라 라고 함.
--  사용: 1. select문의 column에서 사용가능
--        2. where절에서도 사용 가능
--        3. order by절에서도 사용 가능
select dept_code, emp_name, salary, 
    (select round(avg(salary))
        from employee E2
      where E1.dept_code = E2.dept_code) AS AVG_SAL
from employee E1
where E1.job_code NOT IN ('J1', 'J2', 'J3')
    and E1.salary > (select round(avg(salary))
                       from employee E2
                       where E1.dept_code = E2.dept_code)
order by dept_code;

--select문에 스칼라 서브쿼리 사용하기
--모든사원의 사번, 이름, 관리자사번, 관리자명 조회
select E.emp_id, E.emp_name, E.manager_id, M.emp_name
from employee E
    JOIN employee M ON E.mananger_id=M.emp_id;

--스칼라로 변환 (차이점: manager_id null이어도 null로 출력됨)
--(select 단일값 from 테이블)으로만 스칼라 서브쿼리 정의 가능
select emp_id, emp_name, manager_id, 
    nvl((select emp_id 
        from employee M 
      where E.manager_id = M.emp_id), '없음') AS 관리자명
from employee E;

--사원명, 부서코드, 부서명,부서별 평균임금을 서브쿼리를 이용해출력
select emp_name, dept_code, D.dept_title, 
    (select round(avg(salary))
        from employee E2
        where E2.dept_code = E1.dept_code) AS 부서별평균임금
from employee E1
   JOIN department D ON E1.dept_code=D.dept_id
order by dept_code;

--직급이 J1 아닌사원중 자신의 부서별 평균 급여보다 적은 급여받는 사원들
--부서코드, 사원명, 급여, 부서별 급여평균
select dept_code, emp_name, salary,
    (select round(avg(salary))
        from employee E2
        where E1.dept_code = E2.dept_code) AS 부서별급여평균
from employee E1
where E1.job_code <> 'J1'
    and E1.salary < (select round(avg(salary))
                        from employee E2
                        where E1.dept_code = E2.dept_code)
order by dept_code;

--스칼라 where절에 사용하기
--자신이 속한 직급의 평균급여보다 많이 받는 직원의 
--이름, 직급, 급여를 조회
select emp_name, J.job_name, salary
from  employee E1
    JOIN job J ON E1.job_code = J.job_code
where E1.salary > (select round(avg(salary))
                        from employee E2
                        where E1.job_code= E2.job_code)
order by E1.job_code;

--스칼라 서브쿼리를 order by에
--모든 직원의 사번, 이름, 소속부서 조회후, 부서명으로 오름차순
select emp_id, emp_name, dept_code
from employee E
order by (select dept_title from department D
            where E.dept_code = D.dept_id) DESC nulls last;

--서브쿼리를 FROM 절에 사용
select emp_id, emp_name, dept_code,
    DECODE(substr(emp_no,8,1), 1,'남', 2,'여') AS 성별
from employee
where substr(emp_no,8,1) in (1,3);

select * 
from (select emp_id AS 사번, emp_name AS 사원명, 
             dept_code AS 부서코드,
             DECODE(substr(emp_no,8,1), 1,'남', 2,'여') AS 성별
        from employee)
        --where emp_id like '20%');
where 성별='남' and 사번='200'; --컬럼명이 바뀜. where에 emp_id 사용불가

--INLINE VIEW
--Employee 테이블에서 1990년도에 입사한 사원의 
--사번, 사원명, 입사년도
select *
from (select emp_id, emp_name, EXTRACT(year from hire_date) AS 입사년도
        from employee
        where EXTRACT(year from hire_date) like '199_'
        order by emp_id, hire_date);
--where 입사년도 - 1990 between 0 and 9

--Employee 테이블에서 사원중 30, 40대인 여자사원의 
--사번, 부서명, 성별, 나이를 출력
select *
from (select emp_id, emp_name, dept_title, 
        DECODE(substr(emp_no,8,1), 1,'남',2,'여') AS 성별, 
        EXTRACT(year from sysdate)
            - TO_NUMBER(DECODE(substr(emp_no,8,1),1,19,2,19,20)
              || substr(emp_no,1,2)) + 1 AS 나이
        from employee E
            LEFT JOIN department D ON dept_code=dept_id)
where 성별='여'
    and substr(나이,1,1) in(3,4);
--and (trunc(나이/10)) in (3,4);

--WITH AS
--서브쿼리에 별칭 부여하여 그 별칭으로 서브쿼리를 사용하는 것
WITH TT AS(select emp_id, emp_name, salary 
            from employee
            order by salary desc)
select TT.emp_id, TT.emp_name, TT.salary 
    from TT;

--RANKING 순위를 조회하는 조회문을 알아보자.
--  월급많은 top3를 조회
--오라클이 테이블이면 제공하는 컬럼
--ROWNUM : 컬럼에 대해 자동으로 1~끝번까지 번호부여
--ROWID : row를 찾아갈 수 있게 해주는 주소값!
CREATE TABLE TEST(
    BOARDNO NUMBER,
    TITLE VARCHAR2(10),
    CONTENT VARCHAR2(200),
    WRITER VARCHAR2(10)
);

select ROWID, ROWNUM, boardno, title, content, writer from test;

--ROWNUM은 테이블 생성시 Insert순서대로 내부적으로 정해진 값. (변하지 않음)
--그러므로, order by에 의해 ROWNUM이 변하지 않는다.
--따라서 select * from (select ROWNUM R, ... from TABLE)
--다음 결과는 order by salary가 높은 순으로 출력되지 않는다.
select ROWNUM, emp_id, emp_name, salary
    from employee
where ROWNUM <=3
order by salary desc;

--ROWNUM 자동으로 숫자부여. 부여되는 시점은 FROM(서브쿼리)
--ORDER BY는 FROM 이후 마지막에 실행되므로
--INLINE VIEW로 미리 넣어둠
--하지만, ROWNUM은 1부터 row가 선택되면서 증가하므로, ROWNUM >=3는 결과 없음
select ROWNUM, E.*
from (select emp_id, emp_name, salary 
        from employee order by salary desc) E
where ROWNUM <=3;

--ERROR!
select ROWNUM, * from employee;
--OK!
select ROWNUM, EMPLOYEE.* from employee;

--D5부서에서 연봉 상위 3명의 정보출력
--순위, 사번, 사원명, 연봉
select ROWNUM, E.*
from (select emp_id, emp_name,
        TO_CHAR(12*salary, 'L999,999,999') AS 연봉
        from employee 
        where dept_code='D5' order by 연봉 DESC) E
where ROWNUM <=3;

--월급이 5등부터 10등까지
--사원명, 월급
--안나옴!! ROWNUM BETWEEN A and B (A=1아니면 출력안됨)
--NOT WORKING!
select ROWNUM, E.*
    from (select emp_name, salary
            from employee order by salary DESC) E
where ROWNUM between 5 and 10; --NOT SHOWING ANY RESULTS

--paging 처리시에 필수
--INLINE VIEW를 두번 써야함
--ROWNUM은쿼리결과가 selected될때 값이 부여됨,
--즉 where절이 끝나고나서 row가 선택되면서 부여되므로,
--row>N일때 (N>1) 

--When assigning ROWNUM to a row, 
--Oracle starts at 1 and only increments the value when a row 
--is selected; that is, when all conditions in the WHERE clause are met. 
--Since our condition requires that ROWNUM is greater than 2,
--no rows are selected and ROWNUM is never incremented beyond 1.
select *
from ( select ROWNUM RNUM, E.*
       from (select emp_name, salary
               from employee order by salary DESC) E
    )
where RNUM between 5 and 10;

--계층형 쿼리
--      조직도 구성, 메뉴, 답변형 게시판(댓글)
--  FROM 다음에 옵션 값을 등록해서 처리함
--  START WITH: 부모행(루트노드) 지정
--  CONNECT BY: 부모-자식관계 설정
--  PRIOR: START WITH 절에서 제시한 부모행의 기준컬럼을 지정
--  LEVEL: 계층정보를 나타내는 가상의 컬럼
-- 댓글 시스템 만들때 사용
select LEVEL, emp_id, emp_name, manager_id
from employee
start with emp_id=200
connect by prior emp_id = manager_id
order by LEVEL;

select LPAD(' ', (LEVEL-1)*5, ' ') || 
    EMP_NAME ||NVL2(MANAGER_ID, '(' || MANAGER_ID||')', '') AS 조직도
from employee
start with manager_id IS NULL
connect by prior emp_id=manager_id;

--RANK() 윈도우함수: 오라클이 제공하는 순위조회 함수
--  ROWNUM을 더 많이 씀.
select 순위, emp_name, salary
from (select emp_name, salary,
            RANK() OVER(order by salary desc) AS 순위
            from employee order by salary desc);

select 순위, emp_name, salary
from (select emp_name, salary,
            DENSE_RANK() OVER(order by salary desc) AS 순위
            from employee order by salary desc)
where 순위 between 5 and 10;

--DML
--  Manipulates Table Data
--      INSERT: add Row(s) to table
--      UPDATE: modify specific Row(s) and specific Column
--      DELETE: delete specific Row(s)

-- col(1~N) or ALL col(in order)
--INSERT into TABLE_NAME(COL1,... COLN)
--    VALUES(VAL1,...VALN);
--INSERT into TABLE_NAME
--    VALUES(VAL_1,...VAL_TOTALCOLNUM);

--oracle은 DEFAULT 명시해야됨, 
--mysql은 자동으로 디폴드값 대입함
INSERT INTO employee VALUES(
    900, '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01055569512',
    'D1', 'J8', 'S3', 4300000, 0.2, '200', SYSDATE, DEFAULT, DEFAULT);

INSERT INTO employee VALUES(
    901, '함지민', '781020-2123453', 'hamham@kh.or.kr', '01012341234',
    'D1', 'J4', 'S3', 4500000, DEFAULT, 
        (SELECT emp_id from employee where emp_name='이오리'), 
        SYSDATE, DEFAULT, DEFAULT);

INSERT INTO employee(emp_id, emp_name, emp_no, email, phone,
    dept_code, job_code, sal_level, salary, bonus, manager_id)
VALUES(903, '유병승', '000224-3123412', 'prince0324@naver.com',
        '01036446259', 'D2','J1','S1', '99900000', 0.8, '200');

select * from employee where emp_name in('장채현', '함지민', '유병승');

COMMIT;
 
--NOT NULL CONSTRAINTS : 
--  "SAL_LEVEL" IS NOT NULL
--  "JOB_CODE" IS NOT NULL
--  "EMP_NO" IS NOT NULL
--  "EMP_NAME" IS NOT NULL
--  "EMP_ID" IS NOT NULL
INSERT INTO employee(emp_id, emp_name, emp_no, sal_level, job_code)
    VALUES(904, '서현희', '910804-2123412', 'S1', 'J3');

--INSERT문에 서브쿼리 이용하기
CREATE TABLE emp_01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    EMP_TITLE VARCHAR2(20));

INSERT INTO emp_01 VALUES(999, '유병승', '대표이사');

INSERT INTO emp_01( select emp_id, emp_name, J.job_name
    from employee E JOIN job J ON E.job_code = J.job_code);

select * from emp_01;

--CREATE은 자동 COMMIT 됨
CREATE TABLE emp_hire_date(
    emp_id NUMBER,
    emp_name VARCHAR2(30),
    hire_date DATE);

CREATE TABLE emp_manager(
    emp_id NUMBER,
    emp_name VARCHAR2(30),
    manager_id NUMBER);

--INSERT using sub-query
INSERT INTO emp_hire_date( select emp_id, emp_name, hire_date
                            from employee);

INSERT INTO emp_manager( select emp_id, emp_name, manager_id
                            from employee);
select * from emp_hire_date;
select * from emp_manager;

ROLLBACK;
COMMIT;

--INSERT ALL
INSERT ALL
    INTO emp_hire_date VALUES(emp_id, emp_name, hire_date)
    INTO emp_manager VALUES(emp_id, emp_name, manager_id)
select emp_id, emp_name, hire_date, manager_id
    from employee;

--INSERT ALL 여러 테이블에 한번에 값을 삽입
--값을 넣을때, 조건에 따라서 값을 넣을 수 있음.
--CASE 절 과 비슷한 WHEN을 사용해서 처리함.
CREATE TABLE emp_old(
    emp_id NUMBER,
    emp_name VARCHAR2(30),
    hire_date DATE,
    salary NUMBER);

CREATE TABLE emp_new(
    emp_id NUMBER,
    emp_name VARCHAR2(30),
    hire_date DATE,
    salary NUMBER);

--OLD employee테이블에서 00.01.01 이전 입사한 사원
--NEW employee테이블에서 00.01.01 이후 입사한 사원
INSERT INTO emp_old( select emp_id , emp_name, hire_date, salary
                    from employee
                    where hire_date < '00/01/01');

INSERT INTO emp_new( select emp_id , emp_name, hire_date, salary
                    from employee
                    where hire_date >= '00/01/01');
select * from emp_old;
select * from emp_new;

INSERT ALL 
    WHEN hire_date <'00/01/01' 
        THEN INTO emp_old 
            VALUES(emp_id, emp_name, hire_date, salary)
    WHEN hire_date >='00/01/01'
        THEN INTO emp_new
            VALUES(emp_id, emp_name, hire_date, salary)
select emp_id, emp_name, hire_date, salary
from employee;

--UPDATE 테이블의 내용을 수정하는 것
--  UPDATE table_name SET 변경된컬럼=변경될값;
CREATE TABLE copy_dept 
    AS select * from department;

--총무부 -> 전략기획부
UPDATE copy_dept SET dept_title='전략기획부', location_id='L1'
where dept_id='D9';

--UPDATE문도 서브쿼리를 이용할 수 있음
CREATE table emp_salary
AS select emp_id, emp_name, salary, bonus from employee;

UPDATE emp_salary SET bonus = ( select bonus from emp_salary
            where emp_name='하이유')
    where emp_id = ( select emp_id from emp_salary
            where emp_name='송종기');

--부서가 회계관리부 인 사원들의 보너스를 .4로 수정
CREATE table emp_salary1
AS select emp_id, emp_name, dept_code, salary, bonus
    from employee;

UPDATE emp_salary1
SET bonus=.4
where dept_code=(
    select dept_code from department
        where dept_title = '회계관리부');

select * from emp_salary1;

--총무부 사원의 월급이 100000원 증가시키기
UPDATE emp_salary1
SET salary = (salary+100000)
where dept_code= (select dept_id from department
                where dept_title='총무부');

--다중 열 UPDATE
select emp_name, salary, bonus from emp_salary1
where emp_name in ('유재식', '방명수');

UPDATE emp_salary1
SET (salary, bonus) = (select salary, bonus
from emp_salary1 where emp_name ='유재식')
where emp_name = '방명수';

CREATE table emp_local
as select * from employee;

--근무지역이 유럽인 사람 보너스를 .5
UPDATE emp_local
SET bonus =.5
where dept_code = (select dept_id
    from department JOIN location ON location_id= local_code
        where local_name='EU');

select bonus from emp_local where dept_code='D8';

--MERGE 두개의 테이블을합치는 작업
--  사용: row끼리 병합
--  MERGE INTO 테이블명 USING 합쳐질테이블명
--      ON (결합할기준값)
--  WHEN MATCHED THEN UPDATE구문
--  WHEN NOT MATCHED THEN INSERT구문
CREATE TABLE MERGE_TEST
    AS (select * from employee);

CREATE TABLE MERGE_TEST2
    AS (select * from employee where dept_code='D8');

select * from merge_test where dept_code ='D8';
select * from merge_test2;

INSERT INTO merge_test2
VALUES(998, '바바', '171230-1234555','baba@b.com',
    '01011112222', 'D2', 'J2', 'S2', 100, .1, 
    NULL, sysdate, DEFAULT, DEFAULT);

UPDATE merge_test2
SET salary=10, bonus=20
where dept_code='D8';

MERGE INTO merge_test USING merge_test2
ON(merge_test.emp_id = merge_test2.emp_id)
WHEN MATCHED THEN 
    UPDATE SET merge_test.salary = merge_test2.salary,
           merge_test.bonus = merge_test2.bonus
    --모든 컬럼 UPDATE SET(모든 데이터 전부 MERGE 하려면)
    --merge_test.emp_name = merge_test2.emp_name, ...
WHEN NOT MATCHED THEN
    INSERT VALUES( merge_test2.EMP_ID, merge_test2.EMP_NAME, 
        merge_test2.EMP_NO, merge_test2.EMAIL, merge_test2.PHONE, 
        merge_test2.DEPT_CODE, merge_test2.JOB_CODE, merge_test2.SAL_LEVEL, 
        merge_test2.SALARY, merge_test2.BONUS, merge_test2.MANAGER_ID, 
        merge_test2.HIRE_DATE, merge_test2.ENT_DATE, merge_test2.ENT_YN);

select emp_name, dept_code, salary, bonus from merge_test
where dept_code='D8';

--DELETE: where절에 pk 컬럼 주로 씀
DELETE from merge_test where emp_name='유병승';

ALTER TABLE EMPLOYEE ADD FOREIGN KEY(dept_code)
    REFERENCES DEPARTMENT(dept_id);

--ERROR!
--FOREIGN KEY VIOLATION
--  ORA-02291: integrity constraint 
--  (KH.SYS_C007055) violated - parent key not found
INSERT INTO EMPLOYEE(emp_id, emp_name, emp_no, 
        sal_level, dept_code, job_code)
    VALUES(997, '루루', '990101-1311333', 'S2','D0', 'J2');

INSERT INTO EMPLOYEE(emp_id, emp_name, emp_no, 
        sal_level, dept_code, job_code)
    VALUES(997, '루루', '990101-1311333', 'S2','D1', 'J2');

--NO RESULT!
select * from department where dept_id='D0';
select * from department where dept_id='D1';
select * from department where dept_id='D4';

--ERROR! - child record found!
DELETE from department where dept_id='D1';

--OK! Because 'D4' has NO CHILD RECORD!
DELETE from department where dept_id='D4';

--TRUNCATE (DELETE와 같지만, ROLLBACK 안됨)
DELETE from merge_test;
ROLLBACK; --OK

TRUNCATE TABLE merge_test;
ROLLBACK; --CANNOT retrieve data...

--DDL
--  CREATE 오브젝트 생성
--  ALTER 오브젝트 수정
--  DROP 오브젝트 삭제
--  오브젝트: table ,view, index, sequence, user ...
--사용: CREATE 오브젝트종류 오브젝트명칭
CREATE TABLE member1(
    mem_name VARCHAR2(20),
    mem_password VARCHAR2(30),
    mem_id VARCHAR2(20)
);

select * from member1;

--테이블 컬럼에 주석달기.
COMMENT ON COLUMN member1.mem_name IS '회원 이름';
COMMENT ON COLUMN member1.mem_password IS '회원 비밀번호';
COMMENT ON COLUMN member1.mem_id IS '회원 아이디';

--select * from all_tab_comments where table_name='MEMBER1';
select * from user_col_comments where table_name='MEMBER1';

--CONSTRAINTS 제약조건
--  NOT NULL
--  UNIQUE
--  PRIMARY KEY(NOT NULL & UNIQUE)
--  FOREIGN KEY
--  CHECK

CREATE TABLE member2(
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_ID VARCHAR2(10) UNIQUE,
    MEM_PASSWORD varchar2(20));

--CONSTRAINT_TYPE='C' CHECK 또는 NOT NULL
--CONSTRAINT_TYPE='R' FOREIGN KEY 설정됨
--CONSTRAINT_TYPE='P' PRIMARY KEY 설정됨
--CONSTRAINT_TYPE='U' UNIQUE 설정됨

select * from user_cons_columns;
select * from user_constraints;
select table_name, constraint_name, constraint_type
    from user_constraints 
    where table_name in ('MEMBER1', 'MEMBER2');

--NOT NULL 특정 컬럼에 무조건 데이터를 넣어야 할 때
--NULL에 대해 제약조건을 설정하지 않으면 무조건 NULL 허용
--ID, PW, NO에는 값이 반드시 필요. NULL값이 못들어 오게 설정
CREATE TABLE user_ncons(
    user_no NUMBER NOT NULL,
    user_id VARCHAR2(30) NOT NULL,
    user_pw VARCHAR2(30) NOT NULL,
    user_name VARCHAR2(20),
    gender VARCHAR2(30),
    phone VARCHAR2(30),
    email VARCHAR2(50));

--ERROR! CONSTRAINTS
INSERT INTO user_ncons(user_no, user_id, user_pw) VALUES(1, NULL, NULL);
--OK
INSERT INTO user_ncons(user_no, user_id, user_pw) VALUES(1, 'admin', 1234);

--UNIQUE
CREATE TABLE user_nuni(
    user_no NUMBER NOT NULL,
    user_id VARCHAR2(30) NOT NULL,
    user_pw VARCHAR2(30) NOT NULL,
    user_name VARCHAR2(20),
    gender VARCHAR2(30),
    phone VARCHAR2(30),
    email VARCHAR2(50));
--DUPLICATES inserted
INSERT INTO user_nuni VALUES(
    1, 'admin', 1234, 'administrator', 'M', '01012345555', 'admin@a.com');
INSERT INTO user_nuni VALUES(
    2, 'admin', 1234, 'administrator2', 'F', '01012345555', 'admin@a.com');

select * from user_nuni;

--COLUMN LEVEL CONSTRAINTS
CREATE TABLE user_uni(
    user_no NUMBER NOT NULL,
    user_id VARCHAR2(30) NOT NULL UNIQUE,
    user_pw VARCHAR2(30) NOT NULL,
    user_name VARCHAR2(20),
    gender VARCHAR2(30),
    phone VARCHAR2(30),
    email VARCHAR2(50));

--TABLE LEVEL CONSTRAINTS DEFINITION - UNIQUE
--  UNIQUE, PK, FK can be defined in TABLE LEVEL
--  NOT NULL : can only be defined in COLUMN LEVEL definition
CREATE TABLE user_uni2(
    user_no NUMBER NOT NULL,
    user_id VARCHAR2(30) NOT NULL,
    user_pw VARCHAR2(30) NOT NULL,
    user_name VARCHAR2(20),
    gender VARCHAR2(30),
    phone VARCHAR2(30),
    email VARCHAR2(50),

    UNIQUE(user_id)
  --  UNIQUE(user_no, user_id) --unique pair
  --  NOT NULL(user_id) --NOT ALLOWED! ERROR!
);

INSERT INTO user_uni VALUES(
1, 'admin', 1234, 'administrator', 'M', '01012345555', 'admin@a.com');
--ERROR! ORA-00001: unique constraint (KH.SYS_C007066) violated
INSERT INTO user_uni VALUES(
2, 'admin', 1234, 'administrator2', 'F', '01012345555', 'admin@a.com');
--OK! NULL은 중복 취급 안됨 -> NOT NULL CONSTRAINT로 NULL insert 방지해야함.
INSERT INTO user_uni VALUES(
3, NULL, 1234, 'administrator2', 'F', '01012345555', 'admin@a.com');

select * from user_uni;
select * from user_uni2;

CREATE TABLE cons_uni_group(
    user_no NUMBER,
    user_id VARCHAR2(20),
    user_pw VARCHAR2(20),
    user_name VARCHAR2(30),

    UNIQUE(user_no, user_id)
);
--OK
INSERT INTO cons_uni_group VALUES(1, 'admin', '1234', 'administrator');
INSERT INTO cons_uni_group VALUES(2, 'admin', '1234', 'administrator');
INSERT INTO cons_uni_group VALUES(1, 'user01', '1234', 'administrator');
--ERROR! should be unique pair
INSERT INTO cons_uni_group VALUES(1, 'admin', '1234', 'administrator');

select * from cons_uni_group;

--PRIMARY KEY : distinguish rows
--  not null & unique - ONLY ONE can exist in a table.
-- INDEX is created for pk.
CREATE TABLE user_primary (
    user_no NUMBER PRIMARY KEY,
    user_id VARCHAR2(20),
    user_pw VARCHAR2(30),
    user_name VARCHAR2(20),
    gender VARCHAR2(30),
    phone VARCHAR2(30),
    email VARCHAR2(50)
);
--EQUIVALENT constraint deifinition
CREATE TABLE user_primary_tb (
    user_no NUMBER,
    user_id VARCHAR2(20),
    user_pw VARCHAR2(30),
    user_name VARCHAR2(20),
    gender VARCHAR2(30),
    phone VARCHAR2(30),
    email VARCHAR2(50),

    PRIMARY KEY(user_no)
);

--OK
INSERT INTO user_primary VALUES(
1, 'admin', '1234', 'administrator', 'M', '01012345555', 'admin@email.com');
INSERT INTO user_primary VALUES(
2, 'user01', '5555', 'administrator', 'F', '01012345555', 'admin@email.com');

--ERROR pk(not null)
INSERT INTO user_primary VALUES(
NULL, 'user01', '5555', 'administrator', 'F', '01012345555', 'admin@email.com');
--ERROR pk(unique)
INSERT INTO user_primary VALUES(
1, 'user01', '5555', 'administrator', 'F', '01012345555', 'admin@email.com');

select * from user_primary;

--PRIMARY KEY (COMPOSITE)
--  PRIMARY KEY 복합키는 테이블레벨로 생성
--user(n), product(n) 이어주는 테이블로 정의 가능
CREATE TABLE tbl_composite_key(
    proc_no VARCHAR2(20),
    user_id VARCHAR2(20),
    order_date DATE,
    order_num NUMBER,
    PRIMARY KEY(proc_no, user_id, order_date)
);
INSERT INTO tbl_composite_key VALUES('P111', 'user01', sysdate, 10);
INSERT INTO tbl_composite_key VALUES('P111', 'user01', sysdate, 10); --OK! SYSDATE differs every seconds

INSERT INTO tbl_composite_key VALUES('P111', 'user01', '19/06/25', 10);
INSERT INTO tbl_composite_key VALUES('P111', 'user01', '19/06/25', 10); --ERROR! DUPLICATE! fixed time(hr,min,sec all 0s)

select * from tbl_composite_key;


--FOREIGN KEY : 참조되는 컬럼 값 NULL 가능
--외부 테이블에서 값을 가져오는것!
--REFERENCE 참조할 컬럼 생략하면, 참조하는 테이블의 primary key를 참조!
CREATE TABLE user_grade(
    grade_no NUMBER PRIMARY KEY,
    grade_name VARCHAR2(10)
);

INSERT INTO user_grade VALUES(10, '일반');
INSERT INTO user_grade VALUES(20, '실버');
INSERT INTO user_grade VALUES(30, '골드');

select * from user_grade;

CREATE TABLE member_foreign(
    user_no NUMBER PRIMARY KEY,
    user_id VARCHAR2(20) NOT NULL UNIQUE,
    user_pw VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(20),
    grade_no NUMBER,

    FOREIGN KEY(grade_no) REFERENCES user_grade(grade_no)
);

--ERROR - foreign key. (10,20,30) are allowed as 'grade_no'
INSERT INTO member_foreign VALUES(1, 'user01', '1234', 'baba', 50);
--OK
INSERT INTO member_foreign VALUES(1, 'user01', '1234', 'baba', 10);

select * from member_foreign;

--OMIT column name in a referenced table
--  In default, it references PK COLUMN of a referenced table
CREATE TABLE member_foreign1(
    user_no NUMBER PRIMARY KEY,
    user_id VARCHAR2(20) NOT NULL UNIQUE,
    user_pw VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(20),
    grade_no NUMBER,

--  references PK column(grade_no) in default
    FOREIGN KEY(grade_no) REFERENCES user_grade
    --CONSTRAINT fk_grade_no FOREIGN KEY(grade_no) REFERENCES user_grade(grade_no)
);
--ERROR foregin key violated
INSERT INTO member_foreign1 VALUES(1, 'user01', '1234', 'baba', 50);
--OK
INSERT INTO member_foreign1 VALUES(1, 'user01', '1234', 'baba', 10);
INSERT INTO member_foreign1 VALUES(2, 'user02', '1234', 'baba', 30);

select * from member_foreign1;

CREATE TABLE member_foreign2(
    user_no NUMBER PRIMARY KEY,
    user_id VARCHAR2(20) NOT NULL UNIQUE,
    user_pw VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(20),

    grade_no NUMBER REFERENCES user_grade
  --grade_no NUMBER REFERENCES user_grade(grade_no) --OK
    --FOREIGN KEY(grade_no) REFERENCES user_grade
);
--ERROR foregin key violated
INSERT INTO member_foreign2 VALUES(1, 'user01', '1234', 'baba', 50);
--OK
INSERT INTO member_foreign2 VALUES(1, 'user01', '1234', 'baba', 10);
INSERT INTO member_foreign2 VALUES(2, 'user02', '1234', 'baba', 30);

select * from member_foreign2;

CREATE TABLE member_foreign3(
    user_no NUMBER PRIMARY KEY,
    user_id VARCHAR2(20) NOT NULL UNIQUE,
    user_pw VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(20),
    grade_no NUMBER,

    CONSTRAINT fk_grade_no FOREIGN KEY(grade_no) REFERENCES user_grade(grade_no)
);

CREATE TABLE user_tbl(
    user_id VARCHAR2(20) PRIMARY KEY,
    user_pw VARCHAR2(20) NOT NULL,
    user_name VARCHAR2(20) NOT NULL,
    email VARCHAR2(30) NOT NULL
);

CREATE TABLE product_tbl(
    pro_id VARCHAR2(20) PRIMARY KEY,
    pro_name VARCHAR2(20),
    price NUMBER
);

INSERT INTO user_tbl VALUES('USER01', '1234', 'auauau', 'aa@rr.com');
INSERT INTO user_tbl VALUES('USER02', '1234', 'bububu', 'bb@rr.com');
INSERT INTO user_tbl VALUES('USER03', '1234', 'cucucu', 'cc@rr.com');

INSERT INTO product_tbl VAlUES('F01', '침대', 1000000);
INSERT INTO product_tbl VAlUES('F02', '컴퓨터', 1200000);
INSERT INTO product_tbl VAlUES('F03', '에어컨', 2000000);

CREATE TABLE shop(
    user_id VARCHAR2(20),
    pro_id VARCHAR2(20),
    purchaseDay DATE
);

INSERT INTO shop VALUES('user03', 'f01', sysdate);

select * from shop;

--user_id 대소문자 달라서 못찾음
select * from shop S
    LEFT JOIN user_tbl U ON S.user_id = U.user_id;

CREATE TABLE shop1(
    user_id VARCHAR2(20) NOT NULL REFERENCES user_tbl(user_id),
    pro_id VARCHAR2(20) NOT NULL REFERENCES product_tbl(pro_id),
    purchaseDay DATE
);

--ERROR! FOREIGN KEY rule violated
INSERT INTO shop1 VALUES('user03', 'f01', sysdate);
--OK
INSERT INTO shop1 VALUES('USER03', 'F01', sysdate);

select * from shop1 S
    LEFT JOIN user_tbl U ON S.user_id = U.user_id;

--FOREIGN KEY에는 NULL 대입됨 막으려면 NOT NULL도 추가
INSERT INTO shop1 VALUES(NULL, NULL, sysdate);

select * from shop1;

select * from user_tbl;
select * from product_tbl;

--cannot delete (fk constraint and data parent&child exist)
delete from user_tbl where user_id = 'USER03';
--OK
delete from user_tbl where user_id = 'USER01';

--fk로 reference 걸려있는 데이터 삭제 되도록
--테이블 생성시 옵션 지정
--참조키에 삭제에 대한 옵션을 설정할 수 있음
--  ON DELETE 옵션
--    SET NULL : NULL로 바꿔줌(부모에reference 되어있어도 자식컬럼 NULL 변환됨)
--    SET CASCADE : 부모값 지워지면 자식데이터도 같이 삭제
select * from user_tbl;

CREATE TABLE shop2(
    user_id VARCHAR2(20) NOT NULL 
                         REFERENCES user_tbl(user_id) ON DELETE SET NULL,
    pro_id VARCHAR2(20) NOT NULL
                        REFERENCES product_tbl(pro_id) ON DELETE SET NULL,
    purchaseDay DATE
    --CONSTRAINT fk_user_id FOREIGN_KEY(user_id) REFERENCES user_tbl(user_id) ON DELETE SET NULL,
    --CONSTRAINT fk_pro_id FOREIGN_KEY(pro_id) REFERENCES product_tbl(pro_id) ON DELETE SET NULL
);

INSERT INTO shop2 VALUES('USER02', 'F01', sysdate);

select * from shop2;

--ERROR --shop1 has 'USER03'
DELETE from user_tbl where user_id='USER03';
--ERROR...  would be OK if NOT NULL CONSTRAINT is not set, 
--(since ON DELETE SET NULL is specified)
-- shop2 has 'USER02'
DELETE from user_tbl where user_id='USER02';

CREATE TABLE shop3(
    user_id VARCHAR2(20) REFERENCES user_tbl(user_id) ON DELETE SET NULL,
    pro_id VARCHAR2(20) REFERENCES product_tbl(pro_id) ON DELETE SET NULL,
    purchaseDay DATE
);

INSERT INTO shop3 VALUES('USER02', 'F01', sysdate);

--ERROR -- shop1 has 'USER03'
DELETE from user_tbl where user_id='USER03';
--OK user_id set to NULL
DELETE from user_tbl where user_id='USER02';

select * from shop3;

--CASCADE delete all regardless of Foreign Key references
CREATE TABLE shop4(
    user_id VARCHAR2(20) REFERENCES user_tbl(user_id) ON DELETE CASCADE,
    pro_id VARCHAR2(20) REFERENCES product_tbl(pro_id) ON DELETE CASCADE,
    purchaseDay DATE
);
INSERT INTO user_tbl VALUES('USER01', '123', 'lulu','lalala@la.com');
INSERT INTO shop4 VALUES('USER03', 'F02', sysdate);

DELETE from user_tbl where user_id='USER01';
DELETE from user_tbl where user_id='USER03';

select * from user_tbl;
select * from shop4;

--CHECK 제약조건: 데이터로 들어오는값을 특정값으로 제한
CREATE TABLE check_tbl(
    username VARCHAR2(20),
    gender VARCHAR2(10) CHECK(gender in ('남','여'))
);
INSERT INTO check_tbl VALUES('바바바', '남자'); --ERROR
INSERT INTO check_tbl VALUES('바바바', '여'); --OK

--SUBQUERY 이용한 CREATE TABLE
CREATE TABLE employee_tbl
AS select * from employee 
    JOIN department ON dept_id= dept_code
    JOIN job USING (job_code)
    JOIN location ON local_code = location_id;

select emp_name, dept_title, job_name from employee_tbl;

--컬럼만 복사 WHERE 1=0
CREATE TABLE temp AS select emp_name, salary, bonus 
        from employee where 1=0;
select * from temp;

-- ALTER TABLE 테이블명 ADD (COL DataType);
-- 테이블에 설정된 설정을 추가 변경, 제약 조건을 추가/변경
select * from user_tbl;

ALTER TABLE user_tbl ADD(age NUMBER);

ALTER TABLE user_tbl ADD(address VARCHAR2(30));

select * from user_tbl;

--COLUMN 추가시 DEFAULT 값 설정가능
CREATE TABLE defaulttest(
    age NUMBER default 10
);

INSERT INTO defaulttest VALUES(19);
INSERT INTO defaulttest VALUES(default);

select * from defaulttest;

--DEFAULT -> NOT NULL
--컬럼 추가하면서 제약조건 설정
ALTER TABLE user_tbl ADD(
    national VARCHAR2(20) DEFAULT '한국');
ALTER TABLE user_tbl ADD(
    user_no VARCHAR2(20) UNIQUE);
ALTER TABLE user_tbl ADD(
    gender VARCHAR2(10) DEFAULT '여' check(gender in ('남','여')));

select * from user_tbl;


--제약조건 테이블 생성 후에 새로 추가
CREATE TABLE add_cons(
    emp_no NUMBER,
    emp_id VARCHAR2(20),
    emp_pw VARCHAR2(20)
);

ALTER TABLE add_cons
ADD CONSTRAINT pk_add_cons PRIMARY KEY (emp_no);
 
--emp_id unique 제약조건 설정!
ALTER TABLE add_cons
ADD CONSTRAINT unq_cons UNIQUE(emp_id);

--ERROR 안됨!
--emp_pwd not null 제약조건 설정! 
--null able 기본 제약조건이 null이 이미 설정 되어 있음
--제약조건을 추가하는 것이 아니라, 이미 설정된
--null -> not null;
--ERROR!!
ALTER TABLE add_cons
ADD CONSTRAINT nn_cons NOT NULL(emp_pw);
--OK
ALTER TABLE add_cons
MODIFY emp_pw CONSTRAINT nn_cons NOT NULL;

--컬럼의 내용을 수정(자료형, 길이)
ALTER TABLE add_cons
MODIFY emp_no VARCHAR2(20);


--emp_id 길이를 100으로 증가
--길이를 축소할때, 데이터 존재하면 변경 불가.
ALTER TABLE add_cons
MODIFY emp_id VARCHAR2(100);

--컬럼 삭제하기
--ALTER TABLE 테이블명 DROP COLUMN 컬럼명
ALTER TABLE add_cons DROP COLUMN emp_pw;

--제약조건 삭제
--ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명
select * from user_constraints;
--PK_ADD_CONS
--UNQ_CONS

ALTER TABLE add_cons DROP CONSTRAINT PK_ADD_CONS;

--컬럼 명칭을 변경
--ALTER TABLE 테이블명 RENAME COLUMN 대상 to 변경값
ALTER TABLE add_cons RENAME COLUMN emp_no TO no;
ALTER TABLE add_cons RENAME COLUMN no TO emp_no;

select * from add_cons;

--테이블 이름 변경
ALTER TABLE add_cons RENAME TO add_training;
ALTER TABLE add_training RENAME TO add_cons;

select * from add_training;
select * from add_cons;

RENAME add_training TO add_cons;
RENAME add_cons TO add_training;

--테이블 삭제
DROP TABLE add_cons;
DROP TABLE add_training;
DROP TABLE shop2;

--사용자 삭제
DROP USER user_name;

--DCL(Data Control Language)
--데이터에 접근, 수정, 삭제 등 데이터를 조작하는 기능을 통제
--grant(권한부여), revoke(권한회수), 
--commit(데이터확정), rollback(되돌리기)

--GRANT 권한명(select, update, delete, ...) 
--  || role(권한들의 모음, 그룹 패키지화 e.g. resource)
-- TO 대상user [option]
--  option = "with admin option"(부여받은 권한을 또 다른사람에게 부여가능)
CONN sys/oracle

select * from dba_sys_privs
where GRANTEE='KH';  --tablespace 테이블 만들 수 있는 공간

select * from dba_role_privs
where GRANTEE='KH';

GRANT select, update ON scott.emp TO KH;

CONN kh/kh

select * from scott.emp;

UPDATE scott.emp SET comm=30 where empno=7934;

select * from user_sys_privs;
select * from user_role_privs;

REVOKE update ON scott.emp FROM kh;

--ROLE 부여된 권한보기
select * from dba_sys_privs
    where grantee in ('CONNECT', 'RESOURCE');

--VIEW 가상 테이블
--  select 실행한 결과를 화면에 담는 객체
--  select 문장 자체를 저장하여 호출할 때마다 해당쿼리 실행
--  실질적으로 DB를 저장하고 있지 않음.
--  검색의 효율성: 내가 찾고자 하는 정보만 조회
--  보안성: 테이블의 정보를 숨길 수 있음
--  CREATE or REPLACE VIEW view_name[col1 별칭1, col2 별칭2, ...]
--      AS (select emp_id, emp_name, dept_code from employee);
--  SELECT * from view_name;
--  GRANT CREATE VIEW To db_user; --VIEW 에 GRANT 권한 부여(conn system/oracle)
CONN system/oracle
GRANT CREATE VIEW TO KH;
CONN kh/kh

CREATE OR REPLACE VIEW view_emp AS (
    select emp_id, emp_name, email, phone, job_code, sal_level
    from employee);

select * from view_emp;

select * from user_views where view_name='VIEW_EMP';

--사번, 이름, 직급명, 부서명, 근무지역을
--v_resultset_emp 라는 뷰에
CREATE OR REPLACE VIEW v_resultset_emp AS(
    select emp_id AS 사번, emp_name, J.job_name, D.dept_title, L.local_name
        from employee E
            LEFT JOIN job J USING (job_code)
            LEFT JOIN department D ON E.dept_code = D.dept_id
            LEFT JOIN location L ON D.location_id = L.local_code);

select * from v_resultset_emp V where V.사번 = '205';

--TABLE 변경시 VIEW에도 함께 적용됨: VIEW에도 '정중앙'
--  VIEW에는 쿼리문이 저장되어 있으므로.
UPDATE employee  SET emp_name='정중앙' WHERE emp_id='205';
select * from v_resultset_emp V where V.사번 = '205';

--VIEW 특징
--1.컬럼뿐 아니라, 산술연산 처리한 view 생성도 가능
CREATE OR REPLACE VIEW view_emp_salary AS(
    select emp_name AS 사원명, 12*salary*(1+nvl(bonus,0)) AS 연봉
    from employee);

select * from view_emp_salary;

--JOIN 을 이용한 view도 생성 가능
--employee에서 사번, 사원이름, 직급, 부서명
--컬럼(직급NULL -> 인턴) view_emp_read
CREATE OR REPLACE VIEW view_emp_read AS(
    select emp_id, emp_name, nvl(job_name, '인턴') AS 직급, dept_title
    from employee
        LEFT JOIN department ON dept_code= dept_id
        LEFT JOIN job USING (job_code));

select * from view_emp_read;

--VIEW에서도 데이터 추가,수정,삭제가 가능
-- 다음 6가지 상황에서는 불가능
--1. 뷰에 정의되지 않은 컬럼 수정
--2. 뷰에 보이지 않는 컬럼 중 NOT NULL 제약조건 가진 컬럼 있을경우
--3. 산술 연산이 적용된 컬럼이 있을 경우
--4. JOIN을 통해 여러테이블을 참조할 경우
--    조회한 테이블의 정보 중에 기본키가 
--    단 한개일 경우는 변경 가능
--5. DISTINCT를 사용하여 실제 데이터의 내용이 명확하지 않은 경우
--6. 그룹함수나 GROUP BY 구문을 사용해서 조회한 쿼리일 경우
UPDATE view_emp SET emp_no='881123-2000123' where emp_id=500; 
DELETE FROM view_emp where emp_id=500;

select * from view_emp where emp_name='강오덩';

--1. 뷰에 정의되지 않은 컬럼을 수정
CREATE OR REPLACE VIEW V_JOB AS(
    select job_code from job);

INSERT INTO v_job VALUES('J8', '인턴'); --ERROR
UPDATE v_job SET job_name='인턴' where job_code is null; --ERROR

--2. 뷰에 보이지 않는 컬럼 중
--   NOT NULL 제약조건 가진 컬럼 있을경우
--VIEW의 DML 사용: 생성된 VIEW를 가지고 DML 구문이 사용 가능
--  DML 구문을 가지고 view 테이블에 내용을 변경하면 실제 테이블도 변경
--vim_emp -> emp_id, emp_name, email, phone, job_code, sal_level
--ORA-01400: cannot insert NULL into ("KH"."EMPLOYEE"."EMP_NO")
CREATE OR REPLACE VIEW view_emp AS (
    select emp_id, emp_name, email, phone, job_code, sal_level
    from employee);
--ERROR
INSERT INTO view_emp VALUES(500, '강오덩', 'kang@a.com', 
            '01012345555', 'J5', 'S3');
DROP VIEW view_emp;

CREATE OR REPLACE VIEW view_emp AS (
    select emp_id, emp_no, emp_name, email, phone, job_code, sal_level
    from employee);
--OK! EMPLOYEE 테이블에도 데이터가 추가됨!!!
INSERT INTO view_emp VALUES(500, '790626-1034555', '강오덩', 'kang@a.com', 
            '01012345555', 'J5', 'S3');

--주의! VIEW에 INSERT하면 TABLE 데이터도 함께 변경됨!
DELETE FROM view_emp where emp_name='강오덩';
DELETE FROM EMPLOYEE where emp_name='강오덩';
select * from view_emp;
select * from view_emp where emp_name='강오덩';
select * from employee where emp_name='강오덩';

--3. 산술 연산이 적용된 컬럼이 있을 경우
CREATE OR REPLACE VIEW v_emp_sal AS(
    select emp_id, emp_name, salary, 
           12*salary*(1+nvl(bonus,0)) AS 연봉
    from employee);

--ERROR! virtual column not allowed here
INSERT INTO v_emp_sal VALUES(901, '손흥만', 3000000,40000000);

--4. JOIN을 통해 여러테이블을 참조할 경우
CREATE OR REPLACE VIEW v_join_emp AS(
    select emp_id, emp_name, dept_title from employee
        LEFT JOIN department ON dept_id=dept_code);

INSERT INTO v_join_emp VALUES(911, '댕댕이', '기술지원부'); --ERROR
UPDATE v_join_emp SET dept_title='기술지원부' where emp_id=218; --ERROR

--4-1 조회한 테이블의 정보 중에 기본키가 단 한개일 경우는 변경 가능
--OK
DELETE from v_join_emp where dept_title = '기술지원부';
ROLLBACK;
COMMIT;

select * from v_join_emp;
select * from department;
select * from employee;

--5. DISTINCT를 사용하여 실제 데이터의 내용이 명확하지 않은 경우
CREATE OR REPLACE VIEW v_dept_emp AS (
    select distinct dept_code from employee);
INSERT INTO v_dept_emp VALUES('D0'); --ERROR
DELETE FROM v_dept_emp where dept_code='D9'; --ERROR --  몇개의 데이터를 지울지 distinct 때문애 불명확함.

select * from v_dept_emp;

--6. 그룹함수나 GROUP BY 구문을 사용해서 조회한 쿼리일 경우
CREATE OR REPLACE VIEW v_group_dept AS (
    select dept_code, SUM(salary) AS 합계, TRUNC(AVG(salary),-4) AS 평균
    from employee GROUP BY dept_code);
--ERROR : virtual column not allowed here
INSERT INTO v_group_dept VALUES('D10', 50000, 50000);
UPDATE v_group_dept SET dept_code='D10' where dept_code='D5';
DELETE FROM v_group_dept where dept_code='D6';


--VIEW 생성시 설정할 수 있는 옵션
--  OR REPLACE: 동일 한 이름 뷰를 replace(덮어씌움)
--  FORCE / NO FORCE : 서브쿼리에 할용된
--      테이블이 없어도 일단 VIEW를 생성(force)
--  WITH CHECK / READ ONLY:
--      CHECK: 설정한 컬럼값을 수정 못하게 막음
--      READ ONLY: 뷰에서 어떤 컬럼도 VIEW를 통해서 변경하지 못하도록
CREATE OR REPLACE FORCE VIEW v_emp AS (
    select t_code, t_name, t_content from test_table);

select * from v_emp;
select * from user_views where view_name = 'V_EMP';
DROP VIEW v_emp;

--NO FORCE 생성시 view의 테이블이 존재 하지 않을때,뷰를 생성하지 않겠다.
-- 디폴드 값이 NOFORCE
CREATE OR REPLACE NOFORCE VIEW v_emp AS (
    select t_code, t_name, t_content from test_table);

--WITH CHECK 설정 컬럼을 수정 못하게.
    CREATE OR REPLACE VIEW v_emp AS
        select * from employee WITH CHECK OPTION;

    --ERROR! CHECK option때문에
    INSERT INTO v_emp VALUES(810, '류별리', '101010-1234567',
            'ryu@kh.co.kr', '01012345555', 'D1', 'J7', 'S1',
            800000, .1, 200, SYSDATE, NULL, DEFAULT);
select * from v_emp;

--DELETE는 가능
DELETE from v_emp where emp_id=500;

--WITH READ ONLY: 데이터 입력/수정/삭제 전부 막음
CREATE OR REPLACE VIEW v_emp AS
    select * from employee WITH READ ONLY;

--ERROR
INSERT INTO v_emp VALUES(810, '류별리', '101010-1234567',
            'ryu@kh.co.kr', '01012345555', 'D1', 'J7', 'S1',
            800000, .1, 200, SYSDATE, NULL, DEFAULT);
DELETE from v_emp where t_id=200;
DELETE from v_emp where emp_id='200';

--SEQUENCE
--1,2,3,4,5 이러한 형식으로 숫자 데이터를 
-- 자동으로 카운트 하는 객체
--CREATE sequence 시퀀스명
--  [INCREMENT BY 숫자] : 다음값에 대한 증감수치. 생략시, 1씩 증가
--  INCREMENT BY 5;
--  INCREMENT BY -5;
--  [START WITH 숫자] : 시작값. 생략시 1씩 증가
--  [MAX VALUE 숫자 | NOMAXVALUE] : 발생 시킬 값의 최대값 설정
--      10^27-1 까지 가능
--  [MIN VALUE 숫자 | NOMINVALUE] : 최소값 설정
--      -10^26
--  [CYCLE | NOCYCLE] 값의 순환 여부
--  [CACHE 바이트 크기 | NOCACHE] 값을 미리 구해놓고,
--      다음값을 반영할  활용하는 설정
--      기본값 20Byte | 최소값 2Byte

CREATE SEQUENCE seq_empid
START WITH 300
INCREMENT BY 5
MAXVALUE 320
NOCYCLE
NOCACHE;

select seq_empid.nextval from dual;
select seq_empid.currval from dual;

--START WITH 시작점을 바꿀 수 없음
ALTER SEQUENCE seq_empid
--START WITH 300
INCREMENT BY 10
MAXVALUE 400
NOCYCLE
NOCACHE;

select * from user_sequences;

--SEQUENCE:
--  SELECT 구문에서 데이터 조회시 사용가능
--  INSERT UPDATE에서도 사용가능
--  VIEW에서는 sequence 사용불가

--시퀀스 삭제하기
DROP SEQUENCE seq_empid;

CREATE SEQUENCE seq_eid
START WITH 300
INCREMENT BY 1
MAXVALUE 10000
NOCYCLE
NOCACHE;

select seq_eid.nextval from dual;
select seq_eid.currval from dual;
DROP SEQUENCE seq_eid;
select * from user_sequences;

--데이터 추가
INSERT INTO EMPLOYEE VALUES(
    seq_eid.NEXTVAL, '송주미', '121203-1234567',
    'song@kh.co.kr', '01012334556', 'D2', 'J7',
    'S1', 5000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
);

select emp_id, emp_name, dept_code, job_code, sal_level
from employee where emp_name='송주미';

--D9부서에 J7 직급의 사원 4명을 시퀀스를 활용하여 추가
INSERT INTO EMPLOYEE VALUES( seq_eid.NEXTVAL, 'AGENT1', '881111-1234567',
    'agent1@kh.co.kr', '01012334556', 'D9', 'J7',
    'S1', 9000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
);
INSERT INTO EMPLOYEE VALUES( seq_eid.NEXTVAL, 'AGENT2', '891111-1234567',
    'agent2@kh.co.kr', '01012334556', 'D9', 'J7',
    'S1', 9000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
);
INSERT INTO EMPLOYEE VALUES( seq_eid.NEXTVAL, 'AGENT3', '821111-1234567',
    'agent3@kh.co.kr', '01012334556', 'D9', 'J7',
    'S1', 9000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
);
INSERT INTO EMPLOYEE VALUES( seq_eid.NEXTVAL, 'AGENT4', '831010-1234567',
    'agent4@kh.co.kr', '01012334556', 'D9', 'J7',
    'S1', 9000000, 0.1, 200, SYSDATE, NULL, DEFAULT);
);

select * from employee
where emp_name like '%AGENT%';

--SEQUENCE 옵션 CYCLE/CACHE
--  CYCLE : 시퀀스 값이 최대/최소값 도달했을때, 
--      다시 반대 값부터 시작하는 옵션
CREATE SEQUENCE seq_cycle
START WITH 200
INCREMENT BY 10
MAXVALUE 230
MINVALUE 15
CYCLE
NOCACHE;

--ERROR! SEQ_CYCLE.CURRVAL is not yet defined in this session
select seq_cycle.currval from dual;
--after nextval executed first time
select seq_cycle.nextval from dual;

DROP SEQUENCE seq_cycle;

select * from user_sequences;

--CACHE / NOCACHE
-- CACHE : 컴퓨터가 다음값에대한 연산들 
--          그때그때 수행하지 않고 미리 계산해 놓는 것
-- NOCACHE : 컴퓨터가 수행할값을 그때그때 처리 하는 것.
--LAST_VALUE 120 미리 계산됨. CURRVAL 121되면 LAST_VALUE=140
CREATE SEQUENCE SEQ_CACHE
START WITH 100
INCREMENT BY 1
CACHE 20
NOCYCLE;

SELECT SEQ_CACHE.NEXTVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;


--INDEX
-- SQL 명령어 조회처리속도를 향상시키기 위한 객체다.
-- 테이블의 식별자(PK, UNIQUE Key)가 되는 컬럼값에대해
-- 각 컬럼단위로 일정간격을 계산하여 조회속도를 향상
--장점: 검색속도가 향샹된다.
--단점: 인덱스가 존재하느 테이블의 내용이 자주변경되는 테이블이라면
--      인덱스를 매번 다시 계산 => 성능 저하
--      인덱스 저장하기 위한 별도의 공간 할당해야 함.
--      읽기성능은 비약적으로 향상, 쓰기 성능은 비관적 하향
-- CREATE [UNIQUE] INDEX index_name
-- ON table_name(column_name);

SELECT * FROM USER_IND_COLUMNS;

--인덱스의 구조 - ROWID
SELECT ROWID, EMP_ID, EMP_NAME FROM EMPLOYEE; --인덱스가 ROWID로 search?

-- 인덱스의 종류
-- 1. 고유인덱스( UNIQUE INDEX )
-- 2. 비고유인덱스( NOUNIQUE INDEX )
-- 3. 단일인덱스( SINGLE INDEX )
-- 4. 결합인덱스 ( COMPOSITE INDEX )
-- 5. 함수기반인덱스 ( FUNCTION BASED INDEX )

--1. 고유 인덱스
-- UNIQUE INDEX
-- 인덱스 생성시 고유값을 기준으로 생성하는 인덱스
-- 오라클에서 PRIMARY KEY 제약조건을 사용하면 자동으로 생성 한다.


CREATE UNIQUE INDEX IDX_EMP_NO
ON EMPLOYEE(EMP_NO);

SELECT * FROM USER_IND_COLUMNS WHERE TABLE_NAME='EMPLOYEE';


--테이블에 중복값 존재할 경우 고유키 생성 불가
--emp_no가 같은 테이터 행이 존재하면 UNIQUE 인덱스 생성불가
CREATE UNIQUE INDEX IDX_DEPT_CODE
ON EMPLOYEE(DEPT_CODE);

-- 2. 비고유 인덱스(DEFAULT)  중복된 값을 가진 컬럼에 사용 가능
CREATE INDEX IDX_DEPT_CODE
ON EMPLOYEE(DEPT_CODE);

-- 지금까지는 컬럼 하나 -> 단일 인덱스

-- 3. 결합 인덱스 : 두개 이상의 컬럼으로 인덱스를 구성하는 것
CREATE INDEX IDX_DEPT
ON DEPARTMENT( DEPT_ID, DEPT_TITLE );

SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT
WHERE DEPT_ID !='D1' AND DEPT_TITLE != '기술지원부';

DROP INDEX IDX_DEPT;

--인덱스 확인
SELECT * FROM USER_IND_COLUMNS;
-- 같은이름 인덱스 2개 확인 가능 
-- => 컬럼포지션을 확인 해보면 1,2 나누어져 있는거 확인 가능

--4. 함수 기반 인덱스
-- 조회시 자주 사용하는 함수식이 있다면
-- 해당 함수식을 인덱스에 반영해서 검색조건을 생성한다.

-- SAL*12 할때 SAL에 인덱스가 있더라도 산술계산을 하게되면
-- SAL에 적용된 INDEX를 사용할수 없다.
-- 이렇게 수식으로 검색하는 경우가 많다고 한다면, 
-- 아예 수식을 함수로 만들고 그함수에 인덱스 반영

CREATE INDEX IDX_EMP_SAL_CAL
ON EMPLOYEE( 12*salary*(1+ NVL(bonus,0));

SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE
WHERE 12*salary*(1+nvl(bonus,0)) >1000000;

-- PL/SQL (PROCEDURAL LANGUAGE EXTENSION TO SQL)
-- SQL에서 확장된 형태의 언어
-- 오라클 자체에서 내장된 절차적 언어
-- 기존 SQL의 단점 극복 하기 위해서 사용한다.
-- 변수의 정의, 조건 처리, 반복처리, 예외를 처리등을 지원하다.

-- PL/SQL의 구조
/*
    선언부, 실행부, 예외처리부 구성됨
    선언부 : DECLARE, 변수, 상수 선언하는 부분
    실행부 : BEGIN ~ END, 제어문, 반복문, 함수정의 등의 작업을 하는 부분 
    예외처리부 : EXCEPTION, 예외 발생시 처리할 내용을 작성하는 부분
*/
/*
    PL/SQL 작성 요령
    1. PL/SQL 블록 내에서는 한문장을 종료할때 마다 세미콜론을 사용
    2. END 뒤에 ;을 사용하여 하나의 블록이 끝났다는것을 명시
    3. DELCARE 나 BEGIN 키워드로 PL/SQL블록이 시작이라는것을 알수있다.
    4. 쿼리문 수행하기 위해서는 /가 반드시 입력 되어야 한다.
        PL/SQL 블록은 행에 / 있으면 종결된것으로 생각한다.
*/

-- 뷰 : SELECT문을 저장해서 필요때마다 사용, 가상의 테이블
-- 프로시저 : PL/SQL 문을 저장해서 사용, 함수

-- 실행부 사용해서 간단한 문장을 출력
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
    -- DBMS_OUTPUT 패키지의 PUT_LINE()프로시저를 호출
END;
/

-- 화면에 작성한출력문이 보이도록 설정
-- 시스템 관련 설정이다.
-- 기본값 OFF -> ON으로 변경
SET SERVEROUTPUT ON;

-- 변수 선언
--[1] 일반변수
DECLARE 
    V_ID NUMBER; 
BEGIN
    SELECT EMP_ID
    INTO V_ID
    FROM EMPLOYEE
    WHERE EMP_NAME = '선동일';
END;
/

-- 변수에 값 대입 varname := value;
DECLARE 
    v_empno NUMBER(4);
    v_empname varchar2(10);
    test_num number(5) := 10*20;
BEGIN
    v_empno := 1001;
    v_empname := '윤원택';

    DBMS_OUTPUT.PUT_LINE('사번       이름');
    DBMS_OUTPUT.PUT_LINE('--------------');
    DBMS_OUTPUT.PUT_LINE(v_empno ||'   '||v_empname);
    DBMS_OUTPUT.PUT_LINE('TEST_NUM = '||test_num);
END;
/


--[2] 레퍼런스 변수
-- %TYPE : 한 컬럼의 자료형을 받아 올때 사용하는 자료형 타입
DECLARE 
    emp_id EMPLOYEE.EMP_ID%TYPE;
    emp_name EMPLOYEE.EMP_NAME%TYPE;
    dept_code EMPLOYEE.DEPT_CODE%TYPE;
    job_code EMPLOYEE.DEPT_CODE%TYPE;
    salary EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, NVL(DEPT_CODE,'-'), JOB_CODE, SALARY
    INTO emp_id, emp_name, dept_code, job_code, salary
    FROM EMPLOYEE
    WHERE EMP_NAME = &사원이름;
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : '|| EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : '|| EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('DEPT_CODE : '|| DEPT_CODE);
END;
/
-- %ROWTYPE : 테이블의 모든 컬럼의 자료형을 참조
-- 특정테이블의 컬럼 수나 데이터 형식을 몰라도 지정할수 있다.
-- SELECT 문장으로 행을 검색 할때 유리하다.
DECLARE 
    MYROW EMPLOYEE%ROWTYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO MYROW.EMP_ID, MYROW.EMP_NAME 
    FROM EMPLOYEE
    WHERE EMP_NAME='이';
    
    DBMS_OUTPUT.PUT_LINE(MYROW.EMP_ID||' '||MYROW.EMP_NAME);
    
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('NO DATA');
END;
/

--제어문, 반복문 
--IF문 --
--1. IF ~ THEN : if(조건식){실행부}
--               IF ~ THEN 
/*
    IF 조건 THEN 
        조건만족시 처리구문;
*/
BEGIN
    IF '&이름' = '서선덕' THEN
        DBMS_OUTPUT.PUT_LINE('님이 서선덕이냐!!!');
    END IF;
END;
/

-- 2. IF ~ THEN ~ ELSE ~ END IF
--  사원번호를 입력받아서 사원의 사번,이름,급여,보너스율을 출력
--  직급코드에 따라 직급명(소속) 출력 
DECLARE
    emp_id EMPLOYEE.emp_id%TYPE;
    emp_name EMPLOYEE.emp_name%TYPE;
    salary EMPLOYEE.salary%TYPE;
    bonus EMPLOYEE.bonus%TYPE;
    job_code JOB.job_code%TYPE;
    job_name JOB.job_name%TYPE;

    emp_position VARCHAR2(20);
BEGIN
    SELECT emp_id, emp_name, salary, nvl(bonus,0), job_code, job_name
    INTO emp_id, emp_name, salary, bonus, job_code, job_name
    FROM EMPLOYEE JOIN JOB USING (job_code)
    WHERE emp_id = &사원번호;
    
    IF job_code = 'J1' THEN emp_position := '대표님';
    ELSE emp_position :=job_name;
    END IF;

    DBMS_OUTPUT.PUT_LINE('사번: ' || emp_id);
    DBMS_OUTPUT.PUT_LINE('이름: ' || emp_name);
    DBMS_OUTPUT.PUT_LINE('급여: ' || salary);
    DBMS_OUTPUT.PUT_LINE('보너스율: ' || bonus*100 ||'%');
    DBMS_OUTPUT.PUT_LINE('직급: ' || emp_position);
END;
/

-- 3. IF ~ THEN ~ ELSIF ~ ELSE ~ END IF;
-- ELSE IF 가 아니라 ELSIF
/*
    IF 조건 1 THEN
        조건1이 만족할 경우 처리구문;
    ELSIF 조건2 THEN
        조건2가 만족할 경우 처리구문;
    ELSE 
        조건을 만족하지 않을 경우 처리
*/

--점수를 입력받아서 SCORE 변수에 저장하고
--90점 이상은 'A'
--75점 이상은 'B'
--60점 이상은 'C'
-- 그 이하는 'F'로 채첨하여
-- 출력 ->'당신의 점수는 00이고, O학점입니다.'
DECLARE
    SCORE INT;
    GRADE VARCHAR2(2);
BEGIN
    SCORE := '&점수';
    
    -- IF문 --
    IF SCORE >=90 THEN GRADE := 'A';
    ELSIF SCORE >=75 THEN GRADE :='B';
    ELSIF SCORE >= 60 THEN GRADE :='C';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 '||SCORE 
            ||'점이고, 학점은 '||GRADE||'학점입니다.');
    
END;
/

--4. CASE 문
--자바에서 SWITCH문
-- CASE ~ END CASE;
/*
    CASE 
        WHEN 표현식1 THEN 
            실행문1;
        WHEN 표현식2 THEN
            실행문2;
        ELSE 기본실행문3;
*/
-- 
DECLARE 
    INPUTVALUE NUMBER;
BEGIN
    INPUTVALUE := '&INPUTVALUE';
    
    CASE INPUTVALUE
        WHEN 1 THEN 
            DBMS_OUTPUT.PUT_LINE(INPUTVALUE||'입력함');    
        WHEN 2 THEN
            DBMS_OUTPUT.PUT_LINE(INPUTVALUE||'입력함');
        WHEN 3 THEN 
            DBMS_OUTPUT.PUT_LINE(INPUTVALUE||'입력함');
        ELSE 
            DBMS_OUTPUT.PUT_LINE('1,2,3 모두 아니야~!');
    END CASE;
END;
/

--사원번호를 입력받아서 직급코드로 
--대표(J1),임원진(J2), 일반직원(나머지) 구분한 예제를 CASE문으로 구현
DECLARE 
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
    EMP_TEAM VARCHAR2(20);
BEGIN
    SELECT JOB_CODE
    INTO JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';
    
    CASE JOB_CODE
        WHEN 'J1' THEN EMP_TEAM := '대표';
        WHEN 'J2' THEN EMP_TEAM := '임원';
        ELSE EMP_TEAM := '일반직원';
    END CASE;
    
    DBMS_OUTPUT.PUT_LINE('소속 : '||EMP_TEAM);
END;
/

-- 반복문
DECLARE 
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE;
    
    DBMS_OUTPUT.PUT_LINE(E.EMP_ID); --ERROR!
END;
/

-- LOOP, FOR, WHILE

--일반 LOOP 문
/*
    LOOP
        반복시킬 내용
        --method1--
        IF 반복 종료 조건 EXIT;
        END IF;

        --method2--
        EXIT WHEN 반복종료조건;
    END LOOP;
*/

-- 1 ~5 까지의 반복문을 수행하는 LOOP 반복문 구현
DECLARE 
    N INT:=1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N+1;
        EXIT WHEN N = 6;
    END LOOP;
END;
/
-- 5 ~ 1 출력하는 LOOP문을 작성해보자
DECLARE 
    N INT := 5;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N-1;
        EXIT WHEN N = 0;
    END LOOP;
END;
/

-- - - - -REVIEW - - - - --
--VIEW
/*
CREATE OR REPLACE view_name AS (
    select col1, .. .colN
        FROM employee);
*/
--SEQUENCE
--  1,2,3... 등의 숫자를 증감시키는 객체
/*
CREATE SEQUENCE seq_name
START WITH 200
INCREMENT BY 5
MAXVALUE 250
CYCLE/NOCYCLE --순환여부
NOCACHE;
*/

--INDEX
--테이블에서 특정데이터를 검색할때, 효율적으로 검색하기 위한 객체
--CREATE INDEX idx_name ON table_name (col1, col2,...);

--PL/SQL procedual script language
/*
DECLARE
BEGIN
    EXCEPTION
END;
/
*/
SET SERVEROUTPUT ON;

--1~10 난수 5개 출력
--  Function that generates random number LOW <= N <HIGH
--  DBMS_RANDOM.VALUE(LOW, HIGH);
DECLARE
    n INT :=1;
    rand NUMBER;
    output VARCHAR2(20);
BEGIN

    LOOP
        rand := TRUNC(DBMS_RANDOM.VALUE(1, 11));
        output := (output || rand || ' ');
        --DBMS_OUTPUT.PUT_LINE(rand);
        n := n+1;
        IF instr(output, rand) = 0 THEN
            CONTINUE;
        END IF;
        EXIT WHEN n =5;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(output);
END;
/

--FOR loop--
/*
    FOR 카운터변수 IN [REVERSE] 시작값..종료값 LOOP
        반복할 내용
    END LOOP;
    --카운터변수 ->자동선언
    --마운트 값은 자동으로 1씩증가
*/
BEGIN
    FOR N IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;

    FOR N IN REVERSE 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

--중첩 FOR LOOP
--구구단 출력
BEGIN
    FOR I IN 2..9 LOOP
        FOR J IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(I || ' * ' || J ||' = '||(I*J));
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

--짝수 단 출력
DECLARE
    RES NUMBER;
BEGIN
    FOR i IN 2..9 LOOP
        IF MOD(i,2) = 0 THEN
            FOR j IN 1..9 LOOP
                RES := i * j;
                DBMS_OUTPUT.PUT_LINE(i||' * '||j||' = '|| RES);
            END LOOP;
        END IF;
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

--FOR문 이용한 INSERT
CREATE TABLE tb_test_for(
    no NUMBER,
    test_date DATE
);

BEGIN
    FOR X IN 1..10 LOOP
        INSERT INTO tb_test_for VALUES(X, sysdate+x);
    END LOOP;
END;
/

select * from tb_test_for;

--PL/SQL FOR 반복문 이용하여 employee 테이블의
--200부터 210번까지 사원의 아이디,이름,이메일 출력
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ID    NAME    EMAIL');
    DBMS_OUTPUT.PUT_LINE('-------------------');
    FOR I IN 0..10 LOOP
        SELECT *
            INTO E
            FROM EMPLOYEE
            WHERE emp_id=(200+I);
        DBMS_OUTPUT.PUT_LINE(E.emp_id ||'    ' || E.emp_name ||'    '||E.email);
    END LOOP;
END;
/

DECLARE
    emp_id EMPLOYEE.EMP_ID%TYPE;
    emp_name EMPLOYEE.EMP_NAME%TYPE;
    email EMPLOYEE.EMAIL%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ID    NAME    EMAIL');
    DBMS_OUTPUT.PUT_LINE('-------------------');
    FOR I IN 0..10 LOOP
        SELECT emp_id, emp_name, email
            INTO emp_id, emp_name, email 
            FROM EMPLOYEE
            WHERE emp_id=(200+I);
        DBMS_OUTPUT.PUT_LINE(emp_id ||'    ' || emp_name ||'    '||email);
    END LOOP;
END;
/


--WHILE LOOP
/*
    WHILE [cond] LOOP
        ...
        ...
    END LOOP;
*/
DECLARE
    N INT := 5;
BEGIN
    WHILE N > 0 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N-1;
    END LOOP;
END;
/

--2~9사이 수 입력 받아 구구단 출력
DECLARE
    DAN NUMBER;
    N NUMBER := 1;
BEGIN
    DAN := &단;
    IF DAN BETWEEN 2 AND 9 THEN
        WHILE N <=9 LOOP
            DBMS_OUTPUT.PUT_LINE(DAN||' * '||N||' = '||DAN*N);
            N := N + 1;
        END LOOP;
    END IF;
END;
/

--대입할 '=' '&' 두가지 사용
--  '=' 값 직접 대입
--  '&' 사용자 입력값 대입
--      기존의 데이터 접근할 때, 정적인 SQL에서 벗어나서
--      동적인 SQL을 구현

--  기존 '정적' SQL
select * from employee where emp_name='유재식';
--  '동적' SQL
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE emp_name = '&사원명';
    DBMS_OUTPUT.PUT_LINE('사원번호: ' || E.emp_id);
    DBMS_OUTPUT.PUT_LINE('사원명: ' || E.emp_name);
    DBMS_OUTPUT.PUT_LINE('사원급여: ' || E.salary);
END;
/

--RECORD 자료형
--  기존 일반변수 / 참조변수
--  %ROWTYPE이 참조할 테이블 컬럼데이터 타입을 자동으로 가져옴

--  RECORD 특정 테이블의 컬럼을 각각 뽑아 별도의
--  한행짜리 자료형 선언을 하는것.

/*  사용법
    TYPE record_type_name IS RECORD(변수명 변수타입, ...);
    레코드객체 레코드타입명;
*/
DECLARE
    TYPE my_record IS RECORD(
        my_id EMPLOYEE.EMP_ID%TYPE,
        my_name EMPLOYEE.EMP_NAME%TYPE
    );
    v_emp my_record;
BEGIN
    SELECT emp_id, emp_name
    INTO v_emp
    FROM EMPLOYEE
    WHERE emp_name='선동일';

    DBMS_OUTPUT.PUT_LINE('사번: '||v_emp.my_id);
    DBMS_OUTPUT.PUT_LINE('사원명: ' || v_emp.my_name);
END;
/

--사번 사원명 직급명 담을 참조변수로 송종기사원
--사번,사원명,직급명 출력
DECLARE
    TYPE my_r_type IS RECORD(
        emp_id EMPLOYEE.emp_id%TYPE,
        emp_name EMPLOYEE.emp_name%TYPE,
        job_name JOB.job_name%TYPE
    );
    v_emp my_r_type;
BEGIN
    SELECT emp_id, emp_name, job_name
    INTO v_emp
    FROM EMPLOYEE JOIN JOB USING (job_code)
    WHERE emp_name = '송종기';

    DBMS_OUTPUT.PUT_LINE('id = ' || v_emp.emp_id);
    DBMS_OUTPUT.PUT_LINE('name = ' || v_emp.emp_name);
    DBMS_OUTPUT.PUT_LINE('position = ' || v_emp.job_name);
END;
/

--EXCEPTION 예외처리: 실행부 안에서 사용
/*
    EXCEPTION
        WHEN 예외명 THEN 처리문장1
        WHEN 예외명 THEN 처리문장2
        WHEN 예외1 OR 예외2 THEN 처리문장3
        WHEN OTHERS THEN 처리문장4
*/
/*
오라클에서 제공하는 예외 별칭들... 몇가지만..
    NO_DATA_FOUND : select 한 결과가 하나도 없는 경우.
    CASE_NOT_FOUND : CASE 구문 일치하는 결과가 없고, ELSE 처리를 하지 않은 경우.
    LOGIN_DENIED : 잘못된 아이디나 비밀번호를 입력하였을 경우
    DUP_VAL_ON_INDEX : UNIQUE 제약 조건을 위배했을 경우
    INVALID_NUMBER : 문자데이터를 숫자로 변경할때 변경할 수 없는 문자인 경우.
*/
BEGIN
    UPDATE EMPLOYEE
    SET emp_id=201
    WHERE emp_id=200;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('이미 존재하는 사원입니다.');
END;
/

--사용자 정의 예외처리
--프로그래머가 정의
--RAISE_APPLICATION_ERROR() 사용하여
--오류코드 -20000~-20999의 범위에서 만들거나
--RAISE(자바에서는 THROW) 사용해서 예외를 발생 시킬 수 있다.

/*
사용방법
    RAISE_APPLICATION_ERROR (에러코드, 메시지);
    RAISE 예외;
*/

CREATE TABLE test_member(
    mid VARCHAR2(20) PRIMARY KEY,
    pwd VARCHAR2(30),
    name VARCHAR2(15)
);

select * from test_member;

DECLARE
    v_pwd VARCHAR2(30);
    toolong_name EXCEPTION;
    tooshort_pwd EXCEPTION;
    toolong_pwd EXCEPTION;
    PRAGMA EXCEPTION_INIT(toolong_name, -12899);
    PRAGMA EXCEPTION_INIT(tooshort_pwd, -20001);
    PRAGMA EXCEPTION_INIT(toolong_pwd, -20999);
    --PRAGMA EXCEPTION_INIT(예외명, 예외번호);
     --예외번호를 명시해서, 컴파일러에 이 예외를
    --사용한다는 것을 알리는 역할
BEGIN
    v_pwd := '&비밀번호';
    IF LENGTH(v_pwd) <8 THEN
        RAISE tooshort_pwd;
    ELSIF LENGTH(v_pwd) > 20 THEN
        RAISE toolong_pwd;
    END IF;

    INSERT INTO test_member VALUES('USER02', v_pwd, '고길동');
EXCEPTION
    WHEN tooshort_pwd THEN
        DBMS_OUTPUT.PUT_LINE('비밀번호는 8자리 이상으로!!!');
    WHEN toolong_pwd THEN
        DBMS_OUTPUT.PUT_LINE('비밀번호는 20자리 이하로!!!');
END;
/

--PROCEDURE
--  PL/SQL을 미리 저장해놓고, procedure_name으로 호출하여
--  함수처럼 동작시키는 PL/SQL 객체
/* [사용형식]
    CREATE [OR REPLACE] PROCEDURE 프로시저명 (
        매개변수 1 [IN/OUT/IN OUT] 자료형,
        매개변수 2,
        ...
    );
    -- IN : 프로시저에서 사용할 변수값을 외부에서 넣겠다.
    -- OUT : 프로시저를 실행한 결과를 외부로 추출할때(RETURN)
    -- INOUT : IN과 OUT 두가지 기능 둘다 가능
               (단, IN과 OUT 두가지 중 하나만 사용 가능 - 권장 X)
    IS
    DECLARE(선언부)
    BEGIN
        실행할 부분
    END;
    /

  [호출방식]
    EXECUTE procedure_name(param1, param2, ...);
       EXEC procedure_name(param1, param2, ...);
  [삭제]
    DROP PROCEDURE 프로시저명;

  [프로시저를 조회]
    -- 데이터사전: user_source;
    select * from user_soruce;
*/

--직원 정보를 모두 삭제하는 프로시져 구현하기
CREATE TABLE emp_tmp AS (select * from employee);

--프로시져 생성
CREATE OR REPLACE PROCEDURE del_all_emp
IS
BEGIN
    DELETE FROM emp_tmp;
    COMMIT;
END;
/

--프로시져 선언만 했고, 바로 실행안됨
select count(*) from emp_tmp; --33
EXEC del_all_emp;
select count(*) from emp_tmp; --0

DROP TABLE emp_tmp;

--매개변수를 갖는 프로시져
--  [IN]
CREATE TABLE emp_tmp_01 AS (select * from EMPLOYEE);

--프로시져 생성(매개변수)
CREATE OR REPLACE PROCEDURE del_emp_name (
    v_name IN EMP_TMP_01.EMP_NAME%TYPE)
IS
BEGIN
    DELETE FROM emp_tmp_01
    WHERE emp_name like v_name;
    DBMS_OUTPUT.PUT_LINE(v_name || '직원정보 삭제!!');
    COMMIT;
END;
/

--특정 이름을 가진 사원 삭제
select * from emp_tmp_01 where emp_name='이오리';
EXEC DEL_EMP_NAME('이오리');
select * from emp_tmp_01 where emp_name='이오리';

select * from emp_tmp_01 where emp_name like '이%';
EXEC DEL_EMP_NAME('이%');
select * from emp_tmp_01 where emp_name like '이%';


--[OUT]
--  내부의 값을 외부로 전달하는 방식
--  값을 받을 수 있게 변수 생성

--  변수선언
--  VARIABLE 변수명 자료형(바이트);

--  실행
--  EXEC 프로시져명(전달값, :전달받을 변수명);

/*
METHOD(30);
INT NO = METHOD2();
INT NO = METHOD3(30);
*/

--직원 정보를 조회하여 변수에 직원 정보 추가 후
--밖으로 OUT 해보자
CREATE OR REPLACE PROCEDURE
    emp_info(vemp_id IN EMPLOYEE.EMP_ID%TYPE, --매개변수들 선언
             vemp_name OUT EMPLOYEE.EMP_NAME%TYPE,
             vphone OUT EMPLOYEE.PHONE%TYPE,
             vemail OUT EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    SELECT emp_name, phone, email
    INTO vemp_name, vphone, vemail
    FROM EMPLOYEE
    WHERE emp_id = vemp_id;
END;
/

--변수선언 -> 프로시져를 통해 OUT되는 데이터를 담는다.
VARIABLE var_ename VARCHAR2(20);
VARIABLE var_phone VARCHAR2(20);
VARIABLE var_email VARCHAR2(20);

EXEC emp_info(201, :var_ename, :var_phone, :var_email);

--변수확인
PRINT var_ename;
PRINT var_phone;
PRINT var_email;

SET AUTOPRINT ON;
--프로시져 실행하고 EXEC하면, 전부 출력됨

select * from user_source;

--부서코드 입력받아 해당 부서 정보 삭제후
--  삭제된 부서이름을 출력하는 프로시져
--  단 만약 조회한 부서 없을겨우
--  NO_DATA_FOUND 사용하여 '해당 부서가 존재하지 않습니다.' 출력
CREATE TABLE dept_01 AS (select * from department);
DROP TABLE dept_01;

CREATE OR REPLACE PROCEDURE del_dept(
    v_dept_id IN DEPT_01.DEPT_ID%TYPE,
    v_dept_title OUT DEPT_01.DEPT_TITLE%TYPE)
IS
BEGIN
    SELECT dept_title
    INTO v_dept_title
    FROM dept_01
    WHERE dept_id=v_dept_id;

    DELETE FROM dept_01
    WHERE dept_id=v_dept_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(v_dept_title || ' 부서가 성공적으로 삭제되었습니다.');

EXCEPTION 
    WHEN NO_DATA_FOUND
        THEN DBMS_OUTPUT.PUT_LINE('해당부서 ' || v_dept_id || ' 가 존재하지 않습니다.');
        RETURN;
END;
/

VARIABLE dept_title VARCHAR2(35);
select * from dept_01;
EXEC del_dept('&부서코드', :dept_title);
select * from dept_01;
EXEC del_dept('D2', :dept_title);

PRINT dept_title;


--FUNCTION 함수
--  similar to procedure, 
--  but has RETURN value.
--  사원번호를 입력받아 1년치 연봉+보너스 계산하여
--  반환하는 함수를 정의하세요

CREATE OR REPLACE FUNCTION bonus_cal(
    v_emp_id EMPLOYEE.emp_id%TYPE)
RETURN NUMBER
IS
    v_sal EMPLOYEE.salary%TYPE;
    v_bonus EMPLOYEE.bonus%TYPE;
    v_cal_sal NUMBER;
BEGIN
    SELECT salary, nvl(bonus,0)
    INTO v_sal, v_bonus
    FROM EMPLOYEE
    WHERE emp_id = v_emp_id;

    v_cal_sal := 12*v_sal*(1 + v_bonus);
    RETURN v_cal_sal;
END;
/

SET SERVEROUTPUT ON;

select bonus_cal('&emp_id') from dual;

VARIABLE var_re NUMBER;
--EXEC procedure_name(200, :out_param1, :out_param2);
--EXEC :out_param := procedure_name(in_param);
EXEC :var_re := bonus_cal('&emp_id');
PRINT var_re;

--사원번호를 입력받아 성별 RETURN
CREATE OR REPLACE FUNCTION f_gender(
    v_emp_id EMPLOYEE.emp_id%TYPE)
RETURN VARCHAR2
IS
    v_gender VARCHAR2(10);
BEGIN
    SELECT DECODE( substr(emp_no,8, 1),
           '1', '남', '3', '남', '여')
    INTO v_gender
    FROM EMPLOYEE
    WHERE emp_id = v_emp_id;

    RETURN v_gender;
END;
/

select f_gender('&employee_id') from dual;

VARIABLE var_re VARCHAR2(10);
EXEC :var_re := f_gender('&employee_id');
PRINT var_re;

select * from all_errors;

--CURSOR
--  SELECT 문 결과 여러ROW일때, 한개 행씩  접근하여 처리
--  CURSOR에 RESULTSET을 보관하고 FETCH로 다음행으로 연결
--
--  [사용법]
--  CURSOR를 변수로 선언하고, 선언한 변수 CURSOR를 OPEN으로 연다.
--  반복문 안에서 FETCH를 통해 한 행씩 종료되면, CLOSE 명령으로 CURSOR 닫음
--
--  [CURSOR에 데이터 존재여부 확인하는 방법]
--  %NOTFOUND : OPEN 후 FETCH 전에 NULL, FETCH된 행이 존재하면 FALSE, 존재하지 않으면 TRUE
--  %FOUND : FETCH 된 행이 존재하면 TRUE, 아니면 FALSE
--  %ISOPEN : 최근 실행된 CURSOR가 OPEN 된 상태이면 TRUE, 아니면 FALSE
--  %ROWCOUNT : CURSOR에 들어가 있는 ROW 수

--  부서코드 부서명 지역코드를 모두 출력하는
--  커서를 이용한 프로시져를 작성
CREATE OR REPLACE PROCEDURE cursortest
IS
    v_dept DEPARTMENT%ROWTYPE;
    CURSOR C1  -- 9개의 행이 CURSOR C1 로 전부 들어감
    IS
    SELECT * FROM DEPARTMENT;
BEGIN
    OPEN C1;
    LOOP
        FETCH C1 INTO v_dept.dept_id,
                      v_dept.dept_title,
                      v_dept.location_id;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('부서코드: ' || v_dept.dept_id
                             ||', 부서명: ' || v_dept.dept_title
                             ||', 지역코드: '|| v_dept.location_id);
    END LOOP;
    CLOSE C1;
END;
/
SET SERVEROUTPUT ON;
EXEC cursortest;

DECLARE
    v_user EMPLOYEE%ROWTYPE;
    CURSOR C1
    IS
    SELECT * FROM EMPLOYEE;
BEGIN
    OPEN C1;
    LOOP
        FETCH C1 INTO v_user;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('이름 : ' || v_user.emp_name);
    END LOOP;
    CLOSE C1;
END;
/

--FOR IN 을 이용하여 처리하는 방법
--  CURSOR를 open/close 안해도 됨.
DECLARE
    v_dept DEPARTMENT%ROWTYPE;
    CURSOR C2
    IS SELECT * from department;
BEGIN
    --OPEN C2
    --FETCH C2 INTO
    FOR v_dept IN C2 LOOP
        DBMS_OUTPUT.PUT_LINE('부서코드' || v_dept.dept_id);
    END LOOP;
END;
/

--TRIGGER : DML(insert,update,delete)실행전,후에 발생시킨
--  실행 구문을 정해놓고 실행시키는 것
--  CREATE 명령어로 생성
--  after/before 실행시점
--  실행할 명령어를 지정
--  행단위로 실행 할 지 여부.
--  CREATE TRIGGER trigger_name
--  AFTER/BEFORE 실행명령어 ON table_name
--  FOR EACH ROW
--  PL/SQL 구문실행 (BEGIN~END)
--  명령어 : 
--      new.컬럼 : 지금 수정 삽입된 자료(update,insert에만)
--      old.컬럼 : 수정, 삭제 이전에 있던 값 (update, delete에만)

-- trigger 생성하면 자동으로 돌아감
CREATE OR REPLACE TRIGGER tg_empnew
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원 등록완료!');
END;
/

SELECT * from user_triggers;

INSERT INTO employee VALUES(
    996, '박수영', '961222-2112333', 'red@sm.co.kr', '01011223344',
    'D1', 'J2', 'S2', 1500000, 0.3, 200, SYSDATE, DEFAULT, DEFAULT);
INSERT INTO employee VALUES(
    996, '박수영', '961222-2112333', 'red@sm.co.kr', '01011223344',
    'D1', 'J2', 'S2', 1500000, 0.3, 200, SYSDATE, DEFAULT, DEFAULT);
select * from employee;

DELETE FROM employee where emp_name='박수영';

COMMIT; --COMMIT해야 메시지 출력
--AUTO COMMIT 설정시 INSERT 마다 출력

--
CREATE OR REPLACE TRIGGER tg_sal
AFTER UPDATE ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('변경전 값 : ' || :OLD.salary);
    DBMS_OUTPUT.PUT_LINE('변경후 값 : ' || :NEW.salary);
END;
/

UPDATE employee SET SALARY = SALARY * 3 WHERE emp_name='유병승';
select emp_name, salary from employee where emp_name='유병승';

ROLLBACK;

SELECT * from user_triggers;

--TRIGGER 적용하기
CREATE TABLE product(
    pcode NUMBER PRIMARY KEY,
    pname VARCHAR2(30),
    brand VARCHAR2(30),
    price NUMBER,
    stock NUMBER DEFAULT 0
);
--입고 출고 관리 테이블
CREATE TABLE product_IO(
    icode NUMBER PRIMARY KEY,
    pcode NUMBER,
    pdate DATE,
    amount NUMBER,
    status VARCHAR2(10) CHECK(status in ('입고', '출고')),
    CONSTRAINT fk_proc_io FOREIGN KEY(pcode) REFERENCES product(pcode)
);
DROP TABLE product;
DROP TABLE product_io;

select * from product;
select * from product_io;

CREATE SEQUENCE seq_proc;
CREATE SEQUENCE seq_proc_io;

DROP SEQUENCE seq_proc;
DROP SEQUENCE seq_proc_io;

INSERT INTO product VALUES(seq_proc.nextval, 'IPad', 'APPLE.INC', 1500000, DEFAULT);
INSERT INTO product VALUES(seq_proc.nextval, 'IPone', 'APPLE.INC', 1000000, DEFAULT);
INSERT INTO product VALUES(seq_proc.nextval, 'Galaxy S10', 'SAMSUNG', 190000, DEFAULT);

select * from product;

--TRIGGER IO테이블 값이 입력되면 입력되는 것을 기준으로
--product 수량의 수정하는 trigger 생성
CREATE TRIGGER tg_product
AFTER INSERT ON PRODUCT_IO
FOR EACH ROW
BEGIN
    IF :new.status='입고' THEN
        UPDATE product
        SET stock = stock +:new.amount
        WHERE pcode = :new.pcode;
    ELSIF :new.status='출고' THEN
        UPDATE product
        SET stock = stock  - :new.amount
        WHERE pcode = :new.pcode;
    END IF;
END;
/
DROP TRIGGER tg_product;

INSERT INTO product_io VALUES(seq_proc_io.nextval, 1, SYSDATE, 10, '입고');
INSERT INTO product_io VALUES(seq_proc_io.nextval, 2, SYSDATE, 50, '입고');
INSERT INTO product_io VALUES(seq_proc_io.nextval, 3, SYSDATE, 100, '입고');

select * from user_sequences;
--EMPLOYEE 테이블에서 사원을 삭제하면 삭제테이블로 이동
CREATE TABLE del_emp AS (select * from employee where 1=0);

CREATE TRIGGER tg_del_emp
AFTER DELETE ON EMPLOYEE
FOR EACH ROW
WHEN (OLD.emp_name <> '유병승')
BEGIN
    INSERT INTO del_emp VALUES
    (:OLD.EMP_ID, :OLD.EMP_NAME, :OLD.EMP_NO, :OLD.EMAIL, :OLD.PHONE, 
     :OLD.DEPT_CODE, :OLD.JOB_CODE, :OLD.SAL_LEVEL, :OLD.SALARY, :OLD.BONUS, 
     :OLD.MANAGER_ID, :OLD.HIRE_DATE, :OLD.ENT_DATE, :OLD.ENT_YN);
END;
/

DROP TRIGGER tg_del_emp;

INSERT INTO employee VALUES( 995, '박수영2', '961223-2112333', 'red@sm.co.kr',
    '01011223344', 'D1', 'J2', 'S2', 1500000, 0.3, 200, SYSDATE, DEFAULT, DEFAULT);

DELETE FROM EMPLOYEE WHERE  emp_name='박수영2';
DELETE FROM EMPLOYEE WHERE  emp_name='유병승';
ROLLBACK;

select * from del_emp;

DESC EMPLOYEE;

COMMIT;
ROLLBACK;