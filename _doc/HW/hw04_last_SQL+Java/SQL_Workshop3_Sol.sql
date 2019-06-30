select * from tab where tname like 'TB#_%' escape '#';

select * from TB_CLASS;
select * from TB_CLASS_PROFESSOR;
select * from TB_DEPARTMENT;
select * from TB_GRADE;
select * from TB_PROFESSOR;
select * from TB_STUDENT;

--1
select student_name AS 학생이름, student_address AS 주소지
from tb_student order by student_name;

--2
select student_name, student_ssn from tb_student
where absence_yn='Y'
order by student_ssn desc;

--3
select student_name AS 학생이름, student_no AS 학번, student_address AS "거주지 주소"
from tb_student
where substr(student_no,1,1) = '9'
    and (student_address like '%강원도%' or student_address like '%경기도%')
order by student_name;

--4
select professor_name, professor_ssn from tb_department 
    JOIN tb_professor USING (department_no)
where department_name = '법학과'
order by professor_ssn;

--5
select student_no, TO_CHAR(point,'9.99') from tb_student 
    JOIN tb_grade USING (student_no)
where term_no='200402' and class_no ='C3118100'
order by point desc, student_no;

--6
select student_no, student_name, department_name
from tb_student
    JOIN tb_department USING (department_no)
order by student_name, department_name;

--7
select class_name, department_name
from tb_class JOIN tb_department USING (department_no)
order by department_name;

--8
select class_name, professor_name
from tb_class_professor
    JOIN tb_class USING (class_no)
    JOIN tb_professor USING (professor_no)
order by professor_name;

--9
select class_name, professor_name
from tb_class_professor
    JOIN tb_class C USING (class_no)
    JOIN tb_professor P USING (professor_no)
    JOIN tb_department D ON C.department_no = D.department_no
where category='인문사회'
order by class_name, professor_name;

--10
select student_no AS 학번, student_name AS 학생이름, ROUND(avg(point),1) AS 전체평점
from tb_student
    JOIN tb_grade USING(student_no)
    JOIN tb_department USING(department_no)
where department_name='음악학과'
GROUP BY student_no, student_name
order by 전체평점 desc, 학번;

--11
select department_name AS 학과이름, student_name AS 학생이름, professor_name AS 지도교수이름
from tb_student 
    JOIN tb_department USING (department_no)
    JOIN tb_professor ON coach_professor_no = professor_no
where student_no ='A313047';

--12
select student_name, term_no
from tb_student S
    JOIN tb_grade G USING (student_no)
    JOIN tb_class C ON G.class_no = C.class_no
where term_no like '2007__' and C.class_name='인간관계론'
order by student_name;

--13 예체능 계열 과목 중 과목 담당교수를 핚 명도 배정받지 못핚 과목을 찾아 그 과목
--이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
select C.class_name, D.department_name
from tb_department D
    JOIN tb_class C ON D.department_no = C.department_no
    LEFT JOIN tb_class_professor CP ON C.class_no = CP.class_no
where D.category = '예체능' and CP.professor_no IS NULL;

select class_name, department_name
from tb_class C
    JOIN tb_department USING (department_no)
where category='예체능'
    and NOT EXISTS(select professor_no from tb_class_professor CP
                    where C.class_no = CP.class_no)
order by class_name;