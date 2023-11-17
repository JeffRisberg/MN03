## Micronaut 4.2.0 Documentation

- [User Guide](https://docs.micronaut.io/4.2.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.2.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.2.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
## Feature testcontainers documentation

- [https://www.testcontainers.org/](https://www.testcontainers.org/)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature lombok documentation

- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)

- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)


## Feature flyway documentation

- [Micronaut Flyway Database Migration documentation](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)

- [https://flywaydb.org/](https://flywaydb.org/)


## test this as

./gradlew test

## run this as

./gradlew run

## sample urls

curl http://localhost:8080/charities/list

curl -X POST http://localhost:8080/charities -H 'Content-Type: application/json' -d '
{"name": "American Cancer", "ein": "56-5555", "description": "example"}
'

curl http://localhost:8080/charities/list

curl http://localhost:8080/donors/list

curl -X POST http://localhost:8080/donors -H 'Content-Type: application/json' -d '
{"firstName": "Bob", "lastName": "Smith", "address": "Palo Alto, CA"}
'

curl http://localhost:8080/donors/list

curl -X POST http://localhost:8080/donations -H 'Content-Type: application/json' -d '
{"donor_id": 1, "charity_id": 1, "amount": 2000.0}
'

curl -X DELETE http://localhost:8080/donors/1

curl -X DELETE http://localhost:8080/charities/1

