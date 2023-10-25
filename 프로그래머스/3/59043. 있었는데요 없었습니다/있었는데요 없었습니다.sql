-- 코드를 입력하세요
--최종결과 : INS.ANIMAL_ID, INS.NAME
--필요한 테이블 : INS JOIN OUTS
--조건 : WHERE INS.DATETIME > OUTS.DATETIME
--그룹 :
--그룹 조건 : 
--소팅 : INS.DATETIME ASC;
SELECT INS.ANIMAL_ID, INS.NAME 
FROM ANIMAL_INS INS INNER JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE INS.DATETIME > OUTS.DATETIME
ORDER BY INS.DATETIME ASC;