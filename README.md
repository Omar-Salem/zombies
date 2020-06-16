# README #

### Problem Description ###

After the nuclear war, a strange and deadly virus has infected the planet. Living creatures
are becoming zombies that spread their zombiness by an unfriendly bite. The world consists
of an ​ n ​ x​ n ​ grid on which ​ zombies​ ​ and ​ creatures​ live.

Both of these occupy a single square on the grid and can be addressed using zero-indexed
x-y coordinates. Top left corner is ​ (x: 0, y: 0)​ with x represent horizontal coordinate, y
represent vertical coordinate. Any number of zombies and creatures may occupy the same
grid square.

At the beginning of the program, a single zombie awakes and begins to move around the
grid. It is given an initial x-y coordinate and a list of movements, up, down, left and right. E.g.
(​ U ​ , ​ D ​ , ​ L ​ , ​ R ​ ).


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
