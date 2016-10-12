#revewthedoctors
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

##Country table
A country named Nepal is added.

##Zone table
A Zone named Bagmati is added.

##District table
A District named Kathmandu is added.

##City table
A city named Kathmandu is added.

##Speciality table
Speciality name Pulmonologist with chest as speciality category is added.

##Hospital table
Hospital named 'Grande International Hospital' is added.

##User
One user and one admin is added.
###Admin:
####Name: admin admin admin 
####Email:'admin@gmail.com'
####Password 'test' 
####authority ADMIN_ROLE

###User
####Name: Srija Pokhrel
####Email:'srijapokharel@gmail.com'
####Password 'test' 
####authority User_ROLE 

##Doctor Table
A Doctor with following details is added.

####FirstName: Arjun
####MiddleName: Kumar
####LastName: Karki
####SpecialityName:Pulmonologist
####Hospital:Grande International Hospital.

#User Manual

Chekc out the user manual from
https://medium.com/@Smrita/web-application-walk-through-of-review-the-doctors-a2a4966fed09#.ws0wfj1uc
