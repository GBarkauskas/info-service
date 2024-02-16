# Car Information API

This API provides endpoints to manage car information. Users can create, update, delete, and retrieve car information based on their permissions.

## Endpoints

- **Create Car Information:**
  - Method: POST
  - Path: `/api/v1/cars-information`
  - Required Role: ADMIN
  - Description: Creates a new car information entry.

- **Update Car Information:**
  - Method: PUT
  - Path: `/api/v1/cars-information/{id}`
  - Required Role: ADMIN
  - Description: Updates an existing car information entry with the specified ID.

- **Delete Car Information:**
  - Method: DELETE
  - Path: `/api/v1/cars-information/{id}`
  - Required Role: ADMIN
  - Description: Deletes the car information entry with the specified ID.

- **Get All Cars Information:**
  - Method: GET
  - Path: `/api/v1/cars-information`
  - Required Role: ADMIN or USER
  - Description: Retrieves a list of all car information entries.

- **Get Car Information by ID:**
  - Method: GET
  - Path: `/api/v1/cars-information/{id}`
  - Required Role: ADMIN or USER
  - Description: Retrieves the car information entry with the specified ID.

## Authorization

- All endpoints require authentication.
- Endpoints GET `/api/v1/cars-information`, POST `/api/v1/cars-information/{id}`, GET `/api/v1/cars-information/{id}` are accessible to both ADMIN and USER roles.
- Endpoints PUT `/api/v1/cars-information/{id}`,  DELETE `/api/v1/cars-information/{id}` require the ADMIN role for access.

## Request and Response Formats

- Request payloads are expected to be in JSON format.
- Response payloads are in JSON format and contain car information data.

## Security

- JWT (JSON Web Token) authentication is used to secure the API.
- Permissions are enforced using Spring Security's `@PreAuthorize` annotation based on user roles.

## Dependencies

- This API is built using Spring Boot.
- Spring Security is used for authentication and authorization.
- Lombok is used for reducing boilerplate code.

## Usage

- Make HTTP requests to the provided endpoints using appropriate authentication headers.
- Use ADMIN credentials to access endpoints requiring ADMIN role.
- Use USER credentials to access endpoints requiring USER role.

## Note

- Ensure that proper authentication tokens are included in the request headers.

### Sample Request

```json
POST /api/v1/cars-information
{
  "make": "Toyota",
  "model": "Camry",
  "year": "2022",
  "engine": "V6",
  "acceleration": "0-60 mph in 6.5 seconds",
  "fuelType": "Gasoline"
}
