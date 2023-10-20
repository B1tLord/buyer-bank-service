CREATE TABLE IF NOT EXISTS payment (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_id int not null references client_account(id),
    trans_date timestamp not null,
    amount decimal(18,2) not null,
    description varchar(2000),
    reference varchar(255)
);

CREATE UNIQUE INDEX payment_reference_unique ON payment(reference);
