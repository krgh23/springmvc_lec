DROP DATABASE IF EXISTS db_app13;
CREATE DATABASE IF NOT EXISTS db_app13;
USE db_app13;

DROP TABLE IF EXISTS tbl_bbs;

CREATE TABLE IF NOT EXISTS tbl_bbs
(
    bbs_id      INT AUTO_INCREMENT,
    contents    VARCHAR(1000) NOT NULL,
    created_at  DATETIME,
    state       TINYINT COMMENT '삭제여부(0:정상, 1:삭제)',
    depth       TINYINT COMMENT '댓글깊이(0:원글, 1:댓글, 2:대댓글, ...)',
    group_id    INT COMMENT '그룹화(원글과 해등 원글에 달린 댓글은 같은 번호를 가짐',
    group_order SMALLINT COMMENT '같은 그룹 내에서 정렬하기 위한 값',
    CONSTRAINT pk_bbs PRIMARY KEY (bbs_id)
) ENGINE='InnoDB' COMMENT='계층형게시판';


-- SELECT LAST_INSERT_ID();


-- INSERT INTO tbl_bbs(bbs_id, contents, group_id)
-- VALUES(null, 'test', LAST_INSERT_ID() + 1);  --  LAST_INSERT_ID() + 1 = LAST_INSERT_ID()는 INSERT 하고나서라서 +1을 해줘야 같은 번호로 세팅됨

SELECT * FROM db_app13.tbl_bbs;


