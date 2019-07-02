SELECT * FROM TB_BOOK;
SELECT * FROM TB_WRITER;
SELECT * FROM TB_PUBLISHER;
SELECT * FROM TB_BOOK_AUTHOR;
SELECT * FROM TB_BOOK_TRANSLATOR;

--1
SELECT count(*) FROM TB_BOOK;
SELECT count(*) FROM TB_WRITER;
SELECT count(*) FROM TB_PUBLISHER;
SELECT count(*) FROM TB_BOOK_AUTHOR;

--2
select C.TABLE_NAME, T.COLUMN_NAME, DATA_TYPE, DATA_DEFAULT, NULLABLE, 
    C.CONSTRAINT_NAME, C.CONSTRAINT_TYPE, C.R_CONSTRAINT_NAME
from user_constraints C
    JOIN user_cons_columns M ON C.table_name=M.table_name
    JOIN user_tab_columns T ON M.table_name=T.table_name
where C.table_name in( 
    'TB_BOOK', 'TB_WRITER', 'TB_PUBLISHER', 'TB_BOOK_AUTHOR')
order by C.table_name;

select * from user_constraints where table_name IN ('TB_BOOK', 'TB_WRITER', 'TB_PUBLISHER', 'TB_BOOK_AUTHOR');
select * from user_cons_columns where table_name IN ('TB_BOOK', 'TB_WRITER', 'TB_PUBLISHER', 'TB_BOOK_AUTHOR');
select * from user_tab_columns where table_name IN ('TB_BOOK', 'TB_WRITER', 'TB_PUBLISHER', 'TB_BOOK_AUTHOR');
select * from all_tab_columns;

--3
select book_no, book_nm from tb_book where length(book_nm) >=25;

--4
select writer_nm, office_telno, home_telno, mobile_no
from (
    select ROWNUM, writer_nm, office_telno, home_telno, mobile_no
    from tb_writer
    where mobile_no like '019%'
        and substr(writer_nm,1,1)='김'
    order by writer_nm)
where ROWNUM=1;

--5
select count(distinct writer_no) AS "작가(명)"
from tb_book_author
where compose_type='옮김';


--6
select compose_type, count(*) from tb_book_author
where compose_type IS NOT NULL
GROUP BY compose_type
HAVING count(*) >= 300;

--7 가장 최근에 발간된 최신작 이름과 발행일자, 출판사 이름을 표시하는 SQL 구 문을 작성하시오.
SELECT book_nm, issue_date, publisher_nm
FROM ( 
    SELECT book_nm, issue_date, publisher_nm
        FROM tb_book
        order by issue_date DESC)
where ROWNUM =1;

--8 가장 많은 책을 쓴 작가 3 명의 이름과 수 량을 표시하되, 많이 쓴 순서대로 표시하는 SQL 구 문을 작성하시오.
--  단, 동명이인( 同名異人) 작가는 없다고 가정한다. ( 결과 헤더는 “ 작가 이름”, “ 권 수” 로 표시 되도록 할 것)
SELECT writer_nm, count
from ( SELECT writer_nm, count(writer_nm) AS COUNT
    FROM tb_book_author
        JOIN tb_writer USING (writer_no)
    GROUP BY writer_nm
    order by count(writer_nm) DESC)
WHERE ROWNUM <=3;

--9
--작가 정보 테이블의 모든 등록일자 항목이 누락되어 있는 걸 발견하였다.
--  누락된 등록일자 값을 각 작가의 최초 출판도서의 발행일과 동일한 날짜’ 로 
--변경시키는 SQL 구 문을 작성하시오. (COMMIT 처리할 것)
SELECT writer_no, MIN(issue_date)
FROM tb_book
    JOIN tb_book_author USING (book_no)
GROUP BY writer_no
order by TO_NUMBER(writer_no);

SELECT writer_no, regist_date
FROM tb_writer order by TO_NUMBER(writer_no);

UPDATE tb_writer
SET (writer_no, regist_date)  =
        ( SELECT writer_no, MIN(issue_date) AS ISSUE
            FROM tb_book
                JOIN tb_book_author USING (book_no)
            WHERE tb_book_author.writer_no = tb_writer.writer_no
            GROUP BY writer_no)
