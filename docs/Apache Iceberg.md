# Apache Iceberg

Table format from Netflix.

Currently is dependent on Hive metastore but **only stores where the manifest files are stored**. In the future it could be replaced by another system.

## Advantages

- clear table format
- Decouple of dependency on catalog
- allow deletes
- multiple partitions

## Disadvantages

- Longer writes (due to bigger metadata)
