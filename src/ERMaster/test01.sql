
/* Drop Triggers */

DROP TRIGGER TRI_customer_custid;



/* Drop Tables */

--DROP TABLE orders CASCADE CONSTRAINTS;
--DROP TABLE customer CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_customer_custid;




/* Create Sequences */

CREATE SEQUENCE SEQ_customer_custid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE customer100
(
	custid number NOT NULL,
	name varchar2(50),
	address varchar2(50),
	phone varchar2(50),
	PRIMARY KEY (custid)
);


CREATE TABLE orders100
(
	orderid number NOT NULL,
	custid number NOT NULL,
	bookid number NOT NULL,
	saleprice number,
	orderdate date,
	PRIMARY KEY (orderid)
);


select * from customer;


/* Create Foreign Keys */

ALTER TABLE orders
	ADD FOREIGN KEY (custid)
	REFERENCES customer (custid)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_customer_custid BEFORE INSERT ON customer
FOR EACH ROW
BEGIN
	SELECT SEQ_customer_custid.nextval
	INTO :new.custid
	FROM dual;
END;

/




