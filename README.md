# spring-boot-serialize-immutable-objects
Spring Boot • Serialize Immutable Objects

## Prerequisites

- JDK 11+ is installed
- JAVA_HOME is defined in the shell environment and the java executable is in the system path.

## Building

This project uses maven wrapper, so maven will be downloaded on-the-fly on the first build.

```shell
# build
$ ./mvnw verify

# clean and build
$ ./mvnw clean verify
```

Expect a build success is printed in the console after executing maven verify.

```shell
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.191 s
[INFO] Finished at: 2021-11-03T10:51:32-07:00
[INFO] ------------------------------------------------------------------------
```