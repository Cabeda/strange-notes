# AWS Redshift

### [VACUUM best practices](https://aws.amazon.com/premiumsupport/knowledge-center/redshift-vacuum-performance/)

VACUUM performance can be improved with the following best practices:

- Because VACUUM is a resource-intensive operation, run it during off-peak hours.
- During off-peak hours, [use wlm_query_slot_count to temporarily override the concurrency level in a queue](https://docs.aws.amazon.com/redshift/latest/dg/tutorial-wlm-query-slot-count.html) for a VACUUM operation.
- Run the VACUUM operation with a threshold parameter of up to 99% for large tables.
- Determine the appropriate threshold and frequency of running VACUUM. For example, you might want to run VACUUM at a threshold of 100%, or have your data always sorted. Use the approach that optimizes your Amazon Redshift cluster's query performance.
- Run a VACUUM FULL or VACUUM SORT ONLY often enough that a high unsorted region does not accumulate in large tables.
  If there is a large amount of unsorted data on a large table, create a deep copy (using [CREATE TABLE AS](https://docs.aws.amazon.com/redshift/latest/dg/r_CREATE_TABLE_AS.html)). A deep copy can help you load the data into a new table instead of running VACUUM SORT on the existing table.
- Run the VACUUM command with the BOOST option. The BOOST option allocates additional resources to VACUUM, such as available memory and disk space. With the BOOST option, VACUUM operates in one window and blocks concurrent deletes and updates for the duration of the VACUUM operation.
  **Note:** If you run VACUUM with the BOOST option, query performance might be affected. It's a best practice to run the VACUUM BOOST operation during maintenance operations or off-peak hours.
- Divide any large tables into [time-series tables](https://docs.aws.amazon.com/redshift/latest/dg/c_best-practices-time-series-tables.html) to improve VACUUM performance. In some cases, using a time-series table can fulfill the need for running VACUUM.
- [Choose a column compression type](https://docs.aws.amazon.com/redshift/latest/dg/t_Compressing_data_on_disk.html) for large tables. Compressed rows consume less disk space when sorting data.
