select * from tab where tname like 'TB%';
select * from tbl_files;
select * from tb_class;
select * from tb_class_professor;
select * from tb_department;
select * from tb_grade;
select * from tb_professor;
select * from tb_student;

--1
select department_name AS "학과 명", 
    category AS 계열
from TB_DEPARTMENT;

--2
select department_name ||'의 정원은 ' || capacity ||'명 입니다.'
    AS "학과별 정원"
from tb_department;

--3
select s.student_name
from TB_STUDENT S, TB_DEPARTMENT D
where S.department_no = D.department_no
    and D.department_name='국어국문학과'
    and substr(S.student_ssn, 8,1)= 2
    and S.absence_yn = 'Y';

--4
select student_name
from tb_student
where student_no in ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

--5
select department_name, category
from tb_department
where capacity between 20 and 30;

--6
select professor_name
from tb_professor
where department_no IS NULL;

--7
select student_name, student_no 
from tb_student
where department_no IS NULL;

--8
select class_no from tb_class where preattending_class_no IS NOT NULL;

--9
select distinct category from tb_department;

--10
select student_no, student_name, student_ssn
from tb_student
where absence_YN = 'N'
    and EXTRACT(year from entrance_date)=2002
    and student_address like '%전주%';

