# Spring Boot 2 Example Project

Projeto de exemplo utilizando Spring Boot 2, testes unitários e integração convertendo para jar ou web.

Para gerar os pacotes utilizar:
- `mvn clean package -Pjar` (Gera Spring Boot Jar)
- `mvn clean package -Pwar` (Gera um war para implantar no wildfly)

Se quiser testar diretamente no eclipse
- `clean spring-boot:run`

Se quiser testar com deploy no wildfly (Servidor deve estar iniciado)
- `mvn clean wildfly:undeploy wildfly:deploy`
