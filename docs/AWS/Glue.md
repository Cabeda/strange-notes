# Glue

Aggregates multiple systems being some of them:

- ETL: spark jobs
- Data Catalog: hive metastore implementation
- Data Crawler: crawls for metadata from multiple systems and stores it on data catalog
- Schema regsitry: equivalent to confluent schema registry

## Glue crawler

- Very useful to search for new tables and partitions for existing ones.
- Need to be careful to enable the crawler to update the entire partitions of a table if it detects a new incompatible type (i.e. if it was an int and then we detect that it's actually a float on a later search)

## Transformations

[Source](https://aws.amazon.com/blogs/big-data/ten-new-visual-transforms-in-aws-glue-studio/)

- Split string
- Array to columns
- Derived columns
- Concatenate columns
- Unpivot Columns Into Rows
- Explode Array Or Map into Rows
- select fields
- Pivot Rows Into Columns
- Autobalance Processing
- Drop fields

## Glue 4.0

[Source](https://aws.amazon.com/blogs/big-data/dive-deep-into-aws-glue-4-0-for-apache-spark/)

- Python 3.10
- Spark 3.3.0
- Supports pandas API
  - Change import to `import pyspark.pandas as pd`
- Python UDF profiling
- Adaptative query execution (AQE) by default. Set with `spark.sql.adaptive.enabled`
- Improved Redshift connector
- Improved overall perf (they estimate 2.7 times faster)
