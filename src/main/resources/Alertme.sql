
CREATE TABLE IF NOT EXISTS public.users
(
  id  SERIAL PRIMARY KEY NOT NULL,
  n_number VARCHAR(60)        NOT NULL UNIQUE,
  email_id VARCHAR(60)  NOT NULL,
  nationality VARCHAR(60)  not null,
  passport_nbr VARCHAR(10) not null
);

CREATE TABLE IF NOT EXISTS public.gnib_info
(
  id              SERIAL PRIMARY KEY                   NOT NULL,
  user_id         INTEGER REFERENCES users (id)        NOT NULL,
  gnib_nbr numeric not NULL,
  stamp VARCHAR(3) not null,
  validFrom Date not null,
  validTo Date not null
);

CREATE TABLE IF NOT EXISTS public.visa_info
(
  id              SERIAL PRIMARY KEY                   NOT NULL,
  user_id         INTEGER REFERENCES users (id)        NOT NULL,
  country VARCHAR(60) not NULL,
  validFrom Date not null,
  validTo Date not null,
  type VARCHAR(60) not null
);

#######USER

-- insert into users values
-- (1,'n0270598','divya.praveenkumar@gmail.com','INDIAN','ABC1234');

##gnib_nbr
--
-- insert into gnib_info(user_id,gnib_nbr, stamp,validFrom,  validTo)
-- values(1,682639,1,'2017-05-22','2018-08-22');
