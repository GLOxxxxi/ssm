/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/11/10 16:03:58                          */
/*==============================================================*/


drop table if exists clazz;

drop table if exists grade;

drop table if exists institute;

drop table if exists student;

/*==============================================================*/
/* Table: clazz                                                 */
/*==============================================================*/
create table clazz
(
   c_id                 int not null,
   g_id                 int,
   c_name               varchar(20),
   primary key (c_id)
);

/*==============================================================*/
/* Table: grade                                                 */
/*==============================================================*/
create table grade
(
   g_id                 int not null,
   i_id                 int,
   g_num                varchar(10),
   primary key (g_id)
);

/*==============================================================*/
/* Table: institute                                             */
/*==============================================================*/
create table institute
(
   i_id                 int not null,
   i_num                varchar(10),
   primary key (i_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   id                   int not null,
   c_id                 int,
   s_name               varchar(20),
   s_age                int,
   s_class              varchar(20),
   s_studentnumber      varchar(20),
   primary key (id)
);

alter table clazz add constraint "FK_grade-clazz" foreign key (g_id)
      references grade (g_id) on delete restrict on update restrict;

alter table grade add constraint "FK_institute-grade" foreign key (i_id)
      references institute (i_id) on delete restrict on update restrict;

alter table student add constraint "FK_clazz-student" foreign key (c_id)
      references clazz (c_id) on delete restrict on update restrict;

