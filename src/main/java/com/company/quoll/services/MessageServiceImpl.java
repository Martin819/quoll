package com.company.quoll.services;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
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
    public List<Message> findMessageByRecipient(User recipient) {
        return messageRepository.findByRecipient(recipient);
    }

    public List<Message> findMessageByRecipientOrderByMessageReadAsc(User recipient) {
        return messageRepository.findByRecipientOrderByMessageReadAsc(recipient);
    }

    @Override
    public List<Message> findMessageByRecipientAndSender(User recipient, User sender) {
        return messageRepository.findByRecipientAndSender(recipient, sender);
    }

    @Override
    public List<Message> findMessageByRecipientAndSenderOrderByDateTimeDesc(User recipient, User sender) {
        return messageRepository.findByRecipientAndSenderOrderByDateTimeDesc(recipient, sender);
    }

    @Override
    public List<Message> findMessageByRecipientAndDateTimeAfter(User recipient, Date dateTime) {
        return messageRepository.findByRecipientAndDateTimeAfter(recipient, dateTime);
    }

    @Override
    public List<Message> findMessageByRecipientAndSenderAndDateTimeAfter(User recipient, User sender, Date dateTime) {
        return messageRepository.findByRecipientAndSenderAndDateTimeAfter(recipient, sender, dateTime);
    }

    @Override
    public List<Message> findMessageDistinctByRecipientOrderByMessageReadAsc(User recipient) {
        return messageRepository.findDistinctByRecipientOrderByMessageReadAsc(recipient);
    }

    @Override
    public List<Message> findMessageByRecipientAndMessageRead(User recipient, boolean messageRead) {
        return messageRepository.findByRecipientAndMessageRead(recipient, messageRead);
    }


    @Override
    public List<Message> findLastMessages(User recipient) {
        return messageRepository.findLastForRecipient(recipient);
    }

    @Override
    public Message findMessageById(long id) {
        return messageRepository.findById(id);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
