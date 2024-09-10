-- 코드를 입력하세요
SELECT PRODUCT_CODE, PRICE * SUM(SALES_AMOUNT) AS SALES
FROM PRODUCT AS P INNER JOIN OFFLINE_SALE AS O
WHERE P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY P.PRODUCT_ID
ORDER BY SALES DESC, PRODUCT_CODE ASC;