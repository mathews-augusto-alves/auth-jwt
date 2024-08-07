# auth-jwt

`auth-jwt` is a Java library for authentication and authorization using JWT (JSON Web Tokens). This library provides a set of tools for securing your Spring Boot applications, including user authentication and role-based access control.

## Contact

For more information, you can contact the project maintainer:

- **LinkedIn**: [Mathews Alves](https://www.linkedin.com/in/mathews-alves)
- **Email**: [mathews.alves.job@outlook.com](mailto:mathews.alves.job@outlook.com)


## Technologies Used

- **Java 17**: The primary programming language.
- **Spring Boot 3.3.2**: Framework for building the application.
- **JPA (Java Persistence API)**: For database operations.
- **JJWT**: Library for creating and parsing JWT tokens.
- **ModelMapper**: For object mapping.
- **Lombok**: For reducing boilerplate code.
- **H2 Database**: In-memory database for development and testing.

## Features

- JWT-based authentication
- User registration and login
- Role-based access control
- Exception handling and validation

## Documentation and Standards

This project adheres to the following principles and standards:

### Clean Code

- **Focus**: Writing readable and maintainable code.
- **Principles**: Emphasizes simplicity, clarity, and minimalism.
- **Practices**: Includes meaningful naming conventions, small functions, and code comments.

### Clean Architecture

- **Focus**: Structuring the project for separation of concerns and scalability.
- **Layers**: Adopts a layered architecture to separate business logic from infrastructure and presentation concerns.
- **Principles**: Encourages independence of layers and ease of testing and maintenance.

By following these principles, the project aims to ensure high-quality code that is both maintainable and scalable.


## Installation and Setup

### Prerequisites

- **Java 17**: Ensure that Java 17 is installed on your machine.

### Clone the Repository

```bash
git clone https://github.com/your-username/auth-jwt.git
cd auth-jwt
```

## API Examples

### Retrieve Available Roles

Use the following `curl` command to retrieve the available roles that can be assigned to a user:

```bash
curl --request GET \
  --url http://localhost:8080/api/public/roles \
```

### Register a New User

Use the following `curl` command to register a new user:

```bash
curl --request POST \
  --url http://localhost:8080/api/public/register \
  --header 'Content-Type: application/json' \
  --data '{
    "username": "admin",
    "password": "adminpass",
    "roles": [
      {
        "id": "410fc019-f6e3-410b-a7bd-0ec877454e9e",
        "name": "ROLE_ADMIN"
      }
    ]
}'
```

### Log In and Retrieve Token

Use the following `curl` command to log in and retrieve the authentication token:

```bash
curl --request POST \
  --url http://localhost:8080/api/public/auth/login \
  --header 'Content-Type: application/json' \
  --data '{
    "username": "admin",
    "password": "adminpass"
}'
```

### Test auth

Use the following `curl` command to test authentication:

```bash
curl --request GET \
  --url http://localhost:8080/api/test/ \
  --header 'Authorization: your_token' \JSESSIONID=AE98C018C9C2BCEED8420CDF24C80CF1'
```

