use bao_dien_tu;

-- Tạo thủ tục để lấy được những bài viết đã được duyệt
DELIMITER $$
CREATE PROCEDURE GetApprovedPosts()
BEGIN
    SELECT * FROM POST WHERE XET_DUYET = '1';
END $$
DELIMITER ;

-- Gọi bài đã duyệt
call GetApprovedPosts();

-- Tạo thủ tục để lấy những bài viết chưa được duyệt trước ngày 01-02-2018.
DELIMITER $$
CREATE PROCEDURE GetUnapprovedPostsBeforeDate()
BEGIN
    SELECT * FROM POST
    WHERE XET_DUYET = '0'
    AND THOI_GIAN_DANG < '2018-02-01';
END $$
DELIMITER ;

-- Gọi bài đã duyệt
call GetUnapprovedPostsBeforeDate();

-- Tạo function để lấy được số tháng lớn nhất mà các bài viết đã đăng kể từ thời điểm được đăng đến thời điểm 01-01-2019 trong bảng POST.
SET GLOBAL log_bin_trust_function_creators = 1;
delimiter $$

CREATE FUNCTION DEM_THANG() 
returns int
DETERMINISTIC
begin 
	DECLARE max_months INT;
    SELECT MAX(TIMESTAMPDIFF(MONTH, THOI_GIAN_DANG, '2019-01-01')) INTO max_months
    FROM POST;
	RETURN max_months;
end$$
delimiter ;

-- Lấy số tháng lớn nhất
select DEM_THANG();

