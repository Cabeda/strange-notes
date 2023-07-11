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

## Optimizations on S3

Check [AWS article](https://aws.amazon.com/blogs/big-data/improve-operational-efficiencies-of-apache-iceberg-tables-built-on-amazon-s3-data-lakes/)

Also check [S3](./AWS/S3.md). If we set tags on write we can tell S3 which objects are to be hard or soft deleted.

## Releases

[Source](https://iceberg.apache.org/releases)

## WAP (Write-Audit-Publish)

Uses the data branching to enable safe data publishing. The logic is very similar to the one provided as transactions by databases such as Postgres.
