# SQL

- Means **Structured Query Language**

## Anti-join

Get in query all values not in B

```SQL
SELECT a.i
  FROM a
  WHERE NOT EXISTS
    (SELECT b.i FROM b WHERE a.i = b.i);

```

## SQL 2023

- ORDER BY in grouped table (F868)
- GREATEST and LEAST (T054)
  - `SELECT greatest(1, 2);  --> 2 SELECT least(1, 2);     --> 1`
- String padding functions (T055)
- Multi-character TRIM functions (T056)
- Optional string types maximum length (T081) e.g. `VARCHAR(10)` can be `VARCHAR`
- Enhanced cycle mark values (T133) with boolean values
- ANY_VALUE (T626) to get any value from the specified column
- New JSON features
  - JSON data type (T801)
  - JSON_SERIALIZE, JSON_SCALAR, and IS JSON.
- SQL/JSON simplified accessor (T860–T864)
  - `SELECT t.j.foo.bar[2], ... FROM tbl t ..`
- Property Graph Queries (SQL/PGQ)
  - 
