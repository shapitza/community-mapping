# Deployment (free tier)

| Part     | Service            | Free tier, as of October 2026                                              |
| -------- | ------------------ | -------------------------------------------------------------------------- |
| Database | Neon               | 1 GB per project, 100 compute-hours a month, suspends after 5 min idle     |
| API      | Render web service | 750 instance-hours a month, sleeps after 15 min idle, wakes in about 1 min |
| Web app  | Render static site | Always on                                                                  |

No credit card is needed for either service. The first request after a quiet
period is slow, because both the API and the database have to wake up.

## 1. Database on Neon

1. Create an account at https://neon.com and a project (PostgreSQL 16, a region in Europe).
2. Open **Connect** and copy the **direct** connection details (not the pooled one):
   host, database, user and password.
3. The JDBC URL is `jdbc:postgresql://<host>/<database>?sslmode=require`.

The tables are created automatically the first time the API starts.

## 2. API and web app on Render

1. Create an account at https://render.com and connect it to GitHub.
2. Choose **New → Blueprint** and pick this repository. Render reads `render.yaml`
   and proposes two services: `community-map-api` and `community-map-frontend`.
3. Fill in the values it asks for:

   | Service  | Variable               | Value                                               |
   | -------- | ---------------------- | --------------------------------------------------- |
   | API      | `DATASOURCE_URL`       | the JDBC URL from step 1                            |
   | API      | `DATASOURCE_USERNAME`  | Neon user                                           |
   | API      | `DATASOURCE_PASSWORD`  | Neon password                                       |
   | API      | `CORS_ALLOWED_ORIGINS` | `https://community-map-frontend.onrender.com`       |
   | Frontend | `VITE_API_BASE_URL`    | `https://community-map-api.onrender.com/api`        |

   If Render gives the services different addresses (the names may be taken),
   use the real ones and redeploy both services.
4. Wait for both deploys to finish. The first API build takes several minutes.

## 3. Check

- `https://<api>.onrender.com/api/health` returns `{"status":"UP",...}`.
- The web app opens and shows the demo map.

## Notes

- Every push to `main` redeploys both services.
- Render's free instance blocks outbound SMTP ports, so email has to be sent
  through a provider with an HTTP API.
- Render's own free PostgreSQL expires 30 days after creation, which is why the
  database is on Neon.
- The free API instance is small. If it runs out of memory, lower the heap share
  by setting `JAVA_OPTS` on the service (see `backend/Dockerfile` for the default).
