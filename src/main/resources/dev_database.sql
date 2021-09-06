-- -----------------------------------------------------
-- Schema dev_database
-- -----------------------------------------------------
CREATE database `dev_database`;

USE `dev_database`;

-- -----------------------------------------------------
-- Table `dev_database`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dev_database`.`client`;
CREATE TABLE IF NOT EXISTS `dev_database`.`client`(
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(20) NOT NULL,
  `document_type` VARCHAR(20) NOT NULL,
  `document_number` VARCHAR(20) UNIQUE NOT NULL,
  `birth_date` DATETIME NULL DEFAULT NULL,
  `date_create` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `username_create` VARCHAR(30) NULL,
  `date_update` DATETIME ON UPDATE CURRENT_TIMESTAMP,
  `username_update` VARCHAR(30) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `dev_database`.`mobile_line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dev_database`.`mobile_line`;
CREATE TABLE IF NOT EXISTS `dev_database`.`mobile_line` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `client_id` BIGINT(11) NOT NULL,
  `cell_phone_number` VARCHAR(30) NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `plan_name` VARCHAR(20) NOT NULL,
  `date_create` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `username_create` VARCHAR(30) NULL,
  `date_update` DATETIME ON UPDATE CURRENT_TIMESTAMP,
  `username_update` VARCHAR(30) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fkey_client_mobile_line`
    FOREIGN KEY (`client_id`)
    REFERENCES `dev_database`.`client` (`id`)
  ON DELETE CASCADE);


-- -----------------------------------------------------
-- Table `dev_database`.`offer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dev_database`.`offer`;
CREATE TABLE IF NOT EXISTS `dev_database`.`offer` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `mobile_line_id` BIGINT(11) NOT NULL,
  `code` VARCHAR(30) NOT NULL,
  `description` VARCHAR(20) NOT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `end_date` DATETIME NULL DEFAULT NULL,
  `date_create` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `username_create` VARCHAR(30) NULL,
  `date_update` DATETIME ON UPDATE CURRENT_TIMESTAMP,
  `username_update` VARCHAR(30) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fkey_mobile_line_offer`
    FOREIGN KEY (`mobile_line_id`)
    REFERENCES `dev_database`.`mobile_line` (`id`)
  ON DELETE CASCADE);
