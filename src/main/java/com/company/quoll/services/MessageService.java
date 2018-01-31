package com.company.quoll.services;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface MessageService {

    List<Message> findMessageByRecipient(User recipient);
    List<Message> findMessageBySender(User sender);
    List<Message> findMessageByRecipientOrderByMessageReadAsc(User recipient);
    List<Message> findMessageByRecipientAndSender(User recipient, User sender);
    List<Message> findMessageByRecipientAndSenderOrderByDateTimeDesc (User recipient, User sender);
    List<Message> findMessageByRecipientAndDateTimeAfter(User recipient, Date dateTime);
    List<Message> findMessageByRecipientAndSenderAndDateTimeAfter(User recipient, User sender, Date dateTime);
    List<Message> findMessageDistinctByRecipientOrderByMessageReadAsc(User recipient);
    List<Message> findMessageByRecipientAndMessageRead(User recipient, boolean messageRead);
    Message findMessageById(long id);
    void saveMessage(Message message);
    List<Message> findLastMessages(User recipient);
    List<Message> findByRecipientOrSender(User user);
    List<Message> findLastFor(User user);
    List<Message> findLastForUsers(User u1, User u2);

}
