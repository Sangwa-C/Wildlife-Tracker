# Wildlife-Tracker

## *By Sangwa Sabine Chelsea*

## Description

This is an app that allows the user to make list of animals and add them to the database, moreover to track endangered animals sighted in the wild.

Project which I am provided with the code containing the basic classes, Spark setup, HandlebarsTemplateEngine, hbs template structure, routing in App.java, tests, and database setup instructions. 

The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. This application was developed to allow Rangers to track wildlife sightings in the area.

# Install

## Pre-requisites

  1. Ensure you have Java installed 
     (A simple way to install Java is using sdkman.)
     
     sdk install java
  
  2.Gradle
    Gradle is used as the build tool and can be installed with sdkman:
  
    sdk install gradle
  
  3.Postgres.
  (Enter y when prompted “Do you want to continue? [Y/n]” and wait for the installation to complete. 0r <a href="https://www.postgresql.org/docs/9.3/contrib.html">try this link</a>)
  
    sudo apt-get install postgresql postgresql-contrib libpq-dev
  
  
## Installation guide   
**{follow the below instructions for set up.}**
    
   1. You will need Internet connection.

   2. You need to get into the Wildlife-Tracker Repository.
    
     Link:-> https://github.com/Sangwa-C/Wildlife-Tracker.git
        
   3. From there you can access the Wildlife-Tracker.
    
   4. Clone the project.
    
   5. get into project folder (cd into project).

   6. If you have all the Pre-requisites you can run the application.
    
     gradle run


## Manual Database Creation
To create the necessary databases, launch postgres, then psql, and run the following commands:

* CREATE DATABASE wildlife_tracker;
* \c wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
* CREATE TABLE sight  CREATE TABLE sightings (id SERIAL PRIMARY KEY,name varchar,location varchar,rangeName varchar,health varchar, age varchar);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

## BDD

**The program should allow the user to add an Animal.**

    Input Example: "Animals's Name: Zebra"
                   
**The program should return when the user add an animals to the database** 

    Output Example: "Animals's Name: Zebra"
 
 **The program should allow the user to report an endangered animal**
 
         Input Example: "Animals's Name: Zebra"   
                        "Animal's Health: healthy"
                        "Animals's Age: New born"
                        "Animal's location: zone A"
                        "Reporter's Name: Chelsea"
    
## Known Bugs

<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji>This webpage is not suitable for all screen sizes and it might load slowly if your internet is low.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png"  >
 </g-emoji>   Can submit empty or invalid characters in a non-endangered animal sighting report.
</p> 

 <p>    
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> Can submit empty or invalid characters in an endangered animal sighting report.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> User can submit empty or invalid characters when adding an animal to the system.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> User can not delete entry.
</p>

<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> User can not update entry.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> Recording date of sighting not displayed in detail
</p>


## Technologies Used

* JAVA
* Gradle
* Spark
* HTML
* CSS & Bootstrap
* PostgreSQL
* Junit
* Heroku
 
## Support and contact details
If you any issues or have questions, ideas or concerns contact us on chelseasabinesangwa@gmail.com.

### License
MIT Copyright (c) 2019 Sangwa Sabine Chelsea. # Wildlife-Tracker
