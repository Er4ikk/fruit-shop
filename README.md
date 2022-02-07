# fruit-shop

basic app that manages a small fruit shop:
-insert new slot of products
-delete slot of products
-show current slots 
-modify slot by id
-sell slot/s
-show current sales and the iva


#description:
java project with maven 4.0.0
junit 4.11 for local test cases (silenced after the db update)
for interfacing with mongo db i used the maven shade plugin (3.2.0)
and then i icluded the support for mongojava (taken from mvn central repository)
-------------------------------------------------------
This plugin provides the capability to package the artifact in an uber-jar, including its dependencies and to shade - i.e. rename - the packages of some of the dependencies.
https://maven.apache.org/plugins/maven-shade-plugin/ 
-------------------------------------------------------------
What is a uber jar?

An uber-JAR—also known as a fat JAR or JAR with dependencies—is a JAR file that contains not only a Java program, but embeds its dependencies as well. This means that the JAR functions as an “all-in-one” distribution of the software, without needing any other Java code. (You still need a Java runtime, and an underlying operating system, of course.)
https://imagej.net/develop/uber-jars
sort of java container
------------------------------------------------------------

for ci/cd pipeline i used git actions-->easy to use and automated
--> java with maven CI jdk 11
--> maven.yml contains all the info of the ci/cd pipeline
--> little bug that i encounterd was the file destination of pom fixed in maven.yml update
-------------------------------------------------------------
for the static analysis i used checkstyle for git actions(plugin)
is a plugin written by nikitasavinov/checkstyle-action@master --> this is the repo
it runs a docker image based on openjdk 8 alpine  and then runs the program inside the container
it use as confiuration of check style :google_checks.xml
https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml
--------------------------------------------------------------------------
SLF4J-->warning when mongodb was running locally something to do with logins etc
The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time. 
https://www.slf4j.org/
--------------------------------------------------------------------------

# docker
for running the app we first must install docker

command to build the image (current one is -> relateiq/oracle-java8)
docker build -t fruit-shop-final . --> from the docker file directory

command to run the image (-it is for interactive shell)
docker run -it -p 8080:8080 --name <container_name>  fruit-shop-final
command to start the container
docker start <container_name>

command to attach container(press some numbers after the command to view the ui)
docker attach <container_name>


# docker-compose
docker-compose up --> from the docker-compose.yml directory
(in new terminal)docker attach <container_name>
press some numbers to unlock the ui

----------------------------------------------------------------------------
used this image for docker :
relateiq/oracle-java8 
with open jdk 11 and maven i had some troubles and exceptions(this images didn t recognize commands such
as mvn java etc ) so i got this image from docker hub and it worked out well
installed maven and build the program succcessfully.

then i downloaded the mongodb image (official) that runs on a separate container
using the plugin of mongodb for maven i made the crud operations for the program.

When i tried to run the app and the db in docker i encauntered multiple problems
most of them because this two containers weren't on the same network or because 
the default network didn t had a dns so ip adresses weren t correc(never run mongodb in 
a container with localhost because it won t get requestes and will launch SocketException).

Using docker-compose is much easier because it created an own network for the two containers
db and app and also it has a dns server so inside the code i only typed the service name of the db
(containd in the docker compose) and everything runs like it shuold be.

anyway there is a little bug but it is nothing to worry about :
after launching docker-compose up from the docker-compose.yml directory 
you will se the app running but you can t interact with it ... so a solution is 
to docker attach the appp from a new terminal window typing some numbers and 
the app will run on this new terminal (anyway to stop everything you just need to type 0
on the terminal running the app and ctr+c on the docker-compose up terminal) 
