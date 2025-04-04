create table transactions (
    id serial,
    amount numeric,
    category varchar,
    description varchar,
    isIncome bool,
    date varchar,
    constraint transaction_pk primary key (id)
)