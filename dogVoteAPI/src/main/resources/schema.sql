-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema numble
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `numble` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `numble` ;

-- -----------------------------------------------------
-- Table `numble`.`dogs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `numble`.`dogs` (
                                               `id` BIGINT NOT NULL AUTO_INCREMENT,
                                               `description` VARCHAR(255) NOT NULL,
    `detail` VARCHAR(10000) NOT NULL,
    `image_url` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `vote_count` BIGINT NULL DEFAULT 0,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
