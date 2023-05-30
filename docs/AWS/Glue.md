# Glue

Aggregates multiple systems being some of them:

- ETL: spark jobs
- Data Catalog: hive metastore implementation
- Data Crawler: crawls for metadata from multiple systems and stores it on data catalog
- Schema regsitry: equivalent to confluent schema registry

## Glue crawler

- Very useful to search for new tables and partitions for existing ones.
- Need to be careful to enable the crawler to update the entire partitions of a table if it detects a new incompatible type (i.e. if it was an int and then we detect that it's actually a float on a later search)
