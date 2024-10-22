USE BAO_DIEN_TU;

-- Truy vấn tất cả bảng POST
SELECT * FROM POST;

-- Truy vấn tất cả bảng MANAGERS
SELECT * FROM MANAGERS;

-- Truy vấn những bài viết có LUOT_XEM lớn hơn 20.
SELECT * FROM POST
WHERE LUOT_XEM > 20;

-- Truy vấn những bài viết đã được xét duyệt và sắp xếp kết quả theo thứ tự bảng chữ cái của cột tiêu đề.
SELECT TIEU_DE , NOI_DUNG , LUOT_XEM , XET_DUYET ,NGUOI_DUYET, THOI_GIAN_DANG
FROM POST
WHERE XET_DUYET = '1'
order by TIEU_DE;

-- Truy vấn lấy tên các acount_name của user comment vào POST: 
SELECT C.NGUOI_COMMENT, U.ACCOUNT_NAME, C.NOI_DUNG 
FROM COMMENT C
LEFT JOIN USERS U ON C.NGUOI_COMMENT = U.ID_USER
ORDER BY C.NGUOI_COMMENT;

-- Truy vấn tìm nội dung bài viết bắt đầu bằng chữ ‘n’
SELECT * FROM POST
WHERE NOI_DUNG LIKE lower('N%');

-- Tạo VIEW để lấy ra những bài viết đã được duyệt bởi những người quản lý.
CREATE VIEW VIEW_APPROVED_POSTS AS
SELECT p.*
FROM POST p
JOIN MANAGERS mng ON p.NGUOI_DUYET = mng.ID_MNG
WHERE p.XET_DUYET = TRUE;

-- Tạo VIEW để lấy ra các comment của user.
CREATE VIEW VIEW_USER_COMMENTS AS
SELECT c.*, u.ACCOUNT_NAME
FROM COMMENT c
JOIN USERS U ON c.NGUOI_COMMENT = U.ID_USER;