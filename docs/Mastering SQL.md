# Mastering SQL

```sql
select first_name, length(first_name)
from customer;

select first_name, last_name, substring(first_name, 1,1) || substring(last_name, 1,1)
from customer;

--3.26

select rental_id, date_part('hour', rental_date) as "rental hour"
from rental
where date_part('hour', rental_date) >= 22;

--3.27

select payment_id, payment_date
from payment
order by payment_date desc
limit 3;

--3.35

select rating,
case rating
when 'G' then 'General'
when
else 'Unknown'
end
from film;

--4.1

select count(*),
	count(email)
from customer;

--4.9
select
	count(*) filter(where return_date - rental_date < interval '3 days') as lt_3_days,
	count(*) filter(where return_date - rental_date >= interval '3 days') as gte_3_days,
	count(*) filter(where return_date is null) as never_returned
from rental;

--4.10 0 - 1hrs, 1 - 2hrs, 2 - 3hrs, and 3hrs+
select
	case
		when length <= 60 then '0 - 1hrs'
		when length > 60 and length <= 120 then '1 - 2hrs'
		when length > 120 and length <= 180 then '2 - 3hrs'
		when length > 180 then '3hrs+'
		else '0 - 1hrs'
	end as length,
	count(*)
from film
group by 1
order by length;

--4.11
select
  1.0 * sum(length) / count(*) as avg1,
  1.0 * avg(length) as avg2
from film;
-- ANSWER: AVG doesn't take into account null length

--4.12 Write a query to return the average rental duration for each customer in descending order

select customer_id, avg(return_date - rental_date) as avg_rent_duration
from rental
	group by 1
	order by 2 desc;

--4.13
select customer_id
from payment
group by customer_id
having bool_and(amount > 2);

--4.14

select rating, repeat('*', (count(*) / 10)::int) as "count/10"
from film
where rating is not null
group by rating;

--5.1 Write a query to print a description of each film's length as shown in the output below. When a film does not have a length, print: [title] is unknown length

select title || ' is ' || coalesce(length::text || ' minutes', 'unkown')
from film;

--5.2 You want to play a movie title guessing game with some friends. Write a query to print only the first 3 letters of each film title and then '*' for the rest (The repeat function may come in handy here...)

select left(title, 3) || repeat('*', length(title)-3)
from film;

--5.3 Write a query to list the percentage of films that are rated NC-17, G, PG, PG-13, NC-17, and R, rounded to the nearest integer.

select
	round(100.0 * count(case when rating = 'NC-17' then 1 end)) / count(*) as NC_17,
	round(100.0 * count(case when rating = 'G' then 1 end)) / count(*) as G,
	round(100.0 * count(case when rating = 'PG' then 1 end)) / count(*) as PG,
	round(100.0 * count(case when rating = 'PG-13' then 1 end)) / count(*) as PG_13,
	round(100.0 * count(case when rating = 'R' then 1 end)) / count(*) as R
from film;

-- 5.4 Casting

select int '33';
select int '33.3';
select cast(33.3 as int);
select cast(33.8 as int);
select 33::text;
select 'hello'::varchar(2);
select cast(35000 as smallint);
select 12.1::numeric(1,1);

-- 5.5

select *
from pg_timezone_names;

select *
from pg_timezone_abbrevs;

--5.6

select title,
	make_interval(0, 0, 0, rental_duration, 0,0, 0.0) as duration,
	make_interval(0, 0, 0, rental_duration, 0,0, 0.0) + '1 day'::interval as "duration + 1"
from film;

-- 5.7

select date_part('hour',rental_date) as hr, count(*) as count
from rental
group by date_part('hour',rental_date)
order by date_part('hour',rental_date) asc;

--5.8

select
  date_trunc('month', payment_date) as "month",
  sum(amount) as total
from payment
group by "month"
order by "month";

--5.9 Write a query to return a count of the number of films that were rented out on the last day of a month

select count(*)
from rental
where date_trunc('day', rental_date) = date_trunc('month',rental_date) + interval '1 month' - interval '1 day';

--5.10 Write a query to list the film titles that have spaces at the beginning or end (we want to flag them so we know to clean them up!)

select title
from film
where length(title) != length(trim(title));

--5.11 Write a query to sum up, for each customer, the total number of hours they have had films rented out for. Return only the top 3 customers with the most hours.

select * from rental;

select customer_id, cast(date_part('epoch',sum(return_date - rental_date)) / 3600 as int)
from rental r
group by customer_id
order by 2 desc
limit 3;

-- 5.12 write a query to generate a list of timestamps which represent the first day of every month in 2019, at 5pm UTC

select * from generate_series('2019-01-01 17:00 UTC'::timestamptz, '2019-12-31'::timestamp, '1 month'::interval);

--5.13 Return a count of the number of occurrences of the letter 'A' in each customer's first name (this is a common interview question for SQL related jobs!). Order the output by the count descending.

select distinct first_name, char_length(first_name) - char_length(replace(first_name, 'A', ''))
from customer
order by 2 desc;

--5.14 Write a query to tally up the total amount of money made on weekends (Saturday and Sunday)

select sum(amount)
from payment
where extract(dow from payment_date) in (0, 6);

-- 6.8
-- Write a query to return a count of the number of films rented by every customer on the 24th May, 2005. Order the results by number of films rented descending.

select c.first_name || ' ' || c.last_name,
		count(r.rental_id)
from rental r
join customer c on c.customer_id = r.customer_id
where r.rental_date::date > to_date('2005-05-24', 'YYYY-MM-DD')
group by c.customer_id
order by count(r.rental_id) desc
;

-- 8.1 Write a query to return the 3 most recent rentals for each customer. Earlier you did this with a lateral join - this time do it with window functions

with rental_rank as (
select customer_id,
		rental_date
		rental_id,
		rank() over (partition by customer_id order by rental_date)
from rental)
select *
from rental_rank
where rank <= 3;

-- 8.2 Write a query to return all the distinct film ratings without using the DISTINCT keyword
select rating
from (
select rating,
		title,
		rank() over (partition by rating order by title) as rank
from film) t
where rank = 1 and rating is not null;

```

### Ordem

1. From
2. Where
3. Group by
4. having
5. select
6. order by
7. limit
