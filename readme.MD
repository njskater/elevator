# A Demo Elevator System
This is a demo application to simulate an elevator system.

------------------------------------
System Requirement:
------------------------------------
Application tested on Mac OSX 10.10 and 10.11  
Requires:  
JDK 1.8+  
MAVEN 3.0+



------------------------------------
To run this application:
------------------------------------
```
mvn spring-boot:run
```


------------------------------------
To send command to elevator system:
------------------------------------
```
curl -X PUT http://localhost:8080/elevator-command -H "content-type:application/json" -d '{"currentLevel":7, "destLevel":2,"passengerNumber":10}'
```


---------------------------------------------------------------
To check elevator moving history from back end data store:
---------------------------------------------------------------
```
curl -X GET http://localhost:8080/elevator-history
```
-------------------------
Extra Configuration
-------------------------
This application is using spring boot as the container and default listening port is 8080.  
If this required to be changed, please modify application.properties file under src/main/resources.  

