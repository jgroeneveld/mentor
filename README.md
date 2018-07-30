# mentor

mentor is a project to play around with Spring Boot structure and API's.

## High level goal

Have a best practice Spring Boot project with good development environment.
Deployed on production on AWS with docker and kubernetes.

## Decisions

- Use Spring Boot Starters
- Use `h2` Database as development database
- Use `flyway` for migrations
- Use `spring-boot-devtools` to have things like accessing the h2 console at `:8080/h2-console`
- Code is structured with ECB (Entity-Control-Boundary).

## API's

Pagination is done with Pageable (`?page=0`)

### Managers
- `GET /managers` Returns a paginated list of all managers.
- `GET /managers/{id}` Returns a single Manager
- `POST /managers` Create new manager (JSON Payload)

### Directs
- `GET /managers/{managerId}/directs` Returns a paginated list of all directs belonging to the manager.
- `POST /managers/{managerId}/directs` Creates a new direct belonging to the manager (JSON Payload)

## Getting started

```
mvn install
mvn spring-boot:run
```