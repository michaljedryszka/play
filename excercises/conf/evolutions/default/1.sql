# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_computer primary key (id))
;

create table o_order (
  id                        bigint not null,
  created                   timestamp,
  shipped                   timestamp,
  discounted_price          decimal(38),
  sales_man_id              bigint,
  constraint pk_o_order primary key (id))
;

create table order_item (
  id                        bigint not null,
  order_id                  bigint not null,
  amount                    bigint,
  stock_item_id             bigint,
  constraint pk_order_item primary key (id))
;

create table reseller (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_reseller primary key (id))
;

create table reseller_stock_item (
  id                        bigint not null,
  reseller_id               bigint not null,
  price                     decimal(38),
  computer_id               bigint,
  constraint pk_reseller_stock_item primary key (id))
;

create table sales_man (
  id                        bigint not null,
  name                      varchar(255),
  reseller_id               bigint,
  constraint pk_sales_man primary key (id))
;


create table reseller_company (
  reseller_id                    bigint not null,
  company_id                     bigint not null,
  constraint pk_reseller_company primary key (reseller_id, company_id))
;
create sequence company_seq;

create sequence computer_seq;

create sequence o_order_seq;

create sequence order_item_seq;

create sequence reseller_seq;

create sequence reseller_stock_item_seq;

create sequence sales_man_seq;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);
alter table o_order add constraint fk_o_order_salesMan_2 foreign key (sales_man_id) references sales_man (id) on delete restrict on update restrict;
create index ix_o_order_salesMan_2 on o_order (sales_man_id);
alter table order_item add constraint fk_order_item_o_order_3 foreign key (order_id) references o_order (id) on delete restrict on update restrict;
create index ix_order_item_o_order_3 on order_item (order_id);
alter table order_item add constraint fk_order_item_stockItem_4 foreign key (stock_item_id) references reseller_stock_item (id) on delete restrict on update restrict;
create index ix_order_item_stockItem_4 on order_item (stock_item_id);
alter table reseller_stock_item add constraint fk_reseller_stock_item_reselle_5 foreign key (reseller_id) references reseller (id) on delete restrict on update restrict;
create index ix_reseller_stock_item_reselle_5 on reseller_stock_item (reseller_id);
alter table reseller_stock_item add constraint fk_reseller_stock_item_compute_6 foreign key (computer_id) references computer (id) on delete restrict on update restrict;
create index ix_reseller_stock_item_compute_6 on reseller_stock_item (computer_id);
alter table sales_man add constraint fk_sales_man_reseller_7 foreign key (reseller_id) references reseller (id) on delete restrict on update restrict;
create index ix_sales_man_reseller_7 on sales_man (reseller_id);



alter table reseller_company add constraint fk_reseller_company_reseller_01 foreign key (reseller_id) references reseller (id) on delete restrict on update restrict;

alter table reseller_company add constraint fk_reseller_company_company_02 foreign key (company_id) references company (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists computer;

drop table if exists o_order;

drop table if exists order_item;

drop table if exists reseller;

drop table if exists reseller_company;

drop table if exists reseller_stock_item;

drop table if exists sales_man;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists computer_seq;

drop sequence if exists o_order_seq;

drop sequence if exists order_item_seq;

drop sequence if exists reseller_seq;

drop sequence if exists reseller_stock_item_seq;

drop sequence if exists sales_man_seq;

