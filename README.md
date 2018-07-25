# mentor

mentor is a project to play around with Spring Boot structure and API's.

## Decisions

- Use Spring Boot Starters
- Use `h2` Database as development database
- Use `flyway` for migrations (add `scripts/create_migration` to create migration files with timestamps)
- Use `spring-boot-devtools` to have things like accessing the h2 console at `:8080/h2-console`
- Code is structured with ECB (Entity-Control-Boundary).

## API's

Pagination is done with Pageable (`?page=0`)

### Managers
- `GET /managers` Returns a paginated list of all managers.
- `GET /managers/{id}` Returns a single Manager
- `POST /managers` Create new manager (JSON Payload)

### Directs
- `GET /directs` Returns a paginated list of all directs.