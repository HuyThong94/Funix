create database lap14;
use lap14;

-- yeu cau 1
create table animals(
	id int auto_increment primary key,
    animal_name varchar(100)
);

-- Yeu cau 2
DELIMITER $$
CREATE TRIGGER replace_cat_before_insert
BEFORE INSERT ON animals
FOR EACH ROW
BEGIN
    IF NEW.animal_name LIKE '%cat%' THEN
        SET NEW.animal_name = 'xxx';
    END IF;
END$$
DELIMITER ;

INSERT INTO animals (animal_name) VALUES ('Wildcat');
SELECT * FROM animals;