WHERE EXISTS (SELECT writer_no, MIN(issue_date) AS ISSUE
        FROM tb_book
            JOIN tb_book_author USING (book_no)
        WHERE tb_book_author.writer_no = tb_writer.writer_no
        GROUP BY writer_no);

--10
-- 현재 도서저자 정보 테이블은 저서와 번역서를 구분 없이 관리 하고 있다. 앞으로는 번역서는 따로 관리하려
--고 한다. 제시된 내용에 맞게 “TB_BOOK_ TRANSLATOR” 테이블을 생성하는 SQL 구문을 작성하시오.
--(Primary Key 제약 조건 이름은 “PK_BOOK_TRANSLATOR” 로 하고, Reference 제약 조건 이름은
--“FK_BOOK_TRANSLATOR_01”, “FK_BOOK_TRANSLATOR_02” 로 할 것)
CREATE TABLE tb_book_translator(
    book_no VARCHAR2(10),
    writer_no VARCHAR2(10),
    trans_lang VARCHAR2(60),
    CONSTRAINT pk_book_translator PRIMARY KEY(book_no, writer_no),
    CONSTRAINT fk_book_translator_01 FOREIGN KEY(book_no)
                    REFERENCES tb_book(book_no),
    CONSTRAINT fk_book_translator_02 FOREIGN KEY(writer_no)
                    REFERENCES tb_writer(writer_no)
);

--11
-- 도서 저작 형태(compose_type) 가 ' 옮김', ' 역주', ' 편역', ' 공역' 에 해당하는
-- 데이터는 도서 저자 정보 테이블에서 도서 역자 정보 테이블(TB_BOOK_TRANSLATOR)로
--옮기 는 SQL 구문을 작성하시오. 단, “TRANS_LANG” 컬럼은 NULL 상태로 두도록 
--한다. ( 이동된 데이터는 더이상 TB_BOOK_AUTHOR 테이블에 남아 있지 않도록 삭제할 것)
CREATE TRIGGER tg_del_book_author
AFTER DELETE ON TB_BOOK_AUTHOR
FOR EACH ROW
BEGIN
    INSERT INTO tb_book_translator VALUES(
        :OLD.book_no, :OLD.writer_no, null);
END;
/

--169 rows deleted
DELETE FROM tb_book_author
where compose_type in ('옮김','역주','편역','공역');

SELECT count(*) from tb_book_author
where compose_type in ('옮김','역주','편역','공역');

--169 rows inserted
select * from tb_book_translator;

ROLLBACK;
COMMIT;


--12
-- 2007 년도에 출판된 번역서 이름 과 번역자( 역자) 를 표시하는 SQL 구 문 작성
SELECT book_nm, writer_nm, issue_date
FROM tb_book_translator
    JOIN tb_book USING (book_no)
    JOIN tb_writer USING (writer_no)
WHERE EXTRACT(year from issue_date)=2007;

--13
-- 12 번 결과를 활용하여 대상 번역서들의 출판일을 변경할 수 없도록 하는
-- 뷰 를 생성하는 SQL 구 문을 작성하시오. ( 뷰 이름은 “VW_BOOK_TRANSLATOR”로 
--하고 도서명, 번 역자, 출판일이 표시되도록 할 것)
CREATE OR REPLACE VIEW vw_book_translator AS (
    SELECT book_nm, writer_nm, issue_date
    FROM tb_book_translator
        JOIN tb_book USING (book_no)
        JOIN tb_writer USING (writer_no)
    WHERE EXTRACT(year from issue_date)=2007
) WITH CHECK OPTION;

SELECT * from vw_book_translator;

UPDATE vw_book_translator
SET issue_date = TO_DATE('99/01/31')
WHERE writer_nm='황석영';

--14 새로운 출판사( 춘 출판사) 와 거래 계약을 맺게 되었다. 
--제시된 다음 정보를 입력하는 SQL 구문을 작성하시오.(COMMIT 처리할 것)
INSERT INTO tb_publisher VALUES('춘 출판사', '02-6710-3737', DEFAULT);

