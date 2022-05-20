## Описание ручек

### `/student/homework`

Ручка `GET`. Отдает список всех домашних заданий в хронологическом порядке в формате:

```json
[
    {
      "id": 1,
      "name": "SD-HW",
      "description": "TO DO",
      "publication": "2022-05-20T13:45:00.000Z",
      "deadline": "2022-05-20T23:59:00.000Z"
    }
]
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/student/homework"
```

### `/student/submission/{homeworkId}`

Ручка `GET`. Отдает список всех попыток домашнего задания в хронологическом порядке
по номеру `homeworkId` в формате:

```json
[
    {
      "id": 1,
      "homeworkId": 1,
      "time": "2022-05-20T22:59:00.000Z",
      "solution": "2 + 2 = 4",
      "result": 10,
      "programOutput": "Tres bon!"
    }
]
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/student/submission/1"
```

### `/student/homework/{id}`

Ручка `GET`. Отдает домашнее задание по номеру `id` в формате:

```json
{
  "id": 1,
  "name": "SD-HW",
  "description": "TO DO",
  "publication": "2022-05-20T13:45:00.000Z",
  "deadline": "2022-05-20T23:59:00.000Z"
}
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/student/homework/1"
```

### `/student/submission/{homeworkId}/{id}`

Ручка `GET`. Отдает попытку домашнего задания 
по номеру домашнего задания `homeworkId` и номеру попытки `id` в формате:

```json
{
  "id": 1,
  "homeworkId": 1,
  "time": "2022-05-20T22:59:00.000Z",
  "solution": "2 + 2 = 4",
  "result": 10,
  "programOutput": "Tres bon!"
}
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/student/homework/1/1"
```

### `/student/submission`

Ручка `POST`. Посылает новую попытку на сервер.

Формат данных:

```yaml
SubmissionRequest:
  schema:
    time:
      type: timestamp
      required: true
    solution:
      type: string
      required: true
```

Пример:
```json
{
  "time": "2022-05-20T22:59:00.000Z",
  "solution": "2 + 2 = 4"
}
```

Пример curl:

```shell
curl -X POST --location "http://localhost:8080/student/submission" \
     -H "Content-Type: application/json" \
     -d '{
            "time": "2022-05-20T22:59:00.000Z",
            "solution": "2 + 2 = 4"
         }'
```

### `/teacher/homework`

Ручка `GET`. Отдает список всех домашних заданий в хронологическом порядке в формате:

```json
[
    {
      "id": 1,
      "name": "SD-HW",
      "description": "TO DO",
      "publication": "2022-05-20T13:45:00.000Z",
      "deadline": "2022-05-20T23:59:00.000Z"
    }
]
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/teacher/homework"
```

### `/teacher/submission/{homeworkId}`

Ручка `GET`. Отдает список всех попыток домашнего задания в хронологическом порядке
по номеру `homeworkId` в формате:

```json
[
    {
      "id": 1,
      "homeworkId": 1,
      "time": "2022-05-20T22:59:00.000Z",
      "solution": "2 + 2 = 4",
      "result": 10,
      "programOutput": "Tres bon!"
    }
]
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/teacher/submission/1"
```

### `/teacher/homework/{id}`

Ручка `GET`. Отдает домашнее задание по номеру `id` в формате:

```json
{
  "id": 1,
  "name": "SD-HW",
  "description": "TO DO",
  "publication": "2022-05-20T13:45:00.000Z",
  "deadline": "2022-05-20T23:59:00.000Z"
}
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/teacher/homework/1"
```

### `/teacher/submission/{homeworkId}/{id}`

Ручка `GET`. Отдает попытку домашнего задания
по номеру домашнего задания `homeworkId` и номеру попытки `id` в формате:

```json
{
  "id": 1,
  "homeworkId": 1,
  "time": "2022-05-20T22:59:00.000Z",
  "solution": "2 + 2 = 4",
  "result": 10,
  "programOutput": "Tres bon!"
}
```

Пример curl:
```shell
curl -X GET --location "http://localhost:8080/teacher/submission/1/1"
```

### `/teacher/homework`

Ручка `POST`. Посылает новую попытку на сервер.

Формат данных:

```yaml
HomeworkRequest:
  schema:
    name:
      type: string
      required: true
    description:
      type: string
      required: true
    publication:
      type: timestamp
      required: true
    deadline:
      type: timestamp
      required: true
```

Пример:
```json
{
  "name": "HW1",
  "description": "Easy HW",
  "publication": "2022-05-11T22:59:00.000Z",
  "deadline": "2022-05-20T23:59:00.000Z"
}
```

Пример curl:

```shell
curl -X POST --location "http://localhost:8080/teacher/homework" \
     -H "Content-Type: application/json" \
     -d '{
            "name": "HW1",
            "description": "Easy HW",
            "publication": "2022-05-11T22:59:00.000Z",
            "deadline": "2022-05-20T23:59:00.000Z"
         }'
```