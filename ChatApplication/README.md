# Chat Application
## FrameWork and Language Used
- SpringBoot
- Java
## DataBase Used
- MySql
## Controller
- UserController
- StatusController
- ChatHistoryController
## Service
- UserService
- StatusService
- ChatHistoryService
## Model
- User
- Status
- ChatHistory
## Repository
- UserRepository
- StatusRepository
- ChatRepository
## Project Summary
- Here in this project we are performing CRUD operations and making possible to have conversation between two users
  personally and saving the Data in the DataBase and as follows :
  ### User
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












