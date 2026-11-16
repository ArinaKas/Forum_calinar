# Кулинарный фан-форум

Веб-приложение для публикации, поиска и обсуждения рецептов из кино, мультфильмов и видеоигр.

## Быстрый старт

### Требования
- Java 17+
- Maven 3.9.16+

### Запуск приложения

```bash
mvn clean jetty:run
```

Приложение будет доступно по адресу: **http://localhost:7777/**

### Запуск тестов

```bash
mvn test
```

### Сборка WAR

```bash
mvn clean package
```

Итоговый WAR файл: `target/forum-calinar-1.0.0.war`

## Технологический стек

Полное описание версий и компонентов: **[TECH_STACK.md](./TECH_STACK.md)**

**Краткий обзор:**
- **Backend:** Spring Framework 7.0.10 (без Boot)
- **Web Server:** Jetty 11.0.26
- **View Layer:** Thymeleaf 3.1.7.RELEASE
- **Database:** H2 2.5.252 (embedded)
- **ORM:** Hibernate 7.4.16.Final + JPA 3.2.0
- **Testing:** JUnit 5 (6.1.3) + Mockito 5.24.0
- **Logging:** SLF4J 2.0.20 + Logback 1.5.29

## Структура проекта

```
src/main/
├── java/com/forum/
│   ├── config/          # Spring конфигурация
│   ├── controller/      # Контроллеры
│   ├── model/           # JPA сущности
│   ├── repository/      # Репозитории
│   └── service/         # Бизнес-логика
├── webapp/WEB-INF/
│   ├── views/           # Thymeleaf шаблоны (.html)
│   ├── static/          # CSS, JS, изображения
│   ├── web.xml          # Конфигурация Servlet
│   ├── application.properties
│   └── logback.xml      # Логирование
```

## Конфигурация

### База данных
Файл: `src/main/webapp/WEB-INF/application.properties`

```properties
# Database
spring.datasource.url=jdbc:h2:mem:forumdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MySQL
spring.datasource.driver-class-name=org.h2.Driver

# Hibernate
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=false
```

### Логирование
Файл: `src/main/webapp/WEB-INF/logback.xml`

Уровень по умолчанию: `DEBUG` для пакета `com.forum`

---

**Разработка:** Курсовой проект РПС  
**Язык:** Java 17
