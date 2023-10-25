-- 코드를 입력하세요
--최종결과 : REST_ID, REST_NAME, FAVORITES
--필요한 테이블 : REST_INFO 
--조건 : 음식종류별 즐겨찾기가 가장 많은 
--소팅 :  음식 종류를 기준으로 내림차순 정렬해주세요. 
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO 
WHERE (FOOD_TYPE,FAVORITES) IN (SELECT FOOD_TYPE, MAX(FAVORITES) as FAVORITES
                                FROM REST_INFO
                               GROUP BY FOOD_TYPE)
ORDER BY FOOD_TYPE DESC;