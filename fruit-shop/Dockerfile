FROM relateiq/oracle-java8
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /com/app/pom.xml
COPY src /com/app/src
WORKDIR /com/app
RUN mvn  package
CMD ["java","-jar","target/fruit-shop-0.0.1-SNAPSHOT.jar"]