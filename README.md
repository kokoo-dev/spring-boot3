# Spring Boot 3 Migration

## Java

- <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/build.gradle#L11">17 이상으로 변경</a>
- <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/src/main/java/com/kokoo/springboot3/cloud/CloudController.java#L5">import 패키지 변경 (javax.* -> jakarta.*)</a>

## Spring Cloud

### Spring Cloud Sleuth
Micrometer Tracing 프로젝트로 이동

- 의존성 변경
  - spring cloud sleuth 의존성 제거
  - <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/build.gradle#L43">micrometer-tracing-bridge-brave 추가</a>
  - <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/build.gradle#L46">OpenFeign 사용의 경우 추가</a>
- <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/src/main/java/com/kokoo/springboot3/cloud/CloudController.java#L3">import 패키지 변경 (org.springframework.cloud.sleuth.* -> io.micrometer.tracing.*)</a>
- 설정 파일 수정
  - <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/src/main/resources/application.yml#L1">OpenFeign Tracing 활성화</a>
  - <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/src/main/resources/application.yml#L7">로깅 패턴 수동 설정</a>
  - <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/src/main/resources/application.yml#L16">전파 방식 지정</a>

참고: https://github.com/micrometer-metrics/tracing/wiki/Spring-Cloud-Sleuth-3.1-Migration-Guide


### Spring Cloud Config

- Client 변경 없음
- <a href="https://github.com/kokoo-dev/spring-boot3-cloud-config">Server 변경 없음</a>

### Spring Cloud Openfeign
변경 없음

### Spring Cloud Gateway

<a href="https://github.com/kokoo-dev/spring-boot3-cloud-gateway">변경 없음</a>

### Spring Cloud Zookeeper
변경 없음

## Swagger

- <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/build.gradle#L55">의존성 변경 (spring-fox -> springdoc)</a>
- <a href="https://github.com/kokoo-dev/spring-boot3/blob/d7d09f792fb43631ee5b46daeb080a8b6b9e73b6/src/main/resources/application.yml#L28">프로퍼티 이름 변경 (springfox.documentation -> springdoc.swagger-ui)</a>

그 외 migration 참고: https://springdoc.org/#migrating-from-springfox 