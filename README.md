# eHotel - CSI2132 Project

## Description

Five of the most well-known hotel chains, with hotels in more than 14 different locations in North America, have decided to collaborate and develop an application that will allow their customers to easily book rooms in their hotels, seeing room availability in real time. You are requested to develop the application that allows the above. 

For every hotel chain we need to know the address of its central offices, the number of its hotels, contact email addresses and phone numbers. The hotels of hotel chains are categorized (e.g. 1-star up to 5-star). For each hotel we need to know the number of rooms, the address of the hotel and contact email and phone numbers for this hotel. For the rooms in a hotel, we need to know their price, all amenities (e.g. TV, air condition, fridge etc), the capacity of the room (e.g. single, double etc), if they have sea view or mountain view, if they can be extended (e.g. adding one more bed) and if there are any problems/damages in the room. For customers we need to store their full name, address and SSN/SIN, the date of their registration into our system. For employees of the hotels, we need to store their full name, address and SSN/SIN. The employees may have various roles/positions in a hotel. Every hotel needs to have a manager. The customers can search for and book rooms through the online application for specific dates. When they check-in the hotel, their room booking is transformed to renting and they can also pay for this renting. The employee that does the check-in for a customer is responsible for transforming the room booking to renting. A customer may present physically at a hotel without a booking and directly ask for a room. In this case the employee at the hotel can do therenting of the room right away without prior booking. We need to store in the database the history of both bookings and rentings (archives), but we do not need to store the history of payments. Information about an old (archived) room booking/renting must exist in the database, even if information about the room itself does not exist in the database anymore. We should be able to delete from our database hotel chains, hotels and rooms. We cannot have in the database information about a room without having in the database the information about the corresponding hotel (i.e. the hotel in which the room belongs too). In the same way, we cannot have in the database information about a hotel without having in the database the information about the corresponding hotel chain (i.e. the hotel chain in which the hotel belongs too). 

## Getting Started

Download a copy of the project on GitHub.

### Prerequisites

What things you need to install the software and how to install them

- Java 1.8+
- NetBeansIDE
  - GlassFish Server (Installed by default on NetBeans)
- Connection to PostgreSQL **OR** the DB can be run locally using JDBC default
- Apache Maven to setup JSF Projects

### Installing

[Install Java 1.8+](https://www.java.com/en/download/manual.jsp)

[Install NetBeansIDE 8.2 from](https://netbeans.apache.org/download/index.html)

[Install Apache Maven](https://maven.apache.org/)

### Checking if the Prerequisites are Installed
##### Verifying that Java 1.8+ is installed:

Follow these steps to [verify Java was installed properly and the environment variable is set](https://www.ibm.com/support/knowledgecenter/en/SS88XH_1.6.0/iva/install_mils_windows_java.html)

#### Verifying Apache Maven is Installed:

Follow these steps to [verify Apache Maven](https://maven.apache.org/install.html)

### Starting NetBeansIDE

1. Open NetBeansIDE
2. Import the project into the Project directory
  - File -> Open Project
  - Navigate to the project location (the file should contain a **POM.xml**)
  - Click **Open Project**
  
### Starting the Glassfish Server
1. Click **Services** in the top left corner beside the project directory
2. Click the drop down for **Servers** in the navigation pane
3. Right click on the GlassFish Server 4.1+
4. Click **Start**
5. Wait for GlassFish to launch (problems may occur if the project is run before the server has fully started; start time varies)
6. To check if GlassFish has started, right click the GlassFish Server 4.1+ again and the option to **Restart** will be avaliable
  
### Start the Database
  - This project can be run on a local database or on a uOttawa server, PostgreSQL database (DB: ctseu025) however, authentication is required to run on the PostgreSQL server
  - For PostgreSQL:
1. Verify that PostgreSQL is the target datatbase:
  - In the project directory, navigate to the **persistence.xml** file
    - eHotel -> Other Sources -> src/main/resources -> META-INF -> persistence.xml
      
2. Verify that the **Data Source** is **java:app/eHotel**
    - persistence.xml -> Design -> CSI2132_eHotel_war_1.0-SNAPSHOTPU -> General: -> Data Source: java:app/eHotel
- In the event that the uOttawa servers are down or the database access is denied 
  - Run the database locally
    - Change the **Data Source** to **jdbc/__default**
      - persistence.xml -> Design -> CSI2132_eHotel_war_1.0-SNAPSHOTPU -> General: -> Data Source: jdbc/__default
        
3. Start the database
  - Navigate to **Services** again in the top left corner beside the project directory
  - Click Databases drop down in the navigation pane
  - Right click **jdbc:postgresql://web0.eecs.uottawa.ca:15432/ctseu025 [ctseu025 on eHotel]**
  - Click **Connect...**
  - For running a local database:
    - Right click **jdbc:derby://localhost:1527/sun-appserv-samples [APP on APP]**
    - Click **Connect...**
      
4. Verify connection to the database
  - Once connected, click the drop down of the database (ctseu025 on eHotel **OR** APP on APP)
  - Click the drop down **APP**
  - Click the drop down **Tables**
  - There should exist a series of tables that are associated with this project (USERACCOUNT, ROOMS, HOTELS, etc.)

### Verify Addition Imports and Configurations
1. Ensure **JavaServer Faces** is installed
2. The **persistence.xml** Source should be configured as follows:
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
  <persistence-unit name="CSI2132_eHotel_war_1.0-SNAPSHOTPU" transaction-type="JTA">
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <jta-data-source>java:app/eHotel</jta-data-source>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <properties>
      <property name="javax.persistence.schema-generation.database.action" value="create"/>
    </properties>
  </persistence-unit>
</persistence>
```

## Deployment - Clean, Build, and Run the Project
1. Right click the project eHotel in the project navigation pane
2. Click **Clean and Build**
3. If there are no errors, right click the project again
4. Click **Run**
5. The project should open in your default browser

### Using eHotels
1. This first step to access the rest of the functions of eHotels is to create an account
  - There are two types of users with corresponding functions to each: **EMPLOYEE** and **CUSTOMER**
  - Click Add Account on the left navigation pane and create an account
  - If account creation was successful, the system redirects to the login page


## Built With

* [Java](https://www.java.com/en/download/manual.jsp) - The backend used to run the project
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

- **Chantal Tseung** - [GitHub](https://github.com/Chantalt108)

## Acknowledgments

- [README.md template](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
