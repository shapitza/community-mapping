# Community Mapping

A platform where organizations keep shared maps of the places that matter to
their community: risks, assets, ideas or anything else they define.

| Folder      | What it is                                                        |
| ----------- | ----------------------------------------------------------------- |
| `backend/`  | REST API — Micronaut 5, Java 25, PostgreSQL, Flyway               |
| `frontend/` | Web app — React 19, TypeScript, Vite, MUI 9, Leaflet/OpenStreetMap |
| `docs/`     | Deployment guide and backend architecture                         |

## Run locally

You need Docker, JDK 25 and Node 22.

```bash
# 1. Database (PostgreSQL 16 on port 5433)
cd backend
docker compose up -d

# 2. API on http://localhost:8080
./mvnw mn:run

# 3. Web app on http://localhost:5173 (in a second terminal)
cd frontend
npm install
npm run dev
```

The schema and a small demo data set are created by Flyway on first start.

## Deploy

The project is set up to run for free on Render (API + static site) and Neon
(PostgreSQL). See [docs/deployment.md](docs/deployment.md).

## Status

Working today: one demo map with categories, places, search and filtering.

Next: organization sign-up with approval, sign-in, invitations, roles,
per-organization isolation, editing and deleting, and the activity log.
