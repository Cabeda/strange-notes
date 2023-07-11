# dbt

## Materializations

The materializations are:

- table
- view
- Incremental
- Ephemeral

## Incremental

- Allows to incrementally update a table instead of recreating it from the ground up everytime we need to update it.

## Data contract

- Used to validate if a model is as expected. If not it will stop before creating the models and breaking downstream

[Source](https://medium.com/geekculture/dbt-model-contracts-importance-and-pitfalls-20b113358ad7)

## Slim CI

Tool CI/CD tool to only test the changes on a PR. Requires having the previous run manifest.json.

Example on [here](https://medium.com/checkout-com-techblog/building-dbt-ci-cd-at-scale-365358f64b6f)

## Plugins to use

[Source](https://medium.com/cts-technologies/crafting-your-dbt-development-workflow-35577d3b573d)

- sqlfluff
- dbt-project-evaluator
- dbt-unit-testing
- dbt-commit
- dbt-coverage
