

# Postgres

* Row-based database
* Open source



## Data Warehouse

### Extensions

* Citus
* Swarm64

### Citus

* Columnar storage
* Sem suporte para update e delete [à data](https://github.com/citusdata/citus/tree/master/src/backend/columnar)

### Tips

- don't use the [same server](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#configuring-postgres-as-a-data-warehouse) as your production system 
- upgrade to pg 12+ (or avoid [common table expressions](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#avoid-common-table-expressions) in your queries)
- go [easy on indexes](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#use-indexes-sparingly) – less is more
- consider [partitioning](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#partitioning) long tables
- ensure you're not [I/O-bound](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#minimize-disk-and-io)
- [vacuum analyze](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/vacuum-after-bulk-inserts) after bulk insertion
- explore [parallel queries](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#look-at-parallel-queries)
- increase [statistics sampling](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#increase-statistics-sampling)
- use [fewer columns](https://www.narrator.ai/blog/using-postgresql-as-a-data-warehouse/#use-fewer-columns) on frequently-queried tables
- 

**Reasons not to use indexes**

1. For many analytics queries it's faster for Postgres to do a table scan than an index scan
2. Indexes increase the size of the table. The smaller the table, the more will fit in memory. 
3. Indexes add additional cost on every insert / update



### Types of Index

https://www.postgresql.org/docs/current/indexes-types.html

* B-tree
* Hash
* GiST
* SP-GiST
* GIN
  * Used for text-search
  * Could be used for general json search
* BRIN

### Partial Indexes

Index of only some rows of a given table [source](https://www.postgresql.org/docs/8.0/indexes-partial.html).

```sql
CREATE INDEX access_log_client_ip_ix ON access_log (client_ip)
    WHERE NOT (client_ip > inet '192.168.100.0' AND client_ip < inet '192.168.100.255');
```

 

### Partitions

Divide uma tabela em várias o que pode reduzir o tempo de respota se uma tiver que aceder apenas a uma query. No entanto tem um trabalho extra de manutenção (as tabelas não são criadas automaticamente).



### Replicação

Postgres tem dois modos:

* Física
* Lógica

É recomendado que se usa a lógica que é mais resiliente

### MVCC

Multi-version concurrency control utilizado para garantir ACID em transações concorrentes

## Explain Analyze

[Source](https://www.cybertec-postgresql.com/en/how-to-interpret-postgresql-explain-analyze-output/)

* Explain shows the query execution plan
* Analyze actually runs the query

### Options

* Analyze
* buffers
* Verbose
* Settings
* Wal: shows the wall usage on DML

```sql
EXPLAIN (ANALYZE, BUFFERS) /* SQL statement */;
```

### Costs

**1 unit Cost** = read 8KB page during sequential scan

**Startup cost**: cost to return first row

**Total cost**: cost to return all rows

### How to check?

* Finds the nodes with the most execution times
* find the lowest node where the estimate is bigger thant the plant (usually 10x more)
* find long running sequential scans with a filter condition. This can be improved with an index

### Tools

* [depesz](https://explain.depesz.com/)
* [Dalibo](https://explain.dalibo.com/)

## Import data 

* COPY is faster than INSERT
* Increase checkpoints is better
* Logged table are slower than unlogged tables but can crash and doesn't have replication
* Create indexes after inserting data
* Avoid triggers when writing
* Improving column order and space consumption
  * Fixed sized columns first



## Notification/Listen

* Can one subscribe to changes? (alternative to streaming system)

## Postgres 14

* Perf improvements
* Adds multirange type
