# Usa uma imagem oficial do Java
FROM openjdk:17-jdk-slim
# Copia o seu jar (o Maven vai gerar ele)
COPY target/*.jar app.jar
# Define a porta
ENTRYPOINT ["java","-jar","/app.jar"]git add Dockerfile