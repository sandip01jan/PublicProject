create table reward
(
   id integer not null,
   cust_id integer not null,
   trx_date date not null,
   trx_amount integer not null,
   points_earned integer not null,
   primary key(id)
);