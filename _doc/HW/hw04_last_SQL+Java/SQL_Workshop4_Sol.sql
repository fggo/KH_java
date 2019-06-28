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
select student_no, student_name from(
    select DENSE_RANK() OVER (order by avg(point) desc) AS 랭킹,
           S.student_name, S.student_no, ROUND(avg(point),2)
    from tb_grade G
        JOIN tb_student S ON G.student_no=S.student_no
        JOIN tb_department D USING (department_no)
    WHERE D.department_name = '국어국문학과'
    GROUP BY S.student_name, S.student_no)
where 랭킹=1;

--4
select capacity from tb_department order by capacity desc;

UPDATE tb_department
SET capacity = ROUND(capacity * 1.1, 0);

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
SET G.point = 4.5
where EXISTS (
    select G.point
    from tb_student S JOIN tb_class C USING (department_no)
    where G.class_no =  C.class_no
        and S.student_name='김명훈'
        and G.term_no ='200501'
        and C.class_name='피부생리학');

--8 성적 테이블(TB_GRADE) 에서 휴학생들의 성적항목을 제거하시오.
DELETE from tb_grade G
where EXISTS (select student_no 
    from tb_student S
    where absence_yn ='Y'
        and G.student_no = S.student_no);

select student_no, student_name, G.point
from tb_student S
    JOIN tb_grade G USING (student_no)
where absence_yn ='Y';
commit;
rollback;
