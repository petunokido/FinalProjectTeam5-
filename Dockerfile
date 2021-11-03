#Image that we are using
FROM openjdk:11
ADD target/ProjetoFinal.jar projetofinal.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "projetofinal.jar"]