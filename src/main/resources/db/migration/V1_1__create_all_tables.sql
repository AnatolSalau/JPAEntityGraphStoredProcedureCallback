
create table client
(
      id            bigserial
            primary key,
      full_name     varchar(255),
      mobile_number varchar(255)
);

alter table client
      owner to postgres;

create table email_address
(
      id        bigserial
            primary key,
      email     varchar(255),
      client_id bigint
            constraint fkdh43nqaxsxkf6wt5k6orm6ipp
                  references client
);

alter table email_address
      owner to postgres;

