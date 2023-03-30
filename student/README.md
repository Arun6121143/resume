#  Student Performance Tracker 

## Project Overview 

- The Student Marks Management System is a Java-Spring Boot project that allows an admin (professor) to allocate marks to students using 
  their unique student identification number (USN). Students can access their final marks by providing their USN. This project is 
  implemented using Maven and RESTAPI's to connect frontend and backend.

## Tech Stack
- Java
- Spring Boot
- MySQL
- HTML
- CSS

## Install
- Clone the project from the GitHub repository.
- Install the necessary dependencies by running the command mvn clean install.
- Create a MySQL database named student_marks and update the database credentials in src/main/resources/application.properties.
- Start the Spring Boot application by running the command mvn spring-boot:run.

## Security
- This project has implemented Spring Security to restrict access to certain endpoints. Only an admin (professor) can allocate marks to 
  students. Students can only access their own final marks.

## Future Scope
- Implement authentication for admins using Spring Security.
- Add more features like email notifications for mark allocation and grade calculation.
- Improve the frontend design to make it more user-friendly.  

## Conclusion
- The Student Marks Management System is a Java-Spring Boot project that provides an efficient way to manage and allocate marks to 
  students. The use of RESTAPI's and Spring Security make it a robust and secure system.
