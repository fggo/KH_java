select * from tab where tname like '%TB%';

select * from TB_STUDENT;
select * from TB_PROFESSOR;
select * from TB_GRADE;
select * from TB_DEPARTMENT;
select * from TB_CLASS_PROFESSOR;
select * from TB_CLASS;
select * from TBL_FILES;

select empno, hiredate, ename, sal,deptno from emp
order by deptno asc, hiredate desc;

--1
select student_no 학번, student_name 이름, entrance_date 입학년도
from tb_student where department_no = '002';

--2
select professor_name, professor_ssn from tb_professor
where length(professor_name) !=3;

--3
select professor_name 교수이름
from tb_professor
where substr(professor_ssn, 8,1)=1
order by TO_NUMBER(TO_CHAR(sysdate, 'yyyy'))
         - TO_NUMBER('19' || substr(professor_ssn,1,2))
         + CASE WHEN TO_CHAR(sysdate, 'mmdd') > substr(professor_ssn,3,4) THEN 0
                ELSE -1 END,
         professor_name;

--select professor_name, professor_ssn, 
--    TO_NUMBER(TO_CHAR(sysdate, 'yyyymmdd')) 현재,
--    TO_NUMBER('19' || substr(professor_ssn,1,6)) 생일,
--    TO_NUMBER(TO_CHAR(sysdate, 'yyyy'))
--        - TO_NUMBER('19' || substr(professor_ssn,1,2))
--        + CASE WHEN TO_CHAR(sysdate, 'mmdd') > substr(professor_ssn,3,4) THEN 0
--                ELSE -1 END AS 만나이
--from tb_professor
--order by TO_NUMBER(TO_CHAR(sysdate, 'yyyy'))
--         - TO_NUMBER('19' || substr(professor_ssn,1,2))
--         + CASE WHEN TO_CHAR(sysdate, 'mmdd') > substr(professor_ssn,3,4) THEN 0
--                ELSE -1 END,
--         professor_name;

--4
select substr(professor_name,2) AS 이름 from tb_professor;

--5
select student_no, student_name,
    student_ssn, entrance_date,
    TO_NUMBER(EXTRACT(year from entrance_date)) AS 입학일,
    TO_NUMBER(CASE WHEN substr(student_ssn, 8,1) in (1,2) THEN 19
                ELSE 20 END ||substr(student_ssn,1,2)) AS 생일,
    TO_NUMBER(EXTRACT(year from entrance_date))
    - TO_NUMBER(CASE WHEN substr(student_ssn, 8,1) in (1,2) THEN 19
                ELSE 20 END || substr(student_ssn,1,2))+1 AS 입학식떄나이
from tb_student
where 
    TO_NUMBER(EXTRACT(year from entrance_date))
    - TO_NUMBER(CASE WHEN substr(student_ssn, 8,1) in (1,2) THEN 19
                ELSE 20 END || substr(student_ssn,1,2))+1 >19;

--6 2020.12.25 크리스마스요일은?
select TO_CHAR(TO_DATE('20201225'), 'day') AS "2020년 크리스마스 요일" from dual;

--7
--TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD') 은 각각 몇 년 몇
--월 몇 일을 의미핛까? 또 TO_DATE('99/10/11','RR/MM/DD'),
--TO_DATE('49/10/11','RR/MM/DD') 은 각각 몇 년 몇 월 몇 일을 의미핛까
--RR 변환 공식
--현재연도   입력연도  계산연도
-------------------------------
--  00~49      00~49   현재세기
--  00~49      50~99   전세기
--  50~99      00~49   다음세기
--  50~99      50~99   현재세기
select EXTRACT(year from TO_DATE('99/10/11','YY/MM/DD')), 
    EXTRACT(year from TO_DATE('49/10/11','YY/MM/DD')) from dual;

select EXTRACT(year from TO_DATE('99/10/11','RR/MM/DD')),
    EXTRACT(year from TO_DATE('49/10/11','RR/MM/DD')) from dual;

--8
select student_no, student_name from tb_student
where substr(student_no,1,1) != 'A'
order by student_no;

select student_no, student_name from tb_student
where EXTRACT(year from entrance_date) <2000
order by student_no;

--9
select ROUND(AVG(g.point),1) AS 평점
from tb_student s, tb_grade g
where s.student_no = g.student_no
    and s.student_no='A517178'
group by s.student_name;

--10
select department_no AS 학과번호, count(*) AS "학생수(명)"
from tb_student
group by department_no
order by department_no;

--11
select count(*) from tb_student where coach_professor_no IS NULL;

--12
select substr(g.term_no, 1,4) AS 년도,
    ROUND(AVG(g.point),1) AS "년도 별 평점"
from tb_student s, tb_grade g
where s.student_no = g.student_no
    and s.student_no = 'A112113'
GROUP BY substr(g.term_no, 1,4)
order by substr(g.term_no, 1,4);

--13
select department_no AS 학과코드명, count(*) AS 휴학생수
    from tb_student
where absence_YN ='Y'
group by department_no
UNION
select s.department_no 학과코드명, 0 휴학생수
from tb_student S
group by s.department_no
HAVING count(*) = (
    WITH A AS
        (select department_no, count(*) COUNT 
            from tb_student where absence_YN='N' group by department_no)
    select A.COUNT from A where A.department_no = s.department_no);

--14
select student_name AS 동일이름, count(*) AS "동명인 수"
from tb_student
GROUP BY student_name
HAVING count(*) > 1
order by student_name;

--15
select substr(g.term_no,1,4) AS 년도,
    substr(g.term_no,5,2) AS 학기,
    ROUND(AVG(g.point),1) AS 평점
from tb_student s, tb_grade g
where s.student_no = g.student_no
    and s.student_no = 'A112113'
GROUP BY ROLLUP(substr(g.term_no,1,4), substr(g.term_no,5,2))
order by substr(g.term_no,1,4), substr(g.term_no,5,2);

