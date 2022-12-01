FROM openjdk:11

MAINTAINER webj2eedev <webj2eedev@dw.com>

ADD target/ielts8-manage-0.0.1-SNAPSHOT.jar /ielts8-manage.jar

WORKDIR /

CMD ["java","-Duser.timezone=Asia/Shanghai", "-Dspring.profiles.active=prod", "-jar", "ielts8-manage.jar"]

EXPOSE 8081