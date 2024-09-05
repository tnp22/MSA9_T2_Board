-- select 1+1 from dual;
-- 게시판 테이블 생성
CREATE TABLE `first_schema`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `content` TEXT NULL,
  `reg_date` TIMESTAMP NOT NULL DEFAULT now(),
  `upd_date` TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`no`))
COMMENT = '게시판';


-- 조회
select * from board;

select * from board
where no = 1;

-- 데이터 추가
insert into board (title,writer,content)
values ('게시글 제목 01','유지현','집에가고싶다');

-- 수정
update board
set title = '게시글 수정 제목 01'
,writer ='강민아'
,content='내가먼저감'
where no =1;

delete from board; -- 안전 업데이트 모드 해제 해야 적용됨

-- 삭제
delete from board
where no =1;

-- 전부삭제
TRUNCATE TABLE board;


