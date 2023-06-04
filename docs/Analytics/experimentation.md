# Experimentation

From my latest readings I've come to the conclusion that we are coming full circle in terms of analysis. I've started working and been requested to create dashboards. For this I had to model the data into snowflake data models. With the ELT we've come to store everything and with the coming of Big Data we decided to process huge amounts of data as fast as possible.

With dbt, spark, orchestrators and so on we've tried to improve this first issue. But why are we doing all of this, the big companies have already come to this conclusion. We might want to create AI models that use our data to improve our produtivity or our systems and the data engineers come to help manage all of this data.

But there's something else. The companies are in constant change. And how do we know if the changes we are making are good or bad? We need to experiment. And for this we need to have a way to measure the impact of our changes. And this is where the metrics layer comes in.

The metric layer provides a way to better organize how a company measure the health of the business and it's systems. This is where dbt is betting. And microsoft seems to be coming the same way with Fabric.

But this is just a stepping stone in my opinion. We need to make decisions and to make decisions we do experiments. And we need to know how to measure and understand the actual impact of our experiment. And this requires a lot of knowledge in statistics. So, I project that we'll see a lot of data scientists and data engineers working together to create a better way to experiment and measure the impact of our experiments. Some tooling and frameworks will appear on top of the metrics layers. But in the meantime I need to improve on my statistics knowledge.

Note: Need to understand the differences between A/B testing and experimentation.

## References

- [door dash](https://doordash.engineering/2020/05/26/why-we-built-a-metrics-platform/)
- [door_dash expe](https://doordash.engineering/2023/04/12/using-metrics-layer-to-standardize-and-scale-experimentation-at-doordash/)
