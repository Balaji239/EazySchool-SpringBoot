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

--MESSAGE TABLE
INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Adam','2176436587','zadam@gmail.com','Regarding a job','Wanted to join as teacher','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Zara','3412654387','zarabaig@hotmail.com','Course Admission','Wanted to join a course','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Marques','8547643673','kmarques@yahoo.com','Course Review','Review of Development course','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Shyam','4365328776','gshyam@gmail.com','Admission Query','Need to talk about admission','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('John','5465765453','doejohn@gmail.com','Holiday Query','Query on upcoming holidays','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Taniya Bell','3987463827','belltaniya@gmail.com','Child Scholarship','Can my child get scholarship?','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Willie Lara','4568764801','476lara@gmail.com','Need Admission','My son need an admission','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Jonathan Parsons','4321768902','jonathan.parsons@gmail.com','Course feedback','Music course is good','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Cloe Rubio','9854438719','rubio987@gmail.com','Correct Date of Birth','My Child DOB needs to be corrected','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Camilla Stein','6545433254','camillas@gmail.com','Transport Query','Is Transport provided?','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Lizeth Gross','4678783434','grossliz@yahoo.com','Progress report','Please send progress report','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Yael Howe','1243563254','howeyael@gmail.com','Certificate Query','Need Certificate hard copy','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Ian Moreno','2312231223','moreno.ian@gmail.com','Food feedback','Food quality can be improved','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Desirae Ibarra','3445235667','ibarrades@gmail.com','Traffic Complaint','Traffic around school can be controlled','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Oswaldo Jarvis','4556121265','jarvissmile@hotmail.com','Study Tour','Study tour details needed','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Miah Perkins','2367784512','perkinsmiah@hotmail.com','Vaccination Support','Vaccination center in the school','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Zion Bolton','8990678900','boltzion@gmail.com','Course fees','Pls share fees of music course','OPEN',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`,`mobile_num`,`email`,`subject`,`message`,`status`,`created_at`, `created_by`)
  VALUES ('Dominik Tanner','4556127834','tannerdominik@gmail.com','Games schedule','Provide Summer games schedule','OPEN',CURDATE(),'DBA');

