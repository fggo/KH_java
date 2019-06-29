sqlplus system/oracle

select username, account_status from dba_users
where username in ('HR','KH','SCOTT','SYSTEM','TEST','TEST11');

alter user HR account unlock;
alter user HR identified by hr;

conn HR/hr;

set linesize 300;
set pagesize 10;

clear screen;

conn system/oracle;
create user kh identified by kh;
create user scott identified by tiger;
create user test identified by test;
conn test/test;	--ERROR : lacks create session privilege
grant connect to TEST;
conn test/test; --SUCCESS

save test
	--test.sql

@test

conn hr/hr
@test11

save test
save test11

edit test
edit ../test
--상대 경로

host

exit

grant resource to kh;
grant resource to hr;
grant resource to scott;

grant connect to kh;
grant connect to hr;
grant connect to scott;
-- resource: role
--resource 권한: 테이블 생성 수정 삭제 할 수 있는
--권한이 모두 있는것.
