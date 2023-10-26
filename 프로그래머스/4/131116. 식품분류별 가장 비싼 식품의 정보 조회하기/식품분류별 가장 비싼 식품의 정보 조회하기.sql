-- 코드를 입력하세요
--최종결과 : CATEGORY, PRICE, PRODUCT_NAME
--필요한 테이블 : 
--조건 :   '과자', '국', '김치', '식용유' AND (식품분류, 가격) IN 가격이 제일 비싼 식품
--그룹 :
--그룹 조건 :
--소팅 :식품 가격을 기준으로 내림차순
SELECT CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT 
WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    AND (CATEGORY, PRICE) IN ( SELECT CATEGORY, MAX(PRICE)
                                FROM FOOD_PRODUCT 
                                GROUP BY CATEGORY )
ORDER BY PRICE DESC;