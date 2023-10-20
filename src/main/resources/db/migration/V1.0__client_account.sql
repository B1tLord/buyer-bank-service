CREATE TABLE IF NOT EXISTS client_account (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_name varchar(20),
    account_no varchar(20),
    balance decimal(18,2)

);

CREATE UNIQUE INDEX client_account_no ON client_account(account_no);


INSERT INTO client_account VALUES (1, 'Joseph Novak', '10200000001', 5600.00);
INSERT INTO client_account VALUES (2, 'Barbora Novotna', '20400000002', 150.00);
