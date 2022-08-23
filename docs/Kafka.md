---
title: "Kafka"
---

- Is a log based platform
- It's fast due to
  - offload work to client
  - log-structure persistence on broker
  - batching
  - compression
  - zero-copy I/O
  - stream-level parallelism

## Producers

- Envia evento para cluster de kafka
- Strongest delivery guarantee `acks=all`
- Ensures message ordering in case of retries `max.in.flight.requests.per.connection=1`
- Batch size é configurável
- Queue limit
- Usa serializer para transformar info

## Consumers

- Lê eventos de um tópico
- Pode iniciar de qualquer offset
- Tipos
  - Low-level
  - Consumer-groups - controller por cima dos low-level que admite a paralelização

### Low-level

- Necessita de topico, partição e offset
- Consumer app tem de gerir aonde é que está a ler

### Consumer groups

- record readers que pode ler de um ou mais tópicos
- consumers podem pertencer ao mesmo grupo pelo group.id
- fazem a gestão dos offsets para cada topio e partição
- é **impossivel** diminuir o número de partições
- estratégias
  - latest
  - earliest
- offsets
  - commited: ultima posição que está no consumer group
  - current: posição atual que se fez poll mas ainda não se fez commit
  - latest: ultimo offset escrito pelo producer para o tópico/partição
  - consumer-group lag: indica quão atrás a aplicação está até ao latest offset
