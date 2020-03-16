# Треннинг JHipster
JHipster - современная платформа для генерации, разработки и поставки приложений, написанных на Spring Boot + JS (Angular или React или Vue). Приложения могут быть как монолитными, так и микросервисными.
Основная цель данного треннинга: познакомиться с данным инструментом не только в теории, но и на практике.
Задачи треннинга:
1. Разобрать пример типового REST-сервиса.
2. Освоить работу с JHipster через терминал на примере монолитного приложения.
3. Познакомиться с инструментами проектирования и прокачать монолит до микросервисного приложения.
4. Попрактиковать различные варианты поставки микросервисного приложения.

## Типовые проекты микросервисов
Данный блок включает в себя обзор типовых паттернов проектирования, используемых в Spring приложениях и поднимает проблему рутинной разработки при таком подходе.

### Задание по созданию простого REST-сервиса
1. Подготовить структуру проекта с помощью [Spring Initializr](https://start.spring.io) со следующими параметрами:
	Project: Gradle
	Language: Java
	Spring Boot: 2.2.5
	Project Metadata: заполнить по-желанию
	Dependencies: Spring Web, Spring JPA, H2 Database Lombok
2. Откройте полученный проект в IDE как Gradle проект (все параметры можно оставлять по-умолчанию).
> Что-то пошло не так? Проект в данном виде в работоспособном состоянии доступен по тэгу `1-1`

## Обзор JHipster

### Задание по созданию монолитного приложения с помощью JHipster
1. Создайте пустую директорию и откройте терминал в ней.
2. Выполните команду jhipster и следуюйте указаниям, ниже пример вариантов ответа на вопросы:
```
    ? Which *type* of application would you like to create? Monolithic application (recommended for simple projects)
    ? [Alpha] Do you want to make it reactive with Spring WebFlux? No
    ? What is the base name of your application? JHipster
    ? What is your default Java package name? ru.liga
    ? Do you want to use the JHipster Registry to configure, monitor and scale your application? No
    ? Which *type* of authentication would you like to use? JWT authentication (stateless, with a token)
    ? Which *type* of database would you like to use? SQL (H2, MySQL, MariaDB, PostgreSQL, Oracle, MSSQL)
    ? Which *production* database would you like to use? PostgreSQL
    ? Which *development* database would you like to use? H2 with in-memory persistence
    ? Do you want to use the Spring cache abstraction? Yes, with the Ehcache implementation (local cache, for a single node)
    ? Do you want to use Hibernate 2nd level cache? Yes
    ? Would you like to use Maven or Gradle for building the backend? Gradle
    ? Which other technologies would you like to use? (Press <space> to select, <a> to toggle all, <i> to invert selection)
    ? Which *Framework* would you like to use for the client? React
    ? Would you like to use a Bootswatch theme (https://bootswatch.com/)? Default JHipster
    ? Would you like to enable internationalization support? (Y/n) Yes
    ? Please choose the native language of the application Russian
    ? Please choose additional languages to install (Press <space> to select, <a> to toggle all, <i> to invert selection)
    ? Besides JUnit and Jest, which testing frameworks would you like to use? (Press <space> to select, <a> to toggle all, <i> to invert selection)
    ? Would you like to install other generators from the JHipster Marketplace? (y/N) No
```
3. Дождитесь окончания генерации проекта и выполните команду `./gradlew` для unix или `gradlew` для Windows
4. Откройте полученный проект в IDE как Gradle проект (все параметры можно оставлять по-умолчанию).
5. Дождидесь запуска, холодный старт может занимать продолжительное время. Запуск завершен после появления сообщения, начинающегося с `Application 'JHipster' is running! Access URLs:`
> Пока ожидаете запуска поисследуйте структуру проекта
6. Откройте в браузере URL, указанный в логах и поизучайте приложение.
> Что-то пошло не так? Проект в данном виде в работоспособном состоянии доступен по тэгу `2-1`
