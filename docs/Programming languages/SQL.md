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
