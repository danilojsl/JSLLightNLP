FROM openjdk:11

RUN addgroup --system spring && adduser --system spring && adduser spring spring
USER spring:spring

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*", "com.johnsnowlabs.light.nlp.SpringBootJSLLightNLPApp"]