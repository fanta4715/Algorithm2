-- 코드를 입력하세요
--최종결과 : 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수와 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)
--필요한 테이블 : 
--조건 : 2021년에 가입한
--그룹 : 년, 월
--그룹 조건 :
--소팅 : 년을 기준으로 오름차순 정렬해주시고 년이 같다면 월을 기준으로 오름차순 정렬해주세요.
WITH USER_IN_2021 AS
    (SELECT  USER_ID
    FROM USER_INFO 
    WHERE TO_CHAR(JOINED,'YYYY') = '2021')
    
SELECT TO_CHAR(SALES_DATE,'YYYY') as YEAR,
TO_NUMBER(TO_CHAR(SALES_DATE,'MM')) as MONTH,
COUNT(DISTINCT(USER_ID)) as PUCHASED_USERS,
ROUND( COUNT(DISTINCT(USER_ID))/(SELECT COUNT(USER_ID) FROM USER_IN_2021),1) as PUCHASED_RATIO
FROM ONLINE_SALE  
WHERE USER_ID IN ( SELECT USER_ID
                    FROM USER_IN_2021 )
GROUP BY TO_CHAR(SALES_DATE,'YYYY'), TO_CHAR(SALES_DATE,'MM')
ORDER BY YEAR, MONTH;