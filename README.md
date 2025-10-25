# JPA Many-to-One Project

[![CI/CD Pipeline](https://github.com/[DIT-BRUGERNAVN]/JPAManyToOne/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/[DIT-BRUGERNAVN]/JPAManyToOne/actions/workflows/ci-cd.yml)
[![Simple CI](https://github.com/[DIT-BRUGERNAVN]/JPAManyToOne/actions/workflows/simple-ci.yml/badge.svg)](https://github.com/[DIT-BRUGERNAVN]/JPAManyToOne/actions/workflows/simple-ci.yml)

## 📖 Beskrivelse
En Spring Boot applikation der demonstrerer JPA Many-to-One relationship mellem Region og Kommune entiteter.

## 🚀 Features
- ✅ REST API endpoints for Regioner og Kommuner
- ✅ JPA Many-to-One relationships
- ✅ H2 database til testing
- ✅ MySQL database til produktion
- ✅ Docker support
- ✅ GitHub Actions CI/CD
- ✅ Comprehensive test suite

## 🏗️ Teknologier
- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **MySQL** (produktion) / **H2** (test)
- **Docker**
- **GitHub Actions**
- **Maven**

## 🏃‍♂️ Kør Applikationen

### Med Docker Compose:
```bash
docker-compose up -d
```

### Lokalt med Maven:
```bash
./mvnw spring-boot:run
```

### Med Docker (build selv):
```bash
./mvnw package -DskipTests
docker build -t jpa-manytoone .
docker run -p 8080:8080 jpa-manytoone
```

## 🧪 Tests
```bash
# Kør alle tests
./mvnw test

# Kun unit tests
./mvnw test -Dtest="Simple*Test"
```

## 📊 API Endpoints

### Regioner:
- `GET /regioner` - Hent alle regioner
- `GET /region/{kode}` - Hent specifik region
- `POST /region` - Opret ny region
- `DELETE /sletregion/{kode}` - Slet region
- `GET /kommunenavne/{kode}` - Hent kommuner i region

### Kommuner:
- `GET /kommuner` - Hent alle kommuner
- `GET /kommune/{kode}` - Hent specifik kommune
- `DELETE /sletkommune/{kode}` - Slet kommune
- `GET /regioner-og-kommuner` - Hent regioner grupperet med kommuner

### Tools:
- `GET /tool/getregioner` - Hent regioner fra ekstern API
- `GET /tool/getkommuner` - Hent kommuner fra ekstern API

## 🗄️ Database
Applikationen bruger:
- **MySQL** til produktion (via Docker Compose)
- **H2** til tests (in-memory)

## 🔧 Configuration

### application.properties:
```properties
spring.datasource.url=jdbc:mysql://mysql:3306/regionkommune
spring.datasource.username=jens
spring.datasource.password=x
spring.jpa.hibernate.ddl-auto=update
```

### Test configuration (application-test.properties):
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create-drop
```

## 🚀 CI/CD Pipeline

Dette projekt bruger GitHub Actions til automatisk:
1. **Testing** - Kører alle tests ved hver commit
2. **Building** - Kompilerer og pakker applikationen
3. **Docker Build** - Builder Docker image
4. **Deployment** - (Kan konfigureres til din server)

Se [CI-CD-README.md](CI-CD-README.md) for detaljer.

## 📈 Project Structure
```
src/
├── main/java/com/example/jpamanytoone/
│   ├── controller/          # REST Controllers
│   ├── model/              # JPA Entities
│   ├── repository/         # Data Access Layer
│   ├── service/            # Business Logic
│   └── config/             # Configuration
└── test/java/com/example/jpamanytoone/
    ├── SimpleModelTest.java      # Model tests
    ├── SimpleRepositoryTest.java # Repository tests
    └── SimpleControllerTest.java # Controller tests
```

## 👥 Contributing
1. Fork repository
2. Opret feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push til branch (`git push origin feature/AmazingFeature`)
5. Åben Pull Request

## 📝 License
Dette projekt er lavet til uddannelsesformål på KEA Datamatiker.

---

**Happy Coding! 🎉**

---

**Husk at ændre `[DIT-BRUGERNAVN]` til dit faktiske GitHub brugernavn i badge URLs!**