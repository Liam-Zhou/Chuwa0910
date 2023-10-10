
-- 1.  Create  oms_company_address  table
CREATE TABLE oms_company_address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    address_name VARCHAR(200),
    send_status TINYINT(1),
    receive_status TINYINT(1),
    name VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    region VARCHAR(64),
    detail_address VARCHAR(200)
);

-- 2.  Insert some random data to  oms_company_address  table
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
    ('address_1', 1, 0, 'A', '111-111-1111', 'province_0', 'city_0', 'region_0', 'detail_address_0'),
    ('address_2', 0, 1, 'B', '222-222-2222', 'province_1', 'city_1', 'region_1', 'detail_address_1'),
    ('address_3', 0, 0, 'C', '333-333-3333', 'province_2', 'city_2', 'region_2', 'detail_address_2'),
    ('address_4', 0, 0, 'D', '444-444-4444', 'province_3', 'city_3', 'region_3', 'detail_address_3'),
    ('address_5', 1, 0, 'E', '555-555-5555', 'province_4', 'city_4', 'region_4', 'detail_address_4'),
    ('address_6', 0, 1, 'F', '666-666-6666', 'province_5', 'city_5', 'region_5', 'detail_address_5'),
    ('address_7', 0, 0, 'G', '777-777-7777', 'province_6', 'city_6', 'region_6', 'detail_address_6'),
    ('address_8', 1, 0, 'H', '888-888-8888', 'province_7', 'city_7', 'region_7', 'detail_address_7'),
    ('address_9', 1, 0, 'I', '999-999-9999', 'province_8', 'city_8', 'region_8', 'detail_address_8'),
    ('address_10', 0, 0, 'J', '888-888-8888', 'province_9', 'city_9', 'region_9', 'detail_address_9');

-- 3.  Write a SQL query to fetch all data from  oms_company_address  `table
SELECT * FROM oms_company_address;

-- 4.  Write a SQL query to fetch top 3 records from  oms_company_address  table
SELECT * FROM oms_company_address LIMIT 3;

-- 5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
UPDATE oms_company_address SET phone = '666-6666-8888';

-- 6.  Delete one entry from  oms_company_address  table
DELETE FROM oms_company_address WHERE id = 1;