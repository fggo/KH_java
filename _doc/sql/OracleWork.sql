select * from dba_users;
-- resouce권한 : 테이블 생성, 수정, 삭제 할 수 있는 권한이 모두 있는것
grant resource to kh;
--자료형을 알아보자
--number자료형 : 숫자를 표현하는 것
--사용 : number[(p:전체자리수,s:전체 자리수 중 소주점의 수)]
create table numberTest(
    a number(7,3),
    b number(7),
    c number,
    d number(7,1),
    e number(5,-2)
);
--생성한 테이블 조회
select * from numbertest;
--작성된 테이블에 값을 넣어보자!
insert into numbertest
values(1234.567,1234.567,1234.567,1234.567,1234.567);

--문자열타입을 저장해보자
--char : 고정길이 최대 2000byte
--nchar : 유니코드 고정길이 최대 글자수 1000개까지

--varchar2 : 가변길이 최대 4000byte
--navarchar2 :유니코드 가변길이 최대 글자수 2000개까지
--사용법 : 자료형(길이)
--char(10) -> 10byte만큼 저장이되는 공간, 무조건 10byte 다 사용
--varchar2(10) -> 10byte만큼 저장이 되는공간, 대입되는 값의 크기에 따라 사용
--               공간이 정해짐
--오라클 express 한글 3byte로 처리됨.
--nchar/nvarchar2(10) -> 글자수 설정 10글자만큼 저장되는 공간 확보

create table chartest(
    a char(6),
    b varchar2(6),
    c nchar(6),
    d nvarchar2(6)
);
select * from chartest;
insert into chartest values('abc','abc','abcdef','abcdef');
insert into chartest values('abcefg','abcefg','abcdef','abcdef');
insert into chartest values('abcefg123','abcefg123','abcdef','abcdef');
insert into chartest values('유뱅','유뱅','유병승','유병승');
insert into chartest values('유뱅','유뱅','유병승천재','유병승천재');
--메모리 공간에서 저장하고 있는 상태 트랜젝션관리!
--commit을 하면 물리적인 저장소에 완전히 저장함
commit;
show user;
--저장된 데이터의 크기와 문자수를 확인
--오라클에서 제공하는 함수 length
select a,length(a),lengthb(a),
       b,length(b),lengthb(b),
       c,length(c),lengthb(c),
       d,length(d),lengthb(d)
from chartest;

--날짜자료형
--현재날짜를 표시해주는 system 컬럼
--sysdate : 현재날짜를 출력해주는 컬럼
select sysdate from dual;
--dual : 오라클에서 기본적으로 제공하는 template테이블
--       테스트용 테이블
select length('큰언니') from dual;
--날짜의 산술연산 (날짜와 숫자)
select sysdate-1 from dual;
select sysdate-10 from dual;
select sysdate-30 from dual;
select sysdate+4 from dual;
--date끼리의 산술연산(날짜와 날짜)
select to_date('20000224','yyyymmdd')-sysdate from dual;

--년,월,일
select sysdate from dual;

--시간까지 출력
--systimestamp
select systimestamp from dual;
--날짜로 형변환
select to_date('20000224') from dual;
create table datetest(
    today date,
    birthday date,
    temp timestamp
    );
select * from datetest;
--date입력시 date형식으로 맞춰서 문자를 입력하면 자동으로
--date형으로 변환되어 대입되고, 
--강제적으로 to_date를 이용하여 형변환하여 대입할수도 있음
--형변환을 이용하는것이 안정적임.(둘다 사용해도 큰 문제는 없음)
insert into datetest values('19/06/13','00/02/24','19/06/13 11:15:00');
insert into datetest values(to_date('20190613'),to_date('20000224')
,to_timestamp('20190613111500'));

--테이블 컬럼의 자료형을 확인하고 싶을때???
--desc 명령어를 이용하여 처리
-- desc 테이블명
desc chartest;

--@실습문제 
--today회사의 회원테이블을 만든다. 다음조건을 만족하는 컬럼데이터타입을 작성하자.
--id : 6자리에서 15자리(변동가능성 없음)
--password : 8자리이상 15자리
--name : 한글입력
--phone : - 없이 11자리
--ssn 주민등록번호 : -없이 13자리
--mileage 회원마일리지 : 
--reg_date 가입일 : 
create table member(
    id char(15),
    password varchar2(15),
    name varchar2(15),
    phone number(11),
    ssn number(13),
    mileage number,
    red_date date
);
--테이블에 있는 데이터를 조회하기
--명령어 select 
--명령구조 :  select 컬럼,컬럼1.... from 테이블명 where 검색조건
--kh.employee테이블의 데이터를 조회
select emp_name, emp_id, email 
from employee;
--employee테이블에서 emp_no, salary, dept_code를 조회
select emp_no, salary, dept_code
from employee;
--department테이블 dept_id, dept_title출력
select dept_id, dept_title
from department;

desc employee;
select * from tab;

select * from employee;
--select문에서 산술연산도 가능함
--연산식의 위치는 컬럼명이 들어가는곳에 연산을 해주면
--그 연산명이 컬럼명이 되고 계산된값이 각 row에 들어간다.
select emp_name, salary, salary*12 from employee;
select emp_name, salary, bonus*12 from employee; 
select emp_name, salary, bonus+12 from employee; 
select emp_name, salary, bonus-12 from employee; 
select emp_name, salary, bonus/12 from employee; 
--%연산은 기본 산술연산자로 등록되어있지않음 mod함수를 이용해야함.
select emp_name, salary, bonus%12 from employee; 

--nvl함수는 컬럼의 데이터가 null일때 null대체해줄 값을 지정
--nvl(컬럼명,대체할값)
select emp_name, salary*12 as 연봉,
        (salary+(salary*nvl(bonus,0)))*12 as "총수령액(원)",
        (salary+(salary*nvl(bonus,0)))*12-(salary*0.03*12) "실 수령액"
        from employee;
select emp_name, sysdate-hire_date from employee;

--테이블에 리터럴값 넣기
select emp_name, salary,'원' as 통화 from employee;
select emp_name, salary,101 as 테스트 from employee;
--distict 중복된 값이 있으면 한번만 출력해라~!
select emp_name, dept_code 
from employee;
select distinct dept_code 
from employee;
--distinct는 하나의 select문안에 두개를 사용할 수 없음
select distinct dept_code, distinct job_code
from employee;
--distinct값을 여러컬럼에 쓸 수 있음
select distinct dept_code, job_code 
from employee;
--where사용하기
--where절은 resultSet에서 필요한 row들(튜플)만 필터링할때 사용한다.
--select 컬럼명, 컬럼명2... from 테이블명 where 컬럼명 비교연산자 값
select * from employee;
select * from employee where job_code='j5';
select * from tab where tname='EMPLOYEE';
--크기비교
select emp_name, salary from employee where salary>5000000;

select emp_name,salary from employee 
where (salary+(salary*bonus))*12-(salary*0.03*12)>50000000;

--논리연산사용하기
--and/or
select * from employee 
where dept_code!='D6' and salary > 3000000;
--job_code가 j3이거나 sal_level s3인 사원출력
select * from employee
where job_code='J3' OR sal_level='S5';
--비교연산자를 여러개 묶기
select * from employee 
where salary>3000000 and job_code='J3' and dept_code='D5';
--직급코드가 J1이 아닌 사원들의 월급등급(sal_level)을 중복없이 출력하세요.
select distinct sal_level from employee where job_code^='J1';
--급여를 3500000원이상 6000000원 이하인 사원 이름과 급여 조회
select emp_name, salary from employee 
where salary>=3500000 and salary <=6000000;
--연결연산자
select emp_no, emp_name, email from employee;
select emp_no||emp_name||email from employee;
select emp_name||'님 안녕하세요 당신은 '||salary||'원 만큼 받나요?'
from employee;
select emp_name, salary from employee
where salary>=3000000 and salary<=6000000;
--between을 사용하여 똑같은 결과를 출력할 수 있음
select emp_name, salary from employee
where salary between 3000000 and 6000000;
--부정연산이용해서 범위 밖에 값을로 출력할 수 있음
select emp_name, salary from employee
where salary not between 3000000 and 6000000;
--
select * from employee 
where hire_date between '90/01/01' and '01/01/01';
--where hire_date>='90/01/01' and hire_date<='01/01/01';

--like 이용하기 like는 문자의 패턴을 확인하여 검색하는방법으로
--내용의 부분검색을 할때 사용할 수 있음
--송씨성을 가진 사원조회
select * from employee
where emp_name like '송%';
--승으로 끝나는 이름을 가진 사원조회
select * from employee
where emp_name like '%기';

--email주소에 문자 'n'포함된 주소를 가지고 있는 사원출력
select email from employee
where email like '%un%';
--'_' 패턴을 이용하여 조회해보자
select email from employee
where email like '__n%';
select emp_name from employee
where emp_name like '유__';
select emp_name from employee
where emp_name not like '%송%';

--이름 가운데 글자가 '옹'인 사원 조회(이름은 모두 3글자임)

--이름에 '이'가 들어가는 사원을 모두 출력하세요.

--1. EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오

--2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 출력하시오

select email from employee;
--'_'앞에가 세글자인 데이터를 출력
--_를 escape문으로 등록을 해주고 처리하면됨

select email from employee
where email like '___#_%' escape '#'; 

--실습문제
create table tbl_escape_watch(
watchname   varchar2(40)
,description    varchar2(200)
);
insert into tbl_escape_watch 
values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch 
values('은시계', '고객 만족도 99.99점를 획득한 고급시계');

--description 컬럼에 99.99% 라는 글자가 들어있는 행만 추출하세요.

--1. EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오
--2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 
--아닌 사원의 이름, 전화번호를 출력하시오
--3. EMPLOYEE 테이블에서 메일주소 '_'의 앞이 4자이면서, 
--DEPT_CODE가 D9 또는 D6이고
--고용일이 90/01/01 ~ 00/12/01이면서, 
--월급이 270만원인 사원의 전체 정보를 출력하시오

--isnull / is not null : null값을 찾을 때 사용
--사용 : 컬럼명 is null OR 컬럼명 is not null
select * from employee;
select emp_name, salary, bonus from employee
where bonus=(null);--안돼~에~!!
select emp_name, salary, bonus from employee
where bonus is null;
select emp_name, salary, bonus from employee
where bonus is not null and salary>=3000000;
select emp_name, dept_code from employee
where dept_code is null;
--in : 여러값을 OR로 연결하여 동등비교하는 것!
-- 사용 : 컬럼명 in (비교값, 비교값1, 비교값2....)
select emp_name,job_code from employee
where job_code in('J3','J2');--job_code='J3' OR job_code='J2'
select emp_name, job_code from employee
where job_code in(select job_code 
                    from employee 
                    where salary>3000000);
--in을 이용해서 유재식, 전형돈, 이태림 찾기 이름출력
--in을 이용해서 유재식, 전형돈, 이태림을 제외한 사원찾기
select emp_name from employee
where emp_name not in('유재식','전형돈','이태림');

select dept_code, hire_date from employee
where (dept_code='D9' OR dept_code='D6') 
and hire_date between '99/01/01' and '00/12/01';

select emp_name, salary, job_code
from employee
where (job_code='J7' OR job_code='J2') AND salary > 2000000;
--where salary > 2000000 AND job_code='J7' OR job_code='J2';

--order by를 이용한 데이터 정렬
--order by절은 항상 구문의 맨마지막에 작성을 한다.
select * from employee;
--이름 순으로 정렬하기 정렬에 대한 옵션을 설정하지 않으면
--default : 오름차순정렬(ASC)
select * from employee
order by emp_name asc;
--내림차순정렬(DESC)
select * from employee
order by emp_name desc;
--정렬시 null값을 확인
select emp_name, salary, bonus from employee
order by bonus;--기본 오름차순에선 null맨아래로 정렬
select emp_name, salary, bonus from employee
order by bonus desc;--내림차순일경우 null맨 위로 정렬
--null의 정렬 순서를 변경하고 싶으면 nulls옵션 사용
select emp_name, salary, bonus from employee
order by bonus nulls first;
select emp_name,salary, bonus from employee
order by bonus DESC nulls last;
--정렬할때 한개이상의 컬럼을 선택할 수 있음
--order by 컬럼명, 컬럼명...
select emp_name, dept_code, job_code from employee;
select emp_name,job_code, dept_code  from employee
order by job_code DEsc, dept_code desc;
--정렬시 컬럼명이 아닌 인덱스번호로 정렬이 가능
select emp_name, salary, bonus from employee
order by salary;
select emp_name, salary, bonus from employee
order by 2;
select emp_name, salary, bonus from employee
order by 3 desc nulls last;
--length함수 사용하기
select emp_name, length(emp_name),lengthb(emp_name),
email, length(email),lengthb(email) from employee;
desc employee;
--리터럴값의 길이를 구할 수 있음
select emp_name, length(emp_name),length('하아호아뢔어') from employee;

--dual가상테이블을 이용하여 출력
select length('하하호호아줌마') from dual;
--instr : 매개변수로 들어온 문자에서 특정문자의 위치를 찾을 때사용
select instr('funkkkky','k') from dual;
select instr('funkakkaaakay','k',4,2) from dual;
select email, instr(email,'_') from employee;
select email,substr(email,instr(email,'@')) from employee;
--LPAD/RPAD:특정문자를 채우는 함수
select LPAD('멋있어요',20,'하') from dual;
select RPAD('멋있어요',20,'하') from dual;
select RPAD(emp_name,8,'님') from employee;
--LTRIM/RTRIM : 문자열의 왼쪽 또는 오른쪽의 지정된 문자를 제거
select '     TRIM', LTRIM('     TRIM') from dual;
select 'kkkkktrim',LTRIM('kkkkktrim','k') from dual;
select 'khkhkhkhkhtrim',LTRIM('khkhkhkhkhtrim','kh') from dual;
select 'kkkkhhhhtrim',LTRIM('kkkkhhhhtrim','kh') from dual;
select 'kkkkahhhhtrim',LTRIM('kkkkahhhhtrim','kh') from dual;
select 'kkkkahhhhtrimkkkkkhhh',RTRIM('kkkkahhhhtrimkkkkkhhh','kh') from dual;
select 'akkkahhhhtrimkkkkkhhha',RTRIM('akkkkahhhhtrimkkkkkhhha','kh') from dual;
select '1204383983339172유병승', LTRIM('1204383983339172유병승','0987654321') from dual;
select '12309548321389유병승10239148105138' from dual;
select RTRIM(LTRIM('12309548321389유병승10239148105138','0987654321'),'1234567890') from dual;
--유병승만 출력될수있게 만들어보세요!
--trim : 양쪽의 특정 단일문자 제거
select '   kh   ',TRIM('   kh   ') from dual;
select 'ZZZZkhZZZZZ',TRIM('Z' FROM 'ZZZZkhZZZZZ') from dual;
--select 'ZZZZkhZZZZZ',TRIM('Za' FROM 'ZZZZkhZZZZZ') from dual;
select 'ZZZZkhZZZZZ',TRIM(LEADING 'Z' FROM 'ZZZZkhZZZZZ') from dual;
select 'ZZZZkhZZZZZ',TRIM(TRAILING 'Z' FROM 'ZZZZkhZZZZZ') from dual;
select 'ZZAZZkhZZZAZZ',TRIM('Z' FROM 'ZZAZZkhZZAZZZ') from dual;

