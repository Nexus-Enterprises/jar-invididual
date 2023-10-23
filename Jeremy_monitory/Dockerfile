# Use a imagem oficial do OpenJDK para Java
FROM openjdk:17-oracle

# Crie um diretório no contêiner para seu aplicativo
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY Nexus/target/Nexus-1.0-jar-with-dependencies.jar /app/Nexus-1.0.jar

# Exponha a porta da aplicação (se necessário)
EXPOSE 8080

# Configure as variáveis de ambiente para o MySQL (se necessário)
ENV MYSQL_ROOT_PASSWORD secret
ENV MYSQL_DATABASE Jeremy
ENV MYSQL_USER root
ENV MYSQL_PASSWORD secret

# Execute sua aplicação Java quando o contêiner for iniciado
CMD ["java", "-jar", "/app/Nexus-1.0-jar-with-dependencies.jar"]

