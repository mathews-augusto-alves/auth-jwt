# test-auth-jwt

`test-auth-jwt` is an implementation of an API that uses auth-lib as its library. It serves to test authenticated routes using the JWT authentication configuration present in the auth-lib project.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven or Gradle

## API Examples

### Route for ROLE_ADMIN

After log in using the authentication route on auth-lib, you can get the response token and do the folowing requests: 

```bash
curl --request GET \
  --url http://localhost:8080/api/test/admin-auth/ \
  --header 'Authorization: Bearer _token_'
```

```bash
curl --request GET \
  --url http://localhost:8080/api/test/user-auth/ \
  --header 'Authorization: Bearer _token_'
```