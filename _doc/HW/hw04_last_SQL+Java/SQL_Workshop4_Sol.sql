select * from TB_CLASS;
select * from TB_CLASS_PROFESSOR;
select * from TB_DEPARTMENT;
select * from TB_GRADE;
select * from TB_PROFESSOR;
select * from TB_STUDENT;

--16
select G.class_no, C.class_name, ROUND(AVG(point),8)
from tb_grade G
    JOIN tb_class C ON G.class_no = C.class_no
    JOIN tb_department D ON C.department_no = D.department_no
where D.department_name='환경조경학과'
GROUP BY G.class_no, C.class_name
order by G.class_no;

--17
select S1.student_name, S1.student_address
from tb_student S1 JOIN tb_student S2 USING(department_no)
where S2.student_name='최경희';

--18
select student_no, student_name
from
   (select ROWNUM, student_no, student_name, avg(point)
    from tb_student
        JOIN tb_department USING (department_no)
        JOIN tb_grade USING (student_no)
    where department_name='국어국문학과'
    GROUP BY ROWNUM, student_no, student_name
    order by avg(point) desc)
where ROWNUM =1;

select student_no, student_name from(
    select DENSE_RANK() OVER (order by avg(point) desc) AS 랭킹,
           student_no, student_name, avg(point)
    from tb_grade
        JOIN tb_student USING (student_no)
        JOIN tb_department USING (department_no)
    WHERE department_name = '국어국문학과'
    GROUP BY student_name, student_no)
where 랭킹=1;

--19
select D1.department_name, ROUND(avg(point),1)
from tb_department D1
    JOIN tb_class C ON C.department_no = D1.department_no
    JOIN tb_grade USING (class_no)
    JOIN tb_department D2 USING (category)
where D2.department_name='환경조경학과'
GROUP BY D1.department_name
order by D1.department_name;

--4
select capacity from tb_department order by capacity desc;

UPDATE tb_department
SET capacity = ROUND(capacity * 1.1);

select capacity from tb_department order by capacity desc;

--5
UPDATE tb_student
SET student_address = '서울시 종로구 숭인동 181-21'
where student_no = 'A413042';

--6
UPDATE tb_student SET student_no = SUBSTR(student_no,1,6);

--7
select G.point
from tb_student S
    JOIN tb_grade G ON S.student_no = G.student_no
    JOIN tb_class C ON C.class_no=  G.class_no
where S.student_name='김명훈'
    and G.term_no ='200501'
    and C.class_name='피부생리학';

UPDATE tb_grade G
SET point = 3.5
where EXISTS (select student_no from tb_student 
                JOIN tb_class C USING (department_no)
                where student_no = G.student_no
                    and C.class_no = G.class_no
                    and C.class_name='피부생리학'
                    and student_name='김명훈')
    and G.term_no='200501';

--8 성적 테이블(TB_GRADE) 에서 휴학생들의 성적항목을 제거하시오.
DELETE from tb_grade G
where EXISTS (select student_no 
    from tb_student S
    where absence_yn ='Y'
        and G.student_no = S.student_no);

select student_no, student_name, absence_yn, G.point
from tb_student S
    JOIN tb_grade G USING (student_no)
where absence_yn ='Y';

commit;
rollback;
