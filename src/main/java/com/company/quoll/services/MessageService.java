package com.company.quoll.services;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    List<Message> findMessageByRecipientAndSender(User recipient, User sender);

    List<Message> findByRecipientOrSender(User user);

    List<Message> findLastForUsers(User u1, User u2);

    void saveMessage(Message message);

}
