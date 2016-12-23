-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nfreports_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nfreports_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nfreports_db` DEFAULT CHARACTER SET utf8 ;
USE `nfreports_db` ;

-- -----------------------------------------------------
-- Table `nfreports_db`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`category` (
  `id_category` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`master` (
  `id_master` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_master`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`product` (
  `id_product` INT NOT NULL,
  `serial_number` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `description` MEDIUMTEXT NULL,
  `price` FLOAT NULL,
  `category_id_category` INT NOT NULL,
  `master_id_master` INT NOT NULL,
  PRIMARY KEY (`id_product`, `category_id_category`, `master_id_master`),
  INDEX `fk_product_category1_idx` (`category_id_category` ASC),
  INDEX `fk_product_master1_idx` (`master_id_master` ASC),
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_id_category`)
    REFERENCES `nfreports_db`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_master1`
    FOREIGN KEY (`master_id_master`)
    REFERENCES `nfreports_db`.`master` (`id_master`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`invoice` (
  `id_invoice` INT NOT NULL,
  `id_customer` INT NULL,
  `id_address` INT NULL,
  `id_payment_method` INT NULL,
  PRIMARY KEY (`id_invoice`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`customer` (
  `id_customer` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `doc_number` INT NULL,
  `state_registration` VARCHAR(45) NULL,
  `invoice_id_invoice` INT NOT NULL,
  PRIMARY KEY (`id_customer`, `invoice_id_invoice`),
  INDEX `fk_customer_invoice1_idx` (`invoice_id_invoice` ASC),
  CONSTRAINT `fk_customer_invoice1`
    FOREIGN KEY (`invoice_id_invoice`)
    REFERENCES `nfreports_db`.`invoice` (`id_invoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`address` (
  `id_address` INT NOT NULL,
  `street` VARCHAR(45) NULL,
  `number` VARCHAR(45) NULL,
  `neighborhood` VARCHAR(45) NULL,
  `id_city` VARCHAR(45) NULL,
  `id_state` VARCHAR(45) NULL,
  PRIMARY KEY (`id_address`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`phone` (
  `id_phone` INT NOT NULL,
  `number` VARCHAR(45) NULL,
  `customer_id_customer` INT NOT NULL,
  PRIMARY KEY (`id_phone`, `customer_id_customer`),
  INDEX `fk_phone_customer1_idx` (`customer_id_customer` ASC),
  CONSTRAINT `fk_phone_customer1`
    FOREIGN KEY (`customer_id_customer`)
    REFERENCES `nfreports_db`.`customer` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`payment_method`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`payment_method` (
  `id_payment_method` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `observations` LONGTEXT NULL,
  `active` TINYINT(1) NULL,
  `invoice_id_invoice` INT NOT NULL,
  PRIMARY KEY (`id_payment_method`, `invoice_id_invoice`),
  INDEX `fk_payment_method_invoice1_idx` (`invoice_id_invoice` ASC),
  CONSTRAINT `fk_payment_method_invoice1`
    FOREIGN KEY (`invoice_id_invoice`)
    REFERENCES `nfreports_db`.`invoice` (`id_invoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`product_has_invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`product_has_invoice` (
  `product_id_product` INT NOT NULL,
  `invoice_id_invoice` INT NOT NULL,
  PRIMARY KEY (`product_id_product`, `invoice_id_invoice`),
  INDEX `fk_product_has_invoice_invoice1_idx` (`invoice_id_invoice` ASC),
  INDEX `fk_product_has_invoice_product1_idx` (`product_id_product` ASC),
  CONSTRAINT `fk_product_has_invoice_product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `nfreports_db`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_invoice_invoice1`
    FOREIGN KEY (`invoice_id_invoice`)
    REFERENCES `nfreports_db`.`invoice` (`id_invoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`instalment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`instalment` (
  `id_instalment` INT NOT NULL,
  `value` VARCHAR(45) NULL,
  `due_date` DATE NULL,
  PRIMARY KEY (`id_instalment`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`instalment_has_payment_method`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`instalment_has_payment_method` (
  `instalment_id_instalment` INT NOT NULL,
  `payment_method_id_payment_method` INT NOT NULL,
  `payment_method_invoice_id_invoice` INT NOT NULL,
  PRIMARY KEY (`instalment_id_instalment`, `payment_method_id_payment_method`, `payment_method_invoice_id_invoice`),
  INDEX `fk_instalment_has_payment_method_payment_method1_idx` (`payment_method_id_payment_method` ASC, `payment_method_invoice_id_invoice` ASC),
  INDEX `fk_instalment_has_payment_method_instalment1_idx` (`instalment_id_instalment` ASC),
  CONSTRAINT `fk_instalment_has_payment_method_instalment1`
    FOREIGN KEY (`instalment_id_instalment`)
    REFERENCES `nfreports_db`.`instalment` (`id_instalment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instalment_has_payment_method_payment_method1`
    FOREIGN KEY (`payment_method_id_payment_method` , `payment_method_invoice_id_invoice`)
    REFERENCES `nfreports_db`.`payment_method` (`id_payment_method` , `invoice_id_invoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`customer_has_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`customer_has_address` (
  `customer_id_customer` INT NOT NULL,
  `customer_invoice_id_invoice` INT NOT NULL,
  `address_id_address` INT NOT NULL,
  PRIMARY KEY (`customer_id_customer`, `customer_invoice_id_invoice`, `address_id_address`),
  INDEX `fk_customer_has_address_address1_idx` (`address_id_address` ASC),
  INDEX `fk_customer_has_address_customer1_idx` (`customer_id_customer` ASC, `customer_invoice_id_invoice` ASC),
  CONSTRAINT `fk_customer_has_address_customer1`
    FOREIGN KEY (`customer_id_customer` , `customer_invoice_id_invoice`)
    REFERENCES `nfreports_db`.`customer` (`id_customer` , `invoice_id_invoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_address_address1`
    FOREIGN KEY (`address_id_address`)
    REFERENCES `nfreports_db`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nfreports_db`.`invoice_has_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nfreports_db`.`invoice_has_address` (
  `invoice_id_invoice` INT NOT NULL,
  `address_id_address` INT NOT NULL,
  PRIMARY KEY (`invoice_id_invoice`, `address_id_address`),
  INDEX `fk_invoice_has_address_address1_idx` (`address_id_address` ASC),
  INDEX `fk_invoice_has_address_invoice1_idx` (`invoice_id_invoice` ASC),
  CONSTRAINT `fk_invoice_has_address_invoice1`
    FOREIGN KEY (`invoice_id_invoice`)
    REFERENCES `nfreports_db`.`invoice` (`id_invoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_has_address_address1`
    FOREIGN KEY (`address_id_address`)
    REFERENCES `nfreports_db`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
