-- 코드를 입력하세요
SELECT m.member_name, r.review_text, TO_CHAR(r.review_date,'YYYY-MM-DD') as REVIEW_DATE
FROM MEMBER_PROFILE m JOIN REST_REVIEW r ON m.member_id = r.member_id
WHERE m.member_id IN (
    SELECT member_id
    FROM (SELECT member_id, COUNT(*)
          FROM REST_REVIEW 
          GROUP BY member_id 
         ORDER BY COUNT(*) DESC)
    WHERE ROWNUM  = 1
)
ORDER BY REVIEW_DATE, r.REVIEW_TEXT;


