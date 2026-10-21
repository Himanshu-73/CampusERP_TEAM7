# Campus ERP: Copilot Instructions

## Stack (do NOT change or substitute)
- Backend: Java 17, Spring Boot 3, Spring Security + JWT, Spring Data JPA, MySQL 8, Flyway, Maven
- Frontend: React 18 + Vite + Tailwind + Axios + React Router
- NO Node/Express/MongoDB on the backend.

## Roles
SUPER_ADMIN, DIRECTOR_HR, TPO, DEPUTY_TPO, PLACEMENT_COORDINATOR, HOD, FACULTY, STUDENT

## Backend rules
1. Base package `com.campuserp`. Each feature lives in `modules/<area>/<feature>/` with `controller`, `service`, `repository`, `entity`, `dto`, `mapper`.
2. Controllers hold no business logic. They call services only.
3. Never expose entities in APIs. Use request/response DTOs with Bean Validation.
4. Every endpoint returns `ApiResponse<T>`. Errors go through `GlobalExceptionHandler`.
5. Schema changes only through Flyway migrations. Set `spring.jpa.hibernate.ddl-auto=validate`.
6. Protect endpoints with `@PreAuthorize` by role. Default is deny.
7. Passwords use BCrypt. Secrets come from environment variables, never hardcoded.
8. Add a unit test for every service method and a MockMvc test for every controller.
9. Endpoints are prefixed `/api/v1/...` and match `docs/api-contract.md`.

## Frontend rules
1. API calls only in `src/services/`. No axios calls inside components.
2. Routes are guarded by `ProtectedRoute` with allowed roles.
3. Reuse `Table.jsx` and `Modal.jsx`. Do not create duplicates.
4. Handle loading, empty, and error states on every page.

## Workflow
- Work one phase at a time. Do not generate code for later phases.
- Branches: `main` (stable), `feature/<name>`. Small commits. Never commit `.env`.
- If a requirement is unclear, ask or leave a TODO. Do not invent features.
