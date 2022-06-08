## Swagger
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#

Starting app with SpringBoot:
```
mvn spring-boot:run
```

## CURL endpoints

Retrieving all available models:
```
curl -X 'GET' 'http://localhost:8080/light/models' -H 'accept: */*'
```

ALBERT NER:
```
curl -X 'POST' \
  'http://localhost:8080/light/annotate' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "modelName": "albert_ner",
  "text": "My name is Danilo and I work at John Snow Labs"
}'
```

Clinical DeIdentification:
```
curl -X 'POST' \
  'http://localhost:8080/light/annotate' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "modelName": "clinical_deid",
  "text": "My name is Danilo and I work at John Snow Labs"
}'
```

## Containerized in Docker
```
mvn clean compile
mvn clean package
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
```

```
sudo docker-compose up --build
```
