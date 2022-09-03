# DynamoDB

- Serverless noSQL Database from AWS.
- Provides [Eventual Consistency](../Databases.md#Data-Consistency)
- Divides data into partitions
- Each partition has a primary node (writer) and can have N Reader nodes
- A router decides to each primary node to send the request

## Global tables

- Feature to put data closer to the users of one or more regions

## Indexes

There are two type:

- Local secondary index (LSI)
- Global secondary index (GSI)

- Local indexes allow for strong consistency while global ones don't
- For global indexes a separate partition infra is set
- For the GSI a separate replication queue receives the requests, separate from the primary nodes, and updates the indexes eventually
