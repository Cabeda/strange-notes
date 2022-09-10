# Databases

A database consists of multiple components:

- transport layer
- query processor
- execution engine
  - transaction manager: coordinates, schedules and tracks transactions
  - lock manager: guards access to resources and prevents concurrent accesses that violate data integrity
  - log manager: holds a history of operations
- storage engine
  - RocksDB

## Types of DB's

- OLTP: transactions
- OLAP: analytical
- HTAP: hybrid of transactions and analytics

## Data Layout

- Row oriented
- Column oriented
- Wide columns
  - Big table or Hbase
  - Stored in multidiensional maps
  - Columns are grouped into column families and inside each column family, data is stored row-wise
  - Good for storing data retrieved by key(s)

## Recovery

- WAL
  - Write-ahead log (WAL) also know as commit log, is an append-only auxiliary disk-resident structure used for crash amd transaction recovery
  - Each WAL record has a unique, monotonically increasing log sequence number (LSN)
- Shadow paging: copy-on-write where new content is published on shadow page and is commited on pointer flip
- Steal and force policies
- ARIES
  - Steal/no-force recovery algorithm
  - uses WAL records to implement repeating history during recovery
  - Creates compensation log records during undo to avoid repeating work in case of another failure

## Deletion

- Most DB's use a delete marker or tombstone instead of deleting directly. When doing garbase collection it can remove this

## Cache

- Eviction: When ti removed cache that no longer needs
- Eviction algorithms
  - FIFO: first in, first out, most naive one
  - LRU: least recently used, places the cache on the back of eviction list when accessed. can be expensive to reorder on high transaction db's
    - 2Q: two-queu LRU: defines 1 cache queue and another for ones with frequent access
    - LRU-K: keeps track of last K accesses
  - Clock: efficient algorithm
  - LFU: trackspage reference events, great for db's under heavy load as it gives preference for frequently accessed items

## Concurrency Control

- Set of techniques for handling interactions between concurrently executing transactions
- Categories:
  - **Optimistic concurrency control**: allows concurrent reads and writes and afterwards checks if the result is serializable. In case of conflict one of the conflicting transactions aborts
  - **Multiversion concurrency control**: guarantees a consistent view of the datbaase at some pointin the past
  - **Pessimistic concurrency control**: uses both lock-based and nonlocking conservative methods. The first disallow other transactions access to data records. The seconds keeps a list of operations and only locks in case of detecting an unfinished transaction for the requested data record

## Data Consistency

The CAP Theorem is fundamentally about replication, specifically network failures during replication.

- CAP theorem

  - Consistency: on a read receive the most recent item
  - Availability: receive non-failing response
  - Partition tolerance: system operation despite network traffic disruption between nodes

- PACELC theorem
  - Extension of CAP
  - It states that in case of network partitioning (P) in a distributed computer system, one has to choose between availability (A) and consistency (C) (as per the CAP theorem), but else (E), even when the system is running normally in the absence of partitions, one has to choose between latency (L) and consistency (C). (source [wiki](https://en.wikipedia.org/wiki/PACELC_theorem))

![ELC Spectrum](images/2022-09-02-23-03-53.png)

## Transaction guarantees (ACID)

ACID refers to a set of guarantees about the behavior of a database when combining multiple operations in a single, logical operation (often called a “transaction”).

- ATOMICITY: all operations succeed or fail together
- CONSISTENCY: the database is in a valid state following the transaction
- ISOLATION: concurrent transactions are treated as executed sequentially
- Durability: a committed transaction will be saved even in the event of a failure

## Read and Write anomalies

- Dirty read: transaction reads uncommited changes from other transactions
- Nonrepeatable read: transaction queries same row twice and gets different results
- phantom read: same as nonrepeatable but for a set of rows
- lost update: occurs when multiple transactions are not aware of each other and overwrite the result of each other
- Dirty write: transaction takes an uncommited value, modifies it and saves it
- Write skew: when the individual transactions respect the constraints but their combination does not

## Serializability (˙ levels)

Decides how to treat concurrent transactions on the same underlying pieces of data.

- Read uncommited: weakest one, allows dirty reads
- Read commited: disallows dirty reads but phantom and nonrepeatable reads are
- repeatable read: only phantom reads are possible to occur
- serializability: guarantees transaction outcomes will appear in some order as if transactions were execured serially

- Snapshot isolation: allows transaction to observe the state changes performed by all transactions that were commited by the time it sta
  rted. It commits with success only if the values it modifies did not change.
  - Write skews are possible under this isolation

## Linearizability

It states that once your system accepts and completes a write operation for a piece of data, all subsequent operations on that data should reflect that write.

## Eventual Consistency

> At a very high level, the notion of ”eventual consistency” refers to a distributed systems model where, to quote Wikipedia, “if no new updates are made to a given data item, eventually all accesses to that item will return the last updated value.”

# Data Structures

- binary search tree: not great for disk-based DB's as it has low fanout and can require frequent balacing
- B-tree
  - Paged B-tree: groups nodes into pages (related to SSD page)
  - By allowing to store more than 2 values on each nodes it reduces the fanout and frequency of rebalances
  - Lookup complexity of **Log M**

## Breadcrumbs

- For operations that can lead to structural changes of a b-tree (split/merge) we store the references to the leaf and nodes so that we can backtrack to propagate a split or merge

## Compression

- Snappy
- zLib
- Lz4
- Zstd
- brotli
- gzip

## Vacuum and maintenance

- Compaction
- vacuum
- general "maintenance"

# Links

https://www.alexdebrie.com/posts/dynamodb-eventual-consistency/
Database internals from Alex Petrov
