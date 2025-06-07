FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

# Dar permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

# Compilar sin tests
RUN ./mvnw package -DskipTests

# Ejecutar el jar exacto
CMD ["java", "-jar", "target/vedrunaBack-0.0.1-SNAPSHOT.jar"]
