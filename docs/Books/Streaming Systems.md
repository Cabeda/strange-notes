# Streaming Systems

Notes regarding the book with the same name

## 01: Streaming 101

Bounded - Stream com fim
Unbounded - Stream sem fim teórico

Event time - quando ocorreu o evento
Process time - quando foi processado

### Window types

- Sliding (hopping)
- Fixed
- Sessions
- Tuple-based - numero fixo de elementos a processar

## 2: The what, where, when and how of data processing

- Triggers:
  - Repeated update
  - Completeness: only materializes when it considers a windows complete
- Watermarks
  - Help define a sense of completeness
  - Types:
    - Perfect
    - Heuristic
  - Allowed lateness: tempo limite para chegarem late events
- Accumulation

## 3: Watermarks

## 4: Advanced Windowing

## 5: Exactly-Once and Side Effects

## 6: Streams and Tables

## 7: The practicalities of Persistent State

## 8: Streaming SQL

## 9: Streaming Joins

## 10: THe evolution of Large-scale Data Processing

1. Mapreduce paper
2. Hadoop open sourced mapreduce ideia
3. Flume was a google owned high level api to optimize mapreduce pipelines
4. Apache Storm: First highly used streaming system with weak consistency replaced with low latency
5. Spark replaced the need of lambda architecture and replaced mapreduce giving a streaming and batch all at once and with much better performance due to RDD
6. MillWhell provides true streaming (spark does a subset) and was added to flume as a streaming API. Being replaced by MillWheel
7. Kafka is a transport layer that gives a sense of security by allowing durability and replayability of streaming
8. Dataflow from google tries to simplify and bring everything under a single API (not open source)
9. Flink adopted the beam programming model and added great accuracy at a fraction of the cost of other systems
10. Beam is a semantic layer that hopes to implement only the best ideas of streaming
