#  Chat Sphere
## Project Overview
- The Chat Application is a Java-Spring Boot project that allows for user registration and interaction in a chat room setting. The project 
  uses REST APIs and MySQL database to create, read, update, and delete user information.
## Tech Stack
- Java
- Spring Boot
- MySQL  
## Setup
- Clone the project from the GitHub repository.
- Install the necessary dependencies by running the command mvn clean install.
- Create a MySQL database named chat_application and update the database credentials in src/main/resources/application.properties.
- start the Spring Boot application by running the command mvn spring-boot:run
## API Endpoints
  ### User Endpoints
  - PostMapping -> http://localhost:8080/create-user
  - PostMapping -> http://localhost:8080/login (To Login)
  - GetMapping -> http://localhost:8080/get-users
  - DeleteMapping -> http://localhost:8080/delete-user/2
  - PutMapping ->http://localhost:8080/update-user/{userId}
  ### Status
  - PostMapping -> http://localhost:8080/create-status
  ### ChatHistory
  - PostMapping -> http://localhost:8080/send-message
  - GetMapping -> http://localhost:8080/getbysenderid/{senderid} (Get Chats By UserId)
  - GetMapping -> http://localhost:8080/getbysenderandreceiverid?user1=1&user2=4 (Get Conversation by Users UserId)
## Testing with POSTMAN
- Open POSTMAN and import the Chat Application.postman_collection.json file included in the project repository.
- The collection includes all API endpoints for testing the CRUD operations on user, chat room and message data.
- You can use the provided sample JSON requests to test the APIs.  
## Future Scope
- Implement authentication for users using Spring Security.
- Add more features like direct messaging and file sharing.
- Improve the frontend design to make it more user-friendly.
## Conclusion
- The Chat Application is a Java-Spring Boot project that provides an efficient way to create a chat room and enable user interaction in a 
  chat room setting. The use of REST APIs and MySQL database make it a robust and scalable system. The ability to add users to chat rooms 
  and post messages in the chat room make it a valuable tool for communication between users.












