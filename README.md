## Разработчики:
* Чижова Мария
* Потрясаева Анна
* Тарабонда Герман
* Обрядина Александра

## Общие сведения о системе
### Назначение
Система для проверки домашних заданий студентов

### Границы системы
* веб-приложение
* один курс
* один студент
* один преподаватель
* REST API
## Ключевые требования (architectural drivers)
### Технические ограничения:
* Это должно быть веб-приложение
* Проверкой заданий занимается раннер, работающий как отдельное приложение и связанный с веб-частью с помощью очереди сообщений - RabbitMQ
* Количество раннеров может быть много, очередь должна балансировать между ними нагрузку

### Бизнес-ограничения:
* Время разработки ограничено двумя месяцами
* Используются лишь бесплатные библиотеки, поскольку нет бюджета на использование платных

### Качественные характеристики системы:
* Приложение должно быть гибким и расширяемым, чтобы было легко добавить новые проверялки при необходимости
* Приложение должно содержать подробную и актуальную документацию, а также описание ко всем публичным методам
* Производительность важна, поскольку у нас может быть большая очередь сообщений
* Безопасность в будущем важна, поскольку предполагается взаимодействие с сетью и другими пользователями

### Ключевые функциональные требования:
1. Возможность просматривать список домашних работ
2. Возможность посмотреть список домашних работ, отсортированный по близости дедлайна
3. Возможность сдать домашнее задание в виде ссылки на GitHub
4. Возможность просмотреть список результатов, отсортированный по дате сдачи
5. Возможность просмотреть детальную информацию о попытке сдачи домашнего задания
6. Возможность добавить новое домашнее задание
7. Возможность просмотреть список результатов, отсортированный по дате сдачи

## Architectural views

### Роли
* Студент, решающий и сдающий домашние задания
* Преподаватель, добавляющий домашние задания и имеющий возможность посмотреть результаты сделанных дз

### Диаграмма случаев использования
![](https://github.com/MariaChizhova/SD-HwProj/blob/task01-architecture/images/usecases.jpg)
### Типичные пользователи
Имя: Олег Монейкен
Возраст: 20 лет
Род деятельности: студент

Имя: Игорь Близнец
Возраст: 43 года
Род деятельности: преподаватель вуза


#### Студент
* просматривает список домашних заданий
* сдает домашние задания в виде ссылки на гитхаб

#### Преподаватель
* добавляет новые домашние задания, а также программу для их проверки
* просматривает результаты домашних работ студента

## Композиция (диаграмма компонентов)

![](https://github.com/MariaChizhova/SD-HwProj/blob/task01-architecture/images/composition.jpg)

## ER-диаграмма

![](https://github.com/MariaChizhova/SD-HwProj/blob/task01-architecture/images/ERdiagram.jpg)
## Макет

![](https://github.com/MariaChizhova/SD-HwProj/blob/task01-architecture/images/student.jpg)

![](https://github.com/MariaChizhova/SD-HwProj/blob/task01-architecture/images/teacher.jpg)
