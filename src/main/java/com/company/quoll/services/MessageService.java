package com.company.quoll.services;

import com.company.quoll.model.Message;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface MessageService {

    List<Message> findMessageByRecipient(int recipient);
    List<Message> findMessageByRecipientAndSender(int recipient, int sender);
    List<Message> findMessageByRecipientAndDateTimeAfter(int recipient, Date dateTime);
    List<Message> findMessageByRecipientAndSenderAndDateTimeAfter(int recipient, int sender, Date dateTime);
    Message findMessageById(long id);

}
