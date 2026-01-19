SELECT w.writer_id, u.nickname, concat(u.city, " ", u.STREET_ADDRESS1, " ", u.STREET_ADDRESS2) as 전체주소, concat(left(u.tlno, 3), "-", substring(u.tlno, 4, 4), "-",right(u.tlno, 4)) as 전화번호
from USED_GOODS_USER as u, 
    (select b.writer_id
     from USED_GOODS_BOARD as b
     group by b.writer_id
     having count(b.board_id) >= 3) as w
where w.writer_id = u.user_id
order by w.writer_id desc