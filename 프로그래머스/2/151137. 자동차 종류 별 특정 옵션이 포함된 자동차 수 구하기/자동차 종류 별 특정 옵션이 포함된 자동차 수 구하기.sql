--최종결과 :CAR_TYPE, COUNT(*) as CARS
--필요한 테이블 : CAR_RENTAL_COMPANY_CAR 
--조건 : '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된
--그룹 : CAR_TYPE
--그룹 조건 :
--소팅 :CAR_TYPE;
SELECT CAR_TYPE, COUNT(*) as CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE ( OPTIONS LIKE '%가죽시트%' 
OR OPTIONS LIKE '%열선시트%' 
OR OPTIONS LIKE '%통풍시트%')
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE;