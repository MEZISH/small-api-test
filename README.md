### Introduction

This is a homework solution for https://jsonplaceholder.typicode.com/ API with following requirements:
 * a) Get a random user (userID) , print its address to output and verify email
format is correct
 * b) Using userID Get their associated posts and verify they contains a valid id,
title and body
 * c) Do a post using same userID with a valid title and body

### Preconditions

* Windows, Linux or Mac OS
* Internet connection
* Installed Java 

### Overall description

Project is written in Groovy, using BDD approach (Cucumber).
Test description located at `src/test/resources/at/features`, step definitions located at `src/test/groovy/at/stepdefs` and most technical code is located at `src/main/groovy/at`.

In my opinion REST response data should be encapsulated, so solution was created for such API - for particular case differences are adjusted in the code.

### Launch guide

1. You can launch the test by executing command `gradlew clean build`. It will launch Gradle build system to clean existing build directory, re-build the project and launch the test.
  You can test against custom API endpoint by passing argument `-DapiUrl=<URL>` e.g. `gradlew clean build -DapiUrl=http://microsoft.com`
  *Please note that in this case the address output will be displayed in the build report located in build directory: `build/reports/index.html`. You must choose `at` package, `TestRunner` class and `Standard output`!*

2. You can launch the test from UI of the IDE by using JUnit test runner class `src/test/groovy/at/TestRunner.groovy`.
In this case you can test against custom API endpoint by passing `api.url` environment variable with URL in run configuration.