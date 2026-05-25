# Stage 1: Build (Pakai Alpine agar ringan + batasi memori Maven)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Batasi penggunaan RAM Maven agar tidak di-kill oleh Render (Maksimal 300MB untuk build)
ENV MAVEN_OPTS="-Xmx300m -XX:MaxMetaspaceSize=128m"

# Trik Caching: Copy pom.xml duluan untuk download dependencies.
# Jika pom.xml tidak berubah, langkah ini akan di-skip saat build ulang (jauh lebih cepat!)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Baru copy source code dan jalankan build tanpa dokumentasi javadoc
COPY src ./src
RUN mvn clean package -DskipTests -B -Dmaven.javadoc.skip=true

# Stage 2: Run (Pakai JRE Alpine yang super ramping)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Salin file jar hasil build
COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Batasi RAM runtime Java agar muat di spek gratisan Render yang cuma 512MB
ENTRYPOINT ["java", "-Xmx300m", "-Xms150m", "-jar", "app.jar"]