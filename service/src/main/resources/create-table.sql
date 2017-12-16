drop table  if exists sales;
drop table if exists `order`;
drop table  if exists price;
drop table  if exists stock;
drop table  if exists crop;
drop table  if exists customer;
drop table  if exists address;



create table crop (
	id varchar(255) NOT NULL,
	code varchar(255) unique key,
	name varchar(255) NOT NULL,
	`status` varchar(255) DEFAULT 'ACTIVE',
	description varchar(255) DEFAULT NULL,
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);



create table price(
	id varchar(255) NOT NULL,
	crop_code varchar(255) NOT NULL,
	`status` varchar(255) DEFAULT 'ACTIVE',
	mrp DECIMAL(10, 2) NOT NULL DEFAULT '0.00',
	unit_of_consumption varchar(255) DEFAULT 'kg',
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
	primary key(id),
	CONSTRAINT `FK_price_crop_ref` FOREIGN KEY (`crop_code`) REFERENCES `crop` (`code`)
);


create table `order`(
	id varchar(255) NOT NULL,
	crop_id varchar(255) NOT NULL,
	quantity DECIMAL(5, 2) NOT NULL DEFAULT '0.00',
	price_id varchar(255) NOT NULL,
	`status` varchar(255) DEFAULT 'ACTIVE',
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
	primary key(id),
	CONSTRAINT `FK_order_crop_ref` FOREIGN KEY (`crop_id`) REFERENCES `crop` (`id`),
	CONSTRAINT `FK_order_price_ref` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`)
);


CREATE TABLE `address` (
  `id` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `line_one` varchar(255) NOT NULL,
  `line_three` varchar(255) DEFAULT NULL,
  `line_two` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table customer(
	id varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	phone varchar(255) NOT NULL,
	email varchar(255) DEFAULT NULL,
	address_id varchar(255) DEFAULT NULL,
	primary key (id),
	CONSTRAINT `FK_customer_address_ref` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
);



create table sales(
	id varchar(255) NOT NULL,
	customer_id varchar(255) NOT NULL,
	order_id varchar(255) NOT NULL,
	status varchar(255) DEFAULT 'ACTIVE',
	address_id varchar(255) NOT NULL,
	discount DECIMAL(2,2) NOT NULL DEFAULT '0.00',
	selling_price DECIMAL(10,2) NOT NULL DEFAULT '0.00',
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
	primary key (id),
	CONSTRAINT `FK_sale_cust_ref` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
	CONSTRAINT `FK_sale_order_ref` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
	CONSTRAINT `FK_sale_address_ref` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
);


create table stock(
	id varchar(255) NOT NULL,
	crop_id varchar(255) NOT NULL,
	out_of_stock bool DEFAULT 1,
	quantity DECIMAL(5, 2) NOT NULL DEFAULT '0.00',
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
	primary key(id),
	CONSTRAINT `FK_stock_crop_ref` FOREIGN KEY (`crop_id`) REFERENCES `crop` (`id`)
);
