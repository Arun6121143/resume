package com.geekster.chatApplication.service;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.geekster.chatApplication.dao.StatusRepository;
import com.geekster.chatApplication.dao.UserRepository;
import com.geekster.chatApplication.model.Status;
import com.geekster.chatApplication.model.Users;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
   
    @Autowired
    StatusRepository repository;

    public JSONArray getUsers(String userId) {
        JSONArray response = new JSONArray();
        if (null != userId) {
            List<Users> usersList = repo.getUserByUserId(Integer.valueOf(userId));
            for (Users user : usersList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        } else {
            List<Users> usersList = repo.getAllUsers();
            for (Users user : usersList) {
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }
        return response;
    }

    private JSONObject createResponse(Users user) {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("userId", user.getUserId());
        jsonObj.put("username", user.getUsername());
        jsonObj.put("firstName", user.getFirstName());
        jsonObj.put("lastName", user.getLastName());
        jsonObj.put("age", user.getAge());
        jsonObj.put("email", user.getEmail());
        jsonObj.put("phoneNumber", user.getPhoneNumber());
        jsonObj.put("gender", user.getGender());
        jsonObj.put("createdDate", user.getCreatedDate());

        return jsonObj;
    }

    public JSONObject login(String username, String password, String email) {
        JSONObject response = new JSONObject();
        List<Users> users = repo.findByUsername(username);
        if (users.isEmpty()) {
            response.put("errormessage", "username not valid");

        } else {
            Users userobj = users.get(0);
            if (password.equals(userobj.getPassword())) {

                if (email.equals(userobj.getEmail())) {

                    response = createResponse(userobj);
                } else {
                    response.put("errormessage", "email is not valid");
                }

            }

            else {
                response.put("errormessage", "password is not valid");

            }

        }
        return response;

    }

    public JSONObject updateUser(Users newUser, String userId) {
        List<Users> usersList = repo.getUserByUserId(Integer.valueOf(userId));
        JSONObject obj = new JSONObject();
        if (!usersList.isEmpty()) {
            Users oldUser = usersList.get(0);
            newUser.setUserId(oldUser.getUserId());
            newUser.setCreatedDate(oldUser.getCreatedDate());
            newUser.setPassword(oldUser.getPassword());
            Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
            newUser.setUpdatedDate(updatedTime);
            repo.save(newUser);
        } else {
            obj.put("errorMessage", "User doesn't exist");
        }
        return obj;
    }

    public String deleteByid(int id) {
        
         Users u = repo.findById(id).get();
         Status  statusid = u.getStatusId();

         if(statusid.getStatusId()==1){
            Status status = repository.findById(2).get();
            u.setStatusId(status);
            repo.save(u);
      
         }else{
            return "already deleted";
         }
         return "deleted suceesfully";
        
        
  

    }
}
