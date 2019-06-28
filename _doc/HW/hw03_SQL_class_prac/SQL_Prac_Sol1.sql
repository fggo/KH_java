--직급이 대리이면서, ASIA지역에 근무하는 직원을 조회
--사번, 이름, 직급명, 부서명, 근무지역명, 급여
select E.emp_id, E.emp_name, J.job_name,
    nvl(D.dept_title, '사원'), L.local_name, E.salary
from employee E 
    LEFT JOIN department D ON (E.dept_code=D.dept_id)
    JOIN location L ON(D.location_id=L.local_code)
    JOIN job J ON (E.job_code = J.job_code)
where J.job_name='대리'
    and L.local_name = 'ASIA1';

--주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원
--사원명, 주민번호, 부서명, 직급명
select E.emp_name, E.emp_id, D.dept_title, J.job_name
from employee E 
    LEFT JOIN department D ON E.dept_code = D.dept_id
    JOIN job J ON E.job_code = J.job_code
where substr(E.emp_no,1,1)=7 and substr(E.emp_no,8,1)=2
    and substr(E.emp_name,1,1) = '전';

--이름에 '형'자가 들어가는 직원
--사번, 사원명, 부서명
select E.emp_id, E.emp_name, D.dept_title
from employee E
    JOIN department D ON E.dept_code = D.dept_id
where E.emp_name like '%형%';

--해외영업부에 근무하는 직원
--사원명, 직급명, 부서코드, 부서명
select E.emp_name, J.job_name, E.dept_code, D.dept_title
from employee E
    JOIN job J ON E.job_code = J.job_code
    JOIN department D ON E.dept_code = D.dept_id
where D.dept_title like '%해외영업%';
    
--보너스를 받는 직원
--사원명, 보너스, 부서명, 근무지역명
select E.emp_name, E.bonus, D.dept_title, L.local_name
from employee E
    JOIN department D ON E.dept_code = D.dept_id
    JOIN location L ON D.location_id= L.local_code
where E.bonus IS NOT NULL;

--부서코드가 D2인 직원
--사원명, 직급명, 부서명, 근무지역명
select E.emp_name, J.job_name, E.dept_code, D.dept_title, L.local_name
from employee E
    JOIN job J ON E.job_code = J.job_code
    JOIN department D ON E.dept_code = D.dept_id
    JOIN location L ON D.location_id = L.local_code
where E.dept_code = 'D2';

--급여등급테이블의 최대급여(MAX_SAL)보다 많이 받는 직원들
--사원명, 직급명, 급여, 연봉
select E.emp_name, J.job_name, 
        E.salary, E.salary*(12 + nvl(E.bonus,0)) AS 연봉, G.MAX_SAL
from employee E
    JOIN job J ON E.job_code = J.job_code
    JOIN sal_grade G ON E.sal_level = G.sal_level
where E.salary *(1+nvl(bonus,0)) > G.MAX_SAL;

--한국(KO)와 일본(JP)에 근무하는 직원
--사원명,부서명, 지역명, 국가명
select E.emp_name, D.dept_title, L.local_name, N.national_name
from employee E
    JOIN department D ON E.dept_code = D.dept_id
    JOIN location L ON D.location_id = L.local_code
    JOIN national N ON L.national_code = N.national_code
where L.national_code in ('KO', 'JP');

--같은부서에 근무하는 직원(self join)
--사원명, 부서명, 동료이름
select E1.emp_name 사원명,
    D.dept_title 부서명,
    E2.emp_name 동료명
from employee E1
    JOIN employee E2 USING(dept_code)
    JOIN department D ON dept_code = D.dept_id
where E1.emp_name != E2.emp_name;

--보너스가 없는 직원 중 직급이 차장과 사원인 직원
--사원명, 직급명, 급여조회 join, in 사용
select E.emp_name, J.job_name, TO_CHAR(E.salary, 'L999,999,999') AS 급여
from employee E
    LEFT JOIN department D ON E.dept_code = D.dept_id
    JOIN job J ON E.job_code = J.job_code
where J.job_name IN ('차장', '사원')
    and E.bonus IS NULL;

--재직중인 직원과 퇴사한 직원의 수
select CASE WHEN ent_yn ='N'
            THEN '재직중' ELSE '퇴사' END AS 재직여부,
        count(*) AS "인원(명)"
from employee
GROUP BY CASE WHEN ent_yn ='N'
        THEN '재직중' ELSE '퇴사' END;
