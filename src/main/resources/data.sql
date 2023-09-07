--HOLIDAY TABLE
INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Oct 31 ','Halloween','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Nov 24 ','Thanksgiving Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Dec 25 ','Christmas','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' July 4 ','Independence Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Sep 5 ','Labor Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holiday_date`,`reason`,`type`,`created_at`, `created_by`)
  VALUES (' Nov 11 ','Veterans Day','FEDERAL',CURDATE(),'DBA');

--ROLE TABLE
INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('STUDENT',CURDATE(),'DBA');

--PERSON TABLE
INSERT INTO `PERSON` (`name`,`email`, `mobile_number`,`password`,`role_id`,`created_at`, `created_by`)
  VALUES ('Admin1','admin1@gmail.com','1234567891','$2a$12$L6w7QUqOzcskblGj4vkom.AIH0KHXAbWCmd.1ceZnDvyR1OjvAiQG',1,CURDATE(),'DBA');

INSERT INTO `PERSON` (`name`,`email`, `mobile_number`,`password`,`role_id`,`created_at`, `created_by`)
  VALUES ('Balaji','baji239@gmail.com','8310850942','$2a$12$M1M1Kh80T6RVedVhM7nsW.u57BM8igW4cYgU1jLUf5rO0lbEFmx/a',2,CURDATE(),'DBA');


