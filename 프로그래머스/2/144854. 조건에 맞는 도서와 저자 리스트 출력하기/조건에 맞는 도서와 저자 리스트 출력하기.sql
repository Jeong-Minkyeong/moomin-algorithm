-- 코드를 입력하세요
SELECT b.book_id, a.author_name, substring(b.published_date, 1, 10)
from book b, author a
where b.author_id = a.author_id and b.category = '경제'
order by b.published_date