CREATE  TABLE `employee_table` (
  `employee_Id` INT NOT NULL AUTO_INCREMENT ,
  `employee_name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `gender` VARCHAR(10) NULL ,
  `salary` DOUBLE NULL ,
  PRIMARY KEY (`employee_Id`) );