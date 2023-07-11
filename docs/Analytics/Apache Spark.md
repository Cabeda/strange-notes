---
title: "Apache Spark"
---

It is divided in the following packages

- Spark Core
- MLlib
- SparkSQL
- Spark Structured Streaming
- GraphX: provides for functions to manipulate graphs

## Architecture

It's divided by:

1. Spark Application
2. Spark Driver
3. SparkSession
4. ClusterManager
5. Spark Executor

### Cluster manager

Supports the following types:

- local
- standalone
- yarn cluster|server
- mesos
- kubernetes

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

## Uber analyser

- Uber provides spark as a service. To try to improve optimizations for users that are not aware of spark it created an additional layer source (https://www.uber.com/en-US/blog/spark-analysers-catching-anti-patterns-in-spark-apps/).

## Spark EMR on EKS

[Source](https://aws.amazon.com/blogs/big-data/improve-reliability-and-reduce-costs-of-your-apache-spark-workloads-with-vertical-autoscaling-on-amazon-emr-on-eks/)

- Docker image that allows to run EMR runtime
- Support vertical autoscaling, using Kubernetes Vertical Pod Autoscaler (VPA) to automatically tune the memory and CPU resources of EMR Spark
  - Vertical autoscaling complements existing Spark autoscaling solutions such as Dynamic Resource Allocation (DRA) and Kubernetes autoscaling solutions such as Karpenter.
