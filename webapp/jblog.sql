-------------- drops --------------
drop table users;
drop table blog;
drop table comments;
drop table post;
drop table category;
drop sequence seq_users_no;
drop sequence seq_category_no;
drop sequence seq_post_no;
drop sequence seq_comments_no;

-------------- create table --------------
create table users(
    userNo number primary key
    ,id varchar2(50) not null unique
    ,userName varchar2(100) not null
    ,password varchar2(50) not null
    ,joinDate date not null
);

create table blog(
    id varchar2(50) primary key
    ,blogTitle varchar2(200) not null
    ,logoFile varchar2(200)
);

create table category(
    cateNo number primary key
    ,id varchar2(50)
    ,cateName varchar2(200) not null
    ,description varchar2(500)
    ,regDate date not null
);

create table comments(
    cmtNo number primary key
    ,postNo number
    ,userNo number
    ,cmtContent varchar2(1000) not null
    ,regDate date not null
);


create table post(
    postNo number primary key
    ,cateNo number
    ,postTitle varchar2(300) not null
    ,postContent varchar2(4000)
    ,regDate date not null
);

-------------- foreign key settings --------------
alter table blog
add constraint blog_fk
foreign key (id)
references users(id);

alter table category
add constraint category_fk
foreign key (id)
references blog(id);

alter table post
add constraint post_fk
foreign key (cateNo)
references category(cateNo);

alter table comments
add constraint comments_fk
foreign key (postNo)
references post(postNo);

alter table comments
add constraint comments_fk2
foreign key (userNo)
references users(userNo);

-------------- create sequence --------------
create sequence seq_users_no
increment by 1
start with 1
nocache;

create sequence seq_category_no
increment by 1
start with 1
nocache;

create sequence seq_post_no
increment by 1
start with 1
nocache;

create sequence seq_comments_no
increment by 1
start with 1
nocache;

-------------- test area --------------
select *
from users;

select *
from category;