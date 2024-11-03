## Simple Client Management API


## Description

The Client Management API provides a simple interface to create, retrieve, update, and delete client records. Each client includes details such as name, age, address, and any associated medical conditions. This API is ideal for applications needing a centralized way to handle client information.

## Table of Contents

- [Simple Client Management API](#simple-client-management-api)
- [Description](#description)
- [Table of Contents](#table-of-contents)
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [Database Setup](#database-setup)
  - [Restoring the Database](#restoring-the-database)
- [Entity Schema (Client)](#entity-schema-client)
- [API Documentation](#api-documentation)
- [Testing](#testing)

## Features

- Create, read, update, and delete (CRUD) client profiles.
- Handle client information such as name, age, address, and medical condition.
- RESTful API with JSON support.

## Technologies

- Java
- Spring Boot
- Spring MVC
- JUnit & Mockito (for testing)
- H2 Database (in-memory)
- Maven
- MYSQL

## Setup

1. **Clone the repository**:

   git clone https://github.com/yourusername/simple-client-management.git


## Database Setup

To restore the database for this project, use the provided dump file located in the `database/` folder.

### Restoring the Database

1. Ensure MySQL is installed and running.
2. Use the following command to restore the database from the dump file:
    ### File Location
- **Dump File**: `database/### File Location
- **Dump File**: `My database/clientbackup.sql`

   ```bash
    mysql -u [username] -p < database/clientbackup.sql
    ```

Replace `[username]` with your MySQL username.

3. **Build the project**;
     mvn clean install

4. Run the application:
   mvn spring-boot:run

  

The application will start on http://localhost:8080


## Entity Schema (Client)

The Client entity represents the client table in the database.
<img width="806" alt="Screenshot 2024-11-02 at 17 39 18" src="https://github.com/user-attachments/assets/922abe35-2f0f-4743-8042-4016739d8c04">


## API Documentation

**API Endpoints**

1. **Get All Clients**
URL: /api/clients
Method: GET
Response: List of all clients.

2. **Get a Client by ID**
URL: /api/clients/{id}
Method: GET
Parameters:
id: Client ID
Response: Details of the specified client.

3. **Create a Client**
URL: /api/clients
Method: POST
Request Body:
<img width="704" alt="Screenshot 2024-11-02 at 15 19 59" src="https://github.com/user-attachments/assets/79a93acc-89e8-49ab-96bc-8bc271dcc9b6">

Response: Confirmation message upon successful creation.

4. **Update a Client**
URL: /api/clients/{id}
Method: PUT
Parameters:
id: Client ID
Request Body:
<img width="516" alt="Screenshot 2024-11-02 at 17 05 12" src="https://github.com/user-attachments/assets/6d2143b9-0306-4296-b816-2b9f3c958741">

Response: Confirmation message upon successful update.

5. **Delete a Client**
URL: /api/clients/{id}
Method: DELETE
Parameters:
id: Client ID
Response: Confirmation message upon successful deletion.

## Testing
To run tests, use the following command:
mvn test

Contributing
If you’d like to contribute to this project, please fork the repository and submit a pull request. We welcome improvements, bug fixes, and additional features.



