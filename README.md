# README #

### Assumptions ###
* json input file will always have valid simulation data. i.e: no malformed directions, only (​ U ​ , ​ D ​ , ​ L ​ , ​ R ​ ), zombie positions and creatures' positions are within bounds of the grid, etc.
* no test for main class as it would require injection of dependencies, which I deemed an overkill for this task.

### Requirements ###

* Java 8
* Maven

### How to build and run ###

```
cd zombies
mvn clean install
java -jar target/zombies-1.0-SNAPSHOT.jar {path to file}
```
