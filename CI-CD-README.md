# JPA Many-to-One Project

## 🚀 GitHub Actions CI/CD

Dette projekt har to GitHub Actions workflows:

### 1. **Simple CI** (`simple-ci.yml`)
- ✅ Kører tests
- ✅ Builder applikationen
- ✅ Uploader JAR fil som artifact

**Kører når:** Du pusher til `main` branch eller laver pull request

### 2. **Fuld CI/CD Pipeline** (`ci-cd.yml`)
- ✅ Kører tests
- ✅ Builder applikationen  
- 🐳 Builder Docker image
- 🚀 Deployer applikationen
- 📢 Sender notifikation

**Kører når:** Du pusher til `main` eller `dev` branch

## 📋 Hvad Sker Der?

### Ved hver commit/push:
1. **🔍 Checkout** - GitHub henter din kode
2. **☕ Setup Java** - Installer Java 17
3. **🧪 Run Tests** - Kører alle dine tests
4. **🔨 Build** - Kompilerer og pakker applikationen
5. **📦 Upload** - Gemmer JAR filen som artifact

### Hvis alt går godt:
- ✅ Grønt checkmark ved dit commit
- 📦 JAR fil er klar til download
- 🚀 (Valgfrit) Applikation deployes automatisk

### Hvis noget fejler:
- ❌ Rødt kryds ved dit commit  
- 📧 Du får besked om hvad der gik galt
- 🛠️ Fix problemet og push igen

## 🛠️ Setup Instructions

### 1. **Aktivér GitHub Actions**
- Gå til dit GitHub repository
- Klik på "Actions" tab
- GitHub finder automatisk dine workflow filer

### 2. **Tilpas til Dine Behov**
Rediger `.github/workflows/ci-cd.yml`:

```yaml
# Skift branches efter behov
branches: [ main, dev, feature/* ]

# Tilføj Docker Hub login (valgfrit)
- name: Login to Docker Hub
  uses: docker/login-action@v3
  with:
    username: ${{ secrets.DOCKER_USERNAME }}
    password: ${{ secrets.DOCKER_PASSWORD }}
```

### 3. **Tilføj Secrets (valgfrit)**
Gå til Settings → Secrets and variables → Actions:
- `DOCKER_USERNAME` - Dit Docker Hub brugernavn
- `DOCKER_PASSWORD` - Dit Docker Hub password/token

### 4. **Database Config (valgfrit)**
Workflows bruger H2 database til tests, men du kan skifte til MySQL:

```yaml
env:
  SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/regionkommune
  SPRING_DATASOURCE_USERNAME: jens  
  SPRING_DATASOURCE_PASSWORD: x
```

## 📊 Workflow Status

Du kan se status på:
- GitHub repository → Actions tab
- Ved hver commit (grønt ✅ eller rødt ❌)
- I pull requests

## 🎯 Best Practices

1. **Branch Protection** - Kræv at CI passes før merge til main
2. **Test Coverage** - Sørg for dine tests dækker vigtig funktionalitet
3. **Fast Feedback** - Hold workflows hurtige (under 5 min)
4. **Security** - Brug secrets til passwords og tokens
5. **Notifications** - Setup Slack/Discord notifikationer

## 🔧 Troubleshooting

### Tests fejler?
```bash
# Kør lokalt først:
./mvnw test

# Check logs i GitHub Actions tab
```

### Build fejler?
```bash
# Test build lokalt:
./mvnw package

# Check Java version matcher (17)
```

### Docker build fejler?
```bash
# Test lokalt:
docker build -t test .
```

---

**Happy Coding! 🎉**