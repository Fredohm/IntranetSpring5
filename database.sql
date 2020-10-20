drop database if exists `intranet_tfe`;

create database if not exists `intranet_tfe` charset=utf8;

use `intranet_tfe`;

--
-- table des utilisateurs
--
drop table if exists `users`;

create table `users` (
    `username` varchar(50) not null,
    `password` varchar(68) not null,
    `enabled` tinyint(1) not null,
    primary key (`username`)
) engine InnoDB auto_increment=1 default charset=utf8;

--
-- Insertion d'un ustilisateur par défaut
insert into `users` values ('admin', '{brcypt}$2a$10$9ux2poECd9muJDTRI0VfUOLpju9hzVAUjo8BoDSVNHwWZieun6QOW', 1);

--
-- tables des autorités
--
drop table if exists `authorities`;

create table `authorities` (
	`username` varchar(50) not null,
	`authority` varchar(50) not null,
    unique key `authorities_idx_1` (`username`, `authority`),
    constraint `authorities_ibfk_1` foreign key (`username`) references `users` (`username`)
) engine=InnoDB auto_increment=1 default charset=utf8;

insert into `authorities` values ('admin', 'ROLE_ADMIN'meeting_room);
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