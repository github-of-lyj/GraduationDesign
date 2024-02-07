/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2024/1/26 20:08:05                           */
/*==============================================================*/


drop table if exists college;

drop table if exists country;

drop table if exists university;

/*==============================================================*/
/* Table: college                                               */
/*==============================================================*/
create table college
(
   collegeCode          varchar(10) not null,
   collegeName          varchar(10) not null,
   primary key (collegeCode)
);

/*==============================================================*/
/* Table: country                                               */
/*==============================================================*/
create table country
(
   title                varchar(30) not null,
   type                 varchar(10) not null,
   href                 text,
   time                 datetime,
   primary key (title, type)
);

/*==============================================================*/
/* Table: university                                            */
/*==============================================================*/
create table university
(
   collegeCode          varchar(10) not null,
   policyName           varchar(40) not null,
   policydate           datetime,
   policyurl            text,
   primary key (policyName, collegeCode)
);

alter table university add constraint FK_publish foreign key (collegeCode)
      references college (collegeCode) on delete restrict on update restrict;

