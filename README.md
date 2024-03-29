# mentor

mentor is a project to play around with Spring Boot structure and API's.

Heroku: https://javamentor.herokuapp.com/managers

## High level goal

Have a best practice Spring Boot project with good development environment.
Deployed on production on AWS with docker and kubernetes.

## Decisions

- Use Spring Boot Starters
- Use `h2` Database as development database
- Use `flyway` for migrations
- Use `spring-boot-devtools` to have things like accessing the h2 console at `:8080/h2-console`
- Code is structured with ECB (Entity-Control-Boundary).
- https://dius.github.io/java-faker/ is used to generate seed data. See `Seeding` for more.
- For API Documentation API Rest Docs is used and the docs can be found under `target/generated-docs/` (after `mvn install`).

## Seeding

- To have a good starting point for development, the database is seeded when starting in development mode.
- Seeding is controlled with the profile "seed" which is included in "development".
- Seeder is done in `de.jgroeneveld.mentor.seed.Seeder`

## API's

For detailed API documentation run `mvn install && open target/generated-docs/`

Pagination is done with Pageable (`?page=0`)

### Managers
- `GET /managers` Returns a paginated list of all managers.
- `GET /managers/{id}` Returns a single Manager
- `POST /managers` Create new manager (JSON Payload)

### Directs
- `GET /managers/{managerId}/directs` Returns a paginated list of all directs belonging to the manager.
- `POST /managers/{managerId}/directs` Creates a new direct belonging to the manager (JSON Payload)
- `GET /managers/{managerId}/directs/{id}` Returns a single direct.

## Getting started

```
mvn install
mvn spring-boot:run
```