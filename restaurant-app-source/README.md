# Restaurant Ordering API

Developer application only: Java 21, Spring Boot, Maven, Spring Data JPA and H2.

## Run
```bash
mvn clean spring-boot:run
```
Application URL: http://localhost:8080

## Endpoints
- `GET /api/menu` — list menu items
- `GET /api/menu/{id}` — get a menu item
- `POST /api/orders` — place an order
- `GET /api/orders/{id}` — get an order
- `GET /actuator/health` — health status

## Sample order
```bash
curl -X POST http://localhost:8080/api/orders -H "Content-Type: application/json" -d '{"customerName":"Alex","items":[{"menuItemId":1,"quantity":2},{"menuItemId":3,"quantity":1}]}'
```
