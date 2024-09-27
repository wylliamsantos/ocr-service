FROM openjdk:21-slim

ENV TESSDATA_PREFIX=/usr/local/share/tessdata

RUN apt-get update && apt-get install -y \
    tesseract-ocr \
    && apt-get clean

WORKDIR /usr/app

COPY build/libs/ocr-service.jar /usr/app/ocr-service.jar
COPY src/main/resources/tessdata ${TESSDATA_PREFIX}

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ocr-service.jar"]