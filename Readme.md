# Library Management API

## Project Overview
A Spring Boot RESTful API for managing a book library with Docker support.

## Prerequisites
- Java 17+
- Maven
- Docker
- Docker Compose

## Running the Application

### Local Development
1. Clone the repository
2. Build the project: `./mvnw clean package`
3. Run the application: `./mvnw spring-boot:run`

### Docker Deployment
1. Build and start services:
   ```
   docker-compose up --build
   ```

## API Endpoints
- `GET /books`: List all books (with pagination)
- `GET /books/{id}`: Get book by ID
- `POST /books`: Create a new book
- `PUT /books/{id}`: Update an existing book
- `DELETE /books/{id}`: Delete a book
- `GET /books/search?query=`: Search books by title or author



## Technologies
- Spring Boot
- Spring Data JPA
- H2 Database
- Docker

## Docker Deployment

### Prerequisites
- Docker
- Docker Compose

### Build and Run
```bash
# Clone the repository
git clone <your-repo-url>
cd library-management-api

# Build the Docker image
docker-compose build

# Start the application
docker-compose up

# Stop the application
docker-compose down
```

### Accessing the Application
- API Base URL: `http://localhost:8080`
- H2 Console: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:librarydb`
   - Username: `sa`
   - Password: `password`

### Common Docker Commands
```bash
# View running containers
docker ps

# View logs
docker-compose logs library-app

# Rebuild without cache
docker-compose build --no-cache
```