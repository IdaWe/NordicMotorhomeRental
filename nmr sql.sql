DROP DATABASE nmr;

##############################
#    CREATING THE DATABASE   #
##############################

CREATE DATABASE nmr;

##############################
#      USING THE DATABASE    #
##############################

USE nmr;

##############################
#    CREATING THE TABLES     #
##############################


##############################
#       CREATING CUSTOMER    #
##############################

CREATE TABLE customer(
cus_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
cus_first_name VARCHAR(100),
cus_last_name VARCHAR(100),
cus_phone INT,
cus_address VARCHAR(100),
cus_zip INT,
cus_city VARCHAR(100),
cus_drivers_license_number INT,
cus_email VARCHAR(100)
);

##############################
#       CREATING VENDOR      #
##############################

CREATE TABLE vendor(
vendor_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
vendor_name VARCHAR(100),
vendor_address VARCHAR(100),
vendor_phone INT,
vendor_email VARCHAR(100),
vendor_acc_number INT
);

##############################
#      CREATING MOTORHOME    #
##############################

CREATE TABLE motorhome(
motorhome_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
motorhome_brand VARCHAR(100),
motorhome_model VARCHAR(100),
motorhome_type VARCHAR(100),
motorhome_description VARCHAR(500),
motorhome_price INT
);

##############################
#        CREATING LEASE      #
##############################

CREATE TABLE lease(
lease_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
lease_rent_date DATE,
lease_return_date DATE,

-- FK's 
vendor_id INT,
cus_id INT,
motorhome_id INT
);

##############################
#        CREATING PRODUCT    #
##############################

CREATE TABLE product(
product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(100),
product_price INT
);

##############################
#  CREATING EXTRA_LEASE_SALE #
##############################

CREATE TABLE lease_extra_sale(
product_amount INT,

-- FK's
lease_id INT,
product_id INT,
PRIMARY KEY (lease_id, product_id)
);


##############################
#        ALTER TABLES:       #
#      ADD FOREIGN KEYS      #
##############################


-- LEASE
ALTER TABLE lease ADD FOREIGN KEY (cus_id) REFERENCES customer(cus_id);
ALTER TABLE lease ADD FOREIGN KEY (motorhome_id) REFERENCES motorhome(motorhome_id);
ALTER TABLE lease ADD FOREIGN KEY (vendor_id) REFERENCES vendor(vendor_id) ;

-- LEASE_EXTRA_SALE
ALTER TABLE lease_extra_sale ADD FOREIGN KEY (lease_id) REFERENCES lease(lease_id);
ALTER TABLE lease_extra_sale ADD FOREIGN KEY (product_id) REFERENCES product(product_id);



##############################
#       Customer LIST        #
##############################

INSERT INTO customer
(cus_first_name, cus_last_name, cus_phone, cus_address, cus_zip, cus_city, cus_drivers_license_number, cus_email)
VALUES
('Minnie', 'Mouse', '67567577', 'Mouse Hill 14', '8899', 'Toontown', '546788', 'MinnieMouse@Disney.com');

INSERT INTO customer
(cus_first_name, cus_last_name, cus_phone, cus_address, cus_zip, cus_city, cus_drivers_license_number, cus_email)
VALUES
('Peter', 'Pan', '12121212', 'Skibsvej 77', '1111', 'Ønskeøen', '122221', 'PeterPan@Disney.com');

INSERT INTO customer
(cus_first_name, cus_last_name, cus_phone, cus_address, cus_zip, cus_city, cus_drivers_license_number, cus_email)
VALUES
('Andersine', 'And', '44334455', 'Andebyvej 44', '4444', 'Andeby', '44333344', 'Andersine_And@andeby.com');

INSERT INTO customer
(cus_first_name, cus_last_name, cus_phone, cus_address, cus_zip, cus_city, cus_drivers_license_number, cus_email)
VALUES
('Hexia', 'de Trix', '77777777', 'Mt. Vesuvius', '7777', 'Mt. Vesuv', '77777777', 'HexiaDeTrix@MtVesuv.andeby.com');

INSERT INTO customer
(cus_first_name, cus_last_name, cus_phone, cus_address, cus_zip, cus_city, cus_drivers_license_number, cus_email)
VALUES
('Peter', 'Plys', '34343434', 'Skovvej 100', '4444', 'Hundredmeter skoven', '5435443', 'PeterPlys@Teddy.com');



