-- Yeu cau 1
create database stored_procedure;
use stored_procedure;
CREATE TABLE word_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    noun VARCHAR(100),
    adjective VARCHAR(100)
);

INSERT INTO word_table (noun, adjective) VALUES 
('cat', 'happy'),
('dog', 'brave'),
('car', 'fast'),
('house', 'big'),
('flower', 'beautiful'),
('tree', 'tall'),
('book', 'interesting'),
('river', 'long'),
('mountain', 'high'),
('star', 'bright');

-- Yeu cau 2
DELIMITER $$
CREATE PROCEDURE get_nouns_adjectives(OUT nouns_list TEXT, OUT adjectives_list TEXT)
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE noun_var VARCHAR(100);
    DECLARE adj_var VARCHAR(100);
    DECLARE noun_cursor CURSOR FOR SELECT noun, adjective FROM word_table;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    SET nouns_list = '';
    SET adjectives_list = '';
    OPEN noun_cursor;

    read_loop: LOOP
        FETCH noun_cursor INTO noun_var, adj_var;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SET nouns_list = CONCAT_WS(',', nouns_list, noun_var);
        SET adjectives_list = CONCAT_WS(',', adjectives_list, adj_var);
    END LOOP;
    CLOSE noun_cursor;
END$$

DELIMITER ;

-- Yeu cau 3
DELIMITER $$
CREATE PROCEDURE crwwweate_random_star()
BEGIN
    DECLARE random_noun VARCHAR(100);
    DECLARE random_adj VARCHAR(100);

    -- Chọn ngẫu nhiên một danh từ và tính từ
    SELECT noun INTO random_noun FROM word_table ORDER BY RAND() LIMIT 1;
    SELECT adjective INTO random_adj FROM word_table ORDER BY RAND() LIMIT 1;

    -- Tạo bảng stars nếu chưa có
    CREATE TABLE IF NOT EXISTS stars (
        star_name VARCHAR(200)
    );

    -- Nối danh từ và tính từ và chèn vào bảng stars
    INSERT INTO stars (star_name) VALUES (CONCAT(random_adj, ' ', random_noun));
END$$
DELIMITER ;

-- Yeu cau 4
DELIMITER $$
CREATE PROCEDURE create_random_height_weight()
BEGIN
    DECLARE random_height INT;
    DECLARE random_weight INT;

    -- Tạo bảng height_weight nếu chưa có
    CREATE TABLE IF NOT EXISTS height_weight (
        height INT,
        weight INT
    );
    -- Tạo chiều cao ngẫu nhiên từ 100 đến 190 cm
    SET random_height = FLOOR(100 + (RAND() * (190 - 100 + 1)));
    -- Tạo cân nặng ngẫu nhiên từ 1/3 chiều cao đến 1/2 chiều cao
    SET random_weight = FLOOR((random_height / 3) + (RAND() * ((random_height / 2) - (random_height / 3) + 1)));
    -- Chèn vào bảng
    INSERT INTO height_weight (height, weight) VALUES (random_height, random_weight);
END$$
DELIMITER ;

INSERT INTO word_table (noun, adjective) VALUES 
('lion', 'strong'),
('tiger', 'fierce'),
('elephant', 'large'),
('bird', 'small'),
('ocean', 'vast');

CALL get_nouns_adjectives(@nouns, @adjectives);
SELECT @nouns, @adjectives;

CALL create_random_star();
SELECT * FROM stars;

CALL create_random_height_weight();
SELECT * FROM height_weight;
