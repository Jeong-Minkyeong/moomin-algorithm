-- 코드를 입력하세요
-- SELECT substring(product_code, 1, 2) as category, count(product_code) as products from product group by substring(product_code, 1, 2)

select left(product_code, 2) as category, count(product_code) from product group by category