##############################
#        PRODUCT LIST        #
##############################

INSERT INTO product
(product_name, product_price)
VALUES
('Towels', '50');

INSERT INTO product
(product_name, product_price)
VALUES
('Bed linen', '60');

INSERT INTO product
(product_name, product_price)
VALUES
('Child seat', '100');

INSERT INTO product
(product_name, product_price)
VALUES
('gps', '150');

INSERT INTO product
(product_name, product_price)
VALUES
('Bike rack', '120');

INSERT INTO product
(product_name, product_price)
VALUES
('Picnic table', '75');

INSERT INTO product
(product_name, product_price)
VALUES
('Picnic chairs', '40');



##############################
#       MOTORHOME LIST       #
##############################

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Marano t 590 ','two persons', 
'fully integrated luxury camper with single or double bed and lovely sitting area with reversible chairs, 
good spacious closets and a nice kitchen with a combinated fridge and cooler', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Marano t 590 ','two persons', 
'fully integrated luxury camper with single or double bed and lovely sitting area with reversible chairs, 
good spacious closets and a nice kitchen with a combinated fridge and cooler', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Marano t 590 ','two persons', 
'fully integrated luxury camper with single or double bed and lovely sitting area with reversible chairs, 
good spacious closets and a nice kitchen with a combinated fridge and cooler', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Marano t 590 ','two persons', 
'fully integrated luxury camper with single or double bed and lovely sitting area with reversible chairs, 
good spacious closets and a nice kitchen with a combinated fridge and cooler', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Premium van 600 ','two persons', 
'in collaboration with the Nordic countries Carthago dealers, has specially designed these van models to best suit our customers. 
The trolleys are packed with extras such as, 6-speed automatic gear, 150hp and aircondition', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Premium van 600 ','two persons', 
'in collaboration with the Nordic countries Carthago dealers, has specially designed these van models to best suit our customers. 
The trolleys are packed with extras such as, 6-speed automatic gear, 150hp and aircondition', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Premium van 600 ','two persons', 
'in collaboration with the Nordic countries Carthago dealers, has specially designed these van models to best suit our customers. 
The trolleys are packed with extras such as, 6-speed automatic gear, 150hp and aircondition', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Premium van 600 ','two persons', 
'in collaboration with the Nordic countries Carthago dealers, has specially designed these van models to best suit our customers. 
The trolleys are packed with extras such as, 6-speed automatic gear, 150hp and aircondition', '500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Compactline 144 LE','four persons', 
'This fantastic fully integrated motorhome contains just about everything you would ever want on a vacation. 
Single beds behind & lower bed in cab. Big kitchen and four places to sleep', '800');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Compactline 144 LE','four persons', 
'This fantastic fully integrated motorhome contains just about everything you would ever want on a vacation. 
Single beds behind & lower bed in cab. Big kitchen and four places to sleep', '800');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Compactline 144 LE','four persons', 
'This fantastic fully integrated motorhome contains just about everything you would ever want on a vacation. 
Single beds behind & lower bed in cab. Big kitchen and four places to sleep', '800');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Compactline 144 LE','four persons', 
'This fantastic fully integrated motorhome contains just about everything you would ever want on a vacation. 
Single beds behind & lower bed in cab. Big kitchen and four places to sleep', '800');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Tourer 144 QB','four persons', 
'fully integrated luxury camper with Queensbed that can be length-shifted to a better space and lovely seating area with great front seats and good spacious cabinets', '800');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Tourer 144 QB','four persons', 
'fully integrated luxury camper with Queensbed that can be length-shifted to a better space and lovely seating area with great front seats and good spacious cabinets', '800');

