FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/Timesheet_Devops1-1.0.jar Timesheet_Devops1-1.0.jar
ENTRYPOINT ["java","-jar","/Timesheet_Devops1-1.0.jar"]