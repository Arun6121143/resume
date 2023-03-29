# Hospital Management

## Project Overview 
- The Hospital Management System is a Java-Spring Boot project that allows for the management of patients and doctors in a hospital 
  setting. The project uses REST APIs and MySQL database to create, read, update, and delete patient and doctor information.

## Tech Stack
- Java
- Spring Boot
- MySQL  

## Setup
- Clone the project from the GitHub repository.
- Install the necessary dependencies by running the command mvn clean install.
- Create a MySQL database named hospital_management and update the database credentials in src/main/resources/application.properties.
- Start the Spring Boot application by running the command mvn spring-boot:run.

## API Endpoints
  ### Patient Endpoints
- POST /Patient/Add/patient/Details: Create a new patient with the provided details.
- GET /Patient/getpatient: Get the details of a all patients.
- GET Patient/getpatbyid/patId/{id}: Get the details of patients with their id.
- PUT Patient/update/patient/details/patId/{id}: Update the details of a patient with the provided ID.
- DELETE Patient/delete/patient/patId/{id}: Delete a patient with the provided ID.

 ### Doctor Endpoints
- POST Hospital/Doctor/addDoc: Create a new doctor with the provided details.
- GET Hospital/DoctorGetDoctor/Details/docId/{docId}: Get the details of a doctor with the provided ID.
- PUT Hospital/DoctorUpdate/Doctor/docId/{docId}: Update the details of a doctor with the provided ID.
- DELETE Hospital/DoctorDelete/Doctor/docId/{docId}: Delete a doctor with the provided ID.
- GET Hospital/DoctorGetDoctor/Details: Get the details of all doctors.

## Testing with POSTMAN
- Open POSTMAN and import the Hospital Management System.postman_collection.json file included in the project repository.
- The collection includes all API endpoints for testing the CRUD operations on patient and doctor data.
- You can use the provided sample JSON requests to test the APIs.

## Future Scope
- Implement authentication for doctors and patients using Spring Security.
- Add more features like appointment scheduling and medical history management.
- Improve the frontend design to make it more user-friendly.

## Conclusion
- The Hospital Management System is a Java-Spring Boot project that provides an efficient way to manage patient and doctor information in a 
  hospital setting. The use of REST APIs and MySQL database make it a robust and scalable system. The ability to assign doctors to patients 
  based on their concerns and consult with their respective doctors make it a valuable tool for both doctors and patients.

 
 












