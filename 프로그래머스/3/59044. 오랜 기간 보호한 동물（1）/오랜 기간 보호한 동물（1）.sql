-- 코드를 입력하세요
--최종결과 : NAME, DATETIME
--필요한 테이블 : 입양을 못 간 동물의 ID와 DATETIME을 보호 시작일 순 오름차순 반환하는 select
--조건 : ROWNUM <=3
--소팅 : 보호 시작일 순
SELECT NAME, DATETIME
FROM (SELECT NAME, DATETIME
     FROM ANIMAL_INS INS
     WHERE NOT EXISTS (SELECT * 
                       FROM ANIMAL_OUTS OUTS 
                       WHERE OUTS.ANIMAL_ID = INS.ANIMAL_ID)
     ORDER BY DATETIME)
WHERE ROWNUM <=3 ;