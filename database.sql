drop database if exists `intranet_tfe`;

create database if not exists `intranet_tfe` charset=utf8;

use `intranet_tfe`;

--
-- table des utilisateurs
--
drop table if exists `user`;

create table `user` (
	`id` int(11) not null auto_increment,
    `username` varchar(50) not null,
    `password` char(80) not null,
    `first_name` varchar(50) not null,
    `last_name` varchar(50) not null,
    `email` varchar(50) not null,
    primary key (`id`)
) engine InnoDB auto_increment=1 default charset=utf8;

--
-- Insertion d'un ustilisateur par défaut
insert into `user` (username, password, first_name, last_name, email) values ('fredohm', '$2a$10$9ux2poECd9muJDTRI0VfUOLpju9hzVAUjo8BoDSVNHwWZieun6QOW', 'Fred', 'Ohm', 'fredwz@ymail.com');

--
-- tables des autorités
--
drop table if exists `role`;

create table `role` (
	`id` int(11) not null auto_increment,
	`name` varchar(50) default null,
    primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;


insert into `role` (name) values ('ROLE_EMPLOYEE'),('ROLE_MANAGER'),('ROLE_ADMIN');


--
--  table associant utilisateurs et roles
--
drop table if exists `users_roles`;

create table `users_roles` (
	`user_id` int(11) not null,
    `role_id` int(11) not null,
    primary key(`user_id`,`role_id`),
    
    key `fk_role_idx` (`role_id`),
    
    constraint `fk_user` foreign key (`user_id`)
    references `user` (`id`)
    on delete no action on update no action,
    
    constraint `fk_role` foreign key (`role_id`)
    references `role` (`id`)
    on delete no action on update no action
) engine=InnoDB default charset=utf8;

set foreign_key_checks=1;

insert into `users_roles` (user_id,role_id) values (1,3);

--
-- table répertoriant les salles existantes
--
drop table if exists `meeting_room`;

create table `meeting_room` (
	`id` int(11) not null auto_increment,
    `meeting_room_name` varchar(45) not null,
    `meeting_room_places_nb` int(4) not null,
    `location` varchar(45) default null,
    `description` varchar(255) default null,
    `available` boolean default true,
    primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;


--
-- table des réservations
--
drop table if exists `booking`;

create table `booking` (
	`id` int(11) not null auto_increment,
    `meeting_room_id` int(11) not null,
    `object` varchar(255) not null,
    `organizer` varchar(255) not null,
    `members_number` int(11) not null,
    `meeting_date` datetime not null,
    `begin_time` time not null,
    `end_time` time not null,
    `drinks` tinyint(1) not null,
    `food` tinyint(1) not null,
    `projector` tinyint(1) not null,
    `notes` text default null,
    primary key (`id`),
    key `fk_meeting_room_id_idx` (`meeting_room_id`),
    constraint `fk_meeting_room_id` foreign key (`meeting_room_id`)
    references `meeting_room` (`id`) on delete no action on update no action
) engine InnoDB auto_increment=1 default charset=utf8;