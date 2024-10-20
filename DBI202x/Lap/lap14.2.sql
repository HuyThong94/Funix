use lap14;

-- Yeu cau 1
CREATE TABLE sales (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product VARCHAR(45) NOT NULL,
    sold NUMERIC(8, 2) NOT NULL
);

CREATE TABLE sales_totals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    total NUMERIC(11, 2) NOT NULL,
    day DATE UNIQUE
);

-- Yeu cau 2
DELIMITER $$
CREATE TRIGGER update_sales_totals_after_insert
AFTER INSERT ON sales
FOR EACH ROW
BEGIN
    DECLARE sale_date DATE;
    SET sale_date = CURDATE(); -- Lấy ngày hiện tại
    
    -- Kiểm tra nếu ngày đó đã có trong bảng sales_totals hay chưa
    IF EXISTS (SELECT 1 FROM sales_totals WHERE day = sale_date) THEN
        -- Nếu có, cập nhật tổng số tiền bán
        UPDATE sales_totals
        SET total = total + NEW.sold
        WHERE day = sale_date;
    ELSE
        -- Nếu chưa có, chèn một bản ghi mới với tổng số tiền của ngày đó
        INSERT INTO sales_totals (total, day)
        VALUES (NEW.sold, sale_date);
    END IF;
END$$
DELIMITER ;

INSERT INTO sales (product, sold) VALUES ('Product A', 500.00),('Product B', 300.00);

SELECT * FROM sales_totals;
