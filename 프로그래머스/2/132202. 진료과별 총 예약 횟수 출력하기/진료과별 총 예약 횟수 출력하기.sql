-- 코드를 입력하세요
-- SELECT mcdp_cd as 진료과코드, count(mcdp_cd) as 5월예약건수 from appointment where month(mcdp_cd) = '05' group by 진료과코드
SELECT mcdp_cd as 진료과코드, count(mcdp_cd) as 5월예약건수 from appointment where month(apnt_ymd) = 5 group by 진료과코드 order by 5월예약건수, 진료과코드