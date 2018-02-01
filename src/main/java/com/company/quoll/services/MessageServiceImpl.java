package com.company.quoll.services;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
import com.company.quoll.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findMessageByRecipientAndSender(User recipient, User sender) {
        return messageRepository.findByRecipientAndSender(recipient, sender);
    }

    @Override
    public List<Message> findByRecipientOrSender(User user) {
        return messageRepository.findByRecipientOrSender(user);
    }

    @Override
    public List<Message> findLastForUsers(User u1, User u2) {
        return messageRepository.findLastForUsers(u1, u2);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

}
