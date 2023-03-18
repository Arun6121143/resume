package com.geekster.chatApplication.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.chatApplication.dao.ChatRepository;
import com.geekster.chatApplication.model.ChatHistory;

@Service
public class ChatService {
  @Autowired
  ChatRepository chatrepo;

  public int saveMessage(ChatHistory chat) {
    ChatHistory c = chatrepo.save(chat);
    return c.getChatId();
  }

  public void deleteid(int id) {
    chatrepo.deleteById(id);
  }

  public JSONObject getid(int id) {
    JSONObject json = getmessages(id);
    return json;

  }

  public JSONObject getmessages(int id) {
    ChatHistory chat = chatrepo.findById(id).get();
    JSONObject obj = new JSONObject();
    obj.put("senderid", chat.getFrom().getUserId());
    obj.put("sendername", chat.getFrom().getFirstName());
    obj.put("receiverid", chat.getTo().getUserId());
    obj.put("receivername", chat.getTo().getFirstName());
    obj.put("message sent", chat.getMessage());
    return obj;

  }

  public JSONObject getbysender(int senderid) {
    JSONObject json = getchats(senderid);
    return json;
  }

  public JSONObject getchats(int senderid) {
    List<ChatHistory> chats = chatrepo.findbysenderid(senderid);
    JSONObject response = new JSONObject();
    response.put("senderid", chats.get(0).getFrom().getUserId());
    response.put("sendername", chats.get(0).getFrom().getFirstName());
    
    JSONArray arr = new JSONArray();
    for (ChatHistory c : chats) {
      JSONObject reciever = new JSONObject();

      reciever.put("receiverid", c.getTo().getUserId());
      reciever.put("receivername", c.getTo().getFirstName());
      reciever.put("message", c.getMessage());
      arr.put(reciever);
    }
    response.put("receivers", arr);
    return response;

  }

  public JSONObject getbysenderreceiver(int user1, int user2) {
      JSONObject json = getConversation(user1, user2);
      return json;
  }

  private JSONObject getConversation(int user1, int user2) {
    List<ChatHistory> chats = chatrepo.getConversation(user1, user2);
    JSONObject response = new JSONObject();
    response.put("senderid",chats.get(0).getFrom().getUserId());
    response.put("sendername",chats.get(0).getFrom().getFirstName());
    JSONArray arr = new JSONArray();
    for(ChatHistory c:chats){
      JSONObject receiver = new JSONObject();
      receiver.put("receivername",c.getTo().getFirstName());
      receiver.put("message",c.getMessage());
      receiver.put("Timestamp",c.getCreatedDate());
      arr.put(receiver);
      
    }
    response.put("receiver",arr);
    return response;

  }
}