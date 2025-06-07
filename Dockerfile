FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

# Dar permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

# Compilar sin tests
RUN ./mvnw package -DskipTests

CMD ["java", "-jar", "target/*.jar"]
