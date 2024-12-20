DROP DATABASE IF EXISTS db_app09;
CREATE DATABASE IF NOT EXISTS db_app09;
USE db_app09;

DROP TABLE IF EXISTS tbl_attach;
DROP TABLE IF EXISTS tbl_notice;

CREATE TABLE IF NOT EXISTS tbl_notice
(
    notice_id       INT AUTO_INCREMENT,
    notice_title    VARCHAR(1000) NOT NULL,
    notice_contents VARCHAR(1000),
    created_at      DATETIME,
    CONSTRAINT pk_notice PRIMARY KEY (notice_id)
) ENGINE=InnoDB COMMENT ='공지사항';


CREATE TABLE IF NOT EXISTS tbl_attach
(
    attach_id         INT AUTO_INCREMENT,
    notice_id         INT,
    file_path         VARCHAR(300),
    original_filename VARCHAR(300),
    filesystem_name   VARCHAR(40),
    download_count    int,
    CONSTRAINT pk_file PRIMARY KEY (attach_id),
    CONSTRAINT fk_notice_attach FOREIGN KEY (notice_id)
        REFERENCES tbl_notice (notice_id) ON DELETE CASCADE /* 데이터베이스상에서만 사라지고 파일은 남아있음 */
) ENGINE=InnoDB COMMENT ='첨부파일';


    SELECT n.notice_id, 
           n.notice_title, 
           n.notice_contents, 
           n.created_at, 
           COUNT(a.notice_id) AS attach_count
      FROM tbl_notice n INNER JOIN tbl_attach a ON n.notice_id = a.notice_id
     GROUP BY n.notice_id, n.notice_title, n.notice_contents, n.created_at
     ORDER BY n.notice_id DESC;



















