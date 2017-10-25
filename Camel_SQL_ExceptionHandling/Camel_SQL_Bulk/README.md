A Camel application that demonstrates:
- Use of MySQL and the Camel SQL Component
- Route-specific Exception handling
- SQL Component bulk processing
- Splitting an errant bulk package to highlight the bad entry
- External properties file read by route


Can use MySQL on Docker / jdbc:mysql://111.11.0.2:3306
CREATE DATABASE ricks_test_db;
create user 'rick'@'%' identified by 'password';
GRANT ALL PRIVILEGES ON *.* TO 'rick'@'%' WITH GRANT OPTION;
use ricks_test_db;
CREATE TABLE a_test_tbl (id int, msg VARCHAR(20));
INSERT INTO a_test_tbl(id, msg) VALUES (1, 'This is a message');
