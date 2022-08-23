---
title: "Apache Spark"
---

## Libraries

- pyspark.sql.functions: get spark functions
- pyspark.sql.types: get spark types

## Resilient Distributed Dataset (RDD)

- Low level datasets that splits data between machines

## Datasets

- Buil on top of RDD
- catalog: has functions to list tables on the sparksession
  - list_tables: lists all tables in the catalog

## RDD

### Transformation functions

- filter

  - df.filter(df.dest == "asdfg")

- map

- flatmap

- union

  - unions two RDD by location (not by schema) so we need to be careful of the col position

- reduceByKey: Combines values same key

- groupbByKey: group values same key

- sortByKey: sort RDD by key

- join: join two pair based RDD by ley

## Read/write operations

- read/write
  - csv
  - json
  - parquet
  - options

### Action Functions

- collect: return all elements
- take: take first n
- first: take first element
- count
- repartition: reshuffle whole dataset
  - `repartition(5, col(country))`
- coalesce: reshuffles some of the partitions
  - useful to avoid full reshuffle
- broadcast: provides a copy of the data to all workers

## DataFrames

### Transformation functions

- select
- filter/where
- groupBy
- orderBy/sort
  - can use inside **asc**, **desc**, **asc_nulls_first**, **desc_nulls_first**, **asc_nulls_last**, **desc_nulls_last**
- sortWithinPartitions (sorts on each partition and can be useful to improve perf for further transformations)
- dropDuplicates
- drop: removes a column or multiple ones
- withColumn:Creates a new column
- withColumnRenamed: renames a column in the dataframe

### Action Functions

- printSchema
- head
- show
- count
- columns
- describe
- corr: get correlation

### SQL Functions

- createOrReplaceTempView("name")
- sql(query)
- contains
- isNull/isNotNull
- upper
- split
- cast
- :array
  - size
  - getItem
- when: condição if
- otherwhise

## Functions

- monotonically_increasing_id
- cache
- unpersist

## data types

- Byte type
- Short type
- Integer
- long
- float
- double
- decimal
- string
- binary
- boolean
- timestamp
- date
- array
- map
- struct

## Processes

- Driver
- executor
- cluster manager
  - standalone: simple cluster
  - apache mesos (deprecated)
  - yarn: hadoop 2 resource manager
  - kubernetes

Execution modes

- cluster
- client
- local

- job
  - stages: set of tasks done in a single executor
    - tasks: unit of computation
