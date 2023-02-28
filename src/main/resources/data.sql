drop table if exists loan cascade;
create table loan (
    loan_number bigserial not null,
    amount_paid bigint,
    created_date date,
    customer_id bigint,
    loan_type varchar(255),
    outstanding_amount bigint,
    start_date date,
    total_loan bigint,
    primary key (loan_number)
                  );

INSERT INTO loan ( customer_id, start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_date)
VALUES ( 1, NOW()::DATE-250, 'Home', 200000, 50000, 150000, NOW()::DATE-250);

INSERT INTO loan ( customer_id, start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_date)
VALUES ( 1, NOW()::DATE-376, 'Vehicle', 40000, 10000, 30000, NOW()::DATE-376);

INSERT INTO loan ( customer_id, start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_date)
VALUES ( 1, NOW()::DATE-549, 'Home', 50000, 10000, 40000, NOW()::DATE-549);

INSERT INTO loan ( customer_id, start_date, loan_type, total_loan, amount_paid, outstanding_amount, created_date)
VALUES ( 1, NOW()::DATE-122, 'Personal', 10000, 3500, 6500, NOW()::DATE-122);