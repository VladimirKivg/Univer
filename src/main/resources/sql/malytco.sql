CREATE TABLE `new_maliatko`.`kid_p1` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `father_name` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `birth_document_id` INT NULL,
  `address_id` INT NULL,
  `parent_one_id` INT NULL,
  `benefits` VARCHAR(45) NULL,
  `registr_to_queue` DATE NULL,
  `status_id` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`kid_p2` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `parent_two_id` INT NULL,
  `medical_date_id` INT NULL,
  `registr_to_garden_date` DATE NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(45) NULL,
  `citi` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `building_number` INT NULL,
  `apartament` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `father_name` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `phone` VARCHAR(45) NULL,
  `mail` VARCHAR(45) NULL,
  `pasport_id` INT NULL,
  `address_id` INT NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`kinder_garden` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NULL,
  `name` VARCHAR(45) NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `kinder_garden_id` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`user_to_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `role_is` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`user_to_group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `group_id` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`user_to_kinder_garden` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `kinder_garden_id` INT NULL,
  PRIMARY KEY (`id`));
  
  ALTER TABLE `new_maliatko`.`kid_p2` 
ADD COLUMN `kinder_garden_id` INT NULL AFTER `registr_to_garden_date`,
ADD COLUMN `group_id` INT NULL AFTER `kinder_garden_id`;

CREATE TABLE `new_maliatko`.`visiting` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kind_id` INT NULL,
  `visiting_date` DATE NULL,
  `presence` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `new_maliatko`.`receipt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kid_id` INT NULL,
  `visited_days` INT NULL,
  `cost_per_day` FLOAT NULL,
  `debt_overpay` FLOAT NULL,
  `sum_to_pay` FLOAT NULL,
  `pay_period` DATE NULL,
  `actual_pay` FLOAT NULL,
  PRIMARY KEY (`id`));
  
  
  CREATE TABLE `new_maliatko`.`kid_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kid_id` INT NULL,
  `kindergarten_id` INT NULL,
  `apply_date` DATETIME NULL,
  PRIMARY KEY (`id`));
  
  ALTER TABLE `new_maliatko`.`kid_p1` 
RENAME TO  `new_maliatko`.`kid` ;


ALTER TABLE `new_maliatko`.`kid_list` 
ADD INDEX `fk_kid_1_idx` (`kid_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`kid_list` 
ADD CONSTRAINT `fk_kid_1`
  FOREIGN KEY (`kid_id`)
  REFERENCES `new_maliatko`.`kid` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `new_maliatko`.`kinder_garden` 
RENAME TO  `new_maliatko`.`kindergarten` ;