--SUBSTR : 특정문자열의 일부분 잘라냄
SELECT SUBSTR('SHOWMETHEMONEY',5,2) FROM DUAL; 
SELECT SUBSTR('SHOWMETHEMONEY',5) FROM DUAL; 
SELECT SUBSTR('SHOWMETHEMONEY',-8,3) FROM DUAL;
SELECT SUBSTR('여러분 힘내세요 오늘 금요일이에요',5,4) FROM DUAL; 
--EMPLOYEE테이블 사원명에서 성(유씨,김씨 박씨 등)만 중복없이 사전순으로 출력
SELECT DISTINCT SUBSTR(EMP_NAME,1,1) AS EMP_NAME FROM EMPLOYEE
ORDER BY EMP_NAME;


--영문자를 대문자, 소문자, 첫글자대문자로 변경해주는 함수
--LOWER, UPPER, INITCAP
SELECT LOWER('KOREA') FROM DUAL;
SELECT UPPER('korea') from dual;
SELECT UPPER('KorEa') from dual;
select initcap('show me the money') from dual;
--문자열을 결합하는 함수 concat == ||
select concat(emp_name, email) from employee;
select emp_name||email from employee;
select emp_name||hire_date from employee;
select concat(emp_name, hire_date) from employee;
--replace : 특정문자를 원하는문자로 변경
select replace('puppy','p','b') from dual;
select replace(email,substr(email,instr(email,'@')),'@naver.com')
from employee;
'@kh.or.kr'
select email from employee;

select * from employee;
select * from employee 
where substr(emp_no,8,1)=2;

--숫자처리 함수 
--abs : 절대값
select abs(10),abs(-10) from dual;
--mod : 나머지값 구하는것
select mod(10,2), mod(10,3) from dual;
--round : 반올림하는 함수(특정위치에서)
select round(234.678) from dual;
select round(234.478) from dual;
select round(234.678,2) from dual;
select round(bonus,1) from employee;
select hire_date-sysdate from employee;
select round(hire_date-sysdate) from employee;
--floor : 소수점자리를 버림~
select floor(234.678) from dual;
select floor(bonus) from employee;
select floor(hire_date-sysdate) from employee;
--trunc : 소수점 버림 특정위치에서 버릴수있음.
select trunc(234.678,1) from dual;
--ceil : 무조건올림! 
select ceil(234.678) from dual;
select ceil(234.178) from dual;
select ceil(234.078) from dual;

--파일경로를 제외하고 파일명만 아래와 같이 출력하세요.
create table tbl_files
(fileno number(3)
,filepath varchar2(500)
);

insert into tbl_files values(1, 'c:\abc\deft\salesinfo.xls');
insert into tbl_files values(2, 'c:\music.mp3');
insert into tbl_files values(3, 'c:\documents\resume.hwp');

select * from tbl_files;
select substr(filepath,instr(filepath,'\',-1)+1) from tbl_files;
--날짜처리 함수
--MONTHS_BETWEEN : 입력받은 두개의 날짜사이의 개월수를 출력
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE('20000224','YYYYMMDD')))||'개월' 
FROM DUAL;
SELECT MONTHS_BETWEEN(SYSDATE,HIRE_DATE) FROM EMPLOYEE;
-- ADD_MONTHS : 개월를 추가해주는거 더해주는것
SELECT TO_DATE('20000224','YYYY/MM/DD') FROM DUAL;
SELECT TO_DATE('20000224','YYYY/MM/DD'),
ADD_MONTHS(TO_DATE('20000224','YYYY/MM/DD'),5) FROM DUAL;
--오늘부로 무관씨가 군대에 또 가게 됨.
--군복무기간이 1년6개월이라고 가정
--1. 제대일자를 구하고
--2. 먹을 짬밥수(급식)를 구하세요
-- 하루에 3끼를 먹는다고 가정
SELECT SYSDATE AS "무관입대" ,ADD_MONTHS(SYSDATE,18)AS 전역일,
        (ADD_MONTHS(SYSDATE,18)-SYSDATE) AS 군생활일수,
        (ADD_MONTHS(SYSDATE,18)-SYSDATE)*3 AS 짬빱
FROM DUAL;


--NEXT_DAY : 지정한날짜의 지정한 요일의 날짜를 구해줌
-- 일요일 : 1, 월 : 2, 화 : 3,  수 : 4, 목 : 5, 금 : 6, 토 : 7
SELECT NEXT_DAY(SYSDATE,'월') FROM DUAL;
SELECT NEXT_DAY(SYSDATE,'월요일') FROM DUAL;
SELECT NEXT_DAY(SYSDATE,2) FROM DUAL;

--로케일에 따라서 대입하는것을 달리 해야함
SELECT * FROM V$NLS_PARAMETERS;

ALTER SESSION SET NLS_LANGUAGE=KOREAN;

--LAST_DAY : 정해진 날짜가 속한 달의 마지막 날을 표시
SELECT LAST_DAY('00/02/24') FROM DUAL;
--3달 후 마지막날을 구해봅시다~
SELECT LAST_DAY(ADD_MONTHS(SYSDATE,3)) FROM DUAL;

--날짜의 년,월,일을 따로 구분하여 관리해보자
--EXTRACT
SELECT EXTRACT(YEAR FROM SYSDATE)AS 년,
        EXTRACT(MONTH FROM SYSDATE) AS 월,
        EXTRACT(DAY FROM SYSDATE) AS 일,
        EXTRACT(HOUR FROM CAST(SYSDATE AS TIMESTAMP)) AS 시간,
        EXTRACT(MINUTE FROM CAST(SYSDATE AS TIMESTAMP)) AS 분,
        EXTRACT(SECOND FROM CAST(SYSDATE AS TIMESTAMP)) AS 시간
FROM DUAL;
--자료형 변환
--to_char : 문자열로 변경을 해주는 함수
--변경시 문자기호
--yyyy : 년도(4자리) / yy : 년도 2자리
--month : 월을 locale설정에 맞게 출력
--mm : 월을 숫자로 표현
--mon : 월을 알파벳으로 표현
--dd : 날짜를 표현
--d : 요일 -> 숫자 : 2
--dy : 요일을 약어로표현 : 월
--day : 요일 예 : 월요일
--HH : 시간 HH24(24시간) HH12(12시간)
--mi : 분
--ss : 초

select sysdate from dual;
select to_char(sysdate,'yyyy-mm-dd day hh24:mi:ss') 
from dual;
--어제날짜를 문자열로 출력
select to_char(sysdate-1,'yyyy-mm-dd day hh24:mi:ss')
from dual;
select to_char(sysdate+1,'yyyy-mm-dd dy')
from dual;
--컬럼을 이용한 문자열로 변경
select emp_name, hire_date
,to_char(hire_date,'yyyy/mm/dd hh24:mi:ss')
from employee;
--사원테이블에서 고용일(0000-00-00(요일))
select emp_name, hire_date
,to_char(hire_date,'yyyy-mm-dd(dy)')
from employee;
--숫자를 문자열로 변경
--to_char
--문자열로 변경시 포멧형식
--,(comma) 콤마형식으로변환(3째자리에 ,붙이는것) : 900,000
--.(period) 소수점 형식으로 변환 : 90.9
--9 해당자리의 숫자의미 -> 값이 없을 경우 소수점이상은 공백, 소수점이하는 0으로표시
--0 해당자리의 숫자의미 -> 값이 없을 경우 0으로 무조건 표시, 숫자를 고정적으로 표시할 경우
--$ 통화표시(돈) -> $달러표시
--L local통화로 표시 -> \
select to_char(123456,'999,999,999') from dual;
select to_char(123456,'000,000,000') from dual;
select to_char(123567,'99,999') from dual;
--통화표시
select to_char(3456,'$9,999') from dual;
select to_char(3456,'L9,999') from dual;
--소수점
select to_char(1234.56,'99999.9999') from dual;
select to_char(1234.56,'00000.0000') from dual;
--employee테이블의 salary컬럼을 원화표시로 ,로 구분하여 출력해보자
--연봉을계산하여 동일한 방식으로 출력해보자~! 
select emp_name, to_char(salary,'L999,999,999'),
    to_char(salary*12,'L999,999,999,999')
from employee;
-- to_date : 날짜형식으로 변환
--작성법 :  to_date(charater,format) : 문자를 날짜로 변경~
--         to_date(number,format) : 숫자를 날짜로 변경!
select to_char(to_date('19960626','yyyymmdd'),'yy.mm.dd dy') as "현빈 생일 경축"
from dual;
--시간까지 날짜로 변경하기
select to_char(to_date('19960626 02:30:20','yyyymmdd hh24:mi:ss')
                ,'yy/mm/dd hh24:mi:ss')
from dual;
select hire_date from employee;
select hire_date from employee
where hire_date >to_date('20000101','yyyymmdd');

--숫자-날짜로 변환 주의할것~! 앞에 0이 들어가는 년도가 나오면 안됨~! 
select to_date(19960626,'yyyymmdd') from dual;
select to_date('010224','yymmdd') from dual;

--조건에 따라 출력하기 decode
--사용법 : decode(표현식, 조건1,조건1(true:표현식의 결과와 같을때)결과,
--             조건2,조건2결과.... default)
select emp_no from employee;
select emp_name, emp_no, 
decode(substr(emp_no,8,1),'1','남','2','여','3','남','4','여') as 성별
from employee;
select * from department;
--deparmentcode : 
--D1 : 인사관리, D2:회계관리, D3 : 마케팅, D4 : 국내영업, D5 : 해외영업1
--D6 : 해외영업2, D8 : 기술지원, D9 : 총무
-- 사원명, DEPTCODE, 과명(조건별로 출력)
SELECT EMP_NAME, DEPT_CODE,NVL( 
DECODE(DEPT_CODE,'D1','인사관리','D2','회계관리','D3','회계관리',
        'D3','마케팅','D4','국내영업','D5','해외영업1','D6','해외영업2',
        'D8','기술지원','D9','총무'),'부서없음') AS 과명
FROM EMPLOYEE;
--CASE문:조건에 따라 컬럼값을 출력
--사용 : CASE WHEN 조건 THEN 조건결과값 WHEN 조건2 THEN 조건2 ....
--       ELSE 결과 END AS 별칭부여
SELECT EMP_NAME, EMP_NO
    ,CASE 
        WHEN SUBSTR(EMP_NO,8,1)=1 THEN '남'
        WHEN SUBSTR(EMP_NO,8,1)=2 THEN '여'
        --ELSE '여'
     END
    AS 성별
FROM EMPLOYEE;

--CASE문으로 아까 문제 DEPT_CODE변경문제 다시 해보자~~! 
-- 사원테이블에서 다음과 같이 출력하세요.
-- 현재나이= 현재년도 - 태어난년도 +1
/*
-------------------------------------------------------------------------
사원번호    사원명       주민번호        성별   현재나이
-------------------------------------------------------------------------
200	       선동일	  621235-1*******	   남	    57
201	       송종기	  631156-1*******	   남	    56
202	       노옹철	  861015-1*******	   남	    33
                        .
                        .
                        .
-------------------------------------------------------------------------
*/
select emp_id as 사원번호,
        emp_name as 사원명,
        concat(substr(emp_no,1,8),'******'),
        case
            when substr(emp_no,8,1)=1 then '남'
            else '여'
        end as 성별,
        (extract(year from sysdate)-
        --extract(year from to_date(substr(emp_no,1,2),'yy')) as 현재나이
        extract(year from to_date(substr(emp_no,1,2),'rr')))+1 as 현재나이,
        to_number(extract(year from sysdate))-
        (to_number(substr(emp_no,1,2))+ 
            case 
                when substr(emp_no,8,1) in (1,2) then 1900 
                else 2000
            end)+1
            as 현재나이
from employee;

insert into employee values(
    '250','고두밋','470808-2123341','go@kh.or.kr',null,'D2','J2','S5'
    ,4480000,null,null,to_date('94/01/20','rr/mm/dd'),null,'N'
);

--그룹함수 함수실행결과가 한개의 row로 출력되는 함수
--sum(컬럼명) : 컬럼에 대한 합계~
--사원 월급에 대한 총합계
select sum(salary) from employee;
select sum(salary) 
from employee
where emp_name like '유%';
--resultset 한개 row로 되어있기 때문에 컬럼을 선택할 수 없다.
select emp_name, sum(salary) 
from employee;
--연봉의 합계
select sum(salary*12), sum((salary+salary*nvl(bonus,0))*12)
from employee;
select sum(bonus) from employee;
select bonus from employee where bonus is not null;
--avg : 컬럼의 평균을 구하는 함수
select bonus from employee;
select avg(bonus) from employee;
select round(avg(bonus),2), avg(nvl(bonus,0)) 
from employee 
where bonus is not null;

--테이블에 대한 전체 row수 조회 : count
--count(컬럼 OR *)
select count(*) from employee;
select * from employee;
select count(*) 
from employee
where dept_code='D9';

select count(*) 
from employee 
where salary>3000000;

select count(emp_name)
from employee;
select count(dept_code)
from employee;

select count(*)
from employee
where dept_code is not null;

select count(distinct dept_code)
from employee;
select DISTINCT dept_code 
from employee;

--max, min구하기~!
select max(salary),min(salary) from employee;
select max(hire_date),min(hire_date) from employee;

--부서별 월급의 평균구하자, 화폐형식으로 변환
select dept_code,floor(avg(salary))
from employee
group by dept_code;--중복값이 존재해야지 결과 의미가 있음.

select emp_name, floor(avg(salary))
from employee
group by emp_name;

--group by를 선언하면 그 그룹으로 계산되는 그룹함수를 사용가능
select dept_code, count(dept_code), sum(salary), floor(avg(salary)),
        max(salary), min(salary)
from employee
group by dept_code;

--성별컬럼을 기준으로 남자여자에 대한 평균월급, 합계, 인원수
select case 
         when substr(emp_no,8,1)=1 then '남'
         else '여'
        end as gender,
        count(*) as 인원수,
        to_char(sum(salary),'L999,999,999') as 월급합계,
        to_char(floor(avg(salary)),'L999,999,999') as 월급평균
from employee
group by case 
         when substr(emp_no,8,1)=1 then '남'
         else '여'
        end;

--job_code를 기준으로 salary 합계, 평균 구하기
select job_code, sum(salary), floor(avg(salary))
from employee
where dept_code is not null
group by job_code
having sum(salary)>9000000;
--부서 인원수가 4이상인 부서만 출력하세요
select dept_code,count(*) 
from employee
group by dept_code
having count(*)>=4;

--그룹집계함수 rollup / CUBE
--그룹에 대한 총합계를 구해주는 함수
SELECT DEPT_CODE,
        SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
--ROOLUP을 통해 합계를 구하기
SELECT DEPT_CODE,
        SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE);
--컬럼이 두개일 경우
SELECT DEPT_CODE, JOB_CODE,
    SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE,JOB_CODE
ORDER BY 1;
--두개컬럼에 대한 소계,총계를 출력
SELECT DEPT_CODE, JOB_CODE,
    SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY 1;


SELECT JOB_CODE, DEPT_CODE, 
    SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE,DEPT_CODE)
ORDER BY 1;
--부서별 인원수 정보를 출력하는데 총 인원까지 출력하세요
SELECT DEPT_CODE, COUNT(*) 
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE)
ORDER BY 1;
--부서별, 직급별 인원수를 출력하고 부서별 소계 전체 총계를 출력하세요
SELECT DEPT_CODE, JOB_CODE,
    COUNT(*)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE,JOB_CODE)
ORDER BY 1;

--CUBE : 한개 그룹만 설정하여 처리할때는 ROLLUP과 동일
-- 두개이상 그룹이 설정될 경우 출력값이 달라짐~!
SELECT DEPT_CODE, JOB_CODE,
    SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1;

