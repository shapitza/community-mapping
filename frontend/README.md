# Community Map — frontend

React 19, TypeScript, Vite, MUI 9, React Query and Leaflet (OpenStreetMap tiles).

## Run locally

```bash
cp .env.example .env   # optional, the defaults match the local backend
npm install
npm run dev            # http://localhost:5173
```

The backend has to be running on `http://localhost:8080` (see `../backend`).

## Scripts

| Command             | What it does                            |
| ------------------- | --------------------------------------- |
| `npm run dev`       | Development server with hot reload      |
| `npm run typecheck` | TypeScript check only                   |
| `npm run build`     | TypeScript check, then production build |
| `npm run preview`   | Serve the production build locally      |

## Configuration

| Variable            | Default                     | Meaning                        |
| ------------------- | --------------------------- | ------------------------------ |
| `VITE_API_BASE_URL` | `http://localhost:8080/api` | Base URL of the backend API    |
| `VITE_MAP_ID`       | `1`                         | Map shown until sign-in exists |
