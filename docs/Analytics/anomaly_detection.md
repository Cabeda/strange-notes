# Anomaly detection

Algorithms to detect deviation.

## Time series discords

Example on this using AWS Kinesis Data Analytics (Flink) [Source](https://aws.amazon.com/blogs/big-data/real-time-time-series-anomaly-detection-for-streaming-applications-on-amazon-kinesis-data-analytics/)

**Discord Aware Matrix Profile (DAMP)** is an improvement in terms of performance:
    - Early stopping:Procurar por subsequências similiares abaixo do threshold. Se encontrar marca como nominal e para
    - Look-ahead windowing: olha para uma amostra dos dados no futuro e se forem similares à em análise atual descarta
    - Use of MASS: Usa o algoritmo MASS para encontrar subsequências similares no passado
