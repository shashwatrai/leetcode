# Write your MySQL query statement below
with temp1 as (
select id,lag(id) over(order by visit_date ) as prevId1,lead(id) over(order by visit_date ) as nextId1, visit_date,people from stadium where people >= 100 order by visit_date , id),
temp2 as (
    select id,prevId1, nextId1,lag(prevId1) over(order by visit_date ) as prevId2,lead(nextId1) over(order by visit_date ) as nextId2, visit_date,people from temp1 where people >= 100 order by visit_date , id

)
select id, visit_date,people from temp2 where  (id = nextId1 - 1 and nextId1 = nextId2 -1) or
 (id = nextId1 - 1 and prevId1 = id -1) or (prevId2 = prevId1 - 1 and prevId1 = id -1)
