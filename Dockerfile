# Substituímos a imagem antiga por uma alternativa atualizada
FROM eclipse-temurin:17-jdk-alpine
# Copia o seu jar (o Maven vai gerar ele)
COPY target/*.jar app.jar
# Define a porta
ENTRYPOINT ["java","-jar","/app.jar"]