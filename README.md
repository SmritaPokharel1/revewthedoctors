##revewthedoctors
Review the doctors is an application that helps people find good doctors. Not just this but it also helps in providing a platform for people to rate and review doctors. There are many technologies that this project uses .Firstly it is written in Java EE and Spring framework — Spring MVC , Spring Data Jpa, Spring security. Secondly it uses MYSQL as its underlying database. Thirdly it uses gradle for dependency management . Lastly it uses git for version control.

#Application Setup  for tomcat

1.Clone reviewthedoctors

2.Run gradlew clean from the terminal

3.Run gradlew build from the terminal

4.Create a database named revewthedoctors in mysql.

5.Deploy the revewthedoctors.war war file which is located at projectroot_folder/build/libs/ to tomcat.

#Application startup

The class com.reviewthedoctors.initialization.Initializor.java is used to populate values in database. 
Following are the data that get populated in the database when the application starts:


#User Manual

Chekc out the project manual from
https://medium.com/@Smrita/web-application-walk-through-of-review-the-doctors-a2a4966fed09#.ws0wfj1uc
