alter table transactions
rename column transactionDate to date;

alter table transactions
rename column isIncome to is_income;