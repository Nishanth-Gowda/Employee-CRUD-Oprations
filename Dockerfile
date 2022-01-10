FROM openjdk:17
ADD target/git-jenkins-jntegration.jar git-jenkins-integration.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "git-jenkins-integration.jar"]