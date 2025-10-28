# Employee Management API

Projek ini merupakan sistem manajemen karyawan yang memungkinkan untuk mengelola data karyawan.
Sistem ini dibangun dengan menggunakan SpringBoot Java dengan Database PostgreSQL

---

## 🛠️ Tech Stack yang di gunakan :
* **Java**: Java 17
* **Spring Boot**:= Springboot 3.5.7
* **Gradle**: Dependency management and build tool
* **Spring Data JPA**: Data persistance
* **[Database]**: PostgreSQL
* **Docker**: Containerization
* **Swagger UI**: API Documentation

---

## 📋 Prerequisites
Hal - hal yang diperlukan agar projek ini bisa berjalan :
* JDK [e.g., 17] or newer
* Gradle
* Docker and Docker Compose

---

## ⚡ Cara Menjalankan Projek Ini

**Notes :**
Dikarenakan konfigurasi yang saya buat tidak memiliki image untuk db PostgreSQL pada `docker-compose.yml` file, oleh karenanya diperlukan untuk menambahkan
konfigurasi untuk setup images pada PostgreSQL. Sebagai berikut :

``` bash
version: '3.8'

services:
  # Tambahkan service untuk menambahkan image PostgreSQL
  db:
    image: postgres:latest
    container_name: postgres-db
    environment:
      - POSTGRES_USER=namauser # Silahkan isi nama user anda
      - POSTGRES_PASSWORD=namapassword # Silahkan isi password anda
      - POSTGRES_DB=namadatabase # Silahkan isi nama database anda
    ports:
      - "5432:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data
    networks:
      - my-network

  app:
    build: .
    container_name: springboot-api
    ports:
      - "8080:8080"
    environment:
      # Ubah Konfigurasi Berikut jika menggunakan Image baru PostgreSQL
      - DB_HOST=db
      - DB_PORT=5432
      - DB_NAME=namadatabase 
      - DB_USER=namauser
      - DB_PASS=namapassword
    networks:
      - my-network
    depends_on:
      - db

networks:
  my-network:
    driver: bridge

# Tambahkan volume untuk storage buat services db
volumes:
  postgres-data:
    driver: local
```

Jika sudah bisa lanjut ke langkah selanjutnya.

### 1. Clone Repo
Pertama, Clone repo dengan command berikut :
```bash
git clone [https://github.com/admalfrizi/test-juke.git](https://github.com/admalfrizi/test-juke.git)
cd test-juke
```
### 2. Setup Project

Tambahkan konfigurasi untuk application.properties sebagai berikut :
``` bash
spring.application.name=test-juke
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driver-class-name=org.postgresql.Driver
springdoc.swagger-ui.path=/swagger-ui.html
```

#### Sebelum melakukan build pada grade harap dipastikan semua dependency di file `build.gradle` di update ke versi baru

Jalankan command pada terminal jetbrains untuk Melakukan build pada gradle :
``` bash
./gradlew build
```

### 3. Setup Docker 
Setelah melakukan konfigurasi pada projeknya, selanjutnya melakukan setup untuk docker container. Secara default repo ini 
sudah memiliki file `docker-compose.yml` untuk menyimpan konfigurasi container yang akan dijalan dengan **Docker Compose**
dan `Dockerfile` untuk membuat docker image pada project tersebut, Lalu jalankan command berikut :
``` bash
docker-compose up --build
```

### 4. Projek Sudah Dijalankan 
Selanjutnya, projek sudah berjalan dengan url `http://localhost:8080/` untuk bisa mengakses dokumentasi api, dapat mengakses untuk
URL berikut `http://localhost:8080/swagger-ui/index.html`






