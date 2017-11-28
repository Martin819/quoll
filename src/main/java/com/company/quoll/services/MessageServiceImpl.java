package com.company.quoll.services;

import com.company.quoll.model.Message;
import com.company.quoll.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findMessageByRecipient(int recipient) {
        return messageRepository.findByRecipient(recipient);
    }

    @Override
    public List<Message> findMessageByRecipientAndSender(int recipient, int sender) {
        return messageRepository.findByRecipientAndSender(recipient, sender);
    }

    @Override
    public List<Message> findMessageByRecipientAndDateTimeAfter(int recipient, Date dateTime) {
        return messageRepository.findByRecipientAndDateTimeAfter(recipient, dateTime);
    }

    @Override
    public List<Message> findMessageByRecipientAndSenderAndDateTimeAfter(int recipient, int sender, Date dateTime) {
        return messageRepository.findByRecipientAndSenderAndDateTimeAfter(recipient, sender, dateTime);
    }

    @Override
    public Message findMessageById(long id) {
        return messageRepository.findById(id);
    }
}