SELECT DEPT_CODE,
    SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
SELECT JOB_CODE,
    SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT DEPT_CODE,JOB_CODE,
    SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY 1;

SELECT SUM(SALARY)
FROM EMPLOYEE;
--부서별, 직책별 인원총계
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1,2;

SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

DELETE FROM EMPLOYEE WHERE DEPT_CODE IS NULL;

ROLLBACK;

--GROUPING : 집계결과인지를 판단하는 함수
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY), COUNT(*),
    CASE 
        WHEN GROUPING(DEPT_CODE)=0 AND GROUPING(JOB_CODE)=1
            THEN '부서별합계'
        WHEN GROUPING(DEPT_CODE)=1 AND GROUPING(JOB_CODE)=0
            THEN '직급별합계'
        WHEN GROUPING(DEPT_CODE)=1 AND GROUPING(JOB_CODE)=1
            THEN '총합계'
        ELSE '그룹별 합계'
    END AS 구분
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1;





--집합연산자(SET OPERATION)
--2개 이상의 RESULT SET을 한개의 RESULT SET으로 합치는 것!
--SELECT문 집합연산자 SELECT문 집합연산자 SELECT문.....
--조건 : 각 RESULT SET의 컬럼의 갯수가 같아야함, 
--      컬럼에 순서에따른 타입도 같아야함

--UNION : 중복값없이 두개의 RESULT SET의 데이터를 합치는 것
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>3000000
ORDER BY DEPT_CODE;
--컬럼에 데이터는 꼭 컬럼명에서 요구하는 
--자료가 들어가지 않아도됨
SELECT EMP_NAME, LENGTHB(EMP_NO)
FROM EMPLOYEE
WHERE SALARY>3000000
UNION
SELECT DEPT_ID, LENGTHB(DEPT_TITLE)
FROM DEPARTMENT;
--UNION ALL : 두개의 RESULT SET에 있는 중복값을 모두 출력
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>3000000
union
select emp_id, emp_name, dept_code, salary
from employee
where job_code in ('J3','J4');


--intersect : 두 result set의 중복값만 출력
select emp_id, emp_name, dept_code, salary
from employee
where dept_code='D5'
intersect
select emp_id, emp_name, dept_code, salary
from employee
where salary>3000000;

--minus : 두개이상의 resultset에서 위 select문에서 중복되는값을 빼는것
select  dept_code
from employee
where dept_code='D8'
minus
select dept_id
from department;

select * from employee;
--group by grouping sets
--group by로 설정되어있는 result set들을 결합해주는 기능
select dept_code, job_code, manager_id, floor(avg(salary))
from employee
group by GROUPING SETS(
    (DEPT_CODE,JOB_CODE, MANAGER_ID),
    (DEPT_CODE,MANAGER_ID),
    (JOB_CODE,MANAGER_ID)
    )
ORDER BY 1 NULLS LAST,2 NULLS LAST,3 NULLS LAST;
    
select dept_code, job_code, manager_id, floor(avg(salary))
from employee
GROUP BY (DEPT_CODE,JOB_CODE, MANAGER_ID);
select dept_code, manager_id, floor(avg(salary))
from employee
GROUP BY (DEPT_CODE,MANAGER_ID);
select job_code, manager_id, floor(avg(salary))
from employee
GROUP BY (JOB_CODE, MANAGER_ID);

--join사용하기
--join은 두개의 테이블을 결합하여 한개의 테이블로 출력하는 것
--두개의 테이블을 row단위로 결합을 해야하기 때문에 서로 매핑되는 값이 
--필요함(두 테이블이 각가 가지고 있는 동일한값)
select emp_name, employee.job_code,job_name
from employee, job
where employee.job_code=job.job_code;

select * from employee;
select * from job;

--사원명, 부서명을 출력하기
select *from employee;
select * from department;
select emp_name, dept_title
from employee e, department d
where e.dept_code=d.dept_id and;
--ansi표준 sql으로 변환해보면
--select 컬럼명, 컬럼명2,...
--from 테이블 join 테이블 on 비교컬럼=비교컬럼
--[where 조건....]
--사원명, 직책명을출력해보자
select emp_name, job_name
from employee e join job j on e.job_code=j.job_code;
--department를 ansi로 변경해보세요
select emp_name, dept_title
from employee join department on dept_code=dept_id;
--위 테이블에서 총무부원만 출력해보자
select emp_name, dept_title
from employee inner join department on dept_code=dept_id
where dept_title='총무부';

--inner 조인 : 기준이 되는 값이랑 일치하는 값이 없으면 그 row를 출력하지않음
select * from employee;
select count(*) 
from employee e join department d on e.dept_code=d.dept_id;
--outerjoin : 기준값이랑 일치하는 것이 없더라도 한쪽(LEFT,RIGHT)기준으로 
--한쪽은모두 출력하게 하는것
-- select 컬럼명, 컬럼명,컬럼명....
-- from 테이블 left/right join 테이블 on 비교값=비교값
--left join
select emp_name, e.dept_code, dept_title
from employee e left join department d on e.dept_code=d.dept_id;

select emp_name, e.dept_code, dept_title
from department d left join employee e on e.dept_code=d.dept_id;

select emp_name, e.dept_code, dept_title
from department d right join employee e on e.dept_code=d.dept_id;

--오라클 outter조인 사용법
select emp_name, dept_code, dept_title, dept_id
from employee, department
where dept_code(+)=dept_id;

--fulljoin : 일치되는 값이 없어도 양쪽 테이블의 데이터 모두 출력
select emp_name, dept_code, dept_title, dept_id
from employee full join department on dept_code=dept_id;

select emp_name, dept_code, dept_title, dept_id
from employee, department;

select emp_name, dept_code, dept_title, dept_id
from employee cross join department
order by 1,3;

select emp_name,dept_code from employee;
select dept_title,dept_id from department;


--non-equ join : 동등비교가 아니라 값 크기 비교로 조인
select * from sal_grade;

select emp_name, salary, s.sal_Level,s.min_sal,s.max_sal
from employee join sal_grade s 
on (salary between min_sal and max_sal);

-- self join : 본인테이블을 본인참조하여 연결하는 것
-- 자기테이블의 컬럼값(구분되는)을 갖고있는 컬럼이 존재해야함.
-- employee : emp_id = manager_id
select emp_id, manager_id from employee;

select e.emp_id, e.emp_name, e.manager_id, m.emp_name, m.salary
from employee e
left join employee m on e.manager_id=m.emp_id;


--사원테이블
select emp_id, emp_name, manager_id from employee;
--매니저테이블
select emp_id, emp_name from employee;
--다중조인 테이블을 두개이상 결합하는것을 의미한다.
--from 절에 join구문을 계속 사용하면됨
--join을 할때 연결되는 컬럼이 반드시 이전에 결합된 테이블에 존재
select *
from employee e
join job j on(j.job_code=e.job_code)
left join department on dept_code=dept_id
join location l on location_id=local_code
;
select * from location;

--직급이 대리이면서, ASIA지역에 근무하는 직원을 조회
--사번, 이름, 직급명, 부서명, 근무지역명, 급여
--주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원
--사원명, 주민번호, 부서명, 직급명
--이름에 '형'자가 들어가는 직원
--사번, 사원명, 부서명
--해외영업부에 근무하는 직원
--사원명, 직급명, 부서코드, 부서명
--보너스를 받는 직원
--사원명, 보너스, 부서명, 근무지역명
--부서코드가 D2인 직원
--사원명, 직급명, 부서명, 근무지역명
--급여등급테이블의 최대급여(MAX_SAL)보다 많이 받는 직원들
--사원명, 직급명, 급여, 연봉
--한국(KO)와 일본(JP)에 근무하는 직원
--사원명,부서명, 지역명, 국가명
--같은부서에 근무하는 직원(self join)
--사원명, 부서명, 동료이름
--보너스가 없는 직원 중 직급이 차장과 사원인 직원
--사원명, 직급명, 급여조회 join, in 사용
--재직중인 직원과 퇴사한 직원의 수


SELECT E.EMP_NAME 사원명
      , DEPT_TITLE 부서명
      , E2.EMP_NAME 동료사원명
FROM EMPLOYEE E
 JOIN EMPLOYEE E2 ON(E.DEPT_CODE = E2.DEPT_CODE)
 LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = DEPT_ID
WHERE E.EMP_NAME != E2.EMP_NAME
ORDER BY 1;








--해외영업1부 사원을 출력하시오
select * 
from employee
where dept_code=(select dept_id from department 
            where dept_title='해외영업1부');
select * from department;

--단일행 서브쿼리 : 서브쿼리의 결과가 1개일때(1row)

select * 
from employee
where salary>(select avg(salary) from employee);

select *
from employee
where dept_code=(select dept_id
                    from department where dept_title='총무부')
    AND salary>(select avg(salary) from employee);
    
--다중행서브쿼리 : resultset의 행 여러행으로 되는 경우

select emp_name, dept_code
from employee
where dept_code='D9' or dept_code='D5';
select dept_code from employee 
where emp_name='송종기' OR emp_name='박나라';

select emp_name, dept_code 
from employee
where dept_code not in (select dept_code from employee 
                    where emp_name in('송종기','박나라'));
--다중열 서브쿼리 select문에서 컬럼을 다수 선택하는 경우
--비교대상도 1:1 매칭이 되어야한다.
--퇴사한 여직원과 같은 직급, 같은 부서인 사원 
select *
from employee
where (job_code, dept_code) 
            in (select job_code, dept_code 
                from employee 
                where substr(emp_no,8,1)=2 and ent_yn='Y');
                
--다중행다중열서브쿼리 : 서브쿼리의 resultset 결과가 row 2개이상 
--column도 2개이상인 결과를 가지는 select을 사용했을때 
--직급별 최소급여를 받는 직원의 사번, 이름, 직급, 급여 조회
select job_code, min(salary) 
from employee
group by job_code;

select emp_id, emp_name, job_code, salary
from employee
where (job_code,salary)in(select job_code, min(salary) 
                            from employee
                            group by job_code);
                            
--다중행서브쿼리로 대소비교할때 ANY, ALL
--ANY : 서브쿼리에 결과중 하나라도 참이면 참이다
--x > ANY(서브쿼리) : 어떤값보다 크기만하면 참 -> 최소값보다 크면 참
SELECT EMP_NAME, SALARY
FROM EMPLOYEE 
WHERE SALARY >= ANY(SELECT MIN(SALARY) 
                    FROM EMPLOYEE GROUP BY JOB_CODE);

--최대값보다 작으면 참     
SELECT EMP_NAME, SALARY
FROM EMPLOYEE 
WHERE SALARY < ANY(SELECT MIN(SALARY) 
                    FROM EMPLOYEE GROUP BY JOB_CODE);                            
-- ALL : 서브쿼리의 결과값 모두 참이면 참
--X > ALL : 서브쿼리의 모든값 보다 크면 참 -> 최대값보다 크면 참
--X < ALL : 서브쿼리의 모든값 보다 작으면 참 -> 최소값보다 작으면 참
SELECT EMP_NAME, SALARY
FROM EMPLOYEE 
WHERE SALARY < ALL(SELECT MIN(SALARY) 
                    FROM EMPLOYEE GROUP BY JOB_CODE
                    HAVING MIN(SALARY)>2000000);                  

SELECT EMP_NAME, SALARY
FROM EMPLOYEE 
WHERE SALARY > ALL(SELECT MIN(SALARY) 
                    FROM EMPLOYEE GROUP BY JOB_CODE
                    HAVING MIN(SALARY)<6000000);       
                    
--상관서브쿼리 : MAIN SELECT문과 SUBSELECT문이 서로 결과에 영향을 주는것
SELECT EMP_ID, EMP_NAME, MANAGER_ID
FROM EMPLOYEE E
WHERE EXISTS(SELECT * FROM EMPLOYEE M WHERE E.MANAGER_ID=M.EMP_ID);
 
--심봉선 사원과 같은 부서의 사원의 부서이름, 월평균급여를 조회
--가장많은 급여를 받는 사원을 EXISTS 상관서브쿼리를 이용하여 구하여라
-- NOT EXISTS이용
--윤은해와 급여가 같은 사원들을 검색해서 사번, 사원이름, 급여출력
--EMPLOYEE테이블에서 기본급여가 제일 많은 사람과 제일적은 사람의 정보를 
-- 사번,사원명,월급출력
--D1,D2부서에 근무하는 사원들 중에서 기본급여가 D5부서 직원들의 평균월급보다 
-- 많은 사람들만 부서번호, 사번,사원명, 월급출력
--차태현 전지연 사원의 급여등급과 같은 사원의 직급명, 사원명 출력
--직급이 대표, 부사장이 아닌 모든 사원을 부서별로 출력
--ASIA1지역에 근무하는 사원정보출력 부서코드, 사원명(서브쿼리이용)
--2000년1월1일 이전 입자사중에 2000년1월1일이후 입사자보다 급여을 (가장높게
-- 받는사원보다) 적게 받는 사원의 사원명과 월급여를 출력
--'J4'직급의 사원보다 많은 급여를 받는 직급이 J5,J6,J7인 사원 출력
--D1부서의 사원(전체)보다 입사가 늧은 사원들의 정보를 검색하고, 사원명, 부서번호
-- 입사일을 출력
--인사관리부의 사원전체보다 입사가 늦은 사원들의정보를 검색, 사원명, 부서명, 입사일
--기술지원부이면서 급여가 2000000인 사원의 사원명, 부서코드, 급여출력
--부서별 최대급여를 받는 사원의 사원명, 부서명, 급여를 출력
--직급이 J1, J2, J3이 아닌 사원중에서 자신의 부서별 평균급여보다 많은 급여를 받는 사원출력.
-- 부서코드, 사원명, 급여, 부서별 급여평균

select  dept_code, round(avg(salary)) avg_sal
from employee
group by dept_code;

select e.dept_code, emp_name, salary
from employee e
join(select  dept_code, round(avg(salary)) as avg_sal
        from employee
        group by dept_code)a on e.dept_code = a.dept_code   
where job_code not in ('J1','J2','J3') 
    AND salary > avg_sal;
    

--스칼라서브쿼리 : 상관쿼리인데 resultSet 무조건 한개만~있는것~!   
select dept_code,emp_name, salary ,
        (select round(avg(salary)) 
         from employee where dept_code=e.dept_code)as avg_sal
from employee e
where job_code not in('J1','J2','J3')
    AND salary > (select round(avg(salary)) 
         from employee where dept_code=e.dept_code);

select avg(salary) from employee;


select dept_title, emp_name
from employee e left join department on dept_code = dept_id
where exists (select 1 
             from employee 
             where dept_code = e.dept_code and emp_name = '심봉선');

select dept_title, trunc(avg(salary)) 평균급여
from employee e left join department on dept_code = dept_id
where exists (select 1 
             from employee 
             where dept_code = e.dept_code and emp_name = '심봉선')
group by dept_title;


--스칼라서브쿼리 : 상관서브쿼리에서 그 결과(resultset) 단일행일 경우를 말함
--스칼라 : sql에서 단일값을 갖는 데이터를 스칼라라고 함
--사용 : 1. select문의 컬럼 위치에서 사용가능
--      2. where절에서도 사용이 가능
--      3. order by 절에서도 사용이 가능

--select문에 스칼라서브쿼리 사용하기
-- 모든사원의 사번, 이름 관리자사번, 관리자명을 조회
-- self join
select e.emp_id,e.emp_name, e.manager_id, m.emp_name
from employee e join employee m 
on e.manager_id=m.emp_id;
--스칼라
select emp_id, emp_name, manager_id, 
    nvl((select emp_name from employee m where e.manager_id=m.emp_id),'없음') as 관리자명
