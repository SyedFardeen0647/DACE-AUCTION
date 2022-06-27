FROM openjdk:11
EXPOSE 8080
ADD target/spring-boot-auction.jar spring-boot-auction.jar
ENTRYPOINT ["java","-jar","/spring-boot-auction.jar"]