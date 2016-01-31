Vytvoøení tabulek v postgresql databázi, aby aplikace byla funkèní:
# vytvoreni databaze
psql -U postgre -W
CREATE DATABASE morosystems TEMPLATE template0 ENCODING 'UTF8';
# vytvoreni schematu
\connect morosystems
CREATE SCHEMA morosystems;
CREATE USER morosystems PASSWORD 'morosystems';
GRANT ALL ON SCHEMA morosystems TO morosystems;
GRANT ALL ON ALL TABLES IN SCHEMA morosystems TO morosystems;
\q


# vytvoreni tabulek
psql -d morosystems -U morosystems -W

CREATE TABLE morosystems.readerTable
(id SERIAL NOT NULL PRIMARY KEY,
firstname VARCHAR(256) NOT NULL,
lastname VARCHAR(256) NOT NULL,
email VARCHAR(256) NOT NULL,
telephone VARCHAR(256) NOT NULL
);

CREATE TABLE morosystems.bookTable
(id SERIAL PRIMARY KEY,
userid INTEGER NOT NULL,
title VARCHAR(256) NOT NULL,
description VARCHAR(256) NOT NULL,
FOREIGN KEY (userid) REFERENCES readerTable (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE morosystems.accountTable
(id SERIAL PRIMARY KEY,
userid INTEGER NOT NULL,
name VARCHAR(256) NOT NULL,
accountPrefix VARCHAR(8) NOT NULL,
accountNumber VARCHAR(32) NOT NULL,
bankCode VARCHAR(8) NOT NULL,
FOREIGN KEY (userid) REFERENCES readerTable (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE morosystems.users_books_table
(userid INTEGER NOT NULL,
bookid INTEGER NOT NULL,
PRIMARY KEY (userid, bookid),
FOREIGN KEY (userid) REFERENCES readerTable (id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (bookid) REFERENCES bookTable (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE morosystems.user_accounts_table
(userid INTEGER NOT NULL,
accountid INTEGER NOT NULL,
PRIMARY KEY (userid, accountid),
FOREIGN KEY (userid) REFERENCES readerTable (id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (accountid) REFERENCES bookTable (id) ON DELETE CASCADE ON UPDATE CASCADE
);

# vlozeni testovacich dat
# READERTABLE
INSERT INTO morosystems.readerTable (firstname, lastname, email, telephone) VALUES ('Pepa', 'Dvorak', 'pepadvorak@dvorakovci.cz', '789456123');
INSERT INTO morosystems.readerTable (firstname, lastname, email, telephone) VALUES ('Franta', 'Jednicka', 'franta.jednicka2k@mistr.cz', '123456789');
INSERT INTO morosystems.readerTable (firstname, lastname, email, telephone) VALUES ('Alois', 'Makak', 'makak@srozumem.cz', '789000000');

INSERT INTO morosystems.bookTable (userid,title,description) VALUES (1, 'Kniha1', 'Dobra kniha');
INSERT INTO morosystems.bookTable (userid,title,description) VALUES (1, 'Kniha2', 'Spatna kniha');
INSERT INTO morosystems.bookTable (userid,title,description) VALUES (1, 'Kniha3', 'Nic moc kniha');
INSERT INTO morosystems.bookTable (userid,title,description) VALUES (2, 'Kniha4', 'Dobra kniha');
INSERT INTO morosystems.bookTable (userid,title,description) VALUES (2, 'Kniha5', 'Spatna kniha');
INSERT INTO morosystems.bookTable (userid,title,description) VALUES (3, 'Kniha6', 'Nic moc kniha');

INSERT INTO morosystems.accountTable (userid,name,accountprefix,accountnumber,bankcode) VALUES (1, 'Bank account1', '0000', '1232456789', '0800');
INSERT INTO morosystems.accountTable (userid,name,accountprefix,accountnumber,bankcode) VALUES (1, 'Bank account2', '1111', '9876543210', '0100');
INSERT INTO morosystems.accountTable (userid,name,accountprefix,accountnumber,bankcode) VALUES (2, 'Bank account1', 'AAAA', '1232456789', '0800');
INSERT INTO morosystems.accountTable (userid,name,accountprefix,accountnumber,bankcode) VALUES (2, 'Bank account2', 'BBBB', '9876543210', '0100');







select t1.lastname, t2.title, t3.accountprefix
from readertable t1 inner join booktable t2 on t1.id = t2.userid
inner join accounttable t3 on t1.id=t3.userid;
