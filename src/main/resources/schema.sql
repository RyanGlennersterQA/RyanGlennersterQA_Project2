drop table if exists car_park CASCADE;
create table car_park (id bigint AUTO_INCREMENT, arrival_date varchar(255), leaving_date varchar(255), make varchar(255), model varchar(255), primary key (id));