from employee e;
select emp_name from employee where dept_code='D1';

--사원명, 부서코드,부서명,부서별 평균임금을 서브쿼리를 이용해서 출력해보자
select emp_name, dept_code, dept_title, 
    (select round(avg(salary)) from employee 
        where dept_code=e.dept_code) as avg_sal
from employee e join department on dept_code=dept_id;

select round(avg(salary)) from employee 
where dept_code='D1'
group by dept_code ;
select dept_code from employee
;
--직급이 J1이 아닌 사원중 자신의 부서별 평균 급여보다 적은 급여를 받는 사원
-- 부서코드, 사원명, 급여, 부서별 급여평균
select dept_code, emp_name, salary, 
        (select round(avg(salary)) 
        from employee where dept_code=e.dept_code)
from employee e
where job_code<>'J1' and salary <(select round(avg(salary)) 
        from employee where dept_code=e.dept_code);

--스칼라 where절에 사용하기~~!
--자신이 속한 직급의 평균급여보다 많이 받는 직원의
--이름, 직급, 급여, 평균급여, 직책명을 조회

select emp_name, job_code, salary
from employee a
where salary>(select round(avg(salary))
                from employee 
                where job_code=a.job_code);
                
select job_code, round(avg(salary))
from employee
group by job_code;
-- 스칼라서브쿼리 order by절
--모든 직원의 사번, 이름, 소속부서를 조회 후 부서명으로 오름차순정렬하세요
select emp_id, emp_name, dept_code
from employee
order by (select dept_title
            from department
            where dept_code=dept_id) desc nulls last;
            
-- FROM절에 서브쿼리 사용하기
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
        DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여') 성별
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)=1;

SELECT * 
FROM (SELECT EMP_ID AS 사번, EMP_NAME AS 사원명, DEPT_CODE AS 부서코드,
        DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여') 성별
        FROM EMPLOYEE
        WHERE 사번 LIKE '20%');

--EMPLOYEE 테이블에서 1990년도에 입사한 사원의 사번, 사원명, 입사년도를 
--인라인류로 작성
select *
from(select emp_id 사번
         , emp_name 사원명
         , extract(year from hire_date) 입사년도
    from employee)
where 입사년도 - 1990 between 0 and 9; 
--2. employee테이블에서 사원중 30대, 40대인 
--여자사원의 사번, 부서명, 성별, 나이를 출력하라.
select 사번, 사원명, 부서명, 성별, 나이
from (
        select emp_id 사번
             , emp_name 사원명
             , (select dept_title from department where dept_id
                = e.dept_code) 부서명
             , extract(year from sysdate)
             -(decode(substr(emp_no,8,1),'1',1900,'2',1900,2000)
             +to_number(substr(emp_no,1,2)))+1 나이
             , decode(substr(emp_no,8,1),'1','남','3','남','여') 성별
        from employee e
      )
where 성별 = '여' and (trunc(나이/10) in(3,4));

--WITH : 서브쿼리에 별칭을 부여해서 그 별칭으로 서브쿼리를 사용하는것
WITH TT AS(SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE 
            ORDER BY SALARY DESC)
SELECT * FROM TT;

--순위를 조회하는 조회문을 알아보자
--월급많은 TOP3를 조회
--오라클이 테이블이면 제공하는 컬럼
--ROWNUM : 컬럼에 대해 자동으로 1~끝번까지 번호부여
--ROWID : ROW를 찾아갈수있게 해주는 주소값!
CREATE TABLE TEST(
    BOARDNO NUMBER,
    TITLE VARCHAR2(10),
    CONTENT VARCHAR2(200),
    WRITER VARCHAR2(10)
);
SELECT * FROM TEST;
SELECT ROWID, ROWNUM, BOARDNO, TITLE, CONTENT, WRITER
FROM TEST;

SELECT ROWID, ROWNUM, EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

SELECT ROWNUM,EMP_ID, EMP_NAME,SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

SELECT ROWNUM, A.*
FROM (SELECT EMP_ID, EMP_NAME, SALARY
        FROM EMPLOYEE ORDER BY SALARY DESC)A
WHERE ROWNUM <=3;

SELECT ROWNUM, EMPLOYEE.*
FROM EMPLOYEE;
--D5부서에서 연봉 상위 3명의 정보출력
--순위, 사번, 사원명, 연봉
SELECT ROWNUM, A.* 
FROM (SELECT EMP_ID, EMP_NAME, SALARY*12 AS 연봉
        FROM EMPLOYEE 
        WHERE DEPT_CODE='D5'
        ORDER BY 연봉 DESC) A
WHERE ROWNUM <=3;

--월급이 5~10등까지 사원명, 월급 출력해보자 *패이징처리시 필요!!
SELECT * FROM(
    SELECT ROWNUM RNUM, A.* 
    FROM (SELECT EMP_ID, EMP_NAME, SALARY*12 AS 연봉
            FROM EMPLOYEE 
            ORDER BY 연봉 DESC) A
)       
WHERE RNUM BETWEEN 5 AND 10;

--계층형쿼리
--조직도 구성, 메뉴, 답변형게시판(댓글)
-- FROM 다음에 옵션값을 등록해서 처리함
--START WITH : 부모행(루트노드) 지정
--CONNECT BY : 부모-자식관계설정
--PRIOR : START WITH절에서 제시한 부모행의기준컬럼을 지정
--LEVEL : 계층정보를 나타내는 가상의 컬럼

SELECT LEVEL, EMP_ID, EMP_NAME, MANAGER_ID
FROM EMPLOYEE
START WITH EMP_ID=200
CONNECT BY PRIOR EMP_ID=MANAGER_ID
ORDER BY LEVEL;
SELECT LPAD(' ',(LEVEL-1)*5,' ')||EMP_NAME
            ||NVL2(MANAGER_ID,'('||MANAGER_ID||')','')AS 조직도
FROM EMPLOYEE
START WITH MANAGER_ID IS NULL
CONNECT BY PRIOR EMP_ID=MANAGER_ID;

--RANK()윈도우함수 : 오라클이 제공하는 순위조회함수
SELECT 순위, EMP_NAME, SALARY
FROM(SELECT EMP_NAME, SALARY, 
            RANK() OVER(ORDER BY SALARY DESC) AS 순위
            FROM EMPLOYEE ORDER BY SALARY DESC)
            WHERE 순위 BETWEEN 4 AND 10;


SELECT 순위, EMP_NAME, SALARY
FROM(SELECT EMP_NAME, SALARY, 
            DENSE_RANK() OVER(ORDER BY SALARY DESC) AS 순위
            FROM EMPLOYEE ORDER BY EMP_NAME);

--DDL:테이블에 데이터를 조작하는 언어
--INSERT : 테이블에 ROW(행)을 삽입하는 명령어
--UPDATE : 테이블의 특정 ROW(행) 특정 컬럼의 값을 수정하는 명령어
--DELETE : 테이블의 특정 ROW(행)를 삭제 하는 명령어

--INSERT 사용법 
--INSERT INTO 테이블명[(컬럼명, 컬럼명, 컬럼명,....)]
--VALUES(값1, 값2, 값3, 값4,....);
--테이블뒤에 괄호컬럼은 특정 컬럼들만 값을 대입하여 ROW를 추가할때
--일반적으로 전체 컬럼에 대해서 값을 대입을 할때는 INTO 테이블 VALUES()
--로 값을 대입
--VALUES대입값의 순서는 테이블이 정해놓은 순서대로 작성하면됨
-- *테이블을 만들때 작성한 컬럼순서

--전체값에 대해 대입하는 경우
INSERT INTO EMPLOYEE
VALUES(900,'장채현','901123-1080503','JANG_CH@KH.OR.KR','0105556952',
'D1','J8','S3',4300000,0.2,'200',SYSDATE,DEFAULT,DEFAULT);
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE
VALUES(901, '함지민','731020-2123453','hamham@kh.or.kr','01012341234',
'D1','J4','S3',4500000,NULL,'218',SYSDATE,DEFAULT,DEFAULT);
SELECT * FROM EMPLOYEE;
commit;
--내가 원하는 컬럼만 골라서 행추가
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, 
DEPT_CODE,JOB_CODE, SAL_LEVEL, BONUS, MANAGER_ID)
VALUES(903, '유병승', '000224-3123412','prince0324@naver.com',
'01036446259','D2','J1','S1',0.3,'200');
SELECT * FROM EMPLOYEE;
--데이터를 입력할때는 제약조건을 지켜야됨.
INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME, EMP_NO,SAL_LEVEL, JOB_CODE)
VALUES(904,'서현희','910804-2123412','S1','J3');
SELECT * FROM EMPLOYEE WHERE EMP_ID='904';

--INSERT문에 SUBQUERY이용하기
CREATE TABLE EMP01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    EMP_TITLE VARCHAR2(20)
);
INSERT INTO EMP01
VALUES(999,'유병승','대표이사');
SELECT * FROM EMP01;

INSERT INTO EMP01(
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE)
);
--서브쿼리를 이용해서 값을 넣을때는 VALUES예약어가 생략!
CREATE TABLE EMP_HIRE_DATE(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    HIRE_DATE DATE
);
CREATE TABLE EMP_MANAGER(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    MANAGER_ID NUMBER
);
SELECT * FROM EMP_HIRE_DATE;
SELECT * FROM EMP_MANAGER;
INSERT INTO EMP_HIRE_DATE(
    SELECT EMP_ID, EMP_NAME, HIRE_DATE
    FROM EMPLOYEE
);
INSERT INTO EMP_MANAGER(
    SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
);
ROLLBACK;--되돌리기
SELECT * FROM EMPLOYEE;
--INSERT ALL을 활용해서 두개의 테이블에 한번에 데이터를 삽입~
INSERT ALL 
INTO EMP_HIRE_DATE VALUES(EMP_ID,EMP_NAME,HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE;

SELECT * FROM EMP_HIRE_DATE;
SELECT * FROM EMP_MANAGER;
--INSERT ALL여러 테이블에 한번에 값을 삽입하는것
--값을 넣을때 조건에 따라서 값을 넣을수 있음
--CASE절 과 비슷한 WHEN사용해서 처리함
CREATE TABLE EMP_OLD(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    HIRE_DATE DATE,
    SALARY NUMBER
);
CREATE TABLE EMP_NEW(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    HIRE_DATE DATE,
    SALARY NUMBER
);
SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;
--OLD EMPLOYEE에서 00.01.01 이전에 입사한 사원
--NEW EMPLOYEE에서 00.01.01 이후에 입사한 사원
INSERT INTO EMP_OLD(
     SELECT EMP_ID,EMP_NAME, HIRE_DATE, SALARY
     FROM EMPLOYEE WHERE HIRE_DATE<'00/01/01'
);
SELECT * FROM EMP_OLD;
DELETE FROM EMP_OLD;
INSERT ALL
WHEN HIRE_DATE<'00/01/01' THEN
INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE>='00/01/01' THEN
INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY 
FROM EMPLOYEE;
SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

--UPDATE : 테이블의 내용을 수정하는것
--사용
--UPDATE 테이블명
--SET 변경될컬럼=변경될값
--WHERE 조건
CREATE TABLE COPY_DEPT
AS SELECT * FROM DEPARTMENT;
SELECT * FROM COPY_DEPT;
UPDATE COPY_DEPT
SET DEPT_TITLE='전략기획부', LOCATION_ID='L1'
WHERE DEPT_ID='D2';

ROLLBACK;
--UPDATE문도 서브쿼리를 이용할 수 있음
CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, SALARY, BONUS 
    FROM EMPLOYEE;
    
SELECT * FROM EMP_SALARY;
UPDATE EMP_SALARY
SET BONUS=(SELECT BONUS 
            FROM EMP_SALARY 
            WHERE EMP_NAME='하이유')
WHERE EMP_ID=(SELECT EMP_ID 
                FROM EMP_SALARY 
                WHERE EMP_NAME='송종기');
            
select * from department;


CREATE TABLE EMP_SALARY1
AS SELECT EMP_ID, EMP_NAME,dept_code, SALARY, BONUS 
    FROM EMPLOYEE;
--부서가 회계관리부인 사원들의 보너스를 0.4로 수정하세요.
update emp_salary1
set bonus=0.4
where dept_code=(select  dept_id from department
                    where dept_title='회계관리부');
                    
select * from emp_salary1 where dept_code='D2';

--부서가 총무부사원의 월급이 100000원씩 증가함
--반영해보세요~! 
select * from emp_salary1 where dept_code='D9';
update emp_salary1
set salary=salary+100000
where dept_code=(select dept_id from department where dept_title='총무부');

select * from emp_salary1 where emp_name in ('유재식','방명수');

update emp_salary1
set (salary, bonus) = (select salary, bonus from employee
                        where emp_name='유재식')
where emp_name='방명수';                    

select * from employee
left join department on dept_code=dept_id
join location on location_id=local_code;

-- 근무지역이 유럽인 녀석들의 보너스를 0.5
create table emp_local
as select * from employee;

update emp_local
set bonus=0.5
where dept_code=(select dept_id from department
                    join location on location_id=local_code
                    where local_name='EU'
                    );
select * from emp_local where dept_code='D8';                    

--merge : 병합 두개의 테이블을 합치는 작업
--merge 사용
--MERGE INTO 테이블명 USING 합쳐질테이블명 ON 결합할 기준값
--WHEN MATCHED THEN
--UPDATE SET
--업데이트 구문
--WHEN NOT MATCHED THEN
--인서트 구문
CREATE TABLE MERGE_TEST
AS SELECT * FROM EMPLOYEE;
CREATE TABLE MERGE_TEST2
AS SELECT * FROM EMPLOYEE
    WHERE DEPT_CODE='D8';
SELECT * FROM MERGE_TEST;    
SELECT * FROM MERGE_TEST2;    

INSERT INTO MERGE_TEST2
VALUES(998,'윤원택','921101-1234567','nice435555@gmail.com',
    '01094982991','D2','J2','S2',100,0.1,NULL,SYSDATE,DEFAULT,DEFAULT);

UPDATE MERGE_TEST2
SET SALARY =10,BONUS=0
WHERE DEPT_CODE='D8';
COMMIT;

SELECT * FROM MERGE_TEST2;

MERGE INTO MERGE_TEST USING MERGE_TEST2 
    ON(MERGE_TEST.EMP_ID=MERGE_TEST2.EMP_ID)
WHEN MATCHED THEN
UPDATE SET
MERGE_TEST.SALARY=MERGE_TEST2.SALARY,
MERGE_TEST.BONUS=MERGE_TEST2.BONUS
WHEN NOT MATCHED THEN
INSERT VALUES(MERGE_TEST2.EMP_ID,MERGE_TEST2.EMP_NAME,MERGE_TEST2.EMP_NO,
MERGE_TEST2.EMAIL, MERGE_TEST2.PHONE,MERGE_TEST2.DEPT_CODE,MERGE_TEST2.JOB_CODE,
MERGE_TEST2.SAL_LEVEL,MERGE_TEST2.SALARY,MERGE_TEST2.BONUS,MERGE_TEST2.MANAGER_ID,
MERGE_TEST2.HIRE_DATE,MERGE_TEST2.ENT_DATE,MERGE_TEST2.ENT_YN);

SELECT * FROM MERGE_TEST;


SELECT * FROM MERGE_TEST;
DELETE FROM MERGE_TEST
WHERE EMP_NAME='유병승';
DELETE FROM MERGE_TEST;
COMMIT;
SELECT * FROM DEPARTMENT;
DELETE FROM DEPARTMENT 
WHERE DEPT_ID='D1';
ROLLBACK;

ALTER TABLE EMPLOYEE ADD 
FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);
SELECT * FROM DEPARTMENT;

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME,EMP_NO,SAL_LEVEL, DEPT_CODE, JOB_CODE)
VALUES(997,'최장원','940207-1234561','S2','D1','J2');

