-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, TO_CHAR(PUBLISHED_DATE,'YYYY-MM-DD') AS PUBLISHED_DATE
FROM BOOK NATURAL JOIN AUTHOR 
WHERE CATEGORY = '경제'
ORDER BY PUBLISHED_DATE ASC;