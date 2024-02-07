/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2024/2/7 12:06:15                            */
/*==============================================================*/


drop table if exists block;

drop table if exists file;

drop table if exists isFollow;

drop table if exists post;

drop table if exists postReply;

drop table if exists user;

drop table if exists userReply;

/*==============================================================*/
/* Table: block                                                 */
/*==============================================================*/
create table block
(
   blockID              int not null auto_increment,
   zoneName             varchar(20) not null,
   blockName            varchar(20) not null,
   blockIntroduce       varchar(100),
   postNumber           int not null,
   followers            int not null,
   primary key (blockID)
);

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   fileID               int not null auto_increment,
   userID               int not null,
   fileName             varchar(50) not null,
   filePath             varchar(50) not null,
   primary key (fileID)
);

/*==============================================================*/
/* Table: isFollow                                              */
/*==============================================================*/
create table isFollow
(
   userID               int not null,
   blockID              int not null,
   primary key (userID, blockID)
);

/*==============================================================*/
/* Table: post                                                  */
/*==============================================================*/
create table post
(
   postID               int not null auto_increment,
   userID               int not null,
   blockID              int not null,
   replyNumber          int not null,
   postTitle            varchar(30) not null,
   postDate             datetime not null,
   primary key (postID)
);

/*==============================================================*/
/* Table: postReply                                             */
/*==============================================================*/
create table postReply
(
   postReplyID          int not null auto_increment,
   userID               int not null,
   postID               int not null,
   postReplyContent     varchar(100) not null,
   postReplyTime        datetime not null,
   primary key (postReplyID)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userID               int not null auto_increment,
   userName             char(15) not null,
   userLevel            int not null,
   userAvatar           int not null,
   userExperience       int not null,
   userAccount          varchar(20) not null,
   userPassword         varchar(20) not null,
   authority            char(10) not null,
   isAdministrators     bool not null,
   primary key (userID)
);

/*==============================================================*/
/* Table: userReply                                             */
/*==============================================================*/
create table userReply
(
   userReplyID          int not null auto_increment,
   userID               int not null,
   postID               int not null,
   postReplyID          int not null,
   userReplyContent     varchar(30) not null,
   userReplyTime        datetime not null,
   primary key (userReplyID)
);

alter table file add constraint FK_upload_and_download foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table isFollow add constraint FK_isFollow foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table isFollow add constraint FK_isFollow2 foreign key (blockID)
      references block (blockID) on delete restrict on update restrict;

alter table post add constraint FK_contain foreign key (blockID)
      references block (blockID) on delete restrict on update restrict;

alter table post add constraint FK_publish foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table postReply add constraint FK_interactToPost foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table postReply add constraint FK_makeup foreign key (postID)
      references post (postID) on delete restrict on update restrict;

alter table userReply add constraint FK_communicate foreign key (postReplyID)
      references postReply (postReplyID) on delete restrict on update restrict;

alter table userReply add constraint FK_interactToUser foreign key (userID)
      references user (userID) on delete restrict on update restrict;

alter table userReply add constraint FK_portion foreign key (postID)
      references post (postID) on delete restrict on update restrict;