DELETE FROM DEPARTMENT WHERE DEPT_ID='D1';
SELECT * FROM EMPLOYEE WHERE DEPT_CODE='D4';
DELETE FROM DEPARTMENT WHERE DEPT_ID='D4';

DELETE FROM MERGE_TEST2;
ROLLBACK;
SELECT * FROM MERGE_TEST2;
TRUNCATE TABLE MERGE_TEST2;
ROLLBACK;


--DDL : 오브젝트들을 만드는 언어
-- CREATE, ALTER, DROP 
--CREATE : 오브젝트를 생성
--ALTER : 오브젝트를 수정
--DROP : 오브젝트를 삭제
--오브젝트 : 테이블, VIEW, INDEX, 시퀀스, USER... 등
--CREATE : CREATE 오브젝트종류 오브젝트의명칭
--테이블 생성
CREATE TABLE MEMBER1(
    MEM_NAME VARCHAR2(20),
    MEM_PASSWARD VARCHAR2(30),
    MEM_ID VARCHAR2(20)
);

SELECT * FROM MEMBER1;
--테이블에 주석달기(설명)
COMMENT ON TABLE MEMBER1 IS '테스트용 회원관리';
SELECT * FROM ALL_TAB_COMMENTS WHERE TABLE_NAME='MEMBER1';
COMMENT ON COLUMN MEMBER1.MEM_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER1.MEM_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER1.MEM_PASSWARD IS '회원비밀번호';

SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME='MEMBER1';

--테이블의 제약조건 확인하기
DESC USER_CONSTRAINTS;
DESC USER_CONS_COLUMNS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME='EMPLOYEE';
--TYPE : C -> CHECK 또는 NOT NULL / R-> FOREIGN KEY
--       P -> PRIMARY KEY / U -> UNIQUE

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME='MEMBER1';

CREATE TABLE MEMBER2 (
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_ID VARCHAR2(10) UNIQUE,
    MEM_PASSWORD VARCHAR2(20)
);
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME='MEMBER2';
-- NOT NULL제약조건
-- 특정컬럼에 무조건 데이터를 넣어야할때 설정하는 제약조건
-- NULL에 대해 조건을 설정하지 않으면 NULL무조건 허용.

CREATE TABLE USER_NCONS(
    USERNO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PW VARCHAR2(30),
    USER_NAME VARCHAR2(20),
    GENDER VARCHAR2(30),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);
INSERT INTO USER_NCONS VALUES(NULL,NULL,NULL,NULL,NULL,NULL,NULL);
SELECT * FROM USER_NCONS;
--ID, PW, NO에는 값이 반드시 필요하기 때문에
--NULL값이 못 들어오게 설정해보자
CREATE TABLE USER_CONS(
    USERNO NUMBER NOT NULL,
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(20),
    GENDER VARCHAR2(30),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);
INSERT INTO USER_CONS VALUES(1,'ADMIN','1234',NULL,NULL,NULL,NULL);
INSERT INTO USER_CONS(USER_ID,USER_PW) 
VALUES ('USER01','USER01');
INSERT INTO USER_CONS(USER_ID,USER_PW,USERNO)
VALUES('USER01','USER01',002);
--UNIQUE : 지정된 컬럼에 중복된 데이터가 들어가지 않게 설정
CREATE TABLE USER_NUNI(
    USERNO NUMBER NOT NULL,
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(20),
    GENDER VARCHAR2(30),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);
INSERT INTO USER_NUNI VALUES(1,'ADMIN','1234',
'관리자','남','01036446259','PRINCE0324@NAVER.COM');
INSERT INTO USER_NUNI VALUES(2,'ADMIN','1234',
'관리자2','여','01036446259','PRINCE0324@NAVER.COM');
SELECT * FROM USER_NUNI;

CREATE TABLE USER_UNI3(
    USERNO NUMBER NOT NULL,
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(20),
    GENDER VARCHAR2(30),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    UNIQUE(USER_ID),PRIMARY KEY(USERNO)
);
INSERT INTO USER_UNI2 VALUES(1,'ADMIN','1234',
'관리자','남','01036446259','PRINCE0324@NAVER.COM');
INSERT INTO USER_UNI2 VALUES(2,'USER01','1234',
'관리자2','여','01036446259','PRINCE0324@NAVER.COM');
INSERT INTO USER_UNI2 VALUES(3,'USER01','1234',
'관리자2','여','01036446259','PRINCE0324@NAVER.COM');

SELECT * FROM USER_UNI;

CREATE TABLE CONS_UNI_GROUP(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PW VARCHAR2(20),
    USER_NAME VARCHAR2(30),
    UNIQUE(USER_NO,USER_ID)
);
INSERT INTO CONS_UNI_GROUP 
VALUES(1,'ADMIN','1234','관리자');
INSERT INTO CONS_UNI_GROUP 
VALUES(2,'ADMIN','1234','관리자');
INSERT INTO CONS_UNI_GROUP 
VALUES(1,'USER01','1234','관리자');
INSERT INTO CONS_UNI_GROUP 
VALUES(2,'ADMIN','1234','관리자');

SELECT * FROM CONS_UNI_GROUP;

--PRIMARY KEY : 테이블에서 데이터(행)구별할 수 있는 식별자
-- NOT NULL제약조건, UNOIQUE제약조건이 설정됨
-- 테이블에 한개만(한개컬럼)에 설정할 수 있음
-- 기본적으로 테이블당 설정하는 것이 좋음
-- PRIMARY KEY를 설정하면 자동으로 그 컬럼에 기본 인덱스가 설정됨
-- 컬럼레벨, 테이블레벨에서 설정 가능
CREATE TABLE USER_PRIMARY(
    USERNO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20),
    USER_PW VARCHAR2(30),
    USER_NAME VARCHAR2(20),
    GENDER VARCHAR2(30),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);
INSERT INTO USER_PRIMARY 
VALUES(1,'ADMIN','1234','관리자','남','0103644','PRIN');
INSERT INTO USER_PRIMARY 
VALUES(2,'USER01','5555','사용자','여','0103644','PRIN');
INSERT INTO USER_PRIMARY 
VALUES(NULL,'USER01','5555','사용자','여','0103644','PRIN');
INSERT INTO USER_PRIMARY 
VALUES(1,'USER01','5555','사용자','여','0103644','PRIN');

CREATE TABLE USER_PRIMARY_TB(
    USERNO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PW VARCHAR2(30),
    USER_NAME VARCHAR2(20),
    GENDER VARCHAR2(30),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    PRIMARY KEY(USERNO)
);
INSERT INTO USER_PRIMARY_TB
VALUES(1,'USER02','관리자','111','남','0101','P');
INSERT INTO USER_PRIMARY_TB
VALUES(1,'USER03','관리자','111','남','0101','P');

--복합키로 여러컬럼을 묶어서 PRIMARY KEY로 등록 가능
--복합키로 설정시에는 테이블레벨에서 설정
CREATE TABLE TBL_COMPOSITE_KEY(
    PROC_NO VARCHAR2(20),
    USER_ID VARCHAR2(20),
    ORDER_DATE DATE,
    ORDER_NUM NUMBER,
    PRIMARY KEY(PROC_NO,USER_ID,ORDER_DATE)
);
INSERT INTO TBL_COMPOSITE_KEY
VALUES('P111','USER01',SYSDATE,10);
INSERT INTO TBL_COMPOSITE_KEY
VALUES('P112','USER01','19/06/25',11);
SELECT * FROM TBL_COMPOSITE_KEY;

--FOREIGN KEY : 외부의 테이블에서 값을 가져오는것!
CREATE TABLE USER_GRADE(
    GRADE_NO NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(10)
);
INSERT INTO USER_GRADE VALUES(10,'일반');
INSERT INTO USER_GRADE VALUES(20,'실버');
INSERT INTO USER_GRADE VALUES(30,'골드');
SELECT * FROM USER_GRADE;

CREATE TABLE MEMBER_FOREIGN(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) NOT NULL UNIQUE,
    USER_PW VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(20),
    GRADE_NO NUMBER,
    FOREIGN KEY(GRADE_NO) REFERENCES USER_GRADE(GRADE_NO)
);
--인서트는 나중에
SELECT * FROM USER_GRADE;
INSERT INTO MEMBER_FOREIGN
VALUES(1,'USER01','USER01','최장원',10);
SELECT * FROM MEMBER_FOREIGN;

CREATE TABLE MEMBER_FOREIGN1(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) NOT NULL UNIQUE,
    USER_PW VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(20) REFERENCES USER_GRADE(),
    GRADE_NO NUMBER,
    FOREIGN KEY(GRADE_NO) REFERENCES USER_GRADE
);
INSERT INTO MEMBER_FOREIGN1
VALUES(1,'USER01','USER01','최장원',30);

CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(20) PRIMARY KEY,
    USER_PW VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(20) NOT NULL,
    EMAIL VARCHAR2(30) NOT NULL
);
INSERT INTO USER_TBL 
VALUES('USER01','USER01','여동규','AAA@KH.COM');
INSERT INTO USER_TBL 
VALUES('USER02','USER02','오건철','BBB@KH.COM');
INSERT INTO USER_TBL 
VALUES('USER03','USER03','윤원택','CCC@KH.COM');
SELECT * FROM USER_TBL;

CREATE TABLE PRODUCT_TBL(
    PRO_ID VARCHAR2(20) PRIMARY KEY,
    PRO_NAME VARCHAR2(20),
    PRICE NUMBER
);
INSERT INTO PRODUCT_TBL VALUES('F01','침대',1000000);
INSERT INTO PRODUCT_TBL VALUES('E01','컴퓨터',1200000);
INSERT INTO PRODUCT_TBL VALUES('E02','에어컨',2000000);
SELECT * FROM PRODUCT_TBL;

create table shop(
    user_id varchar2(20),
    pro_id varchar2(20),
    purchaseDay date
);

select * from shop;
select * 
from shop s left join user_tbl u on s.user_id=u.user_id;
select * from user_tbl;

create table shop2(
    user_id varchar2(20) NOT NULL references user_tbl(user_id),
    pro_id varchar2(20) NOT NULL references product_tbl(pro_id),
    purchaseDay date
);

insert into shop1 values('user03','e01',sysdate);
insert into shop1 values('USER03','E01',sysdate);
insert into shop1 values(NULL,NULL,sysdate);

SELECT * FROM SHOP1 S
JOIN USER_TBL U ON S.USER_ID=U.USER_ID;

SELECT * FROM SHOP1;
DELETE FROM USER_TBL WHERE USER_ID='USER01';

--참조키에 삭제에 대한 옵션을 설정할 수 있음
-- ON DELETE 옵션 : SET NULL : 너는 NULL로 바꿔라~
--                  CASCADE : 부모값지워지면 너두 사라져!

SELECT * FROM USER_TBL;

DROP TABLE SHOP3;
create table shop3(
    user_id varchar2(20) references user_tbl(user_id) ON DELETE CASCADE,
    pro_id varchar2(20) references product_tbl(pro_id) ON DELETE CASCADE,
    purchaseDay date
);
INSERT INTO USER_TBL VALUES('USER01','123','지존준영','JIJON@D');
INSERT INTO SHOP3 VALUES('USER01','E02',SYSDATE);
SELECT * FROM SHOP3;
DELETE FROM USER_TBL WHERE USER_ID='USER01';
SELECT * FROM USER_TBL;

--CHECK제약조건 : 데이터로 들어오는값을 특정값으로 제한하는것

CREATE TABLE CHECK_TBL(
 USERNAME VARCHAR2(20),
 GENDER VARCHAR2(10) CHECK(GENDER IN ('남','여','그'))
 );
INSERT INTO CHECK_TBL VALUES('유병승','남자');
INSERT INTO CHECK_TBL VALUES('유병승','여');

--subquery를 이용한 create table 

create table employee_tbl
as select * from employee
join department on dept_id=dept_code
join job using(job_code)
join location on local_code=location_id;
select emp_name,dept_title,job_name from employee_tbl;

--컬럼만 복사해서 테이블 생성
create table temp
as select emp_name, salary, bonus
   from employee where 1=0;
   
select * from temp;
--alter table : 테이블에 설정된 컬럼 추가,변경 제약조건을 추가/변경
--테이블에 컬럼추가하기
select * from user_tbl;
--add옵션사용
alter table user_tbl add(age number);
--user_tbl 주소 추가
alter table user_tbl add(address varchar2(30));

--컬럼에 대해 기본값을 설정
create table defaulttest(
    age number default 10
);
insert into defaulttest values(19);
insert into defaulttest values(default);
select * from defaulttest;
--컬럼을 추가하면서 제약조건 설정
alter table user_tbl 
add(national varchar2(20)default '한국');
alter table user_tbl 
add(user_no varchar2(20)unique);
--성별추가
alter table user_tbl
add(gender varchar2(10) default '여' check(gender in('남','여')));
select * from user_tbl;

--제약조건 추가
create table add_cons(
    emp_no number,
    emp_id varchar2(20),
    emp_pw varchar2(20)
);
alter table add_cons
add constraint pk_add_cons primary key(emp_no);
--emp_id unique제약조건 설정!
alter table add_cons
add constraint uni_add_cons_id unique(emp_id);
--emp_pw not null 제약조건 설정
alter table add_cons
add constraint not_pw not null;
--null <-- null able 제약조건이 null 이미 설정이 되어 있음
--추가하는 것이 아니라 수정 이미 설정된 null->not null로 변경!
alter table add_cons
modify emp_pw constraint not_null_pw not null;
--컬럼의 내용을 수정(자료형, 길이)
alter table add_cons
modify emp_no varchar2(20);
desc add_cons;
--emp_id 길이를 100으로 변경
alter table add_cons
modify emp_id varchar2(100);

--컬럼삭제하기
--drop column 컬럼명
alter table add_cons
drop column emp_pw;
select * from add_cons;
--제약조건 삭제
--drop constraint 제약조건명
select * from employee;
alter table employee
drop constraint SYS_C007037;
--컬럼명칭을 변경
--alter table 테이블명 rename column 대상 to 변경값
alter table add_cons rename column emp_no to no;
select * from add_cons;

--테이블 이름 바꾸기
alter table add_cons rename to ah_training;
select * from add_cons;
select * from ah_training;
rename ah_training to add_cons;

--테이블 삭제~
drop table add_cons;

--DCL(Data Control Language)
--데이터에 접근, 수정, 삭제 등 데이터를 조작하는 기능을 통제
--grant(권한부여), revoke(권한회수) commit(데이터확정), rollback(되돌리기)
--grant
--grant 권한명,(select, update, delete...등)||role TO 대상 [option]
-- * with admin option 
select * from DBA_sys_PRIVS
where GRANTEE='KH';
select * from DBA_role_PRIVS
where GRANTEE='KH';

grant select, update on scott.emp to kh;

select * from scott.emp;
update scott.emp set comm=30 where empno=7934;

select * from USER_sys_PRIVS;

--권한을 회수
revoke update on scott.emp from kh;--system계정에서
update scott.emp set comm=30;


--role 부여된 권한보기
select * from  dba_sys_privs
where grantee in('CONNECT','RESOURCE');

