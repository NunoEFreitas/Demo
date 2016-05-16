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
-- Table `mydb`.`UserType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`UserType` ;

CREATE TABLE IF NOT EXISTS `mydb`.`UserType` (
  `idUserType` INT NOT NULL AUTO_INCREMENT,
  `descriptionUserType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUserType`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `nameUser` VARCHAR(45) NOT NULL,
  `addressUser` VARCHAR(45) NOT NULL,
  `phoneUser` VARCHAR(45) NULL,
  `emailUser` VARCHAR(45) NOT NULL,
  `passwordUser` VARCHAR(45) NOT NULL,
  `UserType_idUserType` INT NOT NULL,
  `nifUser` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_User_UserType_idx` (`UserType_idUserType` ASC),
  CONSTRAINT `fk_User_UserType`
    FOREIGN KEY (`UserType_idUserType`)
    REFERENCES `mydb`.`UserType` (`idUserType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrderStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`OrderStatus` ;

CREATE TABLE IF NOT EXISTS `mydb`.`OrderStatus` (
  `idOrderStatus` INT NOT NULL AUTO_INCREMENT,
  `descriptionOrderStatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idOrderStatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `idOrder` INT NOT NULL AUTO_INCREMENT,
  `dateInOrder` DATE NOT NULL,
  `dateOutOrder` DATE NULL,
  `OrderStatus_idOrderStatus` INT NOT NULL,
  `User_idUser` INT NOT NULL,
  `priceOrder` DECIMAL NULL,
  PRIMARY KEY (`idOrder`, `OrderStatus_idOrderStatus`, `User_idUser`),
  INDEX `fk_Order_OrderStatus1_idx` (`OrderStatus_idOrderStatus` ASC),
  INDEX `fk_Order_User1_idx` (`User_idUser` ASC),
  CONSTRAINT `fk_Order_OrderStatus1`
    FOREIGN KEY (`OrderStatus_idOrderStatus`)
    REFERENCES `mydb`.`OrderStatus` (`idOrderStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `mydb`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Product` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT,
  `descriptionProduct` VARCHAR(45) NOT NULL,
  `priceProduct` DECIMAL NULL,
  `photoProduct` VARCHAR(45) NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrderedProduct`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`OrderedProduct` ;

CREATE TABLE IF NOT EXISTS `mydb`.`OrderedProduct` (
  `Quantity` INT NOT NULL,
  `Order_idOrder` INT NOT NULL,
  `Product_idProduct` INT NOT NULL,
  PRIMARY KEY (`Order_idOrder`, `Product_idProduct`),
  INDEX `fk_OrderedProduct_Product1_idx` (`Product_idProduct` ASC),
  CONSTRAINT `fk_OrderedProduct_Order1`
    FOREIGN KEY (`Order_idOrder`)
    REFERENCES `mydb`.`Order` (`idOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderedProduct_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `mydb`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sale` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sale` (
  `idSale` INT NOT NULL AUTO_INCREMENT,
  `dateSale` VARCHAR(45) NOT NULL,
  `totalPriceSale` DECIMAL NOT NULL,
  PRIMARY KEY (`idSale`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
