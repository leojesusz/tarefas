# Estágio 1: Compilar o código
FROM eclipse-temurin:17-jdk-alpine AS build
COPY . .
# Adicionamos o chmod +x aqui para dar permissão ao arquivo
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Estágio 2: Rodar o projeto
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]