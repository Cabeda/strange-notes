# DuckDB

## Subqueries

There are two forms of subqueries, the ones as expressions and the ones as tables.:

In the expressions ones we have:

- Scalar subqueries
- EXISTS
- IN/ANY/ALL

### Scalar subqueries

- **Correlated subqueries**: the subquery is evaluated once for each row processed by the parent statement.
- **Non-correlated subqueries**: the subquery is evaluated only once and the result is used for all the rows processed by the parent statement.

[duckdb blog](https://duckdb.org/2023/05/26/correlated-subqueries-in-sql.html)

## Macros

```sql
CREATE MACRO min_distance_per_carrier(param) AS (
     SELECT MIN(distance)
     FROM ontime
     WHERE uniquecarrier=param
);

```

DuckDB uses a state-of-the-art subquery decorrelation algorithm as described in the Unnesting Arbitrary Queries paper. This allows all subqueries to be decorrelated and executed as a single, much more efficient, query.
