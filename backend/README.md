# Community Map — backend

Micronaut 5 on Java 25, Micronaut Data JDBC, PostgreSQL 16, Flyway.

## Run locally

```bash
docker compose up -d   # PostgreSQL on localhost:5433
./mvnw mn:run          # API on http://localhost:8080
./mvnw verify          # build and run the tests (needs the database running)
```

Check that it is up: `curl http://localhost:8080/api/health`

## Configuration

All settings have local defaults and can be overridden with environment variables.

| Variable               | Default                                             | Meaning                                  |
| ---------------------- | --------------------------------------------------- | ---------------------------------------- |
| `PORT`                 | `8080`                                              | HTTP port                                |
| `DATASOURCE_URL`       | `jdbc:postgresql://localhost:5433/community_map`    | JDBC URL                                 |
| `DATASOURCE_USERNAME`  | `community_map`                                     | Database user                            |
| `DATASOURCE_PASSWORD`  | `community_map`                                     | Database password                        |
| `DATASOURCE_POOL_SIZE` | `5`                                                 | Maximum open database connections        |
| `CORS_ALLOWED_ORIGINS` | `http://localhost:5173`                             | Origin(s) of the web app, comma-separated |

## Layout

The code is organised by business component, each split into `boundary`,
`control` and `entity`. See [docs/architecture.md](../docs/architecture.md)
for the rules and where new code goes.

```
src/main/java/com/communitymap/
  organizations/ identity/ members/ maps/ categories/ places/ activity/ platform/
    boundary/   HTTP endpoints and request records
    control/    business logic and repositories
    entity/     domain objects
src/main/resources/db/migration/   Flyway migrations
src/test/java/.../ArchitectureTest  checks the layer rules on every build
```

## Endpoints

| Method     | Path                                       |
| ---------- | ------------------------------------------ |
| GET        | `/api/health`                              |
| GET, POST  | `/api/organizations`                       |
| GET        | `/api/organizations/{id}`                  |
| GET, POST  | `/api/organizations/{organizationId}/maps` |
| GET        | `/api/maps/{id}`                           |
| GET, POST  | `/api/maps/{mapId}/categories`             |
| GET, POST  | `/api/maps/{mapId}/items`                  |
| GET        | `/api/items/{id}`                          |
| GET, POST  | `/api/items/{itemId}/observations`         |

The schema also has tables for statuses, custom fields, photos, source links
and the activity log; they have entities and repositories but no endpoints yet.