--참조키
DROP TABLE USER1;
CREATE TABLE USER1(
    USER_ID VARCHAR2(20) PRIMARY KEY,
    USER_PW VARCHAR2(20) NOT NULL
);
INSERT INTO USER1 VALUES('ADMIN','1234');
INSERT INTO USER1 VALUES('USER01','1234');
INSERT INTO USER1 VALUES('USER02','1234');
CREATE TABLE BOARD1(
    TITLE VARCHAR2(100),
    COMMENTS VARCHAR2(500),
    WRITER VARCHAR2(20) REFERENCES USER1(USER_ID) ON DELETE CASCADE
);
INSERT INTO BOARD1 VALUES('무관','무관무관','USER01');
INSERT INTO BOARD1 VALUES('원택','원택원택','USER02');
INSERT INTO BOARD1 VALUES('은철','은철은철','USER03');
SELECT * FROM BOARD1;
DELETE FROM USER1 WHERE USER_ID='USER01';



----------------------
-- VIEW
----------------------
/*
    view : select를 실행한 결과를 화면에 담는 객체
        select 문장 자체를 저장하여
        호출할때마다 해당쿼리 실행하여 결과를 보여준다.
        
        실질적으로 데이터를 담고 있지 않다.
        노출하고 싶지 않은 정보 조회시 제외.
        
        검색의 효율성 : 내가 찾고자 하는 정보만 조회할수 있다.
        보안성 : 내가 테이블의 정보를 숨길수 있다.
*/


-- View 사용법
-- CREATE OR REPLACE VIEW 뷰이름[컬럼 별칭, 컴럼 별칭2, ....]
-- AS 
--  SELECT EMP_ID, EMP_NAME, DEPTE_COD
--  FROM EMPOYEE;

-- SELECT * FROM 뷰이름;

-- 뷰 권한을 부여(SYSTEM 계정에서)
GRANT CREATE VIEW TO KH;

--view 확인 ( view data dictionary ) 
SELECT * FROM USER_VIEWS;

--VIEW 생성(EMP_NO, EMP_NAME, EMAIL, PHONE )
CREATE OR REPLACE VIEW VIEW_EMP
AS
    SELECT EMP_ID, EMP_NO, EMP_NAME,EMAIL, PHONE, JOB_CODE, SAL_LEVEL
    FROM EMPLOYEE;

--VIEW 데이터 확인
SELECT * FROM VIEW_EMP;
SELECT * FROM USER_VIEWS WHERE VIEW_NAME = 'VIEW_EMP';

--실습 1.
-- 사번, 이름, 직급명, 부서명, 근무지역을 조회하고
-- 그 결과를 V_RESULTSET_EMP 라는 뷰를 만들어
-- 그 뷰를 통해 결과를 확인해봅시다.

--1. 쿼리를 먼저 작성
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
LEFT JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID )
LEFT JOIN LOCATION ON ( LOCATION_ID = LOCAL_CODE );

--2. 뷰에 대입
CREATE OR REPLACE VIEW 
        V_RESULTSET_EMP(사번, 이름, 직급명, 부서명, 근무지)
AS
    SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
    FROM EMPLOYEE
    LEFT JOIN JOB USING(JOB_CODE)
    LEFT JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID )
    LEFT JOIN LOCATION ON ( LOCATION_ID = LOCAL_CODE );
--3. 뷰를 실행
SELECT * FROM V_RESULTSET_EMP;

-- 실습2. 만들어진 VIEW를 활용해서
--      사번이 '205'번인 직원 정보 조회를 해보자
SELECT * FROM V_RESULTSET_EMP WHERE 사번 = '205';

-- TABLE 변경
UPDATE EMPLOYEE SET EMP_NAME= '정중앙' 
WHERE EMP_ID='205';

SELECT * FROM V_RESULTSET_EMP
WHERE 사번='205';

--View 특징
--1. 컬럼뿐 아니라 산술연산 처리한 view 생성도 가능하다.
CREATE OR REPLACE VIEW VIEW_EMP_SALARY
AS
    SELECT EMP_NAME 사원명, 
        ( SALARY + ( SALARY*NVL(BONUS,0)))*12 AS 연봉
    FROM EMPLOYEE;

--VIEW 확인
SELECT * FROM VIEW_EMP_SALARY;

-- 2. JOIN을 활용한 VIEW도 생성 가능
--문제
-- EMPLOYEE 테이블에서 사번, 사원이름, 직급, 부서명 
-- 컬럼(직급: NULL -> 인턴 )을 가진 VIEW_EMP_READ를 만들고
-- 확인해보자.
CREATE OR REPLACE VIEW VIEW_EMP_READ
AS 
    SELECT EMP_ID 사번, EMP_NAME 사원명, NVL(JOB_NAME,'인턴') 직급,
        DEPT_TITLE 부서명
    FROM EMPLOYEE
    LEFT JOIN JOB USING(JOB_CODE) --EMPLOYEE와 JOB과의 JOIN 
    LEFT JOIN DEPARTMENT 
        ON EMPLOYEE.DEPT_CODE = DEPARTMENT.DEPT_ID;
    
SELECT * FROM VIEW_EMP_READ;

-- VIEW의 DML 사용 
-- 생성된 뷰를 가지고 DML 구문 사용이 가능하다.
-- DML 구문을 가지고 뷰 테이블에 내용을 변경할시 실제 테이블도 변경

-- VIEW_EMP -> EMP_ID, EMP_NAME, EMAIL, PHONE, JOB_CODE, SAL_LEVEL


SELECT * FROM VIEW_EMP;

INSERT INTO VIEW_EMP VALUES('500', '790626-1034555', '강오덩', 
    'kang@naver.com','01012345678','D5','S3');

--데이터 수정/삭제
UPDATE VIEW_EMP SET EMP_NO='881123-2000123' WHERE EMP_ID=500;
DELETE FROM VIEW_EMP WHERE EMP_ID='500';


--뷰에서도 데이터 추가, 수정, 삭제가 가능하다.
--다음 6가지 상황에서는 불가능하다.
--1. 뷰에 정의되지 않은 컬럼을 수정할 경우
--2. 뷰에서 보이지 않는 컬럼중
--     NOT NULL 제약조건을 가진 컬럼이 있을 경우
--3. 산술연산이 적용된 컬럼이 있을 경우
--4. JOIN을 통해 여러 테이블을 참조할 경우
--      -조회한 테이블의 정보중에 기본키의 요소가 단한개
--       일 경우에는 변경이 가능하다.
--5. DISTINCT를 사용하여 실제데이터의 내용이 
--   명확하지 않은 경우
--6. 그룹함수나 GROUP BY 구문을 사용해서 조회한 쿼리일 경우 

-- 1.뷰에 정의되어 있지 않은 컬럼을 수정할 경우
CREATE OR REPLACE VIEW V_JOB
AS
    SELECT JOB_CODE FROM JOB;

SELECT * FROM V_JOB;

--00913. 00000 -  "too many values"
INSERT INTO V_JOB VALUES('J8','인턴');

--00904. 00000 -  "%s: invalid identifier"
UPDATE V_JOB SET JOB_NAME = '인턴'
    WHERE JOB_CODE='J7';

-- 3. 산술표현일 경우
CREATE OR REPLACE VIEW V_EMP_SAL
AS
    SELECT EMP_ID, EMP_NAME, SALARY,
            (SALARY + SALARY*NVL(BONUS,0))*12 연봉
    FROM EMPLOYEE;
    
SELECT * FROM V_EMP_SAL;

01733. 00000 -  "virtual column not allowed here"
INSERT INTO V_EMP_SAL 
    VALUES(901, '손흥만', 3000000, 40000000);


--4. JOIN을 통해서 VIEW의 정보를 수정하는 경우
CREATE OR REPLACE VIEW V_JOIN_EMP
AS
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID );

SELECT * FROM V_JOIN_EMP;

--ORA-01776: cannot modify more than one base table through a join view
INSERT INTO V_JOIN_EMP VALUES(911,'여동규','기술지원부');

--ORA-01779: cannot modify a column which maps to a non key-preserved table
UPDATE V_JOIN_EMP SET DEPT_TITLE = '기술지원부'
        WHERE EMP_ID=218;

--4-1. JOIN 통해서 여러 테이블을 참조할 경우 / 삭제는 가능
DELETE FROM V_JOIN_EMP
    WHERE DEPT_TITLE='기술지원부';

SELECT * FROM V_JOIN_EMP;
SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;

ROLLBACK;

--5. DISTINCT를 사용 하는 경우
CREATE OR REPLACE VIEW V_DEPT_EMP
AS 
    SELECT DISTINCT DEPT_CODE
    FROM EMPLOYEE;
    
SELECT * FROM V_DEPT_EMP;

--ORA-01732: data manipulation operation not legal on this view
INSERT INTO V_DEPT_EMP VALUES('D0');

--ORA-01732: data manipulation operation not legal on this view
DELETE FROM V_DEPT_EMP WHERE DEPT_CODE='D9';



--6. 그룹함수, GROUP BY
CREATE OR REPLACE VIEW V_GROUP_DEPT
AS
    SELECT DEPT_CODE, SUM(SALARY) 합계, TRUNC(AVG(SALARY),-4) 평균
    FROM EMPLOYEE
    GROUP BY DEPT_CODE;

SELECT * FROM V_GROUP_DEPT;

--ORA-01733: virtual column not allowed here
INSERT INTO V_GROUP_DEPT VALUES('D10',50000,50000);

--ORA-01732: data manipulation operation not legal on this view
UPDATE V_GROUP_DEPT SET DEPT_CODE='D10'
WHERE DEPT_CODE='D5';

--ORA-01732: data manipulation operation not legal on this view
DELETE FROM V_GROUP_DEPT WHERE DEPT_CODE='D6';

--VIEW 생성 시 설정할 수 있는 옵션
-- OR REPLACE : 기존에 있던 동일한 이름의 뷰가 있을 경우에
--              해당뷰를 덮어씌우고 , 없다면 새로 만들겠다.
-- FORCE / NO FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도
--                  뷰를 강제로 생성할 것인지 설정
-- WITH CHECK / READ ONLY :
--      CHECK : 설정한 컬럼의 값을 바꾸지 못하게 막는 설정
--      READ ONLY : 뷰에 어떠한 컬럼도 뷰를 통해서 변경하지
--        변경하지 못하게 막는 설정

-- FORCE : 존재하지 않는 테이블 뷰를 강제로 생성
CREATE OR REPLACE FORCE VIEW V_EMP
AS
    SELECT T_CODE, T_NAME, T_CONTENT
    FROM TEST_TABLE;

SELECT * FROM V_EMP;

SELECT * FROM USER_VIEWS;

DROP VIEW V_EMP;

--NO FORECE : 만약 생성하려는 뷰의 테이블이 존재하지 않을때
--              뷰를 생성하지 않겠다.
CREATE OR REPLACE /*NOFORCE*/ VIEW V_EMP
AS
    SELECT T_CODE, T_NAME, T_CONTENT
    FROM TEST_TABLE;

-- 기본값 NOFORCE

-- WITH CHECK : 뷰에 존재하는 컬럼을 추가하거나 수정하지 
--              못하게 막는 옵션
CREATE OR REPLACE VIEW V_EMP
AS
    SELECT * FROM EMPLOYEE
    WITH CHECK OPTION;

SELECT * FROM V_EMP;

--ORA-32575: Explicit column default is not supported for modifying views
INSERT INTO V_EMP 
    VALUES( 810, '류별리', '101010-1234567', 'ryu@kh.or.kr', 
        '01012344321','D1', 'J7','S1', 8000000, 0.1, 
            200, SYSDATE, NULL, DEFAULT );

--DELETE 가능
DELETE FROM V_EMP
    WHERE EMP_ID = '200';

ROLLBACK;

-- WITH READ ONLY : 데이터 입력, 수정, 삭제 모두 막는 옵션
CREATE OR REPLACE VIEW V_EMP
AS
    SELECT * FROM EMPLOYEE
    WITH READ ONLY;

SELECT * FROM V_EMP;

--ORA-32575: Explicit column default is not supported for modifying views
INSERT INTO V_EMP 
    VALUES( 810, '류별리', '101010-1234567', 'ryu@kh.or.kr', 
        '01012344321','D1', 'J7','S1', 8000000, 0.1, 
            200, SYSDATE, NULL, DEFAULT );

--ORA-42399: cannot perform a DML operation on a read-only view
DELETE FROM V_EMP WHERE EMP_ID='200';




-----------------------
--SEQUENCE
-----------------------
-- 1,2,3,4,5 ..... 이러한 형식으로
-- 숫자 데이터를 자동으로 카운트하는 객체

/*
    CREATE SEQUENCE 시퀀스명
    [INCREMENT BY 숫자] : 다음값에 증감수치,생략시 1씩증가
        --INCREMENT BY 5 -> 5씩 증가
        --INCREMENT BY -5 -> 5씩 감소
    [START WITH 숫자] : 시작값, 생략하면 1부터
    [MAXVALUE 숫자 | NOMAXVALUE ] : 발생시킬 값의 최대값 설정(10^27-1)
    [MINVALUE 숫자 | NOMINVALUE ] : 발생시킬 값의 최소값 설정(-10^26)
    [CYCLE | NOCYCLE ] : 값의 순환여부
    [CACHE 바이트크기 | NOCACHE ] : 값을 미리 구해놓고 
                                다음값을 반영할 때 활용하는 설정
                                --기본값 20Byte | 최소값 2Byte
*/
CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;
        
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

--현재 값 확인
SELECT SEQ_EMPID.CURRVAL FROM DUAL;


--시퀀스 설정 변경하기
ALTER SEQUENCE SEQ_EMPID
--ORA-02283: cannot alter starting sequence number
--START WITH 315
INCREMENT BY 10
MAXVALUE 400
NOCYCLE
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;


--SELECT * FROM USER_VIEWS;
SELECT * FROM USER_SEQUENCES;

-- SELECT 구문에서 데터 조회시에 사용 가능
-- INSERT, UPDATE 에서도 사용 가능하다.

--시퀀스 삭제하기
DROP SEQUENCE SEQ_EMPID;

--------------------------
CREATE SEQUENCE SEQ_EID
START WITH 300
INCREMENT BY 1
MAXVALUE 10000
NOCYCLE
NOCACHE;

--데이터 추가
INSERT INTO EMPLOYEE 
VALUES(
    SEQ_EID.NEXTVAL, '송주미', '121203-1234567',
    'song@kh.or.kr', '01012334556', 'D2', 'J7',
    'S1',5000000,0.1,200,SYSDATE, NULL, DEFAULT
);

SELECT * FROM EMPLOYEE WHERE EMP_NAME='송주미';


SELECT * FROM USER_SEQUENCES;

-- D9부서에 J7 직급의 사원 4명을 
-- 시퀀스를 활용하여 추가하시오.
INSERT INTO EMPLOYEE
VALUES (SEQ_EID.NEXTVAL, '오건철', '110101-1234567', 'gong123@kh.or.kr',
        '01012344321','D9','J7','S1',5000000,0.1, 200, SYSDATE,
        NULL, DEFAULT);
INSERT INTO EMPLOYEE
VALUES (SEQ_EID.NEXTVAL, '김기호', '500101-1234567', 'gogil@kh.or.kr',
        '01012344321','D9','J7','S1',5000000,0.1, 200, SYSDATE,
        NULL, DEFAULT);
INSERT INTO EMPLOYEE
VALUES (SEQ_EID.NEXTVAL, '윤원택', '530101-1234567', 'ahn0123@kh.or.kr',
        '01012344321','D9','J7','S1',5000000,0.1, 200, SYSDATE,
        NULL, DEFAULT);
