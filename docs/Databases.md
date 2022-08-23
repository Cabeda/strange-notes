# Databases

## Data Consistency

The CAP Theorem is fundamentally about replication, specifically network failures during replication.

- CAP theorem
  - Consistency: on a read receive the most recent item
  - Availability: receive non-failing response
  - Partition tolerance: system operation despite network traffic disruption between nodes

## ACID

ACID refers to a set of guarantees about the behavior of a database when combining multiple operations in a single, logical operation (often called a “transaction”).

- ATOMICITY: all operations succedd or fail together
- CONSISTENCY: the database is in a valid state following the transaction
- ISOLATION: concurrent transactions are treated as executed sequentially
- Durability: a committed transaction will be saved even in the event of a failure

## Linearizability

It states that once your system accepts and completes a write operation for a piece of data, all subsequent operations on that data should reflect that write.

## Serializability

 Decides how to treat concurrent transactions on the same underlying pieces of data.
