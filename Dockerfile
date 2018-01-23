FROM java:8
MAINTAINER RORY LANDER
COPY ./target/RLSB1-0.0.1-SNAPSHOT.jar /home/RLSB1-0.0.1-SNAPSHOT.jar
COPY ../../Keys/Appkeypair/publicKey /home/publicKey
EXPOSE 8080
CMD ["java","-jar","/home/RLSB1-0.0.1-SNAPSHOT.jar"]