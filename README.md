# Labseq Project

## Description
REST service implementation using Quarkus framework for calculating values from the labseq sequence, with Angular (TypeScript) web GUI.

## Labseq Sequence Definition
The labseq sequence l(n) is defined as:
- n=0 => l(0) = 0
- n=1 => l(1) = 1  
- n=2 => l(2) = 0
- n=3 => l(3) = 1
- n>3 => l(n) = l(n-4) + l(n-3)

Example: 0, 1, 0, 1, 1, 1, 1, 2, 2, 2, 3, ...

## Project Structure
```
labseq-project/
├── backend/
│   └── labseq/          # Quarkus Java backend
├── frontend/
│   └── labseq-ui/       # Angular frontend
└── README.md
```

## Assumptions Made
1. **Caching Strategy**: Used ConcurrentHashMap for thread-safe caching with optimized calculation starting from the highest cached value to minimize redundant calculations.
2. **Response Format**: Returns BigInteger values as strings to handle large numbers in JSON.


## Backend (Quarkus)

### Prerequisites
- Java 21+
- Maven 3.8+

### Running the Backend
```bash
cd backend/labseq
./mvnw quarkus:dev
```

The backend will start on `http://localhost:8080`

### API Documentation
Access Swagger UI at: `http://localhost:8080/q/swagger-ui`

### API Endpoint
- **GET** `/labseq/{n}` - Calculate labseq value at position n
  - **Parameter**: n (non-negative integer)
  - **Response**: Labseq value as string
  - **Error**: 400 if n is negative

### Example Usage
```bash
curl http://localhost:8080/labseq/10

# Response: "3"
```

## Frontend (Angular)

### Prerequisites
- Node.js 18+
- Angular CLI

### Running the Frontend
```bash
cd frontend/labseq-ui
npm install
ng serve
```

The frontend will start on `http://localhost:4200`

## Performance
- Optimized caching mechanism ensures l(100000) calculation completes under 10 seconds
- Thread-safe implementation using ConcurrentHashMap
- Efficient algorithm that reuses previously calculated values

## Testing
Test the performance requirement:
```bash
curl http://localhost:8080/labseq/100000
# Should complete in under 10 seconds
```

## Docker
```bash
cd backend/labseq
./mvnw clean package
docker build -t labseq-backend .
docker run -p 8080:8080 labseq-backend
```
