--16
select G.class_no, C.class_name, ROUND(AVG(point),8)
from tb_grade G
    JOIN tb_class C ON G.class_no = C.class_no
    JOIN tb_department D ON C.department_no = D.department_no
where D.department_name='환경조경학과'
GROUP BY G.class_no, C.class_name
order by G.class_no;

--17
