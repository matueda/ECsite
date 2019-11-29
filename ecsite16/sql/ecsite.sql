set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
family_name varchar(50),
first_name varchar(50),
family_name_kana varchar(50),
first_name_kana varchar(50),
street_address varchar(50),
call_number varchar(12),
admin_flg varchar(1),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR1",100,3);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR2",100,4);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR3",100,4);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR4",100,4);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR5",100,4);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR6",100,4);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR7",100,900);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR8",100,900);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR9",100,900);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR10",100,900);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("COLOR11",100,900);

INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("internous","internous01","test","0");
INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("admin","admin","管理者","1");
INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("yasuo","839","yasuo","0");
INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg,family_name,first_name,family_name_kana,first_name_kana,street_address,call_number) VALUES("testuser","testuser","テストユーザー","0","田中","太郎","たなか","たろう","東京都港区虎ノ門４丁目３−１ 城山トラストタワー 31F","77777777777");