INSERT INTO EMPLOYEE
VALUES (SEQ_EID.NEXTVAL, '김준영', '670101-1234567', 'park007@kh.or.kr',
        '01012344321','D9','J7','S1',5000000,0.1, 200, SYSDATE,
        NULL, DEFAULT);

SELECT * FROM EMPLOYEE;

-- 시퀀스 옵션 CYCLE/ CACHE
-- CYCLE : 시퀀스의 값이 최소값OR최대값 도달했을때
--          다시 반대의 값부터 시작하는 옵션.

CREATE SEQUENCE SEQ_CYCLE
START WITH 200
INCREMENT BY 10
MAXVALUE 230
MINVALUE 15
CYCLE
NOCACHE;

SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
--SELECT SEQ_CYCLE.CURRVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;


-- CACHE / NOCACHE
-- CACHE : 컴퓨터가 다음값에대한 연산들 
--          그때그때 수행하지 않고
--          미리 계산해 놓는 것
-- NOCACHE : 컴퓨터가 수행할값을 그때그때 처리 하는 것.

CREATE SEQUENCE SEQ_CACHE
START WITH 100
INCREMENT BY 1
CACHE 20
NOCYCLE;

SELECT SEQ_CACHE.NEXTVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;


---------------------
--INDEX
---------------------
-- SQL 명령어 조회처리속도를 향상시키기 위한 객체다.
-- 테이블의 식별자(기본키, 고유키)가 되는 컬럼값에대해
-- 각 컬럼단위로 일정간격을 계산하여 조회속도를 향상시킨다.
--

--장점
-- 검색속도가 향샹된다.

--단점
-- 인덱스가 존재하느 테이블의 내용이
-- 자주변경되는 테이블이라면
-- 인덱스를 매번 다시 계산
-- => 성능이 저하될수 있다.

-- 인데스를 저장하기 위한 별도의 공간을 할당해야 한다.

-- 읽기성능은 비약적으로 향상, 쓰기 성능은 비관적 하향

-- 인덱스 생성방법
-- CREATE [UNIQUE] INDEX 인덱스명
-- ON 테이블명( 컬럼명 )

--인덱스 확인
SELECT * FROM USER_IND_COLUMNS;


--인덱스의 구조
SELECT ROWID, EMP_ID, EMP_NAME FROM EMPLOYEE;
--ROWID
-- 

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
CREATE UNIQUE INDEX IDX_DEPT_CODE
ON EMPLOYEE(DEPT_CODE);

SELECT * FROM EMPLOYEE;

-- 2. 비고유 인덱스
-- 중복된 값을 가진 컬럼에 사용 가능
--
CREATE INDEX IDX_DEPT_CODE
ON EMPLOYEE(DEPT_CODE);

-- 지금까지는 컬럼 하나 -> 단일 인덱스

-- 3. 결합 인덱스 
-- 두개 이상의 컬럼으로 인덱스를 구성하는 것
CREATE INDEX IDX_DEPT
ON DEPARTMENT( DEPT_ID, DEPT_TITLE );

SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT
WHERE DEPT_ID !='D1'
    AND DEPT_TITLE != '기술지원부';

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
ON EMPLOYEE( (SALARY*NVL(BONUS,0)+SALARY)*12 );

SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE (SALARY*NVL(BONUS,0)+SALARY)*12 >1000000;


-- PL/SQL --
-- (PROCEDURAL LANGUAGE EXTENSION TO SQL)
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


-- 변수에 값 대입
-- 변수명 := 값;
DECLARE 
    V_EMPNO NUMBER(4);
    v_empname varchar2(10);
    test_num number(5) := 10*20;
BEGIN
    V_EMPNO := 1001;
    V_EMPNAME := '윤원택';
    DBMS_OUTPUT.PUT_LINE('사번       이름');
    DBMS_OUTPUT.PUT_LINE('--------------');
    DBMS_OUTPUT.PUT_LINE(V_EMPNO ||'   '||V_EMPNAME);
    DBMS_OUTPUT.PUT_LINE('TEST_NUM = '||TEST_NUM);
END;
/
------------------------------------
--[2] 레퍼런스 변수
-- %TYPE : 한 컬럼의 자료형을 받아 올때 사용하는 자료형 타입
DECLARE 
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    JOB_CODE EMPLOYEE.DEPT_CODE%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, NVL(DEP
    T_CODE,'-'), JOB_CODE, SALARY
    INTO EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    FROM EMPLOYEE
    WHERE EMP_NAME='&EMP_NAME';
    
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

