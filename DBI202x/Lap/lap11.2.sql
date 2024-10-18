use online_shop;

-- Yeu cau 2
select * from sales where transaction_value > 2;

set @transaction_value = 2;
select * from sales where transaction_value > @transaction_value;