INSERT INTO motorhome(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Tourer 144 QB','four persons', 
'fully integrated luxury camper with Queensbed that can be length-shifted to a better space and lovely seating area with great front seats and good spacious cabinets', '800');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Fiat','Carthago Tourer 144 QB','four persons', 
'fully integrated luxury camper with Queensbed that can be length-shifted to a better space and lovely seating area with great front seats and good spacious cabinets', '800');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','T67','five persons', 
'This super nice and spacious Sunlight T 67 is ideal to the family of 5. 
The two single beds can be gathered to one large double bed. On the pull down bed over the sofa there is a bed net, so it is also suitable for small children. 
With the bed in the sofa arrangement there is easily 5 beds in this motorhome.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','T67','five persons', 
'This super nice and spacious Sunlight T 67 is ideal to the family of 5. 
The two single beds can be gathered to one large double bed. On the pull down bed over the sofa there is a bed net, so it is also suitable for small children. 
With the bed in the sofa arrangement there is easily 5 beds in this motorhome.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','T67','five persons', 
'This super nice and spacious Sunlight T 67 is ideal to the family of 5. 
The two single beds can be gathered to one large double bed. On the pull down bed over the sofa there is a bed net, so it is also suitable for small children. 
With the bed in the sofa arrangement there is easily 5 beds in this motorhome.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','T67','five persons', 
'This super nice and spacious Sunlight T 67 is ideal to the family of 5. 
The two single beds can be gathered to one large double bed. On the pull down bed over the sofa there is a bed net, so it is also suitable for small children. 
With the bed in the sofa arrangement there is easily 5 beds in this motorhome.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Hymer','MasterLine I 780 (2020)',' five persons', 
'With the extra focus on quality and luxury, this integrated Hymer B-Class MasterLine I 780 is a premium camper. 
it is possible to devide the camper into different living areas such as master bedroom and dining area, or you can leave it as a open floor solution. 
Nothing has been spared on this brand new camper.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Hymer','MasterLine I 780 (2020)',' five persons', 
'With the extra focus on quality and luxury, this integrated Hymer B-Class MasterLine I 780 is a premium camper. 
it is possible to devide the camper into different living areas such as master bedroom and dining area, or you can leave it as a open floor solution. 
Nothing has been spared on this brand new camper.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Hymer','MasterLine I 780 (2020)',' five persons', 
'With the extra focus on quality and luxury, this integrated Hymer B-Class MasterLine I 780 is a premium camper. 
it is possible to devide the camper into different living areas such as master bedroom and dining area, or you can leave it as a open floor solution. 
Nothing has been spared on this brand new camper.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Hymer','MasterLine I 780 (2020)',' five persons', 
'With the extra focus on quality and luxury, this integrated Hymer B-Class MasterLine I 780 is a premium camper. 
it is possible to devide the camper into different living areas such as master bedroom and dining area, or you can leave it as a open floor solution. 
Nothing has been spared on this brand new camper.', '1100');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','A 68','six persons', '
Despite its compactness, this Sunlight A 68 is suitable for 6 persons. 
You should however pay a little attention to the length of the bed in the sofa arrangement, as it is only suitable for children under 10 years.', '1500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','A 68','six persons', '
Despite its compactness, this Sunlight A 68 is suitable for 6 persons. 
You should however pay a little attention to the length of the bed in the sofa arrangement, as it is only suitable for children under 10 years.', '1500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','A 68','six persons', '
Despite its compactness, this Sunlight A 68 is suitable for 6 persons. 
You should however pay a little attention to the length of the bed in the sofa arrangement, as it is only suitable for children under 10 years.', '1500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Sunlight','A 68','six persons', '
Despite its compactness, this Sunlight A 68 is suitable for 6 persons. 
You should however pay a little attention to the length of the bed in the sofa arrangement, as it is only suitable for children under 10 years.', '1500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Ford','Zefrio 675',' six persons', '
The Rollerteam Zefiro 675 is a luxury hi line 6 berth motorhome where up to 6 people can travel, sleep and enjoy their holiday', '1500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Ford','Zefrio 675',' six persons', '
The Rollerteam Zefiro 675 is a luxury hi line 6 berth motorhome where up to 6 people can travel, sleep and enjoy their holiday', '1500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Ford','Zefrio 675',' six persons', '
The Rollerteam Zefiro 675 is a luxury hi line 6 berth motorhome where up to 6 people can travel, sleep and enjoy their holiday', '1500');

INSERT INTO motorhome
(motorhome_brand,motorhome_model, motorhome_type, motorhome_description, motorhome_price) 
VALUES
('Ford','Zefrio 675',' six persons', '
The Rollerteam Zefiro 675 is a luxury hi line 6 berth motorhome where up to 6 people can travel, sleep and enjoy their holiday', '1500');
