# Athena

Query engine that started with a fork from Presto and nows is a mix between Presto and Trino.

It serves as a good alternative to the ones above if heavily integrated with AWS.

It's currently my goto to query Hive and iceberg tables.

## Data quality

We can define data quality checks using **Data Quality Rulesets in AWS Glue** ([source](https://www.lariatdata.com/blog/continuous-data-quality-athena)).
Uses DQDL. Howevever it's important to consider the following limitations:

* DQDL thresholds must be hardcoded. They cannot, for example, be compared against a dynamic moving average of that number over the last week.
* The raw result of a measurement e.g DistinctValuesCount is unavailable to you. This may be necessary for you to quantify the scale and severity of a data quality problem. Distinct values declining by 5% may require a different resolution workflow, than distinct values declining by 100%
* DQDL CustomSQL rules must emit 1 numeric result alone, which will be compared against the threshold expression. In cases where you want a `GROUP BY`-style measurement, you will need to pre-define the groups and define separate CustomSQL rules for each.