--15 동명이인( 同名異人) 작가의 이름을 찾으려고 한다. 이름과 동명이인 숫자를 
--표시하는 SQL 구 문을 작성하시오.
SELECT writer_nm, count(writer_nm)
FROM tb_writer
GROUP BY writer_nm
HAVING count(writer_nm) =2;

--16 도서의 저자 정보 중 저작 형태(compose_type) 가 누락된 데이터들이 적 지 않게 
--존재한다. 해당 컬럼이NULL 인 경우 ' 지음' 으로 변경하는 SQL 구 문을 
--작성하시오.(COMMIT 처리할 것)
--389 ROWS UPDATED
UPDATE tb_book_author
SET compose_type='지음'
WHERE compose_type IS NULL;

COMMIT;

--17 서울지역 작가 모임을 개최하려고 한다. 사무실이 서울이고, 사무실 전화 번호 
--국번이 3 자리인 작가의 이름과 사무실 전화 번호를 표시하는 SQL 구 문을 작성하시오
SELECT writer_nm, office_telno
FROM tb_writer
WHERE instr(office_telno, '-',1,2) -
      instr(office_telno,'-',1,1) = 4
    AND substr(office_telno,1,2)='02';

--18 2006 년 1 월 기준으로 등록된 지 31 년 이상 된 작가 이름을 이름순으로 표시하는 SQL 구 문을 작성하시오.
SELECT writer_nm
from tb_writer
WHERE regist_date <='750101' -- '75/01/01'
order by writer_nm;

--19. 요즘 들어 다시금 인기를 얻고 있는 ' 황금가지' 출판사를 위한 기획전을 열려고 한다. ' 황금가지'
--출판사에서 발행한 도서 중 재고 수 량이 10 권 미만인 도서명과 가격, 재고상태를 표시하는 SQL 구 문을
--작성하시오. 재고 수 량이 5 권 미만인 도서는 ‘ 추가주문필요’ 로, 나머지는 ‘ 소량보유’ 로 표시 하고,
--재고수량 이 많은 순, 도서명 순으로 표시 되 도록 한다.
SELECT book_nm, price, 
    CASE WHEN stock_qty < 5 THEN '추가주문필요' 
    ELSE '소량보유' END AS stock_quantity
from tb_book
where publisher_nm='황금가지'
    AND stock_qty <10
ORDER BY stock_qty DESC, book_nm;

--20 ' 아타트롤' 도서 작가와 역자를 표시하는 SQL 구 문을 작성하시오. ( 결과 헤더는
--‘ 도서명’,’ 저자’,’ 역자’ 로 표시할 것)
SELECT book_nm AS BOOK_TITLE,
       W.writer_nm AS AUTHOR,
       W2.writer_nm AS TRANSLATOR
FROM tb_book B
    JOIN tb_book_author A ON B.book_no = A.book_no
    JOIN tb_book_translator T ON B.book_no = T.book_no
    JOIN tb_writer W ON W.writer_no = A.writer_no
    JOIN tb_writer W2 ON W2.writer_no = T.writer_no
WHERE book_nm='아타트롤';


--21. 현재 기준으로 최초 발행일로부터 만 30 년이 경과되고, 재고 수 량이 90 권 이상인 도서에 대해 도서명, 재고
--수량, 원래 가격, 20% 인하 가격을 표시 하는 SQL 구 문을 작성하시오. ( 결과 헤더는 “ 도서명”, “ 재고
--수량”, “ 가격(Org)”, “ 가격(New)” 로 표시할 것. 재고 수량이 많은 순, 할인 가격이 높은 순, 도서명
--순으로 표시되도록 할 것)
SELECT book_nm AS "book title",
       stock_qty AS "stock qty",
       TO_CHAR(price, '999,999') AS "PRICE(Org)",
       TO_CHAR(price*(1-.2), '999,999') AS "PRICE(New)"
FROM tb_book
WHERE stock_qty >=90
    AND (sysdate - issue_date)/365 >=30
ORDER BY stock_qty DESC, price DESC, book_nm;
