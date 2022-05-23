## Установка RabbitMq

Ссылка на инструкцию: [Download and install](https://www.google.com/url?sa=D&q=https://www.rabbitmq.com/download.html&ust=1653309480000000&usg=AOvVaw0p8QcuMV4dD5cgjELVjGZa&hl=en)

## Запуск

- Для поднятия локальной бд и накатки миграций таблиц нужно выполнить следующую команду:
`cd server/db && docker-compose up -d`
- Чтобы следить за ее состоянием, можно подключиться к ней по следующему `url` (пароль и логин в `docker-compose.yaml`): `jdbc:postgresql://localhost:5432/hwproj`
- Для запуска локального клиента нужно загрузить зависимости командой: `npm install` и запустить командой: `npm start`.

## Описание ручек

### `/hwproj/homework/student`

Ручка `GET`. Отдает список всех опубликованных домашних заданий в хронологическом порядке в формате:

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
curl -X GET --location "http://localhost:8080/hwproj/homework/student"
```

### `/hwproj/homework/teacher`

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
curl -X GET --location "http://localhost:8080/hwproj/homework/teacher"
```

### `/hwproj/submission/{homeworkId}`

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
curl -X GET --location "http://localhost:8080/hwproj/submission/1"
```

### `/hwproj/homework/{id}`

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
curl -X GET --location "http://localhost:8080/hwproj/homework/1"
```

### `/hwproj/submission/{homeworkId}/{id}`

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
curl -X GET --location "http://localhost:8080/hwproj/homework/1/1"
```

### `/hwproj/submission/add`

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
curl -X POST --location "http://localhost:8080/hwproj/submission/add" \
     -H "Content-Type: application/json" \
     -d '{
            "time": "2022-05-20T22:59:00.000Z",
            "solution": "2 + 2 = 4"
         }'
```

### `/hwproj/homework/add`

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
curl -X POST --location "http://localhost:8080/hwproj/homework/add" \
     -H "Content-Type: application/json" \
     -d '{
            "name": "HW1",
            "description": "Easy HW",
            "publication": "2022-05-11T22:59:00.000Z",
            "deadline": "2022-05-20T23:59:00.000Z"
         }'
```
