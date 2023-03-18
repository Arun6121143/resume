package com.geekster.chatApplication.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geekster.chatApplication.dao.StatusRepository;
import com.geekster.chatApplication.dao.UserRepository;
import com.geekster.chatApplication.model.ChatHistory;
import com.geekster.chatApplication.model.Status;
import com.geekster.chatApplication.model.Users;

import com.geekster.chatApplication.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ChatHistoryController {

    @Autowired
    ChatService chatHistoryService;

    @Autowired
    UserRepository repository;

    @Autowired
    StatusRepository repo;

    @PostMapping("/sendmessage")
    public ResponseEntity<String> saveMessage(@RequestBody String requestData) {
        JSONObject requestObj = new JSONObject(requestData);
        JSONObject errorList = validateRequest(requestObj);
        if (errorList.isEmpty()) {
            ChatHistory chat = setChatHistory(requestObj);
            if (chat.getStatusId() == null) {
                return new ResponseEntity<>("The user is Inactive", HttpStatus.BAD_REQUEST);
            }
            int chatId = chatHistoryService.saveMessage(chat);
            return new ResponseEntity<>("message sent- " + chatId, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    private ChatHistory setChatHistory(JSONObject requestObj) {
        ChatHistory chat = new ChatHistory();

        String message = requestObj.getString("message");
        int senderId = requestObj.getInt("sender");
        int receiverId = requestObj.getInt("receiver");
        Users senderUserObj = repository.findById(senderId).get();

        Status statusId1 = senderUserObj.getStatusId();
        System.out.println(statusId1.getStatusId());
        if (statusId1.getStatusId() == 2) {
            return chat;
        }
        Users receiverUserObj = repository.findById(receiverId).get();

        Status statusId2 = receiverUserObj.getStatusId();
        if (statusId2.getStatusId() == 2) {
            return chat;
        }

        chat.setTo(receiverUserObj);
        chat.setFrom(senderUserObj);
        chat.setMessage(message);
        Status status = repo.findById(1).get();
        chat.setStatusId(status);

        return chat;

    }

    private JSONObject validateRequest(JSONObject requestObj) {
        JSONObject errorObj = new JSONObject();
        if (!requestObj.has("sender")) {
            errorObj.put("sender", "Missing parameter");
        }
        if (!requestObj.has("receiver")) {
            errorObj.put("receiver", "Missing parameter");
        }
        if (requestObj.has("message")) {
            String message = requestObj.getString("message");
            if (message.isBlank() || message.isEmpty()) {
                errorObj.put("message", "message body can't be empty");
            }
        } else {
            errorObj.put("message", "Missing parameter");
        }
        return errorObj;
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteByid(@PathVariable int id) {
        chatHistoryService.deleteid(id);
        return "deleted succesfully";
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<String> getbyid(@PathVariable int id) {
        JSONObject o = chatHistoryService.getid(id);
        return new ResponseEntity<String>(o.toString(), HttpStatus.CREATED);

    }

    @GetMapping("/getbysenderid/{senderid}")
    public ResponseEntity<String> getbysenderid(@PathVariable int senderid) {
        JSONObject obj = chatHistoryService.getbysender(senderid);
        return new ResponseEntity<String>(obj.toString(), HttpStatus.CREATED);

    }

    @GetMapping("/getbysenderandreceiverid")
    public ResponseEntity<String> getbysenderreceive(@RequestParam int user1 , @RequestParam int user2){
        JSONObject obj = chatHistoryService.getbysenderreceiver(user1,user2);
        return  new ResponseEntity<String>(obj.toString(), HttpStatus.CREATED);
    }

    

}
