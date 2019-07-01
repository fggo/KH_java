SELECT * FROM TB_BOOK;
SELECT * FROM TB_WRITER;
SELECT * FROM TB_PUBLISHER;
SELECT * FROM TB_BOOK_AUTHOR;

--1
SELECT count(*) FROM TB_BOOK;
SELECT count(*) FROM TB_WRITER;
SELECT count(*) FROM TB_PUBLISHER;
SELECT count(*) FROM TB_BOOK_AUTHOR;

--2 ??
select TABLE_NAME, COLUMN_NAME, DATA_TYPE, DATA_DEFAULT,
    --AS NULLABLE, 
CONSTRAINT_NAME, CONSTRAINT_TYPE, R_CONSTRAINT_NAME
from user_constraints
where table_name in(
    'TB_BOOK', 'TB_WRITER', 'TB_PUBLISHER', 'TB_BOOK_AUTHOR', 'TEST1');

CREATE TABLE test1(
    a VARCHAR2(20) PRIMARY KEY,
    b VARCHAR2(20) UNIQUE
);

select * from user_constraints;
select * from tab where tname like '%CONSTRAINT%';

--3
select book_no, book_nm from tb_book
where length(book_nm) >=25;

--4
select writer_nm, office_telno, home_telno, mobile_no
from (
    select ROWNUM, writer_nm, office_telno, home_telno, mobile_no
    from tb_writer
    where mobile_no like '019%'
        and substr(writer_nm,1,1)='±è'
    order by writer_nm)
where ROWNUM=1;

--5
select count(*) AS "ÀÛ°¡(¸í)"
from tb_book_author
where compose_type='¿Å±è';


--6
select compose_type, count(*) from tb_book_author
GROUP BY compose_type
HAVING count(*) >= 300;

--7
