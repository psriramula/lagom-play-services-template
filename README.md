# lagom-play-services-template #

[![GitHub version](https://img.shields.io/badge/version-1.0.0-green.svg)](https://github.com/hitachi-dsg/lagom-play-services-template/releases)


lagom-play-services-template is a lagom + play services project template for developers.

It uses a simple Play framework and works with Lagom services model, any other service types ( streams and AKKA can be added on top of this template)

## Prerequisite
---------------
* [JDK 1. 8 ](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), at least version  1.8.0_650
* [sbt ](https://www.scala-sbt.org/download.html), sbt ( Scala Build Tool ) , at least version 1.1.0


## Compiling
---------
To compile the code

```
$ sbt compile
```

## testing
---------
To exectute the tests

```
$ sbt test
```

## Running
----------

To run with in Development environment

```
$ sbt runAll
```


Browse the application via url http://localhost:9000/service-a

## TODO'S
----------
Need to resolve conductR based bundle start issue
Need to add aws docker image capability to suite the delivery pipeline 