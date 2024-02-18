# Car Information API

This API provides endpoints to manage car information. Users can create, update, delete, and retrieve car information based on their permissions.

# Technologies Used
### Java 17
### Spring-boot 3
### Spring-security 6
### Swagger 2
### PostgreSql/H2
### Lombok

# How To Launch
1. Build the project using command: "mvn clean install"
2. Navigate through the terminal to info-service package where docker-compose file is located
3. Use command in the terminal "docker-compose up" to launch DB and built service.
## Launch Notes
1. There are two profiles: test and present.
   If you want to switch spring profiles, open docker-compose file, find SPRING_PROFILES_ACTIVE: change from present to test, by default it's present.
2. mvn clean install also runs all tests if you want to skip test run you can use "mvn clean install -DskipTests".

# How To Test
1. Open postman
2. Host is localhost, port 8080
3. First need to call localhost:8080/api/v1/login with:
   ```json
   {
   "username":string,
   "password":string
   }
since users are pre-loaded into the DB you can use thier username/password depending on your need for roles.

4. You will get a accessToken response with a JWT if username/password is correct.
5. Put JWT into Authorization section of postman, type is Barrer Token.
6. Call the other endpoints to see CRUD functionality.
7. Since JWT stops being valid after 60 second, I recommend to call it each time before calling the /api/v1/cars-information endpoints.

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

### Sample Response

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
