package com.geekster.chatApplication.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.geekster.chatApplication.model.ChatHistory;

public interface ChatRepository  extends JpaRepository<ChatHistory,Integer>{
     @Query(value="Select * from tbl_chat_History where from_user_id = :senderid and status_id=1",nativeQuery=true)
     public List<ChatHistory> findbysenderid(int senderid);

     @Query(value = "select * from tbl_chat_history where ( from_user_id = :user1 and  to_user_id = :user2)" +
     "or ( from_user_id = :user2 and  to_user_id = :user1) and status_id  = 1 order by created_date",
     nativeQuery = true)
List<ChatHistory> getConversation(int user1, int user2);


}