-- @
-- 사원번호를 입력받아서 사원의 사번,이름급여,보너스율을 출력하자!
-- 추가로 대표님인 경우, '대표님~~~하뚜' 
DECLARE 
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS,0), JOB_CODE
    INTO EMP_ID, EMP_NAME, SALARY, BONUS, JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_ID=&EMP_ID;
    
    DBMS_OUTPUT.PUT_LINE(EMP_ID);
    DBMS_OUTPUT.PUT_LINE(EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(SALARY);
    DBMS_OUTPUT.PUT_LINE(BONUS*100||'%');
    
    IF (JOB_CODE ='J1')
    THEN DBMS_OUTPUT.PUT_LINE('대표님 하뜨~~');
    END IF; 
END;
/

-- 2. IF ~ THEN ~ ELSE ~ END IF
DECLARE 
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
    EMP_TEAM VARCHAR2(20);
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS,0), JOB_CODE
    INTO EMP_ID, EMP_NAME, SALARY, BONUS, JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_ID=&EMP_ID;
    
    DBMS_OUTPUT.PUT_LINE(EMP_ID);
    DBMS_OUTPUT.PUT_LINE(EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(SALARY);
    DBMS_OUTPUT.PUT_LINE(BONUS*100||'%');
    
    IF JOB_CODE='J1' THEN EMP_TEAM :='대표';
    ELSE EMP_TEAM :='직원';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('소속 :' || EMP_TEAM); 
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
--대표(J1),임원진(J2), 일반직원(나머지) 구분한 예제를
--CASE문으로 구현
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
    
    DBMS_OUTPUT.PUT_LINE(E.EMP_ID);
END;
/

-- LOOP, FOR, WHILE

--일반 LOOP 문
/*
    LOOP
        반복시킬 내용
        IF 반복 종료 조건 
            EXIT;
        END IF;
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
----------------------------------------
/*
    [VIEW]
    -가상의테이블
    CREATE OR REPLACE VIEW 뷰이름(컬럼, 컬럼, ....)
    AS
        SELECT EMP_ID, EMP_NAME, ... 
        FROM EMPLOYEE;
        
    SELECT * FROM 뷰이름;
    보안성, 검색의 효율성
    
    [SEQUENCE]
    1,2,3,4 .... 등의 숫자 증감시키는 
    데이터 베이스 객체
    
    CREATE SEQUENCE 시퀀스명
    STRAT WITH 시작값
    INCREMENT BY 증감 값
    MAXVALUE/NOMAXVALUE 최대값
    MINVALUE/NOMINVALUE 최소값
    CYCLE/NOCYLE 순환여부
    CACHE/NOCACHE 값을 미리계산 할지 말지
    
    
    [INDEX]
    테이블에서 특정데이터를 검색할때,
    효율적으로 검색하기 위한 객체
    
    CREATE INDEX 인덱스명
    ON 테이블명( 컬럼, 컬럼.. )
    
    
    PL/SQL
    
    DECLARE
    BEGIN
        EXCEPTION
    END;
    /
*/

SET SERVEROUTPUT ON;

--문제
-- 1~ 10사이의 난수를 5개 출력해보자!!
-- DBMS_RANDOM.VALUE(LOW,HIGH)
-- 난수발생시키는 함수. LOW보다 크거나 같고, HIGH보다 작은 범위
DECLARE 
    RND_NO NUMBER;
    N NUMBER := 0;
BEGIN
    LOOP
        N :=N+1;
        DBMS_OUTPUT.PUT_LINE(TRUNC(DBMS_RANDOM.VALUE(1,11)));
        EXIT WHEN N>5;
    END LOOP;
END;
/
--FOR 반복문 --
/*
    FOR 카운터변수 IN [REVERSE] 시작값..종료값 LOOP
        반복할 내용
    END LOOP;
*/
-- FOR LOOP 카운터변수 -> 자동 선언
-- 카운트 값은 자동으로 1씩 증가
BEGIN
    FOR N IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

--FOR문을 반대로 실행해 보자
BEGIN
    FOR N IN REVERSE 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/

BEGIN
    FOR I IN 1..9 LOOP
        FOR J IN 2..9 LOOP
            DBMS_OUTPUT.PUT_LINE(J || '*' ||I|| '=' || J*I);
            DBMS_OUTPUT.PUT_LINE('  ');
        END LOOP;
    END LOOP;
END;
/

--문제
-- 구구단, 짝수단 출력
-- FOR, IF, MOD()
DECLARE 
    RES NUMBER;
BEGIN
    FOR DAN IN 2..9 LOOP
        IF MOD(DAN, 2) = 0
            THEN FOR SU IN 1..9 LOOP
                RES := DAN * SU;
                DBMS_OUTPUT.PUT_LINE(
                DAN||' * '||SU||' = '||RES);
            END LOOP;
        END IF;
    END LOOP;
END;
/

--FOR문을 통한 INSERT

CREATE TABLE TB_TEST_FOR(
    NO NUMBER,
    TEST_DATE DATE
);

BEGIN
    FOR X IN 1..10 LOOP
        INSERT INTO TB_TEST_FOR VALUES(X,SYSDATE+X);
    END LOOP;
END;
/

SELECT * FROM TB_TEST_FOR;


--문제
-- PL/SQL의 FOR 반복문을 이용하여 EMPLOYEE테이블의
--200번 부터 210까지 사원의 아이디,이름,메일 출력 해보자
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ID    NAME    EMAIL');
    DBMS_OUTPUT.PUT_LINE('---------------------------------');

    FOR I IN 0..10 LOOP
        SELECT *
        INTO E
        FROM EMPLOYEE
        WHERE EMP_ID = 200+I;
        
        DBMS_OUTPUT.PUT_LINE(E.EMP_ID||'    '||E.EMP_NAME||
                        '    '||E.EMAIL);
    END LOOP;
END;
/

-- WHILE문
-- 제어조건이 TRUE 동안만 반복
--
/*
    [사용형식]
    WHILE 반복할 조건식 LOOP
        반복할 스크립트 내용;
    END LOOP;
*/
DECLARE 
    N INT := 5;
BEGIN
    WHILE N > 0  LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N-1;
    END LOOP;
END;
/

--2~9사이의 수를 입력 받고, 구구단 출렵해보자.
DECLARE 
    DAN NUMBER;
    N NUMBER := 2;
BEGIN
    DAN := &단; 
    IF DAN BETWEEN 2 AND 9 THEN
        WHILE N<=9 LOOP
            DBMS_OUTPUT.PUT_LINE(DAN||'*'||N||'='||DAN*N);
            N:= N+1;
        END LOOP;
    END IF;    
END;
/

-- 대입할때 '= ' ':= &' 두가지를 사용했다.

-- 기존의 데이터 접근할때
-- 정적인 SQL에서 벗어나서 동적인 SQL을 구현

--기존 SQL(정적)
SELECT * FROM EMPLOYEE
WHERE EMP_NAME='유재식';

-- 동적 SQL
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_NAME='&사원명';
    
    DBMS_OUTPUT.PUT_LINE('사원번호 : '|| E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('사원명: '||E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('사원급여: '||E.SALARY);
END;
/


--RECORD 자료형 변수 생성
-- %ROWTYPE 이 참조할 테이블 컬럼데이터타입을 자동으로 가져온다.
-- RECORD 특정 테이블의 컬럼을 각각 뽑아 별도의
-- 한행 짜리 자료형 선언을 하는것

/*
    사용법
    TYPE 레코드타입명 IS RECORD( 변수명 변수타입,....  );
    
    레코드객체 레코드타입명;
    
    STUDENT STD; 
    STD = NEW STUDENT();
    STD.METHOD();
*/
DECLARE 
    TYPE MY_RECORD_TYPE IS RECORD(
        MYID EMPLOYEE.EMP_ID%TYPE,
        MYNAME EMPLOYEE.EMP_NAME%TYPE
    );
    
    MYRECORD MY_RECORD_TYPE;

BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO MYRECORD
    FROM EMPLOYEE
    WHERE EMP_NAME = '선동일';
    
    DBMS_OUTPUT.PUT_LINE('사원번호 : '||MYRECORD.MYID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || MYRECORD.MYNAME);
END;
/

-- 사번, 사원명, 직급명을 담을수 있는 참조변수를 통해서
-- 송종기사원의 사번, 사원명, 직급명을 출력하세요.
DECLARE 
    --레코드선언
    type my_r_type is record (
        EID EMPLOYEE.EMP_ID%TYPE,
        ENAME EMPLOYEE.EMP_NAME%TYPE,
        EJOBNAME JOB.JOB_NAME%TYPE
    );

    --변수에 자료형으로 레코드를 지정
    V_EMP MY_R_TYPE;
BEGIN
    --SELECT
    SELECT EMP_ID, EMP_NAME, JOB_NAME
    INTO V_EMP
    FROM EMPLOYEE E
    LEFT JOIN JOB J USING(JOB_CODE)
    WHERE E.EMP_NAME = '송종기';  
    --출력
    DBMS_OUTPUT.PUT_LINE('사번 :'||V_EMP.EID);
    DBMS_OUTPUT.PUT_LINE('사원명 :'||V_EMP.ENAME);
    DBMS_OUTPUT.PUT_LINE('직급명 :'||V_EMP.EJOBNAME);
END;
/

-- 예외처리
/*
    사용형식
    EXCEPTION 
        WHEN 예외명 THEN 처리문장1
        WHEN 예외명 THEN 처리문장2
        WHEN 예외1 OR 예외2 THEN 처리문장3
        WHEN OTHERS THEN 처리문장4
*/
BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID='201'
    WHERE EMP_ID='200';
END;
/

/*
    오라클에서 제공하는 예외 별칭들...몇가지만..
    NO_DATA_FOUND : SELECT 한 결과가 하나도 없는 경우
    CASE_NOT_FOUND : CASE 구문중에 일치하는 결과가 하나도 없고
                   ELSE로 그 이외에 내용에대한 처리를 하지 않은경우
    LOGIN_DENIED : 잘못된 아이디나 비밀번호를 입력하였을 경우
    DUP_VAL_ON_INDEX : UNIQUE 제약 조건을 위배했을 경우
    INVALID_NUMBER : 문자데이터를 숫자로 변경할때 변경할수 없는
                    문자인 경우.
*/

BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID='201'
    WHERE EMP_ID='200';

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('이미 존재하는 사원입니다!!!');   
END;
/

-- 사용자정의 예외처리
-- 프로그래머가 정의
-- RAISE_APPLICATION_ERROR() 사용하여
-- 오류코드 -20000 ~ -20999의 범위 내에서  만들거나
-- RAISE(자바에서 THROW) 사용해서 예외를 발생시킬수가 있다.

/*
    사용방법
    RAISE_APPLICATION_ERROR(에러코드, 메세지);
    RAISE 예외;
*/
CREATE TABLE TEST_MEMBER(
    MID VARCHAR2(20) PRIMARY KEY,
    PWD VARCHAR2(30),
    NAME VARCHAR2(15)
);
SELECT * FROM TEST_MEMBER;

INSERT INTO TEST_MEMBER 
VALUES('PLSQLuser02', '111', '홍길동아니다');

DECLARE 
    V_PWD VARCHAR2(30);
    TOOLONG_NAME EXCEPTION;
    TOOSHORT_PWD EXCEPTION;
    PRAGMA EXCEPTION_INIT(TOOLONG_NAME, -12899);
    PRAGMA EXCEPTION_INIT(TOOSHORT_PWD, -20001);
    --PRAGMA EXCEPTION_INIT(예외명, 예외번호);
    --예외번호를 명시해서 컴파일러에 이 예외를 
    --사용한다는 것을 알리는 역할
BEGIN
    V_PWD := '&비밀번호';
    IF LENGTH(V_PWD) <8 THEN
        RAISE TOOSHORT_PWD;
    END IF;
    
    INSERT INTO TEST_MEMBER
    VALUES ('USER02',V_PWD,'고길동');


    WHEN TOOSHOEXCEPTIONRT_PWD THEN 
        DBMS_OUTPUT.PUT_LINE('비번짧다!!!!');
END;
/

SELECT * FROM TEST_MEMBER;

--- PL/SQL 객체들 ---
--프로시저 : PL/SQL을 미리 저장해놓았다가
--      프로시저명으로 호출하여 함수처럼 동작시키는 객체

/*[사용형식]
    CREATE [OR REPLACE] PROCEDURE 프로시저명( 
        매개변수 1 [IN/OUT/IN OUT] 자료형,
        매개변수 2
        ...
    )
        IN : 프로시저에서 사용할 변수값을 외부에서 넣겠다.
        OUT : 프로시저를 실행한 결과를 외부로 추출할때(RETURN)
        INOUT: IN과 OUT 두가지 기능 둘다 가능
            (단, IN과 OUT 둘가지중 하나만 사용 가능 - 권장X)
    
    IS
        DECLARE(선언부)
        BEGIN
            실행할 부분
        END;
        /
*/

--[호출방식]
--EXECUTE 프로시저명(전달값1, 전달값2, ...)
--EXEC         "           "

--[삭제]
--DROP PROCEDURE 프로시저명;

--[프로시저를 조회]
-- 데이터사전: USER_SOURCE;

--문제.직원정보를 모두 삭제하는 프로시져 구현하기
--테이블 생성 및 EMPLOYEE 복사
CREATE TABLE EMP_TMP
AS SELECT * FROM EMPLOYEE;

--확인
SELECT * FROM EMP_TMP;
SELECT COUNT(*) FROM EMP_TMP;

--프로시저 생성
CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
    BEGIN
        DELETE FROM EMP_TMP;
        COMMIT;
    END;
    /

-- 프로시저는 바로 실행X
-- 선언후에 별도로 실행까지 해야한다.
SELECT COUNT(*) FROM EMP_TMP;

EXEC DEL_ALL_EMP;
DROP TABLE EMP_TMP;

--------------------
-- 매개변수를 갖는 프로시져

-- [IN]
CREATE TABLE EMP_TMP_01
AS SELECT * FROM EMPLOYEE;

--(특정 이름을 가진 사원 삭제)
SELECT * FROM EMP_TMP_01 
    WHERE EMP_NAME LIKE '이%';
    
-- 프로시저 생성(매개변수)
CREATE OR REPLACE PROCEDURE DEL_EMP_NAME
(V_NAME IN EMP_TMP_01.EMP_NAME%TYPE)
IS
BEGIN
    DELETE FROM EMP_TMP_01
    WHERE EMP_NAME LIKE V_NAME;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME||'직원정보 삭제!!');
    COMMIT;
END;
/

EXEC DEL_EMP_NAME('이오리');

SELECT * FROM EMP_TMP_01
WHERE EMP_NAME LIKE '이%';


EXEC DEL_EMP_NAME('이%');

--[OUT]--
-- 내부의 값을외부로 전달하는 방식
-- 값을 받을 수 있게 변수 생성

-- 변수선언
-- VARIABLE 변수명 자료형(바이트);

--실행
--EXEC 프로시저명(전달값, :전달받을변수명);

/*
METHOD1(30);
INT NO = METHOD2();
INT NO = METHOD3(30);
*/
--직원정보를 조회하여 변수에 직원 정보 추가후 
--밖으로 OUT 해보자

EXEC EMP_INFO(201,:VAR_ENAME, :VAR_PHONE, :VAR_EMAIL);
CREATE OR REPLACE PROCEDURE
EMP_INFO( VEMP_ID IN EMPLOYEE.EMP_ID%TYPE,
          VEMP_NAME OUT EMPLOYEE.EMP_NAME%TYPE,
          VPHONE OUT EMPLOYEE.PHONE%TYPE,
          VEMAIL OUT EMPLOYEE.EMAIL%TYPE )
IS
BEGIN
    SELECT EMP_NAME, PHONE, EMAIL
    INTO VEMP_NAME, VPHONE, VEMAIL
    FROM EMPLOYEE
    WHERE EMP_ID = VEMP_ID;
END;
/

--변수 선언 -> 프로시저를 통해 OUT되는 데이터를 담는다.
VARIABLE VAR_ENAME VARCHAR2(20);
VARIABLE VAR_PHONE VARCHAR2(20);
VARIABLE VAR_EMAIL VARCHAR2(20);

--변수 확인(출력)
PRINT VAR_ENAME;

EXEC EMP_INFO(201,:VAR_ENAME, :VAR_PHONE, :VAR_EMAIL);

PRINT VAR_PHONE;
PRINT VAR_EMAIL;

-- 실행하고 프로시져를 통해 입력받은 변수값을 자동으로 출력해준다.
SET AUTOPRINT ON;

SELECT * FROM USER_SOURCE;

--문제
-- 부서코드를 입력받아 해당 부서의 정보를 삭제한 뒤
-- 삭제된 부서의 이름을 출력하는 프로시져를 만드시오.
-- 단, 만약 조회한 부서가 없을 경우
-- NO_DATA_FOUND를 활용하여
-- '해당 부서가 존재하지 않습니다.'라는 문장을 출력하시오.

CREATE TABLE DEPT_01
AS SELECT * FROM DEPARTMENT;

CREATE OR REPLACE PROCEDURE 
    DEL_DEPT( V_DEPT_ID IN DEPT_01.DEPT_ID%TYPE,
              V_DEPT_TITLE OUT DEPT_01.DEPT_TITLE%TYPE)
IS
BEGIN
    SELECT DEPT_TITLE
    INTO V_DEPT_TITLE
    FROM DEPT_01
    WHERE DEPT_ID = V_DEPT_ID;
    
    DELETE FROM DEPT_01
    WHERE DEPT_ID = V_DEPT_ID;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE(V_DEPT_TITLE||'부서가 삭제 되었습니다.');
    
EXCEPTION
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('해당 부서는 존재하지 않는다!');
END;
/
VARIABLE DEPT_TITLE VARCHAR2(35);

EXEC DEL_DEPT('&부서코드', :DEPT_TITLE);
EXEC DEL_DEPT('D0', :DEPT_TITLE);

----함수
--프로시져와 비슷한 기능을 수행함, 차이점은 return값을 가지고 있음.
create or replace function
bonus_cal(v_empid employee.emp_id%type)
return number
is
    v_sal employee.salary%type;
    v_bonus employee.bonus%type;
    v_cal_sal number;
begin
    select salary, bonus
    into v_sal, v_bonus
    from employee
    where emp_id=v_empid;
    
    v_cal_sal := (v_sal+(v_sal*v_bonus))*12;
    return v_cal_sal;
end;
/

select bonus_cal('&emp_id') from dual;
variable var_re number;
exec :var_re := bonus_cal('&emp_id');
print var_re;

--사원번호를 입력받아 성별을 리턴하는 함수를 만들어보자
-- f_gender()
--select f_gender('&emp_id') from dual;
--지존준영풀이~
create or replace function
f_gender(v_empid employee.emp_id%type)
return varchar2
is
    v_gender varchar2(10);
    v_temp employee.emp_no%type;
begin
    select emp_no
    into v_temp
    from employee
    where emp_id=v_empid;
    if substr(v_temp,8,1)=1 then 
        v_gender := '남';
    else
        v_gender := '여';
    end if;
    return v_gender;
end;
/
select emp_name, emp_no,f_gender('&emp_id') from employee;
--별리씨! 풀이
--create or replace function
--f_gender(v_empid employee.emp_id%type)
--return varchar2
--is
--    v_gender varchar2(10);
--    v_temp employee.emp_no%type;
--begin
--    select substr(emp_no,8,1)
--    into v_temp
--    from emplyee where emp_id=v_empid;
--    
--    v_gender := case

--풀어보자
create or replace function
f_gender(v_empid employee.emp_id%type)
return varchar2
is 
    v_gender varchar2(10);
begin
    select decode(substr(emp_no,8,1),'1','남','2','여')
    into v_gender
    from employee
    where emp_id=v_empid;
    
    return v_gender;
end;
/
select f_gender('&emp_id') from dual;

--쿼리문 실행간 에러발생내용모아놓는 테이블
select * from all_errors;
--cursor: select 결과(resultSet)가 다중행일때 한개행씩 접근하여 
--        데이터를 처리하는 기능
--        cursor를 resultSet을 보관하고 fetch로 다음행으로 연결하는것
--cursor사용법
--cursor을 변수로 선언하고  선언한 변수 cursor을 open으로 연다.
--반복문 안에서 fetch를 통해 한행씩접근함
--종료가 되면 close명령을 cursor를 닫아줌
--cursor에 데이터 존재여부를 확인하는 방법
-- %NOTFOUND : OPEN 후 FETCH전에 NULL, 
--             FETCH된 행이 존재하면 FALSE, 아니면 TRUE
-- %FOUND : FETCH된 행이 존재하면 TRUE, 아니면 FALSE
-- %ISOPEN : 최근 실행된 CURSOR가 OPEN된 상태이면 TRUE
-- %ROWCOUNT : CURSOR의 ROW의 수

CREATE OR REPLACE PROCEDURE CURSORTEST
IS
    V_DEPT DEPARTMENT%ROWTYPE;
    CURSOR C1
    IS
    SELECT * FROM DEPARTMENT;
BEGIN
 OPEN C1;
 LOOP
    FETCH C1 INTO V_DEPT.DEPT_ID,
                  V_DEPT.DEPT_TITLE,
                  V_DEPT.LOCATION_ID;
    EXIT WHEN C1%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('부서코드 : '||V_DEPT.DEPT_ID
                        ||' 부서명 : '||V_DEPT.DEPT_TITLE
                        ||' 지역코드 : '||V_DEPT.LOCATION_ID);
 end loop;
 close c1;
end;
/
set serveroutput on;
exec CURSORTEST;
select * from department;

declare
    v_user employee%rowtype;
    cursor c1
    is
    select * from employee;
begin
    open c1;
    loop
        fetch c1 into v_user;
        exit when c1%notfound;
        dbms_output.put_line('이름 : '||v_user.emp_name);
    end loop;
    close c1;
end;
/
--for in을 이용하여 처리하는 방법
-- 커서를 open/close를 안해도 됩니다.
declare
    v_dept department%rowtype;
    cursor c2
    is select * from department;
begin
    for v_dept in c2 loop
    DBMS_output.put_line('부서코드 : '||v_dept.dept_id);
    end loop;
end;
/
--트리거 : DML(insert, update, delete)실행되기 전, 후에 발생시킨 실행할
-- 구문을 저장해 놓고 실행시키는것.
-- create 명령어로 생성을 함
--aftfer/before : 실행 시점
--실행할 명령어를 지정
--행단위로 실행할지 여부
-- create trigger 트리거명
-- after/before 실행명령어 on 테이블
-- for each row
-- pl/sql구문실행(begin~end)
-- 명령어
--     new.컬럼 : 지금 수정,삽입된 자료(insert, update)
--     old.컬럼 : 수정, 삭제 이전에 있던 값(update, delete)

--트리거를 생성해 보자
create or replace trigger tg_empnew
after insert on employee
for each row
begin
    DBMS_output.put_line('신입사원등록');
end;
/
select * from user_triggers;
insert into employee values(996,'박수영','961124-2123456',
'red@sm.co.kr','01032456975','D1','J2','S2',1500000,0.3,200,
sysdate,default,default);
commit;
insert into employee values(995,'박수영1','961124-2123454',
'red@sm.co.kr','01032456975','D1','J2','S2',1500000,0.3,200,
sysdate,default,default);
insert into employee values(994,'박수영2','961124-2123453',
'red@sm.co.kr','01032456975','D1','J2','S2',1500000,0.3,200,
sysdate,default,default);
insert into employee values(993,'박수영3','961124-2123452',
'red@sm.co.kr','01032456975','D1','J2','S2',1500000,0.3,200,
sysdate,default,default);
insert into employee values(992,'박수영4','961124-2123451',
'red@sm.co.kr','01032456975','D1','J2','S2',1500000,0.3,200,
sysdate,default,default);

commit;

create or replace trigger tg_sal
after update on employee
for each row
begin
    DBMS_output.put_line('변경전 : '||:old.salary);
    DBMS_output.put_line('변경후 : '||:new.salary);
end;
/
select * from user_triggers;
update employee set salary=salary*3
where emp_name='유병승';
select  emp_name, salary from employee where emp_name='유병승';
commit;

--트리거 적용하기
--제품테이블
create table product(
    pcode number primary key,
    pname varchar2(30),
    brand varchar2(30),
    price number,
    stock number default 0
);
--입고출고 관리 테이블
create table product_IO(
    icode number primary key,
    pcode number,
    pdate date,
    amount number,
    status varchar2(10) check(status in('입고','출고')),
    constraint fk_proc_io foreign key(pcode) 
    references product(pcode)
);
select * from product;
select * from product_io;

create sequence seq_proc;
create sequence seq_proc_io;

insert into product 
values(seq_proc.nextval,'아이패드','액플하',1500000,default);
insert into product 
values(seq_proc.nextval,'아이폰','액플',1000000,default);
insert into product 
values(seq_proc.nextval,'갤럭쉬S10','썀쏭',180000,default);
select seq_proc.currval from dual;
select * from user_sequences;
select * from product;
--trigger생성 :  io테이블 값이 입력되면 입력되는것을 기준으로
--product 의 수량이 수정되는 트리거
drop trigger tg_product;
create trigger tg_product
after insert on product_io
for each row
begin
    if :new.status='입고'
    then
        update product
        set stock=stock + :new.amount
        where pcode = :new.pcode;
    elsif :new.status='출고'
    then
        update product
        set stock=stock - :new.amount
        where pcode = :new.pcode;
    end if;
end;
/
select * from product;
insert into product_io 
values(seq_proc_io.nextval,1,sysdate,10,'입고');
insert into product_io 
values(seq_proc_io.nextval,2,sysdate,50,'입고');
insert into product_io 
values(seq_proc_io.nextval,3,sysdate,100,'입고');

--employee테이블에서 사원을 삭제하면 삭제테이블(del_emp)로 이동
create table del_emp
as select * from employee where 1=0;
select * from del_emp;
drop trigger tg_delemp;
create trigger tg_delemp
after delete on employee
for each row
when (old.emp_name <> '유병승')
begin
    insert into del_emp
    values(:old.emp_id, :old.emp_name,:old.emp_no,:old.email,
    :old.phone,:old.dept_code,:old.job_code,:old.sal_level,
    :old.salary,:old.bonus,:old.manager_id,:old.hire_date,
    :old.ent_date,:old.ent_yn);
end;
/
select * from employee;
delete from employee where emp_name='박수영3';
delete from employee where emp_name='박수영2';

































