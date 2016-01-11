-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`client` ;

CREATE TABLE IF NOT EXISTS `mydb`.`client` (
  `client_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `telephone` INT(9) NOT NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE INDEX `telephone_UNIQUE` (`telephone` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`employee` ;

CREATE TABLE IF NOT EXISTS `mydb`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `joining_date` DATE NOT NULL,
  `salary` DOUBLE NOT NULL,
  `ssn` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ssn` (`ssn` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`material` ;

CREATE TABLE IF NOT EXISTS `mydb`.`material` (
  `mateiral_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `designation` VARCHAR(45) NOT NULL,
  `buy_price` FLOAT NULL DEFAULT NULL,
  `sell_price` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`mateiral_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`userprofile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`userprofile` ;

CREATE TABLE IF NOT EXISTS `mydb`.`userprofile` (
  `profile_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `profile_designation` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`profile_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_password` VARCHAR(100) NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `user_email` VARCHAR(50) NOT NULL,
  `user_telephone` BIGINT(9) NULL DEFAULT NULL,
  `user_nif` BIGINT(9) NULL DEFAULT NULL,
  `user_address` VARCHAR(200) NULL DEFAULT NULL,
  `userprofile_profile_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `userprofile_profile_id`),
  INDEX `fk_user_userprofile1_idx` (`userprofile_profile_id` ASC),
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC),
  CONSTRAINT `fk_user_userprofile1`
    FOREIGN KEY (`userprofile_profile_id`)
    REFERENCES `mydb`.`userprofile` (`profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`repairstatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`repairstatus` ;

CREATE TABLE IF NOT EXISTS `mydb`.`repairstatus` (
  `status_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `status_designation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`status_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`repair`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`repair` ;

CREATE TABLE IF NOT EXISTS `mydb`.`repair` (
  `repair_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `user_user_id` BIGINT(20) NOT NULL,
  `client_client_id` BIGINT(20) NOT NULL,
  `repair_status_status_id` BIGINT(20) NOT NULL,
  `observation` VARCHAR(500) NULL DEFAULT NULL,
  `hours_spend` INT(3) NULL DEFAULT NULL,
  `price` FLOAT NULL DEFAULT NULL,
  `serial_number` VARCHAR(25) NULL,
  PRIMARY KEY (`repair_id`, `user_user_id`, `client_client_id`, `repair_status_status_id`),
  INDEX `fk_repair_app_user1_idx` (`user_user_id` ASC),
  INDEX `fk_repair_client1_idx` (`client_client_id` ASC),
  INDEX `fk_repair_repair_status1_idx` (`repair_status_status_id` ASC),
  CONSTRAINT `fk_repair_app_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `mydb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_repair_client1`
    FOREIGN KEY (`client_client_id`)
    REFERENCES `mydb`.`client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_repair_repair_status1`
    FOREIGN KEY (`repair_status_status_id`)
    REFERENCES `mydb`.`repairstatus` (`status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`materialused`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`materialused` ;

CREATE TABLE IF NOT EXISTS `mydb`.`materialused` (
  `repair_repair_id` BIGINT(20) NOT NULL,
  `material_mateiral_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`repair_repair_id`, `material_mateiral_id`),
  INDEX `fk_repair_has_material_material1_idx` (`material_mateiral_id` ASC),
  INDEX `fk_repair_has_material_repair1_idx` (`repair_repair_id` ASC),
  CONSTRAINT `fk_repair_has_material_material1`
    FOREIGN KEY (`material_mateiral_id`)
    REFERENCES `mydb`.`material` (`mateiral_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_repair_has_material_repair1`
    FOREIGN KEY (`repair_repair_id`)
    REFERENCES `mydb`.`repair` (`repair_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
