# auth-lib

## Overview
`auth-lib` is a JWT configuration project for APIs that can be used both as a standalone microservice in a microservices architecture and as a library in other Spring projects. It implements JWT authentication configuration.

# test-auth-jwt

## Overview
`test-auth-jwt` is an implementation of an API that uses auth-lib as its library. It serves to test authenticated routes using the JWT authentication configuration present in the auth-lib project.


## Features
- JWT authentication configuration for Spring applications.
- Can be used as a standalone microservice or as a library in other projects.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven or Gradle

### Installation

#### As a Library
To use `auth-lib` as a library in your Spring project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>auth-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### As a Microservice
To use `auth-lib` as a microservice in your Spring project:

```bash
git clone https://github.com/mathews-alves-2019/auth-jwt.git
cd auth-lib
mvn clean install
```

Then you can run the application.