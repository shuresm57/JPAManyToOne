# JPA Many-to-One Project

## Beskrivelse
En Spring Boot applikation der demonstrerer JPA Many-to-One relationship mellem Region og Kommune entiteter. Dette projekt er lavet til uddannelsesformål på KEA Datamatiker.

## Teknologier
- Java 17
- Spring Boot 3.5.5
- Spring Data JPA
- MySQL (produktion) / H2 (test)
- Docker
- GitHub Actions
- Maven

## Features
- REST API endpoints for Regioner og Kommuner
- JPA Many-to-One relationships
- H2 database til testing
- MySQL database til produktion
- Docker support
- GitHub Actions CI/CD

## API Endpoints

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