# Технологический стек — Кулинарный фан-форум

## Backend

| Технология | Версия | Назначение |
|-----------|--------|-----------|
| **Java** | 17.0.21 (LTS) | Язык программирования |
| **Spring Framework** | 7.0.10 | Dependency Injection, веб-фреймворк (MVC) |
| **Spring Web MVC** | 7.0.10 | REST/веб-контроллеры, DispatcherServlet |
| **Spring TX** | 7.0.10 | Управление транзакциями |
| **Spring ORM** | 7.0.10 | Интеграция ORM (Hibernate) |
| **Spring Test** | 7.0.10 | Интеграционные тесты |
| **JPA** | 3.2.0 | Спецификация для работы с БД |
| **Hibernate** | 7.4.16.Final | ORM-реализация JPA |
| **H2 Database** | 2.5.252 (embedded) | Встроенная реляционная БД |
| **Thymeleaf** | 3.1.7.RELEASE | Шаблонизатор (server-side рендеринг) |
| **Thymeleaf Spring 6** | 3.1.7.RELEASE | Интеграция Thymeleaf со Spring |
| **Jakarta Servlet API** | 6.1.0 | Servlet API для Jakarta |
| **Jetty** | 11.0.26 | Servlet контейнер, запуск через Maven плагин |

## Frontend

| Технология | Описание |
|-----------|---------|
| **HTML** | Разметка страниц |
| **CSS** | Стили (тематический дизайн) |
| **JavaScript** | Интерактивность (пересчёт ингредиентов, AJAX) |
| **Thymeleaf** | Server-side рендеринг HTML на бекенде |

## Тестирование

| Технология | Версия | Назначение |
|-----------|--------|-----------|
| **JUnit 5 (Jupiter)** | 6.1.3 | Unit-тестирование |
| **Mockito** | 5.24.0 | Мокирование зависимостей |
| **AssertJ** | 3.27.7 | Удобные assertions |

## Сборка и зависимости

| Инструмент | Версия | Назначение |
|-----------|--------|-----------|
| **Maven** | 3.9.16 | Управление зависимостями и сборка |
| **maven-compiler-plugin** | 3.16.0 | Компиляция под Java 17 |
| **jetty-maven-plugin** | 12.1.15 | Запуск Jetty сервера (`mvn jetty:run`) |
| **maven-surefire-plugin** | 3.6.0 | Запуск unit-тестов |
| **maven-failsafe-plugin** | 3.5.5 | Запуск интеграционных тестов |

## Logging

| Технология | Версия | Назначение |
|-----------|--------|-----------|
| **SLF4J** | 2.0.20 | Фасад для логирования |
| **Logback** | 1.5.29 | Реализация логирования |

## Архитектура

```
HTTP Request
    ↓
Controller (Spring MVC)
    ↓ (обрабатывает запрос, валидация)
Service (Business Logic)
    ↓ (бизнес-логика, расчёты, правила)
Repository (JPA/Hibernate)
    ↓ (работа с БД)
H2 Database (Embedded)
    ↓
HTTP Response (Thymeleaf HTML)
```

## Основные компоненты

### JPA Entities (10 сущностей)
- **User** — пользователь (email, password, роль, баллы, ранг)
- **Recipe** — рецепт (название, описание, статус, автор)
- **Ingredient** — ингредиент (масштабируемость)
- **Step** — шаги приготовления
- **Work** — произведение (фильм, игра, мультфильм, персонажи)
- **Comment** — комментарии и оценки
- **Favorite** — избранные рецепты
- **Report** — система жалоб
- **UserRank** — ранги (Звание 1-5)
- **RecipeStatus** — статусы рецептов (DRAFT, PENDING_MODERATION, PUBLISHED, REJECTED, ON_REWORK)

### Services (бизнес-логика)
- **UserService** — регистрация, авторизация, управление профилем
- **RecipeService** — CRUD, валидация, публикация рецептов
- **CommentService** — комментарии, оценки, начисление баллов
- **ModerationService** — одобрение/отклонение, обработка жалоб
- **RankService** — автоматическое присвоение рангов
- **IngredientScalingService** — пересчёт ингредиентов при изменении порций
- **WorkService** — управление произведениями и персонажами
- **ReportService** — система жалоб

### Controllers
- **HomeController** — главная страница, лента
- **RecipeController** — просмотр, создание рецептов
- **UserController** — регистрация, профиль
- **CommentController** — комментарии, оценки
- **ModeratorController** — панель модератора
- **AdminController** — управление справочниками

## Запуск и разработка

### Для локальной разработки
```bash
mvn jetty:run
```
Приложение поднимается на `http://localhost:8080` с автоматической перезагрузкой.

### Для запуска тестов
```bash
mvn test
```

### Для сборки
```bash
mvn clean package
```

## Конфигурация

### application.properties
- **H2 БД** — встроенная, конфигурируется через URL и параметры
- **Hibernate** — автоматическое создание таблиц (ddl-auto: create-drop или update)
- **Thymeleaf** — кеширование шаблонов, режим разработки/production

### Spring конфигурация
- **AppConfig.java** — бины приложения (сервисы, репозитории)
- **WebConfig.java** — MVC конфигурация (DispatcherServlet, ViewResolver)
- **JpaConfig.java** — DataSource, EntityManager, TransactionManager
- **ThymeleafConfig.java** — TemplateEngine, ViewResolver

### web.xml
- **DispatcherServlet** — маршрутизация запросов
- **Listener** — инициализация Spring контекста

## Особенности реализации

**Без Spring Boot** — полная ручная конфигурация Spring компонентов