ALTER TABLE `new_maliatko`.`kid_list` 
ADD INDEX `fk_kindergarten_1_idx` (`kindergarten_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`kid_list` 
ADD CONSTRAINT `fk_kindergarten_1`
  FOREIGN KEY (`kindergarten_id`)
  REFERENCES `new_maliatko`.`kindergarten` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

DROP TABLE `new_maliatko`.`kid_p2`;

ALTER TABLE `new_maliatko`.`kid` 
ADD COLUMN `parent_two_id` INT NULL DEFAULT NULL AFTER `status_id`,
ADD COLUMN `medical_data_id` INT NULL DEFAULT NULL AFTER `parent_two_id`,
ADD COLUMN `registr_to_garden_date` DATE NULL DEFAULT NULL AFTER `medical_data_id`,
ADD COLUMN `kindergarten_id` INT NULL DEFAULT NULL AFTER `registr_to_garden_date`,
ADD COLUMN `group_id` INT NULL DEFAULT NULL AFTER `kindergarten_id`;

ALTER TABLE `new_maliatko`.`group` 
CHANGE COLUMN `kinder_garden_id` `kindergarten_id` INT NULL DEFAULT NULL ;

ALTER TABLE `new_maliatko`.`group` 
ADD CONSTRAINT `fk_kindergarten_2`
  FOREIGN KEY (`kindergarten_id`)
  REFERENCES `new_maliatko`.`kindergarten` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `new_maliatko`.`kindergarten` 
ADD INDEX `fk_address_1_idx` (`address_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`kindergarten` 
ADD CONSTRAINT `fk_address_1`
  FOREIGN KEY (`address_id`)
  REFERENCES `new_maliatko`.`address` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `new_maliatko`.`kid` 
ADD INDEX `fk_address_2_idx` (`address_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`kid` 
ADD CONSTRAINT `fk_address_2`
  FOREIGN KEY (`address_id`)
  REFERENCES `new_maliatko`.`address` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `new_maliatko`.`user` 
ADD INDEX `fk_address_3_idx` (`address_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`user` 
ADD CONSTRAINT `fk_address_3`
  FOREIGN KEY (`address_id`)
  REFERENCES `new_maliatko`.`address` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `new_maliatko`.`kid` 
CHANGE COLUMN `birth_document_id` `birth_document` VARCHAR(45) NULL DEFAULT NULL ;

ALTER TABLE `new_maliatko`.`kid` 
ADD INDEX `fk_group_1_idx` (`group_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`kid` 
ADD CONSTRAINT `fk_group_1`
  FOREIGN KEY (`group_id`)
  REFERENCES `new_maliatko`.`group` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `new_maliatko`.`user_to_role` 
CHANGE COLUMN `role_is` `role_id` INT NULL DEFAULT NULL ;


ALTER TABLE `new_maliatko`.`user_to_role` 
ADD INDEX `fk_user_1_idx` (`user_id` ASC) VISIBLE,
ADD INDEX `fk_role_1_idx` (`role_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`user_to_role` 
ADD CONSTRAINT `fk_user_1`
  FOREIGN KEY (`user_id`)
  REFERENCES `new_maliatko`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_role_1`
  FOREIGN KEY (`role_id`)
  REFERENCES `new_maliatko`.`role` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `new_maliatko`.`user_to_kinder_garden` 
CHANGE COLUMN `kinder_garden_id` `kindergarten_id` INT NULL DEFAULT NULL , RENAME TO  `new_maliatko`.`user_to_kindergarten` ;


ALTER TABLE `new_maliatko`.`user_to_kindergarten` 
ADD INDEX `fk_user_2_idx` (`user_id` ASC) VISIBLE,
ADD INDEX `fk_kindergarten_3_idx` (`kindergarten_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`user_to_kindergarten` 
ADD CONSTRAINT `fk_user_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `new_maliatko`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_kindergarten_3`
  FOREIGN KEY (`kindergarten_id`)
  REFERENCES `new_maliatko`.`kindergarten` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `new_maliatko`.`user_to_group` 
ADD INDEX `fk_user_3_idx` (`user_id` ASC) VISIBLE,
ADD INDEX `fk_group_2_idx` (`group_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`user_to_group` 
ADD CONSTRAINT `fk_user_3`
  FOREIGN KEY (`user_id`)
  REFERENCES `new_maliatko`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_group_2`
  FOREIGN KEY (`group_id`)
  REFERENCES `new_maliatko`.`group` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `new_maliatko`.`kid` 
ADD INDEX `fk_user_4_idx` (`parent_one_id` ASC) VISIBLE,
ADD INDEX `fk_user_5_idx` (`parent_two_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`kid` 
ADD CONSTRAINT `fk_user_4`
  FOREIGN KEY (`parent_one_id`)
  REFERENCES `new_maliatko`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_user_5`
  FOREIGN KEY (`parent_two_id`)
  REFERENCES `new_maliatko`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `new_maliatko`.`kid` 
DROP COLUMN `kindergarten_id`;


ALTER TABLE `new_maliatko`.`kid` 
DROP COLUMN `registr_to_queue`,
CHANGE COLUMN `status_id` `status` VARCHAR(45) NULL DEFAULT NULL ;


ALTER TABLE `new_maliatko`.`visiting` 
ADD COLUMN `user_logger_id` INT NULL AFTER `presence`,
CHANGE COLUMN `kind_id` `kid_id` INT NULL DEFAULT NULL ;
 
 ALTER TABLE `new_maliatko`.`visiting` 
ADD INDEX `fk_kid_2_idx` (`kid_id` ASC) VISIBLE,
ADD INDEX `fk_user_6_idx` (`user_logger_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`visiting` 
ADD CONSTRAINT `fk_kid_2`
  FOREIGN KEY (`kid_id`)
  REFERENCES `new_maliatko`.`kid` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_user_6`
  FOREIGN KEY (`user_logger_id`)
  REFERENCES `new_maliatko`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `new_maliatko`.`receipt` 
ADD INDEX `fk_kid_3_idx` (`kid_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`receipt` 
ADD CONSTRAINT `fk_kid_3`
  FOREIGN KEY (`kid_id`)
  REFERENCES `new_maliatko`.`kid` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `new_maliatko`.`receipt` 
DROP COLUMN `actual_pay`;

CREATE TABLE `new_maliatko`.`payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NULL,
  `bank_payment_number` VARCHAR(45) NULL,
  `description` VARCHAR(150) NULL,
  `paymentcol` VARCHAR(45) NULL,
  `pay_amount` FLOAT NULL DEFAULT NULL,
  `register_date` DATETIME NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `new_maliatko`.`receipt` 
ADD COLUMN `payment_id` INT NULL AFTER `pay_period`;

ALTER TABLE `new_maliatko`.`receipt` 
ADD INDEX `fk_payment_1_idx` (`payment_id` ASC) VISIBLE;
;
ALTER TABLE `new_maliatko`.`receipt` 
ADD CONSTRAINT `fk_payment_1`
  FOREIGN KEY (`payment_id`)
  REFERENCES `new_maliatko`.`payment` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


  