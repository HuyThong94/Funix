use cat_app; 
select * from cats;

-- Yêu cầu 1:
update cats set name="jack" where cat_id=7;

-- Yêu cầu 2:
update cats set name="Bitish Shorthair" where cat_id=1;

-- Yêu cầu 3:
update cats set age=12 where breed="Maine Coon";

-- Yêu cầu 4:
delete from cats where age=4;

-- Yêu cầu 5:
delete from cats where cat_id=age;

-- Yêu cầu 6:
delete from cats;