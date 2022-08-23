# Airflow

Orchestration tool

## Dynamic Dags

Possible since recent versions ([source](https://airflow.apache.org/docs/apache-airflow/stable/howto/dynamic-dag-generation.html))

### Task Groups

Ferramenta que agrupa dags dentro de blocos

```python
t0 = DummyOperator(task_id='start')

# Start Task Group definition
with TaskGroup(group_id='group1') as tg1:
    t1 = DummyOperator(task_id='task1')
    t2 = DummyOperator(task_id='task2')

    t1 >> t2
# End Task Group definition

t3 = DummyOperator(task_id='end')

# Set Task Group's (tg1) dependencies
t0 >> tg1 >> t3
```

## Cross-dag dependencies

- TriggerDagRunOperator: ideal for downstream dependency
- ExternalTaskSensor: ideal for upstream dependency
- API

```python
trigger_dependent_dag = TriggerDagRunOperator(
        task_id="trigger_dependent_dag",
        trigger_dag_id="dependent-dag",
        wait_for_completion=True
    )
```

Note: Since 2.1 we can see the dependencies set by option 1 and 2 in a separate view

## Tips

- Avoid processing tasks on airflow. Delegate to other tools

## Releases

### 2.1.0

- Add PythonVirtualenvDecorator to Taskflow API
- Add Taskgroup decorator
- Dag calendar view
- Cross-dag view
- Auto refresh tree view
- Allow celery workers without gossup or mingle modes

### 2.0.2

- Taskflow API
- REST API
- Scheduler improved (horizontal scaling)
- task Groups
- New UI
- Added Smart Sensors (replace external sensor?)
- Simplified Kubernetes Executor
- Split airflow packages into external
- Auto refresh view
- Faster webserver start up

### 1.10.15

- Fix bug on depends_on_past or task_concurrency stuck
- New new cli commands of 2.0
- Fix airflow db upgrade
