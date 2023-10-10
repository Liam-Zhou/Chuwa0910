CREATE SCHEMA `ChuwaTest` DEFAULT CHARACTER SET utf8;
USE ChuwaTest;
CREATE TABLE oms_company_address (
    id BIGINT PRIMARY KEY,
    address_name VARCHAR(200),
    send_status INT(1),
    receive_status INT(1),
    name VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    detail_address VARCHAR(200)
);

INSERT INTO oms_company_address (id,address_name,send_status,receive_status,name,phone,province,city,detail_address) VALUES (1,"a",1,1,"a","a","a","a","a");
INSERT INTO oms_company_address (id,address_name,send_status,receive_status,name,phone,province,city,detail_address) VALUES (2,"b",1,1,"b","b","b","b","b");
INSERT INTO oms_company_address (id,address_name,send_status,receive_status,name,phone,province,city,detail_address) VALUES (3,"c",1,1,"b","b","b","b","b");
INSERT INTO oms_company_address (id,address_name,send_status,receive_status,name,phone,province,city,detail_address) VALUES (4,"d",1,1,"b","b","b","b","b");
INSERT INTO oms_company_address (id,address_name,send_status,receive_status,name,phone,province,city,detail_address) VALUES (5,"e",1,1,"b","b","b","b","b");
INSERT INTO oms_company_address (id,address_name,send_status,receive_status,name,phone,province,city,detail_address) VALUES (6,"f",1,1,"b","b","b","b","b");
INSERT INTO oms_company_address (id,address_name,send_status,receive_status,name,phone,province,city,detail_address) VALUES (7,"g",1,1,"b","b","b","b","b");

SELECT * FROM oms_company_address;

SELECT * FROM oms_company_address LIMIT 3;

UPDATE oms_company_address SET phone = '666-6666-88' WHERE true;

DELETE FROM oms_company_address WHERE id = 1;
