SELECT TO_NUMBER(HOUR) as HOUR, COUNT(*) as COUNT
FROM (
    SELECT TO_CHAR(DATETIME, 'HH24') as HOUR 
    FROM ANIMAL_OUTS
)
WHERE HOUR BETWEEN 09 AND 19
GROUP BY HOUR
ORDER BY HOUR;

