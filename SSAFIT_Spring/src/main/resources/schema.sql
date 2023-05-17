drop database if exists ssafit;

create database ssafit;

use ssafit;

create table video (
	`id` varchar(40) primary key not null,
    `title` varchar(100) not null,
    `part` varchar(40) not null,
    `channelName` varchar(40) not null,
    `url` varchar(100) not null,
    `view_cnt` int not null default 0
)engine=InnoDB;

insert into video
values
("gMaB-fG4u4g", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "전신", "ThankyouBUBU", "https://www.youtube.com/embed/gMaB-fG4u4g", 75),
("swRNeYw1JkY", "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "전신", "ThankyouBUBU", "https://www.youtube.com/embed/swRNeYw1JkY", 12),
("54tTYO-vU2E", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/54tTYO-vU2E", 2),
("QqqZH3j_vH0", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/QqqZH3j_vH0", 111),
("tzN6ypk6Sps", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "하체", "김강민", "https://www.youtube.com/embed/tzN6ypk6Sps", 42),
("u5OgcZdNbMo", "저는 하체 식주의자 입니다", "하체", "GYM종국", "https://www.youtube.com/embed/u5OgcZdNbMo", 777),
("PjGcOP-TQPE", "11자복근 복부 최고의 운동 [복근 핵매운맛]", "복부", "ThankyouBUBU", "https://www.youtube.com/embed/PjGcOP-TQPE", 31),
("7TLk7pscICk", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "복부", "SomiFit", "https://www.youtube.com/embed/7TLk7pscICk", 127);

drop table if exists review;
create table review (
	`id` int AUTO_INCREMENT not null,
    `videoId` varchar(100) not null,
    `title` varchar(100) not null,
    `description` varchar(40) not null,
    `writer` varchar(40) not null,
    `view_cnt` int not null default 0,
    `reg_date` TIMESTAMP DEFAULT now(),
    PRIMARY KEY(id),
    CONSTRAINT `fk_videoid` FOREIGN KEY (`videoid`)
        REFERENCES `video` (`id`)
);

drop table if exists users;
create table users (
	`id` varchar(40) not null PRIMARY KEY,
    `password` varchar(40) not null,
    `email` varchar(40) not null,
    `name` varchar(40) not null
)engine=InnoDB;

insert into users
values 
("parkseyun", "123", "parkseyun@naver.com", "박세윤"),
("ssafy", "1234", "ssafy@ssafy.com", "박싸피");

insert into review(videoId, title, writer, description)
values
("gMaB-fG4u4g", "title1", "writer1","description1"),
("swRNeYw1JkY", "title2", "writer2","description2"),
("54tTYO-vU2E", "title3", "writer3","description3"),
("QqqZH3j_vH0", "title4", "writer4","description4"),
("tzN6ypk6Sps", "title5", "writer5","description5"),
("u5OgcZdNbMo", "title6", "writer6","description6"),
("PjGcOP-TQPE", "title7", "writer7","description7"),
("7TLk7pscICk", "title8", "writer8","description8");

select * from video;
select * from review;
select * from users;